package desafio.apitranferencia.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Conta {
    private UUID id;
    private String numero;
    private BigDecimal saldo;


    public Conta(UUID id, String numero, BigDecimal saldo) {
        validate(id, numero, saldo);
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
    }

    public static Conta create(UUID id, String numero, BigDecimal saldo) {
        final UUID uuid = UUID.randomUUID();
        return new Conta(uuid, numero, saldo);
    }

    private void validate(UUID id, String numero, BigDecimal saldo) {
        if (id == null) {
            throw new IllegalArgumentException("ID nao pode ser nulo");
        }
        if (numero == null || numero.isEmpty()) {
            throw new IllegalArgumentException("Numero da conta nao pode ser nulo ou vazio");
        }
        if (saldo == null || saldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Saldo deve ser maior ou igual a zero");
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}

