package net.learning.SwaggerUI.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import net.learning.SwaggerUI.model.request.SampleRequest;
import net.learning.SwaggerUI.model.response.SuccessSampleResponse;
import net.learning.SwaggerUI.swagger.SubmitDocumentContract;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sample")
@SecurityRequirement(name = "JWT-Authentication")
public class SampleAPIConroller {

    @SubmitDocumentContract
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/project")
    //@PreAuthorize("@UserAccessValidator.hasAuthority('${app.security.access-rights.vessel-voyage-documents}')")
    public ResponseEntity<SuccessSampleResponse> submitImportDocument(
            @RequestBody @Valid SampleRequest requestPayload,
            @RequestHeader("HeaderField1") String headerField1, @RequestHeader("HeaderField2") String headerField2){

            return ResponseEntity.status(HttpStatus.OK).body(new SuccessSampleResponse());

    }
}
/*
500
{
    "timestamp": "2022-05-03T14:30:48.976+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "path": "/sample/project"
}
400
{
    "method": "POST",
    "requestUri": "/documentSummariesCriteria",
    "status": "BAD_REQUEST",
    "timestamp": "03-05-2022 14:33:57",
    "message": "Validation errors",
    "debugMessage": "Required request body is missing",
    "subErrors": null,
    "id": "c3984d0a-65aa-46e6-b6ac-6e14a1e7faea"
}
 */