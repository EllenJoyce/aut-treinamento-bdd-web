package curso.treinamento.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import cucumber.deps.com.thoughtworks.xstream.converters.basic.StringBufferConverter;
import curso.treinamento.pages.LoginPage;
import curso.treinamento.pages.RegisterPage;
import curso.treinamento.setup.Hooks;

public class RegistroSteps {
	
	private LoginPage  loginPage = new LoginPage(Hooks.getDriver());
	private RegisterPage registerPage = new RegisterPage(Hooks.getDriver());
	
	String firstName, lastName;
	
		
	@Dado("^que eu esteja  na tela de registro$")
    public void queEuEstejaNaTelaDeRegistro() throws Throwable {
			Assert.assertTrue("Página Login não apresentada.", loginPage.checkPage());
			
			loginPage.clickRegister();
			
			Assert.assertTrue("Página Register não apresentada.", registerPage.checkPage());
		
	}


	@Quando("^faço o preenchimento das informações da tela de Register$")
	public void facoOPreenchimentoDasInformaçõesDaTelaDeRegister(DataTable dataTable) throws Throwable {
	    
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
		
		firstName = list.get(0).get("First Name").toString();
		lastName = list.get(0).get("Last name").toString();
		
		registerPage.preencherContactInformation(list.get(0).get("First Name"),  list.get(0).get("Last name"), 
				list.get(0).get("Phone"), list.get(0).get("Email"));
		
		registerPage.preencherMailingInformation(list.get(0).get("Address"), list.get(0).get("Address Complement"), list.get(0).get("City"), 
				list.get(0).get("State Province"), list.get(0).get("Postal code"), list.get(0).get("Country"));
		
		registerPage.preencherUserInformation(list.get(0).get("User name"), list.get(0).get("Password"), list.get(0).get("Confirm password"));
		
		registerPage.clicarBotaoSubmit();
	}

	@Então("^sou registrado com sucesso$")
	public void souRegistradoComSucesso() {
		
		Assert.assertTrue("Registro não foi realizado com sucesso.", registerPage.validarMensagemDeSucesso(firstName, lastName));	
	
	}
}