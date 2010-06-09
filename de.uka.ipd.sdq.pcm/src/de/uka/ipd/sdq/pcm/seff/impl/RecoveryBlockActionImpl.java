/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.seff.RecoveryBlockAction;
import de.uka.ipd.sdq.pcm.seff.RecoveryBlockAlternativeBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.pcm.seff.util.SeffValidator;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.ParserException;

import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recovery Block Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.RecoveryBlockActionImpl#getRecoveryBlockalternativeBehaviours <em>Recovery Blockalternative Behaviours</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecoveryBlockActionImpl extends AbstractInternalControlFlowActionImpl implements RecoveryBlockAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getRecoveryBlockalternativeBehaviours() <em>Recovery Blockalternative Behaviours</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecoveryBlockalternativeBehaviours()
	 * @generated
	 * @ordered
	 */
	protected EList<RecoveryBlockAlternativeBehaviour> recoveryBlockalternativeBehaviours;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecoveryBlockActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.RECOVERY_BLOCK_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RecoveryBlockAlternativeBehaviour> getRecoveryBlockalternativeBehaviours() {
		if (recoveryBlockalternativeBehaviours == null) {
			recoveryBlockalternativeBehaviours = new EObjectContainmentWithInverseEList<RecoveryBlockAlternativeBehaviour>(RecoveryBlockAlternativeBehaviour.class, this, SeffPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCKALTERNATIVE_BEHAVIOURS, SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__RECOVERY_BLOCK_ACTION_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR);
		}
		return recoveryBlockalternativeBehaviours;
	}

	/**
	 * The cached OCL expression body for the '{@link #Alternativesformachain(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Alternativesformachain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Alternativesformachain(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ALTERNATIVESFORMACHAIN__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.recoveryBlockalternativeBehaviours->isUnique(s: RecoveryBlockAlternativeBehaviour | s.nextAlternative) and\n"+"self.recoveryBlockalternativeBehaviours->forAll(x:RecoveryBlockAlternativeBehaviour| x <> x.nextAlternative)\n"+"";

	/**
	 * The cached OCL invariant for the '{@link #Alternativesformachain(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Alternativesformachain</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Alternativesformachain(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint ALTERNATIVESFORMACHAIN__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Alternativesformachain(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ALTERNATIVESFORMACHAIN__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(SeffPackage.Literals.RECOVERY_BLOCK_ACTION);
			try {
				ALTERNATIVESFORMACHAIN__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ALTERNATIVESFORMACHAIN__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(ALTERNATIVESFORMACHAIN__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 SeffValidator.DIAGNOSTIC_SOURCE,
						 SeffValidator.RECOVERY_BLOCK_ACTION__ALTERNATIVESFORMACHAIN,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Alternativesformachain", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCKALTERNATIVE_BEHAVIOURS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRecoveryBlockalternativeBehaviours()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCKALTERNATIVE_BEHAVIOURS:
				return ((InternalEList<?>)getRecoveryBlockalternativeBehaviours()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCKALTERNATIVE_BEHAVIOURS:
				return getRecoveryBlockalternativeBehaviours();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SeffPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCKALTERNATIVE_BEHAVIOURS:
				getRecoveryBlockalternativeBehaviours().clear();
				getRecoveryBlockalternativeBehaviours().addAll((Collection<? extends RecoveryBlockAlternativeBehaviour>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SeffPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCKALTERNATIVE_BEHAVIOURS:
				getRecoveryBlockalternativeBehaviours().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SeffPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCKALTERNATIVE_BEHAVIOURS:
				return recoveryBlockalternativeBehaviours != null && !recoveryBlockalternativeBehaviours.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} //RecoveryBlockActionImpl
