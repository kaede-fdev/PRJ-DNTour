package service.interfaces;

import model.User;

/**
 *
 * @author VJames
 */
public interface IAuthService {

    public void createNewUser(String fullname, String emai, String password);

    public User findUserByEmail(String email);

    public void updateUserVerifyByEmail(boolean verify, String email);
}
