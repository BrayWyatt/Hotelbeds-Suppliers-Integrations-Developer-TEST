package com.hotelbeds.supplierintegrations.hackertest.detector;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogTools
{
    HackerDetection hackerDetection = new HackerDetection();
    public static File logFile;
    FileWriter writer;

    public LogTools()
    {
        logFile = new File(System.getProperty("user.dir") + "\\LogFile.txt");
    }

    public void SendToLog (String ip, Date date, LogStatus action, String username) throws Exception
    {
        String logLine = ip + "," + date.getTime() + "," + action + "," + username;
        logFile = new File(System.getProperty("user.dir") + "\\LogFile.txt");
        String hackerIP = hackerDetection.parseLine(logLine);
        if (hackerIP != null)
        {
            throw new Exception("Seems to be an attempt to hack the system from the IP:" + hackerIP);
        }

        writer = new FileWriter(System.getProperty("user.dir") + "\\LogFile.txt", true);
        writer.write(ip + "," + date.getTime() + "," + action + "," + username + "\n");
        writer.close();
    }
}