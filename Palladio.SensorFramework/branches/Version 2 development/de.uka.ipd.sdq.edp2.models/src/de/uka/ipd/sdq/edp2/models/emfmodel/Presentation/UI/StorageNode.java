/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI;

import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Storage Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNode#getExperimentGroup <em>Experiment Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage#getStorageNode()
 * @model abstract="true"
 * @generated
 */
public interface StorageNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Experiment Group</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup#getStorageNode <em>Storage Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment Group</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Experiment Group</em>' reference list.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage#getStorageNode_ExperimentGroup()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup#getStorageNode
	 * @model opposite="storageNode" ordered="false"
	 * @generated
	 */
	EList<ExperimentGroup> getExperimentGroup();

} // StorageNode
