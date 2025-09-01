package desafio.apitranferencia.application.usecase.conta.output;

import desafio.apitranferencia.domain.model.Conta;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ConsultarContaOutput {
   private List<DadosContaOutput> contas;
}
