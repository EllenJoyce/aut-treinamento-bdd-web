package curso.treinamento.steps;

import java.util.List;
import java.util.Map;

import javax.swing.JSpinner.ListEditor;
import javax.xml.xpath.XPath;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class RegistroSteps {

	WebDriver driver;

	@Dado("^que eu esteja  na tela de registro$")
	public void que_eu_esteja_na_tela_de_registro() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://newtours.demoaut.com/");

		driver.findElement(By.linkText("REGISTER")).click();

		Assert.assertTrue("Página'Resgiter' Não apresentada com sucesso",
				driver.findElement(By.xpath("//img[@src='/images/masts/mast_register.gif']")).isDisplayed());

	}

	@Quando("^faço o preenchimento das informações da tela de Register$")
	public void faço_o_preenchimento_das_informações_da_tela_de_Register(DataTable dataTable) throws Throwable {

		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);

		driver.findElement(By.name("firstName")).sendKeys(list.get(0).get("First Name"));

		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(list.get(0).get("Last name"));

		driver.findElement(By.name("phone")).sendKeys(list.get(0).get("Phone"));

		driver.findElement(By.id("userName")).sendKeys(list.get(0).get("Email"));

		driver.findElement(By.name("address1")).sendKeys(list.get(0).get("Address"));

		driver.findElement(By.name("address2")).sendKeys(list.get(0).get("Address Complement"));

		driver.findElement(By.name("city")).sendKeys(list.get(0).get("City"));

		driver.findElement(By.name("state")).sendKeys(list.get(0).get("State Province"));

		driver.findElement(By.name("postalCode")).sendKeys(list.get(0).get("Postal code"));

		new Select(driver.findElement(By.name("country"))).selectByVisibleText(list.get(0).get("Country"));

		driver.findElement(By.id("email")).sendKeys(list.get(0).get("User name"));

		driver.findElement(By.name("password")).sendKeys(list.get(0).get("Password"));

		driver.findElement(By.name("confirmPassword")).sendKeys(list.get(0).get("Confirm password"));

		driver.findElement(By.name("register")).click();

	}

	@Então("^sou registrado com sucesso$")
	public void sou_registrado_com_sucesso() throws Throwable {
		String mensagem = driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]"))
				.getText();
		if (mensagem.contains("Ellen Fagundes")) {
			System.out.println("Sou Registrado com sucesso");
		} else {
			throw new Exception("Não cadastrado com sucesso");
		}
		driver.close();

	}

}
