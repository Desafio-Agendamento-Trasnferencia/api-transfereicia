package desafio.apitranferencia.infrastructure.gateway;

import desafio.apitranferencia.domain.gateway.TransferenciaGateway;
import desafio.apitranferencia.domain.model.Transferencia;
import desafio.apitranferencia.infrastructure.entity.TransferenciaEntity;
import desafio.apitranferencia.infrastructure.gateway.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaGatewayImpl implements TransferenciaGateway {

    private final TransferenciaRepository transferenciaRepository;

    public TransferenciaGatewayImpl(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    @Override
    public void criarTransferencia(Transferencia transferencia) {
        final TransferenciaEntity entity = TransferenciaEntity.toEntity(transferencia);
        transferenciaRepository.save(entity);
    }
}
