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

import de.fzi.se.quality.qualityannotation.PCMREInterface;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.util.QualityAnnotationValidator;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>PCMRE Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.PCMREInterfaceImpl#getInterface <em>Interface
 * </em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMREInterfaceImpl extends PCMREImpl implements PCMREInterface {

    /**
     * The cached value of the '{@link #getInterface() <em>Interface</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getInterface()
     * @generated
     * @ordered
     */
    protected OperationInterface interface_;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PCMREInterfaceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.PCMRE_INTERFACE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OperationInterface getInterface() {
        if (this.interface_ != null && ((EObject) this.interface_).eIsProxy()) {
            final InternalEObject oldInterface = (InternalEObject) this.interface_;
            this.interface_ = (OperationInterface) this.eResolveProxy(oldInterface);
            if (this.interface_ != oldInterface) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            QualityAnnotationPackage.PCMRE_INTERFACE__INTERFACE, oldInterface, this.interface_));
                }
            }
        }
        return this.interface_;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public OperationInterface basicGetInterface() {
        return this.interface_;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setInterface(final OperationInterface newInterface) {
        final OperationInterface oldInterface = this.interface_;
        this.interface_ = newInterface;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.PCMRE_INTERFACE__INTERFACE, oldInterface, this.interface_));
        }
    }

    /**
     * The cached OCL expression body for the '
     * {@link #NextLowerLevelMustConsistOfTypePCMRERole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Level Must Consist Of Type PCMRE Role</em>}' operation. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #NextLowerLevelMustConsistOfTypePCMRERole(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.childREs->select(pcmre | not pcmre.oclIsTypeOf(PCMRERole))->size() = 0";
    /**
     * The cached OCL invariant for the '
     * {@link #NextLowerLevelMustConsistOfTypePCMRERole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Next Lower Level Must Consist Of Type PCMRE Role</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #NextLowerLevelMustConsistOfTypePCMRERole(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean NextLowerLevelMustConsistOfTypePCMRERole(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE_INTERFACE);
            try {
                NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                        QualityAnnotationValidator.PCMRE_INTERFACE__NEXT_LOWER_LEVEL_MUST_CONSIST_OF_TYPE_PCMRE_ROLE,
                        EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] { "NextLowerLevelMustConsistOfTypePCMRERole",
                                        EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
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
    protected static final String EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parentRE.childREs->select(pcmre | pcmre.oclAsType(PCMREInterface).interface = self.interface)->size() = 1";
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
            helper.setContext(QualityAnnotationPackage.Literals.PCMRE_INTERFACE);
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
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                        QualityAnnotationValidator.PCMRE_INTERFACE__EACH_RE_TARGET_MUST_BE_REFERENCED_ONLY_FROM_ONE_RE,
                        EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] { "EachRETargetMustBeReferencedOnlyFromOneRE",
                                        EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
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
        case QualityAnnotationPackage.PCMRE_INTERFACE__INTERFACE:
            if (resolve) {
                return this.getInterface();
            }
            return this.basicGetInterface();
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
        case QualityAnnotationPackage.PCMRE_INTERFACE__INTERFACE:
            this.setInterface((OperationInterface) newValue);
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
        case QualityAnnotationPackage.PCMRE_INTERFACE__INTERFACE:
            this.setInterface((OperationInterface) null);
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
        case QualityAnnotationPackage.PCMRE_INTERFACE__INTERFACE:
            return this.interface_ != null;
        }
        return super.eIsSet(featureID);
    }

} // PCMREInterfaceImpl
