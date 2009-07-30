/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ordinal Intervals Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.OrdinalIntervalsType#isAllIntervalWidthsEqual <em>All Interval Widths Equal</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationPackage#getOrdinalIntervalsType()
 * @model
 * @generated
 */
public interface OrdinalIntervalsType extends DataType {
	/**
	 * Returns the value of the '<em><b>All Interval Widths Equal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Interval Widths Equal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Interval Widths Equal</em>' attribute.
	 * @see #setAllIntervalWidthsEqual(boolean)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationPackage#getOrdinalIntervalsType_AllIntervalWidthsEqual()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isAllIntervalWidthsEqual();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.OrdinalIntervalsType#isAllIntervalWidthsEqual <em>All Interval Widths Equal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>All Interval Widths Equal</em>' attribute.
	 * @see #isAllIntervalWidthsEqual()
	 * @generated
	 */
	void setAllIntervalWidthsEqual(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model iRequired="true" iOrdered="false"
	 * @generated
	 */
	void getBeginOfInterval(int i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model IRequired="true" IOrdered="false"
	 * @generated
	 */
	void getWidthOfInterval(int I);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	void getNumberOfIntervals();

} // OrdinalIntervalsType
