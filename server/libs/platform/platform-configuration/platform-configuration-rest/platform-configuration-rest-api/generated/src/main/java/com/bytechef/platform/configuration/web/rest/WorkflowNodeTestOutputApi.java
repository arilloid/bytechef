/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.9.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.platform.configuration.web.rest;

import com.bytechef.platform.configuration.web.rest.model.WorkflowNodeTestOutputModel;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-20T13:40:06.558198+02:00[Europe/Zagreb]", comments = "Generator version: 7.9.0")
@Validated
@Tag(name = "workflow-node-test-output", description = "The Platform Workflow Node Test Output Internal API")
public interface WorkflowNodeTestOutputApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /workflows/{id}/test-outputs/{workflowNodeName} : Delete existing workflow node test output
     * Delete existing workflow node test output.
     *
     * @param id The id of a workflow. (required)
     * @param workflowNodeName The name of a workflow node for which to create test output objects. (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "deleteWorkflowNodeTestOutput",
        summary = "Delete existing workflow node test output",
        description = "Delete existing workflow node test output.",
        tags = { "workflow-node-test-output" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/workflows/{id}/test-outputs/{workflowNodeName}"
    )
    
    default ResponseEntity<Void> deleteWorkflowNodeTestOutput(
        @Parameter(name = "id", description = "The id of a workflow.", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "workflowNodeName", description = "The name of a workflow node for which to create test output objects.", required = true, in = ParameterIn.PATH) @PathVariable("workflowNodeName") String workflowNodeName
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /workflows/{id}/test-outputs/{workflowNodeName} : Create a new or update existing workflow node test output
     * Create a new or update existing workflow node test output.
     *
     * @param id The id of a workflow. (required)
     * @param workflowNodeName The name of a workflow node for which to create test output objects. (required)
     * @return The workflow node test output object. (status code 200)
     */
    @Operation(
        operationId = "saveWorkflowNodeTestOutput",
        summary = "Create a new or update existing workflow node test output",
        description = "Create a new or update existing workflow node test output.",
        tags = { "workflow-node-test-output" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The workflow node test output object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = WorkflowNodeTestOutputModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/workflows/{id}/test-outputs/{workflowNodeName}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<WorkflowNodeTestOutputModel> saveWorkflowNodeTestOutput(
        @Parameter(name = "id", description = "The id of a workflow.", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "workflowNodeName", description = "The name of a workflow node for which to create test output objects.", required = true, in = ParameterIn.PATH) @PathVariable("workflowNodeName") String workflowNodeName
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"workflowNodeName\" : \"workflowNodeName\", \"id\" : 0, \"workflowId\" : \"workflowId\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /workflows/{id}/test-outputs/{workflowNodeName}/sample-output : Upload a sample output to create a new or update existing workflow node test output
     * Upload a sample output to create a new or update existing workflow node test output.
     *
     * @param id The id of a workflow. (required)
     * @param workflowNodeName The name of a workflow node for which to create test output objects. (required)
     * @param body  (required)
     * @return The workflow node test output object. (status code 200)
     */
    @Operation(
        operationId = "uploadWorkflowNodeSampleOutput",
        summary = "Upload a sample output to create a new or update existing workflow node test output",
        description = "Upload a sample output to create a new or update existing workflow node test output.",
        tags = { "workflow-node-test-output" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The workflow node test output object.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = WorkflowNodeTestOutputModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/workflows/{id}/test-outputs/{workflowNodeName}/sample-output",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<WorkflowNodeTestOutputModel> uploadWorkflowNodeSampleOutput(
        @Parameter(name = "id", description = "The id of a workflow.", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "workflowNodeName", description = "The name of a workflow node for which to create test output objects.", required = true, in = ParameterIn.PATH) @PathVariable("workflowNodeName") String workflowNodeName,
        @Parameter(name = "body", description = "", required = true) @Valid @RequestBody Object body
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"workflowNodeName\" : \"workflowNodeName\", \"id\" : 0, \"workflowId\" : \"workflowId\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
