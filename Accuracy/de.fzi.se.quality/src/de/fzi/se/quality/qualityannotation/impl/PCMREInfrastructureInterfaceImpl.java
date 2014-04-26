/**
 */
package de.fzi.se.quality.qualityannotation.impl;

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

import de.fzi.se.quality.qualityannotation.PCMREInfrastructureInterface;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.util.QualityAnnotationValidator;
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PCMRE Infrastructure Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.PCMREInfrastructureInterfaceImpl#getInterface <em>Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMREInfrastructureInterfaceImpl extends PCMREImpl implements PCMREInfrastructureInterface {
	/**
     * The cached value of the '{@link #getInterface() <em>Interface</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInterface()
     * @generated
     * @ordered
     */
	protected InfrastructureInterface interface_;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PCMREInfrastructureInterfaceImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.PCMRE_INFRASTRUCTURE_INTERFACE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public InfrastructureInterface getInterface() {
        if (interface_ != null && interface_.eIsProxy()) {
            InternalEObject oldInterface = (InternalEObject)interface_;
            interface_ = (InfrastructureInterface)eResolveProxy(oldInterface);
            if (interface_ != oldInterface) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_INTERFACE__INTERFACE, oldInterface, interface_));
            }
        }
        return interface_;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public InfrastructureInterface basicGetInterface() {
        return interface_;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setInterface(InfrastructureInterface newInterface) {
        InfrastructureInterface oldInterface = interface_;
        interface_ = newInterface;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_INTERFACE__INTERFACE, oldInterface, interface_));
    }

	/**
     * The cached OCL expression body for the '{@link #NextLowerLevelMustConsistOfTypePCMREInfrastructureRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Next Lower Level Must Consist Of Type PCMRE Infrastructure Role</em>}' operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #NextLowerLevelMustConsistOfTypePCMREInfrastructureRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
	protected static final String NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.childREs->select(pcmre | not pcmre.oclIsTypeOf(PCMREInfrastructureRole))->size() = 0";

	/**
     * The cached OCL invariant for the '{@link #NextLowerLevelMustConsistOfTypePCMREInfrastructureRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Next Lower Level Must Consist Of Type PCMRE Infrastructure Role</em>}' invariant operation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #NextLowerLevelMustConsistOfTypePCMREInfrastructureRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
	protected static Constraint NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean NextLowerLevelMustConsistOfTypePCMREInfrastructureRole(DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE_INFRASTRUCTURE_INTERFACE);
            try {
                NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            }
            catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                         QualityAnnotationValidator.PCMRE_INFRASTRUCTURE_INTERFACE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_INFRASTRUCTURE_ROLE,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "NextLowerLevelMustConsistOfTypePCMREInfrastructureRole", EObjectValidator.getObjectLabel(this, context) }),
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
	protected static final String EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parentRE.childREs->select(pcmre | pcmre.oclAsType(PCMREInfrastructureInterface).interface = self.interface)->size() = 1";

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
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE_INFRASTRUCTURE_INTERFACE);
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
                         QualityAnnotationValidator.PCMRE_INFRASTRUCTURE_INTERFACE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE,
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
            case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_INTERFACE__INTERFACE:
                if (resolve) return getInterface();
                return basicGetInterface();
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
            case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_INTERFACE__INTERFACE:
                setInterface((InfrastructureInterface)newValue);
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
            case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_INTERFACE__INTERFACE:
                setInterface((InfrastructureInterface)null);
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
            case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_INTERFACE__INTERFACE:
                return interface_ != null;
        }
        return super.eIsSet(featureID);
    }

} //PCMREInfrastructureInterfaceImpl
