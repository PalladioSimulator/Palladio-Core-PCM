/**
 *
 */
package de.fzi.se.validation.effort.jjnpaths;

import de.fzi.se.controlflowdescription.ControlFlowDescription;
import de.fzi.se.controlflowdescription.ControlFlowDescriptionFactory;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

/**This class is a specialized {@link MDSDBlackboard} partition. It loads and holds CFD models instances.
 *
 * @author groenda
 *
 */
public class CFDResourceSetPartition extends ResourceSetPartition {

	/**
	 * @return The first control flow description in the resource set.
	 */
	public ControlFlowDescription getControlFlowDescription() {
		return getElement(ControlFlowDescriptionFactory.eINSTANCE.createControlFlowDescription()).get(0);
	}
}
