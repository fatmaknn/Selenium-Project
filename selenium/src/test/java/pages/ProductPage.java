package pages;

import org.junit.Assert;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import test.LoginPageTest;

import org.apache.log4j.Logger;
public class ProductPage {
    WebDriver driver;
    Logger log = Logger.getLogger(ProductPage.class);
    By product = By.xpath("//*[@id=\"product_id_627050431\"]/a");
    By cart = By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/a");
    By price = By.xpath("//*[@id=\"item-info-block-627050431\"]/div/div[1]/div[2]/div/div[1]/div/div/div[4]/p");
    By cartPrice = By.xpath("//*[@id=\"cart-price-container\"]/div[3]/p");
    By plus = By.xpath("//*[@class=\"plus icon-plus gg-icon gg-icon-plus\"]");
    By delete = By.xpath("//*[@class=\"hidden-m\"]");
    By amount = By.className("amount");
    By x = By.xpath("//*[@id=\"empty-cart-container\"]/div[1]/div[1]/div/div[2]/h2");
    

    public ProductPage (WebDriver driver) {
		this.driver = driver;
	}
    
    
    public void clickPage(){
        driver.findElement(product).click();
    }
    
    public String prices() {
    	driver.findElement(product);
    	return driver.findElement(price).getText();
    }

    //silme iþlemi ve kontrolü
    public void deleteProduct() throws Exception {
    	driver.findElement(delete).click();
    	String empty = driver.findElement(x).getText();
    	try {
    	if(empty.equals("Sepetinizde ürün bulunmamaktadýr.")) {
        	log.info("The items deleted!");
    	}else {
    		log.error("The items not deleted!");
    	} }
    	catch (Exception e) {
            System.out.println(e.getMessage());
        }
    	
    }
    

    //rastgele bir ürün bulma
    public void findProduct() {
		WebElement element = driver.findElement(product);
		//get position
		int x =element.getLocation().getX();
		int y = element.getLocation().getY();
		//scroll to x y 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" +x +", " +y +")");
		//this.clickPage();
    }
    
    //ürünü sepete ekleme ve fiyat karþýlaþtýrma
    public void AddtoCart() throws Exception{
    	WebElement mainElement = driver.findElement(product);
    	String product_prices = this.prices();
    	Actions builder = new Actions(driver);
    	builder.moveToElement(mainElement).moveToElement(driver.findElement(By.xpath("//*[@id=\"item-info-block-627050431\"]/div/div[1]/div[3]/button"))).click().perform();
    	driver.findElement(cart).click();
    	String cart_price = driver.findElement(cartPrice).getText();
    	try {
    	if(product_prices.equals(cart_price)) {
    		Assert.assertTrue(true);
    	}else {
    		log.error("Prices are not same!");
    	}
    	} catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

    //ürün sayýsýný arttýrma ve kontrolü
    public void AddProduct() throws Exception{
    	driver.findElement(plus).click();
    	String total = driver.findElement(amount).getText();
    	try {
    	int i = 2;
		if(total.equals(i)) {
    		Assert.assertTrue(true);
    	}else {
    		log.error("amount is not 2!");
    	}
    	} catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

    
    
}
