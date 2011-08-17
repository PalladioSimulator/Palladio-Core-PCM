/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.seff_reliability.impl;

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
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.seff.impl.AbstractInternalControlFlowActionImpl;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAction;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAlternativeBehaviour;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.Seff_reliabilityPackage;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.util.Seff_reliabilityValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recovery Block Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.RecoveryBlockActionImpl#getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction <em>Recovery Block Alternative Behaviours Recovery Block Action</em>}</li>
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
	 * The cached value of the '{@link #getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction() <em>Recovery Block Alternative Behaviours Recovery Block Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction()
	 * @generated
	 * @ordered
	 */
	protected EList<RecoveryBlockAlternativeBehaviour> recoveryBlockAlternativeBehaviours_RecoveryBlockAction;

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
		return Seff_reliabilityPackage.Literals.RECOVERY_BLOCK_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RecoveryBlockAlternativeBehaviour> getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction() {
		if (recoveryBlockAlternativeBehaviours_RecoveryBlockAction == null) {
			recoveryBlockAlternativeBehaviours_RecoveryBlockAction = new EObjectContainmentWithInverseEList<RecoveryBlockAlternativeBehaviour>(RecoveryBlockAlternativeBehaviour.class, this, Seff_reliabilityPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOURS_RECOVERY_BLOCK_ACTION, Seff_reliabilityPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__RECOVERY_BLOCK_ACTION_RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR);
		}
		return recoveryBlockAlternativeBehaviours_RecoveryBlockAction;
	}

	/**
	 * The cached OCL expression body for the '{@link #Alternativesformachain(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Alternativesformachain</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #Alternativesformachain(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ALTERNATIVESFORMACHAIN__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.recoveryBlockAlternativeBehaviours_RecoveryBlockAction->isUnique(s: RecoveryBlockAlternativeBehaviour | s.nextAlternative_RecoveryBlockAlternativeBehaviour) and\n"+"self.recoveryBlockAlternativeBehaviours_RecoveryBlockAction->forAll(x:RecoveryBlockAlternativeBehaviour| x <> x.nextAlternative_RecoveryBlockAlternativeBehaviour)\n"+"";

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
			helper.setContext(Seff_reliabilityPackage.Literals.RECOVERY_BLOCK_ACTION);
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
						 Seff_reliabilityValidator.DIAGNOSTIC_SOURCE,
						 Seff_reliabilityValidator.RECOVERY_BLOCK_ACTION__ALTERNATIVESFORMACHAIN,
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
			case Seff_reliabilityPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOURS_RECOVERY_BLOCK_ACTION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction()).basicAdd(otherEnd, msgs);
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
			case Seff_reliabilityPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOURS_RECOVERY_BLOCK_ACTION:
				return ((InternalEList<?>)getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction()).basicRemove(otherEnd, msgs);
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
			case Seff_reliabilityPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOURS_RECOVERY_BLOCK_ACTION:
				return getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction();
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
			case Seff_reliabilityPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOURS_RECOVERY_BLOCK_ACTION:
				getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction().clear();
				getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction().addAll((Collection<? extends RecoveryBlockAlternativeBehaviour>)newValue);
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
			case Seff_reliabilityPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOURS_RECOVERY_BLOCK_ACTION:
				getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction().clear();
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
			case Seff_reliabilityPackage.RECOVERY_BLOCK_ACTION__RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOURS_RECOVERY_BLOCK_ACTION:
				return recoveryBlockAlternativeBehaviours_RecoveryBlockAction != null && !recoveryBlockAlternativeBehaviours_RecoveryBlockAction.isEmpty();
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
