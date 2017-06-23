package exam.preparation.ExamPreparationProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	double testStartTime;
	double testEndTime;
	protected WebDriver driver;

	@BeforeMethod
	public void prepareForTest() {

		testStartTime = System.currentTimeMillis();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://88.119.151.54/opencartone/");

	}

	@AfterMethod
	public void closeBrowser() {

		testEndTime = System.currentTimeMillis();
		System.out.println("Time tests took: " + (testEndTime - testStartTime));

		driver.close();

	}

}
