package com.automation.livelo.steps;

import java.util.Map;

import com.automation.livelo.pages.MainPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LiveloSteps extends MainPage {

	public LiveloSteps() {
	}


	@Given("usuario no site da Livelo")
	@When("acessar o site da Livelo")
	public void usuarioNoSiteDaLivelo() throws Throwable {
		acessarSistema();

	}

	@When("usuario autorizar o uso de cookies")
	@When("autorizar o uso de cookies")
	public void autorizarUsoDeCookies() throws Throwable {
		autorizarCookies();
	}

	@When("aparecer a mensagem {string} clicar em fechar")
	public void aparecerMensagemEClicarEmFechar(String mensagem) throws Throwable {
		fecharAlerta(mensagem);
	}

	@When("^acessar o menu \\\"(.*?)\\\"$")
	public void acessarOMenu(String listaDeMenus) throws Throwable {
		acessarMenu(listaDeMenus.split("\" -> \""));
	}

	@When("clicar no produto {string}")
	public void clicarNoProduto(String nomeDoProduto) throws Throwable {
		clicarNoProdutoPorNome(nomeDoProduto);
	}

	@Then("o sistema abrira a pagina do produto:")
	public void oSistemaAbriraAPaginaDoProduto(DataTable arg1) throws Throwable {
		Map<Object, Object> m = arg1.asMaps(String.class, String.class).get(0);
		String nome, tipo;
		nome = m.get("Nome").toString();
		tipo = m.get("Tipo").toString();
		validarProduto(nome, tipo);
	}

	@When("preencher o campo {string} com o valor {string}")
	public void preencherCampo(String campo, String valor) throws InterruptedException {
		preencherOCampoComOValor(campo, valor);
	}

	@When("adicionar produto no carrinho")
	public void adicionarNoCarrinho() {
		adicionarAoCarrinho();
	}

	@When("clicar em remover o procuto {string} do carrinho")
	public void removerProcutoDoCarrinho(String produto) throws Throwable {
		removerProdutoDoCarrinho(produto);
	}

	@Then("valido que nao existe itens no carrinho")
	public void carrinhoVazio() {
		validarCarrinhoVazio();

	}

	@When("voltar para home")
	public void voltarParaHome() throws Throwable {
		home();
	}
	
	@Then("valido quantidade de itens no carrinho")
	public void valido_quantidade_de_itens_no_carrinho() {
	    validarQuantidadeDeProdutos();
	}
	
	@When("pesquisar pelo produto {string}")
	public void pesquisarPorProduto(String produto) throws InterruptedException {
		realizarPesquia(produto);;
	}



}
