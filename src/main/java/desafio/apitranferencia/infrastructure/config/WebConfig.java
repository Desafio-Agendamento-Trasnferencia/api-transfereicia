package desafio.apitranferencia.infrastructure.config;

import desafio.apitranferencia.application.usecase.transferencia.CriarTranferenciaVoidUseCase;
import desafio.apitranferencia.domain.gateway.ContaGateway;
import desafio.apitranferencia.domain.gateway.TransferenciaGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public CriarTranferenciaVoidUseCase criarTranferenciaUseCase(
            ContaGateway contaGateway,
            TransferenciaGateway transferenciaGateway) {
        return new CriarTranferenciaVoidUseCase(contaGateway, transferenciaGateway);
    }

}
