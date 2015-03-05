/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPointRepository;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SystemReference;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>System Operation Measuring Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SystemOperationMeasuringPointImpl#getMeasuringPointRepository
 * <em>Measuring Point Repository</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SystemOperationMeasuringPointImpl#getSystem
 * <em>System</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemOperationMeasuringPointImpl extends OperationReferenceImpl implements SystemOperationMeasuringPoint {
    /**
     * The cached value of the '{@link #getSystem() <em>System</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getSystem()
     * @generated
     * @ordered
     */
    protected de.uka.ipd.sdq.pcm.system.System system;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected SystemOperationMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.SYSTEM_OPERATION_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public MeasuringPointRepository getMeasuringPointRepository() {
        if (this.eContainerFeatureID() != PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY) {
            return null;
        }
        return (MeasuringPointRepository) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetMeasuringPointRepository(
            final MeasuringPointRepository newMeasuringPointRepository, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newMeasuringPointRepository,
                PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setMeasuringPointRepository(final MeasuringPointRepository newMeasuringPointRepository) {
        if (newMeasuringPointRepository != this.eInternalContainer()
                || (this.eContainerFeatureID() != PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY && newMeasuringPointRepository != null)) {
            if (EcoreUtil.isAncestor(this, newMeasuringPointRepository)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newMeasuringPointRepository != null) {
                msgs = ((InternalEObject) newMeasuringPointRepository).eInverseAdd(this,
                        MeasuringpointPackage.MEASURING_POINT_REPOSITORY__MEASURING_POINTS,
                        MeasuringPointRepository.class, msgs);
            }
            msgs = this.basicSetMeasuringPointRepository(newMeasuringPointRepository, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY,
                    newMeasuringPointRepository, newMeasuringPointRepository));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public de.uka.ipd.sdq.pcm.system.System getSystem() {
        if (this.system != null && ((EObject) this.system).eIsProxy()) {
            final InternalEObject oldSystem = (InternalEObject) this.system;
            this.system = (de.uka.ipd.sdq.pcm.system.System) this.eResolveProxy(oldSystem);
            if (this.system != oldSystem) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM, oldSystem, this.system));
                }
            }
        }
        return this.system;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public de.uka.ipd.sdq.pcm.system.System basicGetSystem() {
        return this.system;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSystem(final de.uka.ipd.sdq.pcm.system.System newSystem) {
        final de.uka.ipd.sdq.pcm.system.System oldSystem = this.system;
        this.system = newSystem;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM, oldSystem, this.system));
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
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetMeasuringPointRepository((MeasuringPointRepository) otherEnd, msgs);
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
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
            return this.basicSetMeasuringPointRepository(null, msgs);
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
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
            return this.eInternalContainer().eInverseRemove(this,
                    MeasuringpointPackage.MEASURING_POINT_REPOSITORY__MEASURING_POINTS, MeasuringPointRepository.class,
                    msgs);
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
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
            return this.getMeasuringPointRepository();
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM:
            if (resolve) {
                return this.getSystem();
            }
            return this.basicGetSystem();
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
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
            this.setMeasuringPointRepository((MeasuringPointRepository) newValue);
            return;
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM:
            this.setSystem((de.uka.ipd.sdq.pcm.system.System) newValue);
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
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
            this.setMeasuringPointRepository((MeasuringPointRepository) null);
            return;
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM:
            this.setSystem((de.uka.ipd.sdq.pcm.system.System) null);
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
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
            return this.getMeasuringPointRepository() != null;
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM:
            return this.system != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(final int derivedFeatureID, final Class<?> baseClass) {
        if (baseClass == MeasuringPoint.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
                return MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY;
            default:
                return -1;
            }
        }
        if (baseClass == SystemReference.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM:
                return PcmmeasuringpointPackage.SYSTEM_REFERENCE__SYSTEM;
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(final int baseFeatureID, final Class<?> baseClass) {
        if (baseClass == MeasuringPoint.class) {
            switch (baseFeatureID) {
            case MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY:
                return PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY;
            default:
                return -1;
            }
        }
        if (baseClass == SystemReference.class) {
            switch (baseFeatureID) {
            case PcmmeasuringpointPackage.SYSTEM_REFERENCE__SYSTEM:
                return PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // SystemOperationMeasuringPointImpl
