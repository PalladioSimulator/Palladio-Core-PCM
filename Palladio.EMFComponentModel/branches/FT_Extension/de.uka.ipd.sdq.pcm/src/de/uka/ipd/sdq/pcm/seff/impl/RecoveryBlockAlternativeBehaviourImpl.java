/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import java.util.Collection;

import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import de.uka.ipd.sdq.pcm.repository.FailureType;
import de.uka.ipd.sdq.pcm.seff.FailureHandlingEntity;
import de.uka.ipd.sdq.pcm.seff.RecoveryBlockAlternativeBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.util.SeffValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recovery Block Alternative Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.RecoveryBlockAlternativeBehaviourImpl#getFailuretype <em>Failuretype</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.RecoveryBlockAlternativeBehaviourImpl#getNextAlternative <em>Next Alternative</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecoveryBlockAlternativeBehaviourImpl extends ResourceDemandingBehaviourImpl implements RecoveryBlockAlternativeBehaviour {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getFailuretype() <em>Failuretype</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailuretype()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureType> failuretype;

	/**
	 * The cached value of the '{@link #getNextAlternative() <em>Next Alternative</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextAlternative()
	 * @generated
	 * @ordered
	 */
	protected RecoveryBlockAlternativeBehaviour nextAlternative;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecoveryBlockAlternativeBehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailureType> getFailuretype() {
		if (failuretype == null) {
			failuretype = new EObjectResolvingEList<FailureType>(FailureType.class, this, SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__FAILURETYPE);
		}
		return failuretype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecoveryBlockAlternativeBehaviour getNextAlternative() {
		if (nextAlternative != null && nextAlternative.eIsProxy()) {
			InternalEObject oldNextAlternative = (InternalEObject)nextAlternative;
			nextAlternative = (RecoveryBlockAlternativeBehaviour)eResolveProxy(oldNextAlternative);
			if (nextAlternative != oldNextAlternative) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__NEXT_ALTERNATIVE, oldNextAlternative, nextAlternative));
			}
		}
		return nextAlternative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecoveryBlockAlternativeBehaviour basicGetNextAlternative() {
		return nextAlternative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextAlternative(RecoveryBlockAlternativeBehaviour newNextAlternative) {
		RecoveryBlockAlternativeBehaviour oldNextAlternative = nextAlternative;
		nextAlternative = newNextAlternative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__NEXT_ALTERNATIVE, oldNextAlternative, nextAlternative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__FAILURETYPE:
				return getFailuretype();
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__NEXT_ALTERNATIVE:
				if (resolve) return getNextAlternative();
				return basicGetNextAlternative();
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
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__FAILURETYPE:
				getFailuretype().clear();
				getFailuretype().addAll((Collection<? extends FailureType>)newValue);
				return;
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__NEXT_ALTERNATIVE:
				setNextAlternative((RecoveryBlockAlternativeBehaviour)newValue);
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
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__FAILURETYPE:
				getFailuretype().clear();
				return;
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__NEXT_ALTERNATIVE:
				setNextAlternative((RecoveryBlockAlternativeBehaviour)null);
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
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__FAILURETYPE:
				return failuretype != null && !failuretype.isEmpty();
			case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__NEXT_ALTERNATIVE:
				return nextAlternative != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == FailureHandlingEntity.class) {
			switch (derivedFeatureID) {
				case SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__FAILURETYPE: return SeffPackage.FAILURE_HANDLING_ENTITY__FAILURETYPE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == FailureHandlingEntity.class) {
			switch (baseFeatureID) {
				case SeffPackage.FAILURE_HANDLING_ENTITY__FAILURETYPE: return SeffPackage.RECOVERY_BLOCK_ALTERNATIVE_BEHAVIOUR__FAILURETYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //RecoveryBlockAlternativeBehaviourImpl
