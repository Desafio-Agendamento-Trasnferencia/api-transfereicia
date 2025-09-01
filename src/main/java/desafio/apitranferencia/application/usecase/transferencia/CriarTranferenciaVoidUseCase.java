package desafio.apitranferencia.application.usecase.transferencia;

import desafio.apitranferencia.application.usecase.VoidUseCase;
import desafio.apitranferencia.application.usecase.transferencia.Input.CriarTransferenciaInput;
import desafio.apitranferencia.domain.exception.RecursoNaoEncontrado;
import desafio.apitranferencia.domain.exception.SaldoInsuficienteException;
import desafio.apitranferencia.domain.gateway.ContaGateway;
import desafio.apitranferencia.domain.gateway.TransferenciaGateway;
import desafio.apitranferencia.domain.model.Conta;
import desafio.apitranferencia.domain.model.StatusTransferencia;
import desafio.apitranferencia.domain.model.Taxa;
import desafio.apitranferencia.domain.model.Transferencia;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class CriarTranferenciaVoidUseCase extends VoidUseCase<CriarTransferenciaInput> {

    private final ContaGateway contaGateway;
    private final TransferenciaGateway transferenciaGateway;

    public CriarTranferenciaVoidUseCase(ContaGateway contaGateway, TransferenciaGateway transferenciaGateway) {
        this.contaGateway = contaGateway;
        this.transferenciaGateway = transferenciaGateway;
    }

    @Override
    public void execute(CriarTransferenciaInput input) {
        verificarConta(input.getContaOrigem(), "Conta de origem não encontrada.");
        verificarConta(input.getContaDestino(), "Conta de destino não encontrada.");

        final BigDecimal taxaCalculada = calcularTaxa(input.getValor(), input.getDataTransferencia());

        verificarSaldo(input.getValor().add(taxaCalculada), input.getContaOrigem());

        if (input.getDataTransferencia().equals(LocalDate.now())) {
            contaGateway.debitar(input.getContaOrigem(), input.getValor().add(taxaCalculada));

            contaGateway.creditar(input.getContaDestino(), input.getValor());
        }

        final Transferencia transferencia = Transferencia.create(
                new Conta(
                        contaGateway.consuntarIdDaConta(input.getContaOrigem())
                ),
                new Conta(
                        contaGateway.consuntarIdDaConta(input.getContaDestino())
                ),
                input.getValor(),
                input.getDataTransferencia(),
                taxaCalculada,
                definirStatus(input.getDataTransferencia())
        );

        transferenciaGateway.criarTransferencia(transferencia);
    }

    private void verificarConta(Long conta, String mensagemErro) {
        if (!contaGateway.consultarConta(conta)) {
            throw new RecursoNaoEncontrado(mensagemErro);
        }
    }

    private void verificarSaldo(BigDecimal valorComTaxa, Long contaOrigem) {
        final BigDecimal saldoContaOrigem = contaGateway.consultarSaldo(contaOrigem);
        final BigDecimal valoresAPagar = transferenciaGateway.consultarValoresAPagar(contaOrigem);
        final BigDecimal saldoDisponivel = saldoContaOrigem.subtract(valoresAPagar);
        if (saldoDisponivel.compareTo(valorComTaxa) < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente na conta de origem.");
        }
    }

    private BigDecimal calcularTaxa(BigDecimal valor, LocalDate dataTransferencia) {
        final long dias = ChronoUnit.DAYS.between(LocalDate.now(), dataTransferencia);

        final Taxa regra = Taxa.getByDias((int) dias);

        final BigDecimal taxaPercentual = valor.multiply(BigDecimal.valueOf(regra.getTaxaPercentual()));
        final BigDecimal taxaFixa = BigDecimal.valueOf(regra.getValorFixo());

        return taxaPercentual.add(taxaFixa);
    }

    private StatusTransferencia definirStatus(LocalDate dataTransferencia) {
        return dataTransferencia.isAfter(LocalDate.now())
                ? StatusTransferencia.AGENDADO
                : StatusTransferencia.CONCLUIDA;
    }
}
