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

        // Check that we're on the right page.
        if (!"Inbox".equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the inbox page");
        }
    }

    By composeButtonLocator = By.id("compose");
    By signOutButtonLocator = By.id("signout");
    By outboxLinkLocator = By.id("outbox");

    public NewMailPage openComposePage() {
        driver.findElement(composeButtonLocator).submit();
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
