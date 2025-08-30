package desafio.apitranferencia.web.controller.trasferencia;

import desafio.apitranferencia.web.controller.trasferencia.request.RealizarTransferenciaRequest;
import desafio.apitranferencia.web.controller.trasferencia.response.TransferenciasResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    @PostMapping
    public void criarTransferencia(@RequestBody RealizarTransferenciaRequest request) {

    }

    @GetMapping
    public ResponseEntity<TransferenciasResponse> listarTransferencias() {
        return null;
    }

}
