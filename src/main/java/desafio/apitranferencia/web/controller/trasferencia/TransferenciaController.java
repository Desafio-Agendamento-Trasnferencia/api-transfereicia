package desafio.apitranferencia.web.controller.trasferencia;

import desafio.apitranferencia.application.usecase.transferencia.CriarTranferenciaVoidUseCase;
import desafio.apitranferencia.application.usecase.transferencia.Input.CriarTransferenciaInput;
import desafio.apitranferencia.web.controller.trasferencia.request.RealizarTransferenciaRequest;
import desafio.apitranferencia.web.controller.trasferencia.response.TransferenciasResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final CriarTranferenciaVoidUseCase criarTranferenciaVoidUseCase;

    public TransferenciaController(CriarTranferenciaVoidUseCase criarTranferenciaVoidUseCase) {
        this.criarTranferenciaVoidUseCase = criarTranferenciaVoidUseCase;
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
        return null;
    }

}
