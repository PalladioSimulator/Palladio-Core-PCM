/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.seff.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.Signature;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;
import org.palladiosimulator.pcm.seff.util.SeffValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Service Effect Specification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.pcm.seff.impl.ServiceEffectSpecificationImpl#getSeffTypeID
 * <em>Seff Type ID</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.seff.impl.ServiceEffectSpecificationImpl#getDescribedService__SEFF
 * <em>Described Service SEFF</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.seff.impl.ServiceEffectSpecificationImpl#getBasicComponent_ServiceEffectSpecification
 * <em>Basic Component Service Effect Specification</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ServiceEffectSpecificationImpl extends CDOObjectImpl implements ServiceEffectSpecification {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getSeffTypeID() <em>Seff Type ID</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSeffTypeID()
     * @generated
     * @ordered
     */
    protected static final String SEFF_TYPE_ID_EDEFAULT = "1";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ServiceEffectSpecificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.SERVICE_EFFECT_SPECIFICATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getSeffTypeID() {
        return (String) this.eDynamicGet(SeffPackage.SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID,
                SeffPackage.Literals.SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSeffTypeID(final String newSeffTypeID) {
        this.eDynamicSet(SeffPackage.SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID,
                SeffPackage.Literals.SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID, newSeffTypeID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Signature getDescribedService__SEFF() {
        return (Signature) this.eDynamicGet(SeffPackage.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF,
                SeffPackage.Literals.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Signature basicGetDescribedService__SEFF() {
        return (Signature) this.eDynamicGet(SeffPackage.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF,
                SeffPackage.Literals.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDescribedService__SEFF(final Signature newDescribedService__SEFF) {
        this.eDynamicSet(SeffPackage.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF,
                SeffPackage.Literals.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF, newDescribedService__SEFF);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public BasicComponent getBasicComponent_ServiceEffectSpecification() {
        return (BasicComponent) this.eDynamicGet(
                SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION,
                SeffPackage.Literals.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION, true,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetBasicComponent_ServiceEffectSpecification(
            final BasicComponent newBasicComponent_ServiceEffectSpecification, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newBasicComponent_ServiceEffectSpecification,
                SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setBasicComponent_ServiceEffectSpecification(
            final BasicComponent newBasicComponent_ServiceEffectSpecification) {
        this.eDynamicSet(SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION,
                SeffPackage.Literals.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION,
                newBasicComponent_ServiceEffectSpecification);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, SeffValidator.DIAGNOSTIC_SOURCE,
                                SeffValidator.SERVICE_EFFECT_SPECIFICATION__REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] {
                                                "ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole",
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
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetBasicComponent_ServiceEffectSpecification((BasicComponent) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
            return this.basicSetBasicComponent_ServiceEffectSpecification(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
            return this.eInternalContainer().eInverseRemove(this,
                    RepositoryPackage.BASIC_COMPONENT__SERVICE_EFFECT_SPECIFICATIONS_BASIC_COMPONENT,
                    BasicComponent.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID:
            return this.getSeffTypeID();
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF:
            if (resolve) {
                return this.getDescribedService__SEFF();
            }
            return this.basicGetDescribedService__SEFF();
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
            return this.getBasicComponent_ServiceEffectSpecification();
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
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID:
            this.setSeffTypeID((String) newValue);
            return;
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF:
            this.setDescribedService__SEFF((Signature) newValue);
            return;
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
            this.setBasicComponent_ServiceEffectSpecification((BasicComponent) newValue);
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
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID:
            this.setSeffTypeID(SEFF_TYPE_ID_EDEFAULT);
            return;
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF:
            this.setDescribedService__SEFF((Signature) null);
            return;
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
            this.setBasicComponent_ServiceEffectSpecification((BasicComponent) null);
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
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID:
            return SEFF_TYPE_ID_EDEFAULT == null ? this.getSeffTypeID() != null
                    : !SEFF_TYPE_ID_EDEFAULT.equals(this.getSeffTypeID());
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF:
            return this.basicGetDescribedService__SEFF() != null;
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
            return this.getBasicComponent_ServiceEffectSpecification() != null;
        }
        return super.eIsSet(featureID);
    }

} // ServiceEffectSpecificationImpl
