package desafio.apitranferencia.domain.gateway;

import desafio.apitranferencia.domain.model.Conta;

import java.math.BigDecimal;
import java.util.List;

public interface ContaGateway {

    BigDecimal consultarSaldo(Long numeroConta);

    boolean consultarConta(Long contaOrigem);

    void debitar(Long contaOrigem, BigDecimal taxaCalculada);

    void creditar(Long contaDestino, BigDecimal valor);

    Long consuntarIdDaConta(Long numeroConta);

    List<Conta> listarContas();
}
