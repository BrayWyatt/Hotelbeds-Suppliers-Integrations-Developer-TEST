package test;

import com.hotelbeds.supplierintegrations.hackertest.detector.LoginUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginUserTest
{
    @Test
    void login()
    {
        LoginUser loginUser = new LoginUser();
        try
        {
            loginUser.login("111.111.111.111", "Jose.Martinez");

            loginUser.login("222.222.222.222", "Pedro.Perez");

            loginUser.login("333.333.333.333", "Marcos.Ruiz");

            loginUser.login("444.444.444.444", "Ana.Gonzalez");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}