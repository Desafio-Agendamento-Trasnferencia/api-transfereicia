package desafio.apitranferencia.web.controller.trasferencia.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TransferenciasResponse {
    private List<TransferenciaResponse> transferencias;
}
