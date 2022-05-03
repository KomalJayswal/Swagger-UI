package net.learning.SwaggerUI.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InternalServerErrorSampleResponse {

    private String timestamp;
    private String status;
    private String error;
    private String path;
}
