package desafio.apitranferencia.web.handler;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Instant timestamp;
    private int status;
    private String message;
    private String details;

    public ErrorResponse(Instant timestamp, int status, String message, String details) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public Instant getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getMessage() { return message; }
    public String getDetails() { return details; }
}
