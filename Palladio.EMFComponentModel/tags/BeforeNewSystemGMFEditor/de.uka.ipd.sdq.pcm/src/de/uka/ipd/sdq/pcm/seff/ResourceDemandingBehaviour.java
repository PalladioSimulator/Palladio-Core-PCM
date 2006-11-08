
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Demanding Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour#getSteps_Behaviour <em>Steps Behaviour</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour#getParametricResourceDemands_Behaviour <em>Parametric Resource Demands Behaviour</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour#getParametricParameterUsage_Behaviour <em>Parametric Parameter Usage Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getResourceDemandingBehaviour()
 * @model
 * @generated
 */
public interface ResourceDemandingBehaviour extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Steps Behaviour</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.seff.AbstractAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steps Behaviour</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steps Behaviour</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getResourceDemandingBehaviour_Steps_Behaviour()
	 * @model type="de.uka.ipd.sdq.pcm.seff.AbstractAction" containment="true" ordered="false"
	 * @generated
	 */
	EList getSteps_Behaviour();

	/**
	 * Returns the value of the '<em><b>Parametric Resource Demands Behaviour</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parametric Resource Demands Behaviour</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parametric Resource Demands Behaviour</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getResourceDemandingBehaviour_ParametricResourceDemands_Behaviour()
	 * @model type="de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand" containment="true" ordered="false"
	 * @generated
	 */
	EList getParametricResourceDemands_Behaviour();

	/**
	 * Returns the value of the '<em><b>Parametric Parameter Usage Behaviour</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.seff.ParametricParameterUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parametric Parameter Usage Behaviour</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parametric Parameter Usage Behaviour</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getResourceDemandingBehaviour_ParametricParameterUsage_Behaviour()
	 * @model type="de.uka.ipd.sdq.pcm.seff.ParametricParameterUsage" containment="true" ordered="false"
	 * @generated
	 */
	EList getParametricParameterUsage_Behaviour();

} // ResourceDemandingBehaviour