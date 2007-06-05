package de.uka.ipd.sdq.codegen.simucontroller.workflow;

public interface ISimulationJob {
	public void execute() throws Exception;
	public void rollback() throws Exception;
	public String getName();
}
