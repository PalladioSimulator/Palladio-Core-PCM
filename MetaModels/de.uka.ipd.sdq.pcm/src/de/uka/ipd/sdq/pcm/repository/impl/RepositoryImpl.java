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
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.reliability.FailureType;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Repository</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl#getRepositoryDescription <em>
 * Repository Description</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl#getComponents__Repository <em>
 * Components Repository</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl#getInterfaces__Repository <em>
 * Interfaces Repository</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl#getFailureTypes__Repository <em>
 * Failure Types Repository</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RepositoryImpl#getDataTypes__Repository <em>Data
 * Types Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RepositoryImpl extends EntityImpl implements Repository {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getRepositoryDescription() <em>Repository Description</em>}
     * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRepositoryDescription()
     * @generated
     * @ordered
     */
    protected static final String REPOSITORY_DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRepositoryDescription() <em>Repository Description</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRepositoryDescription()
     * @generated
     * @ordered
     */
    protected String repositoryDescription = REPOSITORY_DESCRIPTION_EDEFAULT;

    /**
     * The cached value of the '{@link #getComponents__Repository() <em>Components Repository</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getComponents__Repository()
     * @generated
     * @ordered
     */
    protected EList<RepositoryComponent> components__Repository;

    /**
     * The cached value of the '{@link #getInterfaces__Repository() <em>Interfaces Repository</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getInterfaces__Repository()
     * @generated
     * @ordered
     */
    protected EList<Interface> interfaces__Repository;

    /**
     * The cached value of the '{@link #getFailureTypes__Repository()
     * <em>Failure Types Repository</em>}' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getFailureTypes__Repository()
     * @generated
     * @ordered
     */
    protected EList<FailureType> failureTypes__Repository;

    /**
     * The cached value of the '{@link #getDataTypes__Repository() <em>Data Types Repository</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getDataTypes__Repository()
     * @generated
     * @ordered
     */
    protected EList<DataType> dataTypes__Repository;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected RepositoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.REPOSITORY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getRepositoryDescription() {
        return this.repositoryDescription;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRepositoryDescription(final String newRepositoryDescription) {
        final String oldRepositoryDescription = this.repositoryDescription;
        this.repositoryDescription = newRepositoryDescription;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION, oldRepositoryDescription,
                    this.repositoryDescription));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<RepositoryComponent> getComponents__Repository() {
        if (this.components__Repository == null) {
            this.components__Repository = new EObjectContainmentWithInverseEList<RepositoryComponent>(
                    RepositoryComponent.class, this, RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY,
                    RepositoryPackage.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT);
        }
        return this.components__Repository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<FailureType> getFailureTypes__Repository() {
        if (this.failureTypes__Repository == null) {
            this.failureTypes__Repository = new EObjectContainmentWithInverseEList<FailureType>(FailureType.class,
                    this, RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY,
                    ReliabilityPackage.FAILURE_TYPE__REPOSITORY_FAILURE_TYPE);
        }
        return this.failureTypes__Repository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<DataType> getDataTypes__Repository() {
        if (this.dataTypes__Repository == null) {
            this.dataTypes__Repository = new EObjectContainmentWithInverseEList<DataType>(DataType.class, this,
                    RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY,
                    RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE);
        }
        return this.dataTypes__Repository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<Interface> getInterfaces__Repository() {
        if (this.interfaces__Repository == null) {
            this.interfaces__Repository = new EObjectContainmentWithInverseEList<Interface>(Interface.class, this,
                    RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY,
                    RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE);
        }
        return this.interfaces__Repository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getComponents__Repository()).basicAdd(
                    otherEnd, msgs);
        case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getInterfaces__Repository()).basicAdd(
                    otherEnd, msgs);
        case RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getFailureTypes__Repository()).basicAdd(
                    otherEnd, msgs);
        case RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getDataTypes__Repository()).basicAdd(
                    otherEnd, msgs);
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
        case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
            return ((InternalEList<?>) this.getComponents__Repository()).basicRemove(otherEnd, msgs);
        case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
            return ((InternalEList<?>) this.getInterfaces__Repository()).basicRemove(otherEnd, msgs);
        case RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY:
            return ((InternalEList<?>) this.getFailureTypes__Repository()).basicRemove(otherEnd, msgs);
        case RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY:
            return ((InternalEList<?>) this.getDataTypes__Repository()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
            return this.getRepositoryDescription();
        case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
            return this.getComponents__Repository();
        case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
            return this.getInterfaces__Repository();
        case RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY:
            return this.getFailureTypes__Repository();
        case RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY:
            return this.getDataTypes__Repository();
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
        case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
            this.setRepositoryDescription((String) newValue);
            return;
        case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
            this.getComponents__Repository().clear();
            this.getComponents__Repository().addAll((Collection<? extends RepositoryComponent>) newValue);
            return;
        case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
            this.getInterfaces__Repository().clear();
            this.getInterfaces__Repository().addAll((Collection<? extends Interface>) newValue);
            return;
        case RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY:
            this.getFailureTypes__Repository().clear();
            this.getFailureTypes__Repository().addAll((Collection<? extends FailureType>) newValue);
            return;
        case RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY:
            this.getDataTypes__Repository().clear();
            this.getDataTypes__Repository().addAll((Collection<? extends DataType>) newValue);
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
        case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
            this.setRepositoryDescription(REPOSITORY_DESCRIPTION_EDEFAULT);
            return;
        case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
            this.getComponents__Repository().clear();
            return;
        case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
            this.getInterfaces__Repository().clear();
            return;
        case RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY:
            this.getFailureTypes__Repository().clear();
            return;
        case RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY:
            this.getDataTypes__Repository().clear();
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
        case RepositoryPackage.REPOSITORY__REPOSITORY_DESCRIPTION:
            return REPOSITORY_DESCRIPTION_EDEFAULT == null ? this.repositoryDescription != null
            : !REPOSITORY_DESCRIPTION_EDEFAULT.equals(this.repositoryDescription);
        case RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY:
            return this.components__Repository != null && !this.components__Repository.isEmpty();
        case RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY:
            return this.interfaces__Repository != null && !this.interfaces__Repository.isEmpty();
        case RepositoryPackage.REPOSITORY__FAILURE_TYPES_REPOSITORY:
            return this.failureTypes__Repository != null && !this.failureTypes__Repository.isEmpty();
        case RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY:
            return this.dataTypes__Repository != null && !this.dataTypes__Repository.isEmpty();
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
        result.append(" (repositoryDescription: ");
        result.append(this.repositoryDescription);
        result.append(')');
        return result.toString();
    }

} // RepositoryImpl
