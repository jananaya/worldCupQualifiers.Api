package unimagdalena.web.api.worldcupqualifiers.infrastructure.exceptions;

import java.util.List;
import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private HttpStatus status;
    private String uri;
    private List<String> messages;

    public ErrorResponse(HttpStatus status, String uri, List<String> messages) {
        this.status = status;
        this.uri = uri;
        this.messages = messages;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public List<String> getMessages() {
        return messages;
    }

    public String getUri() {
        return uri;
    }
}
