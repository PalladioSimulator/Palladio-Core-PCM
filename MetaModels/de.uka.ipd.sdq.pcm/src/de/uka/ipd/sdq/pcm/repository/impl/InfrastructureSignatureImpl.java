/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Infrastructure Signature</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.impl.InfrastructureSignatureImpl#getParameters__InfrastructureSignature
 * <em>Parameters Infrastructure Signature</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.impl.InfrastructureSignatureImpl#getInfrastructureInterface__InfrastructureSignature
 * <em>Infrastructure Interface Infrastructure Signature</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class InfrastructureSignatureImpl extends SignatureImpl implements InfrastructureSignature {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the ' {@link #getParameters__InfrastructureSignature()
     * <em>Parameters Infrastructure Signature</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getParameters__InfrastructureSignature()
     * @generated
     * @ordered
     */
    protected EList<Parameter> parameters__InfrastructureSignature;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected InfrastructureSignatureImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.INFRASTRUCTURE_SIGNATURE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Parameter> getParameters__InfrastructureSignature() {
        if (this.parameters__InfrastructureSignature == null) {
            this.parameters__InfrastructureSignature = new EObjectContainmentWithInverseEList<Parameter>(
                    Parameter.class, this,
                    RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE,
                    RepositoryPackage.PARAMETER__INFRASTRUCTURE_SIGNATURE_PARAMETER);
        }
        return this.parameters__InfrastructureSignature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InfrastructureInterface getInfrastructureInterface__InfrastructureSignature() {
        if (this.eContainerFeatureID() != RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE) {
            return null;
        }
        return (InfrastructureInterface) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetInfrastructureInterface__InfrastructureSignature(
            final InfrastructureInterface newInfrastructureInterface__InfrastructureSignature, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newInfrastructureInterface__InfrastructureSignature,
                RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setInfrastructureInterface__InfrastructureSignature(
            final InfrastructureInterface newInfrastructureInterface__InfrastructureSignature) {
        if (newInfrastructureInterface__InfrastructureSignature != this.eInternalContainer()
                || (this.eContainerFeatureID() != RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE && newInfrastructureInterface__InfrastructureSignature != null)) {
            if (EcoreUtil.isAncestor(this, newInfrastructureInterface__InfrastructureSignature)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newInfrastructureInterface__InfrastructureSignature != null) {
                msgs = ((InternalEObject) newInfrastructureInterface__InfrastructureSignature).eInverseAdd(this,
                        RepositoryPackage.INFRASTRUCTURE_INTERFACE__INFRASTRUCTURE_SIGNATURES_INFRASTRUCTURE_INTERFACE,
                        InfrastructureInterface.class, msgs);
            }
            msgs = this.basicSetInfrastructureInterface__InfrastructureSignature(
                    newInfrastructureInterface__InfrastructureSignature, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE,
                    newInfrastructureInterface__InfrastructureSignature,
                    newInfrastructureInterface__InfrastructureSignature));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getParameters__InfrastructureSignature())
                    .basicAdd(otherEnd, msgs);
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetInfrastructureInterface__InfrastructureSignature((InfrastructureInterface) otherEnd,
                    msgs);
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
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE:
            return ((InternalEList<?>) this.getParameters__InfrastructureSignature()).basicRemove(otherEnd, msgs);
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE:
            return this.basicSetInfrastructureInterface__InfrastructureSignature(null, msgs);
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
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE:
            return this.eInternalContainer().eInverseRemove(this,
                    RepositoryPackage.INFRASTRUCTURE_INTERFACE__INFRASTRUCTURE_SIGNATURES_INFRASTRUCTURE_INTERFACE,
                    InfrastructureInterface.class, msgs);
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
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE:
            return this.getParameters__InfrastructureSignature();
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE:
            return this.getInfrastructureInterface__InfrastructureSignature();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE:
            this.getParameters__InfrastructureSignature().clear();
            this.getParameters__InfrastructureSignature().addAll((Collection<? extends Parameter>) newValue);
            return;
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE:
            this.setInfrastructureInterface__InfrastructureSignature((InfrastructureInterface) newValue);
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
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE:
            this.getParameters__InfrastructureSignature().clear();
            return;
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE:
            this.setInfrastructureInterface__InfrastructureSignature((InfrastructureInterface) null);
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
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE:
            return this.parameters__InfrastructureSignature != null
                    && !this.parameters__InfrastructureSignature.isEmpty();
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE__INFRASTRUCTURE_INTERFACE_INFRASTRUCTURE_SIGNATURE:
            return this.getInfrastructureInterface__InfrastructureSignature() != null;
        }
        return super.eIsSet(featureID);
    }

} // InfrastructureSignatureImpl
