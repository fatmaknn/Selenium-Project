package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage {
    WebDriver driver;
    
    
    By btnGirisYap = By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div[1]/div[3]/div/div[1]/div");
    By giris = By.xpath("//*[@class=\"gekhq4-4 hwMdSM\"]");
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    
/*    public void GirisYap () {
    	WebElement mainElement = driver.findElement(btnGirisYap);
    	Actions builder = new Actions(driver);
    	builder.moveToElement(mainElement).moveToElement(driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div/div[2]"))).perform();
    	builder.build().perform();
    	driver.findElement(giris).click();
    }*/
}