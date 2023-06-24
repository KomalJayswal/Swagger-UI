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
	<version>1.6.14</version>
</dependency>
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
</dependency> 
```
For Reactive application, you can use below pom dependency
```bash
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-webflux-ui</artifactId>
<version>1.6.14</version>
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

For webflux, use `spring openapi starter ui` dependency
```
   <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      <version>2.0.2</version>
   </dependency>
```

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

The dependencies you mentioned are annotations commonly used in Java frameworks like Spring Boot, specifically in the context of building RESTful web services. Here's an explanation of each annotation and its usage:

@Data:

Provided by the Lombok library, it generates boilerplate code for getter, setter, toString, equals, and hashCode methods.
It reduces the amount of code required for data objects and improves code readability.

@Builder:

Also from Lombok, it generates a builder pattern for constructing objects.
It provides a convenient way to create instances with a fluent API, reducing the verbosity of traditional constructors.

@AllArgsConstructor:

Another Lombok annotation, it generates a constructor with parameters for all fields in a class.
It saves developers from writing boilerplate code for constructors when all fields need to be initialized.

@NoArgsConstructor:

This Lombok annotation generates a no-argument constructor.
It is useful when objects need to be created without explicitly passing any arguments.
@Operation:

It is part of the Springfox library used for documenting RESTful APIs with Swagger.
It represents an API operation or endpoint and allows specifying details like the operation's HTTP method, summary, and description.

@ApiResponse:

Also used with Swagger, it describes a possible response from an API operation.
It includes details like response codes, descriptions, and example payloads.

@Content:

This Swagger annotation specifies the content or media type of an API response or request body.
It is used to define the format of the data being sent or received, such as JSON or XML.

@Schema:

It is another Swagger annotation used for defining the structure and properties of a data model or object.
It allows specifying details like data types, validation rules, and documentation for the schema.

@Target:

A built-in Java annotation used to specify where another annotation can be applied.
It determines the types of Java elements (classes, fields, methods, etc.) on which the annotation can be used.

@Retention:

This Java annotation is used to specify how long an annotation should be retained.
It determines whether the annotation should be available only during compilation (SOURCE), at runtime (RUNTIME), or in the compiled bytecode (CLASS).
@interface:

It is a keyword in Java used to declare an annotation type.
It defines a new custom annotation that can be used in code.

@RestController:

This annotation is part of the Spring framework and is used to define a RESTful controller class.
It combines the functionality of the @Controller and @ResponseBody annotations, indicating that the class handles requests and returns response data.

@RequestMapping:

Another Spring annotation used to map a request URL or URI to a controller method.
It defines the endpoint or route for a specific HTTP request method (e.g., GET, POST, PUT, DELETE).

@PostMapping:

A specific variant of the @RequestMapping annotation used to map HTTP POST requests to a controller method.
It is commonly used when defining endpoints for creating or adding new resources.

@RequestBody:

This annotation is used to bind the request body to a method parameter in a controller method.
It indicates that the method parameter should be populated with the content of the HTTP request body.

@Valid:

It is used for validating method parameters or fields within a class.
When applied to a parameter or field, it triggers validation according to the specified validation rules or annotations.

@RequestHeader:

This annotation is used to map a request header value to a method parameter in a controller method.
It is typically used to extract values from HTTP request headers and bind them to method parameters for further processing.

</details>

<details>
    <summary><I>What is ResponseEntity in Java ? </I></summary>

ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response. If we want to use it, we have to return it from the endpoint; Spring takes care of the rest. ResponseEntity is a generic type.

</details>

