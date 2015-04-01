package com.github.njakovleva;


/**
 * Created by jakovleva on 1/27/2015.
 */

import java.io.*;
import java.util.Properties;

public class UserData {

    private String urlGmail;
    private String urlYandex;
    private String urlInbox;
    private String urlMail;
    private String loginGmail;
    private String passwordGmail;
    private String loginYandex;
    private String passwordYandex;
    private String loginInbox;
    private String passwordInbox;
    private String loginMail;
    private String passwordMail;
    private String mailYandex;
    private String mailGmail;
    private String mailInbox;
    private String mailMail;
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
            urlInbox = userData.getProperty("url_inbox");
            urlMail = userData.getProperty("url_mail");
            loginGmail = userData.getProperty("login_gmail");
            passwordGmail = userData.getProperty("password_gmail");
            loginYandex = userData.getProperty("login_yandex");
            passwordYandex = userData.getProperty("password_yandex");
            loginInbox = userData.getProperty("login_inbox");
            passwordInbox = userData.getProperty("password_inbox");
            loginMail = userData.getProperty("login_mail");
            passwordMail = userData.getProperty("password_mail");
            mailYandex = userData.getProperty("mail_yandex");
            mailGmail = userData.getProperty("mail_gmail");
            mailInbox = userData.getProperty("mail_inbox");
            mailMail = userData.getProperty("mail_mail");
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

    public String getUrlInbox() {
        return urlInbox;
    }

    public String getUrlMail() { return urlMail; }

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

    public String getLoginInbox() {
        return loginInbox;
    }

    public String getPasswordInbox() {
        return passwordInbox;
    }

    public String getLoginMail(){
        return loginMail;
    }

    public String getPasswordMail(){
        return passwordMail;
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

    public String getMailInbox() {
        return mailInbox;
    }

    public String getMailMail(){
        return mailMail;
    }
}
