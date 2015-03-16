package com.github.njakovleva;


/**
 * Created by jakovleva on 1/27/2015.
 */

import java.io.*;
import java.util.Properties;

public class UserData {

    public void loadUserData() {

        Properties userData = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream("config.properties");

            // set the properties value
            userData.setProperty("sender_mail", "www.gmail.com");

            // save properties to project root folder
            userData.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public void getUserData(String SenderMailUrl, String ReceiverMailUrl, String SenderLogin, String SenderPassword,
                            String ReceiverLogin, String ReceiverPassword, String Receiver, String Subject, String Content) {
        Properties userData = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            userData.load(input);

            SenderMailUrl = userData.getProperty("sender_mail");
            ReceiverMailUrl = userData.getProperty("receiver_mail");
            SenderLogin = userData.getProperty("sender_login");
            SenderPassword = userData.getProperty("sender_password");
            ReceiverLogin = userData.getProperty("receiver_login");
            ReceiverPassword = userData.getProperty("receiver_password");
            Receiver = userData.getProperty("receiver");
            Subject = userData.getProperty("subject");
            Content = userData.getProperty("content");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
