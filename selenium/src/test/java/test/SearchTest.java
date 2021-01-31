package test;
import org.junit.Test;

import Collections.LoginPageCollection;
import pages.LoginPage;
import pages.SearchPage;
import pages.ProductPage;

public class SearchTest extends BaseTest {
	
	//giriþ yapma, arama,2.sayfa açýlýþý, ürün seçme, sepete ekleme,fiyat karþýlaþtýrma,ürün sayýsýný arttýrma, ürünü silme iþlemlerinin testi burda gerçekleþiyor.
    @Test
    public void Search() throws Exception {
        navigateUrl(LoginPageCollection.loginPageUrl);
        new LoginPage(driver).LoginMethod(LoginPageCollection.correctUsername, LoginPageCollection.correctPassword);
        new SearchPage(driver).sendInput("bilgisayar");
        new SearchPage(driver).performPage();
        new ProductPage(driver).findProduct();
        new ProductPage(driver).AddtoCart();
        new ProductPage(driver).AddProduct();
        new ProductPage(driver).deleteProduct();
    }
}
