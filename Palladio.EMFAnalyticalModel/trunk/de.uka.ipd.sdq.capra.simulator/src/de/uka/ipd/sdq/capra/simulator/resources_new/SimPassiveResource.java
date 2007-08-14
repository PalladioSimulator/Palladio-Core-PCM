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

}
