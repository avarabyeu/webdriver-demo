package com.github.njakovleva;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by jakovleva on 11/6/2014.
 */


/* *
 - Проверить что письмо появилось в папке отправленные.
 - Проверить что письмо пришло через UI (т.е. в браузере)
 - Проверить что письмо пришло, используя протокол POP3, либо IMAP
 */

public class TestOneClass {
    private SendFromGUIClass sendFromGui = new SendFromGUIClass();
    private UserData userData = new UserData();

    private WebDriver webDriver;

    @BeforeClass
    public void openWebDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Installations\\Chrome Driver\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @AfterClass
    public void closeWebDriver(){
        webDriver.close();
    }

    //@Test(description = "Проверить что письмо пришло через UI (т.е. в браузере)")
    //public void checkUI() {
        //sendFromGui.sendEmail(webDriver);
        //InboxPage inboxPage = sendFromGui.openReceiverEmail(webDriver);
        //Assert.assertTrue(inboxPage.hasMessage(userData.getSubject()));
    //}


    @Test(description = "Проверить что письмо появилось в папке отправленные.")
    public void checkOutbox() {
        sendFromGui.sendEmail(webDriver);
        OutboxPage outboxPage = sendFromGui.openSenderOutbox(webDriver);
        Assert.assertTrue(outboxPage.hasMessage(userData.getSubject()));
    }

    //@Test(description = "Проверить что письмо пришло, используя протокол POP3, либо IMAP")
    //public void checkPOP3() {
    //something
    //}
}
