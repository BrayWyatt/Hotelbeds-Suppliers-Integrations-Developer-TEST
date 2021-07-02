package com.hotelbeds.supplierintegrations.hackertest.detector;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;



public class LoginUser
{
    //Variables
    int login;
    int valorRandom;

    public void login (String ip, String username) throws  Exception
    {
        Random random = new Random();
        valorRandom = random.nextInt(2);

        LogStatus status = valorRandom == 0 ? LogStatus.SIGNIN_FAILURE : LogStatus.SIGNIN_SUCCESS;

        LogTools logTools = new LogTools();
        logTools.SendToLog(ip, new Date(), status, username);
    }
}