package desafio.apitranferencia.application.usecase.transferencia.Input;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CriarTransferenciaInput {
    private Long contaOrigem;
    private Long contaDestino;
    private BigDecimal valor;
    private LocalDate dataTransferencia;
}
