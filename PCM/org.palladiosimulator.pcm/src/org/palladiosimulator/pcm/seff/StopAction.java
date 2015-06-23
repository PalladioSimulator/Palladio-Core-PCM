/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.seff;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Stop Action</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc --> StopActions end a scenario behaviour and contain only a predecessor.
 * <!-- end-model-doc -->
 *
 *
 * @see org.palladiosimulator.pcm.seff.SeffPackage#getStopAction()
 * @model
 * @generated
 */
public interface StopAction extends AbstractInternalControlFlowAction {

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
     *        "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.successor_AbstractAction.oclIsUndefined()'"
     * @generated
     */
    boolean StopActionSuccessorMustNotBeDefined(DiagnosticChain diagnostics, Map<Object, Object> context);

} // StopAction
