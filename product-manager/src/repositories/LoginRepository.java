package repositories;

import models.login.Login;

public class LoginRepository {
    static Login[] loginManagers = new Login[1];

    static {
        loginManagers[0] = new Login("truong", "123");
    }


    static Login[] loginCustomers = new Login[1];
    static {
        loginCustomers[0] = new Login("hieu", "456");
    }

    public boolean CheckLoginManeger(Login login) {
        for (Login lg: loginManagers) {
            if ((login.getUserName().equals(lg.getUserName())) && (login.getPassWord().equals(lg.getPassWord()))) {
                return true;
            }
        }
        return false;
    }

    public boolean checkLoginCustomer(Login login) {
        for (Login lg: loginCustomers) {
            if ((login.getUserName().equals(lg.getUserName())) && (login.getPassWord().equals(lg.getPassWord()))) {
                return true;
            }
        }
        return false;
    }
}
