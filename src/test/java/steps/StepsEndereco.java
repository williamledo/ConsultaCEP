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

	private Cep cep;
    private ResponseEntity response;
	
    @Autowired
    private EnderecoController controller = new EnderecoController();
	
    @Dado("que eu tenho um CEP válido")
    public void que_eu_tenho_um_cep_válido() {
    	
    	cep = new Cep("54100020");
    	
    }

    @Quando("eu fizer a requisição para consultar o endereço com um cep válido")
    public void eu_fizer_a_requisição_para_consultar_o_endereço_com_um_cep_válido() throws Exception {

    	response = controller.consultar(cep);
    	
    }

    @Então("eu deveria receber um response com status code {int} e o endereço completo")
    public void eu_deveria_receber_um_response_com_status_code_e_o_endereço_completo(Integer statusCode) {

    	assertEquals(response.getStatusCode().value(), statusCode);
    	assertNotNull(response.getBody());
    	
    }

    @Dado("que eu tenho um CEP inválido")
    public void que_eu_tenho_um_cep_inválido() {

    	cep = new Cep("11111111");
    	
    }

    @Quando("eu fizer a requisição para consultar o endereço com um cep inválido")
    public void eu_fizer_a_requisição_para_consultar_o_endereço_com_um_cep_inválido() throws Exception {
    	
    	response = controller.consultar(cep);
    	
    }

    @Então("eu deveria receber um response com status code {int} e a mensagem {string}")
    public void eu_deveria_receber_um_response_com_status_code_e_a_mensagem(Integer statusCode, String string) {

    	assertEquals(response.getStatusCode().value(), statusCode);
    	assertEquals(response.getBody(), string);
    	assertNotNull(response.getBody());
    	
    }
}
