/**
 * Copyright SDQ, IPD, U Karlsruhe, 2007
 *
 * $Id$
 */
package de.uka.ipd.sdq.completions.impl;

import org.eclipse.emf.ecore.EClass;

import de.uka.ipd.sdq.completions.CompletionsPackage;
import de.uka.ipd.sdq.completions.DelegatingExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delegating External Call Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DelegatingExternalCallActionImpl extends ExternalCallActionImpl implements DelegatingExternalCallAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DelegatingExternalCallActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompletionsPackage.Literals.DELEGATING_EXTERNAL_CALL_ACTION;
	}

} //DelegatingExternalCallActionImpl
