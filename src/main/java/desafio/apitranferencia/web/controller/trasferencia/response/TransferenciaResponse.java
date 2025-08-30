package desafio.apitranferencia.web.controller.trasferencia.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class TransferenciaResponse {
    private LocalDate datataTransferencia;
    private String contaOrigem;
    private String contaDestino;
    private Double valor;
    private String taxa;
    private String status;
}
