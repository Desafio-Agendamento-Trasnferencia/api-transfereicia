package desafio.apitranferencia.application.usecase.conta.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DadosContaOutput {
    private final Long numeroConta;
    private final BigDecimal saldo;
    private final BigDecimal totalTransferenciasSaida;
    private final BigDecimal totalTransferenciasEntrada;
}
