package desafio.apitranferencia.infrastructure.entity;

import desafio.apitranferencia.domain.model.Conta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "contas")
@Getter
@Setter
public class ContaEntity {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(nullable = false)
    private BigDecimal saldo;

    public ContaEntity() {
    }

    public ContaEntity toEntity(Conta conta) {
        ContaEntity entity = new ContaEntity();
        entity.setId(conta.getId());
        entity.setNumero(conta.getNumero());
        entity.setSaldo(conta.getSaldo());
        return entity;
    }

    public Conta toDomain() {
        return new Conta(
                this.id,
                this.numero,
                this.saldo
        );
    }
}
