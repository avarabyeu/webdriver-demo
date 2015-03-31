package com.github.njakovleva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by jakovleva on 1/8/2015.
 */
public class NewMailPage {
    private final WebDriver driver;

    public NewMailPage(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        //if (!"Yandex.Mail".equals(driver.getTitle())) {
        // Alternatively, we could navigate to the login page, perhaps logging out first
        //throw new IllegalStateException("This is not the Compose page");
        //}
    }

    By recipientLocator = By.className("to");
    By subjectLocator = By.className("b-input__text js-kbd-subj");
    By contentLocator = By.name("send");
    By sendButtonLocator = By.id("nb-16");

    public NewMailPage typeRecipient(String recipient) {
        // This is the only place that "knows" how to enter a recipient

        driver.findElement(recipientLocator).sendKeys(recipient);
        System.out.println("test");
        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;
    }

    public NewMailPage typeSubject(String subject) {
        // This is the only place that "knows" how to enter a subject
        driver.findElement(subjectLocator).sendKeys(subject);

        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;
    }

    public NewMailPage typeContent(String content) {
        // This is the only place that "knows" how to enter a content
        driver.findElement(contentLocator).sendKeys(content);

        // Return the current page object as this action doesn't navigate to a page represented by another PageObject
        return this;
    }

    // The compose page allows the user to send the message
    private InboxPage submitMail() {
        // This is the only place that sends mail and expects the destination to be the inbox page.
        // A separate method should be created for the instance of clicking login whilst expecting a login failure.
        driver.findElement(sendButtonLocator).submit();

        // Return a new page object representing the destination. Should the login page ever
        // go somewhere else (for example, a legal disclaimer) then changing the method signature
        // for this method will mean that all tests that rely on this behaviour won't compile.
        return new InboxPage(driver);
    }

    // Conceptually, the compose page offers the user the service of being able to "send mail"
    // the application using a recipient, subject and content.
    public InboxPage sendMail(String recipient, String subject, String content) {
        // The PageObject methods that enter recipient, subject, content & submit mail have already defined and should not be repeated here.
        typeRecipient(recipient);
        typeSubject(subject);
        typeContent(content);
        return submitMail();
    }
}

