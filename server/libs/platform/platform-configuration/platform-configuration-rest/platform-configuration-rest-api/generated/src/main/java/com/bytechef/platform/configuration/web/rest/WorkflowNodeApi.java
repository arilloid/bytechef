/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bytechef.platform.configuration.web.rest;

import com.bytechef.platform.configuration.web.rest.model.EvaluateWorkflowNodeDisplayConditionRequestModel;
import com.bytechef.platform.configuration.web.rest.model.GetWorkflowNodeDescription200ResponseModel;
import com.bytechef.platform.configuration.web.rest.model.OptionModel;
import com.bytechef.platform.configuration.web.rest.model.PropertyModel;
import com.bytechef.platform.configuration.web.rest.model.WorkflowNodeOutputModel;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-14T16:10:55.682263+01:00[Europe/Zagreb]")
@Validated
@Tag(name = "workflow-node", description = "The Platform Workflow Node API")
public interface WorkflowNodeApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /workflows/{id}/{workflowNodeName}/display-condition : Evaluate display condition for an action or trigger property
     * Evaluate display condition for an action or trigger property.
     *
     * @param id The workflow id (required)
     * @param workflowNodeName The name of a workflow&#39;s action task or trigger (E.g. mailchimp_1) (required)
     * @param evaluateWorkflowNodeDisplayConditionRequestModel  (optional)
     * @return The list of options. (status code 200)
     */
    @Operation(
        operationId = "evaluateWorkflowNodeDisplayCondition",
        summary = "Evaluate display condition for an action or trigger property",
        description = "Evaluate display condition for an action or trigger property.",
        tags = { "workflow-node" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of options.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Boolean.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/workflows/{id}/{workflowNodeName}/display-condition",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Boolean> evaluateWorkflowNodeDisplayCondition(
        @Parameter(name = "id", description = "The workflow id", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "workflowNodeName", description = "The name of a workflow's action task or trigger (E.g. mailchimp_1)", required = true, in = ParameterIn.PATH) @PathVariable("workflowNodeName") String workflowNodeName,
        @Parameter(name = "EvaluateWorkflowNodeDisplayConditionRequestModel", description = "") @Valid @RequestBody(required = false) EvaluateWorkflowNodeDisplayConditionRequestModel evaluateWorkflowNodeDisplayConditionRequestModel
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /workflows/{id}/{workflowNodeName}/description : Get an action description shown in the editor
     * Get an action description shown in the editor.
     *
     * @param id The workflow id (required)
     * @param workflowNodeName The name of an workflow&#39;s action task or trigger (E.g. mailchimp_1) (required)
     * @return The editor description. (status code 200)
     */
    @Operation(
        operationId = "getWorkflowNodeDescription",
        summary = "Get an action description shown in the editor",
        description = "Get an action description shown in the editor.",
        tags = { "workflow-node" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The editor description.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = GetWorkflowNodeDescription200ResponseModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/workflows/{id}/{workflowNodeName}/description",
        produces = { "application/json" }
    )
    
    default ResponseEntity<GetWorkflowNodeDescription200ResponseModel> getWorkflowNodeDescription(
        @Parameter(name = "id", description = "The workflow id", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "workflowNodeName", description = "The name of an workflow's action task or trigger (E.g. mailchimp_1)", required = true, in = ParameterIn.PATH) @PathVariable("workflowNodeName") String workflowNodeName
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"description\" : \"description\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /workflows/{id}/{workflowNodeName}/properties/{propertyName}/dynamic-properties : Get dynamic properties for an action or trigger property shown in the editor
     * Get dynamic properties for an action or trigger property shown in the editor.
     *
     * @param id The workflow id (required)
     * @param workflowNodeName The name of a workflow&#39;s action task or trigger (E.g. mailchimp_1) (required)
     * @param propertyName The name of a property. (required)
     * @return The list of options. (status code 200)
     */
    @Operation(
        operationId = "getWorkflowNodeDynamicProperties",
        summary = "Get dynamic properties for an action or trigger property shown in the editor",
        description = "Get dynamic properties for an action or trigger property shown in the editor.",
        tags = { "workflow-node" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of options.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PropertyModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/workflows/{id}/{workflowNodeName}/properties/{propertyName}/dynamic-properties",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<PropertyModel>> getWorkflowNodeDynamicProperties(
        @Parameter(name = "id", description = "The workflow id", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "workflowNodeName", description = "The name of a workflow's action task or trigger (E.g. mailchimp_1)", required = true, in = ParameterIn.PATH) @PathVariable("workflowNodeName") String workflowNodeName,
        @Parameter(name = "propertyName", description = "The name of a property.", required = true, in = ParameterIn.PATH) @PathVariable("propertyName") String propertyName
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /workflows/{id}/{workflowNodeName}/properties/{propertyName}/options : Get an action or trigger property options shown in the editor
     * Get an action or trigger property options shown in the editor.
     *
     * @param id The workflow id (required)
     * @param workflowNodeName The name of a workflow&#39;s action task or trigger (E.g. mailchimp_1) (required)
     * @param propertyName The name of a property. (required)
     * @param searchText Optional search text used to filter option items (optional)
     * @return The list of options. (status code 200)
     */
    @Operation(
        operationId = "getWorkflowNodeOptions",
        summary = "Get an action or trigger property options shown in the editor",
        description = "Get an action or trigger property options shown in the editor.",
        tags = { "workflow-node" },
        responses = {
            @ApiResponse(responseCode = "200", description = "The list of options.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OptionModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/workflows/{id}/{workflowNodeName}/properties/{propertyName}/options",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<OptionModel>> getWorkflowNodeOptions(
        @Parameter(name = "id", description = "The workflow id", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "workflowNodeName", description = "The name of a workflow's action task or trigger (E.g. mailchimp_1)", required = true, in = ParameterIn.PATH) @PathVariable("workflowNodeName") String workflowNodeName,
        @Parameter(name = "propertyName", description = "The name of a property.", required = true, in = ParameterIn.PATH) @PathVariable("propertyName") String propertyName,
        @Parameter(name = "searchText", description = "Optional search text used to filter option items", in = ParameterIn.QUERY) @Valid @RequestParam(value = "searchText", required = false) String searchText
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"description\" : \"description\", \"label\" : \"label\", \"value\" : \"\" }, { \"description\" : \"description\", \"label\" : \"label\", \"value\" : \"\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /workflows/{id}/outputs/{workflowNodeName} : Get dynamic output schema of an action task or trigger used in a workflow
     * Get dynamic output schema of an action task or trigger used in a workflow.
     *
     * @param id The workflow id (required)
     * @param workflowNodeName The name of a workflow&#39;s action task or trigger (E.g. mailchimp_1) (required)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "getWorkflowNodeOutput",
        summary = "Get dynamic output schema of an action task or trigger used in a workflow",
        description = "Get dynamic output schema of an action task or trigger used in a workflow.",
        tags = { "workflow-node" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = WorkflowNodeOutputModel.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/workflows/{id}/outputs/{workflowNodeName}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<WorkflowNodeOutputModel> getWorkflowNodeOutput(
        @Parameter(name = "id", description = "The workflow id", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "workflowNodeName", description = "The name of a workflow's action task or trigger (E.g. mailchimp_1)", required = true, in = ParameterIn.PATH) @PathVariable("workflowNodeName") String workflowNodeName
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"triggerDefinition\" : { \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"outputFunctionDefined\" : true, \"name\" : \"name\", \"description\" : \"description\", \"outputDefined\" : true, \"nodeDescriptionDefined\" : true, \"componentName\" : \"componentName\", \"componentVersion\" : 0, \"title\" : \"title\", \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ] }, \"outputSchema\" : { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, \"workflowNodeName\" : \"workflowNodeName\", \"actionDefinition\" : { \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"outputFunctionDefined\" : true, \"name\" : \"name\", \"description\" : \"description\", \"outputDefined\" : true, \"nodeDescriptionDefined\" : true, \"componentName\" : \"componentName\", \"componentVersion\" : 0, \"title\" : \"title\", \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ] }, \"taskDispatcherDefinition\" : { \"taskProperties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ], \"outputFunctionDefined\" : true, \"variablePropertiesDefined\" : true, \"icon\" : \"icon\", \"name\" : \"name\", \"description\" : \"description\", \"outputDefined\" : true, \"resources\" : { \"documentationUrl\" : \"documentationUrl\" }, \"title\" : \"title\", \"version\" : 0, \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ] }, \"sampleOutput\" : \"{}\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /workflows/{id}/outputs : Get all dynamic output schemas used in a workflow
     * Get all dynamic output schemas used in a workflow.
     *
     * @param id The workflow id for which to return all used action definitions (required)
     * @param lastWorkflowNodeName The name of the last workflow node (action task or trigger) up to which include the output schema (E.g. mailchimp_1, airtable_3) (optional)
     * @return Successful operation. (status code 200)
     */
    @Operation(
        operationId = "getWorkflowNodeOutputs",
        summary = "Get all dynamic output schemas used in a workflow",
        description = "Get all dynamic output schemas used in a workflow.",
        tags = { "workflow-node" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation.", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = WorkflowNodeOutputModel.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/workflows/{id}/outputs",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<WorkflowNodeOutputModel>> getWorkflowNodeOutputs(
        @Parameter(name = "id", description = "The workflow id for which to return all used action definitions", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "lastWorkflowNodeName", description = "The name of the last workflow node (action task or trigger) up to which include the output schema (E.g. mailchimp_1, airtable_3)", in = ParameterIn.QUERY) @Valid @RequestParam(value = "lastWorkflowNodeName", required = false) String lastWorkflowNodeName
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"triggerDefinition\" : { \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"outputFunctionDefined\" : true, \"name\" : \"name\", \"description\" : \"description\", \"outputDefined\" : true, \"nodeDescriptionDefined\" : true, \"componentName\" : \"componentName\", \"componentVersion\" : 0, \"title\" : \"title\", \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ] }, \"outputSchema\" : { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, \"workflowNodeName\" : \"workflowNodeName\", \"actionDefinition\" : { \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"outputFunctionDefined\" : true, \"name\" : \"name\", \"description\" : \"description\", \"outputDefined\" : true, \"nodeDescriptionDefined\" : true, \"componentName\" : \"componentName\", \"componentVersion\" : 0, \"title\" : \"title\", \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ] }, \"taskDispatcherDefinition\" : { \"taskProperties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ], \"outputFunctionDefined\" : true, \"variablePropertiesDefined\" : true, \"icon\" : \"icon\", \"name\" : \"name\", \"description\" : \"description\", \"outputDefined\" : true, \"resources\" : { \"documentationUrl\" : \"documentationUrl\" }, \"title\" : \"title\", \"version\" : 0, \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ] }, \"sampleOutput\" : \"{}\" }, { \"triggerDefinition\" : { \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"outputFunctionDefined\" : true, \"name\" : \"name\", \"description\" : \"description\", \"outputDefined\" : true, \"nodeDescriptionDefined\" : true, \"componentName\" : \"componentName\", \"componentVersion\" : 0, \"title\" : \"title\", \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ] }, \"outputSchema\" : { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, \"workflowNodeName\" : \"workflowNodeName\", \"actionDefinition\" : { \"help\" : { \"body\" : \"body\", \"learnMoreUrl\" : \"learnMoreUrl\" }, \"outputFunctionDefined\" : true, \"name\" : \"name\", \"description\" : \"description\", \"outputDefined\" : true, \"nodeDescriptionDefined\" : true, \"componentName\" : \"componentName\", \"componentVersion\" : 0, \"title\" : \"title\", \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ] }, \"taskDispatcherDefinition\" : { \"taskProperties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ], \"outputFunctionDefined\" : true, \"variablePropertiesDefined\" : true, \"icon\" : \"icon\", \"name\" : \"name\", \"description\" : \"description\", \"outputDefined\" : true, \"resources\" : { \"documentationUrl\" : \"documentationUrl\" }, \"title\" : \"title\", \"version\" : 0, \"properties\" : [ { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true }, { \"displayCondition\" : \"displayCondition\", \"hidden\" : true, \"name\" : \"name\", \"description\" : \"description\", \"advancedOption\" : true, \"required\" : true, \"expressionEnabled\" : true } ] }, \"sampleOutput\" : \"{}\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
