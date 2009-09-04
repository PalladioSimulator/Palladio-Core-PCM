/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Presentation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Reader</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.DataReader#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.DataReader#getDataSource <em>Data Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.Presentation.PresentationPackage#getDataReader()
 * @model abstract="true"
 * @generated
 */
public interface DataReader extends EObject {
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.Presentation.DataReaderConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference list.
	 * @see de.uka.ipd.sdq.edp2.models.Presentation.PresentationPackage#getDataReader_Configuration()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DataReaderConfiguration> getConfiguration();

	/**
	 * Returns the value of the '<em><b>Data Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source</em>' containment reference.
	 * @see #setDataSource(DataSource)
	 * @see de.uka.ipd.sdq.edp2.models.Presentation.PresentationPackage#getDataReader_DataSource()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	DataSource getDataSource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.Presentation.DataReader#getDataSource <em>Data Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source</em>' containment reference.
	 * @see #getDataSource()
	 * @generated
	 */
	void setDataSource(DataSource value);

} // DataReader
