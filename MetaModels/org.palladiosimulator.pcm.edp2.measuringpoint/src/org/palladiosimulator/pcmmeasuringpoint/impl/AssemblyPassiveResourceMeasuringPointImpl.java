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
import org.palladiosimulator.pcmmeasuringpoint.AssemblyPassiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Assembly Passive Resource Measuring Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyPassiveResourceMeasuringPointImpl#getPassiveResource
 * <em>Passive Resource</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyPassiveResourceMeasuringPointImpl#getMeasuringPointRepository
 * <em>Measuring Point Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssemblyPassiveResourceMeasuringPointImpl extends AssemblyReferenceImpl implements
AssemblyPassiveResourceMeasuringPoint {
    /**
     * The cached value of the '{@link #getPassiveResource() <em>Passive Resource</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPassiveResource()
     * @generated
     * @ordered
     */
    protected PassiveResource passiveResource;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AssemblyPassiveResourceMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PassiveResource getPassiveResource() {
        if (this.passiveResource != null && ((EObject) this.passiveResource).eIsProxy()) {
            final InternalEObject oldPassiveResource = (InternalEObject) this.passiveResource;
            this.passiveResource = (PassiveResource) this.eResolveProxy(oldPassiveResource);
            if (this.passiveResource != oldPassiveResource) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE,
                            oldPassiveResource, this.passiveResource));
                }
            }
        }
        return this.passiveResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PassiveResource basicGetPassiveResource() {
        return this.passiveResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPassiveResource(final PassiveResource newPassiveResource) {
        final PassiveResource oldPassiveResource = this.passiveResource;
        this.passiveResource = newPassiveResource;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE,
                    oldPassiveResource, this.passiveResource));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public MeasuringPointRepository getMeasuringPointRepository() {
        if (this.eContainerFeatureID() != PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY) {
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
                PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY, msgs);
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
                || (this.eContainerFeatureID() != PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY && newMeasuringPointRepository != null)) {
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
                    PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY,
                    newMeasuringPointRepository, newMeasuringPointRepository));
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
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
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
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
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
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
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
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE:
            if (resolve) {
                return this.getPassiveResource();
            }
            return this.basicGetPassiveResource();
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
            return this.getMeasuringPointRepository();
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
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE:
            this.setPassiveResource((PassiveResource) newValue);
            return;
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
            this.setMeasuringPointRepository((MeasuringPointRepository) newValue);
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
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE:
            this.setPassiveResource((PassiveResource) null);
            return;
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
            this.setMeasuringPointRepository((MeasuringPointRepository) null);
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
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE:
            return this.passiveResource != null;
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
            return this.getMeasuringPointRepository() != null;
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
        if (baseClass == PassiveResourceReference.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE:
                return PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE;
            default:
                return -1;
            }
        }
        if (baseClass == MeasuringPoint.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
                return MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY;
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
        if (baseClass == PassiveResourceReference.class) {
            switch (baseFeatureID) {
            case PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE:
                return PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE;
            default:
                return -1;
            }
        }
        if (baseClass == MeasuringPoint.class) {
            switch (baseFeatureID) {
            case MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY:
                return PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // AssemblyPassiveResourceMeasuringPointImpl
