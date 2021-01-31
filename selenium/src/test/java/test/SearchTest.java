package test;
import org.junit.Test;

import Collections.LoginPageCollection;
import pages.LoginPage;
import pages.SearchPage;
import pages.ProductPage;

public class SearchTest extends BaseTest {
	
	//giri� yapma, arama,2.sayfa a��l���, �r�n se�me, sepete ekleme,fiyat kar��la�t�rma,�r�n say�s�n� artt�rma, �r�n� silme i�lemlerinin testi burda ger�ekle�iyor.
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
