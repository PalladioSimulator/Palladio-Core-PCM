/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Listing Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.ElementListingAttribute#getRange <em>Range</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getElementListingAttribute()
 * @model
 * @generated
 */
public interface ElementListingAttribute extends Attribute {
	/**
	 * Returns the value of the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' containment reference.
	 * @see #setRange(EnumerationRange)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getElementListingAttribute_Range()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EnumerationRange getRange();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.ElementListingAttribute#getRange <em>Range</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' containment reference.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(EnumerationRange value);

} // ElementListingAttribute
