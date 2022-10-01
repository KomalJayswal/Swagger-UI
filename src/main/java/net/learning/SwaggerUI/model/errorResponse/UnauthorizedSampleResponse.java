package net.learning.SwaggerUI.model.errorResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnauthorizedSampleResponse {

    private String timestamp;
    private String status;
    private String error;
    private String path;
}
