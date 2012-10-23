/**
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.qualityannotation.PCMREInfrastructureRole;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.fzi.se.quality.qualityannotation.util.QualityAnnotationValidator;

import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.ocl.ParserException;

import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PCMRE Infrastructure Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.PCMREInfrastructureRoleImpl#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMREInfrastructureRoleImpl extends PCMREImpl implements PCMREInfrastructureRole {
	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected InfrastructureRequiredRole role;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMREInfrastructureRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityAnnotationPackage.Literals.PCMRE_INFRASTRUCTURE_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureRequiredRole getRole() {
		if (role != null && role.eIsProxy()) {
			InternalEObject oldRole = (InternalEObject)role;
			role = (InfrastructureRequiredRole)eResolveProxy(oldRole);
			if (role != oldRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_ROLE__ROLE, oldRole, role));
			}
		}
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureRequiredRole basicGetRole() {
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(InfrastructureRequiredRole newRole) {
		InfrastructureRequiredRole oldRole = role;
		role = newRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_ROLE__ROLE, oldRole, role));
	}

	/**
	 * The cached OCL expression body for the '{@link #NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Next Lower Level Must Consist Of Type PCMRE Infrastructure Signature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.childREs->select(pcmre | not pcmre.oclIsTypeOf(PCMREInfrastructureSignature))->size() = 0";

	/**
	 * The cached OCL invariant for the '{@link #NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Next Lower Level Must Consist Of Type PCMRE Infrastructure Signature</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(QualityAnnotationPackage.Literals.PCMRE_INFRASTRUCTURE_ROLE);
			try {
				NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
						 QualityAnnotationValidator.PCMRE_INFRASTRUCTURE_ROLE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_SIGNATURE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "NextLowerLevelMustConsistOfTypePCMREInfrastructureSignature", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #EachRETargetMustBeReferencedOnlyFromOneRE(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Each RE Target Must Be Referenced Only From One RE</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EachRETargetMustBeReferencedOnlyFromOneRE(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parentRE.childREs->select(pcmre | pcmre.oclAsType(PCMREInfrastructureRole).role = self.role)->size() = 1";

	/**
	 * The cached OCL invariant for the '{@link #EachRETargetMustBeReferencedOnlyFromOneRE(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Each RE Target Must Be Referenced Only From One RE</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EachRETargetMustBeReferencedOnlyFromOneRE(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean EachRETargetMustBeReferencedOnlyFromOneRE(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(QualityAnnotationPackage.Literals.PCMRE_INFRASTRUCTURE_ROLE);
			try {
				EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
						 QualityAnnotationValidator.PCMRE_INFRASTRUCTURE_ROLE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "EachRETargetMustBeReferencedOnlyFromOneRE", EObjectValidator.getObjectLabel(this, context) }),
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_ROLE__ROLE:
				if (resolve) return getRole();
				return basicGetRole();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_ROLE__ROLE:
				setRole((InfrastructureRequiredRole)newValue);
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
			case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_ROLE__ROLE:
				setRole((InfrastructureRequiredRole)null);
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
			case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_ROLE__ROLE:
				return role != null;
		}
		return super.eIsSet(featureID);
	}

} //PCMREInfrastructureRoleImpl
