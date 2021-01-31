package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage {
    WebDriver driver;
    By userName = By.name("kullanici");

    By password = By.name("sifre");

    By login = By.name("pass");


    public LoginPage (WebDriver driver){
        this.driver = driver;
    }
    
    //Username input'una giriþ yapma
    public void setUserName(String strUserName){
        driver.findElement(userName).sendKeys(strUserName);
    }

    //Password input'una giriþ yapma
    public void setPassword(String strPassword){
        driver.findElement(password).sendKeys(strPassword);
    }

    //Giriþ yap butonuna týklama
    public void clickLogin(){
        driver.findElement(login).submit();
    }

    public void LoginMethod(String strUserName,String strPasword){
        //Collections'tan gelen username'i dolduruyor
        this.setUserName(strUserName);
        //Collections'tan gelen password'u doldur
        this.setPassword(strPasword);
        //giriþlerden sonra login'e týklama
        this.clickLogin();

    }
}
