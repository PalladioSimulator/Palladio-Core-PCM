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

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation;
import edu.kit.ipd.sdq.mdsd.profiles.metamodelextension.impl.EStereotypableObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Required Characterisation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.impl.RequiredCharacterisationImpl#getType <em>Type</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.impl.RequiredCharacterisationImpl#getParameter <em>Parameter
 * </em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.impl.RequiredCharacterisationImpl#getInterface_RequiredCharacterisation
 * <em>Interface Required Characterisation</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RequiredCharacterisationImpl extends EStereotypableObjectImpl implements RequiredCharacterisation {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final VariableCharacterisationType TYPE_EDEFAULT = VariableCharacterisationType.STRUCTURE;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected VariableCharacterisationType type = TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getParameter()
     * @generated
     * @ordered
     */
    protected Parameter parameter;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected RequiredCharacterisationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.REQUIRED_CHARACTERISATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public VariableCharacterisationType getType() {
        return this.type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setType(final VariableCharacterisationType newType) {
        final VariableCharacterisationType oldType = this.type;
        this.type = newType == null ? TYPE_EDEFAULT : newType;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.REQUIRED_CHARACTERISATION__TYPE, oldType, this.type));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Parameter getParameter() {
        if (this.parameter != null && ((EObject) this.parameter).eIsProxy()) {
            final InternalEObject oldParameter = (InternalEObject) this.parameter;
            this.parameter = (Parameter) this.eResolveProxy(oldParameter);
            if (this.parameter != oldParameter) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            RepositoryPackage.REQUIRED_CHARACTERISATION__PARAMETER, oldParameter, this.parameter));
                }
            }
        }
        return this.parameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Parameter basicGetParameter() {
        return this.parameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParameter(final Parameter newParameter) {
        final Parameter oldParameter = this.parameter;
        this.parameter = newParameter;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.REQUIRED_CHARACTERISATION__PARAMETER, oldParameter, this.parameter));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Interface getInterface_RequiredCharacterisation() {
        if (this.eContainerFeatureID() != RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION) {
            return null;
        }
        return (Interface) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetInterface_RequiredCharacterisation(
            final Interface newInterface_RequiredCharacterisation, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newInterface_RequiredCharacterisation,
                RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setInterface_RequiredCharacterisation(final Interface newInterface_RequiredCharacterisation) {
        if (newInterface_RequiredCharacterisation != this.eInternalContainer()
                || (this.eContainerFeatureID() != RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION && newInterface_RequiredCharacterisation != null)) {
            if (EcoreUtil.isAncestor(this, newInterface_RequiredCharacterisation)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newInterface_RequiredCharacterisation != null) {
                msgs = ((InternalEObject) newInterface_RequiredCharacterisation).eInverseAdd(this,
                        RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS, Interface.class, msgs);
            }
            msgs = this.basicSetInterface_RequiredCharacterisation(newInterface_RequiredCharacterisation, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION,
                    newInterface_RequiredCharacterisation, newInterface_RequiredCharacterisation));
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
        case RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetInterface_RequiredCharacterisation((Interface) otherEnd, msgs);
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
        case RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION:
            return this.basicSetInterface_RequiredCharacterisation(null, msgs);
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
        case RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION:
            return this.eInternalContainer().eInverseRemove(this,
                    RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS, Interface.class, msgs);
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
        case RepositoryPackage.REQUIRED_CHARACTERISATION__TYPE:
            return this.getType();
        case RepositoryPackage.REQUIRED_CHARACTERISATION__PARAMETER:
            if (resolve) {
                return this.getParameter();
            }
            return this.basicGetParameter();
        case RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION:
            return this.getInterface_RequiredCharacterisation();
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
        case RepositoryPackage.REQUIRED_CHARACTERISATION__TYPE:
            this.setType((VariableCharacterisationType) newValue);
            return;
        case RepositoryPackage.REQUIRED_CHARACTERISATION__PARAMETER:
            this.setParameter((Parameter) newValue);
            return;
        case RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION:
            this.setInterface_RequiredCharacterisation((Interface) newValue);
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
        case RepositoryPackage.REQUIRED_CHARACTERISATION__TYPE:
            this.setType(TYPE_EDEFAULT);
            return;
        case RepositoryPackage.REQUIRED_CHARACTERISATION__PARAMETER:
            this.setParameter((Parameter) null);
            return;
        case RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION:
            this.setInterface_RequiredCharacterisation((Interface) null);
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
        case RepositoryPackage.REQUIRED_CHARACTERISATION__TYPE:
            return this.type != TYPE_EDEFAULT;
        case RepositoryPackage.REQUIRED_CHARACTERISATION__PARAMETER:
            return this.parameter != null;
        case RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION:
            return this.getInterface_RequiredCharacterisation() != null;
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
        result.append(" (type: ");
        result.append(this.type);
        result.append(')');
        return result.toString();
    }

} // RequiredCharacterisationImpl
