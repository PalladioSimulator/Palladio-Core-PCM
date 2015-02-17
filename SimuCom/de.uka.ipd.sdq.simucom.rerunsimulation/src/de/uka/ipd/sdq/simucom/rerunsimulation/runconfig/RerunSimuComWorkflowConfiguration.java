package de.uka.ipd.sdq.simucom.rerunsimulation.runconfig;

import java.util.Map;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;

public class RerunSimuComWorkflowConfiguration extends SimuComWorkflowConfiguration {

    private boolean regenerateAllocation = false;

    private boolean regenerateUsage = false;

    private boolean regenerateSystem = false;

    public RerunSimuComWorkflowConfiguration(Map<String, Object> attributes) {
        super(attributes);
    }

    public boolean isRegenerateAllocation() {
        return regenerateAllocation;
    }

    public void setRegenerateAllocation(boolean regenerateAllocation) {
        this.regenerateAllocation = regenerateAllocation;
    }

    public boolean isRegenerateUsage() {
        return regenerateUsage;
    }

    public void setRegenerateUsage(boolean regenerateUsage) {
        this.regenerateUsage = regenerateUsage;
    }

    public boolean isRegenerateSystem() {
        return regenerateSystem;
    }

    public void setRegenerateSystem(boolean regenerateSystem) {
        this.regenerateSystem = regenerateSystem;
    }

}
