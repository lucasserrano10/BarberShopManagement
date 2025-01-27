package Teste;

import Dominio.Agendamento;
import Dominio.BarberShop;
import Dominio.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        List<Agendamento> agendamentos = new ArrayList<>();
        BarberShop barberShop = new BarberShop(clientes, agendamentos);

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("========================================");
            System.out.println("---Bem Vindo(a) ao BarberShopJava---");
            System.out.println("========================================");

            while (true) {  // Loop principal para escolher Usuário ou Administrador
                System.out.print("Entre com o número 1 - Usuário, 2 - Administrador 3 - Sair do Programa -> ");
                int escolhaUser = -1;

                try {
                    escolhaUser = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Opção Inválida!");
                    input.nextLine(); // Limpa o buffer do scanner
                    continue;  // Continua pedindo a opção
                }

                if (escolhaUser == 1) {
                    // Menu de serviços para o Usuário
                    System.out.println("Usuário Liberado.");
                    System.out.println("========================================");
                    while (true) {
                        System.out.println(" 1. Cadastrar-se \n 2. Agendar um Horário \n 3. Cancelar Agendamento \n 4. Sair");
                        System.out.print("Escolha uma Opção: ");
                        int escolhaServicoUser = -1;

                        try {
                            escolhaServicoUser = input.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida! Por favor, digite um número.");
                            input.nextLine();
                            continue;  // Retorna ao menu de serviços do Usuário
                        }

                        if (escolhaServicoUser == 1) {
                            barberShop.cadastrarUsuario();
                        } else if (escolhaServicoUser == 2) {
                            barberShop.agendarHorario();
                        } else if (escolhaServicoUser == 3) {
                            barberShop.cancelarHorario();
                        } else if (escolhaServicoUser == 4) {
                            System.out.println("Obrigado(a) por usar o BarberShopJava!");
                            break;  // Sai do menu de Usuário e retorna ao menu inicial
                        } else {
                            System.out.println("Por favor, Escolha uma opção válida");
                        }
                    }
                } else if (escolhaUser == 2) {
                    // Menu de serviços para o Administrador
                    final int NUMERO_CONTA_ADMIN = 12345;
                    final int PIN_CONTA_ADMIN = 123;
                    try {
                        System.out.print("Entre com o Número da Conta -> ");
                        int inputNumeroConta = input.nextInt();

                        System.out.print("Entre com o PIN da Conta -> ");
                        int inputPinConta = input.nextInt();

                        if (inputNumeroConta != NUMERO_CONTA_ADMIN || inputPinConta != PIN_CONTA_ADMIN) {
                            System.out.println("Número da conta ou PIN incorretos. Acesso negado.");
                            continue;  // Retorna ao menu inicial
                        }

                        System.out.println("Liberado como Administrador.");
                        System.out.println("========================================");
                        while (true) {
                            System.out.println(" 1. Listar Clientes \n 2. Excluir Cliente \n 3. Procurar Cliente \n 4. Listar Agendamentos \n 5.Sair");
                            System.out.print("Escolha uma Opção: ");
                            int escolhaServicoAdmin = -1;

                            try {
                                escolhaServicoAdmin = input.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida! Por favor, digite um número.");
                                input.nextLine();
                                continue;  // Retorna ao menu de serviços do Administrador
                            }

                            if (escolhaServicoAdmin == 1) {
                                barberShop.listarClientes();
                            } else if (escolhaServicoAdmin == 2) {
                                barberShop.excluirUsuario();
                            } else if (escolhaServicoAdmin == 3) {
                                barberShop.procurarUsuario();
                            } else if (escolhaServicoAdmin == 4) {
                                barberShop.listarAgendamentos();
                            } else if (escolhaServicoAdmin == 5){
                                System.out.println("Obrigado(a) por usar o BarberShopJava!");
                                break;
                            }else {
                                System.out.println("Por Favor, Escolha uma opção válida");
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida! Acesso negado.");
                        continue;  // Retorna ao menu inicial se erro no PIN
                    }
                } else if (escolhaUser == 3){
                    System.out.println("Obrigado(a) por usar o BarberShopJava!");
                    break;
                }else {
                    System.out.println("Escolha uma Opção válida !");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}


