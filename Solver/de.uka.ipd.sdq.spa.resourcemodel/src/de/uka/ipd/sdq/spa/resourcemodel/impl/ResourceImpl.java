/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.spa.resourcemodel.Resource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Resource</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceImpl#getName <em>Name</em>}</li>
 * <li>{@link de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceImpl#getNumberOfServers <em>Number Of
 * Servers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ResourceImpl extends EObjectImpl implements Resource {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = "";

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getNumberOfServers() <em>Number Of Servers</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getNumberOfServers()
     * @generated
     * @ordered
     */
    protected static final int NUMBER_OF_SERVERS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getNumberOfServers() <em>Number Of Servers</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getNumberOfServers()
     * @generated
     * @ordered
     */
    protected int numberOfServers = NUMBER_OF_SERVERS_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ResourceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EClass eStaticClass() {
        return ResourceModelPackage.Literals.RESOURCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ResourceModelPackage.RESOURCE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getNumberOfServers() {
        return numberOfServers;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setNumberOfServers(int newNumberOfServers) {
        int oldNumberOfServers = numberOfServers;
        numberOfServers = newNumberOfServers;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ResourceModelPackage.RESOURCE__NUMBER_OF_SERVERS,
                    oldNumberOfServers, numberOfServers));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ResourceModelPackage.RESOURCE__NAME:
            return getName();
        case ResourceModelPackage.RESOURCE__NUMBER_OF_SERVERS:
            return new Integer(getNumberOfServers());
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case ResourceModelPackage.RESOURCE__NAME:
            setName((String) newValue);
            return;
        case ResourceModelPackage.RESOURCE__NUMBER_OF_SERVERS:
            setNumberOfServers(((Integer) newValue).intValue());
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eUnset(int featureID) {
        switch (featureID) {
        case ResourceModelPackage.RESOURCE__NAME:
            setName(NAME_EDEFAULT);
            return;
        case ResourceModelPackage.RESOURCE__NUMBER_OF_SERVERS:
            setNumberOfServers(NUMBER_OF_SERVERS_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case ResourceModelPackage.RESOURCE__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        case ResourceModelPackage.RESOURCE__NUMBER_OF_SERVERS:
            return numberOfServers != NUMBER_OF_SERVERS_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String toString() {
        if (eIsProxy())
            return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (name: ");
        result.append(name);
        result.append(", numberOfServers: ");
        result.append(numberOfServers);
        result.append(')');
        return result.toString();
    }

} // ResourceImpl
