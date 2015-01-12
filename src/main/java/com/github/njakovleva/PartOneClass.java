package Main;

import ManageEmail.InboxPage;
import ManageEmail.LoginPage;
import ManageEmail.NewMailPage;
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
public class PartOneClass
{
    public static WebDriver driver = new PhantomJSDriver();
    public static String senderMailUrl = "www.gmail.com";
    public static String receiverMailUrl = "www.yandex.com";

    public static String senderLogin;
    public static String senderPassword;
    public static String receiverLogin;
    public static String receiverPassword;
    public static String receiver;
    public static String subject = "test";
    public static String content;

    public PartOneClass() {
    }

    public InboxPage sendEmail()
    {
        LoginPage loginPage = new LoginPage(driver, senderMailUrl);

        //sender actions
        InboxPage inboxPage = loginPage.loginAs(senderLogin, senderPassword);
        NewMailPage newMailPage = inboxPage.openComposePage();
        inboxPage = newMailPage.sendMail(receiver, subject, content);

        loginPage = inboxPage.signOut();

        //receiver actions
        loginPage = new LoginPage(driver, receiverMailUrl);
        inboxPage = loginPage.loginAs(receiverLogin, receiverPassword);
        return inboxPage;
    }
}
