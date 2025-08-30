package desafio.apitranferencia.web.controller.trasferencia.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class RealizarTransferenciaRequest {
    private Long contaOrigem;
    private Long contaDestino;
    private Double valor;
    private LocalDate dataTransferencia;
}
