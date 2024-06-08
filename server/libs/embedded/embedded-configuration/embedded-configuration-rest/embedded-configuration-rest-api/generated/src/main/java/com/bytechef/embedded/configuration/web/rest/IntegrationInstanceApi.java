/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.embedded.configuration.web.rest;

import com.bytechef.embedded.configuration.web.rest.model.IntegrationInstanceModel;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-10T08:46:52.177283+02:00[Europe/Zagreb]", comments = "Generator version: 7.5.0")
@Validated
@Tag(name = "integration-instance", description = "the integration-instance API")
public interface IntegrationInstanceApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /integration-instances/{id} : Delete an integration instance
     * Delete an integration instance.
     *
     * @param id The id of an integration instance. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "deleteIntegrationInstance",
        summary = "Delete an integration instance",
        description = "Delete an integration instance.",
        tags = { "integration-instance" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/integration-instances/{id}"
    )
    
    default ResponseEntity<Void> deleteIntegrationInstance(
        @Parameter(name = "id", description = "The id of an integration instance.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PATCH /integration-instances/{id}/enable/{enable} : Enable/disable an integration instance
     * Enable/disable an integration instance.
     *
     * @param id The id of an integration instance. (required)
     * @param enable Enable/disable the integration instance. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "enableIntegrationInstance",
        summary = "Enable/disable an integration instance",
        description = "Enable/disable an integration instance.",
        tags = { "integration-instance" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/integration-instances/{id}/enable/{enable}"
    )
    
    default ResponseEntity<Void> enableIntegrationInstance(
        @Parameter(name = "id", description = "The id of an integration instance.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "enable", description = "Enable/disable the integration instance.", required = true, in = ParameterIn.PATH) @PathVariable("enable") Boolean enable
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PATCH /integration-instances/{id}/workflows/{workflowId}/enable/{enable} : Enable/disable an integration instance workflow
     * Enable/disable an integration instance workflow.
     *
     * @param id The id of an integration instance. (required)
     * @param workflowId The id of an integration instance workflow. (required)
     * @param enable Enable/disable the integration instance workflow. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "enableIntegrationInstanceWorkflow",
        summary = "Enable/disable an integration instance workflow",
        description = "Enable/disable an integration instance workflow.",
        tags = { "integration-instance" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/integration-instances/{id}/workflows/{workflowId}/enable/{enable}"
    )
    
    default ResponseEntity<Void> enableIntegrationInstanceWorkflow(
        @Parameter(name = "id", description = "The id of an integration instance.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "workflowId", description = "The id of an integration instance workflow.", required = true, in = ParameterIn.PATH) @PathVariable("workflowId") String workflowId,
        @Parameter(name = "enable", description = "Enable/disable the integration instance workflow.", required = true, in = ParameterIn.PATH) @PathVariable("enable") Boolean enable
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /integration-instances/{id} : Get an integration instance by id
     * Get an integration instance by id.
     *
     * @param id The id of an integration instance. (required)
     * @return The integration instance object. (status code 200)
     */
    @Operation(
        operationId = "getIntegrationInstance",
        summary = "Get an integration instance by id",
        description = "Get an integration instance by id.",
        tags = { "integration-instance" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The integration instance object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = IntegrationInstanceModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/integration-instances/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<IntegrationInstanceModel> getIntegrationInstance(
        @Parameter(name = "id", description = "The id of an integration instance.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"integrationInstanceConfigurationId\" : 7, \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"integrationInstanceConfiguration\" : { \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"createdBy\" : \"createdBy\", \"lastModifiedDate\" : \"2000-01-23T04:56:07.000+00:00\", \"lastModifiedBy\" : \"lastModifiedBy\", \"integrationVersion\" : 2, \"description\" : \"description\", \"integrationId\" : 5, \"id\" : 5, \"lastExecutionDate\" : \"2000-01-23T04:56:07.000+00:00\", \"enabled\" : true }, \"enabled\" : true, \"connectedUserId\" : 6, \"__version\" : 3, \"createdDate\" : \"2000-01-23T04:56:07.000+00:00\", \"integrationInstanceWorkflows\" : [ { \"integrationInstanceConfigurationWorkflowId\" : 9, \"inputs\" : { \"key\" : \"\" }, \"enabled\" : true, \"workflowId\" : \"workflowId\" }, { \"integrationInstanceConfigurationWorkflowId\" : 9, \"inputs\" : { \"key\" : \"\" }, \"enabled\" : true, \"workflowId\" : \"workflowId\" } ], \"createdBy\" : \"createdBy\", \"connectionId\" : 0, \"id\" : 1, \"lastExecutionDate\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}