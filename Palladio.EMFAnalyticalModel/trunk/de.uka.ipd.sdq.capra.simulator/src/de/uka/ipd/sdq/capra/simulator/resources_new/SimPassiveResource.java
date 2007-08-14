package de.uka.ipd.sdq.capra.simulator.resources_new;

import de.uka.ipd.sdq.capra.simulator.schedinterface.ISchedulableProcess;


public class SimPassiveResource extends AbstractSimResource implements IPassiveResource {



			/** 
			 * @uml.property name="waitingPolicy"
			 * @uml.associationEnd aggregation="composite" inverse="passiveResource:de.uka.ipd.sdq.capra.simulator.resources_new.AbstractWaitingPolicy"
			 */
			private AbstractWaitingPolicy abstractWaitingPolicy;


			/**
			 * Getter of the property <tt>waitingPolicy</tt>
			 * @return  Returns the abstractWaitingPolicy.
			 * @uml.property  name="waitingPolicy"
			 */
			public AbstractWaitingPolicy getWaitingPolicy() {
				return abstractWaitingPolicy;
			}


			/**
			 * Setter of the property <tt>waitingPolicy</tt>
			 * @param waitingPolicy  The abstractWaitingPolicy to set.
			 * @uml.property  name="waitingPolicy"
			 */
			public void setWaitingPolicy(AbstractWaitingPolicy waitingPolicy) {
				abstractWaitingPolicy = waitingPolicy;
			}


			@Override
			public void acquire(ISchedulableProcess process, int num) {
				// TODO Auto-generated method stub
				
			}


			@Override
			public void release(ISchedulableProcess process, int num) {
				// TODO Auto-generated method stub
				
			}


			/**
			 * @uml.property  name="priorityBoost"
			 * @uml.associationEnd  aggregation="composite" inverse="simPassiveResource:de.uka.ipd.sdq.capra.simulator.resources_new.IPriorityBoost"
			 */
			private IPriorityBoost priorityBoost;


			/**
			 * Getter of the property <tt>priorityBoost</tt>
			 * @return  Returns the priorityBoost.
			 * @uml.property  name="priorityBoost"
			 */
			public IPriorityBoost getPriorityBoost() {
				return priorityBoost;
			}


			/**
			 * Setter of the property <tt>priorityBoost</tt>
			 * @param priorityBoost  The priorityBoost to set.
			 * @uml.property  name="priorityBoost"
			 */
			public void setPriorityBoost(IPriorityBoost priorityBoost) {
				this.priorityBoost = priorityBoost;
			}

}
