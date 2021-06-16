package com.automation.livelo.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;

import com.automation.livelo.elementos.MainPageElementos;
import com.automation.livelo.interfaces.IFrame;
import com.automation.livelo.utils.Main;
import com.automation.livelo.utils.ReportTest;
import com.relevantcodes.extentreports.LogStatus;

public class MainPage extends Main implements IFrame {

	public void acessarSistema() {

		try {
			abrirLink("https://www.livelo.com.br/");
			esperarElementoSerVisivel(MainPageElementos.CHATBOX, 60);
			ReportTest.setLogStatus(LogStatus.PASS, "Acessando site da Livelo");
		} catch (Exception e) {
			ReportTest.setLogStatus(LogStatus.FAIL, "Acessando site da Livelo");
		}

	}

	public void realizarPesquia(String produto) {
		try {
			By btnBuscar = MainPageElementos.BTN_PESQUISAR;
			By nomeDoCampo;
			nomeDoCampo = MainPageElementos.CAMPO_PESQUISAR;
			escrever(nomeDoCampo, produto);
			clicar(btnBuscar);
			ReportTest.setLogStatus(LogStatus.PASS, "Pesquisar Produto");

		} catch (Exception e) {
			ReportTest.setLogStatus(LogStatus.FAIL, "Pesquisar Produto");
		}
	}

	public void fecharbrowser() {

		ReportTest.endRelatorio();
		fecharLink();

	}

	public void autorizarCookies() {
		try {
			By botao = MainPageElementos.BTN_AUTORIZAR_COOKIES;
			esperarElementoSerVisivel(botao, 60);
			clicar(botao);
			ReportTest.setLogStatus(LogStatus.PASS, "Autorizando cookies");
		} catch (Exception e) {
			ReportTest.setLogStatus(LogStatus.FAIL, "Autorizando cookies");
		}

	}

	public void fecharAlerta(String mensagem) {
		switch (mensagem) {
		case "Fique por dentro das nossas novidades":
			By botao = MainPageElementos.DIV_ALERTA_NOTIF;
			if (validarSeElementoExiste(botao)) {
				fecharAlertaNotificacoes(botao);
				ReportTest.setLogStatus(LogStatus.PASS, "Fechar Notificação");
			} else {
				System.out.printf("\nElemento [%s] não existe.", botao.toString());
				ReportTest.setLogStatus(LogStatus.FAIL, "Fechar Notificação");
			}

			break;
		}
	}

	private void fecharAlertaNotificacoes(By botao) {
		try {
			esperarElementoSerVisivel(botao, 30);
			clicar(MainPageElementos.BTN_GO_NOTIFICATION_ALERT);
			ReportTest.setLogStatus(LogStatus.PASS, "Fechando alerta de notificações");
		} catch (Exception e) {
			ReportTest.setLogStatus(LogStatus.FAIL, "Fechando alerta de notificações");
		}

	}

	public void acessarMenu(String... ordemDeMenus) {
		try {
			switch (ordemDeMenus[0]) {

			case "Use seus pontos":
				validarSeElementoExiste(MainPageElementos.MENU_USE_SEUS_PONTOS);
				clicar(MainPageElementos.MENU_USE_SEUS_PONTOS);

				switch (ordemDeMenus[1]) {
				case "Com produtos":
					validarSeElementoExiste(MainPageElementos.MENU_COM_PRODUTOS);
					clicar(MainPageElementos.MENU_COM_PRODUTOS);

					switch (ordemDeMenus[2]) {
					case "Casa":
						validarSeElementoExiste(MainPageElementos.MENU_CASA);
						clicar(MainPageElementos.MENU_CASA);
						return;

					}

				}

			}
			ReportTest.setLogStatus(LogStatus.PASS, "Acessar Menu Use seus pontos > Com Produtos > Casa");
		} catch (Exception e) {
			ReportTest.setLogStatus(LogStatus.FAIL, "Acessar Menu Use seus pontos > Com Produtos > Casa");
		}

	}

	public void clicarNoProdutoPorNome(String nomeDoProduto) {
		try {
			System.out.printf("\nClicando no produto [%s].", nomeDoProduto);

			esperarElementoSerVisivel(MainPageElementos.CHAT_LIVELO_LOGO, 60);

			String produtoAtributo = String.format("//*[text()='%s']/ancestor::div[@class='product-list__element']",
					nomeDoProduto);
			By produto = By.xpath(produtoAtributo);
			esperarElementoSerVisivel(produto, 60);
			clicar(produto);
			ReportTest.setLogStatus(LogStatus.PASS, "Selecionar produto");
		} catch (Exception e) {
			ReportTest.setLogStatus(LogStatus.FAIL, "Selecionar produto");
		}

	}

