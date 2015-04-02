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
    }

    //HTML elements for yandex.com
    //By recipientLocator = By.id("");
    //By recipientLocator = By.name("");
    //By recipientLocator = By.id("nb-36");
    //By recipientLocator = By.LinkName("");
    //By subjectLocator = By.id("");
    //By subjectLocator = By.name("");
    //By subjectLocator = By.className("b-input__text js-kbd-subj");
    //By subjectLocator = By.linkName("");
    //By contentLocator = By.id("");
    //By contentLocator = By.name("send");
    //By contentLocator = By.className("");
    //By contentLocator = By.linkName("");
    //By sendButtonLocator = By.id("nb-16");
    //By sendButtonLocator = By.name("");
    //By sendButtonLocator = By.className("");
    //By sendButtonLocator = By.linkName("");

    //HTML elements for inbox.lv
    //By recipientLocator = By.id("");
    //By recipientLocator = By.name("");
    //By recipientLocator = By.className("");
    //By recipientLocator = By.LinkName("");
    //By subjectLocator = By.id("");
    //By subjectLocator = By.name("");
    //By subjectLocator = By.className("");
    //By subjectLocator = By.linkName("");
    //By contentLocator = By.id("");
    //By contentLocator = By.name("");
    //By contentLocator = By.className("");
    //By contentLocator = By.linkName("");
    //By sendButtonLocator = By.id("");
    //By sendButtonLocator = By.name("");
    //By sendButtonLocator = By.className("");
    //By sendButtonLocator = By.linkName("");

    //HTML elements for gmail.lv
    //By recipientLocator = By.id("to");
    //By recipientLocator = By.name("");
    //By recipientLocator = By.className("");
    //By recipientLocator = By.LinkName("");
    //By subjectLocator = By.id("sub");
    //By subjectLocator = By.name("");
    //By subjectLocator = By.className("");
    //By subjectLocator = By.linkName("");
    //By contentLocator = By.id("body");
    //By contentLocator = By.name("");
    //By contentLocator = By.className("");
    //By contentLocator = By.linkName("");
    //By sendButtonLocator = By.id("send");
    //By sendButtonLocator = By.name("");
    //By sendButtonLocator = By.className("");
    //By sendButtonLocator = By.linkName("");

    //HTML elements for mail.lv
    //By recipientLocator = By.id("");
    //By recipientLocator = By.name("");
    By recipientLocator = By.className("select2-input");
    //By recipientLocator = By.LinkName("");
    By subjectLocator = By.id("id133");
    //By subjectLocator = By.name("");
    //By subjectLocator = By.className("");
    //By subjectLocator = By.linkName("");
    By contentLocator = By.id("");
    //By contentLocator = By.name("");
    //By contentLocator = By.className("");
    //By contentLocator = By.linkName("");
    By sendButtonLocator = By.id("");
    //By sendButtonLocator = By.name("");
    //By sendButtonLocator = By.className("");
    //By sendButtonLocator = By.linkName("");

    // The compose page allows the user to type message recipient
    public NewMailPage typeRecipient(String recipient) {
        System.out.println("test");
        driver.findElement(recipientLocator).sendKeys(recipient);
        //System.out.println("test");
        return this;
    }

    // The compose page allows the user to type message subject
    public NewMailPage typeSubject(String subject) {
        driver.findElement(subjectLocator).sendKeys(subject);
        return this;
    }

    // The compose page allows the user to type message content
    public NewMailPage typeContent(String content) {
        driver.findElement(contentLocator).sendKeys(content);
        return this;
    }

    // The compose page allows the user to send the message
    private InboxPage submitMail() {
        driver.findElement(sendButtonLocator).submit();
        return new InboxPage(driver);
    }

    // The compose page offers the user the service of being able to "send mail"
    // the application using a recipient, subject and content.
    public InboxPage sendMail(String recipient, String subject, String content) {
        typeRecipient(recipient);
        typeSubject(subject);
        typeContent(content);
        return submitMail();
    }
}

