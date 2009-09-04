/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Presentation.UI;

import de.uka.ipd.sdq.edp2.models.Presentation.DataSource;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Presentation Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationInput#getDataSourceDescription <em>Data Source Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.Presentation.UI.UIPackage#getPresentationInput()
 * @model
 * @generated
 */
public interface PresentationInput extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Source Description</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.Presentation.DataSource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Source Description</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source Description</em>' containment reference list.
	 * @see de.uka.ipd.sdq.edp2.models.Presentation.UI.UIPackage#getPresentationInput_DataSourceDescription()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DataSource> getDataSourceDescription();

} // PresentationInput
