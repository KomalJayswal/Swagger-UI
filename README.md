# Swagger UI

## Problem Statement

Create a Swagger UI to generate interactive API documentation that lets your users try out the API calls directly in the browser. 

## Getting Started With Solution

1. Build a fresh springboot Application using [Spring Initializer](https://start.spring.io). Add spring web dependency.
2. Add pom dependencies
```bash
<dependency>
	<groupId>org.springdoc</groupId>
	<artifactId>springdoc-openapi-ui</artifactId>
	<version>1.6.4</version>
</dependency>
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
</dependency> 

```
3. Execute `mvn clean install`
4. Add Request Model and , Response Model of Success and Error.

```bash
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleRequest {

    private String request;
}
```

```bash
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuccessSampleResponse {

    private String response;
}
```

```bash
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BadRequestSampleResponse {

    private String httpMethod;
    private String requestUri;
    private String errorTimestamp;
    private String error;
}
```
Similarly you can create other error response models.

5. Create a swagger annotation. Annotation name will be same as the file name. So, I have created an interface and named it <i>SumitDoucmentContract</i>. 

```bash
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
```
6. Create a Rest API by adding a controller layer
```bash
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
```
7. Add Request and Response Model as per your use case.

8. Now, hit the root URL : http://localhost:8080/swagger-ui/index.html in your browser after running the application. 

**Congratulation! Swagger UI is created for Rest API is created successfully**

If you want the Swagger YAML file for the previously constructed Swagger UI, follow the instructions below.

1. Open the link in your browser : http://localhost:8080/v3/api-docs . You can see the JSON code of Swagger UI. Select it all.
2. Now in another tab open Swagger editor : https://editor.swagger.io/ . Paste all the JSON code on the left side. You will be asked <i>Would you like to convert your JSON into YAML?</i>, select OK.

**Congratulation! On Right side is the same Swagger UI and on the left side is you have your Json Swagger Code for YAML File ready.**

## FAQ

<details>
    <summary><I>Explain in brief about springdoc-openapi-ui ?</I></summary>

* springdoc-openapi java library helps to automate the generation of API documentation using spring boot projects. 
* springdoc-openapi works by examining an application at runtime to infer API semantics based on spring configurations, class structure and various annotations.
* Automatically generates documentation in JSON/YAML and HTML format APIs. This documentation can be completed by comments using swagger-api annotations.
* This library supports:
* * OpenAPI 3
* * Spring-boot (v1 and v2)
* * JSR-303, specifically for @NotNull, @Min, @Max, and @Size.
* * Swagger-ui
* * OAuth 2
* * GraalVM native images

</details>

<details>
    <summary><I>What is the use of Lombok dependency ? </I></summary>

Lombok is used to reduce boilerplate code for model/data objects, e.g., it can generate getters and setters for those object automatically by using Lombok annotations. The easiest way is to use the @Data annotation.

</details>

<details>
    <summary><I>What are the usage of following dependencies ? </I></summary>

@Data : https://javabydeveloper.com/lombok-data-annotation/
@Builder : https://javabydeveloper.com/lombok-builder-examples/
@AllArgsConstructor : https://javabydeveloper.com/lombok-allargsconstructor-examples/
@NoArgsConstructor : https://javabydeveloper.com/lombok-noargsconstructor-examples/

@Operation : https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations#operation-annotations
@ApiResponse : https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations#apiresponse
@Content : https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations#content
@Schema : https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations#schema
	
@Target	: 
@Retention : 
@interface : 
	
@RestController :
@RequestMapping :
@PostMapping :
@RequestBody :
@Valid :
@RequestHeader :

</details>

