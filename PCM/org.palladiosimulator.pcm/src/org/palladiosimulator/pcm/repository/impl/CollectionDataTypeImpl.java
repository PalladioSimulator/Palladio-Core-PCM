/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;

import org.palladiosimulator.pcm.repository.CollectionDataType;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.CollectionDataTypeImpl#getRepository__DataType <em>Repository Data Type</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.CollectionDataTypeImpl#getInnerType_CollectionDataType <em>Inner Type Collection Data Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionDataTypeImpl extends EntityImpl implements CollectionDataType {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CollectionDataTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.COLLECTION_DATA_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Repository getRepository__DataType() {
        return (Repository) eDynamicGet(RepositoryPackage.COLLECTION_DATA_TYPE__REPOSITORY_DATA_TYPE,
                RepositoryPackage.Literals.DATA_TYPE__REPOSITORY_DATA_TYPE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRepository__DataType(Repository newRepository__DataType, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newRepository__DataType,
                RepositoryPackage.COLLECTION_DATA_TYPE__REPOSITORY_DATA_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRepository__DataType(Repository newRepository__DataType) {
        eDynamicSet(RepositoryPackage.COLLECTION_DATA_TYPE__REPOSITORY_DATA_TYPE,
                RepositoryPackage.Literals.DATA_TYPE__REPOSITORY_DATA_TYPE, newRepository__DataType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataType getInnerType_CollectionDataType() {
        return (DataType) eDynamicGet(RepositoryPackage.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE,
                RepositoryPackage.Literals.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataType basicGetInnerType_CollectionDataType() {
        return (DataType) eDynamicGet(RepositoryPackage.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE,
                RepositoryPackage.Literals.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInnerType_CollectionDataType(DataType newInnerType_CollectionDataType) {
        eDynamicSet(RepositoryPackage.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE,
                RepositoryPackage.Literals.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE,
                newInnerType_CollectionDataType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.COLLECTION_DATA_TYPE__REPOSITORY_DATA_TYPE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetRepository__DataType((Repository) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.COLLECTION_DATA_TYPE__REPOSITORY_DATA_TYPE:
            return basicSetRepository__DataType(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case RepositoryPackage.COLLECTION_DATA_TYPE__REPOSITORY_DATA_TYPE:
            return eInternalContainer().eInverseRemove(this, RepositoryPackage.REPOSITORY__DATA_TYPES_REPOSITORY,
                    Repository.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case RepositoryPackage.COLLECTION_DATA_TYPE__REPOSITORY_DATA_TYPE:
            return getRepository__DataType();
        case RepositoryPackage.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE:
            if (resolve)
                return getInnerType_CollectionDataType();
            return basicGetInnerType_CollectionDataType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case RepositoryPackage.COLLECTION_DATA_TYPE__REPOSITORY_DATA_TYPE:
            setRepository__DataType((Repository) newValue);
            return;
        case RepositoryPackage.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE:
            setInnerType_CollectionDataType((DataType) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case RepositoryPackage.COLLECTION_DATA_TYPE__REPOSITORY_DATA_TYPE:
            setRepository__DataType((Repository) null);
            return;
        case RepositoryPackage.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE:
            setInnerType_CollectionDataType((DataType) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case RepositoryPackage.COLLECTION_DATA_TYPE__REPOSITORY_DATA_TYPE:
            return getRepository__DataType() != null;
        case RepositoryPackage.COLLECTION_DATA_TYPE__INNER_TYPE_COLLECTION_DATA_TYPE:
            return basicGetInnerType_CollectionDataType() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == DataType.class) {
            switch (derivedFeatureID) {
            case RepositoryPackage.COLLECTION_DATA_TYPE__REPOSITORY_DATA_TYPE:
                return RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE;
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == DataType.class) {
            switch (baseFeatureID) {
            case RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE:
                return RepositoryPackage.COLLECTION_DATA_TYPE__REPOSITORY_DATA_TYPE;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //CollectionDataTypeImpl
