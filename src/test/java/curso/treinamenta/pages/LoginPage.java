package curso.treinamenta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
    @FindBy(name = "userName")
    WebElement campoUsuario;
    
    @FindBy (name = "password")
    WebElement campoPassword;
    
    @FindBy (name = "login")
    WebElement botaoSign;
    
  
    
}
