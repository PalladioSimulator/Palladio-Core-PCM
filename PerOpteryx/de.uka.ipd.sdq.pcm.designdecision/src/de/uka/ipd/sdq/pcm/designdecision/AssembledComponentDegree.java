/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assembled Component Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * AssembledComponentDegree represents a component selection degree of freedom. It refers to an AssemblyContext as changeableEntity, which is the place in the software architecture in which different component implementations can be used (also called component frame in other component models). The domain is a set of RepositoryComponents that can be put in the AssemblyContext, i.e. in the defined place in the architecture. 
 * 
 * TODO OCL: The domainOfEntities must only contain RepositoryComponents.  The changeableEntity must be an AssemblyContext.
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getAssembledComponentDegree()
 * @model
 * @generated
 */
public interface AssembledComponentDegree extends ClassAsReferenceDegree {
} // AssembledComponentDegree
