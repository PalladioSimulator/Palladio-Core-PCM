/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.qualityannotation.PCMREResourceInterface;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.fzi.se.quality.qualityannotation.util.QualityAnnotationValidator;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;

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
 * An implementation of the model object '<em><b>PCMRE Resource Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.PCMREResourceInterfaceImpl#getResourceInterface <em>Resource Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMREResourceInterfaceImpl extends PCMREImpl implements PCMREResourceInterface {
	/**
	 * The cached value of the '{@link #getResourceInterface() <em>Resource Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceInterface()
	 * @generated
	 * @ordered
	 */
	protected ResourceInterface resourceInterface;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMREResourceInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityAnnotationPackage.Literals.PCMRE_RESOURCE_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInterface getResourceInterface() {
		if (resourceInterface != null && resourceInterface.eIsProxy()) {
			InternalEObject oldResourceInterface = (InternalEObject)resourceInterface;
			resourceInterface = (ResourceInterface)eResolveProxy(oldResourceInterface);
			if (resourceInterface != oldResourceInterface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE__RESOURCE_INTERFACE, oldResourceInterface, resourceInterface));
			}
		}
		return resourceInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInterface basicGetResourceInterface() {
		return resourceInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceInterface(ResourceInterface newResourceInterface) {
		ResourceInterface oldResourceInterface = resourceInterface;
		resourceInterface = newResourceInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE__RESOURCE_INTERFACE, oldResourceInterface, resourceInterface));
	}

	/**
	 * The cached OCL expression body for the '{@link #NextLowerLevelMustConsistOfTypePCMREResourceRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Next Lower Level Must Consist Of Type PCMRE Resource Role</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NextLowerLevelMustConsistOfTypePCMREResourceRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.childREs->select(pcmre | not pcmre.oclIsTypeOf(PCMREResourceRole))->size() = 0";
	/**
	 * The cached OCL invariant for the '{@link #NextLowerLevelMustConsistOfTypePCMREResourceRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Next Lower Level Must Consist Of Type PCMRE Resource Role</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NextLowerLevelMustConsistOfTypePCMREResourceRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean NextLowerLevelMustConsistOfTypePCMREResourceRole(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(QualityAnnotationPackage.Literals.PCMRE_RESOURCE_INTERFACE);
			try {
				NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
						 QualityAnnotationValidator.PCMRE_RESOURCE_INTERFACE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_ROLE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "NextLowerLevelMustConsistOfTypePCMREResourceRole", EObjectValidator.getObjectLabel(this, context) }),
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
	protected static final String EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parentRE.childREs->select(pcmre | pcmre.oclAsType(PCMREResourceInterface).resourceInterface = self.resourceInterface)->size() = 1";
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
			helper.setContext(QualityAnnotationPackage.Literals.PCMRE_RESOURCE_INTERFACE);
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
						 QualityAnnotationValidator.PCMRE_RESOURCE_INTERFACE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE,
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
			case QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE__RESOURCE_INTERFACE:
				if (resolve) return getResourceInterface();
				return basicGetResourceInterface();
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
			case QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE__RESOURCE_INTERFACE:
				setResourceInterface((ResourceInterface)newValue);
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
			case QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE__RESOURCE_INTERFACE:
				setResourceInterface((ResourceInterface)null);
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
			case QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE__RESOURCE_INTERFACE:
				return resourceInterface != null;
		}
		return super.eIsSet(featureID);
	}

} //PCMREResourceInterfaceImpl
