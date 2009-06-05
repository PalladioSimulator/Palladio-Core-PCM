/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.stoex.PowerExpression#getBase <em>Base</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.stoex.PowerExpression#getExponent <em>Exponent</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.stoex.StoexPackage#getPowerExpression()
 * @model
 * @generated
 */
public interface PowerExpression extends Power {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ, IPD, U Karlsruhe (TH)";

	/**
	 * Returns the value of the '<em><b>Base</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base</em>' containment reference.
	 * @see #setBase(Power)
	 * @see de.uka.ipd.sdq.stoex.StoexPackage#getPowerExpression_Base()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Power getBase();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.stoex.PowerExpression#getBase <em>Base</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base</em>' containment reference.
	 * @see #getBase()
	 * @generated
	 */
	void setBase(Power value);

	/**
	 * Returns the value of the '<em><b>Exponent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exponent</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exponent</em>' containment reference.
	 * @see #setExponent(Atom)
	 * @see de.uka.ipd.sdq.stoex.StoexPackage#getPowerExpression_Exponent()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Atom getExponent();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.stoex.PowerExpression#getExponent <em>Exponent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exponent</em>' containment reference.
	 * @see #getExponent()
	 * @generated
	 */
	void setExponent(Atom value);

} // PowerExpression