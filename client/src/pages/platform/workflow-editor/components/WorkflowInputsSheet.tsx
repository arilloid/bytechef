import {Button} from '@/components/ui/button';
import {Sheet, SheetContent, SheetHeader, SheetTitle} from '@/components/ui/sheet';
import WorkflowInputsSheetDialog from '@/pages/platform/workflow-editor/components/WorkflowInputsSheetDialog';
import WorkflowInputsSheetTable from '@/pages/platform/workflow-editor/components/WorkflowInputsSheetTable';
import {Workflow} from '@/shared/middleware/automation/configuration';
import {WorkflowTestConfiguration} from '@/shared/middleware/platform/configuration';

interface WorkflowInputsSheetProps {
    onClose: () => void;
    workflow: Workflow;
    workflowTestConfiguration?: WorkflowTestConfiguration;
}

const WorkflowInputsSheet = ({onClose, workflow, workflowTestConfiguration}: WorkflowInputsSheetProps) => (
    <Sheet onOpenChange={onClose} open>
        <SheetContent
            className="flex flex-col p-4 sm:max-w-workflow-inputs-sheet-width"
            onFocusOutside={(event) => event.preventDefault()}
            onPointerDownOutside={(event) => event.preventDefault()}
        >
            <SheetHeader>
                <div className="flex items-center justify-between">
                    <SheetTitle className="flex">Workflow Inputs</SheetTitle>

                    <div className="mx-8 flex items-center">
                        {workflow.inputs && workflow.inputs.length > 0 && (
                            <WorkflowInputsSheetDialog
                                triggerNode={<Button size="sm">New Input</Button>}
                                workflow={workflow}
                                workflowTestConfiguration={workflowTestConfiguration}
                            />
                        )}
                    </div>
                </div>
            </SheetHeader>

            <WorkflowInputsSheetTable workflow={workflow} workflowTestConfiguration={workflowTestConfiguration} />
        </SheetContent>
    </Sheet>
);

export default WorkflowInputsSheet;
