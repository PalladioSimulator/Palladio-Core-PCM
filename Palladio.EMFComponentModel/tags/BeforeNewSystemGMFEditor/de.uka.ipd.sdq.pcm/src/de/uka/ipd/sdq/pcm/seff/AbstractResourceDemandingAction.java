
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Resource Demanding Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.AbstractResourceDemandingAction#getResourceDemand_Action <em>Resource Demand Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAbstractResourceDemandingAction()
 * @model abstract="true"
 * @generated
 */
public interface AbstractResourceDemandingAction extends AbstractAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Resource Demand Action</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand#getAction_ParametricResourceDemand <em>Action Parametric Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Demand Action</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Demand Action</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAbstractResourceDemandingAction_ResourceDemand_Action()
	 * @see de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand#getAction_ParametricResourceDemand
	 * @model type="de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand" opposite="action_ParametricResourceDemand" ordered="false"
	 * @generated
	 */
	EList getResourceDemand_Action();

} // AbstractResourceDemandingAction