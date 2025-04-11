# Sistema Bancário em Java

Este é um projeto simples de um sistema bancário feito em Java, com suporte para contas comuns e clientes especiais que recebem um bônus (cheque especial) baseado no tipo da conta.

## Estrutura do Projeto

- `ContaBanco.java` – Classe principal da conta bancária
- `ClienteEspecial.java` – Subclasse com bônus para clientes especiais
- `ClienteMain.java` – Execução do sistema com conta comum
- `EspecialMain.java` – Execução com conta especial e menu interativo

  
## Funcionalidades

- Abertura e fechamento de conta
- Depósito e saque
- Verificação de saldo
- Pagamento de mensalidade
- Menu interativo com Scanner
- Geração automática de ID aleatório com 7 dígitos
- Tipos de conta: `CC` (Conta Corrente), `CP` (Conta Poupança)
  
- Clientes especiais recebem bônus na abertura:
  - Conta Platinum: R$ 5000 de bônus
  - Conta Gold: R$ 3000 de bônus
  - Conta Silver: R$ 1000 de bônus

## Exemplo de Uso

Digite o nome do dono da conta: João
Digite o tipo da conta (CC/CP): CC
Conta bancária aberta com sucesso para João
Saldo atual R$100.0

----- MENU -----
1. Depositar
2. Sacar
3. Verificar saldo
0. Sair
Opção: 1
Digite o valor para depósito: 200
Depósito de R$200.0 realizado com sucesso na conta de João
