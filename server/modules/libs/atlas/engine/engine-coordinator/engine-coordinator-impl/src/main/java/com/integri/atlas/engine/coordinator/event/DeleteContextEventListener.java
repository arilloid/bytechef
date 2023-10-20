/*
 * Copyright 2021 <your company/name>.
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

package com.integri.atlas.engine.coordinator.event;

import com.integri.atlas.context.service.ContextService;
import com.integri.atlas.engine.Constants;
import com.integri.atlas.engine.event.Events;
import com.integri.atlas.engine.event.WorkflowEvent;
import com.integri.atlas.engine.job.Job;
import com.integri.atlas.engine.job.JobStatus;
import com.integri.atlas.engine.job.repository.JobRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ivica Cardic
 */
public class DeleteContextEventListener implements EventListener {

    private static final Logger logger = LoggerFactory.getLogger(DeleteContextEventListener.class);

    private final ContextService contextService;
    private final JobRepository jobRepository;

    public DeleteContextEventListener(ContextService contextService, JobRepository jobRepository) {
        this.contextService = contextService;
        this.jobRepository = jobRepository;
    }

    @Override
    public void onApplicationEvent(WorkflowEvent workflowEvent) {
        if (Events.JOB_STATUS.equals(workflowEvent.getType())) {
            handleEvent(workflowEvent);
        }
    }

    private void handleEvent(WorkflowEvent workflowEvent) {
        String jobId = workflowEvent.getRequiredString(Constants.JOB_ID);

        Job job = jobRepository.getById(jobId);

        if (job == null) {
            logger.warn("Unknown job: {}", jobId);

            return;
        }

        if (JobStatus.COMPLETED.equals(job.getStatus()) || JobStatus.FAILED.equals(job.getStatus())) {
            contextService.deleteJobContext(jobId);
        }
    }
}
