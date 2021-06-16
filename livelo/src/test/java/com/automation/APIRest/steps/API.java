package com.automation.APIRest.steps;

import com.automation.APIRest.page.InteracaoRequisicaoPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class API extends InteracaoRequisicaoPage {

	String url = "https://deckofcardsapi.com/api/deck/";
	Response baralho;

	/**
	 * Obtém um baralho partindo de um deck novo ou de um existente.
	 * 
	 * @param deck_id Id do deck existente ou "new" para um novo deck
	 */
	@Given("um baralho com deck_id = {string}")
	public void obterBaralhoAtravesDoDeck(String deck) {
		this.baralho = getResponse(deck, url);
	}

	@Given("um novo baralho")
	public void obterNovoBaralho() {
		this.baralho = getResponseNovoBaralho(url);
	}

	
	@Given("embaralho o deck de cartas")
	public void embaralharDeckDeCartas() {
		this.baralho = (embaralhar(baralho, url));
	}

	@Then("valido que a API retornou sucesso")
	public void validarSucessoDaApi() throws Throwable {
		int status = baralho.getStatusCode();
		validarStatus(status, 200);
	}

	@Then("obtenho o {string}")
	public void obterValor(String opcao) {
		switch (opcao) {
		case ("tempo de execucao"):
			validarTempoDeExecucao(baralho);
			break;
		case ("deck_id"):
			obterDeckId(baralho);
			break;
		default:
			throw new NullPointerException("Opcao nao definida no metodo obterValor.");
		}
	}

	@Then("valido {string} igual a {string}")
	public void validoIgualA(String chave, String valorEsperado) throws Throwable {
		String valorObtido = baralho.body().jsonPath().get(chave).toString();
		validarIguais(valorEsperado, valorObtido);
	}

	@When("pego {string} carta")
	public void pegoUmaCarta(String qtde) {
		this.baralho = (drawCard(baralho, url, qtde));
	}

}
