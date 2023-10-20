/* tslint:disable */
/* eslint-disable */
/**
 * Project Execution API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


import * as runtime from '../runtime';
import type {
  JobModel,
  TestParametersModel,
} from '../models/index';
import {
    JobModelFromJSON,
    JobModelToJSON,
    TestParametersModelFromJSON,
    TestParametersModelToJSON,
} from '../models/index';

export interface TestWorkflowRequest {
    testParametersModel: TestParametersModel;
}

/**
 * 
 */
export class WorkflowTestApi extends runtime.BaseAPI {

    /**
     * Execute a workflow synchronously for testing purposes.
     * Execute a workflow synchronously for testing purpose
     */
    async testWorkflowRaw(requestParameters: TestWorkflowRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<JobModel>> {
        if (requestParameters.testParametersModel === null || requestParameters.testParametersModel === undefined) {
            throw new runtime.RequiredError('testParametersModel','Required parameter requestParameters.testParametersModel was null or undefined when calling testWorkflow.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/tests/workflows`,
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: TestParametersModelToJSON(requestParameters.testParametersModel),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => JobModelFromJSON(jsonValue));
    }

    /**
     * Execute a workflow synchronously for testing purposes.
     * Execute a workflow synchronously for testing purpose
     */
    async testWorkflow(requestParameters: TestWorkflowRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<JobModel> {
        const response = await this.testWorkflowRaw(requestParameters, initOverrides);
        return await response.value();
    }

}
