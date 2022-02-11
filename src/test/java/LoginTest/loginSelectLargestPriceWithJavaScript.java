package LoginTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Driver.DriverManager;

public class loginSelectLargestPriceWithJavaScript extends DriverManager{
	
	@Test
	public void userlogin() throws IOException
	{
		DriverManager.getdriver().get(prop.getProperty("url"));
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		String script = "var max = 0;\r\n" + 
				"document.getElementsByClassName('inventory_item_price')\r\n" + 
				".forEach(e => {newVall = parseFloat(e.innerText.split('$')[1]);\r\n" + 
				"if(max < newVall)\r\n" + 
				"{\r\n" + 
				"    max = newVall;\r\n" + 
				"}\r\n" + 
				"             });\r\n" + 
				"console.log(max)\r\n" + 
				"var xpath = \"//div[normalize-space()='$\"+max+\"']/following-sibling::button[text()='Add to cart']\";\r\n" + 
				"var ele = document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;\r\n" + 
				"ele.click();";
		
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript(script);
	}

}
