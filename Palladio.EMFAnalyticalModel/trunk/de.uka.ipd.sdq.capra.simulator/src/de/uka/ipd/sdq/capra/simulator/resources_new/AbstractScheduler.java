package de.uka.ipd.sdq.capra.simulator.resources_new;

import java.util.List;

public abstract class AbstractScheduler implements IScheduler {

	
	public abstract void schedule();


	@Override
	public void registerNewProcess(ActiveProcess process) {
		// TODO Auto-generated method stub

	}

	/**
	 * @uml.property   name="processRegistry"
	 * @uml.associationEnd   aggregation="composite" inverse="abstractScheduler:de.uka.ipd.sdq.capra.simulator.resources_new.ProcessRegistry"
	 */
	private ProcessRegistry<ActiveProcess> processRegistry;

	/**
	 * Getter of the property <tt>processRegistry</tt>
	 * 
	 * @return Returns the processRegistry.
	 * @uml.property name="processRegistry"
	 */
	public ProcessRegistry<ActiveProcess> getProcessRegistry() {
		return processRegistry;
	}

	/**
	 * Setter of the property <tt>processRegistry</tt>
	 * 
	 * @param processRegistry
	 *            The processRegistry to set.
	 * @uml.property name="processRegistry"
	 */
	public void setProcessRegistry(
			ProcessRegistry<ActiveProcess> processRegistry) {
				this.processRegistry = processRegistry;
			}

	/**
	 * Determines and schedules the next event for a process. This can either be
	 * the finishing of a demand or a timeslice expired.
	 */
	public abstract void scheduleNextEventFor(ActiveProcess process);
	
	/**
	 * @uml.property  name="idleInstanceList"
	 * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" aggregation="composite" inverse="abstractScheduler:de.uka.ipd.sdq.capra.simulator.resources_new.SimResourceInstance"
	 */
	private List<SimResourceInstance> idleInstanceList;

	/**
	 * Getter of the property <tt>idleInstanceList</tt>
	 * @return  Returns the idleInstanceList.
	 * @uml.property  name="idleInstanceList"
	 */
	public List<SimResourceInstance> getIdleInstanceList() {
		return idleInstanceList;
	}

	/**
	 * Setter of the property <tt>idleInstanceList</tt>
	 * @param idleInstanceList  The idleInstanceList to set.
	 * @uml.property  name="idleInstanceList"
	 */
	public void setIdleInstanceList(List<SimResourceInstance> idleInstanceList) {
		this.idleInstanceList = idleInstanceList;
	}

	/**
	 * @uml.property  name="activeInstanceList"
	 * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" aggregation="composite" inverse="abstractScheduler:de.uka.ipd.sdq.capra.simulator.resources_new.SimResourceInstance"
	 */
	private List<SimResourceInstance> activeInstanceList;

	/**
	 * Getter of the property <tt>activeInstanceList</tt>
	 * @return  Returns the activeInstanceList.
	 * @uml.property  name="activeInstanceList"
	 */
	public List<SimResourceInstance> getActiveInstanceList() {
		return activeInstanceList;
	}

	/**
	 * Setter of the property <tt>activeInstanceList</tt>
	 * @param activeInstanceList  The activeInstanceList to set.
	 * @uml.property  name="activeInstanceList"
	 */
	public void setActiveInstanceList(
			List<SimResourceInstance> activeInstanceList) {
				this.activeInstanceList = activeInstanceList;
			}

	/**
	 * @uml.property  name="resource"
	 * @uml.associationEnd  inverse="abstractScheduler:de.uka.ipd.sdq.capra.simulator.resources_new.SimActiveResource"
	 */
	private SimActiveResource resource;

	/**
	 * Getter of the property <tt>resource</tt>
	 * @return  Returns the resource.
	 * @uml.property  name="resource"
	 */
	public SimActiveResource getResource() {
		return resource;
	}


	/**
	 * Setter of the property <tt>resource</tt>
	 * @param resource  The resource to set.
	 * @uml.property  name="resource"
	 */
	public void setResource(SimActiveResource resource) {
		this.resource = resource;
	}


		
		/**
		 */
		public SimResourceInstance getInstance(boolean instance_id){
			return null;
		}

		/**
		 * @uml.property   name="processSelector"
		 * @uml.associationEnd   inverse="abstractScheduler:de.uka.ipd.sdq.capra.simulator.resources_new.IQueueingStrategy"
		 */
		private IQueueingStrategy processSelector;

		/**
		 * Getter of the property <tt>processSelector</tt>
		 * @return  Returns the processSelector.
		 * @uml.property  name="processSelector"
		 */
		public IQueueingStrategy getProcessSelector() {
			return processSelector;
		}


		/**
		 * Setter of the property <tt>processSelector</tt>
		 * @param processSelector  The processSelector to set.
		 * @uml.property  name="processSelector"
		 */
		public void setProcessSelector(IQueueingStrategy processSelector) {
			this.processSelector = processSelector;
		}

}
