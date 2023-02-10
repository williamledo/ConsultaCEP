#language:pt
Funcionalidade: Teste EnderecoController.consultar()
Cenário: Testando a funcionalidade do Controller
Dado recebe um "cep" para fazer a validação
Quando fizer a validação do "cep"
Então vou retornar um ResponseEntity com o corpo da requisição ou a mensagem de erro

