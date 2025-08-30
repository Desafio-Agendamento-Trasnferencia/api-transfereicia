package desafio.apitranferencia.infrastructure.gateway;

import desafio.apitranferencia.domain.exception.RecursoNaoEncontrado;
import desafio.apitranferencia.domain.gateway.ContaGateway;
import desafio.apitranferencia.domain.model.Conta;
import desafio.apitranferencia.infrastructure.entity.ContaEntity;
import desafio.apitranferencia.infrastructure.gateway.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ContaGatewayImpl implements ContaGateway {

    private final ContaRepository contaRepository;

    public ContaGatewayImpl(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public BigDecimal consultarSaldo(Long numeroConta) {
        final Conta conta = contaRepository.findByNumero(numeroConta).toDomain();
        if (conta == null) {
            throw new RecursoNaoEncontrado("Conta Não encontrada: " + numeroConta);
        }
        return conta.getSaldo();
    }

    @Override
    public boolean consultarConta(Long contaOrigem) {
        return contaRepository.existsByNumero(contaOrigem);
    }

    @Override
    public void debitar(Long contaOrigem, BigDecimal taxaCalculada) {
        final ContaEntity conta = contaRepository.findByNumero(contaOrigem);
        if (conta == null) {
            throw new RecursoNaoEncontrado("Conta Não encontrada: " + contaOrigem);
        }
        final var saldoAtual = conta.getSaldo();
        final var novoSaldo = saldoAtual.subtract(taxaCalculada);
        conta.setSaldo(novoSaldo);
        contaRepository.save(conta);
    }

    @Override
    public void creditar(Long contaDestino, BigDecimal valor) {
        final ContaEntity conta = contaRepository.findByNumero(contaDestino);
        if (conta == null) {
            throw new RecursoNaoEncontrado("Conta Não encontrada: " + contaDestino);
        }
        final var saldoAtual = conta.getSaldo();
        final var novoSaldo = saldoAtual.add(valor);
        conta.setSaldo(novoSaldo);
        contaRepository.save(conta);
    }

    @Override
    public Long consuntarIdDaConta(Long numeroConta) {
        return contaRepository.findByNumero(numeroConta).toDomain().getId();
    }
}
