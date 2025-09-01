package desafio.apitranferencia.application.usecase.conta.output;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class TransferenciaTotais {
    private final BigDecimal aPagar;
    private final BigDecimal aReceber;
}
