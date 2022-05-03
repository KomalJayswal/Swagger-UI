package net.learning.SwaggerUI.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BadRequestSampleResponse {

    private String method;
    private String requestUri;
    private String status;
    private String timestamp;
    private String message;
    private String debugMessage;
    private String subErrors;
    private String id;
}
