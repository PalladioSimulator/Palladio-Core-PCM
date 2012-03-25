package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;


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
