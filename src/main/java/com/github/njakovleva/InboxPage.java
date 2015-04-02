package com.github.njakovleva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

/**
 * Created by jakovleva on 1/8/2015.
 */
public class InboxPage {
    private final WebDriver driver;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }

    //HTML elements for yandex.com
    //By composeButtonLocator = By.linkText("Compose");
    //By signOutButtonLocator = By.id("signout");//?
    //By outboxLinkLocator = By.id("outbox");//?

    //HTML elements for inbox.lv
    //By composeButtonLocator = By.id("mail-menu_li_compose");
    //By signOutButtonLocator = By.id("signout");
    //By outboxLinkLocator = By.id("outbox");

    //HTML elements for gmail.com
    //By composeButtonLocator = By.linkText("Compose");
    //By signOutButtonLocator = By.id("");
    //By outboxLinkLocator = By.id("");

    //HTML elements for mail.com
    By composeButtonLocator = By.linkText("Compose E-mail");
    By signOutButtonLocator = By.id("");
    By outboxLinkLocator = By.id("");

    public NewMailPage openComposePage() {
        driver.findElement(composeButtonLocator).click();
        return new NewMailPage(driver);
    }

    public OutboxPage openOutboxPage() {
        driver.findElement(outboxLinkLocator).submit();
        return new OutboxPage(driver);
    }

    public LoginPage signOut() {
        driver.findElement(signOutButtonLocator).submit();
        return new LoginPage(driver);
    }

    public boolean hasMessage(String subject) {
        WebElement message;
        try {
            message = driver.findElement(By.linkText(subject));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
