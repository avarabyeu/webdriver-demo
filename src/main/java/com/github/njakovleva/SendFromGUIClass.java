package com.github.njakovleva;

import org.openqa.selenium.WebDriver;

/**
 * Created by jakovleva on 1/20/2015.
 */
public class SendFromGUIClass {


    private static UserData userData = new UserData();

    public void sendEmail(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver, userData.getUrlYandex());

        //sender actions
        InboxPage inboxPage = loginPage.loginAs(userData.getLoginYandex(), userData.getPasswordYandex());
        NewMailPage newMailPage = inboxPage.openComposePage();
        inboxPage = newMailPage.sendMail(userData.getMailGmail(), userData.getSubject(), userData.getContent());
    }

    public InboxPage openReceiverEmail(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver, userData.getUrlGmail());

        //receiver actions
        InboxPage inboxPage = loginPage.loginAs(userData.getLoginGmail(), userData.getPasswordGmail());
        return inboxPage;
    }

    public OutboxPage openSenderOutbox(WebDriver driver) {

        LoginPage loginPage = new LoginPage(driver, userData.getUrlYandex());
        //System.out.println("test");
        //sender actions
        InboxPage inboxPage = loginPage.loginAs(userData.getLoginYandex(), userData.getPasswordYandex());

        //open outbox
        OutboxPage outboxPage = inboxPage.openOutboxPage();

        return outboxPage;
    }


}
