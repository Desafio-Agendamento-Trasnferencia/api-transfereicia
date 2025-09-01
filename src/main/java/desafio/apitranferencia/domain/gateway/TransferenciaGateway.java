package desafio.apitranferencia.domain.gateway;

import desafio.apitranferencia.application.usecase.conta.output.TransferenciaTotais;
import desafio.apitranferencia.domain.model.Conta;
import desafio.apitranferencia.domain.model.Transferencia;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface TransferenciaGateway {
    void criarTransferencia(Transferencia transferencia);

    List<Transferencia> consultarTodasTransferencias();

    Map<Long, TransferenciaTotais> consultarTransferenciasPorConta(List<Conta> contas);

    BigDecimal consultarValoresAPagar(Long contaId);
}
