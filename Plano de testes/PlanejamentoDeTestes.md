# Plano de testes

## Introdução
### Propósito do sistema 
 Pensando em uma aplicação que seja semelhante a projetos reais, Bug Bank foi pensado para que os desenvolvedores de teste pratique planejamento de testes e automação de testes.

## Abordagem de testes
### Categorização dos requisitos funcionais
Login 
| ID   | Requisito funcional                                                                                                      |
| ---- | -------------------------------------------------------------------------------------------------------------------------|
| 01   | Email e Senha são campos obrigatórios.                                                                                   |
| 02   | Tentativa de acesso sem preencher campos obrigatórios deve exibir a mensagem "Usuário e senha precisam ser preenchidos". |
| 03   | Não deve autorizar o acesso para usuários inválidos ou não cadastrados.                                                  |
| 04   | Usuários válidos e cadastros são direcionados para a home.                                                               |

Cadastro
| ID   | Requisito funcional                                                                                                      |
| ---- | -------------------------------------------------------------------------------------------------------------------------|
| 05   | Os campos Nome, Email, Senha e Confirmação de senha são de preenchimento obrigatório                                     |
| 06   | Tentativa de cadastro sem preencher nome deve visualizar a mensagem "Nome não pode ser vazio"                            |
| 07   | Tentativa de cadastro sem preencher email deve visualizar a mensagem "Email não pode ser vazio"                          |
| 08   | Tentativa de cadastro sem preencher senha deve visualizar a mensagem "Senha não pode ser vazio"                          |
| 09   | Tentativa de cadastro sem preencher confirmação de senha deve visualizar a mensagem "Confirmar senha não pode ser vazio" |
| 10   | Deixar ativo a opção "Criar conta com saldo" deve criar conta com saldo de R$ 1.000,00                                   |
| 11   | Deixar inativo a opção "Criar conta com saldo" deve criar conta com saldo de R$ 0,00                                     |
| 12   | Senha e confirmação de senha precisam ser iguais                                                                         |
| 13   | Cadastrar conta com sucesso deve exibir número da conta criada                                                           |

Transferência
| ID   | Requisito funcional                                                                                                      |
| ---- | -------------------------------------------------------------------------------------------------------------------------|
| 14   | Só é permitido transferência para contas válidas                                                                         |
| 15   | Só é permitido transferência quando saldo é igual ou maior que valor para transferir                                     |
| 16   | Tentativa de transferência para conta inválida deve exibir mensagem de erro "Conta inválida ou inexistente"              |
| 17   | Número e digito da conta aceitam apenas números                                                                          |
| 18   | Campo descrição é um campo de preenchimento obrigatório                                                                  |
| 19   | Valor de transferência não pode ser igual ou menor que zero                                                              |
| 20   |  Ao realizar transferência com sucesso deve ser debitado o valor da conta e exibir a mensagem de "Transferência realizada com sucesso"|
| 21   |  Ao realizar uma transferência com sucesso deve ser redirecionado para o extrato                                         |

Extrato
| ID   | Requisito funcional                                                                                                      |
| ---- | -------------------------------------------------------------------------------------------------------------------------|
| 22   | Deve exibir o saldo disponível no momento                                                                                |
| 23   | Cada transação deve exibir data que foi realizada, tipo da transação (Abertura de conta / Transferência enviada / Transferência recebida)- Quando valor for de saida da conta deve estar em vermelho e iniciar com o sinal de menos/negativo(-)                              |
| 24   | Quando valor for de entrada na conta deve estar em verde                                                                 |
| 25   | Transações sem comentário devem exibir (-)                                                                               |
## Definição do ambiente de teste
Para executar os testes os seguintes recursos devem ser considerados:

-  Energia elétrica
- Computador 
- Internet estável e com boa conexão

 Possíveis riscos
- Energia elétrica instável

  Possível solução: Obter um nobreak no local da aplicação

- Internet instável

  Possível solução: Obter um modem 4G/5G

- Computador com problemas

  Possível solução: Obter um notebook ou computador reserva

