package desafio.apitranferencia.web.controller.trasferencia;

import desafio.apitranferencia.application.usecase.transferencia.ConsultarTransferenciaUseCase;
import desafio.apitranferencia.application.usecase.transferencia.CriarTranferenciaVoidUseCase;
import desafio.apitranferencia.application.usecase.transferencia.Input.CriarTransferenciaInput;
import desafio.apitranferencia.application.usecase.transferencia.output.ConsultarTransferenciaOutput;
import desafio.apitranferencia.web.controller.trasferencia.request.RealizarTransferenciaRequest;
import desafio.apitranferencia.web.controller.trasferencia.response.TransferenciaResponse;
import desafio.apitranferencia.web.controller.trasferencia.response.TransferenciasResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final CriarTranferenciaVoidUseCase criarTranferenciaVoidUseCase;
    private final ConsultarTransferenciaUseCase consultarTransferenciaUseCase;

    public TransferenciaController(CriarTranferenciaVoidUseCase criarTranferenciaVoidUseCase, ConsultarTransferenciaUseCase consultarTransferenciaUseCase) {
        this.criarTranferenciaVoidUseCase = criarTranferenciaVoidUseCase;
        this.consultarTransferenciaUseCase = consultarTransferenciaUseCase;
    }

    @PostMapping
    public void criarTransferencia(@RequestBody RealizarTransferenciaRequest request) {

        final CriarTransferenciaInput input = CriarTransferenciaInput.builder()
                .contaOrigem(request.getContaOrigem())
                .contaDestino(request.getContaDestino())
                .valor(BigDecimal.valueOf(request.getValor()))
                .dataTransferencia(request.getDataTransferencia())
                .build();

        criarTranferenciaVoidUseCase.execute(input);

    }

    @GetMapping
    public ResponseEntity<TransferenciasResponse> listarTransferencias() {
        final ConsultarTransferenciaOutput output = consultarTransferenciaUseCase.execute();

        final TransferenciasResponse response = TransferenciasResponse.builder()
                .transferencias(output.getTransferencias().stream()
                        .map(transferencia -> {
                            return new TransferenciaResponse(
                                    transferencia.getId(),
                                    transferencia.getDataAgendamento().toString(),
                                    transferencia.getDataTransferencia().toString(),
                                    transferencia.getContaOrigem().getNumero().toString(),
                                    transferencia.getContaDestino().getNumero().toString(),
                                    transferencia.getValor().toString(),
                                    transferencia.getTaxa().toString(),
                                    transferencia.getStatus().getLabel()
                            );
                        }).collect(Collectors.toList()))
                .build();
        return ResponseEntity.ok(response);
    }
}
