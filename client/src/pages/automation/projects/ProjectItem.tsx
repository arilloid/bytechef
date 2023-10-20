import {useState} from 'react';
import DropdownMenu, {
    IDropdownMenuItem,
} from '../../../components/DropdownMenu/DropdownMenu';
import {ProjectModel, StatusModel, TagModel} from '../../../middleware/project';
import {
    useDeleteProjectMutation,
    useDuplicateProjectMutation,
    useUpdateProjectTagsMutation,
} from '../../../mutations/projects.mutations';
import {ProjectKeys} from '../../../queries/projects.queries';
import {useQueryClient} from '@tanstack/react-query';
import {twMerge} from 'tailwind-merge';
import {Link} from 'react-router-dom';
import ProjectDialog from './ProjectDialog';
import Name from './components/Name';
import AlertDialog from '../../../components/AlertDialog/AlertDialog';
import WorkflowDialog from './WorkflowDialog';
import TagList from '../../../components/TagList/TagList';

interface ProjectItemProps {
    project: ProjectModel;
    remainingTags?: TagModel[];
}

const ProjectItem = ({project, remainingTags}: ProjectItemProps) => {
    const [showEditDialog, setShowEditDialog] = useState(false);
    const [showDeleteDialog, setShowDeleteDialog] = useState(false);
    const [showWorkflowDialog, setShowWorkflowDialog] = useState(false);

    const dropdownItems: IDropdownMenuItem[] = [
        {
            label: 'Edit',
            onClick: () => {
                setShowEditDialog(true);
            },
        },
        {
            label: 'Duplicate',
            onClick: () => {
                duplicateProjectMutation.mutate(project.id!);
            },
        },
        {
            label: 'New Workflow',
            onClick: () => {
                setShowWorkflowDialog(true);
            },
        },
        {
            separator: true,
        },
        {
            danger: true,
            label: 'Delete',
            onClick: () => setShowDeleteDialog(true),
        },
    ];

    const queryClient = useQueryClient();

    const deleteProjectMutation = useDeleteProjectMutation({
        onSuccess: () => {
            queryClient.invalidateQueries(ProjectKeys.projects);
            queryClient.invalidateQueries(ProjectKeys.projectCategories);
            queryClient.invalidateQueries(ProjectKeys.projectTags);
        },
    });

    const duplicateProjectMutation = useDuplicateProjectMutation({
        onSuccess: () => {
            queryClient.invalidateQueries(ProjectKeys.projects);
        },
    });

    const updateProjectTagsMutation = useUpdateProjectTagsMutation({
        onSuccess: () => {
            queryClient.invalidateQueries(ProjectKeys.projects);
            queryClient.invalidateQueries(ProjectKeys.projectTags);
        },
    });

    return (
        <>
            <div className="flex items-center">
                <Link
                    className="flex-1"
                    to={`/automation/projects/${project.id}`}
                >
                    <div className="flex justify-between">
                        <div>
                            <header className="relative mb-2 flex items-center">
                                {project.description ? (
                                    <Name
                                        description={project.description}
                                        name={project.name}
                                    />
                                ) : (
                                    <span className="mr-2 text-base font-semibold text-gray-900">
                                        {project.name}
                                    </span>
                                )}

                                {project.category && (
                                    <span className="text-xs uppercase text-gray-700">
                                        {project.category.name}
                                    </span>
                                )}
                            </header>

                            <footer
                                className="flex h-[38px] items-center"
                                onClick={(event) => event.preventDefault()}
                            >
                                <div className="mr-4 text-xs font-semibold text-gray-700">
                                    {project.workflowIds?.length === 1
                                        ? `${project.workflowIds?.length} workflow`
                                        : `${project.workflowIds?.length} workflows`}
                                </div>

                                {project.tags && (
                                    <TagList
                                        id={project.id!}
                                        remainingTags={remainingTags}
                                        tags={project.tags}
                                        updateTagsMutation={
                                            updateProjectTagsMutation
                                        }
                                    />
                                )}
                            </footer>
                        </div>

                        <aside className="flex items-center">
                            <span
                                className={twMerge(
                                    'mr-4 rounded px-2.5 py-0.5 text-sm font-medium',
                                    project.status === StatusModel.Published
                                        ? 'bg-green-100 text-green-800 dark:bg-green-200 dark:text-green-900'
                                        : 'bg-gray-100 text-gray-800 dark:bg-gray-200 dark:text-gray-900'
                                )}
                            >
                                {project.status === StatusModel.Published
                                    ? `Published V${project.projectVersion}`
                                    : 'Not Published'}
                            </span>

                            <span className="mr-4 w-[76px] text-center text-sm text-gray-500">
                                {project.status === StatusModel.Published
                                    ? project.lastPublishedDate?.toLocaleDateString()
                                    : '-'}
                            </span>
                        </aside>
                    </div>
                </Link>

                <DropdownMenu id={project.id} menuItems={dropdownItems} />
            </div>

            {showEditDialog && (
                <ProjectDialog
                    project={project}
                    showTrigger={false}
                    visible
                    onClose={() => setShowEditDialog(false)}
                />
            )}

            {showDeleteDialog && (
                <AlertDialog
                    danger
                    isOpen
                    message="This action cannot be undone. This will permanently delete the project and workflows it contains."
                    title="Are you absolutely sure?"
                    setIsOpen={setShowDeleteDialog}
                    onConfirmClick={() => {
                        if (project.id) {
                            deleteProjectMutation.mutate({
                                id: project.id,
                            });
                        }
                    }}
                />
            )}

            {showWorkflowDialog && (
                <WorkflowDialog
                    id={project.id}
                    visible
                    onClose={() => setShowWorkflowDialog(false)}
                />
            )}
        </>
    );
};

export default ProjectItem;
