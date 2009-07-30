/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation;

import de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EDP2 Data Source Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.EDP2DataSourceDescription#getDataSeries <em>Data Series</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationPackage#getEDP2DataSourceDescription()
 * @model
 * @generated
 */
public interface EDP2DataSourceDescription extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Series</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Series</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Series</em>' reference.
	 * @see #setDataSeries(DataSeries)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationPackage#getEDP2DataSourceDescription_DataSeries()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataSeries getDataSeries();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.EDP2DataSourceDescription#getDataSeries <em>Data Series</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Series</em>' reference.
	 * @see #getDataSeries()
	 * @generated
	 */
	void setDataSeries(DataSeries value);

} // EDP2DataSourceDescription
