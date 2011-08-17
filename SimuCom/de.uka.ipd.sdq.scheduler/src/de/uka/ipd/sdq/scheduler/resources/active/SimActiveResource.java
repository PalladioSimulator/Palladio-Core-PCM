package de.uka.ipd.sdq.scheduler.resources.active;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessRegistry;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.passive.WaitingProcess;
import de.uka.ipd.sdq.scheduler.sensors.IActiveResourceStateSensor;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;

public class SimActiveResource extends AbstractActiveResource {

	private IScheduler scheduler;
	private List<IResourceInstance> instanceList;
	private ProcessRegistry processRegistry;
	private IResourceInstance main_instance;
	private Deque<WaitingProcess> waiting_queue = new ArrayDeque<WaitingProcess>();

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
				parent = parent.getRootProcess();
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
		ActiveProcess myProcess = (ActiveProcess)lookUp(process);
		WaitingProcess waiting_process = new WaitingProcess(myProcess,0);
		scheduler.fromRunningToWaiting(waiting_process, waiting_queue, false);
//		myProcess.setIdealInstance(null);
//		myProcess.setLastInstance(null);
	}

	@Override
	protected void enqueue(ISchedulableProcess process) {
		WaitingProcess waiting_process = lookUpWaitingProcess(process);
		
		if (waiting_process != null) {
			IResourceInstance instance = getInstanceFor(waiting_process.getProcess());
			scheduler.fromWaitingToReady(waiting_process, waiting_queue, instance);
		} else {
			IActiveProcess p = lookUp(process);
			IResourceInstance instance = getInstanceFor(p);
			scheduler.forkNewProcess(p, instance);
			instance.schedulingInterrupt(0);
		}
	}

	private IResourceInstance getInstanceFor(IActiveProcess process) {
		IResourceInstance instance = main_instance;
		if (process.hasIdealInstance())
			instance = process.getIdealInstance();
		if (process.hasLastInstance())
			instance = process.getLastInstance();
		return instance;
	}

	private WaitingProcess lookUpWaitingProcess(ISchedulableProcess process) {
		for (WaitingProcess p : waiting_queue){
			if (p.getProcess().getSchedulableProcess().equals(process))
				return p;
		}
		return null;
	}

	public void stop() {
		for( IResourceInstance ri : instanceList) {
			ri.stop();
		}
	}
	
	public void registerProcess(IRunningProcess runningProcess) {
		IActiveProcess p = (IActiveProcess)runningProcess;
		if (!processRegistry.isRegistered(p)){
			processRegistry.registerProcess(p);
			IResourceInstance instance = getInstanceFor(p);
			scheduler.registerProcess(p, instance);
			p.getSchedulableProcess().addTerminatedObserver(this);
		}
	}

	public void unregisterProcess(IActiveProcess process) {
		processRegistry.unregisterProcess(process.getSchedulableProcess());
	}

	public void addObserver(IActiveResourceStateSensor observer) {
		for(IResourceInstance instance : this.instanceList){
			instance.addObserver(observer);
		}
		
	}

	public IActiveProcess findProcess(String processName) {
		return processRegistry.findProcess(processName);
	}
	
	public void notifyTerminated(ISchedulableProcess simProcess) {
		super.notifyTerminated(simProcess);
		IActiveProcess activeProcess = lookUp(simProcess);
		IResourceInstance instance = activeProcess.getLastInstance();
		getScheduler().terminateProcess(activeProcess, instance);
		simProcess.removeTerminatedObserver(this);
	}

	@Override
	public int getQueueLengthFor(SimResourceInstance simResourceInstance) {
		return this.scheduler.getQueueLengthFor(simResourceInstance);
	}
}
