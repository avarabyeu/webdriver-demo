package com.github.njakovleva;


/**
 * Created by jakovleva on 1/27/2015.
 */

import java.io.*;
import java.util.Properties;

public class UserData {

    private String senderMailUrl;
    private String receiverMailUrl;
    private String senderLogin;
    private String senderPassword;
    private String receiverLogin;
    private String receiverPassword;
    private String receiver;
    private String subject;
    private String content;

//    public void loadUserData() {
//
//        Properties userData = new Properties();
//        OutputStream output = null;
//
//        try {
//
//            output = new FileOutputStream("config.properties");
//
//            // set the properties value
//            userData.setProperty("sender_mail", "www.gmail.com");
//
//            // save properties to project root folder
//            userData.store(output, null);
//
//        } catch (IOException io) {
//            io.printStackTrace();
//        } finally {
//            if (output != null) {
//                try {
//                    output.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//
//    }


    public UserData() {
        loadUserData();
    }

    public void loadUserData() {
        Properties userData = new Properties();
        InputStream input = null;

        try {

            input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");

            // load a properties file
            userData.load(input);

            senderMailUrl = userData.getProperty("sender_mail");
            receiverMailUrl = userData.getProperty("receiver_mail");
            senderLogin = userData.getProperty("sender_login");
            senderPassword = userData.getProperty("sender_password");
            receiverLogin = userData.getProperty("receiver_login");
            receiverPassword = userData.getProperty("receiver_password");
            receiver = userData.getProperty("receiver");
            subject = userData.getProperty("subject");
            content = userData.getProperty("content");

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


    public String getSenderMailUrl() {
        return senderMailUrl;
    }

    public String getReceiverMailUrl() {
        return receiverMailUrl;
    }

    public String getSenderLogin() {
        return senderLogin;
    }

    public String getSenderPassword() {
        return senderPassword;
    }

    public String getReceiverLogin() {
        return receiverLogin;
    }

    public String getReceiverPassword() {
        return receiverPassword;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
}
