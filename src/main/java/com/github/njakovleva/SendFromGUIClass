package Main;

import ManageEmail.InboxPage;
        import ManageEmail.LoginPage;
        import ManageEmail.NewMailPage;
        import ManageEmail.OutboxPage;
        import Main.UserData;
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
        import java.io.FileInputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.util.Properties;

/**
 * Created by jakovleva on 1/20/2015.
 */
public class SendFromGUIClass
{
    public static String senderMailUrl;
    public static String receiverMailUrl;
    public static String senderLogin;
    public static String senderPassword;
    public static String receiverLogin;
    public static String receiverPassword;
    public static String receiver;
    public static String subject;
    public static String content;


    public SendFromGUIClass() {
    }

    public UserData userData = new UserData();

    public void sendEmail()
    {
        getUserData();

        WebDriver driver = new PhantomJSDriver();
        LoginPage loginPage = new LoginPage(driver, senderMailUrl);

        //sender actions
        InboxPage inboxPage = loginPage.loginAs(senderLogin, senderPassword);
        NewMailPage newMailPage = inboxPage.openComposePage();
        inboxPage = newMailPage.sendMail(receiver, subject, content);
    }

    public InboxPage openReceiverEmail()
    {
        WebDriver driver = new PhantomJSDriver();
        LoginPage loginPage = new LoginPage(driver, receiverMailUrl);

        //receiver actions
        InboxPage inboxPage = loginPage.loginAs(receiverLogin, receiverPassword);
        return inboxPage;
    }

    public OutboxPage openSenderOutbox()
    {
        getUserData();

        WebDriver driver = new PhantomJSDriver();
        LoginPage loginPage = new LoginPage(driver, senderMailUrl);

        //sender actions
        InboxPage inboxPage = loginPage.loginAs(senderLogin, senderPassword);
        NewMailPage newMailPage = inboxPage.openComposePage();
        inboxPage = newMailPage.sendMail(receiver, subject, content);

        //open outbox
        OutboxPage outboxPage = inboxPage.openOutboxPage();

        return outboxPage;
    }

    private void getUserData() {
        userData.getUserData(senderMailUrl, receiverMailUrl, senderLogin, senderPassword,
                receiverLogin, receiverPassword, receiver, subject, content);
    }

}
