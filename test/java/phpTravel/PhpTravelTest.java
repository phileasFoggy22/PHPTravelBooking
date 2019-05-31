package phpTravel;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhpTravelTest {

	public static WebDriver driver;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void methodTest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/");

		WebElement getSearchDates = driver.findElement(By.xpath("//*[@id=\"dpd1\"]/div/input"));
		getSearchDates.sendKeys("05/06/2019");

		WebElement getSearchDates2 = driver.findElement(By.xpath("//*[@id=\"dpd2\"]/div/input"));

		getSearchDates2.sendKeys("07/06/2019");

		WebElement getPeopleNo = driver.findElement(By.xpath("//*[@id=\"travellersInput\"]"));
		getPeopleNo.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("adultPlusBtn")));
		WebElement addAdult = driver.findElement(By.id("adultPlusBtn"));
		addAdult.click();
		WebElement getSearchBar = driver.findElement(By.xpath("//*[@id=\"s2id_autogen3\"]/a"));
		getSearchBar.click();
		getSearchBar.sendKeys("London");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-drop\"]/ul/li/ul/li[1]/div")));

		WebElement getLondon = driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li/ul/li[1]/div"));
		getLondon.click();
		WebElement searchHotels = driver.findElement(By.xpath("//*[@id=\"hotels\"]/form/div[5]/button"));
		searchHotels.click();
		WebElement chooseHotel = driver.findElement(
				By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div/table/tbody/tr[2]/td/div[3]/a"));
		chooseHotel.click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"OVERVIEW\"]/div[5]/div/div/div[1]")));

		// WebElement chooseCookies = driver.findElement(By.id("cookyGotItBtn"));
		// chooseCookies.click();
		// WebElement chooseRoom = driver.findElement(By.id("roomsCheckbox"));
		// //
		// *[@id="ROOMS"]/div/table/tbody/tr[1]/td/div[2]/div[2]/div/div[3]/div/label/div
		// chooseRoom.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("adults")));
		WebElement modify1 = driver.findElement(By.id("roomsCheckbox"));
		modify1.click();
		Select drpAdultNo = new Select(driver.findElement(By.id("adults")));
		drpAdultNo.selectByVisibleText("3");
		WebElement modify2 = driver
				.findElement(By.xpath("//*[@id=\"body-section\"]/div[4]/div[2]/div/div[2]/form/div[5]/input[3]"));
		modify2.click();
		TimeUnit.SECONDS.sleep(5);

	}

	@AfterClass
	public static void teardown() {
		driver.quit();
	}
}
