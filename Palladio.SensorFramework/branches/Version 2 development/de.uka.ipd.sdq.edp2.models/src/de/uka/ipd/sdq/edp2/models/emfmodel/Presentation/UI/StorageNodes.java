/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Storage Nodes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNodes#getStoragenNode <em>Storagen Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage#getStorageNodes()
 * @model
 * @generated
 */
public interface StorageNodes extends EObject {
	/**
	 * Returns the value of the '<em><b>Storagen Node</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Storagen Node</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storagen Node</em>' containment reference list.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage#getStorageNodes_StoragenNode()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<StorageNode> getStoragenNode();

} // StorageNodes
