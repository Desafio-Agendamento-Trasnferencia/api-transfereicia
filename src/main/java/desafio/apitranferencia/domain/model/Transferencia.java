package desafio.apitranferencia.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transferencia {
    Long id;
    Conta contaOrigem;
    Conta contaDestino;
    BigDecimal valor;
    LocalDate dataAgendamento;
    BigDecimal taxa;
    StatusTransferencia status;

    public Transferencia(Long id, Conta contaOrigem, Conta contaDestino, BigDecimal valor, LocalDate dataAgendamento, BigDecimal taxa, StatusTransferencia status) {
        validate(contaOrigem, contaDestino, valor, dataAgendamento, taxa, status);
        this.id = id;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataAgendamento = dataAgendamento;
        this.taxa = taxa;
        this.status = status;
    }

    public Transferencia(Conta contaOrigem, Conta contaDestino, BigDecimal valor, LocalDate dataAgendamento, BigDecimal taxa, StatusTransferencia status) {
        validate(contaOrigem, contaDestino, valor, dataAgendamento, taxa, status);
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataAgendamento = dataAgendamento;
        this.taxa = taxa;
        this.status = status;
    }

    public static Transferencia create(Conta contaOrigem, Conta contaDestino, BigDecimal valor, LocalDate dataAgendamento, BigDecimal taxa, StatusTransferencia status) {
        return new Transferencia(contaOrigem, contaDestino, valor, dataAgendamento, taxa, status);
    }

    private void validate(Conta contaOrigem, Conta contaDestino, BigDecimal valor, LocalDate dataAgendamento, BigDecimal taxa, StatusTransferencia status) {
        if (contaOrigem == null) {
            throw new IllegalArgumentException("Conta de origem nao pode ser nula");
        }
        if (contaDestino == null) {
            throw new IllegalArgumentException("Conta de destino nao pode ser nula");
        }
        if (valor == null) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        if (dataAgendamento == null) {
            throw new IllegalArgumentException("Data de agendamento nao pode ser nula");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status nao pode ser nulo");
        }

        if (taxa == null) {
            throw new IllegalArgumentException("Taxa nao pode ser nula");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
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

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }
}


