package edu.kit.ipd.sdq.eventsim.system.staticstructure;

import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

/**
 * A role instance is a role that is either provided or required by a {@link ComponentInstance}.
 * <p>
 * A required role and a provided role can be connected by calling the {@code linkRoles} method.
 * 
 * @author Philipp Merkle
 * 
 * @see OperationProvidedRole
 * @see OperationRequiredRole
 */
public class RoleInstance {

    private final OperationInterface interfaze;
    private final String id;
    private final ComponentInstance componentInstance;
    private RoleInstance linkedRole;

    /**
     * Constructs a role instance for the specified role id that provides or requires the specified
     * interface.
     * 
     * @param interfaze
     *            the provided or required interface
     * @param id
     *            the role id
     * @param component
     *            the component instance that owns this role
     */
    public RoleInstance(final OperationInterface interfaze, final String id, final ComponentInstance component) {
        this.interfaze = interfaze;
        this.id = id;
        this.componentInstance = component;
    }

    /**
     * Connects both specified roles. It is only allowed to connect a requiring role and a providing
     * role, which has to be ensued by the caller.
     * 
     * @param requiredRole
     *            the required role
     * @param providedRole
     *            the provided role
     */
    public static void linkRoles(final RoleInstance requiredRole, final RoleInstance providedRole) {
        requiredRole.setLinkedRole(providedRole);
        providedRole.setLinkedRole(requiredRole);
    }

    /**
     * Returns the role that has been connected to this role by using the {@code linkRoles} method.
     * 
     * @return the role that is connected to this role
     */
    public RoleInstance getLinkedRole() {
        return this.linkedRole;
    }

    /**
     * Returns the interface that is provided or required by this role.
     * 
     * @return the provided or required interface
     */
    public OperationInterface getInterface() {
        return this.interfaze;
    }

    /**
     * Returns the id of this role.
     * 
     * @return the role id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Returns the component instance that provides or requires this role.
     * 
     * @return the component instance that owns this role
     */
    public ComponentInstance getComponent() {
        return this.componentInstance;
    }

    /**
     * Sets the role to which this role is connected to.
     * 
     * @param role
     *            the role that is to be connected to this role
     */
    private void setLinkedRole(final RoleInstance role) {
        this.linkedRole = role;
    }

}
