package de.uka.ipd.sdq.capra.simulator.resources;

import java.util.Map;

import de.uka.ipd.sdq.capra.simulator.schedinterface.ISchedulableProcess;


public class SimActiveResource extends AbstractSimResource implements IActiveResource {

	/**
	 * @uml.property   name="scheduler"
	 * @uml.associationEnd   aggregation="composite" inverse="simActiveResource:de.uka.ipd.sdq.capra.simulator.resources.IScheduler"
	 */
	private IScheduler scheduler;

	/**
	 * Getter of the property <tt>scheduler</tt>
	 * @return  Returns the scheduler.
	 * @uml.property  name="scheduler"
	 */
	public IScheduler getScheduler() {
		return scheduler;
	}

	/**
	 * Setter of the property <tt>scheduler</tt>
	 * @param scheduler  The scheduler to set.
	 * @uml.property  name="scheduler"
	 */
	public void setScheduler(IScheduler scheduler) {
		this.scheduler = scheduler;
	}

	@Override
	public void process(ISchedulableProcess process, boolean demand) {
	}

	@Override
	public void registerNewProcess(ActiveProcess process) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @uml.property   name="instances"
	 * @uml.associationEnd   aggregation="composite" inverse="simActiveResource:de.uka.ipd.sdq.capra.simulator.resources.SimResourceInstance" qualifier="key:java.lang.Integer de.uka.ipd.sdq.capra.simulator.resources.SimResourceInstance"
	 */
	private Map<Integer, SimResourceInstance> instancesMap;

	/**
	 * Getter of the property <tt>instances</tt>
	 * @return  Returns the instancesMap.
	 * @uml.property  name="instances"
	 */
	public Map<Integer, SimResourceInstance> getInstances() {
		return instancesMap;
	}

	/**
	 * Setter of the property <tt>instances</tt>
	 * @param instances  The instancesMap to set.
	 * @uml.property  name="instances"
	 */
	public void setInstances(Map<Integer, SimResourceInstance> instances) {
		instancesMap = instances;
	}

		
		/**
		 */
		public SimResourceInstance getInstance(int instance_id){
			return null;
		}

}
