/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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

import de.fzi.se.quality.qualityannotation.PCMREResourceSignature;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.util.QualityAnnotationValidator;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceSignature;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>PCMRE Resource Signature</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.PCMREResourceSignatureImpl#getResourceSignature
 * <em>Resource Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMREResourceSignatureImpl extends PCMREImpl implements PCMREResourceSignature {

    /**
     * The cached value of the '{@link #getResourceSignature() <em>Resource Signature</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getResourceSignature()
     * @generated
     * @ordered
     */
    protected ResourceSignature resourceSignature;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PCMREResourceSignatureImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.PCMRE_RESOURCE_SIGNATURE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceSignature getResourceSignature() {
        if (this.resourceSignature != null && ((EObject) this.resourceSignature).eIsProxy()) {
            final InternalEObject oldResourceSignature = (InternalEObject) this.resourceSignature;
            this.resourceSignature = (ResourceSignature) this.eResolveProxy(oldResourceSignature);
            if (this.resourceSignature != oldResourceSignature) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE__RESOURCE_SIGNATURE,
                            oldResourceSignature, this.resourceSignature));
                }
            }
        }
        return this.resourceSignature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceSignature basicGetResourceSignature() {
        return this.resourceSignature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceSignature(final ResourceSignature newResourceSignature) {
        final ResourceSignature oldResourceSignature = this.resourceSignature;
        this.resourceSignature = newResourceSignature;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE__RESOURCE_SIGNATURE, oldResourceSignature,
                    this.resourceSignature));
        }
    }

    /**
     * The cached OCL expression body for the '
     * {@link #ThisIsTheLowestResourceHierarchyLevel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>This Is The Lowest Resource Hierarchy Level</em>}' operation. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #ThisIsTheLowestResourceHierarchyLevel(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String THIS_IS_THE_LOWEST_RESOURCE_HIERARCHY_LEVEL__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.childREs->isEmpty()";
    /**
     * The cached OCL invariant for the '
     * {@link #ThisIsTheLowestResourceHierarchyLevel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>This Is The Lowest Resource Hierarchy Level</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #ThisIsTheLowestResourceHierarchyLevel(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint THIS_IS_THE_LOWEST_RESOURCE_HIERARCHY_LEVEL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean ThisIsTheLowestResourceHierarchyLevel(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (THIS_IS_THE_LOWEST_RESOURCE_HIERARCHY_LEVEL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE_RESOURCE_SIGNATURE);
            try {
                THIS_IS_THE_LOWEST_RESOURCE_HIERARCHY_LEVEL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(THIS_IS_THE_LOWEST_RESOURCE_HIERARCHY_LEVEL__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(THIS_IS_THE_LOWEST_RESOURCE_HIERARCHY_LEVEL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(
                this)) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(
                                Diagnostic.ERROR,
                                QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                                QualityAnnotationValidator.PCMRE_RESOURCE_SIGNATURE__THIS_IS_THE_LOWEST_RESOURCE_HIERARCHY_LEVEL,
                                EcorePlugin.INSTANCE.getString(
                                        "_UI_GenericInvariant_diagnostic",
                                        new Object[] { "ThisIsTheLowestResourceHierarchyLevel",
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
    protected static final String EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parentRE.childREs->select(pcmre | pcmre.oclAsType(PCMREResourceSignature).resourceSignature = self.resourceSignature)->size() = 1";
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
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE_RESOURCE_SIGNATURE);
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
                                QualityAnnotationValidator.PCMRE_RESOURCE_SIGNATURE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE,
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
        case QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE__RESOURCE_SIGNATURE:
            if (resolve) {
                return this.getResourceSignature();
            }
            return this.basicGetResourceSignature();
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
        case QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE__RESOURCE_SIGNATURE:
            this.setResourceSignature((ResourceSignature) newValue);
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
        case QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE__RESOURCE_SIGNATURE:
            this.setResourceSignature((ResourceSignature) null);
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
        case QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE__RESOURCE_SIGNATURE:
            return this.resourceSignature != null;
        }
        return super.eIsSet(featureID);
    }

} // PCMREResourceSignatureImpl
