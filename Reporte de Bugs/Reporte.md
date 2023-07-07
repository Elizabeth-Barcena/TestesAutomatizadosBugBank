# Reporte de BUGS
Bug encontrados nos testes manuais

|ID | Teste    | Resultado esperado  |    BUG |
|---|----------|--|--------|
| 2 |Criar um usuário sem o campo email |  O sistema não deve criar usuário e deve mostrar a mensagem "Email não pode ser vazio" | :x: Sistema não retorna a mensagem "Email não pode ser vazio"
| 4 |Criar um usuário com campo senha vazia |  O sistema não deve criar usuário e deve mostrar a mensagem "Senha não pode ser vazio" |:x: Sistema não retorna a mensagem "Senha não pode ser vazio"
| 5 |Criar um usuário com campo senha de confirmação em branco | O sistema não deve criar usuário e deve mostrar a mensagem "Confirmar senha não pode ser vazio" | :x: Sistema não retorna a mensagem "Senha de confirmação não pode ser vazio"
| 11 |Cadastrar com um email valido e por espaço " " em todos os outros campos | O sistema não deve permitir o cadastro do usuário | :x: O sistema está permitindo cadastro com campos em branco como nome, senha e confirmação de senha
| 12 |Cadastrar conta com email que ja existe | O sistema não deve permitir conta já existente | :x: O sistema está permitindo cadastro de conta que já existe
| 18 |Fazer transferência para uma conta válida  | O sistema deve fazer a transferencia corretamente e enviar a mensagem "Transferência realizada com sucesso" e redirecionar o usuário a página de extrato |:x: O sistema não redireciona o usuário a página de extrato
| 25  | Fazer a transferência com o campo descrição vazio | O sistema não pode aceitar o campo descrição vazio |:x: Quando é realizado uma transferencia o sistema o campo descrição não pode ser vazio e usuário deve ser avisado 
| 26 |Entrar na página de transferência, deixar o número da conta em branco e fazer a transferência | O sistema não pode permitir nenhum campo da página de transferência vazia | :x: O sistema aceita transferir dinheiro com o campo número de conta vazio
| 27 |Entrar na página de transferências e digitar o múmero de uma conta válida em o digito final | O sistema não deve aceitar uma transferência sem o digito final | :x: Ao enviar uma transferencia para uma conta válida sem o último digito o sistema envia o dinheiro mesmo assim
| 43 |Entrar na página de login e clicar no botão voltar | Botão deve voltar a página de login | :x: Flecha do botão voltar não funciona
| 45 |Diminuir a tela de cadastro | As divs não podem se sobrepor | :x: A div superior da tela de cadastro estra sobrepondo o espaços dos campos de cadastro
