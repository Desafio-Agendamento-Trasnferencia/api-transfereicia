package desafio.apitranferencia.web.controller.conta;

import desafio.apitranferencia.application.usecase.conta.ConsultarContasUseCase;
import desafio.apitranferencia.application.usecase.conta.output.ConsultarContaOutput;
import desafio.apitranferencia.web.controller.conta.response.ContaResponse;
import desafio.apitranferencia.web.controller.conta.response.ContasResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ConsultarContasUseCase consultarContasUseCase;

    public ContaController(ConsultarContasUseCase consultarContasUseCase) {
        this.consultarContasUseCase = consultarContasUseCase;
    }

    @GetMapping
    public ResponseEntity<ContasResponse> listarContas() {

        final ConsultarContaOutput output = consultarContasUseCase.execute();

        List<ContaResponse> contas = output.getContas().stream()
                .map(conta -> new ContaResponse(
                        conta.getNumeroConta(),
                        conta.getSaldo().toString(),
                        conta.getTotalTransferenciasSaida().toString(),
                        conta.getTotalTransferenciasEntrada().toString()
                ))
                .collect(Collectors.toList());

        ContasResponse response = ContasResponse.builder()
                .contas(contas)
                .build();

        return ResponseEntity.ok(response);
    }
}
