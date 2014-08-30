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

import de.uka.ipd.sdq.spa.resourcemodel.ContentionResource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Contention Resource</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.spa.resourcemodel.impl.ContentionResourceImpl#getNumReplicas <em>Num
 * Replicas</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ContentionResourceImpl extends ResourceImpl implements ContentionResource {
    /**
     * The default value of the '{@link #getNumReplicas() <em>Num Replicas</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getNumReplicas()
     * @generated
     * @ordered
     */
    protected static final int NUM_REPLICAS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getNumReplicas() <em>Num Replicas</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getNumReplicas()
     * @generated
     * @ordered
     */
    protected int numReplicas = NUM_REPLICAS_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ContentionResourceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EClass eStaticClass() {
        return ResourceModelPackage.Literals.CONTENTION_RESOURCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getNumReplicas() {
        return numReplicas;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setNumReplicas(int newNumReplicas) {
        int oldNumReplicas = numReplicas;
        numReplicas = newNumReplicas;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceModelPackage.CONTENTION_RESOURCE__NUM_REPLICAS, oldNumReplicas, numReplicas));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ResourceModelPackage.CONTENTION_RESOURCE__NUM_REPLICAS:
            return new Integer(getNumReplicas());
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
        case ResourceModelPackage.CONTENTION_RESOURCE__NUM_REPLICAS:
            setNumReplicas(((Integer) newValue).intValue());
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
        case ResourceModelPackage.CONTENTION_RESOURCE__NUM_REPLICAS:
            setNumReplicas(NUM_REPLICAS_EDEFAULT);
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
        case ResourceModelPackage.CONTENTION_RESOURCE__NUM_REPLICAS:
            return numReplicas != NUM_REPLICAS_EDEFAULT;
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
        result.append(" (numReplicas: ");
        result.append(numReplicas);
        result.append(')');
        return result.toString();
    }

} // ContentionResourceImpl
