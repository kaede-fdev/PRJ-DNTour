package service.impl;

import context.DatabaseContext;
import service.interfaces.IAuthService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import model.User;
import utils.BScript;

/**
 *
 * @author VJames
 */
public class AuthSerivce extends DatabaseContext implements IAuthService {

    private String createNewUserQuery = "INSERT INTO Users (Fullname, Email, Password, CreateAt, Role, Verify) VALUES (?, ?, ?, ?, ?, ?)";
    private String findUserByEmailQuery = "SELECT * FROM Users WHERE Email = ?";
    private String updateUserVerifyByEmailQuery = "UPDATE Users SET Verify = ? WHERE Email = ?";

    @Override

    public void createNewUser(String fullname, String email, String password) {
        String hashedPassword = BScript.hashPassword(password);
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(createNewUserQuery)) {
            statement.setString(1, fullname);
            statement.setString(2, email);
            statement.setString(3, hashedPassword);
            statement.setTimestamp(4, new java.sql.Timestamp(new Date().getTime()));
            statement.setString(5, "USER");
            statement.setBoolean(6, false);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public User findUserByEmail(String email) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(findUserByEmailQuery)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString("Id"));
                user.setFullname(resultSet.getString("Fullname"));
                user.setEmail(resultSet.getString("Email"));
                user.setPassword(resultSet.getString("Password"));
                user.setCreateAt(resultSet.getTimestamp("CreateAt"));
                user.setPhone(resultSet.getString("Phone"));
                user.setRole(resultSet.getString("Role"));
                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUserVerifyByEmail(boolean verify, String email) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(updateUserVerifyByEmailQuery)) {
            statement.setBoolean(1, verify);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
