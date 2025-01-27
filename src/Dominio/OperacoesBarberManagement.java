package Dominio;

import java.util.List;

public interface OperacoesBarberManagement {
    Cliente cadastrarUsuario();
    Cliente agendarHorario();
    Cliente cancelarHorario();
    List<Cliente> listarClientes();
    Cliente excluirUsuario();
    Cliente procurarUsuario();
}
