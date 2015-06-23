/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.usagemodel;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Stop</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc --> Each ScenarioBehaviour has exactly one Stop action which marks the
 * action where the control flows ends. Stop actions have no successor. <!-- end-model-doc -->
 *
 *
 * @see org.palladiosimulator.pcm.usagemodel.UsagemodelPackage#getStop()
 * @model
 * @generated
 */
public interface Stop extends AbstractUserAction {

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
     *        "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='self.successor.oclIsUndefined()'"
     * @generated
     */
    boolean StopHasNoSuccessor(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Stop
