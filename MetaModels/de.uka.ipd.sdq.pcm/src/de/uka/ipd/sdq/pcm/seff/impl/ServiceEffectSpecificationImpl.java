/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.util.SeffValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Service Effect Specification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ServiceEffectSpecificationImpl#getSeffTypeID <em>Seff
 * Type ID</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ServiceEffectSpecificationImpl#getDescribedService__SEFF
 * <em>Described Service SEFF</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.ServiceEffectSpecificationImpl#getBasicComponent_ServiceEffectSpecification
 * <em>Basic Component Service Effect Specification</em>}</li>
 * </ul>
 * </p>
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
     * The cached value of the '{@link #getSeffTypeID() <em>Seff Type ID</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSeffTypeID()
     * @generated
     * @ordered
     */
    protected String seffTypeID = SEFF_TYPE_ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getDescribedService__SEFF() <em>Described Service SEFF</em>}
     * ' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getDescribedService__SEFF()
     * @generated
     * @ordered
     */
    protected Signature describedService__SEFF;

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
    public String getSeffTypeID() {
        return this.seffTypeID;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSeffTypeID(final String newSeffTypeID) {
        final String oldSeffTypeID = this.seffTypeID;
        this.seffTypeID = newSeffTypeID;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID, oldSeffTypeID, this.seffTypeID));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Signature getDescribedService__SEFF() {
        if (this.describedService__SEFF != null && ((EObject) this.describedService__SEFF).eIsProxy()) {
            final InternalEObject oldDescribedService__SEFF = (InternalEObject) this.describedService__SEFF;
            this.describedService__SEFF = (Signature) this.eResolveProxy(oldDescribedService__SEFF);
            if (this.describedService__SEFF != oldDescribedService__SEFF) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPackage.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF,
                            oldDescribedService__SEFF, this.describedService__SEFF));
                }
            }
        }
        return this.describedService__SEFF;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Signature basicGetDescribedService__SEFF() {
        return this.describedService__SEFF;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDescribedService__SEFF(final Signature newDescribedService__SEFF) {
        final Signature oldDescribedService__SEFF = this.describedService__SEFF;
        this.describedService__SEFF = newDescribedService__SEFF;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF, oldDescribedService__SEFF,
                    this.describedService__SEFF));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public BasicComponent getBasicComponent_ServiceEffectSpecification() {
        if (this.eContainerFeatureID() != SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION) {
            return null;
        }
        return (BasicComponent) this.eInternalContainer();
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
        if (newBasicComponent_ServiceEffectSpecification != this.eInternalContainer()
                || (this.eContainerFeatureID() != SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION && newBasicComponent_ServiceEffectSpecification != null)) {
            if (EcoreUtil.isAncestor(this, newBasicComponent_ServiceEffectSpecification)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newBasicComponent_ServiceEffectSpecification != null) {
                msgs = ((InternalEObject) newBasicComponent_ServiceEffectSpecification).eInverseAdd(this,
                        RepositoryPackage.BASIC_COMPONENT__SERVICE_EFFECT_SPECIFICATIONS_BASIC_COMPONENT,
                        BasicComponent.class, msgs);
            }
            msgs = this.basicSetBasicComponent_ServiceEffectSpecification(newBasicComponent_ServiceEffectSpecification,
                    msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION,
                    newBasicComponent_ServiceEffectSpecification, newBasicComponent_ServiceEffectSpecification));
        }
    }

    /**
     * The cached OCL expression body for the '
     * {@link #ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Referenced Signature Must Belong To Interface Referenced By Provided Role</em>}'
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "if self.describedService__SEFF.oclIsKindOf(pcm::repository::OperationSignature) then\n"
            + "	self.basicComponent_ServiceEffectSpecification.providedRoles_InterfaceProvidingEntity->exists(p | p.oclIsKindOf(pcm::repository::OperationProvidedRole) and (p.oclAsType(pcm::repository::OperationProvidedRole).providedInterface__OperationProvidedRole = self.describedService__SEFF.oclAsType(pcm::repository::OperationSignature).interface__OperationSignature))\n"
            + "else\n"
            + "	if self.describedService__SEFF.oclIsKindOf(pcm::repository::EventType) then\n"
            + "		self.basicComponent_ServiceEffectSpecification.providedRoles_InterfaceProvidingEntity->exists(p | p.oclIsKindOf(pcm::repository::SinkRole) and (p.oclAsType(pcm::repository::SinkRole).eventGroup__SinkRole = self.describedService__SEFF.oclAsType(pcm::repository::EventType).eventGroup__EventType))\n"
            + "	else\n" + "		true\n" + "	endif\n" + "endif";

    /**
     * The cached OCL invariant for the '
     * {@link #ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Referenced Signature Must Belong To Interface Referenced By Provided Role</em>}'
     * invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SeffPackage.Literals.SERVICE_EFFECT_SPECIFICATION);
            try {
                REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                        .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        SeffValidator.DIAGNOSTIC_SOURCE,
                        SeffValidator.SERVICE_EFFECT_SPECIFICATION__REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                "ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole",
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
            return SEFF_TYPE_ID_EDEFAULT == null ? this.seffTypeID != null : !SEFF_TYPE_ID_EDEFAULT
                    .equals(this.seffTypeID);
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF:
            return this.describedService__SEFF != null;
        case SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
            return this.getBasicComponent_ServiceEffectSpecification() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (seffTypeID: ");
        result.append(this.seffTypeID);
        result.append(')');
        return result.toString();
    }

    /**
     * The cached environment for evaluating OCL expressions. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // ServiceEffectSpecificationImpl
