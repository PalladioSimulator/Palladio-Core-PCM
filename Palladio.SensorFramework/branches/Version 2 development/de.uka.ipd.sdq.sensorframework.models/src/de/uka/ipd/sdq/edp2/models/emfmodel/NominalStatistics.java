/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nominal Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.NominalStatistics#getCount <em>Count</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.NominalStatistics#getRawYSeries <em>Raw YSeries</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getNominalStatistics()
 * @model
 * @generated
 */
public interface NominalStatistics extends EObject {
	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(long)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getNominalStatistics_Count()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getCount();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.NominalStatistics#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(long value);

	/**
	 * Returns the value of the '<em><b>Raw YSeries</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.RawYSeries#getStatistics <em>Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw YSeries</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw YSeries</em>' container reference.
	 * @see #setRawYSeries(RawYSeries)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getNominalStatistics_RawYSeries()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.RawYSeries#getStatistics
	 * @model opposite="statistics" required="true" transient="false" ordered="false"
	 * @generated
	 */
	RawYSeries getRawYSeries();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.NominalStatistics#getRawYSeries <em>Raw YSeries</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw YSeries</em>' container reference.
	 * @see #getRawYSeries()
	 * @generated
	 */
	void setRawYSeries(RawYSeries value);

} // NominalStatistics
