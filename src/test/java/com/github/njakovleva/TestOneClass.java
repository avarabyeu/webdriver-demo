package com.github.njakovleva;

import Main.PartOneClass;
import org.omg.CORBA.TIMEOUT;
import org.testng.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import com.sun.mail.pop3.POP3Store;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.common.collect.*;


/**
 * Created by jakovleva on 11/6/2014.
 */

/**
 *
 - Проверить что письмо появилось в папке отправленные.
 - Проверить что письмо пришло через UI (т.е. в браузере)
 - Проверить что письмо пришло, используя протокол POP3, либо IMAP
 */




public class TestOneClass {

    public static PartOneClass partOneClass = new PartOneClass();
    public static WebDriver webDriver = new PhantomJSDriver();
    static String sentEmailSubject = "Test email";
    static String receivedEmailSubject;
    static String BaseUrl = "http://www.mail.com";
    static long TimeOut = 30;

    public static void main(String[] args) {
        TestOneClass testOneClass = new TestOneClass();

        //selection which procedure to run

        //case 1
        checkUI();

        //case 2
        //checkOutbox();

        //case 3
        //checkPOP3();
    }

    @Test(description = "Проверить что письмо пришло через UI (т.е. в браузере)")
    public static void checkUI() {

        //send email
        sendEmail(sentEmailSubject);

        //check if message appeared in Inbox
        receivedEmailSubject = messageReceivedUI(sentEmailSubject);
        Assert.assertEquals(receivedEmailSubject, sentEmailSubject);
    }

    @Test(description = "Проверить что письмо появилось в папке отправленные.")
    public void checkOutbox() {
        //something
    }

    @Test(description="Проверить что письмо пришло, используя протокол POP3, либо IMAP")
    public void checkPOP3() {
        //something
    }

    public static void sendEmail(String sentEmailSubject) {
        partOneClass.sendEmail(sentEmailSubject);
    }

    public static void loginToReceiverMail() {
        webDriver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);

        webDriver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);

        webDriver.navigate().to(BaseUrl);

        WebElement loginBox = webDriver.findElement(By.id("Email"));
        loginBox.sendKeys("natayandexone@mail.com");

        WebElement pwBox = webDriver.findElement(By.id("Passwd"));
        pwBox.sendKeys("Kalina@35");

        WebElement signInBtn = webDriver.findElement(By.id("signIn"));
        signInBtn.click();

    }

    public static String messageReceivedUI(String messageSubject) {
        loginToReceiverMail();
        WebElement message;
        try {
           message = webDriver.findElement(By.linkText(messageSubject));
        }
        catch (NoSuchElementException e)
        {
            return "";
        }

        return messageSubject;
    }

    public boolean messageReceivedOutbox() {
        //something here
        return true;
    }

    public boolean messageReceivedPOP3() {
        //something here
        return true;
    }
}
