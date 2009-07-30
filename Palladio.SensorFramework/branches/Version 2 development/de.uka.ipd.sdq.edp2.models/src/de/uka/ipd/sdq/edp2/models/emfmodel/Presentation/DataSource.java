/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation;

import de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.DataType;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource#getData <em>Data</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource#getDescription <em>Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource#getMetricDescription <em>Metric Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationPackage#getDataSource()
 * @model
 * @generated
 */
public interface DataSource extends EObject {
	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.edp2.models.emfmodel.DataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.DataType
	 * @see #setData(DataType)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationPackage#getDataSource_Data()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getData();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.DataType
	 * @see #getData()
	 * @generated
	 */
	void setData(DataType value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' reference.
	 * @see #setDescription(IDataSourceDescription)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationPackage#getDataSource_Description()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	IDataSourceDescription getDescription();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource#getDescription <em>Description</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' reference.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(IDataSourceDescription value);

	/**
	 * Returns the value of the '<em><b>Metric Description</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric Description</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric Description</em>' reference.
	 * @see #setMetricDescription(BaseMetricDescription)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationPackage#getDataSource_MetricDescription()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BaseMetricDescription getMetricDescription();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.DataSource#getMetricDescription <em>Metric Description</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric Description</em>' reference.
	 * @see #getMetricDescription()
	 * @generated
	 */
	void setMetricDescription(BaseMetricDescription value);

} // DataSource
