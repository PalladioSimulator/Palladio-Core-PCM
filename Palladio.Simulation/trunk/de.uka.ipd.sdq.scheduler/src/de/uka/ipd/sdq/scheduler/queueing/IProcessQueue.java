package de.uka.ipd.sdq.scheduler.queueing;

import java.util.List;

import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public interface IProcessQueue {
	
	public int size();

	public boolean isEmpty();
	
	public boolean contains(IActiveProcess process);

	public boolean remove(IActiveProcess process);
	
	public void addLast(IActiveProcess process);

	public void addFirst(IActiveProcess process);
	
	public void add(IActiveProcess process, boolean in_front);
	
	public Iterable<IActiveProcess> ascending();
	
	public Iterable<IActiveProcess> descending();

	public IProcessQueue getBestRunnableQueue(IResourceInstance instance);

	public IActiveProcess getNextRunnableProcess(IResourceInstance instance);
	
	public IActiveProcess getNextRunnableProcess();

	public void identifyMovableProcesses(
			IResourceInstance target_instance, boolean prio_increasing,
			boolean queue_ascending, int processes_needed, List<IActiveProcess> process_list);

	public IProcessQueue createNewInstance();
}
