/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;
import org.palladiosimulator.pcm.protocol.Protocol;
import org.palladiosimulator.pcm.repository.Interface;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.RequiredCharacterisation;
import org.palladiosimulator.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Interface</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.palladiosimulator.pcm.repository.impl.InterfaceImpl#getParentInterfaces__Interface
 * <em>Parent Interfaces Interface</em>}</li>
 * <li>{@link org.palladiosimulator.pcm.repository.impl.InterfaceImpl#getProtocols__Interface
 * <em>Protocols Interface</em>}</li>
 * <li>{@link org.palladiosimulator.pcm.repository.impl.InterfaceImpl#getRequiredCharacterisations
 * <em>Required Characterisations</em>}</li>
 * <li>{@link org.palladiosimulator.pcm.repository.impl.InterfaceImpl#getRepository__Interface
 * <em>Repository Interface</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class InterfaceImpl extends EntityImpl implements Interface {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected InterfaceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.INTERFACE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<Interface> getParentInterfaces__Interface() {
        return (EList<Interface>) this.eDynamicGet(RepositoryPackage.INTERFACE__PARENT_INTERFACES_INTERFACE,
                RepositoryPackage.Literals.INTERFACE__PARENT_INTERFACES_INTERFACE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<Protocol> getProtocols__Interface() {
        return (EList<Protocol>) this.eDynamicGet(RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE,
                RepositoryPackage.Literals.INTERFACE__PROTOCOLS_INTERFACE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<RequiredCharacterisation> getRequiredCharacterisations() {
        return (EList<RequiredCharacterisation>) this.eDynamicGet(
                RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS,
                RepositoryPackage.Literals.INTERFACE__REQUIRED_CHARACTERISATIONS, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Repository getRepository__Interface() {
        return (Repository) this.eDynamicGet(RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE,
                RepositoryPackage.Literals.INTERFACE__REPOSITORY_INTERFACE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetRepository__Interface(final Repository newRepository__Interface,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newRepository__Interface,
                RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRepository__Interface(final Repository newRepository__Interface) {
        this.eDynamicSet(RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE,
                RepositoryPackage.Literals.INTERFACE__REPOSITORY_INTERFACE, newRepository__Interface);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean NoProtocolTypeIDUsedTwice(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, RepositoryValidator.DIAGNOSTIC_SOURCE,
                                RepositoryValidator.INTERFACE__NO_PROTOCOL_TYPE_ID_USED_TWICE,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "NoProtocolTypeIDUsedTwice",
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
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getRequiredCharacterisations())
                    .basicAdd(otherEnd, msgs);
        case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetRepository__Interface((Repository) otherEnd, msgs);
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
        case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
            return ((InternalEList<?>) this.getProtocols__Interface()).basicRemove(otherEnd, msgs);
        case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
            return ((InternalEList<?>) this.getRequiredCharacterisations()).basicRemove(otherEnd, msgs);
        case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
            return this.basicSetRepository__Interface(null, msgs);
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
        case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
            return this.eInternalContainer().eInverseRemove(this, RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY,
                    Repository.class, msgs);
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
        case RepositoryPackage.INTERFACE__PARENT_INTERFACES_INTERFACE:
            return this.getParentInterfaces__Interface();
        case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
            return this.getProtocols__Interface();
        case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
            return this.getRequiredCharacterisations();
        case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
            return this.getRepository__Interface();
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
        case RepositoryPackage.INTERFACE__PARENT_INTERFACES_INTERFACE:
            this.getParentInterfaces__Interface().clear();
            this.getParentInterfaces__Interface().addAll((Collection<? extends Interface>) newValue);
            return;
        case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
            this.getProtocols__Interface().clear();
            this.getProtocols__Interface().addAll((Collection<? extends Protocol>) newValue);
            return;
        case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
            this.getRequiredCharacterisations().clear();
            this.getRequiredCharacterisations().addAll((Collection<? extends RequiredCharacterisation>) newValue);
            return;
        case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
            this.setRepository__Interface((Repository) newValue);
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
        case RepositoryPackage.INTERFACE__PARENT_INTERFACES_INTERFACE:
            this.getParentInterfaces__Interface().clear();
            return;
        case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
            this.getProtocols__Interface().clear();
            return;
        case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
            this.getRequiredCharacterisations().clear();
            return;
        case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
            this.setRepository__Interface((Repository) null);
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
        case RepositoryPackage.INTERFACE__PARENT_INTERFACES_INTERFACE:
            return !this.getParentInterfaces__Interface().isEmpty();
        case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
            return !this.getProtocols__Interface().isEmpty();
        case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
            return !this.getRequiredCharacterisations().isEmpty();
        case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
            return this.getRepository__Interface() != null;
        }
        return super.eIsSet(featureID);
    }

} // InterfaceImpl
