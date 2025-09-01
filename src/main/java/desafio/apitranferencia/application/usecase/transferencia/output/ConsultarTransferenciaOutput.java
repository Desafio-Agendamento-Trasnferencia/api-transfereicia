package desafio.apitranferencia.application.usecase.transferencia.output;

import desafio.apitranferencia.domain.model.Transferencia;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ConsultarTransferenciaOutput {
    List<Transferencia> transferencias;
}
