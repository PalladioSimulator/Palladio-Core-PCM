/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.seff;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Start Action</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc --> StartActions initiate a scenario behaviour and contain only a successor.
 * <!-- end-model-doc -->
 *
 *
 * @see org.palladiosimulator.pcm.seff.SeffPackage#getStartAction()
 * @model
 * @generated
 */
public interface StartAction extends AbstractInternalControlFlowAction {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @model annotation=
     *        "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.predecessor_AbstractAction.oclIsUndefined()'"
     * @generated
     */
    boolean StartActionPredecessorMustNotBeDefined(DiagnosticChain diagnostics, Map<Object, Object> context);

} // StartAction
