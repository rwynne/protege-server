package org.protege.owl.server.api;

import org.protege.owl.server.api.exception.OWLServerException;
import org.protege.owl.server.versioning.ServerDocument;

import java.util.List;
import java.util.Map;

import edu.stanford.protege.metaproject.api.AuthToken;
import edu.stanford.protege.metaproject.api.Operation;
import edu.stanford.protege.metaproject.api.OperationId;
import edu.stanford.protege.metaproject.api.Project;
import edu.stanford.protege.metaproject.api.ProjectId;
import edu.stanford.protege.metaproject.api.Role;
import edu.stanford.protege.metaproject.api.RoleId;
import edu.stanford.protege.metaproject.api.User;
import edu.stanford.protege.metaproject.api.UserId;

/**
 * @author Josef Hardi <johardi@stanford.edu> <br>
 * Stanford Center for Biomedical Informatics Research
 */
public class ServerFilterAdapter extends AbstractServerFilter {

    public ServerFilterAdapter(ServerLayer delegate) {
        super(delegate);
    }

    @Override
    public void createUser(AuthToken token, User newUser) throws Exception {
        getDelegate().createUser(token, newUser);
    }

    @Override
    public void deleteUser(AuthToken token, UserId userId) throws Exception {
        getDelegate().deleteUser(token, userId);
    }

    @Override
    public void updateUser(AuthToken token, UserId userId, User user) throws Exception {
        getDelegate().updateUser(token, userId, user);
    }

    @Override
    public void createProject(AuthToken token, Project newProject) throws Exception {
        getDelegate().createProject(token, newProject);
    }

    @Override
    public void deleteProject(AuthToken token, ProjectId projectId) throws Exception {
        getDelegate().deleteProject(token, projectId);
    }

    @Override
    public void updateProject(AuthToken token, ProjectId projectId, Project newProject) throws Exception {
        getDelegate().updateProject(token, projectId, newProject);
    }

    @Override
    public ServerDocument openProject(AuthToken token, ProjectId projectId) throws Exception {
        return getDelegate().openProject(token, projectId);
    }

    @Override
    public void createRole(AuthToken token, Role newRole) throws Exception {
        getDelegate().createRole(token, newRole);
    }

    @Override
    public void deleteRole(AuthToken token, RoleId roleId) throws Exception {
        getDelegate().deleteRole(token, roleId);
    }

    @Override
    public void updateRole(AuthToken token, RoleId roleId, Role newRole) throws Exception {
        getDelegate().updateRole(token, roleId, newRole);
    }

    @Override
    public void createOperation(AuthToken token, Operation operation) throws Exception {
        getDelegate().createOperation(token, operation);
    }

    @Override
    public void deleteOperation(AuthToken token, OperationId operationId) throws Exception {
        getDelegate().deleteOperation(token, operationId);
    }

    @Override
    public void updateOperation(AuthToken token, OperationId operationId, Operation newOperation)
            throws Exception {
        getDelegate().updateOperation(token, operationId, newOperation);
    }

    @Override
    public void assignRole(AuthToken token, UserId userId, ProjectId projectId, RoleId roleId)
            throws Exception {
        getDelegate().assignRole(token, userId, projectId, roleId);
    }

    @Override
    public void retractRole(AuthToken token, UserId userId, ProjectId projectId, RoleId roleId)
            throws Exception {
        getDelegate().retractRole(token, userId, projectId, roleId);
    }

    @Override
    public void setServerConfiguration(AuthToken token, String property, String value)
            throws Exception {
        getDelegate().setServerConfiguration(token, property, value);
    }

    @Override
    public void commit(AuthToken token, Project project, CommitBundle changes) throws Exception {
        getDelegate().commit(token, project, changes);
    }

    @Override
    public void setTransport(TransportHandler transport) throws OWLServerException {
        getDelegate().setTransport(transport);
    }

    @Override
    public void addServerListener(ServerListener listener) {
        getDelegate().addServerListener(listener);
    }

    @Override
    public void removeServerListener(ServerListener listener) {
        getDelegate().removeServerListener(listener);
    }

    @Override
    public List<User> getAllUsers(AuthToken token) throws Exception {
        return getDelegate().getAllUsers(token);
    }

    @Override
    public List<Project> getProjects(AuthToken token, UserId userId) throws Exception {
        return getDelegate().getProjects(token, userId);
    }

    @Override
    public List<Project> getAllProjects(AuthToken token) throws Exception {
        return getDelegate().getAllProjects(token);
    }

    @Override
    public Map<ProjectId, List<Role>> getRoles(AuthToken token, UserId userId) throws Exception {
        return getDelegate().getRoles(token, userId);
    }

    @Override
    public List<Role> getRoles(AuthToken token, UserId userId, ProjectId projectId) throws Exception {
        return getDelegate().getRoles(token, userId, projectId);
    }

    @Override
    public List<Role> getAllRoles(AuthToken token) throws Exception {
        return getDelegate().getAllRoles(token);
    }

    @Override
    public Map<ProjectId, List<Operation>> getOperations(AuthToken token, UserId userId) throws Exception {
        return getDelegate().getOperations(token, userId);
    }

    @Override
    public List<Operation> getOperations(AuthToken token, UserId userId, ProjectId projectId)
            throws Exception {
        return getDelegate().getOperations(token, userId, projectId);
    }

    @Override
    public List<Operation> getAllOperations(AuthToken token) throws Exception {
        return getDelegate().getAllOperations(token);
    }

    @Override
    public boolean isOperationAllowed(AuthToken token, OperationId operationId, ProjectId projectId, UserId userId)
            throws Exception {
        return getDelegate().isOperationAllowed(token, operationId, projectId, userId);
    }
}
