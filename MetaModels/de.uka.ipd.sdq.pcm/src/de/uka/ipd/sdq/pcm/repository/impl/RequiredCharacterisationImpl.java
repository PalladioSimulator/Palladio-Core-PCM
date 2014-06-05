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
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RequiredCharacterisationImpl#getType <em>Type</em>}
 * </li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.RequiredCharacterisationImpl#getParameter <em>
 * Parameter</em>}</li>
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
    public VariableCharacterisationType getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setType(VariableCharacterisationType newType) {
        VariableCharacterisationType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.REQUIRED_CHARACTERISATION__TYPE,
                    oldType, type));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Parameter getParameter() {
        if (parameter != null && ((EObject) parameter).eIsProxy()) {
            InternalEObject oldParameter = (InternalEObject) parameter;
            parameter = (Parameter) eResolveProxy(oldParameter);
            if (parameter != oldParameter) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            RepositoryPackage.REQUIRED_CHARACTERISATION__PARAMETER, oldParameter, parameter));
            }
        }
        return parameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Parameter basicGetParameter() {
        return parameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setParameter(Parameter newParameter) {
        Parameter oldParameter = parameter;
        parameter = newParameter;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.REQUIRED_CHARACTERISATION__PARAMETER, oldParameter, parameter));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Interface getInterface_RequiredCharacterisation() {
        if (eContainerFeatureID() != RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION)
            return null;
        return (Interface) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetInterface_RequiredCharacterisation(
            Interface newInterface_RequiredCharacterisation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newInterface_RequiredCharacterisation,
                RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setInterface_RequiredCharacterisation(Interface newInterface_RequiredCharacterisation) {
        if (newInterface_RequiredCharacterisation != eInternalContainer()
                || (eContainerFeatureID() != RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION && newInterface_RequiredCharacterisation != null)) {
            if (EcoreUtil.isAncestor(this, (EObject) newInterface_RequiredCharacterisation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInterface_RequiredCharacterisation != null)
                msgs = ((InternalEObject) newInterface_RequiredCharacterisation).eInverseAdd(this,
                        RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS, Interface.class, msgs);
            msgs = basicSetInterface_RequiredCharacterisation(newInterface_RequiredCharacterisation, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION,
                    newInterface_RequiredCharacterisation, newInterface_RequiredCharacterisation));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetInterface_RequiredCharacterisation((Interface) otherEnd, msgs);
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
        case RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION:
            return basicSetInterface_RequiredCharacterisation(null, msgs);
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
        case RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION:
            return eInternalContainer().eInverseRemove(this, RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS,
                    Interface.class, msgs);
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
        case RepositoryPackage.REQUIRED_CHARACTERISATION__TYPE:
            return getType();
        case RepositoryPackage.REQUIRED_CHARACTERISATION__PARAMETER:
            if (resolve)
                return getParameter();
            return basicGetParameter();
        case RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION:
            return getInterface_RequiredCharacterisation();
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
        case RepositoryPackage.REQUIRED_CHARACTERISATION__TYPE:
            setType((VariableCharacterisationType) newValue);
            return;
        case RepositoryPackage.REQUIRED_CHARACTERISATION__PARAMETER:
            setParameter((Parameter) newValue);
            return;
        case RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION:
            setInterface_RequiredCharacterisation((Interface) newValue);
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
        case RepositoryPackage.REQUIRED_CHARACTERISATION__TYPE:
            setType(TYPE_EDEFAULT);
            return;
        case RepositoryPackage.REQUIRED_CHARACTERISATION__PARAMETER:
            setParameter((Parameter) null);
            return;
        case RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION:
            setInterface_RequiredCharacterisation((Interface) null);
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
        case RepositoryPackage.REQUIRED_CHARACTERISATION__TYPE:
            return type != TYPE_EDEFAULT;
        case RepositoryPackage.REQUIRED_CHARACTERISATION__PARAMETER:
            return parameter != null;
        case RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION:
            return getInterface_RequiredCharacterisation() != null;
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
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (type: ");
        result.append(type);
        result.append(')');
        return result.toString();
    }

} // RequiredCharacterisationImpl
