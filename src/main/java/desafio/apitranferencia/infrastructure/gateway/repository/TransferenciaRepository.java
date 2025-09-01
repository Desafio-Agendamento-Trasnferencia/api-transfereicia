package desafio.apitranferencia.infrastructure.gateway.repository;

import desafio.apitranferencia.infrastructure.entity.TransferenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface TransferenciaRepository extends JpaRepository<TransferenciaEntity, Long> {

    @Query("SELECT COALESCE(SUM(t.valor + COALESCE(t.taxa, 0)), 0) " +
            "FROM TransferenciaEntity t " +
            "WHERE t.contaOrigem.numero = :numero " +
            "AND t.dataAgendamento BETWEEN :dataInicial AND :dataFinal")
    BigDecimal somarTransferenciasAPagar(@Param("numero") Long numero,
                                         @Param("dataInicial") LocalDate dataInicial,
                                         @Param("dataFinal") LocalDate dataFinal);

    @Query("SELECT COALESCE(SUM(t.valor), 0) " +
            "FROM TransferenciaEntity t " +
            "WHERE t.contaDestino.numero = :numero " +
            "AND t.dataAgendamento BETWEEN :dataInicial AND :dataFinal")
    BigDecimal somarTransferenciasAReceber(@Param("numero") Long numero,
                                           @Param("dataInicial") LocalDate dataInicial,
                                           @Param("dataFinal") LocalDate dataFinal);
}
