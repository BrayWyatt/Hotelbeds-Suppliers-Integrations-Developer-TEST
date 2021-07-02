package com.hotelbeds.supplierintegrations.hackertest.detector;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class HackerDetection implements HackerDetector {

    @Override
    public String parseLine(String line) { //"80.238.9.179,133612947,SIGNIN_SUCCESS,Will.Smith"
        Scanner myReader = null;
        try {
            myReader = new Scanner(LogTools.logFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int aparicionesFallidas = 0;
        while (myReader.hasNextLine())
        {
            String logLine = myReader.nextLine();
            if (!logLine.equals(""))
            {
                Calendar cal = Calendar.getInstance();                          // creates calendar
                cal.setTime(new Date(Long.valueOf(logLine.split(",")[1])));               // sets calendar time/date
                cal.add(Calendar.MINUTE, 5);                                // adds one hour
                cal.getTime();                                                      // returns new date object plus one hour

                if (cal.getTime().compareTo(new Date()) > 0)
                {
                    if ((logLine.split(",")[0]).equals(line.split(",")[0])
                            && (logLine.split(",")[2]).equals(LogStatus.SIGNIN_FAILURE.toString()))
                    {
                        aparicionesFallidas++;
                    }
                }
            }
        }

        myReader.close();

        if(aparicionesFallidas >= 5)
        {
            return line.split(",")[0];
        }

        return null;
    }
}