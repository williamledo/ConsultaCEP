package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.api.consulta.DTO.Cep;
import com.api.consulta.DTO.EnderecoDTO;
import com.api.consulta.controllers.EnderecoController;
import static org.junit.jupiter.api.Assertions.*;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.internal.common.assertion.Assertion;

public class StepsEndereco {

	private Cep cepValido;
	private Cep cepInvalido;
    ResponseEntity response;
	
    @Autowired
    private EnderecoController controller = new EnderecoController();
	
	@Dado("que eu tenho um CEP válido")
	public void que_eu_tenho_um_cep_válido() {

		cepValido =  new Cep("54100020");
		
	}

	@Quando("eu fizer a requisição para consultar o endereço")
	public void eu_fizer_a_requisição_para_consultar_o_endereço() throws Exception {
	    
		response = controller.consultar(cepValido);
		
	}

	@Então("eu deveria receber um response com status code e o endereço completo")
	public void eu_deveria_receber_um_response_com_status_code_e_o_endereço_completo() {

		assertEquals(200, response.getStatusCode().value());
        assertEquals(response.getBody().getClass(), EnderecoDTO.class);
		
	}

	
	
	@Dado("que eu tenho um CEP inválido")
	public void que_eu_tenho_um_cep_inválido() {

		cepInvalido =  new Cep("11111111");
		
	}

	@Então("eu deveria receber um response com status code {int} e a mensagem {string}")
	public void eu_deveria_receber_um_response_com_status_code_e_a_mensagem(Integer int1, String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}
