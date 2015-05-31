/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.protocol.Protocol;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation;
import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Interface</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getParentInterfaces__Interface <em>
 * Parent Interfaces Interface</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getProtocols__Interface <em>Protocols
 * Interface</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getRequiredCharacterisations <em>
 * Required Characterisations</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getRepository__Interface <em>
 * Repository Interface</em>}</li>
 * </ul>
 * </p>
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
     * The cached value of the '{@link #getParentInterfaces__Interface()
     * <em>Parent Interfaces Interface</em>}' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getParentInterfaces__Interface()
     * @generated
     * @ordered
     */
    protected EList<Interface> parentInterfaces__Interface;

    /**
     * The cached value of the '{@link #getProtocols__Interface() <em>Protocols Interface</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getProtocols__Interface()
     * @generated
     * @ordered
     */
    protected EList<Protocol> protocols__Interface;

    /**
     * The cached value of the '{@link #getRequiredCharacterisations()
     * <em>Required Characterisations</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getRequiredCharacterisations()
     * @generated
     * @ordered
     */
    protected EList<RequiredCharacterisation> requiredCharacterisations;

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
    @SuppressWarnings("unchecked")
    @Override
    public EList<Interface> getParentInterfaces__Interface() {
        if (this.parentInterfaces__Interface == null) {
            this.parentInterfaces__Interface = new EObjectResolvingEList<Interface>(Interface.class, this,
                    RepositoryPackage.INTERFACE__PARENT_INTERFACES_INTERFACE);
        }
        return this.parentInterfaces__Interface;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<Protocol> getProtocols__Interface() {
        if (this.protocols__Interface == null) {
            this.protocols__Interface = new EObjectContainmentEList<Protocol>(Protocol.class, this,
                    RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE);
        }
        return this.protocols__Interface;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<RequiredCharacterisation> getRequiredCharacterisations() {
        if (this.requiredCharacterisations == null) {
            this.requiredCharacterisations = new EObjectContainmentWithInverseEList<RequiredCharacterisation>(
                    RequiredCharacterisation.class, this, RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS,
                    RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION);
        }
        return this.requiredCharacterisations;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Repository getRepository__Interface() {
        if (this.eContainerFeatureID() != RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE) {
            return null;
        }
        return (Repository) this.eInternalContainer();
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
        if (newRepository__Interface != this.eInternalContainer()
                || (this.eContainerFeatureID() != RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE && newRepository__Interface != null)) {
            if (EcoreUtil.isAncestor(this, newRepository__Interface)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newRepository__Interface != null) {
                msgs = ((InternalEObject) newRepository__Interface).eInverseAdd(this,
                        RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY, Repository.class, msgs);
            }
            msgs = this.basicSetRepository__Interface(newRepository__Interface, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE, newRepository__Interface,
                    newRepository__Interface));
        }
    }

    /**
     * The cached OCL expression body for the '
     * {@link #NoProtocolTypeIDUsedTwice(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>No Protocol Type ID Used Twice</em>}' operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #NoProtocolTypeIDUsedTwice(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.protocols__Interface->forAll(p1, p2 |\n"
            + "p1.protocolTypeID <> p2.protocolTypeID)\n" + "";

    /**
     * The cached OCL invariant for the '
     * {@link #NoProtocolTypeIDUsedTwice(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>No Protocol Type ID Used Twice</em>}' invariant operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #NoProtocolTypeIDUsedTwice(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean NoProtocolTypeIDUsedTwice(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(RepositoryPackage.Literals.INTERFACE);
            try {
                NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, RepositoryValidator.DIAGNOSTIC_SOURCE,
                        RepositoryValidator.INTERFACE__NO_PROTOCOL_TYPE_ID_USED_TWICE, EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic", new Object[] { "NoProtocolTypeIDUsedTwice",
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
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getRequiredCharacterisations()).basicAdd(
                    otherEnd, msgs);
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
    @SuppressWarnings("unchecked")
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case RepositoryPackage.INTERFACE__PARENT_INTERFACES_INTERFACE:
            return this.parentInterfaces__Interface != null && !this.parentInterfaces__Interface.isEmpty();
        case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
            return this.protocols__Interface != null && !this.protocols__Interface.isEmpty();
        case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
            return this.requiredCharacterisations != null && !this.requiredCharacterisations.isEmpty();
        case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
            return this.getRepository__Interface() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * The cached environment for evaluating OCL expressions. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // InterfaceImpl
