package desafio.apitranferencia.infrastructure.gateway.repository;

import desafio.apitranferencia.infrastructure.entity.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContaRepository extends JpaRepository<ContaEntity, Long> {

    ContaEntity findByNumero(Long numeroConta);

    boolean existsByNumero(Long contaOrigem);
}
