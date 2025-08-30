package desafio.apitranferencia.domain.gateway;

import java.math.BigDecimal;

public interface ContaGateway {

    BigDecimal consultarSaldo(Long numeroConta);

    boolean consultarConta(Long contaOrigem);

    void debitar(Long contaOrigem, BigDecimal taxaCalculada);

    void creditar(Long contaDestino, BigDecimal valor);

    Long consuntarIdDaConta(Long numeroConta);
}
