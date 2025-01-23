package Teste;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("========================================");
            System.out.println("---Bem Vindo(a) ao BarberShopJava---");
            System.out.println("========================================");
            System.out.print("Entre com o número 1 - Usuário, 2 - Administrador -> ");

            int escolhaUser = -1;

            try {
                escolhaUser = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção Inválida!");
                System.exit(0);
            }

            if (escolhaUser == 1) {
                System.out.println("Usuário Liberado.");
                System.out.println("========================================");
                while(true){
                    System.out.println(" 1. Cadastrar-se \n 2. Agendar um Horário \n 3. Cancelar Agendamento \n 4. Sair");
                    System.out.print("Escolha uma Opção : ");
                    int escolhaServicoUser = -1;
                    try {
                        escolhaServicoUser = input.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida! Por favor, digite um número.");
                        input.nextLine();
                        continue;
                    }

                    if (escolhaServicoUser == 1) {
                        // Cadastrar-se interface
                        System.out.println("Cadastrando-se...");
                    } else if (escolhaServicoUser == 2) {
                        // Agendar Horário Interface
                        System.out.println("Agendando horário...");
                    } else if (escolhaServicoUser == 3) {
                        // Cancelar Agendamento
                        System.out.println("Cancelando agendamento...");
                    } else if (escolhaServicoUser == 4) {
                        System.out.println("Obrigado(a) por usar o BarberShopJava!");
                        break;
                    } else {
                        System.out.println("Por favor, Escolha uma opção válida");
                    }
                }
            } else if (escolhaUser == 2) {
                final int NUMERO_CONTA_ADMIN = 12345;
                final int PIN_CONTA_ADMIN = 123;
                try {
                    System.out.print("Entre com o Número da Conta -> ");
                    int inputNumeroConta = input.nextInt();

                    System.out.print("Entre com o PIN da Conta -> ");
                    int inputPinConta = input.nextInt();

                    if (inputNumeroConta != NUMERO_CONTA_ADMIN || inputPinConta != PIN_CONTA_ADMIN) {
                        System.out.println("Número da conta ou PIN incorretos. Acesso negado.");
                        System.exit(0);
                    }

                    System.out.println("Liberado como Administrador.");
                    System.out.println("========================================");
                    while (true){
                        System.out.println(" 1. Listar Clientes \n 2. Excluir Cliente \n 3. Procurar Cliente \n 4. Sair");
                        System.out.print("Escolha uma Opção : ");
                        int escolhaServicoAdmin = -1;
                        try{
                            escolhaServicoAdmin = input.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Entrada inválida! Por favor, digite um número.");
                            input.nextLine();
                            continue;
                        }
                        if (escolhaServicoAdmin == 1) {
                            // Listando Cliente Interaface
                            System.out.println("Listando Cliente...");
                        } else if (escolhaServicoAdmin == 2) {
                            // Excluindo Cliente interface
                            System.out.println("Excluindo Cliente...");
                        } else if (escolhaServicoAdmin == 3) {
                            // Procurar Cliente
                            System.out.println("Procurar Cliente...");
                        } else if (escolhaServicoAdmin == 4) {
                            System.out.println("Obrigado(a) por usar o BarberShopJava!");
                            break;
                        } else {
                            System.out.println("Por favor, Escolha uma opção válida");
                        }
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Acesso negado.");
                    System.exit(0);
                }

            } else {
                System.out.println("Opção Inválida!");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}