	public void validarProduto(String nome, String tipo) {
		esperarElementoSerVisivel(MainPageElementos.TITULO, 60);
		String titulo = obterTexto(MainPageElementos.TITULO);
		String tipoObtido = obterTexto(MainPageElementos.TIPO_DE_PRODUTO);

		System.out.printf("Titulo do produto obtido: [%s] Tipo do produto obtido: [%s]", titulo, tipoObtido);

		try {
			if (titulo.equals(nome))
				System.out.printf("\nO produto desejado [%s] está sendo mostrado", nome);

			if (tipo.equals(tipoObtido))
				System.out.printf("\nO produto [%s] pertence ao tipo [%s]", titulo, tipoObtido);

			ReportTest.setLogStatus(LogStatus.PASS, "Validar Produto");

		} catch (Exception e) {
			ReportTest.setLogStatus(LogStatus.FAIL, "Validar Produto");
		}

	}

	public void removerProdutoDoCarrinho(String nomeDoProduto) {
		try {
			String produtoAtributo = String.format(
					"//*[text()='%s']/following::a[@class=\"cart-list__remove-item cart-list__remove-item--padding-left body-text body-text--small\"]",
					nomeDoProduto);
			By produto = By.xpath(produtoAtributo);
			esperarElementoSerVisivel(produto, 60);
			clicar(produto);
			ReportTest.setLogStatus(LogStatus.PASS, "Remover produto do carrinho");

		} catch (Exception e) {
			ReportTest.setLogStatus(LogStatus.FAIL, "Remover produto do carrinho");
		}
	}

	public void preencherOCampoComOValor(String campo, String valor) throws InterruptedException {
		try {
			By btnBuscar = MainPageElementos.BTN_BUSCAR_CEP;
			By nomeDoCampo;
			switch (campo) {
			case "CEP":
				nomeDoCampo = MainPageElementos.CAMPO_CEP;
				escrever(nomeDoCampo, valor);
				clicar(btnBuscar);
				break;
			default:
				System.out.println("O campo nao foi definido no metodo preencherOCampoComOValor.");
			}
			ReportTest.setLogStatus(LogStatus.PASS, "Remover produto do carrinho");

		} catch (Exception e) {
			ReportTest.setLogStatus(LogStatus.FAIL, "Remover produto do carrinho");
		}

	}

	public void adicionarAoCarrinho() {
		try {
			esperarElementoSerVisivel(MainPageElementos.BTN_ADICIONAR_CARRINHO, 60);
			clicar(MainPageElementos.BTN_ADICIONAR_CARRINHO);

			esperarElementoSerVisivel(MainPageElementos.TITULO_CARRINHO, 60);
			String titulo = obterTexto(MainPageElementos.TITULO_CARRINHO);
			assertEquals(titulo, "Seu carrinho");
			ReportTest.setLogStatus(LogStatus.PASS, "Adicionando produto ao carrinho");
		} catch (Exception e) {
			ReportTest.setLogStatus(LogStatus.FAIL, "Adicionando produto ao carrinho");
		}

	}

	public void validarCarrinhoVazio() {
		esperarElementoSerVisivel(MainPageElementos.TX_CARRINHO_VAZIO, 60);
		try {
			String texto = obterTexto(MainPageElementos.TX_CARRINHO_VAZIO);
			assertEquals(texto, "Ainda não existem itens no seu carrinho");
			ReportTest.setLogStatus(LogStatus.PASS, "Validar carrinho vazio");
		} catch (Exception e) {
			ReportTest.setLogStatus(LogStatus.FAIL, "Validar carrinho vazio");
		}

	}

	public void home() {
		try {
			esperarElementoSerVisivel(MainPageElementos.IMG_HOME, 60);
			clicar(MainPageElementos.IMG_HOME);
			ReportTest.setLogStatus(LogStatus.PASS, "Validar carrinho vazio");
		} catch (Exception e) {
			ReportTest.setLogStatus(LogStatus.FAIL, "Validar carrinho vazio");
		}

	}

	public void validarQuantidadeDeProdutos() {
		try {
			home();
			esperarElementoSerVisivel(MainPageElementos.VLR_CARRINHO, 60);
			String valorCarrinho = obterTexto(MainPageElementos.VLR_CARRINHO);
			assertEquals(valorCarrinho, "3");
			ReportTest.setLogStatus(LogStatus.PASS, "Validar carrinho vazio");
		} catch (Exception e) {
			ReportTest.setLogStatus(LogStatus.FAIL, "Validar carrinho vazio");
		}

	}

}
