package test3;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestThree {

	@Test
	public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://techfios.com/test/101/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// to select the Toggle all button
		WebElement allbox = driver.findElement(By.name("allbox"));
		allbox.click();

		List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//*[@id=\"todos-content\"]/form/ul/li/input"));
		int size = AllCheckboxes.size();
		System.out.println("List items count is: "+size);

		for (int i = 0; i < size; i++) {

			// AllCheckboxes.get(i).click();
			
			if (AllCheckboxes.get(i).isSelected()) {
				System.out.println("All items are selected");
			} else {
				System.out.println("All items are not selected");

			}
		}
		driver.close();
	}

}
