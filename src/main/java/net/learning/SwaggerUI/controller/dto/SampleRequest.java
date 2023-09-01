package net.learning.SwaggerUI.controller.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.learning.SwaggerUI.model.SampleObjectModel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleRequest {
    @Schema(description = "It is field 1")
    private String field1;
    private String field2;
    private SampleObjectModel nestedSampleObjectModel;
    private List<String> field3;
    private boolean field4;
    private Boolean field5;
}
