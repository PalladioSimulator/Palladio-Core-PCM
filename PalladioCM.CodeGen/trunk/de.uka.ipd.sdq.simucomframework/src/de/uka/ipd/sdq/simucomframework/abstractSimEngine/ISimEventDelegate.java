package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

public interface ISimEventDelegate {

	public abstract void schedule(IEntityDelegate resource, double timeWhenNextJobIsDone);

}