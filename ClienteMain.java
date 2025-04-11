package banco;

import java.util.Random;
import java.util.Scanner;

public class ClienteMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int id = 1000000 + random.nextInt(9000000);

        System.out.print("Digite o nome do dono da conta: ");
        String dono = scanner.nextLine();

        System.out.print("Digite o tipo da conta (CC/CP): ");
        String tipo = scanner.nextLine().toUpperCase();

        ContaBanco conta = new ContaBanco(id, dono, tipo);
        conta.abrirConta();

        System.out.println();
        conta.status();

        System.out.print("\nDigite o valor para depósito: ");
        double valorDeposito = Double.parseDouble(scanner.nextLine());
        conta.depositar(valorDeposito);
        System.out.println("Saldo atual R$" + conta.getSaldo());

        boolean saqueRealizado = false;
        while (!saqueRealizado) {
            System.out.print("\nDigite o valor para saque: ");
            double valorSaque = Double.parseDouble(scanner.nextLine());

            if (conta.getSaldo() >= valorSaque) {
                conta.sacar(valorSaque);
                saqueRealizado = true;
            } else {
                System.out.println("Saldo insuficiente para saque.");
                System.out.print("Deseja tentar um novo valor? (s/n): ");
                String resposta = scanner.nextLine().toLowerCase();
                if (!resposta.equals("s")) {
                    System.out.println("Operação de saque cancelada.");
                    break;
                }
            }
        }

        conta.pagarMensalidade();

        System.out.println();
        System.out.println(conta);

        scanner.close();
    }
}

