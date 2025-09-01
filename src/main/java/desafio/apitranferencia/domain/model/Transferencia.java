package desafio.apitranferencia.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transferencia {
    private Long id;
    private Conta contaOrigem;
    private Conta contaDestino;
    private BigDecimal valor;
    private LocalDate dataAgendamento;
    private LocalDateTime dataTransferencia;
    private BigDecimal taxa;
    private StatusTransferencia status;

    public Transferencia(Long id, Conta contaOrigem, Conta contaDestino, BigDecimal valor, LocalDate dataAgendamento, LocalDateTime dataTransferencia, BigDecimal taxa, StatusTransferencia status) {
        validate(contaOrigem, contaDestino, valor, dataAgendamento, taxa, status);
        this.id = id;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataAgendamento = dataAgendamento;
        this.dataTransferencia = dataTransferencia;
        this.taxa = taxa;
        this.status = status;
    }

    public Transferencia(Conta contaOrigem, Conta contaDestino, BigDecimal valor, LocalDate dataAgendamento, LocalDateTime dataTransferencia, BigDecimal taxa, StatusTransferencia status) {
        validate(contaOrigem, contaDestino, valor, dataAgendamento, taxa, status);
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataAgendamento = dataAgendamento;
        this.dataTransferencia = dataTransferencia;
        this.taxa = taxa;
        this.status = status;
    }

    public static Transferencia create(Conta contaOrigem, Conta contaDestino, BigDecimal valor, LocalDate dataAgendamento, BigDecimal taxa, StatusTransferencia status) {
        final LocalDateTime dataTransferencia = LocalDateTime.now();
        return new Transferencia(contaOrigem, contaDestino, valor, dataAgendamento, dataTransferencia, taxa, status);
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

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public LocalDateTime getDataTransferencia() {
        return dataTransferencia;
    }

    public StatusTransferencia getStatus() {
        return status;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }
}


