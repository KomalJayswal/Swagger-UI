package net.learning.SwaggerUI.model.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.learning.SwaggerUI.model.request.SampleObjectModel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleRequest {

    private String field1;
    private String field2;
    private SampleObjectModel nestedSampleObjectModel;
    private List<String> field3;
    private boolean field4;
    private Boolean field5;
}
