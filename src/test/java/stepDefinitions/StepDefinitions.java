package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void elementWaiter(String element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(element))));
    }

    @Given("user visits the website")
    public void user_visits_the_website() {
        driver.get("https://www.amazon.in/");
    }

    @When("user clicks on hamburger menu")
    public void user_clicks_on_hamburger_menu() {
        driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
    }

    @When("clicks on TV, Appliances and Electronics")
    public void clicks_on_tv_appliances_and_electronics() {
        driver.findElement(By.xpath("//div[contains(text(),'TV, Appliances, Electronics')]")).click();
    }

    @When("clicks on Televisions")
    public void clicks_on_televisions() {
        driver.findElement(By.xpath("//a[contains(text(),'Televisions')]")).click();
    }

    @When("filter by brand name Samsung")
    public void filter_by_brand_name_samsung() throws InterruptedException {
        elementWaiter("//span[contains(text(),'Samsung')]");
        List<WebElement> selectingBrand = driver.findElements(By.xpath("//span[contains(text(),'Samsung')]"));
        selectingBrand.get(1).click();
        Thread.sleep(4000);
    }

    @When("sort by price High to Low")
    public void sort_by_price_high_to_low() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).click();
        driver.findElement(By.xpath("//a[@id='s-result-sort-select_2']")).click();
        Thread.sleep(3000);
    }

    @When("clicks on the second highest priced item")
    public void clicks_on_the_second_highest_priced_item() {
        List<WebElement> televisionList = driver.findElements(By.xpath("//img[@class='s-image']"));
        televisionList.get(1).click();
    }

    @Then("verify About this item section is visible")
    public void verify_about_this_item_section_is_visible() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        elementWaiter("//h1[@class='a-size-base-plus a-text-bold']");
        String text = driver.findElement(By.xpath("//h1[@class='a-size-base-plus a-text-bold']")).getText();
        Assert.assertEquals(text, "About this item");
    }
    @After
    public void afterTest(){
        driver.quit();
    }
}
