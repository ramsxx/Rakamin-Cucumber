package cucumber.stepDef;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user launch the website")
    public void userLaunchTheWebsite() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.cssSelector("#root > div > div.login_logo")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @Then("user input a registered user")
    public void userInputARegisteredUser() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input registered password")
    public void userInputRegisteredPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
    }

    @Then("Home Page Should be displayed")
    public void homePageShouldBeDisplayed() {
        String productPage = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(productPage, "Products");
        driver.quit();
    }

    @And("user input wrong password")
    public void userInputWrongPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce1");
    }

    @Then("user get error massage")
    public void userGetErrorMassage() {
        String errorLogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.quit();
    }


    @When("user input (.*) as email$")
    public void user_input_email_as_email(String email) {
        driver.findElement(By.id("user-name")).sendKeys(email);
    }

    @And("user input (.*) as password$")
    public void user_input_password_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("user verify (.*) login result$")
    public void user_verify_status_login_result(String status) {
        if (status.equals("succes")) {
            String productPage = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
            Assert.assertEquals(productPage, "Products");
        } else {
            driver.quit();
        }
    }

}