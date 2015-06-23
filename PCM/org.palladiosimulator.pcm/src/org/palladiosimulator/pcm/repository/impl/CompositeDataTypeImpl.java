/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;

import org.palladiosimulator.pcm.repository.CompositeDataType;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.InnerDeclaration;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.CompositeDataTypeImpl#getRepository__DataType <em>Repository Data Type</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.CompositeDataTypeImpl#getParentType_CompositeDataType <em>Parent Type Composite Data Type</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.CompositeDataTypeImpl#getInnerDeclaration_CompositeDataType <em>Inner Declaration Composite Data Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositeDataTypeImpl extends EntityImpl implements CompositeDataType {

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
    protected CompositeDataTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.COMPOSITE_DATA_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Repository getRepository__DataType() {
        return (Repository) eDynamicGet(RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE,
                RepositoryPackage.Literals.DATA_TYPE__REPOSITORY_DATA_TYPE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRepository__DataType(Repository newRepository__DataType, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newRepository__DataType,
                RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRepository__DataType(Repository newRepository__DataType) {
        eDynamicSet(RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE,
                RepositoryPackage.Literals.DATA_TYPE__REPOSITORY_DATA_TYPE, newRepository__DataType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<CompositeDataType> getParentType_CompositeDataType() {
        return (EList<CompositeDataType>) eDynamicGet(
                RepositoryPackage.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE,
                RepositoryPackage.Literals.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<InnerDeclaration> getInnerDeclaration_CompositeDataType() {
        return (EList<InnerDeclaration>) eDynamicGet(
                RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE,
                RepositoryPackage.Literals.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetRepository__DataType((Repository) otherEnd, msgs);
        case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getInnerDeclaration_CompositeDataType())
                    .basicAdd(otherEnd, msgs);
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
        case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
            return basicSetRepository__DataType(null, msgs);
        case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
            return ((InternalEList<?>) getInnerDeclaration_CompositeDataType()).basicRemove(otherEnd, msgs);
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
        case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
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
        case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
            return getRepository__DataType();
        case RepositoryPackage.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE:
            return getParentType_CompositeDataType();
        case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
            return getInnerDeclaration_CompositeDataType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
            setRepository__DataType((Repository) newValue);
            return;
        case RepositoryPackage.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE:
            getParentType_CompositeDataType().clear();
            getParentType_CompositeDataType().addAll((Collection<? extends CompositeDataType>) newValue);
            return;
        case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
            getInnerDeclaration_CompositeDataType().clear();
            getInnerDeclaration_CompositeDataType().addAll((Collection<? extends InnerDeclaration>) newValue);
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
        case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
            setRepository__DataType((Repository) null);
            return;
        case RepositoryPackage.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE:
            getParentType_CompositeDataType().clear();
            return;
        case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
            getInnerDeclaration_CompositeDataType().clear();
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
        case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
            return getRepository__DataType() != null;
        case RepositoryPackage.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE:
            return !getParentType_CompositeDataType().isEmpty();
        case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
            return !getInnerDeclaration_CompositeDataType().isEmpty();
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
            case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
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
                return RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} //CompositeDataTypeImpl
