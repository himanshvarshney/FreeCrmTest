package java;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HashMapInSelenium {

	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/login.cfm");
		
		System.out.println(getCredentialsMap());
		
		driver.findElement(By.name("username")).sendKeys(getUserName("admin"));
		driver.findElement(By.name("password")).sendKeys(getPassword("admin"));

	}
	public static HashMap<String, String> getCredentialsMap() {
		HashMap<String, String> userMap = new HashMap<String, String>();
		userMap.put("customer", "naveenautomation:Test@123");
		userMap.put("admin","himanshuvar:Ishwar@001");
		return userMap;
		
	}
	public static String getUserName(String role) {
		String credentials = getCredentialsMap().get(role);
		return credentials.split(":")[0];
	}
	public static String getPassword(String role) {
		String credentials = getCredentialsMap().get(role);
		return credentials.split(":")[1];
	}
}
