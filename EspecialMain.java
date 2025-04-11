package banco;

import java.util.Random;
import java.util.Scanner;

public class EspecialMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int id = 1000000 + random.nextInt(9000000);

        System.out.print("Digite o nome do dono da conta: ");
        String dono = scanner.nextLine();

        System.out.print("Digite o tipo da conta (CC/CP/PLATINUM/GOLD/SILVER): ");
        String tipo = scanner.nextLine().toUpperCase();

        ContaBanco conta;

        if (tipo.equals("PLATINUM") || tipo.equals("GOLD") || tipo.equals("SILVER")) {
            conta = new ClienteEspecial(id, dono, tipo);
        } else {
            conta = new ContaBanco(id, dono, tipo);
        }

        conta.abrirConta();

        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Verificar saldo");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para depósito: ");
                    double valorDep = Double.parseDouble(scanner.nextLine());
                    conta.depositar(valorDep);
                    break;
                case 2:
                    System.out.print("Digite o valor para saque: ");
                    double valorSaq = Double.parseDouble(scanner.nextLine());
                    conta.sacar(valorSaq);
                    break;
                case 3:
                    System.out.println("Saldo atual: R$" + conta.getSaldo());
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }
}