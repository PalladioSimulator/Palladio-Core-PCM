/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Allocation Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * AllocationDegree represents a component allocation degree of freedom. It refers to an AllocationContext as changeableEntity, which is the mapping of a component to a server. The domain is a set of ResourceContainers (i.e. servers or hardware nodes) that can be put in the AllocationContext, i.e. in the mapping where the component is to be deployed. 
 * 
 * TODO OCL: The domainOfEntities must only contain ResourceContainer.  The changeableEntity must be an AllocationContext.
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getAllocationDegree()
 * @model
 * @generated
 */
public interface AllocationDegree extends ClassAsReferenceDegree {
} // AllocationDegree
