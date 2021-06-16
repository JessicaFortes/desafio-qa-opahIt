package com.automation.livelo.elementos;

import org.openqa.selenium.By;

import com.automation.livelo.interfaces.Elementos;

public class MainPageElementos implements Elementos {

	public static final By BTN_CLOSE_NOTIFICATION_ALERT = By.id("btClose");
	public static final By BTN_GO_NOTIFICATION_ALERT = By.id("btGo");
	public static final By DIV_ALERTA_NOTIF = By.id("sm-push");
	public static final By CHATBOX = By.id("lv-chatbox-body-messages");
	public static final By BTN_AUTORIZAR_COOKIES = By.id("btn-authorizeCoookies");
	public static final By FRAME_ALERTA_NOTIF = By.id("social-push");	
	public static final By MENU_USE_SEUS_PONTOS =  By.id("span-first-level-menu-1");
	public static final By MENU_COM_PRODUTOS =  By.id("span-second-level-menu-1-1");
	public static final By MENU_CASA = By.id("span-third-level-menu-1-1-1");
	public static final By MENU_ELETROPORTATEIS = By.id("span-fourth-level-menu-1-1-1-1");
	public static final By TITULO = By.xpath("//*[@id=\"wi4300078-product-header-info-catalog-id\"]/div/h2");
	public static final By TIPO_DE_PRODUTO = By.xpath("//*[@id=\"breadcrumbTrail\"]/a[2]");
	public static final By CHAT_LIVELO_LOGO = By.id("chat-livelo-logo");
	public static final By CAMPO_CEP = By.id("inpt-cep__pdp");
	public static final By BTN_BUSCAR_CEP = By.xpath("//*[@id='wi4300078-product-filter-box-catalog-id']//span[text()='Buscar']");
	public static final By BTN_ADICIONAR_CARRINHO = By.xpath("//*[@id=\"CC-prodDetails-addToCart\"]/button");
	public static final By TITULO_CARRINHO = By.xpath("//*[@id=\"CC-cart-list\"]/div[1]/h1");
	public static final By TX_CARRINHO_VAZIO = By.xpath("//*[@id=\"CC-cart-empty\"]/div/h2");
	public static final By IMG_HOME = By.xpath("//*[@id=\"custom-checkout-header-points_v1-wi2000036\"]/header/div/div/div[1]/div[1]/a/img");
	public static final By VLR_CARRINHO = By.id("span-ball-cart");
	public static final By CAMPO_PESQUISAR = By.id("input-search");
	public static final By BTN_PESQUISAR = By.id("span-searchIcon");



}
