package net.learning.SwaggerUI.swagger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import net.learning.SwaggerUI.controller.dto.SuccessSampleResponse;
import net.learning.SwaggerUI.model.errorResponse.*;

@Operation(summary = "Submit import document", responses = {
        @ApiResponse(responseCode = "201", description = "Document Created successfully", content = @Content(schema = @Schema(implementation = SuccessSampleResponse.class))),
        @ApiResponse(responseCode = "401", description = "Client_credentials authentication failed", content = @Content(schema = @Schema(implementation = FailedAuthenticationSampleResponse.class))),
        @ApiResponse(responseCode = "403", description = "Unauthorized access", content = @Content(schema = @Schema(implementation = UnauthorizedSampleResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid Input", content = @Content(schema = @Schema(implementation = BadRequestSampleResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = InternalServerErrorSampleResponse.class))), })
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SubmitDocumentContract {
}