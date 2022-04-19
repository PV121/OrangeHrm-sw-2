package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl= "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void openBrowserLoginTest(){
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        WebElement userName= driver.findElement(By.id("txtUsername"));// to find element by id
        userName.sendKeys("Admin");

        WebElement password= driver.findElement(By.id("txtPassword"));// to find password field element by id
        password.sendKeys("admin123");

        // click on login button
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();

        String expectedMessage = "Welcome";
        WebElement actualMessageElement = driver.findElement(By.id("welcome"));// to find welcome element by id

        // to split two word by substring (from index no, to index no)
        String actualMessage= actualMessageElement.getText().substring(0,7);

        // to validate expected and actual msg
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @After
    public void closeBrowserLoginTest(){
        closeBrowser();
    }
}
