/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.subsystem.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.subsystem.SubSystem;
import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Sub System</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.subsystem.impl.SubSystemImpl#getRepository__RepositoryComponent
 * <em>Repository Repository Component</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SubSystemImpl extends ComposedProvidingRequiringEntityImpl implements SubSystem {
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
    protected SubSystemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SubsystemPackage.Literals.SUB_SYSTEM;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Repository getRepository__RepositoryComponent() {
        if (eContainerFeatureID() != SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT)
            return null;
        return (Repository) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetRepository__RepositoryComponent(Repository newRepository__RepositoryComponent,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newRepository__RepositoryComponent,
                SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRepository__RepositoryComponent(Repository newRepository__RepositoryComponent) {
        if (newRepository__RepositoryComponent != eInternalContainer()
                || (eContainerFeatureID() != SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT && newRepository__RepositoryComponent != null)) {
            if (EcoreUtil.isAncestor(this, (EObject) newRepository__RepositoryComponent))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newRepository__RepositoryComponent != null)
                msgs = ((InternalEObject) newRepository__RepositoryComponent).eInverseAdd(this,
                        RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY, Repository.class, msgs);
            msgs = basicSetRepository__RepositoryComponent(newRepository__RepositoryComponent, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT, newRepository__RepositoryComponent,
                    newRepository__RepositoryComponent));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetRepository__RepositoryComponent((Repository) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
            return basicSetRepository__RepositoryComponent(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
            return eInternalContainer().eInverseRemove(this, RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY,
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
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
            return getRepository__RepositoryComponent();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
            setRepository__RepositoryComponent((Repository) newValue);
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
    public void eUnset(int featureID) {
        switch (featureID) {
        case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
            setRepository__RepositoryComponent((Repository) null);
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
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
            return getRepository__RepositoryComponent() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == RepositoryComponent.class) {
            switch (derivedFeatureID) {
            case SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT:
                return RepositoryPackage.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT;
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == RepositoryComponent.class) {
            switch (baseFeatureID) {
            case RepositoryPackage.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT:
                return SubsystemPackage.SUB_SYSTEM__REPOSITORY_REPOSITORY_COMPONENT;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // SubSystemImpl
