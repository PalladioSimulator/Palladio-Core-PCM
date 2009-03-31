/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Metric Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getCaptureType <em>Capture Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getDataType <em>Data Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getScale <em>Scale</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getBaseMetricDescription()
 * @model
 * @generated
 */
public interface BaseMetricDescription extends MetricDescription {
	/**
	 * Returns the value of the '<em><b>Capture Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.edp2.models.emfmodel.CaptureType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capture Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capture Type</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.CaptureType
	 * @see #setCaptureType(CaptureType)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getBaseMetricDescription_CaptureType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CaptureType getCaptureType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getCaptureType <em>Capture Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capture Type</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.CaptureType
	 * @see #getCaptureType()
	 * @generated
	 */
	void setCaptureType(CaptureType value);

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.edp2.models.emfmodel.DataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.DataType
	 * @see #setDataType(DataType)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getBaseMetricDescription_DataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getDataType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getDataType <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.DataType
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(DataType value);

	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.edp2.models.emfmodel.Scale}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Scale
	 * @see #setScale(Scale)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getBaseMetricDescription_Scale()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Scale getScale();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Scale
	 * @see #getScale()
	 * @generated
	 */
	void setScale(Scale value);

} // BaseMetricDescription
