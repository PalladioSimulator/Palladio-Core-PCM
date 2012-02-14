/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Capacity Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Capcity degree. Need to refer to a PassiveResource as changeable entity, plus a 
 * 
 * TODO: add OCL that changeable entity is PassiveResource. 
 * 
 * TODO conceptually: Currently the capacity of a passive resource is modelled at the type level. That is not useful for e.g. threadpools. CHange PCM!
 * If PCM is changed, put AssemblyContext as changeable entity and add a ref to PassiveResource here. Then TODO: add OCL for changeableEntity to be an AssemblyContext, plus the PassiveResource must be available in the encapsulated BasicComponent. 
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getCapacityDegree()
 * @model
 * @generated
 */
public interface CapacityDegree extends DiscreteRangeDegree {

} // CapacityDegree
