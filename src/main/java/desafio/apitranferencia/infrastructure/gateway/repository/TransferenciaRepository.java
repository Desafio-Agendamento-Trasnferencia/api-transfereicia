package desafio.apitranferencia.infrastructure.gateway.repository;

import desafio.apitranferencia.infrastructure.entity.TransferenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<TransferenciaEntity, Long> {

}
