package desafio.apitranferencia.domain.model;

import java.math.BigDecimal;

public class Conta {
    private Long id;
    private Long numero;
    private BigDecimal saldo;


    public Conta(Long id, Long numero, BigDecimal saldo) {
        validate(numero, saldo);
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
    }

    public Conta(Long numero, BigDecimal saldo) {
        validate(numero, saldo);
        this.numero = numero;
        this.saldo = saldo;
    }

    public Conta(Long uuid) {
        this.id = uuid;
    }

    public static Conta create(Long numero, BigDecimal saldo) {
        return new Conta(numero, saldo);
    }

    private void validate(Long numero, BigDecimal saldo) {
        if (numero == null) {
            throw new IllegalArgumentException("Numero da conta nao pode ser nulo ou vazio");
        }
        if (saldo == null || saldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Saldo deve ser maior ou igual a zero");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}

