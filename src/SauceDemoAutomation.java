import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoAutomation {
    public static void main(String[] args) throws InterruptedException {
        
    	// Lunch the chrome browser
    	
    	WebDriver driver = new ChromeDriver();
        try {
        	//Open the SauceDemo website
        	
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize(); //Maximize browser window

            // Login with dummy account
            
            driver.findElement(By.id("user-name")).sendKeys("standard_user"); // Enter username
            driver.findElement(By.id("password")).sendKeys("secret_sauce"); // Enter password
            driver.findElement(By.id("login-button")).click(); //Click login button

            // Select first product from the products list
            
            WebElement firstProduct = driver.findElement(By.className("inventory_item_name"));
            firstProduct.click(); // Click on the to open its details page

            // Add to cart
            
            driver.findElement(By.cssSelector("button.btn_primary.btn_inventory")).click(); // Click "Add to cart"
            driver.findElement(By.className("shopping_cart_link")).click(); // Open cart page

            // Logout from the application
            
            driver.findElement(By.id("react-burger-menu-btn")).click(); 
            driver.findElement(By.id("logout_sidebar_link")).click(); // click logout

        } finally {
        	Thread.sleep(5000);
            driver.quit();
        }
    }
}
