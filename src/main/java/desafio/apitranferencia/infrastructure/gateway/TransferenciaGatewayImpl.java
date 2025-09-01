package desafio.apitranferencia.infrastructure.gateway;

import desafio.apitranferencia.application.usecase.conta.output.TransferenciaTotais;
import desafio.apitranferencia.domain.gateway.TransferenciaGateway;
import desafio.apitranferencia.domain.model.Conta;
import desafio.apitranferencia.domain.model.Transferencia;
import desafio.apitranferencia.infrastructure.entity.TransferenciaEntity;
import desafio.apitranferencia.infrastructure.gateway.repository.TransferenciaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public List<Transferencia> consultarTodasTransferencias() {
        return transferenciaRepository.findAll(Sort.by(Sort.Direction.DESC, "dataTransferencia"))
                .stream()
                .map(TransferenciaEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Long, TransferenciaTotais> consultarTransferenciasPorConta(List<Conta> contas) {
        final LocalDate inicio = LocalDate.now().plusDays(1);
        final LocalDate fim = LocalDate.now().plusDays(50);

        return contas.stream().collect(Collectors.toMap(
                Conta::getNumero,
                conta -> {
                    final BigDecimal totalPagar = transferenciaRepository.somarTransferenciasAPagar(conta.getNumero(), inicio, fim);
                    final BigDecimal totalReceber = transferenciaRepository.somarTransferenciasAReceber(conta.getNumero(), inicio, fim);
                    return new TransferenciaTotais(totalPagar, totalReceber);
                }
        ));
    }

    @Override
    public BigDecimal consultarValoresAPagar(Long contaId) {
        final LocalDate inicio = LocalDate.now().plusDays(1);
        final LocalDate fim = LocalDate.now().plusDays(50);
        return transferenciaRepository.somarTransferenciasAPagar(contaId, inicio, fim);
    }

}
