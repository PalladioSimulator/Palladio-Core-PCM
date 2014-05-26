/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.palladiosimulator.edp2.models.measuringpoint.impl.MeasuringPointImpl;

import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Active Resource Measuring Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.ActiveResourceMeasuringPointImpl#getActiveResource <em>Active Resource</em>}</li>
 *   <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.ActiveResourceMeasuringPointImpl#getReplicaID <em>Replica ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActiveResourceMeasuringPointImpl extends MeasuringPointImpl implements ActiveResourceMeasuringPoint {
    /**
     * The cached value of the '{@link #getActiveResource() <em>Active Resource</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getActiveResource()
     * @generated
     * @ordered
     */
    protected ProcessingResourceSpecification activeResource;

    /**
     * The default value of the '{@link #getReplicaID() <em>Replica ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReplicaID()
     * @generated
     * @ordered
     */
    protected static final int REPLICA_ID_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getReplicaID() <em>Replica ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReplicaID()
     * @generated
     * @ordered
     */
    protected int replicaID = REPLICA_ID_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ActiveResourceMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.ACTIVE_RESOURCE_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProcessingResourceSpecification getActiveResource() {
        if (activeResource != null && activeResource.eIsProxy()) {
            InternalEObject oldActiveResource = (InternalEObject)activeResource;
            activeResource = (ProcessingResourceSpecification)eResolveProxy(oldActiveResource);
            if (activeResource != oldActiveResource) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE, oldActiveResource, activeResource));
            }
        }
        return activeResource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProcessingResourceSpecification basicGetActiveResource() {
        return activeResource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setActiveResource(ProcessingResourceSpecification newActiveResource) {
        ProcessingResourceSpecification oldActiveResource = activeResource;
        activeResource = newActiveResource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE, oldActiveResource, activeResource));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getReplicaID() {
        return replicaID;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReplicaID(int newReplicaID) {
        int oldReplicaID = replicaID;
        replicaID = newReplicaID;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID, oldReplicaID, replicaID));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE:
                if (resolve) return getActiveResource();
                return basicGetActiveResource();
            case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID:
                return getReplicaID();
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
            case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE:
                setActiveResource((ProcessingResourceSpecification)newValue);
                return;
            case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID:
                setReplicaID((Integer)newValue);
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
            case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE:
                setActiveResource((ProcessingResourceSpecification)null);
                return;
            case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID:
                setReplicaID(REPLICA_ID_EDEFAULT);
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
            case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE:
                return activeResource != null;
            case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID:
                return replicaID != REPLICA_ID_EDEFAULT;
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
        if (baseClass == ActiveResourceReference.class) {
            switch (derivedFeatureID) {
                case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE: return PcmmeasuringpointPackage.ACTIVE_RESOURCE_REFERENCE__ACTIVE_RESOURCE;
                case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID: return PcmmeasuringpointPackage.ACTIVE_RESOURCE_REFERENCE__REPLICA_ID;
                default: return -1;
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
        if (baseClass == ActiveResourceReference.class) {
            switch (baseFeatureID) {
                case PcmmeasuringpointPackage.ACTIVE_RESOURCE_REFERENCE__ACTIVE_RESOURCE: return PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__ACTIVE_RESOURCE;
                case PcmmeasuringpointPackage.ACTIVE_RESOURCE_REFERENCE__REPLICA_ID: return PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT__REPLICA_ID;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (replicaID: ");
        result.append(replicaID);
        result.append(')');
        return result.toString();
    }

} //ActiveResourceMeasuringPointImpl
