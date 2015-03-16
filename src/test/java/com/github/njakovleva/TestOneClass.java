package com.github.njakovleva;


import org.testng.Assert;
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


    @Test(description = "Проверить что письмо пришло через UI (т.е. в браузере)")
    public void checkUI() {
        sendFromGui.sendEmail();
        InboxPage inboxPage = sendFromGui.openReceiverEmail();
        Assert.assertTrue(inboxPage.hasMessage(userData.getSubject()));
    }


    @Test(description = "Проверить что письмо появилось в папке отправленные.")
    public void checkOutbox() {
        sendFromGui.sendEmail();
        OutboxPage outboxPage = sendFromGui.openSenderOutbox();
        Assert.assertTrue(outboxPage.hasMessage(userData.getSubject()));
    }

    //@Test(description = "Проверить что письмо пришло, используя протокол POP3, либо IMAP")
    //public void checkPOP3() {
    //something
    //}
}
