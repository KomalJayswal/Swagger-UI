package net.learning.SwaggerUI.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleObjectModel {

    private String nestedField1;
    private List<String> nestedField2;
    private boolean nestedField3;
}
