package de.uka.ipd.sdq.scheduler.loaddistribution;

import de.uka.ipd.sdq.scheduler.IResourceInstance;
import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;

public interface IInstanceSelector {

	/**
	 * Selects the initial instance to execute on for a process.
	 */
	public abstract IResourceInstance selectInstanceFor(ActiveProcess process);

}
