@sprint1
Feature: Cadastrar produtos no carrinho da Livelo

  Background: 
    Given usuario no site da Livelo
    When autorizar o uso de cookies

  Scenario: Cadastrar produtos no carrinho
    When acessar o menu "Use seus pontos" -> "Com produtos" -> "Casa"
    And clicar no produto "Frigideira Brinox Garlic 7001/355 Vermelha - 24 cm"
    Then o sistema abrira a pagina do produto:
      | Nome                                               | Tipo |
      | Frigideira Brinox Garlic 7001/355 Vermelha - 24 cm | Casa |
    When preencher o campo "CEP" com o valor "40421560"
    And adicionar produto no carrinho
    And voltar para home
    When acessar o menu "Use seus pontos" -> "Com produtos" -> "Casa"
    And clicar no produto "Omeleteira Brinox Garlic Grafite - 14cm"
    Then o sistema abrira a pagina do produto:
      | Nome                                    | Tipo |
      | Omeleteira Brinox Garlic Grafite - 14cm | Casa |
    When preencher o campo "CEP" com o valor "40421560"
    And adicionar produto no carrinho
    And voltar para home
    When acessar o menu "Use seus pontos" -> "Com produtos" -> "Casa"
    And clicar no produto "Travesseiro Fibrasca Nasa Up3 Visco - Branco"
    Then o sistema abrira a pagina do produto:
      | Nome                                         | Tipo |
      | Travesseiro Fibrasca Nasa Up3 Visco - Branco | Casa |
    When preencher o campo "CEP" com o valor "40421560"
    And adicionar produto no carrinho


  Scenario: Remover produto no carrinho
    When acessar o menu "Use seus pontos" -> "Com produtos" -> "Casa"
    And clicar no produto "Frigideira Brinox Garlic 7001/355 Vermelha - 24 cm"
    When adicionar produto no carrinho
    And clicar em remover o procuto "Frigideira Brinox Garlic 7001/355 Vermelha - 24 cm" do carrinho
    Then valido que nao existe itens no carrinho
