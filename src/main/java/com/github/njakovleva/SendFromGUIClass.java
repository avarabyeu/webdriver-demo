package com.github.njakovleva;

import org.openqa.selenium.WebDriver;

/**
 * Created by jakovleva on 1/20/2015.
 */
public class SendFromGUIClass {


    private static UserData userData = new UserData();

    public void sendEmail(WebDriver driver) {
        //LoginPage loginPage = new LoginPage(driver, userData.getUrlYandex());
        //LoginPage loginPage = new LoginPage(driver, userData.getUrlInbox());
        //LoginPage loginPage = new LoginPage(driver, userData.getUrlGmail());
        LoginPage loginPage = new LoginPage(driver, userData.getUrlMail());

        //sender actions

        //InboxPage inboxPage = loginPage.loginAs(userData.getLoginYandex(), userData.getPasswordYandex());
        //NewMailPage newMailPage = inboxPage.openComposePage();

        //InboxPage inboxPage = loginPage.loginAs(userData.getLoginInbox(), userData.getPasswordInbox());
        //NewMailPage newMailPage = inboxPage.openComposePage();

        //InboxPage inboxPage = loginPage.loginAs(userData.getLoginGmail(), userData.getPasswordGmail());
        //NewMailPage newMailPage = inboxPage.openComposePage();

        InboxPage inboxPage = loginPage.loginAs(userData.getLoginMail(), userData.getPasswordMail());
        NewMailPage newMailPage = inboxPage.openComposePage();

        inboxPage = newMailPage.sendMail(userData.getMailGmail(), userData.getSubject(), userData.getContent());
        //inboxPage = newMailPage.sendMail(userData.getMailMail(), userData.getSubject(), userData.getContent());
    }

    public InboxPage openReceiverEmail(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver, userData.getUrlGmail());

        //receiver actions

        //InboxPage inboxPage = loginPage.loginAs(userData.getLoginGmail(), userData.getPasswordGmail());
        InboxPage inboxPage = loginPage.loginAs(userData.getLoginMail(), userData.getPasswordMail());
        return inboxPage;
    }

    public OutboxPage openSenderOutbox(WebDriver driver) {

        //LoginPage loginPage = new LoginPage(driver, userData.getUrlYandex());
        //LoginPage loginPage = new LoginPage(driver, userData.getUrlInbox());
        LoginPage loginPage = new LoginPage(driver, userData.getUrlGmail());
        //LoginPage loginPage = new LoginPage(driver, userData.getUrlMail());


        //sender actions
        InboxPage inboxPage = loginPage.loginAs(userData.getLoginMail(), userData.getPasswordMail());

        //open outbox
        OutboxPage outboxPage = inboxPage.openOutboxPage();

        return outboxPage;
    }


}
