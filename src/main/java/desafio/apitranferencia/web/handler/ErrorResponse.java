package desafio.apitranferencia.web.handler;

import java.time.Instant;

public class ErrorResponse {

    private Instant timestamp;
    private int status;
    private String error;
    private String message;

    public ErrorResponse(Instant timestamp, int status, String error, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }
}
