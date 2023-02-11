#language:pt

Funcionalidade: Consulta de endereço pelo CEP
  Como usuário, eu quero poder consultar o endereço pelo CEP, de forma que eu possa obter informações sobre o endereço.

Cenário: Consulta de endereço com sucesso
  Dado que eu tenho um CEP válido
  Quando eu fizer a requisição para consultar o endereço com um cep válido
  Então eu deveria receber um response com status code 200 e o endereço completo

Cenário: Consulta de endereço inválido
  Dado que eu tenho um CEP inválido
  Quando eu fizer a requisição para consultar o endereço com um cep inválido
  Então eu deveria receber um response com status code 400 e a mensagem "CEP inválido, verifique e tente novamente"

