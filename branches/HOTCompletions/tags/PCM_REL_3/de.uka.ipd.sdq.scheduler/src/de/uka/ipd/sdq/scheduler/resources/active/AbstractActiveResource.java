package de.uka.ipd.sdq.scheduler
.resources.active;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.resources.AbstractSimResource;

public abstract class AbstractActiveResource extends AbstractSimResource implements
		IActiveResource {

	private static Map<ISchedulableProcess, AbstractActiveResource> currentResourceTable = new ConcurrentHashMap<ISchedulableProcess, AbstractActiveResource>();

	public AbstractActiveResource(int capacity, String name, String id) {
		super(capacity, name, id);
	}

	public final void process(ISchedulableProcess process, double demand) {
		AbstractActiveResource last = getLastResource(process);
		if (!this.equals(last)){
			if (last != null){
				last.dequeue(process);
			}
			this.enqueue(process);
			setLastResource(process, this);
		}
		doProcessing(process,demand);
	}
	
	protected abstract void doProcessing(ISchedulableProcess process, double demand);

	protected abstract void enqueue(ISchedulableProcess process);

	protected abstract void dequeue(ISchedulableProcess process);

	private static AbstractActiveResource getLastResource(ISchedulableProcess process){
		return currentResourceTable.get(process);
	}
	
	private static void setLastResource(ISchedulableProcess process, AbstractActiveResource resource ){
		currentResourceTable.put(process, resource);
	}
}
