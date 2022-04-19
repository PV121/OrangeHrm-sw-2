package testsuite;

import browserfactory.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void openBrowserForgotPassTest() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {

        WebElement forgotPass = driver.findElement(By.linkText("Forgot your password?"));
        forgotPass.click();

        String expectedMessage = "Forgot Your Password?";

        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        String actualMessage = actualMessageElement.getText();

        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @After
    public void closeBrowserForgotPassTest() {
        closeBrowser();
    }
}
