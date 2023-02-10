package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class StepsEndereco {

	WebDriver driver;
	
	@Before
	public void before() {
		driver = new ChromeDriver();
	}
	
	@Dado("recebe um {string} para fazer a validação")
	public void recebe_um_para_fazer_a_validação(String string) {
	    driver.get(string);
	}

	@Quando("fizer a validação do {string}")
	public void fizer_a_validação_do(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Então("vou retornar um ResponseEntity com o corpo da requisição ou a mensagem de erro")
	public void vou_retornar_um_response_entity_com_o_corpo_da_requisição_ou_a_mensagem_de_erro() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}
