package com.automation.APIRest.page;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import com.automation.livelo.utils.log.APILogger;

import io.restassured.response.Response;

public class InteracaoRequisicaoPage extends APILogger {

	public Response getResponse(String deck, String url) {
		APILogger.logMethod("Obtendo baralho...");
		
		Response baralho = given().when().get(obterRequisicao(url, deck));
		baralho.prettyPrint();

		return baralho;
	}
	
	public Response getResponseNovoBaralho(String url) {
		APILogger.logMethod("Obtendo baralho...");
		url = String.format(url + "/new");
		Response baralho = given().when().get(obterRequisicao(url));
		baralho.prettyPrint();

		return baralho;
	}

	public Response embaralhar(Response baralho, String url) {
		APILogger.logMethod("Embaralhando...");
	
		Response deckEmbaralhado = given().when().get(obterRequisicao(url, obterDeckId(baralho), "/shuffle"));
		deckEmbaralhado.prettyPrint();

		return deckEmbaralhado;
	}

	public String obterRequisicao(String... params) {
		APILogger.logMethod();
		String requisicao = "";

		for (String valor : params) {
			requisicao += String.format(valor);
		}

		return requisicao;
	}

	public String obterDeckId(Response baralho) {
		APILogger.logMethod();
		return obterValorDeElementoJsonPorChave(baralho, "deck_id");
	}

	public String obterValorDeElementoJsonPorChave(Response baralho, String elemento) {
		APILogger.logMethod();
		String valorObtido = baralho.body().jsonPath().get(elemento).toString();
		APILogger.info("\n%s: %s\n", elemento, valorObtido);
		return valorObtido;
	}

	public boolean validarStatus(int statusObtido, int statusEsperado) throws Throwable {
		APILogger.logMethod();

		if (!(statusObtido == statusEsperado))
			throw new Throwable("\nA api retornou status " + statusObtido + ", esperado " + statusEsperado);

		APILogger.info("A API retornou o status esperado");
		return true;
	}

	public void validarTempoDeExecucao(Response baralho) {
		APILogger.logMethod();
		System.out.printf("Tempo de execucão: %s segundo(s)\n", baralho.getTimeIn(TimeUnit.SECONDS));
	}

	public void validarValorDeElementoJsonPorChave(Response baralho, String chave, String valorEsperado)
			throws Throwable {
		APILogger.logMethod();
		String valorObtido = baralho.body().jsonPath().get(chave).toString();

		if (!valorObtido.equals(valorEsperado))
			throw new Throwable(
					"Elemento" + chave + " possui valor " + valorObtido + "e o esperado era " + valorEsperado);

		APILogger.info("Elemento [%s] possui valor esperado [%s]\n", chave, valorObtido);
	}

	public boolean validarIguais(String valorEsperado, String valorObtido) throws Throwable {
		APILogger.logMethod();

		if (!(valorObtido.equals(valorEsperado)))
			throw new Throwable("Valores diferentes!");

		return true;
	}

	public Response drawCard(Response baralho, String url, String qtde) {
		APILogger.logMethod("Pegando carta...");
		Response deckAposPegarCarta = given().queryParam("count", qtde).when().get(obterRequisicao(url, obterDeckId(baralho), "/draw"));
				
		deckAposPegarCarta.prettyPrint();

		return deckAposPegarCarta;
	}

	
}
