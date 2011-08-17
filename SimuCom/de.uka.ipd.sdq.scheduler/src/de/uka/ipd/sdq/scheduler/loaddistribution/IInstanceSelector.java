package de.uka.ipd.sdq.scheduler.loaddistribution;

import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public interface IInstanceSelector {

	/**
	 * Selects a resource instance for an executable process. This can be done
	 * initially, when a process is created. Then this method also sets the
	 * ideal instance for the process. Another scenario is that the process
	 * returns from waiting. In this case, the ideal or last instance of the
	 * process can be considered (if set). Once set, the ideal instance of a
	 * process is not changed here.
	 */
	public abstract IResourceInstance selectInstanceFor(IActiveProcess process, IResourceInstance current);

}
