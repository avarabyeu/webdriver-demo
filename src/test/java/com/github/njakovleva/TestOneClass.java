package Test;

import Main.PartOneClass;
import ManageEmail.InboxPage;
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

/**
 *
 - Проверить что письмо появилось в папке отправленные.
 - Проверить что письмо пришло через UI (т.е. в браузере)
 - Проверить что письмо пришло, используя протокол POP3, либо IMAP
 */

public class TestOneClass
{
    public static String subject = "test";

    public static void main(String[] args)
    {
        PartOneClass partOneClass = new PartOneClass();

        //selection which procedure to run

        //case 1

        checkUI(partOneClass);

        //case 2
        //checkOutbox();

        //case 3
        //checkPOP3();
    }

    @Test(description = "Проверить что письмо пришло через UI (т.е. в браузере)")
    public static void checkUI(PartOneClass partOneClass)
    {
        Assert.assertTrue(partOneClass.sendEmail().hasMessage(subject));
    }

    @Test(description = "Проверить что письмо появилось в папке отправленные.")
    public void checkOutbox() {
        //something
    }

    @Test(description="Проверить что письмо пришло, используя протокол POP3, либо IMAP")
    public void checkPOP3() {
        //something
    }



    /*private static void login(String login, String password)
    {
        inboxPage = loginPage.loginAs(login, password);
    }

    private static void openComposePage()
    {
        newMailPage = inboxPage.openComposePage();
    }

    private static void sendMessage(String receiverMail, String mailSubject, String mailContent)
    {
        inboxPage = newMailPage.sendMail(receiverMail, mailSubject, mailContent);
    }

    public boolean messageReceivedOutbox() {
        //something here
        return true;
    }

    public boolean messageReceivedPOP3() {
        //something here
        return true;
    }*/
}
