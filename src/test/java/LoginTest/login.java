package LoginTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverManager;

public class login extends DriverManager{
	
	
	
	@Test
	public void userlogin() throws IOException
	{
		DriverManager.getdriver().get(prop.getProperty("url"));
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		List<WebElement> priceList = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
		double maxprice = priceList.stream().mapToDouble(e -> Double.parseDouble(e.getText().trim().replace("$", ""))).max().getAsDouble();
		System.out.println(maxprice);
		
		String xpath = "//div[normalize-space()='$"+maxprice+"']/following-sibling::button[text()='Add to cart']";
		driver.findElement(By.xpath(xpath)).click();
		
		
	}

}
