package com.github.njakovleva;

import Main.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 * Created by jakovleva on 1/20/2015.
 */
public class SendFromGUIClass {
    public static String senderMailUrl;
    public static String receiverMailUrl;
    public static String senderLogin;
    public static String senderPassword;
    public static String receiverLogin;
    public static String receiverPassword;
    public static String receiver;
    public static String subject;
    public static String content;


    public SendFromGUIClass() {
    }

    public UserData userData = new UserData();

    public void sendEmail() {
        getUserData();

        WebDriver driver = new PhantomJSDriver();
        LoginPage loginPage = new LoginPage(driver, senderMailUrl);

        //sender actions
        InboxPage inboxPage = loginPage.loginAs(senderLogin, senderPassword);
        NewMailPage newMailPage = inboxPage.openComposePage();
        inboxPage = newMailPage.sendMail(receiver, subject, content);
    }

    public InboxPage openReceiverEmail() {
        WebDriver driver = new PhantomJSDriver();
        LoginPage loginPage = new LoginPage(driver, receiverMailUrl);

        //receiver actions
        InboxPage inboxPage = loginPage.loginAs(receiverLogin, receiverPassword);
        return inboxPage;
    }

    public OutboxPage openSenderOutbox() {
        getUserData();

        WebDriver driver = new PhantomJSDriver();
        LoginPage loginPage = new LoginPage(driver, senderMailUrl);

        //sender actions
        InboxPage inboxPage = loginPage.loginAs(senderLogin, senderPassword);
        NewMailPage newMailPage = inboxPage.openComposePage();
        inboxPage = newMailPage.sendMail(receiver, subject, content);

        //open outbox
        OutboxPage outboxPage = inboxPage.openOutboxPage();

        return outboxPage;
    }

    private void getUserData() {
        userData.getUserData(senderMailUrl, receiverMailUrl, senderLogin, senderPassword,
                receiverLogin, receiverPassword, receiver, subject, content);
    }

}
