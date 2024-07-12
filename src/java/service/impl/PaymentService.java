package service.impl;

import service.interfaces.IPaymentService;
import context.DatabaseContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Payment;

/**
 *
 * @author VJames
 */
public class PaymentService extends DatabaseContext implements IPaymentService {

    private String createNewPaymentQuery = "INSERT INTO Payment (Id, TourId, UserId, Fullname, Phone, Email, Address, Amount, PaymentCode, IsPaid, CreateAt, UpdateAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), GETDATE())";
    private String findPaymentByIdQuery = "SELECT * FROM Payment WHERE Id = ?";
    private String updatePaymentStatusQuery = "UPDATE Payment SET IsPaid = ?, UpdateAt = GETDATE() WHERE Id = ?";
    private String updatePaymentCodeQuery = "UPDATE Payment SET PaymentCode = ?, UpdateAt = GETDATE() WHERE Id = ?";

    @Override
    public void createNewPaymentInfo(String id, String amount, String fullname, String phone, String email, String address, String userId, int tourId) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(createNewPaymentQuery)) {

            statement.setString(1, id);
            statement.setInt(2, tourId);

            if (userId != null && !userId.isEmpty()) {
                statement.setString(3, userId);
            } else {
                statement.setNull(3, java.sql.Types.OTHER);
            }

            statement.setString(4, fullname);
            statement.setString(5, phone);
            statement.setString(6, email);
            statement.setString(7, address);
            statement.setInt(8, Integer.parseInt(amount));
            statement.setString(9, null);
            statement.setBoolean(10, false);

            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Payment findPaymentById(String id) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(findPaymentByIdQuery)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Payment payment = new Payment();
                payment.setId(resultSet.getInt("Id"));
                payment.setTourId(resultSet.getInt("TourId"));
                payment.setUserId(resultSet.getString("UserId"));
                payment.setFullname(resultSet.getString("Fullname"));
                payment.setPhone(resultSet.getString("Phone"));
                payment.setEmail(resultSet.getString("Email"));
                payment.setAddress(resultSet.getString("Address"));
                payment.setAmount(resultSet.getInt("Amount"));
                payment.setPaymentCode(resultSet.getString("PaymentCode"));
                payment.setIsPaid(resultSet.getBoolean("IsPaid"));
                payment.setCreateAt(resultSet.getTimestamp("CreateAt"));
                payment.setUpdateAt(resultSet.getTimestamp("UpdateAt"));
                return payment;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void updatePaymentStatus(String id, boolean isPaid) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(updatePaymentStatusQuery)) {
            statement.setBoolean(1, isPaid);
            statement.setString(2, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updatePaymentCode(String id, String payCode) {

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(updatePaymentCodeQuery)) {
            statement.setString(1, payCode);
            statement.setString(2, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
