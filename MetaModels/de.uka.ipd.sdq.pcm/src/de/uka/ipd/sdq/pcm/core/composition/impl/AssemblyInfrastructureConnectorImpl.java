/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyInfrastructureConnector;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Assembly Infrastructure Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyInfrastructureConnectorImpl#getProvidedRole__AssemblyInfrastructureConnector
 * <em>Provided Role Assembly Infrastructure Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyInfrastructureConnectorImpl#getRequiredRole__AssemblyInfrastructureConnector
 * <em>Required Role Assembly Infrastructure Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyInfrastructureConnectorImpl#getProvidingAssemblyContext__AssemblyInfrastructureConnector
 * <em>Providing Assembly Context Assembly Infrastructure Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyInfrastructureConnectorImpl#getRequiringAssemblyContext__AssemblyInfrastructureConnector
 * <em>Requiring Assembly Context Assembly Infrastructure Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssemblyInfrastructureConnectorImpl extends ConnectorImpl implements AssemblyInfrastructureConnector {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getProvidedRole__AssemblyInfrastructureConnector()
     * <em>Provided Role Assembly Infrastructure Connector</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getProvidedRole__AssemblyInfrastructureConnector()
     * @generated
     * @ordered
     */
    protected InfrastructureProvidedRole providedRole__AssemblyInfrastructureConnector;
    /**
     * The cached value of the '{@link #getRequiredRole__AssemblyInfrastructureConnector()
     * <em>Required Role Assembly Infrastructure Connector</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getRequiredRole__AssemblyInfrastructureConnector()
     * @generated
     * @ordered
     */
    protected InfrastructureRequiredRole requiredRole__AssemblyInfrastructureConnector;
    /**
     * The cached value of the '
     * {@link #getProvidingAssemblyContext__AssemblyInfrastructureConnector()
     * <em>Providing Assembly Context Assembly Infrastructure Connector</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getProvidingAssemblyContext__AssemblyInfrastructureConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext providingAssemblyContext__AssemblyInfrastructureConnector;
    /**
     * The cached value of the '
     * {@link #getRequiringAssemblyContext__AssemblyInfrastructureConnector()
     * <em>Requiring Assembly Context Assembly Infrastructure Connector</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRequiringAssemblyContext__AssemblyInfrastructureConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext requiringAssemblyContext__AssemblyInfrastructureConnector;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AssemblyInfrastructureConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.ASSEMBLY_INFRASTRUCTURE_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InfrastructureProvidedRole getProvidedRole__AssemblyInfrastructureConnector() {
        if (this.providedRole__AssemblyInfrastructureConnector != null
                && this.providedRole__AssemblyInfrastructureConnector.eIsProxy()) {
            final InternalEObject oldProvidedRole__AssemblyInfrastructureConnector = (InternalEObject) this.providedRole__AssemblyInfrastructureConnector;
            this.providedRole__AssemblyInfrastructureConnector = (InfrastructureProvidedRole) this
                    .eResolveProxy(oldProvidedRole__AssemblyInfrastructureConnector);
            if (this.providedRole__AssemblyInfrastructureConnector != oldProvidedRole__AssemblyInfrastructureConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                            oldProvidedRole__AssemblyInfrastructureConnector,
                            this.providedRole__AssemblyInfrastructureConnector));
                }
            }
        }
        return this.providedRole__AssemblyInfrastructureConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public InfrastructureProvidedRole basicGetProvidedRole__AssemblyInfrastructureConnector() {
        return this.providedRole__AssemblyInfrastructureConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setProvidedRole__AssemblyInfrastructureConnector(
            final InfrastructureProvidedRole newProvidedRole__AssemblyInfrastructureConnector) {
        final InfrastructureProvidedRole oldProvidedRole__AssemblyInfrastructureConnector = this.providedRole__AssemblyInfrastructureConnector;
        this.providedRole__AssemblyInfrastructureConnector = newProvidedRole__AssemblyInfrastructureConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                    oldProvidedRole__AssemblyInfrastructureConnector,
                    this.providedRole__AssemblyInfrastructureConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InfrastructureRequiredRole getRequiredRole__AssemblyInfrastructureConnector() {
        if (this.requiredRole__AssemblyInfrastructureConnector != null
                && this.requiredRole__AssemblyInfrastructureConnector.eIsProxy()) {
            final InternalEObject oldRequiredRole__AssemblyInfrastructureConnector = (InternalEObject) this.requiredRole__AssemblyInfrastructureConnector;
            this.requiredRole__AssemblyInfrastructureConnector = (InfrastructureRequiredRole) this
                    .eResolveProxy(oldRequiredRole__AssemblyInfrastructureConnector);
            if (this.requiredRole__AssemblyInfrastructureConnector != oldRequiredRole__AssemblyInfrastructureConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                            oldRequiredRole__AssemblyInfrastructureConnector,
                            this.requiredRole__AssemblyInfrastructureConnector));
                }
            }
        }
        return this.requiredRole__AssemblyInfrastructureConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public InfrastructureRequiredRole basicGetRequiredRole__AssemblyInfrastructureConnector() {
        return this.requiredRole__AssemblyInfrastructureConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRequiredRole__AssemblyInfrastructureConnector(
            final InfrastructureRequiredRole newRequiredRole__AssemblyInfrastructureConnector) {
        final InfrastructureRequiredRole oldRequiredRole__AssemblyInfrastructureConnector = this.requiredRole__AssemblyInfrastructureConnector;
        this.requiredRole__AssemblyInfrastructureConnector = newRequiredRole__AssemblyInfrastructureConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                    oldRequiredRole__AssemblyInfrastructureConnector,
                    this.requiredRole__AssemblyInfrastructureConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContext getProvidingAssemblyContext__AssemblyInfrastructureConnector() {
        if (this.providingAssemblyContext__AssemblyInfrastructureConnector != null
                && this.providingAssemblyContext__AssemblyInfrastructureConnector.eIsProxy()) {
            final InternalEObject oldProvidingAssemblyContext__AssemblyInfrastructureConnector = (InternalEObject) this.providingAssemblyContext__AssemblyInfrastructureConnector;
            this.providingAssemblyContext__AssemblyInfrastructureConnector = (AssemblyContext) this
                    .eResolveProxy(oldProvidingAssemblyContext__AssemblyInfrastructureConnector);
            if (this.providingAssemblyContext__AssemblyInfrastructureConnector != oldProvidingAssemblyContext__AssemblyInfrastructureConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                            oldProvidingAssemblyContext__AssemblyInfrastructureConnector,
                            this.providingAssemblyContext__AssemblyInfrastructureConnector));
                }
            }
        }
        return this.providingAssemblyContext__AssemblyInfrastructureConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AssemblyContext basicGetProvidingAssemblyContext__AssemblyInfrastructureConnector() {
        return this.providingAssemblyContext__AssemblyInfrastructureConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setProvidingAssemblyContext__AssemblyInfrastructureConnector(
            final AssemblyContext newProvidingAssemblyContext__AssemblyInfrastructureConnector) {
        final AssemblyContext oldProvidingAssemblyContext__AssemblyInfrastructureConnector = this.providingAssemblyContext__AssemblyInfrastructureConnector;
        this.providingAssemblyContext__AssemblyInfrastructureConnector = newProvidingAssemblyContext__AssemblyInfrastructureConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                    oldProvidingAssemblyContext__AssemblyInfrastructureConnector,
                    this.providingAssemblyContext__AssemblyInfrastructureConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContext getRequiringAssemblyContext__AssemblyInfrastructureConnector() {
        if (this.requiringAssemblyContext__AssemblyInfrastructureConnector != null
                && this.requiringAssemblyContext__AssemblyInfrastructureConnector.eIsProxy()) {
            final InternalEObject oldRequiringAssemblyContext__AssemblyInfrastructureConnector = (InternalEObject) this.requiringAssemblyContext__AssemblyInfrastructureConnector;
            this.requiringAssemblyContext__AssemblyInfrastructureConnector = (AssemblyContext) this
                    .eResolveProxy(oldRequiringAssemblyContext__AssemblyInfrastructureConnector);
            if (this.requiringAssemblyContext__AssemblyInfrastructureConnector != oldRequiringAssemblyContext__AssemblyInfrastructureConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                            oldRequiringAssemblyContext__AssemblyInfrastructureConnector,
                            this.requiringAssemblyContext__AssemblyInfrastructureConnector));
                }
            }
        }
        return this.requiringAssemblyContext__AssemblyInfrastructureConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AssemblyContext basicGetRequiringAssemblyContext__AssemblyInfrastructureConnector() {
        return this.requiringAssemblyContext__AssemblyInfrastructureConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRequiringAssemblyContext__AssemblyInfrastructureConnector(
            final AssemblyContext newRequiringAssemblyContext__AssemblyInfrastructureConnector) {
        final AssemblyContext oldRequiringAssemblyContext__AssemblyInfrastructureConnector = this.requiringAssemblyContext__AssemblyInfrastructureConnector;
        this.requiringAssemblyContext__AssemblyInfrastructureConnector = newRequiringAssemblyContext__AssemblyInfrastructureConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(
                    this,
                    Notification.SET,
                    CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR,
                    oldRequiringAssemblyContext__AssemblyInfrastructureConnector,
                    this.requiringAssemblyContext__AssemblyInfrastructureConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            if (resolve) {
                return this.getProvidedRole__AssemblyInfrastructureConnector();
            }
            return this.basicGetProvidedRole__AssemblyInfrastructureConnector();
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            if (resolve) {
                return this.getRequiredRole__AssemblyInfrastructureConnector();
            }
            return this.basicGetRequiredRole__AssemblyInfrastructureConnector();
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            if (resolve) {
                return this.getProvidingAssemblyContext__AssemblyInfrastructureConnector();
            }
            return this.basicGetProvidingAssemblyContext__AssemblyInfrastructureConnector();
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            if (resolve) {
                return this.getRequiringAssemblyContext__AssemblyInfrastructureConnector();
            }
            return this.basicGetRequiringAssemblyContext__AssemblyInfrastructureConnector();
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
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            this.setProvidedRole__AssemblyInfrastructureConnector((InfrastructureProvidedRole) newValue);
            return;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            this.setRequiredRole__AssemblyInfrastructureConnector((InfrastructureRequiredRole) newValue);
            return;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            this.setProvidingAssemblyContext__AssemblyInfrastructureConnector((AssemblyContext) newValue);
            return;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            this.setRequiringAssemblyContext__AssemblyInfrastructureConnector((AssemblyContext) newValue);
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
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            this.setProvidedRole__AssemblyInfrastructureConnector((InfrastructureProvidedRole) null);
            return;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            this.setRequiredRole__AssemblyInfrastructureConnector((InfrastructureRequiredRole) null);
            return;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            this.setProvidingAssemblyContext__AssemblyInfrastructureConnector((AssemblyContext) null);
            return;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            this.setRequiringAssemblyContext__AssemblyInfrastructureConnector((AssemblyContext) null);
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
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            return this.providedRole__AssemblyInfrastructureConnector != null;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRED_ROLE_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            return this.requiredRole__AssemblyInfrastructureConnector != null;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__PROVIDING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            return this.providingAssemblyContext__AssemblyInfrastructureConnector != null;
        case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR__REQUIRING_ASSEMBLY_CONTEXT_ASSEMBLY_INFRASTRUCTURE_CONNECTOR:
            return this.requiringAssemblyContext__AssemblyInfrastructureConnector != null;
        }
        return super.eIsSet(featureID);
    }

} // AssemblyInfrastructureConnectorImpl
