/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.entity.impl.NamedElementImpl;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Inner Declaration</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InnerDeclarationImpl#getDatatype_InnerDeclaration
 * <em>Datatype Inner Declaration</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.impl.InnerDeclarationImpl#getCompositeDataType_InnerDeclaration
 * <em>Composite Data Type Inner Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InnerDeclarationImpl extends NamedElementImpl implements InnerDeclaration {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getDatatype_InnerDeclaration()
     * <em>Datatype Inner Declaration</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getDatatype_InnerDeclaration()
     * @generated
     * @ordered
     */
    protected DataType datatype_InnerDeclaration;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected InnerDeclarationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.INNER_DECLARATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DataType getDatatype_InnerDeclaration() {
        if (this.datatype_InnerDeclaration != null && ((EObject) this.datatype_InnerDeclaration).eIsProxy()) {
            final InternalEObject oldDatatype_InnerDeclaration = (InternalEObject) this.datatype_InnerDeclaration;
            this.datatype_InnerDeclaration = (DataType) this.eResolveProxy(oldDatatype_InnerDeclaration);
            if (this.datatype_InnerDeclaration != oldDatatype_InnerDeclaration) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION,
                            oldDatatype_InnerDeclaration, this.datatype_InnerDeclaration));
                }
            }
        }
        return this.datatype_InnerDeclaration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public DataType basicGetDatatype_InnerDeclaration() {
        return this.datatype_InnerDeclaration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDatatype_InnerDeclaration(final DataType newDatatype_InnerDeclaration) {
        final DataType oldDatatype_InnerDeclaration = this.datatype_InnerDeclaration;
        this.datatype_InnerDeclaration = newDatatype_InnerDeclaration;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION, oldDatatype_InnerDeclaration,
                    this.datatype_InnerDeclaration));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public CompositeDataType getCompositeDataType_InnerDeclaration() {
        if (this.eContainerFeatureID() != RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION) {
            return null;
        }
        return (CompositeDataType) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetCompositeDataType_InnerDeclaration(
            final CompositeDataType newCompositeDataType_InnerDeclaration, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newCompositeDataType_InnerDeclaration,
                RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setCompositeDataType_InnerDeclaration(final CompositeDataType newCompositeDataType_InnerDeclaration) {
        if (newCompositeDataType_InnerDeclaration != this.eInternalContainer()
                || (this.eContainerFeatureID() != RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION && newCompositeDataType_InnerDeclaration != null)) {
            if (EcoreUtil.isAncestor(this, newCompositeDataType_InnerDeclaration)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newCompositeDataType_InnerDeclaration != null) {
                msgs = ((InternalEObject) newCompositeDataType_InnerDeclaration).eInverseAdd(this,
                        RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE,
                        CompositeDataType.class, msgs);
            }
            msgs = this.basicSetCompositeDataType_InnerDeclaration(newCompositeDataType_InnerDeclaration, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION,
                    newCompositeDataType_InnerDeclaration, newCompositeDataType_InnerDeclaration));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetCompositeDataType_InnerDeclaration((CompositeDataType) otherEnd, msgs);
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
        case RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION:
            return this.basicSetCompositeDataType_InnerDeclaration(null, msgs);
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
        case RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION:
            return this.eInternalContainer().eInverseRemove(this,
                    RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE,
                    CompositeDataType.class, msgs);
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
        case RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION:
            if (resolve) {
                return this.getDatatype_InnerDeclaration();
            }
            return this.basicGetDatatype_InnerDeclaration();
        case RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION:
            return this.getCompositeDataType_InnerDeclaration();
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
        case RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION:
            this.setDatatype_InnerDeclaration((DataType) newValue);
            return;
        case RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION:
            this.setCompositeDataType_InnerDeclaration((CompositeDataType) newValue);
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
        case RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION:
            this.setDatatype_InnerDeclaration((DataType) null);
            return;
        case RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION:
            this.setCompositeDataType_InnerDeclaration((CompositeDataType) null);
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
        case RepositoryPackage.INNER_DECLARATION__DATATYPE_INNER_DECLARATION:
            return this.datatype_InnerDeclaration != null;
        case RepositoryPackage.INNER_DECLARATION__COMPOSITE_DATA_TYPE_INNER_DECLARATION:
            return this.getCompositeDataType_InnerDeclaration() != null;
        }
        return super.eIsSet(featureID);
    }

} // InnerDeclarationImpl