## Programação de testes
### Prioridade de testes
As prioridades dos testes são:
 - Possibilitar o cadastro do usuário
 - Possibilitar o login do usuário
 - Possibilitar que o usuário faça transferências
 - Possibilitar a visualização do extrato do usuário 

 ## Testes Manuais
  Testes de Cadastro

 | ID   | Teste  |     Resultado esperado | Resultado atual|
 | ---- |--------|------------------------|----------------|
 | 01   | Criar um usuário com todos os campos válidos  | Login realizado com sucesso | OK |
 | 02   | Criar um usuário sem o campo email | O sistema não deve criar usuário e deve mostrar a mensagem "Email não pode ser vazio" | BUG
 | 03   | Criar um usuário com campo nome vazio | O sistema não deve criar usuário e enviar a mensagem "Nome não pode ser vazio" | OK
 | 04   | Criar um usuário com campo senha vazia |  O sistema não deve criar usuário e deve mostrar a mensagem "Senha não pode ser vazio" | BUG
 | 05   | Criar um usuário com campo senha de confirmação vazio |  O sistema não deve criar usuário e deve mostrar a mensagem "Confirmar senha não pode ser vazio" | BUG
 | 06   | Criar um usuário com email inválido | O sistema não deve criar o usuário e enviar mensagem "Formato inválido" | OK
 | 07   | Criar um usuário com senha e confirmação de senha diferentes | O sistema não deve criar usuário com senhas diferentes |OK
 | 08   | Criar um usuário com saldo de R$ 1000,00 | O sistema deve aceitar | OK
 | 09   | Criar um usuário sem saldo | O sistema deve aceitar | OK
 | 10   | Cadastrar um usuário com todos os campos válidos e verificar se o sistema retorna o número da conta que foi criada | O sistema deve exibir o número da conta ao terminar de cadastrar | OK
 | 11  | Cadastrar com um email valido e espaço " " em todos os outros campos | O sistema não deve permitir o cadastro do usuário com campo em branco | BUG
 | 12  | Cadastrar conta com email que ja existe | O sistema não deve permitir conta já existente | BUG
 

Testes de Login
| ID   | Teste  |     Resultado esperado | Resultado atual|
| ---- |--------|------------------------|----------------|
| 13   | Fazer login com usuário ja cadastrado | O sistema deve fazer o login corretamente e redirecionar o usuário para a página home  | OK
| 14   | Fazer login com o campo senha incorreto | O sistema não deve aceitar e enviar a mensagem "Usuário ou senha inválido. Tente novamente ou verifique suas informações!" | OK
| 15   | Fazer login com email incorreto  | O sistema não deve aceitar e enviar a mensagem "Usuário ou senha inválido. Tente novamente ou verifique suas informações!"| OK
| 16   |  Fazer login com campo senha vazio | O sistema não deve aceitar e deve mostrar a mensagem "Usuário e senha precisam ser preenchidos" | OK
| 17   |  Fazer login com campo email vazio | O sistema não deve aceitar e deve mostrar a mensagem "Usuário e senha precisam ser preenchidos" | OK

Testes de transferência
| ID   | Teste  |     Resultado esperado | Resultado atual|
| ---- |--------|------------------------|----------------|
| 18   | Fazer transferência para uma conta válida | O sistema deve fazer a transferencia corretamente e enviar a mensagem "Transferência realizada com sucesso" e redirecionar o usuário a página de extrato| BUG
| 19   | Fazer transferência para uma conta invalida | O sistema não deve aceitar e enviar mensagem "Conta inválida ou inexistente" | OK
| 20  | Fazer uma transferência com valor 0 ou negativo | O sistema não deve aceitar e enviar mensagem "Valor da transferência não pode ser 0 ou negativo"| OK
| 21  | Fazer transferência de dinheiro maior que o saldo em conta | O sistema não deve aceitar e enviar mensagem "Você não tem saldo suficiente para essa transação" |OK
| 22  | Fazer transferencia para a própria conta | O sistema não deve aceitar fazer transferencia para a própria conta e enviar mensagem "Nao pode transferir pra mesma conta "| OK
| 23  | Utilizar letras para número da conta | O sistema só pode aceitar números | OK
| 24  | Fazer a transferência com o campo descrição vazio | O sistema não pode aceitar o campo descrição vazio |BUG
| 25  | Entrar na página de transferência, deixar o número da conta em branco e fazer a transferência | O sistema não pode permitir nenhum campo da página de transferência vazia | BUG 
| 26  | Entrar na página de transferências e digitar o número de uma conta válida sem o último digito| O sistema não deve aceitar uma transferencia sem o digito final | BUG

