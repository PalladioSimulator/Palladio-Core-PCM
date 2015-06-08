/**
 */
package de.fzi.se.quality.qualityannotation.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.fzi.se.quality.qualityannotation.PCMREResourceRole;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.util.QualityAnnotationValidator;
import de.uka.ipd.sdq.pcm.core.entity.ResourceRequiredRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>PCMRE Resource Role</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.PCMREResourceRoleImpl#getResourceRole <em>
 * Resource Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMREResourceRoleImpl extends PCMREImpl implements PCMREResourceRole {

    /**
     * The cached value of the '{@link #getResourceRole() <em>Resource Role</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getResourceRole()
     * @generated
     * @ordered
     */
    protected ResourceRequiredRole resourceRole;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PCMREResourceRoleImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.PCMRE_RESOURCE_ROLE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceRequiredRole getResourceRole() {
        if (this.resourceRole != null && ((EObject) this.resourceRole).eIsProxy()) {
            final InternalEObject oldResourceRole = (InternalEObject) this.resourceRole;
            this.resourceRole = (ResourceRequiredRole) this.eResolveProxy(oldResourceRole);
            if (this.resourceRole != oldResourceRole) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            QualityAnnotationPackage.PCMRE_RESOURCE_ROLE__RESOURCE_ROLE, oldResourceRole,
                            this.resourceRole));
                }
            }
        }
        return this.resourceRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceRequiredRole basicGetResourceRole() {
        return this.resourceRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceRole(final ResourceRequiredRole newResourceRole) {
        final ResourceRequiredRole oldResourceRole = this.resourceRole;
        this.resourceRole = newResourceRole;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.PCMRE_RESOURCE_ROLE__RESOURCE_ROLE, oldResourceRole, this.resourceRole));
        }
    }

    /**
     * The cached OCL expression body for the '
     * {@link #NextLowerLevelMustConsistOfTypePCMREResourceSignature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Level Must Consist Of Type PCMRE Resource Signature</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #NextLowerLevelMustConsistOfTypePCMREResourceSignature(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.childREs->select(pcmre | not pcmre.oclIsTypeOf(PCMREResourceSignature))->size() = 0";

    /**
     * The cached OCL invariant for the '
     * {@link #NextLowerLevelMustConsistOfTypePCMREResourceSignature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Level Must Consist Of Type PCMRE Resource Signature</em>}' invariant
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #NextLowerLevelMustConsistOfTypePCMREResourceSignature(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean NextLowerLevelMustConsistOfTypePCMREResourceSignature(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE_RESOURCE_ROLE);
            try {
                NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(
                this)) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(
                                Diagnostic.ERROR,
                                QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                                QualityAnnotationValidator.PCMRE_RESOURCE_ROLE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_RESOURCE_SIGNATURE,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "NextLowerLevelMustConsistOfTypePCMREResourceSignature",
                                                EObjectValidator.getObjectLabel(this, context) }),
                                new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #EachRETargetMustBeReferencedOnlyFromOneRE(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Each RE Target Must Be Referenced Only From One RE</em>}' operation. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #EachRETargetMustBeReferencedOnlyFromOneRE(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parentRE.childREs->select(pcmre | pcmre.oclAsType(PCMREResourceRole).resourceRequiredRole = self.resourceRequiredRole)->size() = 1";

    /**
     * The cached OCL invariant for the '
     * {@link #EachRETargetMustBeReferencedOnlyFromOneRE(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Each RE Target Must Be Referenced Only From One RE</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #EachRETargetMustBeReferencedOnlyFromOneRE(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean EachRETargetMustBeReferencedOnlyFromOneRE(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE_RESOURCE_ROLE);
            try {
                EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(
                                Diagnostic.ERROR,
                                QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                                QualityAnnotationValidator.PCMRE_RESOURCE_ROLE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE,
                                EcorePlugin.INSTANCE.getString(
                                        "_UI_GenericInvariant_diagnostic",
                                        new Object[] { "EachRETargetMustBeReferencedOnlyFromOneRE",
                                                EObjectValidator.getObjectLabel(this, context) }),
                                new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case QualityAnnotationPackage.PCMRE_RESOURCE_ROLE__RESOURCE_ROLE:
            if (resolve) {
                return this.getResourceRole();
            }
            return this.basicGetResourceRole();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case QualityAnnotationPackage.PCMRE_RESOURCE_ROLE__RESOURCE_ROLE:
            this.setResourceRole((ResourceRequiredRole) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case QualityAnnotationPackage.PCMRE_RESOURCE_ROLE__RESOURCE_ROLE:
            this.setResourceRole((ResourceRequiredRole) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case QualityAnnotationPackage.PCMRE_RESOURCE_ROLE__RESOURCE_ROLE:
            return this.resourceRole != null;
        }
        return super.eIsSet(featureID);
    }

} // PCMREResourceRoleImpl
