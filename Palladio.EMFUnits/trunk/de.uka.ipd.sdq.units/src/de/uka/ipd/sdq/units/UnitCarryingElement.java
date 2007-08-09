/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.units;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Carrying Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.units.UnitCarryingElement#getUnit <em>Unit</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.units.UnitCarryingElement#getUnitSpecification <em>Unit Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.units.UnitsPackage#getUnitCarryingElement()
 * @model abstract="true"
 * @generated
 */
public interface UnitCarryingElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' reference.
	 * @see #setUnit(Unit)
	 * @see de.uka.ipd.sdq.units.UnitsPackage#getUnitCarryingElement_Unit()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	Unit getUnit();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.units.UnitCarryingElement#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' reference.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(Unit value);

	/**
	 * Returns the value of the '<em><b>Unit Specification</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Specification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Specification</em>' attribute.
	 * @see #setUnitSpecification(String)
	 * @see de.uka.ipd.sdq.units.UnitsPackage#getUnitCarryingElement_UnitSpecification()
	 * @model default="" required="true"
	 * @generated
	 */
	String getUnitSpecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.units.UnitCarryingElement#getUnitSpecification <em>Unit Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Specification</em>' attribute.
	 * @see #getUnitSpecification()
	 * @generated
	 */
	void setUnitSpecification(String value);

} // UnitCarryingElement