Extrato
| ID   | Teste  |     Resultado esperado | Resultado atual|
| ---- |--------|------------------------|----------------|
| 27   | Entrar na página de extrato e visualizar o saldo | O Saldo deve estar visivel ao usuário e correto | OK
| 28   | Entrar na página de extrato e verificar os dados | Cada transação deve exibir data que foi realizada, tipo da transação (Abertura de conta / Transferência enviada / Transferência recebida)- Quando valor for de saida da conta deve estar em vermelho e iniciar com o sinal de menos/negativo(-)| OK
| 29   | Entrar na página de extrato e ver se o valor das transferencias recebidas estão verde| Quando valor for de entrada na conta deve estar em verde  | OK
| 30 | Entrar na página de extrato e verificar se as transações sem comentarios exibem (-)| Transações sem comentário devem exibir (-) | OK


Botões
| ID   | Teste  |     Resultado esperado | Resultado atual|
| ---- |--------|------------------------|----------------|
| 31 | Ao entrar na página home clicar no botão de extrato | Ao clicar no botão de extrato o sistema deve redirecionar o usuário a página de extrato | OK
| 32 | Ao entrar na página de extrato clicar no botão voltar | Ao clicar no botão voltar o sistema deve redirecionar o usuário a página home | OK
| 33 | Ao entrar na página de extrato clicar no botão sair|  Ao clicar no botão sair o sistema deve fazer o logout do usuário | OK
| 34 | Fazer logout pela página home | O sistema deve fazer o logout corretamente | OK
| 35  | Entrar na pagina home e clicar no botão de transferência | Ao clicar no botão transferência o sistema deve redirecionar o usuário a página de transferências | OK
| 36  | Ao entrar na página de transferência clicar no botão voltar | Ao clicar no botão voltar o sistema deve redirecionar o usuário a página home | OK
| 37  | Ao entrar na página de transferência clicar no botão sair | Ao clicar no botão sair o sistema deve fazer o logout do usuário | OK

Testes de layout
| ID   | Teste  |     Resultado esperado | Resultado atual|
| ---- |--------|------------------------|----------------|
| 38   | Entrar na página home e verificar se os botões aumentam ou mudam de cor ao passar por cima | Ao passar o mouse por cima os botões devem aumentar ou mudar de cor | OK|
| 39 | Entrar na página de transferências e ver se os campos mudam de cor ao selecionar | Os campos da página de transferência devem mudar de cor ao selecionar | OK
| 40 | Entrar na página de extrato e verificar se o scroll rola até o fim das transações | Todas as transações devem ser mostradas | OK
| 41 | Entrar na página de login e clicar na flecha do botão voltar | Botão e flcha deve voltar a página de login | BUG
| 42 | Diminuir a tela de login | As divs não podem se sobrepor | OK
| 43 | Diminuir a tela de cadastro | As divs não podem se sobrepor | BUG
| 44 | Diminuir a página home | As divs não podem se sobrepor | OK


## Testes candidatos a automação
Os testes candidatos a automação são os testes com fluxo de uma conta em um banco como:
 Testes de Cadastro

 | ID   | Teste  |     Resultado esperado |
 | ---- |--------|------------------------|
 | 01   | Criar um usuário com todos os campos válidos  | Login realizado com sucesso | 
 | 02   | Criar um usuário sem o campo email | O sistema não deve criar usuário e deve mostrar a mensagem "Email não pode ser vazio" 
 | 03   | Criar um usuário com campo nome vazio | O sistema não deve criar usuário e enviar a mensagem "Nome não pode ser vazio" | BUG
 | 04   | Criar um usuário com campo senha vazia |  O sistema não deve criar usuário e deve mostrar a mensagem "Senha não pode ser vazio" 
 | 05   | Criar um usuário com campo senha de confirmação vazio |  O sistema não deve criar usuário e deve mostrar a mensagem "Confirmar senha não pode ser vazio" 
 | 06   | Criar um usuário com email inválido | O sistema não deve criar o usuário e enviar mensagem "Formato inválido" 
 | 07   | Criar um usuário com senha e confirmação de senha diferentes | O sistema não deve criar usuário com senhas diferentes 
 | 08   | Criar um usuário com saldo de R$ 1000,00 | O sistema deve aceitar 
 | 09   | Criar um usuário sem saldo | O sistema deve aceitar 
 | 10   | Cadastrar um usuário com todos os campos válidos e verificar se o sistema retorna o número da conta que foi criada | O sistema deve exibir o número da conta ao terminar de cadastrar 
 | 11  | Cadastrar com um email valido e espaço " " em todos os outros campos | O sistema não deve permitir o cadastro do usuário com campo em branco 
 | 12  | Cadastrar conta com email que ja existe | O sistema não deve permitir conta já existente 
 

