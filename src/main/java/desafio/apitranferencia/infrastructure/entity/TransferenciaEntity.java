package desafio.apitranferencia.infrastructure.entity;

import desafio.apitranferencia.domain.model.StatusTransferencia;
import desafio.apitranferencia.domain.model.Transferencia;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "transferencias")
public class TransferenciaEntity {

    @Id
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "conta_origem_id")
    private ContaEntity contaOrigem;

    @ManyToOne(optional = false)
    @JoinColumn(name = "conta_destino_id")
    private ContaEntity contaDestino;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDate dataAgendamento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusTransferencia status;

    @Column
    private BigDecimal taxa;

    public TransferenciaEntity() {
    }

    public TransferenciaEntity toEntity(Transferencia transferencia) {
        TransferenciaEntity entity = new TransferenciaEntity();
        entity.setId(transferencia.getId());
        entity.setContaOrigem(new ContaEntity().toEntity(transferencia.getContaOrigem()));
        entity.setContaDestino(new ContaEntity().toEntity(transferencia.getContaDestino()));
        entity.setValor(BigDecimal.valueOf(transferencia.getValor()));
        entity.setDataAgendamento(transferencia.getDataAgendamento());
        entity.setStatus(transferencia.getStatus());
        return entity;
    }

    public Transferencia toDomain(){
        return new Transferencia(
                this.id,
                this.contaOrigem.toDomain(),
                this.contaDestino.toDomain(),
                this.valor.doubleValue(),
                this.dataAgendamento,
                this.status
        );
    }
}
