package de.uka.ipd.sdq.capra.simulator.resources_new;

import de.uka.ipd.sdq.capra.simulator.schedinterface.ISchedulableProcess;


public interface IActiveResource {

		
		/**
		 */
		public abstract void process(ISchedulableProcess process, boolean demand);
		

}
