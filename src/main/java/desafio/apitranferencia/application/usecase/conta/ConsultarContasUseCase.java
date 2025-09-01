package desafio.apitranferencia.application.usecase.conta;

import desafio.apitranferencia.application.usecase.UseCase;
import desafio.apitranferencia.application.usecase.conta.output.ConsultarContaOutput;
import desafio.apitranferencia.application.usecase.conta.output.DadosContaOutput;
import desafio.apitranferencia.application.usecase.conta.output.TransferenciaTotais;
import desafio.apitranferencia.domain.gateway.ContaGateway;
import desafio.apitranferencia.domain.gateway.TransferenciaGateway;
import desafio.apitranferencia.domain.model.Conta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ConsultarContasUseCase extends UseCase<ConsultarContaOutput> {

    private final ContaGateway contaGateway;

    private final TransferenciaGateway transferenciaGateway;

    public ConsultarContasUseCase(ContaGateway contaGateway, TransferenciaGateway transferenciaGateway) {
        this.contaGateway = contaGateway;
        this.transferenciaGateway = transferenciaGateway;
    }

    @Override
    public ConsultarContaOutput execute() {
        final List<Conta> contas = contaGateway.listarContas();
        final Map<Long, TransferenciaTotais> transferenciasPorConta = transferenciaGateway.consultarTransferenciasPorConta(contas);

       final List<DadosContaOutput> dadosContas = contas.stream()
                .map(conta -> DadosContaOutput.builder()
                        .numeroConta(conta.getNumero())
                        .saldo(conta.getSaldo())
                        .totalTransferenciasSaida(transferenciasPorConta.get(conta.getNumero()).getAPagar())
                        .totalTransferenciasEntrada(transferenciasPorConta.get(conta.getNumero()).getAReceber())
                        .build())
                .collect(Collectors.toList());

        return ConsultarContaOutput.builder()
                .contas(dadosContas)
                .build();
    }
}
