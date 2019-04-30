package curso.treinamento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='/images/masts/mast_register.gif']")
	WebElement titlePage;
	
	@FindBy(name = "firstName")
	WebElement campoFirstName;
	
	@FindBy(name = "lastName")
	WebElement campoLastName;
	
	@FindBy(name = "phone")
	WebElement campoPhone;
	
	@FindBy(id = "userName")
	WebElement campoEmail;
	
	@FindBy(name = "address1")
	WebElement campoAddress;
	
	@FindBy(name = "address2")
	WebElement campoAddressComplement;
	
	@FindBy(name = "city")
	WebElement campoCity;
	
	@FindBy(name = "state")
	WebElement campoStateProvince;
	
	@FindBy(name = "postalCode")
	WebElement campoPostalCode;
	
	@FindBy(name = "country")
	WebElement comboBoxCountry;
	
	@FindBy(id = "email")
	WebElement campoUserName;
	
	@FindBy(name = "password")
	WebElement campoPassword;

	@FindBy(name = "confirmPassword")
	WebElement campoConfirmPassword;
	
	@FindBy(xpath = "//input[@name='register']")
	WebElement botaoSubmit;
	
	@FindBy(xpath = "//b[contains(text(),'Dear')]//ancestor::td[1]")
	WebElement mensagemRegistroComSucesso;
	

	public boolean checkPage() { 
		return titlePage.isDisplayed();
	}
	
	
	public void preencherContactInformation(String firstName, String lastName,  String phone, String email ) { 
		
		campoFirstName.sendKeys(firstName);
		campoLastName.sendKeys(lastName);
		campoPhone.sendKeys(phone);
		campoEmail.sendKeys(email);
	}
	
	public void preencherMailingInformation(String address, String addressComplement, String city, String stateProvince, 
			String postalCode, String country) { 
		
		campoAddress.sendKeys(address);
		campoAddressComplement.sendKeys(addressComplement);
		campoCity.sendKeys(city);
		campoStateProvince.sendKeys(stateProvince);
		campoPostalCode.sendKeys(postalCode);
		new Select(comboBoxCountry).selectByVisibleText(country);
	}
	
	public void preencherUserInformation(String userName, String password, String confirmPassword) { 
		
		campoUserName.sendKeys(userName);
		campoPassword.sendKeys(password);
		campoConfirmPassword.sendKeys(confirmPassword);
	}
	
	public void clicarBotaoSubmit() { 
		botaoSubmit.click();
	}
	
	
	public boolean validarMensagemDeSucesso(String firstName, String lastName) { 
		
		
		if(mensagemRegistroComSucesso.getText().contains("Dear " + firstName + " " + lastName))
			return true;
		else
			return false;
	}
}