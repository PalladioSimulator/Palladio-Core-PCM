/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Presentation.UI;

import de.uka.ipd.sdq.edp2.models.Presentation.DataReader;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Presentation Controller</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationController#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationController#getView <em>View</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationController#getPropertyPane <em>Property Pane</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationController#getDataReader <em>Data Reader</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.Presentation.UI.UIPackage#getPresentationController()
 * @model abstract="true"
 * @generated
 */
public interface PresentationController extends EObject {
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference.
	 * @see #setConfiguration(PresentationConfiguration)
	 * @see de.uka.ipd.sdq.edp2.models.Presentation.UI.UIPackage#getPresentationController_Configuration()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PresentationConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationController#getConfiguration <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' containment reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(PresentationConfiguration value);

	/**
	 * Returns the value of the '<em><b>View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View</em>' containment reference.
	 * @see #setView(PresentationView)
	 * @see de.uka.ipd.sdq.edp2.models.Presentation.UI.UIPackage#getPresentationController_View()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PresentationView getView();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationController#getView <em>View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View</em>' containment reference.
	 * @see #getView()
	 * @generated
	 */
	void setView(PresentationView value);

	/**
	 * Returns the value of the '<em><b>Property Pane</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationPropertyPane}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Pane</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Pane</em>' containment reference list.
	 * @see de.uka.ipd.sdq.edp2.models.Presentation.UI.UIPackage#getPresentationController_PropertyPane()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PresentationPropertyPane> getPropertyPane();

	/**
	 * Returns the value of the '<em><b>Data Reader</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.Presentation.DataReader}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Reader</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Reader</em>' containment reference list.
	 * @see de.uka.ipd.sdq.edp2.models.Presentation.UI.UIPackage#getPresentationController_DataReader()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DataReader> getDataReader();

} // PresentationController
