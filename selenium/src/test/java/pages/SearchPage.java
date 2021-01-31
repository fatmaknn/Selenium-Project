package pages;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import test.BaseTest;

public class SearchPage extends BaseTest{
    Logger log = Logger.getLogger(SearchPage.class);
	private WebDriver driver;
	String expectedUrl = "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2";

	
	By search = By.name("k");
	By page = By.cssSelector("#best-match-right > div.pager.pt30.hidden-m.gg-d-24 > ul > li:nth-child(2) > a");
	//By product = By.xpath("//*[@id=\"item-info-block-634894616\"]/div/div[1]/div[3]");

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

    public void clickPage(){
        driver.findElement(page).click();
    }

	//arama iþlemini gerçekleþtiriyor.
	public void sendInput(String input) {
		driver.findElement(search).sendKeys(input + Keys.ENTER);
	}
	
	//2.sayfayý açýyor.
	public void performPage() {
		//initialize element
		WebElement element = driver.findElement(page);
		//get position
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();

		//scroll to x y 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" +x +", " +y +")");
		this.clickPage();
		try{
			  Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
			  log.info("Navigated to correct webpage");
			}
			catch(Throwable pageNavigationError){
			  log.error("Didn't navigate to correct webpage");
			}
	}

	
}
