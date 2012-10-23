/**
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.qualityannotation.PCMREResourceRole;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.fzi.se.quality.qualityannotation.util.QualityAnnotationValidator;

import de.uka.ipd.sdq.pcm.core.entity.ResourceRequiredRole;

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
 * An implementation of the model object '<em><b>PCMRE Resource Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.PCMREResourceRoleImpl#getResourceRequiredRole <em>Resource Required Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMREResourceRoleImpl extends PCMREImpl implements PCMREResourceRole {
	/**
	 * The cached value of the '{@link #getResourceRequiredRole() <em>Resource Required Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceRequiredRole()
	 * @generated
	 * @ordered
	 */
	protected ResourceRequiredRole resourceRequiredRole;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMREResourceRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityAnnotationPackage.Literals.PCMRE_RESOURCE_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole getResourceRequiredRole() {
		if (resourceRequiredRole != null && resourceRequiredRole.eIsProxy()) {
			InternalEObject oldResourceRequiredRole = (InternalEObject)resourceRequiredRole;
			resourceRequiredRole = (ResourceRequiredRole)eResolveProxy(oldResourceRequiredRole);
			if (resourceRequiredRole != oldResourceRequiredRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QualityAnnotationPackage.PCMRE_RESOURCE_ROLE__RESOURCE_REQUIRED_ROLE, oldResourceRequiredRole, resourceRequiredRole));
			}
		}
		return resourceRequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceRequiredRole basicGetResourceRequiredRole() {
		return resourceRequiredRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceRequiredRole(ResourceRequiredRole newResourceRequiredRole) {
		ResourceRequiredRole oldResourceRequiredRole = resourceRequiredRole;
		resourceRequiredRole = newResourceRequiredRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PCMRE_RESOURCE_ROLE__RESOURCE_REQUIRED_ROLE, oldResourceRequiredRole, resourceRequiredRole));
	}

	/**
	 * The cached OCL expression body for the '{@link #NextLowerLevelMustConsistOfTypePCMREResourceSignature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Next Lower Level Must Consist Of Type PCMRE Resource Signature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NextLowerLevelMustConsistOfTypePCMREResourceSignature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.childREs->select(pcmre | not pcmre.oclIsTypeOf(PCMREResourceSignature))->size() = 0";

	/**
	 * The cached OCL invariant for the '{@link #NextLowerLevelMustConsistOfTypePCMREResourceSignature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Next Lower Level Must Consist Of Type PCMRE Resource Signature</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NextLowerLevelMustConsistOfTypePCMREResourceSignature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean NextLowerLevelMustConsistOfTypePCMREResourceSignature(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(QualityAnnotationPackage.Literals.PCMRE_RESOURCE_ROLE);
			try {
				NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
						 QualityAnnotationValidator.PCMRE_RESOURCE_ROLE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "NextLowerLevelMustConsistOfTypePCMREResourceSignature", EObjectValidator.getObjectLabel(this, context) }),
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
	protected static final String EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parentRE.childREs->select(pcmre | pcmre.oclAsType(PCMREResourceRole).resourceRequiredRole = self.resourceRequiredRole)->size() = 1";

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
			helper.setContext(QualityAnnotationPackage.Literals.PCMRE_RESOURCE_ROLE);
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
						 QualityAnnotationValidator.PCMRE_RESOURCE_ROLE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE,
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
			case QualityAnnotationPackage.PCMRE_RESOURCE_ROLE__RESOURCE_REQUIRED_ROLE:
				if (resolve) return getResourceRequiredRole();
				return basicGetResourceRequiredRole();
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
			case QualityAnnotationPackage.PCMRE_RESOURCE_ROLE__RESOURCE_REQUIRED_ROLE:
				setResourceRequiredRole((ResourceRequiredRole)newValue);
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
			case QualityAnnotationPackage.PCMRE_RESOURCE_ROLE__RESOURCE_REQUIRED_ROLE:
				setResourceRequiredRole((ResourceRequiredRole)null);
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
			case QualityAnnotationPackage.PCMRE_RESOURCE_ROLE__RESOURCE_REQUIRED_ROLE:
				return resourceRequiredRole != null;
		}
		return super.eIsSet(featureID);
	}

} //PCMREResourceRoleImpl
