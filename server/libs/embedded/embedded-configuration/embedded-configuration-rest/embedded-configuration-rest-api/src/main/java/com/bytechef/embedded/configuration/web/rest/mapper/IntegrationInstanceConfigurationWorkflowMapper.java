/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.embedded.configuration.web.rest.mapper;

import com.bytechef.embedded.configuration.domain.IntegrationInstanceConfigurationWorkflow;
import com.bytechef.embedded.configuration.dto.IntegrationInstanceConfigurationWorkflowDTO;
import com.bytechef.embedded.configuration.web.rest.mapper.config.EmbeddedConfigurationMapperSpringConfig;
import com.bytechef.embedded.configuration.web.rest.model.IntegrationInstanceConfigurationWorkflowModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.extensions.spring.DelegatingConverter;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Ivica Cardic
 */
public class IntegrationInstanceConfigurationWorkflowMapper {

    @Mapper(config = EmbeddedConfigurationMapperSpringConfig.class)
    public interface IntegrationInstanceWorkflowToIntegrationInstanceWorkflowModelMapper
        extends Converter<IntegrationInstanceConfigurationWorkflow, IntegrationInstanceConfigurationWorkflowModel> {

        @Override
        @Mapping(target = "lastExecutionDate", ignore = true)
        @Mapping(target = "workflowReferenceCode", ignore = true)
        IntegrationInstanceConfigurationWorkflowModel convert(
            IntegrationInstanceConfigurationWorkflow integrationInstanceConfigurationWorkflow);

        @InheritInverseConfiguration
        @DelegatingConverter
        IntegrationInstanceConfigurationWorkflow invertConvert(
            IntegrationInstanceConfigurationWorkflowModel integrationInstanceConfigurationWorkflowModel);
    }

    @Mapper(config = EmbeddedConfigurationMapperSpringConfig.class)
    public interface IntegrationInstanceWorkflowDTOToIntegrationInstanceWorkflowModelMapper
        extends Converter<IntegrationInstanceConfigurationWorkflowDTO, IntegrationInstanceConfigurationWorkflowModel> {

        @Override
        IntegrationInstanceConfigurationWorkflowModel convert(
            IntegrationInstanceConfigurationWorkflowDTO integrationInstanceWorkflow);

        @InheritInverseConfiguration
        @DelegatingConverter
        IntegrationInstanceConfigurationWorkflowDTO invertConvert(
            IntegrationInstanceConfigurationWorkflowModel integrationInstanceConfigurationWorkflowModel);
    }
}
