package de.uka.ipd.sdq.scheduler.resources.active;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessRegistry;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;

public class SimActiveResource extends AbstractActiveResource {

	private IScheduler scheduler;
	private List<IResourceInstance> instanceList;
	private ProcessRegistry processRegistry;
	private IResourceInstance main_instance;

	public static final Logger logger = Logger.getLogger("Scheduler");

	public SimActiveResource(int capacity, String name, String id) {
		super(capacity, name, id);
		this.instanceList = new ArrayList<IResourceInstance>();
		this.processRegistry = new ProcessRegistry(this);
		for (int i = 0; i < capacity; i++) {
			instanceList.add(factory.createResourceInstance(i, this));
		}
		main_instance = instanceList.get(0);
	}

	public IScheduler getScheduler() {
		return scheduler;
	}

	public List<IResourceInstance> getInstanceList() {
		return instanceList;
	}

	public IActiveProcess lookUp(ISchedulableProcess process) {
		IActiveProcess p = processRegistry.lookUp(process);
		if (p == null){
			ISchedulableProcess parent = process;
			IActiveProcess pparent = null;
			int i=0;
			do{
				parent = parent.getAncestor();
				pparent = processRegistry.lookUp(parent);
				i++;
			} while (pparent == null && parent != null);
			assert pparent != null;
			assert i < 2;
			p = pparent.createNewInstance(process);
			processRegistry.registerProcess(p);
		}
		return p;
	}

	@Override
	public void doProcessing(ISchedulableProcess sched_process, double demand) {
		IActiveProcess process = lookUp(sched_process);
		
		LoggingWrapper.log(" Process " + process + " demands "
				+ MathTools.round(demand, 0.01));
		
		process.setCurrentDemand(demand);
		scheduler.scheduleNextEvent(process.getLastInstance());
		sched_process.passivate();
	}

	public void start() {
		for (IResourceInstance instance : this.instanceList) {
			instance.start();
		}
	}

	public boolean isIdle(IResourceInstance instance) {
		return this.scheduler.isIdle(instance);
	}

	public void setScheduler(IScheduler scheduler) {
		this.scheduler = scheduler;
	}

	@Override
	protected void dequeue(ISchedulableProcess process) {
		IActiveProcess myProcess = lookUp(process);
		scheduler.removeProcess(myProcess, myProcess.getLastInstance());
		myProcess.setIdealInstance(null);
		myProcess.setLastInstance(null);
	}

	@Override
	protected void enqueue(ISchedulableProcess process) {
		IActiveProcess p = lookUp(process);
		scheduler.addProcess(p, main_instance);
		p.getLastInstance().schedulingInterrupt(0, false);
	}

	public void stop() {
		for( IResourceInstance ri : instanceList) {
			ri.stop();
		}
	}
	
	public void registerProcess(IRunningProcess runningProcess) {
		processRegistry.registerProcess((IActiveProcess)runningProcess);
	}

	public void unregisterProcess(IActiveProcess process) {
		processRegistry.unregisterProcess(process.getSchedulableProcess());
	}


}
