package net.learning.SwaggerUI.controller;

import net.learning.SwaggerUI.controller.dto.SampleRequest;
import net.learning.SwaggerUI.controller.dto.SuccessSampleResponse;
import net.learning.SwaggerUI.swagger.SubmitDocumentContract;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sample")
public class SampleAPIConroller {

    @SubmitDocumentContract
    @PostMapping("/project")
    public ResponseEntity<SuccessSampleResponse> submitImportDocument(
            @RequestBody @Valid SampleRequest requestPayload,
            @RequestHeader("HeaderField1") String headerField1, @RequestHeader("HeaderField2") String headerField2){

            return ResponseEntity.status(HttpStatus.OK).body(new SuccessSampleResponse());

    }
}