Testes de Login
| ID   | Teste  |     Resultado esperado | 
| ---- |--------|------------------------|
| 13   | Fazer login com usuário ja cadastrado | O sistema deve fazer o login corretamente e redirecionar o usuário para a página home  
| 14   | Fazer login com o campo senha incorreto | O sistema não deve aceitar e enviar a mensagem "Usuário ou senha inválido. Tente novamente ou verifique suas informações!" 
| 15   | Fazer login com email incorreto  | O sistema não deve aceitar e enviar a mensagem "Usuário ou senha inválido. Tente novamente ou verifique suas informações!"
| 16   |  Fazer login com campo senha vazio | O sistema não deve aceitar e deve mostrar a mensagem "Usuário e senha precisam ser preenchidos" 
| 17   |  Fazer login com campo email vazio | O sistema não deve aceitar e deve mostrar a mensagem "Usuário e senha precisam ser preenchidos" 

Testes de transferência
| ID   | Teste  |     Resultado esperado | 
| ---- |--------|------------------------|
| 18   | Fazer transferência para uma conta válida | O sistema deve fazer a transferencia corretamente e enviar a mensagem "Transferência realizada com sucesso" e redirecionar o usuário a página de extrato
| 19   | Fazer transferência para uma conta invalida | O sistema não deve aceitar e enviar mensagem "Conta inválida ou inexistente" 
| 20  | Fazer uma transferência com valor 0 ou negativo | O sistema não deve aceitar e enviar mensagem "Valor da transferência não pode ser 0 ou negativo"
| 21  | Fazer transferência de dinheiro maior que o saldo em conta | O sistema não deve aceitar e enviar mensagem "Você não tem saldo suficiente para essa transação" 
| 22  | Fazer transferencia para a própria conta | O sistema não deve aceitar fazer transferencia para a própria conta e enviar mensagem "Nao pode transferir pra mesma conta "
| 23  | Utilizar letras para número da conta | O sistema só pode aceitar números 
| 24  | Fazer a transferência com o campo descrição vazio | O sistema não pode aceitar o campo descrição vazio |BUG
| 25  | Entrar na página de transferência, deixar o número da conta em branco e fazer a transferência | O sistema não pode permitir nenhum campo da página de transferência vazia 
| 26  | Entrar na página de transferências e digitar o número de uma conta válida sem o último digito | O sistema não deve aceitar uma transferencia sem o digito final 

Extrato
| ID   | Teste  |     Resultado esperado | 
| ---- |--------|------------------------|
| 27   | Entrar na página de extrato e visualizar o saldo | O Saldo deve estar visivel ao usuário e correto 
| 28   | Entrar na página de extrato e verificar os dados | Cada transação deve exibir data que foi realizada, tipo da transação (Abertura de conta / Transferência enviada / Transferência recebida)- Quando valor for de saida da conta deve estar em vermelho e iniciar com o sinal de menos/negativo(-)
| 29 | Entrar na página de extrato e verificar se as transações sem comentarios exibem (-)| Transações sem comentário devem exibir (-) 


Botões da
| ID   | Teste  |     Resultado esperado |
| ---- |--------|------------------------|
| 30 | Ao entrar na página home clicar no botão de extrato | Ao clicar no botão de extrato o sistema deve redirecionar o usuário a página de extrato 
| 31 | Fazer logout pela página home | O sistema deve fazer o logout corretamente 
| 32  | Entrar na pagina home e clicar no botão de transferência | Ao clicar no botão transferência o sistema deve redirecionar o usuário a página de transferências 