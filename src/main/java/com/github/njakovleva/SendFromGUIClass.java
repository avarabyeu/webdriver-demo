package com.github.njakovleva;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by jakovleva on 1/20/2015.
 */
public class SendFromGUIClass {


    private static UserData userData = new UserData();

    public void sendEmail() {


        WebDriver driver = new FirefoxDriver();
        LoginPage loginPage = new LoginPage(driver, userData.getSenderMailUrl());

        //sender actions
        InboxPage inboxPage = loginPage.loginAs(userData.getSenderLogin(), userData.getSenderPassword());
        NewMailPage newMailPage = inboxPage.openComposePage();
        inboxPage = newMailPage.sendMail(userData.getReceiver(), userData.getSubject(), userData.getContent());
    }

    public InboxPage openReceiverEmail() {
        WebDriver driver = new FirefoxDriver();
        LoginPage loginPage = new LoginPage(driver, userData.getReceiverMailUrl());

        //receiver actions
        InboxPage inboxPage = loginPage.loginAs(userData.getReceiverLogin(), userData.getReceiverPassword());
        return inboxPage;
    }

    public OutboxPage openSenderOutbox() {

        WebDriver driver = new FirefoxDriver();
        LoginPage loginPage = new LoginPage(driver, userData.getSenderMailUrl());

        //sender actions
        InboxPage inboxPage = loginPage.loginAs(userData.getSenderLogin(), userData.getSenderPassword());
        NewMailPage newMailPage = inboxPage.openComposePage();
        inboxPage = newMailPage.sendMail(userData.getReceiver(), userData.getSubject(), userData.getContent());

        //open outbox
        OutboxPage outboxPage = inboxPage.openOutboxPage();

        return outboxPage;
    }


}
