package de.uka.ipd.sdq.simulation;

import de.uka.ipd.sdq.pcm.repository.OperationInterface;

public class SimulatedRole {

    private final String id;
    private final OperationInterface interfaze;
    private SimulatedRole linkedRole;
    private final SimulatedComponentInstance componentInstance;

    public SimulatedRole(final OperationInterface interfaze, final String id, final SimulatedComponentInstance component) {
        this.interfaze = interfaze;
        this.id = id;
        this.componentInstance = component;
    }

    public OperationInterface getInterface() {
        return this.interfaze;
    }

    private void setLinkedRole(final SimulatedRole role) {
        this.linkedRole = role;
    }

    public SimulatedRole getLinkedRole() {
        return this.linkedRole;
    }

    public String getId() {
        return this.id;
    }

    public static void linkRoles(final SimulatedRole r1, final SimulatedRole r2) {
        r1.setLinkedRole(r2);
        r2.setLinkedRole(r1);
    }

    public SimulatedComponentInstance getComponent() {
        return this.componentInstance;
    }

}
