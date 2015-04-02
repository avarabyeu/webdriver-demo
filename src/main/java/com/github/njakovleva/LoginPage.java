package com.github.njakovleva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by jakovleva on 1/8/2015.
 */
public class LoginPage {
    private WebDriver driver;
    private String url;

    //HTML elements for yandex.com
    //private By usernameLocator = By.id("b-mail-domik-username11");
    //private By usernameLocator = By.name("");
    //private By usernameLocator = By.className("");
    //private By usernameLocator = By.linkName("");
    //private By passwordLocator = By.id("b-mail-domik-password11");
    //private By passwordLocator = By.name("");
    //private By passwordLocator = By.className("");
    //private By passwordLocator = By.linkName("");
    //private By loginButtonLocator = By.id("");
    //private By loginButtonLocator = By.name("");
    //private By loginButtonLocator = By.className("b-mail-button__button");
    //private By loginButtonLocator = By.linkName("");

    //HTML elements for inbox.lv
    private By usernameLocator = By.id("login");
    //private By usernameLocator = By.name("");
    //private By usernameLocator = By.className("");
    //private By usernameLocator = By.linkName("");
    //private By passwordLocator = By.id("");
    //private By passwordLocator = By.name("");
    private By passwordLocator = By.className("password");
    //private By passwordLocator = By.linkName("");
    //private By loginButtonLocator = By.id("");
    //private By loginButtonLocator = By.name("");
    private By loginButtonLocator = By.className("btnLogin");
    //private By loginButtonLocator = By.linkName("");

    //HTML elements for gmail.com
    //private By usernameLocator = By.id("");
    //private By usernameLocator = By.name("");
    //private By usernameLocator = By.className("");
    //private By usernameLocator = By.linkName("");
    //private By passwordLocator = By.id("");
    //private By passwordLocator = By.name("");
    //private By passwordLocator = By.className("");
    //private By passwordLocator = By.linkName("");
    //private By loginButtonLocator = By.id("");
    //private By loginButtonLocator = By.name("");
    //private By loginButtonLocator = By.className("");
    //private By loginButtonLocator = By.linkName("");


    //HTML elements for mail.com
    //private By usernameLocator = By.id("");
    //private By usernameLocator = By.name("");
    //private By usernameLocator = By.className("");
    //private By usernameLocator = By.linkName("");
    //private By passwordLocator = By.id("");
    //private By passwordLocator = By.name("");
    //private By passwordLocator = By.className("");
    //private By passwordLocator = By.linkName("");
    //private By loginButtonLocator = By.id("");
    //private By loginButtonLocator = By.name("");
    //private By loginButtonLocator = By.className("");
    //private By loginButtonLocator = By.linkName("");

    public LoginPage(WebDriver Driver, String Url) {
        long TimeOut = 30;
        this.driver = Driver;
        this.url = Url;

        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        driver.navigate().to(url);

        // Check that we're on the right page.
        //if (!"Yandex.Mail — a free email service".equals(driver.getTitle()))
        //if (!"Inbox.lv".equals(driver.getTitle()))
        //if (!"Вход – Google Аккаунты".equals(driver.getTitle()))
        if (!"Free Email Addresses: Web based and secure Email - mail.com".equals(driver.getTitle()))
        {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // The login page allows the user to type their username into the username field
    public LoginPage typeUsername(String username) {
        driver.findElement(usernameLocator).clear();
        System.out.println("test");
        driver.findElement(usernameLocator).sendKeys(String.valueOf(username));
        System.out.println("test");
        return this;
    }

    // The login page allows the user to type their password into the password field
    public LoginPage typePassword(String password) {
        System.out.println("test");
        //driver.findElement(passwordLocator).clear();
        System.out.println("test");
        //driver.findElement(passwordLocator).click();
        driver.findElement(passwordLocator).sendKeys(String.valueOf(password));
        return this;
    }

    // The login page allows the user to submit the login form
    public InboxPage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new InboxPage(driver);
    }

    // The login page allows the user to submit the login form knowing that an invalid username and / or password were entered
    public LoginPage submitLoginExpectingFailure() {
        driver.findElement(loginButtonLocator).submit();
        return new LoginPage(driver, url);
    }

    // The login page offers the user the service of being able to "log into"
    // the application using a user name and password.
    public InboxPage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}

