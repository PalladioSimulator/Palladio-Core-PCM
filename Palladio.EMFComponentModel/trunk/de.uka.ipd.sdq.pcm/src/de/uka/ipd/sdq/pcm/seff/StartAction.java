
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start Action</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getStartAction()
 * @model
 * @generated
 */
public interface StartAction extends AbstractResourceDemandingAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.predecessor_AbstractAction.oclIsUndefined()
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean StartActionPredecessorMustNotBeDefined(DiagnosticChain diagnostics, Map<Object, Object> context);

} // StartAction
