/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Limited Deviation Precision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision#getAbsolute <em>Absolute</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision#getRelative <em>Relative</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getLimitedDeviationPrecision()
 * @model
 * @generated
 */
public interface LimitedDeviationPrecision extends Precision {
	/**
     * Returns the value of the '<em><b>Absolute</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Absolute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Absolute</em>' attribute.
     * @see #setAbsolute(double)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getLimitedDeviationPrecision_Absolute()
     * @model required="true" ordered="false"
     * @generated
     */
	double getAbsolute();

	/**
     * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision#getAbsolute <em>Absolute</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Absolute</em>' attribute.
     * @see #getAbsolute()
     * @generated
     */
	void setAbsolute(double value);

	/**
     * Returns the value of the '<em><b>Relative</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relative</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Relative</em>' attribute.
     * @see #setRelative(double)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getLimitedDeviationPrecision_Relative()
     * @model required="true" ordered="false"
     * @generated
     */
	double getRelative();

	/**
     * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision#getRelative <em>Relative</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Relative</em>' attribute.
     * @see #getRelative()
     * @generated
     */
	void setRelative(double value);

} // LimitedDeviationPrecision
