@sprint2
Feature: Como jogador de baralho
Quero poder validar meu Deck de cartas
De modo que possa usufruir durante meus jogos

   Scenario: [SUCESSO] Embaralhar as cartas e validar baralho
		Given um novo baralho
		Then valido que a API retornou sucesso
		When embaralho o deck de cartas
		Then valido que a API retornou sucesso
		Then obtenho o "tempo de execucao"
		And valido "shuffled" igual a "true"
		And valido "success" igual a "true"
		And valido "remaining" igual a "52"
		Then obtenho o "deck_id"
  
  Scenario: [SUCESSO] Embaralhar as cartas e validar baralho
		Given um baralho com deck_id = "new"
		Then valido que a API retornou sucesso
		When embaralho o deck de cartas
		Then valido que a API retornou sucesso
		Then obtenho o "tempo de execucao"
		And valido "shuffled" igual a "true"
		And valido "success" igual a "true"
		And valido "remaining" igual a "52"
		Then obtenho o "deck_id"

  Scenario: [FALHA] Embaralhar as cartas e validar informacoes erradas no baralho
		Given um baralho com deck_id = "new"
		Then valido que a API retornou sucesso
		When embaralho o deck de cartas
		Then valido que a API retornou sucesso
		And valido "remaining" igual a "50"
		
	Scenario: [SUCESSO] Pegar uma carta de um baralho existente
		Given um baralho com deck_id = "mmkvopq1y3zx"
		Then valido que a API retornou sucesso
		When pego "2" carta
		Then valido que a API retornou sucesso
		
	Scenario: [SUCESSO] Pegar uma carta de um novo baralho
		Given um baralho com deck_id = "new"
		Then valido que a API retornou sucesso
		When pego "1" carta
		Then valido que a API retornou sucesso

	Scenario: [SUCESSO] Pegar duas cartas de um baralho existente
		Given um baralho com deck_id = "new"
		Then valido que a API retornou sucesso
		When pego "3" carta
		Then valido que a API retornou sucesso		