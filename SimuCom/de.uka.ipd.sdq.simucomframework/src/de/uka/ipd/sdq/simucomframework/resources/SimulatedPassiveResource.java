package de.uka.ipd.sdq.simucomframework.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire;

public class SimulatedPassiveResource extends SimProcess {

	protected static Logger logger = 
		Logger.getLogger(SimulatedPassiveResource.class.getName());
	
	protected Queue<SimProcess> associatedQueue = null;
	
	private int capacity;
	
	private int available;

	private String resourceID;

	private PassiveResource resourceStatus;
	
	private List<IPassiveStateListener> stateListener;
	
	public SimulatedPassiveResource(SimuComModel myModel, String resourceID, int capacity)
	{
		super (myModel, resourceID);
		associatedQueue = new ConcurrentLinkedQueue<SimProcess>();
		stateListener = new ArrayList<IPassiveStateListener>();
		
		this.capacity = capacity;
		available = capacity;
		this.resourceID = resourceID;
		logger.debug("Simulated Passive Resource "+resourceID+" created.");
		
		myModel.getResourceRegistry().addPassiveResourceToRegistry(this);
	}
	
	public void acquire(SimProcess thread)
	{
		if (this.getModel().getSimulationControl().isRunning()){
			fireRequest(thread);
			logger.debug("Simulated thread "+thread.getName()+" requests Passive Resource "+this.resourceID);
			associatedQueue.add(thread);
			this.scheduleAt(0);
			updateSimProcessStatus(thread);
			thread.passivate();
		}
	}

	private void updateSimProcessStatus(SimProcess thread) {
		if (this.getModel().getConfig().isDebug()) {
			WaitForAcquire action = SimucomstatusFactory.eINSTANCE.createWaitForAcquire();
			action.setActionStartTime(this.getModel().getSimulationControl().getCurrentSimulationTime());
			action.setResource(this.resourceStatus);
			thread.getSimProcessStatus().setCurrentAction(action);	
		}
	}

	public void release()
	{
		if (this.getModel().getSimulationControl().isRunning()){
			available++;
			fireRelease();
			this.scheduleAt(0);
		}
	}

	@Override
	protected void internalLifeCycle() {
		while(this.getModel().getSimulationControl().isRunning())
		{
			if (associatedQueue.size()==0)
			{
				logger.debug("Queue of Passive Resource "+resourceID+" is empty. Resource going to sleep...");
				passivate();
			}
			else
			{
				if(available > 0)
				{
					available--;
					SimProcess next = associatedQueue.peek();
					associatedQueue.remove(next);
					fireAcquired(next);
					logger.debug("Simulated Process "+next.getName()+" acquired Passive Resource "+resourceID+". It continues execution now...");
					next.scheduleAt(0);
				}
				else
				{
					passivate();
				}
			}
		}
		// This resource is stopped now
		// Wake up waiting processes so that the can terminate
		SimProcess next = null;
		while ((next = associatedQueue.peek()) != null)
		{
			associatedQueue.remove(next);
			next.scheduleAt(0);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess#addProcessToSimStatus()
	 */
	@Override
	protected void addProcessToSimStatus() {
		logger.info("Starting passive resource "+this.getName());

		resourceStatus = SimucomstatusFactory.eINSTANCE.createPassiveResource();
		this.getModel().getSimulationStatus().getResourceStatus().getPassiveResources().add(resourceStatus);
		resourceStatus.setId(this.getName());
		resourceStatus.setInitialResourceCount(this.available);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess#removeProcessFromSimStatus()
	 */
	@Override
	protected void removeProcessFromSimStatus() {
		this.getModel().getSimulationStatus().getResourceStatus().getPassiveResources().remove(resourceStatus);
	}

	public void activateResource() {
		this.scheduleAt(0);
	}

	public void deactivateResource() {
		if (!this.isTerminated()){
			this.activate();
		}
	}
	
	public int getAvailable() {
		return available;
	}

	public int getCapacity() {
		return capacity;
	}

	public void addStateListener(IPassiveStateListener listener) {
		stateListener.add(listener);
	}
	
	public void fireRequest(SimProcess thread) {
		for (IPassiveStateListener l : stateListener) {
			l.request(thread);
		}
	}
	
	public void fireAcquired(SimProcess thread) {
		for (IPassiveStateListener l : stateListener) {
			l.acquired(thread);
		}		
	}
	
	public void fireRelease() {
		for (IPassiveStateListener l : stateListener) {
			l.release();
		}
	}

}
