package desafio.apitranferencia.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class Transferencia {
    UUID id;
    Conta contaOrigem;
    Conta contaDestino;
    Double valor;
    LocalDate dataAgendamento;
    StatusTransferencia status;

    public Transferencia(UUID id, Conta contaOrigem, Conta contaDestino, Double valor, LocalDate dataAgendamento, StatusTransferencia status) {
        validate(id, contaOrigem, contaDestino, valor, dataAgendamento, status);
        this.id = id;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataAgendamento = dataAgendamento;
        this.status = status;
    }

    public static Transferencia create(UUID id, Conta contaOrigem, Conta contaDestino, Double valor, LocalDate dataAgendamento, StatusTransferencia status) {
        final UUID uuid = UUID.randomUUID();
        return new Transferencia(uuid, contaOrigem, contaDestino, valor, dataAgendamento, status);
    }

    private void validate(UUID id, Conta contaOrigem, Conta contaDestino, Double valor, LocalDate dataAgendamento, StatusTransferencia status) {
        if (id == null) {
            throw new IllegalArgumentException("ID nao pode ser nulo");
        }
        if (contaOrigem == null) {
            throw new IllegalArgumentException("Conta de origem nao pode ser nula");
        }
        if (contaDestino == null) {
            throw new IllegalArgumentException("Conta de destino nao pode ser nula");
        }
        if (valor == null || valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        if (dataAgendamento == null) {
            throw new IllegalArgumentException("Data de agendamento nao pode ser nula");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status nao pode ser nulo");
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public StatusTransferencia getStatus() {
        return status;
    }

    public void setStatus(StatusTransferencia status) {
        this.status = status;
    }
}


