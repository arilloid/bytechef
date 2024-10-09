package com.bytechef.component.github.action;

import com.bytechef.component.definition.*;
import com.bytechef.component.github.util.GithubUtils;

import java.util.Map;

import static com.bytechef.component.definition.ComponentDsl.action;
import static com.bytechef.component.definition.ComponentDsl.outputSchema;
import static com.bytechef.component.definition.ComponentDsl.string;
import static com.bytechef.component.definition.Context.Http.responseType;
import static com.bytechef.component.github.constant.GithubConstants.ADD_ASSIGNEES_TO_ISSUE;
import static com.bytechef.component.github.constant.GithubConstants.REPOSITORY;
import static com.bytechef.component.github.constant.GithubConstants.ISSUE;
import static com.bytechef.component.github.constant.GithubConstants.ISSUE_OUTPUT_PROPERTY;
import static com.bytechef.component.github.constant.GithubConstants.ASSIGNEES;
import static com.bytechef.component.github.util.GithubUtils.getOwnerName;

public class GithubAddAssigneesToIssueAction {


  public static final ComponentDsl.ModifiableActionDefinition ACTION_DEFINITION = action(ADD_ASSIGNEES_TO_ISSUE)
    .title("Add assignee to an issue")
    .description("Adds an assignees to the specified issue.")
    .properties(
      string(REPOSITORY)
        .options((OptionsDataSource.ActionOptionsFunction<String>) GithubUtils::getRepositoryOptions)
        .label("Repository")
        .required(true),
      string(ISSUE)
        .options((OptionsDataSource.ActionOptionsFunction<String>) GithubUtils::getIssueOptions)
        .optionsLookupDependsOn(REPOSITORY)
        .label("Issue")
        .description("The issue to add assignee to.")
        .required(true),
      string(ASSIGNEES)
        .options((OptionsDataSource.ActionOptionsFunction<String>) GithubUtils::getCollaborators)
        .optionsLookupDependsOn(REPOSITORY)
        .label("Assignees")
        .description("The list of assignees to add to the issue.")
        .required(true))
    .output(outputSchema(ISSUE_OUTPUT_PROPERTY))
    .perform(GithubAddAssigneesToIssueAction::perform);

  private GithubAddAssigneesToIssueAction() {
  }

  public static Map<String, Object> perform(
    Parameters inputParameters, Parameters connectionParameters, ActionContext context) {

    return context
      .http(http -> http.post(
        "/repos/" + getOwnerName(context) + "/" + inputParameters.getRequiredString(REPOSITORY)
          + "/issues/" + inputParameters.getRequiredString(ISSUE) + "/assignees"))
      .body(Context.Http.Body.of(Map.of(ASSIGNEES, inputParameters.getRequiredString(ASSIGNEES))))
      .configuration(responseType(Context.Http.ResponseType.JSON))
      .execute()
      .getBody(new TypeReference<>() {});

  }
}
