package desafio.apitranferencia.web.controller.conta.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ContaResponse {
    private Long numeroConta;
    private String saldo;
    private String totalTransferenciasSaida;
    private String totalTransferenciasEntrada;
}
