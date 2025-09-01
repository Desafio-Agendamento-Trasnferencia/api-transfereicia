package desafio.apitranferencia.web.controller.trasferencia.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TransferenciaResponse {
    private Long id;
    private String dataAgendamento;
    private String dataTransferencia;
    private String contaOrigem;
    private String contaDestino;
    private String valor;
    private String taxa;
    private String status;
}
