package by.it.akhmelev;

import by.it.akhmelev.pages.ResultPage;
import by.it.akhmelev.pages.StartPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExpediaTest {

    WebDriver driver;


    @Before
    public void setUpBrowser() {
        driver = new ChromeDriver();
    }

    @Test
    public void taskA() throws Exception {
        driver.get("https://www.expedia.com/");

        StartPage startPage = new StartPage(driver);

        ResultPage resultPage = startPage
                .selectSearchFlightMode()
                .selectOneWay()
                .setOrigin("Minsk, Belarus (MSQ-All Airports)")
                .setDestination("Moscow, Russia (MOW-All Airports)")
                .setDepartingDate("05/24/2019")
                .getSearch();

        int resultSearchCount = resultPage.getResultSearchCount();
        Assert.assertTrue(resultSearchCount > 1);


        //Thread.sleep(15000); //это чтобы успеть увидеть результат, а вообще нужно убрать



        //перенос всех событий в POM сделал код чище.
        /*
        WebElement buttonOneWay = driver.findElement(By.id("flight-type-one-way-label-hp-flight"));
        buttonOneWay.click();

        WebElement inputOrigin = driver.findElement(By.id("flight-origin-hp-flight"));
        inputOrigin.click();
        inputOrigin.sendKeys("Minsk, Belarus (MSQ-All Airports)");

        WebElement selectAriaOptionOrigin = driver.findElement(By.id("aria-option-0"));
        selectAriaOptionOrigin.click();

        WebElement inputDestination = driver.findElement(By.id("flight-destination-hp-flight"));
        inputDestination.click();
        inputDestination.sendKeys("Moscow, Russia (MOW-All Airports)");

        WebElement selectAriaOptionDestination = driver.findElement(By.id("aria-option-0"));
        selectAriaOptionDestination.click();

        WebElement inputDeparting = driver.findElement(By.id("flight-departing-hp-flight"));
        inputDeparting.sendKeys("06/21/2019");

        //// some oper
        Thread.sleep(5000);

        List<WebElement> resultPrice=driver.findElements(By.xpath("//*[@data-test-id='listing-price-dollars']"));
        Assert.assertTrue(resultPrice.size()>1);

        */
    }

    @After
    public void tearDownBrowser() {
        driver.quit();
    }
}
