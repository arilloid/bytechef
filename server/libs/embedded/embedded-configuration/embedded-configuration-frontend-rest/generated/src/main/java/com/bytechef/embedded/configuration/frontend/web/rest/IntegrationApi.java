/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.9.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.embedded.configuration.frontend.web.rest;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-20T13:40:04.118048+02:00[Europe/Zagreb]", comments = "Generator version: 7.9.0")
@Validated
@Tag(name = "integration", description = "The Embedded Integration by Connected User Token accessible API")
public interface IntegrationApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /integrations : Get active configurations
     * Get active integrations.
     *
     * @param xEnvironment The environment. (optional)
     * @return The list of active integrations. (status code 200)
     */
    @Operation(
        operationId = "getIntegrations",
        summary = "Get active configurations",
        description = "Get active integrations.",
        tags = { "integration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of active integrations.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = com.bytechef.embedded.configuration.public_.web.rest.model.IntegrationModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/integrations",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<com.bytechef.embedded.configuration.public_.web.rest.model.IntegrationModel>> getIntegrations(
        @Parameter(name = "x-environment", description = "The environment.", in = ParameterIn.HEADER) @RequestHeader(value = "x-environment", required = false) com.bytechef.embedded.configuration.public_.web.rest.model.EnvironmentModel xEnvironment
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"allowMultipleInstances\" : false, \"icon\" : \"icon\", \"integrationVersion\" : 6, \"description\" : \"description\", \"componentName\" : \"componentName\", \"id\" : 0, \"title\" : \"title\" }, { \"allowMultipleInstances\" : false, \"icon\" : \"icon\", \"integrationVersion\" : 6, \"description\" : \"description\", \"componentName\" : \"componentName\", \"id\" : 0, \"title\" : \"title\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
