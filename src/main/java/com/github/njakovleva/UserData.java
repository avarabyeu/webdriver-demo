package com.github.njakovleva;


/**
 * Created by jakovleva on 1/27/2015.
 */

import java.io.*;
import java.util.Properties;

public class UserData {

    private String urlGmail;
    private String urlYandex;
    private String loginGmail;
    private String passwordGmail;
    private String loginYandex;
    private String passwordYandex;
    private String mailYandex;
    private String mailGmail;
    private String subject;
    private String content;


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

            urlGmail = userData.getProperty("url_gmail");
            urlYandex = userData.getProperty("url_yandex");
            loginGmail = userData.getProperty("login_gmail");
            passwordGmail = userData.getProperty("password_gmail");
            loginYandex = userData.getProperty("login_yandex");
            passwordYandex = userData.getProperty("password_yandex");
            mailYandex = userData.getProperty("mail_yandex");
            mailGmail = userData.getProperty("mail_gmail");
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

    public String getUrlGmail() {
        return urlGmail;
    }

    public String getUrlYandex() {
        return urlYandex;
    }

    public String getLoginGmail() {
        return loginGmail;
    }

    public String getPasswordGmail() {
        return passwordGmail;
    }

    public String getLoginYandex() {
        return loginYandex;
    }

    public String getPasswordYandex() {
        return passwordYandex;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getMailYandex() {
        return mailYandex;
    }

    public String getMailGmail() {
        return mailGmail;
    }
}
