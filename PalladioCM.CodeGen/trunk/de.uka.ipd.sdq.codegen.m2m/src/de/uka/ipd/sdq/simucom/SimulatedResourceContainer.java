package de.uka.ipd.sdq.simucom;

public class SimulatedResourceContainer {

	private String myContainerID = null;
	
	public SimulatedResourceContainer(String containerID) {
		myContainerID = containerID;
	}

	public void load(double demand) {
		System.out.println("Resource demanded "+demand+" on "+myContainerID);
	}

	public String getResourceContainerID() {
		return myContainerID;
	}

}
