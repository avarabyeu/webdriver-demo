package Test;

import Main.SendFromGUIClass;
import Main.UserData;
import ManageEmail.InboxPage;
import ManageEmail.OutboxPage;
import ManageEmail.LoginPage;
import ManageEmail.NewMailPage;
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


/* *
 - Проверить что письмо появилось в папке отправленные.
 - Проверить что письмо пришло через UI (т.е. в браузере)
 - Проверить что письмо пришло, используя протокол POP3, либо IMAP
 */

public class TestOneClass {
    public static SendFromGUIClass sendFromGui = new SendFromGUIClass();
    public static UserData userData = new UserData();
    public static String subject = sendFromGui.subject;


    public void main() {


        //selection which procedure to run

        //case 1
        checkUI(sendFromGui);

        //case 2
        checkOutbox(sendFromGui);

        //case 3
        //checkPOP3();
    }

    @Test(description = "Проверить что письмо пришло через UI (т.е. в браузере)")
    public static void checkUI(SendFromGUIClass sendFromGUI) {
        sendFromGUI.sendEmail();
        InboxPage inboxPage = sendFromGUI.openReceiverEmail();
        Assert.assertTrue(inboxPage.hasMessage(subject));
    }


    @Test(description = "Проверить что письмо появилось в папке отправленные.")
    public void checkOutbox(SendFromGUIClass sendFromGUI) {
        sendFromGUI.sendEmail();
        OutboxPage outboxPage = sendFromGUI.openSenderOutbox();
        Assert.assertTrue(outboxPage.hasMessage(subject));
    }

    //@Test(description = "Проверить что письмо пришло, используя протокол POP3, либо IMAP")
    //public void checkPOP3() {
        //something
    //}
