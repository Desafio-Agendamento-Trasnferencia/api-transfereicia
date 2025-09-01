package desafio.apitranferencia.web.controller.conta.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ContasResponse {
    private List<ContaResponse> contas;
}
