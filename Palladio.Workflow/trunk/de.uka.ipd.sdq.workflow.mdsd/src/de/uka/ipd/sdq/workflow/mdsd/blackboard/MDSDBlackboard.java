package de.uka.ipd.sdq.workflow.mdsd.blackboard;

import org.eclipse.emf.ecore.resource.ResourceSet;

import de.uka.ipd.sdq.workflow.Blackboard;

/**
 * A blackboard implementation whose partitions use {@link ResourceSet} to store EMF Model Resources
 * @author Steffen Becker
 */
public class MDSDBlackboard extends Blackboard<ResourceSetPartition> {
}
