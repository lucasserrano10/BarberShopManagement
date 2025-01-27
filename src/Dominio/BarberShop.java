package Dominio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class BarberShop implements OperacoesBarberManagement {
    private List<Cliente> clientes;
    private List<Agendamento> agendamentos;

    public BarberShop(List<Cliente> clientes, List<Agendamento> agendamentos) {
        this.clientes = clientes;
        this.agendamentos = agendamentos;
    }

    @Override
    public Cliente cadastrarUsuario() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("CPF: ");
        String cpf = input.nextLine();

        Cliente novoCliente = new Cliente(nome, cpf, email);
        clientes.add(novoCliente);
        System.out.println("Cadastro realizado com sucesso!");
        return novoCliente;
    }

    @Override
    public Cliente agendarHorario() {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o nome do cliente para agendar: ");
        String nome = input.nextLine();

        Cliente cliente = procurarCliente(nome);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return null;
        }

        System.out.print("Digite a data e hora do agendamento (YYYY-MM-DD HH:mm): ");
        String dataHoraStr = input.nextLine();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));


        Agendamento novoAgendamento = new Agendamento(cliente, dataHora);
        agendamentos.add(novoAgendamento);
        System.out.println("Agendamento realizado com sucesso!");
        return cliente;
    }

    @Override
    public Cliente cancelarHorario() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome do cliente para cancelar o agendamento: ");
        String nome = input.nextLine();

        Cliente cliente = procurarCliente(nome);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return null;
        }


        Agendamento agendamentoCancelado = null;
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getClienteNome().equals(cliente)) {
                agendamentoCancelado = agendamento;
                break;
            }
        }

        if (agendamentoCancelado != null) {
            agendamentos.remove(agendamentoCancelado);
            System.out.println("Agendamento cancelado para: " + cliente.getNome());
        } else {
            System.out.println("Não há agendamento para esse cliente.");
        }

        return cliente;
    }

    @Override
    public List<Cliente> listarClientes() {
        if(clientes.isEmpty()){
            System.out.println("Sem clientes no momento !");
        }else{
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
        return clientes;
    }



    @Override
    public Cliente excluirUsuario() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome do cliente para excluir: ");
        String nome = input.nextLine();

        Cliente clienteRemovido = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                clienteRemovido = cliente;
                clientes.remove(cliente);
                break;
            }
        }

        if (clienteRemovido != null) {
            System.out.println("Cliente excluído: " + clienteRemovido.getNome());
        } else {
            System.out.println("Cliente não encontrado.");
        }

        return clienteRemovido;
    }


    @Override
    public Cliente procurarUsuario() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome do cliente para procurar: ");
        String nome = input.nextLine();

        Cliente clienteEncontrado = procurarCliente(nome);

        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado.getNome());
        } else {
            System.out.println("Cliente não encontrado.");
        }

        return clienteEncontrado;
    }

    private Cliente procurarCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public void listarAgendamentos() {
        if (agendamentos.isEmpty()) {
            System.out.println("Não há agendamentos.");
            return;
        }
        for (Agendamento agendamento : agendamentos) {
            System.out.println(agendamento);
        }
    }
}
