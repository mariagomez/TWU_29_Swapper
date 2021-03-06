package functional.com.thoughtworks.twu;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TakeDownOfferFunctionalTest {


    private WebDriver webDriver;
    private String username;
    private String password;

    @Before
    public void setUp() {
        webDriver = new FirefoxDriver();
        username = "test.twu";
        password = "Th0ughtW0rks@12";
    }

    @Test
    public void shouldBeAbleToTakedownOfferAfterCreate() throws Exception {

        logIn();

        Thread.sleep(2000);
        webDriver.findElement(By.id("createOffer")).click();
        Thread.sleep(2000);

        String offerTitle = "TITLE_"+ GregorianCalendar.getInstance().getTime().getTime();
        webDriver.findElement(By.name("title")).sendKeys(offerTitle);

        Select select = new Select(webDriver.findElement(By.tagName("select")));
        select.selectByValue("Cars");

        webDriver.findElement(By.name("descriptionTxt")).sendKeys("To pass the test or not, this is a question");
        webDriver.findElement(By.name("submit")).click();
        Thread.sleep(2000);


        WebElement takeDownButton = webDriver.findElement(By.id("takeDownButton"));

        assertThat(takeDownButton, is(not(nullValue())));

    }

    @Test
    public void shouldBeAbleToTakedownOfferAfterBrowse() throws Exception {

        logIn();

        Thread.sleep(2000);
        webDriver.findElement(By.id("createOffer")).click();
        Thread.sleep(2000);

        String offerTitle = "TITLE_"+ GregorianCalendar.getInstance().getTime().getTime();
        webDriver.findElement(By.name("title")).sendKeys(offerTitle);

        Select select = new Select(webDriver.findElement(By.tagName("select")));
        select.selectByValue("Cars");

        webDriver.findElement(By.name("descriptionTxt")).sendKeys("To pass the test or not, this is a question");
        webDriver.findElement(By.name("submit")).click();
        Thread.sleep(2000);


        webDriver.get("http://127.0.0.1:8080/twu/");

        webDriver.findElement(By.id("browse")).click();

        Thread.sleep(2000);

        webDriver.findElement(By.id("offer1")).click();

        Thread.sleep(2000);

        WebElement takeDownButton = webDriver.findElement(By.id("takeDownButton"));

        assertThat(takeDownButton, is(not(nullValue())));

    }

    @Test
    public void shouldGoToHomeAfterHideAnOffer() throws Exception {

        logIn();

        Thread.sleep(2000);
        webDriver.findElement(By.id("createOffer")).click();
        Thread.sleep(2000);

        String offerTitle = "TITLE_"+ GregorianCalendar.getInstance().getTime().getTime();
        webDriver.findElement(By.name("title")).sendKeys(offerTitle);

        Select select = new Select(webDriver.findElement(By.tagName("select")));
        select.selectByValue("Cars");

        webDriver.findElement(By.name("descriptionTxt")).sendKeys("To pass the test or not, this is a question");
        webDriver.findElement(By.name("submit")).click();
        Thread.sleep(2000);


        webDriver.findElement(By.id("takeDownButton")).click();
        Thread.sleep(2000);

        String pageTitle = webDriver.getTitle();

        String expectedPageTitle = "Home";

        assertThat(pageTitle, is(expectedPageTitle));

    }



    @Test
    public void shouldNotDisplayHiddenOfferInBrowsePageAfterTakeDown() throws Exception {
        logIn();

        WebDriverWait waitToBrowse = new WebDriverWait(webDriver, 1000);
        waitToBrowse.until(ExpectedConditions.visibilityOfElementLocated(By.id("browse")));
        webDriver.findElement(By.id("browse")).click();
        Thread.sleep(1000);
        List<WebElement> initialList = webDriver.findElements(By.className("offer"));
        webDriver.get("http://127.0.0.1:8080/twu/");


        webDriver.findElement(By.id("createOffer")).click();

        WebDriverWait wait = new WebDriverWait(webDriver, 5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("title")));

        String offerTitle = "TITLE_"+ GregorianCalendar.getInstance().getTime().getTime();
        webDriver.findElement(By.name("title")).sendKeys(offerTitle);

        Select select = new Select(webDriver.findElement(By.tagName("select")));
        select.selectByValue("Cars");

        webDriver.findElement(By.name("descriptionTxt")).sendKeys("To pass the test or not, this is a question");
        webDriver.findElement(By.name("submit")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("takeDownButton")));

        webDriver.findElement(By.id("takeDownButton")).click();
        webDriver.findElement(By.id("browse")).click();

        List<WebElement> offerList = webDriver.findElements(By.className("offer"));

        assertThat(offerList.size(), is(initialList.size()));
    }


    @After
    public void tearDown() throws Exception {
        webDriver.close();
    }

    private void logIn() throws InterruptedException {
        webDriver.get("http://127.0.0.1:8080/twu/");

        webDriver.findElement(By.id("username")).sendKeys(username);
        webDriver.findElement(By.id("password")).sendKeys(password);
        webDriver.findElement(By.name("submit")).click();
        Thread.sleep(2000);
    }

}
