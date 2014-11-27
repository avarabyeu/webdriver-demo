package com.github.njakovleva;

import org.testng.*;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
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
 * Created by jakovleva on 10/8/2014.
 */

/**
 * Открыть в браузере почтовый ящик, создать новое письмо, отправить его.
 */
public class PartOneClass {
    String BaseUrl = "http://www.inbox.lv";
    long TimeOut = 30;
    public WebDriver driver = new PhantomJSDriver();

    public void sendEmail(String emailSubject)
    {
        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);

        driver.navigate().to(BaseUrl);

        WebElement loginBox = driver.findElement(By.id("Email"));
        loginBox.sendKeys("nata-y@inbox.lv");

        WebElement pwBox = driver.findElement(By.id("Passwd"));
        pwBox.sendKeys("$KoMo190256");

        WebElement signInBtn = driver.findElement(By.id("signIn"));
        signInBtn.click();

        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);

        driver.switchTo().frame("canvas_frame");

        WebElement composeBtn = driver.findElement(By.cssSelector("div[class='T-I J-J5-Ji T-I-KE L3']"));
        composeBtn.click();

        WebElement toBox = driver.findElement(By.cssSelector("textarea[class='dK nr']"));
        toBox.sendKeys("natayandexone@mail.com");

        WebElement subjBox = driver.findElement(By.cssSelector("input[class='ez nr']"));
        subjBox.sendKeys(emailSubject);

        WebElement msgBox = driver.findElement(By.cssSelector("textarea[class='Ak aXjCH']"));
        msgBox.sendKeys("This is a test email sent via Selenium Web Driver");

        WebElement sendBtn = driver.findElement(By.cssSelector("div[class='T-I J-J5-Ji Bq nS T-I-KE L3']>b"));
        sendBtn.click();

    }

}
