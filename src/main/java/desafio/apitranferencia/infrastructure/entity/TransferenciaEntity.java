package desafio.apitranferencia.infrastructure.entity;

import desafio.apitranferencia.domain.model.StatusTransferencia;
import desafio.apitranferencia.domain.model.Transferencia;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "transferencias")
public class TransferenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public static TransferenciaEntity toEntity(Transferencia transferencia) {
        TransferenciaEntity entity = new TransferenciaEntity();
        entity.setId(transferencia.getId());
        entity.setContaOrigem(new ContaEntity().toEntity(transferencia.getContaOrigem()));
        entity.setContaDestino(new ContaEntity().toEntity(transferencia.getContaDestino()));
        entity.setValor(transferencia.getValor());
        entity.setDataAgendamento(transferencia.getDataAgendamento());
        entity.setTaxa(transferencia.getTaxa());
        entity.setStatus(transferencia.getStatus());
        return entity;
    }

    public Transferencia toDomain() {
        return new Transferencia(
                this.id,
                this.contaOrigem.toDomain(),
                this.contaDestino.toDomain(),
                this.valor,
                this.dataAgendamento,
                this.taxa,
                this.status
        );
    }
}
