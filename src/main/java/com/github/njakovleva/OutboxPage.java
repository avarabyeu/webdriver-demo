package com.github.njakovleva;

/**
 * Created by jakovleva on 1/8/2015.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class OutboxPage {
    private final WebDriver driver;

    public OutboxPage(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        if (!"Outbox".equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the outbox page");
        }
    }

    By composeButtonLocator = By.id("compose");
    By subjectLocator = By.id("subject");
    By signOutButtonLocator = By.id("signout");

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
