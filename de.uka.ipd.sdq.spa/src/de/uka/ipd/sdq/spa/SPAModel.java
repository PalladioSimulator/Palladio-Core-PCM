/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa;

import de.uka.ipd.sdq.spa.resourcemodel.Resource;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SPA Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.SPAModel#getProcesses <em>Processes</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.SPAModel#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.SpaPackage#getSPAModel()
 * @model
 * @generated
 */
public interface SPAModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Processes</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.spa.ProcessBehaviour}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processes</em>' containment reference list.
	 * @see de.uka.ipd.sdq.spa.SpaPackage#getSPAModel_Processes()
	 * @model type="de.uka.ipd.sdq.spa.ProcessBehaviour" containment="true"
	 * @generated
	 */
	EList<ProcessBehaviour> getProcesses();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.spa.resourcemodel.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see de.uka.ipd.sdq.spa.SpaPackage#getSPAModel_Resources()
	 * @model type="de.uka.ipd.sdq.spa.resourcemodel.Resource" containment="true"
	 * @generated
	 */
	EList<Resource> getResources();

} // SPAModel
