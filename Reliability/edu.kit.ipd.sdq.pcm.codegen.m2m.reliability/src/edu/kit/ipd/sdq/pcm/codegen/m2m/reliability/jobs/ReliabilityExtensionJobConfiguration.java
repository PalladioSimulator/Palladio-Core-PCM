package edu.kit.ipd.sdq.pcm.codegen.m2m.reliability.jobs;

import de.uka.ipd.sdq.workflow.launchconfig.extension.AbstractExtensionJobConfiguration;

public class ReliabilityExtensionJobConfiguration extends
		AbstractExtensionJobConfiguration {
	
	private boolean simulateFailures = false;

	public boolean isSimulateFailures() {
		return simulateFailures;
	}

	public void setSimulateFailures(boolean simulateFailures) {
		this.simulateFailures = simulateFailures;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDefaults() {
		// TODO Auto-generated method stub

	}

}
