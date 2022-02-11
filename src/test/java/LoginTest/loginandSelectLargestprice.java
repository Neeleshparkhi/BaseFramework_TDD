package LoginTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Driver.DriverManager;

public class loginandSelectLargestprice extends DriverManager{
	
	@Test
	public void userlogin() throws IOException
	{
		DriverManager.getdriver().get(prop.getProperty("url"));
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		List<WebElement> priceList = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
		
		double largest = 0;
		for(WebElement e : priceList)
		{
			double price = Double.parseDouble(e.getText().replace("$", "")); //"49.99"
			if(largest<price)
			{
				largest = price;
			}
			
		}
		System.out.println(largest);
		
		String xpath = "//div[normalize-space()='$"+largest+"']/following-sibling::button[text()='Add to cart']";
		driver.findElement(By.xpath(xpath)).click();
		
		
	}

}
