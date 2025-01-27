package Dominio;

import java.time.LocalDateTime;

public class Agendamento {
    private String clienteNome;
    LocalDateTime dataHora;

    public Agendamento(Cliente clienteNome, LocalDateTime dataHora) {
        this.clienteNome = String.valueOf(clienteNome);
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "clienteNome='" + clienteNome + '\'' +
                ", dataHora=" + dataHora +
                '}';
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
