package services.impl;

import models.login.Login;
import repositories.LoginRepository;

public class LoginService {
    static LoginRepository loginReponsitory = new LoginRepository();
    public static boolean checkLoginManager(Login login) {
        return loginReponsitory.CheckLoginManeger(login);
    }

    public static boolean checkLoginCustomer(Login login) {
        return loginReponsitory.checkLoginCustomer(login);
    }
}
