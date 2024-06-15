package service.interfaces;

import context.DatabaseContext;
import service.impl.IAuthService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import utils.BScript;

/**
 *
 * @author VJames
 */
public class AuthSerivce extends DatabaseContext implements IAuthService {

    private String createNewUserQuery = "INSERT INTO Users (Fullname, Email, Password, CreateAt) VALUES (?, ?, ?, ?)";

    @Override
    public void createNewUser(String fullname, String email, String password) {
        String hashedPassword = BScript.hashPassword(password);
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(createNewUserQuery)) {
            statement.setString(1, fullname);
            statement.setString(2, email);
            statement.setString(3, hashedPassword);
            statement.setTimestamp(4, new java.sql.Timestamp(new Date().getTime()));
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
