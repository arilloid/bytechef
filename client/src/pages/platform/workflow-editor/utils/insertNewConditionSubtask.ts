import {CONDITION_CASE_FALSE, CONDITION_CASE_TRUE} from '@/shared/constants';
import {WorkflowTask} from '@/shared/middleware/automation/configuration';

import getParentConditionTask from './getParentConditionTask';

interface GetUpdatedConditionSubtasksProps {
    conditionId: string;
    tasks: Array<WorkflowTask>;
    newTask: WorkflowTask;
    placeholderId: string;
}

export default function insertNewConditionSubtask({
    conditionId,
    newTask,
    placeholderId,
    tasks,
}: GetUpdatedConditionSubtasksProps): Array<WorkflowTask> {
    let conditionTask = tasks.find((task) => task.name === conditionId);

    if (!conditionTask) {
        conditionTask = getParentConditionTask(tasks, conditionId);
    }

    if (!conditionTask) {
        return tasks;
    }

    const conditionCase = placeholderId?.split('-')[1] === 'left' ? CONDITION_CASE_TRUE : CONDITION_CASE_FALSE;

    if (!conditionTask.parameters) {
        conditionTask.parameters = {
            caseFalse: [],
            caseTrue: [],
        };
    }

    const caseTasks: Array<WorkflowTask> =
        conditionCase === CONDITION_CASE_TRUE ? conditionTask.parameters.caseTrue : conditionTask.parameters.caseFalse;

    const nodeIndex = parseInt(placeholderId.split('-').pop() || '-1');

    if (nodeIndex === undefined || nodeIndex === -1 || typeof nodeIndex !== 'number') {
        caseTasks.push(newTask);
    } else {
        caseTasks.splice(nodeIndex, 0, newTask);

        conditionTask.parameters = {
            ...conditionTask.parameters,
            [conditionCase]: caseTasks,
        };
    }

    return tasks.map((task) => (task.name === conditionId ? conditionTask : task));
}
