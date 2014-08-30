package edu.kit.ipd.sdq.pcm.codegen.m2m.reliability.jobs;

import de.uka.ipd.sdq.workflow.extension.AbstractExtensionJobConfiguration;

/**
 * This class holds reliability-specific configuration data for SimuCom runs.
 */
public class ReliabilityExtensionJobConfiguration extends AbstractExtensionJobConfiguration {

    /**
     * Indicates if failure-on-demand occurrences are included in the simulation.
     */
    private boolean mSimulateFailures = false;

    @Override
    public final String getErrorMessage() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Indicates if failure-on-demand occurrences are included in the simulation.
     *
     * @return true, if failure-on-demand occurrences are included in the simulation
     */
    public final boolean isSimulateFailures() {
        return mSimulateFailures;
    }

    @Override
    public void setDefaults() {
        // TODO Auto-generated method stub

    }

    /**
     * Controls if failure-on-demand occurrences shall be included in the simulation.
     *
     * @param simulateFailures
     *            if set to true, failure-on-demand occurrences will be included in the simulation
     */
    public final void setSimulateFailures(final boolean simulateFailures) {
        this.mSimulateFailures = simulateFailures;
    }

}
