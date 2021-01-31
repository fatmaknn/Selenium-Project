package test;
import Collections.LoginPageCollection;
import pages.HomePage;
import pages.LoginPage;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;


public class LoginPageTest extends BaseTest{
    Logger log = Logger.getLogger(LoginPageTest.class);
    String expectedTitle = "GittiGidiyor - T�rkiye'nin �nc� Al��veri� Sitesi";
    
    //Anasayfay� a��yor.
	@Test
	public void Home() {
		navigateUrl(LoginPageCollection.HomePageUrl);
        log.info("Application launched");
	}

	//Giri� yap sayfas�n� a��p, giri� yap�yor.
    @Test
    public void Login() throws Exception {

        navigateUrl(LoginPageCollection.loginPageUrl);
        //new HomePage(driver).GirisYap();
        new LoginPage(driver).LoginMethod(LoginPageCollection.correctUsername, LoginPageCollection.correctPassword);
        //Assert.assertEquals(driver.getTitle(), "GittiGidiyor - T�rkiye'nin �nc� Al��veri� Sitesi");
        
        try{
        	  Assert.assertEquals(expectedTitle, driver.getTitle());
        	  log.info("Navigated to correct webpage");
        	}
        	catch(Throwable pageNavigationError){
        	  log.error("Didn't navigate to correct webpage");
        	}
    }
}
