package desafio.apitranferencia.application.usecase.transferencia;

import desafio.apitranferencia.application.usecase.UseCase;
import desafio.apitranferencia.application.usecase.transferencia.output.ConsultarTransferenciaOutput;
import desafio.apitranferencia.domain.gateway.TransferenciaGateway;
import desafio.apitranferencia.domain.model.Transferencia;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultarTransferenciaUseCase extends UseCase<ConsultarTransferenciaOutput> {

    private final TransferenciaGateway transferenciaGateway;

    public ConsultarTransferenciaUseCase(TransferenciaGateway transferenciaGateway) {
        this.transferenciaGateway = transferenciaGateway;
    }

    @Override
    public ConsultarTransferenciaOutput execute() {
        List<Transferencia> domain = transferenciaGateway.consultarTodasTransferencias();
        return ConsultarTransferenciaOutput.builder()
                .transferencias(domain)
                .build();
    }
}
