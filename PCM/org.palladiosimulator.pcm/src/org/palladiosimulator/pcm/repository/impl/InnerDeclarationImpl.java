/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.core.entity.impl.NamedElementImpl;

import org.palladiosimulator.pcm.repository.CompositeDataType;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.InnerDeclaration;
import org.palladiosimulator.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inner Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.InnerDeclarationImpl#getDatatype_InnerDeclaration <em>Datatype Inner Declaration</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.InnerDeclarationImpl#getCompositeDataType_InnerDeclaration <em>Composite Data Type Inner Declaration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InnerDeclarationImpl extends NamedElementImpl implements InnerDeclaration {

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
    protected InnerDeclarationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.INNER_DECLARATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataType getDatatype_InnerDeclaration() {
        return (DataType) eDynamicGet(RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION,
                RepositoryPackage.Literals.INNER_DECLARATION__DATATYPE_INNER_DECLARATION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataType basicGetDatatype_InnerDeclaration() {
        return (DataType) eDynamicGet(RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION,
                RepositoryPackage.Literals.INNER_DECLARATION__DATATYPE_INNER_DECLARATION, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDatatype_InnerDeclaration(DataType newDatatype_InnerDeclaration) {
        eDynamicSet(RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION,
                RepositoryPackage.Literals.INNER_DECLARATION__DATATYPE_INNER_DECLARATION, newDatatype_InnerDeclaration);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompositeDataType getCompositeDataType_InnerDeclaration() {
        return (CompositeDataType) eDynamicGet(
                RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION,
                RepositoryPackage.Literals.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCompositeDataType_InnerDeclaration(
            CompositeDataType newCompositeDataType_InnerDeclaration, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newCompositeDataType_InnerDeclaration,
                RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCompositeDataType_InnerDeclaration(CompositeDataType newCompositeDataType_InnerDeclaration) {
        eDynamicSet(RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION,
                RepositoryPackage.Literals.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION,
                newCompositeDataType_InnerDeclaration);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetCompositeDataType_InnerDeclaration((CompositeDataType) otherEnd, msgs);
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
        case RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION:
            return basicSetCompositeDataType_InnerDeclaration(null, msgs);
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
        case RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION:
            return eInternalContainer().eInverseRemove(this,
                    RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE,
                    CompositeDataType.class, msgs);
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
        case RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION:
            if (resolve)
                return getDatatype_InnerDeclaration();
            return basicGetDatatype_InnerDeclaration();
        case RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION:
            return getCompositeDataType_InnerDeclaration();
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
        case RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION:
            setDatatype_InnerDeclaration((DataType) newValue);
            return;
        case RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION:
            setCompositeDataType_InnerDeclaration((CompositeDataType) newValue);
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
        case RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION:
            setDatatype_InnerDeclaration((DataType) null);
            return;
        case RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION:
            setCompositeDataType_InnerDeclaration((CompositeDataType) null);
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
        case RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION:
            return basicGetDatatype_InnerDeclaration() != null;
        case RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION:
            return getCompositeDataType_InnerDeclaration() != null;
        }
        return super.eIsSet(featureID);
    }

} //InnerDeclarationImpl
