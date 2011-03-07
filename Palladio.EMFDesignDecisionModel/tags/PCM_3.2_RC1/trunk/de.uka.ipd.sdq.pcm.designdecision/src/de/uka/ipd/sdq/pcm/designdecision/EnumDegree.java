/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Construct to model a special type of enumerated degree of freedom where the domain of values is a subset of an enumeration in the metamodel. Each concrete subclass of EnumDegree must model the domain explicitly (refer to the concrete Enum to choose from). 
 * 
 * This class is actually superflous as it does not add any properties to its subclasses. It is just used to conceptually group this type of degree of freedom. Maybe it can be used to implement some OCL checks (with reflection?). 
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getEnumDegree()
 * @model abstract="true"
 * @generated
 */
public interface EnumDegree extends DegreeOfFreedom {
} // EnumDegree
