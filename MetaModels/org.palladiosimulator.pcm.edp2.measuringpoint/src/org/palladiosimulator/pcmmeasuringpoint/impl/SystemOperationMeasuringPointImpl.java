/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
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
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SystemOperationMeasuringPointImpl#getStringRepresentation
 * <em>String Representation</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.SystemOperationMeasuringPointImpl#getResourceURIRepresentation
 * <em>Resource URI Representation</em>}</li>
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
     * The default value of the '{@link #getStringRepresentation() <em>String Representation</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getStringRepresentation()
     * @generated
     * @ordered
     */
    protected static final String STRING_REPRESENTATION_EDEFAULT = null;

    /**
     * The default value of the '{@link #getResourceURIRepresentation()
     * <em>Resource URI Representation</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getResourceURIRepresentation()
     * @generated
     * @ordered
     */
    protected static final String RESOURCE_URI_REPRESENTATION_EDEFAULT = null;

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
        return (MeasuringPointRepository) this.eDynamicGet(
                PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY,
                MeasuringpointPackage.Literals.MEASURING_POINT__MEASURING_POINT_REPOSITORY, true, true);
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
        this.eDynamicSet(PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY,
                MeasuringpointPackage.Literals.MEASURING_POINT__MEASURING_POINT_REPOSITORY, newMeasuringPointRepository);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getStringRepresentation() {
        if (this.getSystem() == null || this.getRole() == null || this.getOperationSignature() == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);

        final StringBuilder result = new StringBuilder();

        result.append(this.getSystem().getEntityName());
        result.append(".");
        result.append(this.getRole().getEntityName());
        result.append(".");
        result.append(this.getOperationSignature().getEntityName());

        return result.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getResourceURIRepresentation() {
        if (this.getOperationSignature() == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);
        return EMFLoadHelper.getResourceURI(this.getOperationSignature());
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public de.uka.ipd.sdq.pcm.system.System getSystem() {
        return (de.uka.ipd.sdq.pcm.system.System) this.eDynamicGet(
                PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM,
                PcmmeasuringpointPackage.Literals.SYSTEM_REFERENCE__SYSTEM, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public de.uka.ipd.sdq.pcm.system.System basicGetSystem() {
        return (de.uka.ipd.sdq.pcm.system.System) this.eDynamicGet(
                PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM,
                PcmmeasuringpointPackage.Literals.SYSTEM_REFERENCE__SYSTEM, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSystem(final de.uka.ipd.sdq.pcm.system.System newSystem) {
        this.eDynamicSet(PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM,
                PcmmeasuringpointPackage.Literals.SYSTEM_REFERENCE__SYSTEM, newSystem);
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
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__STRING_REPRESENTATION:
            return this.getStringRepresentation();
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__RESOURCE_URI_REPRESENTATION:
            return this.getResourceURIRepresentation();
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
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__STRING_REPRESENTATION:
            return STRING_REPRESENTATION_EDEFAULT == null ? this.getStringRepresentation() != null
                    : !STRING_REPRESENTATION_EDEFAULT.equals(this.getStringRepresentation());
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__RESOURCE_URI_REPRESENTATION:
            return RESOURCE_URI_REPRESENTATION_EDEFAULT == null ? this.getResourceURIRepresentation() != null
                    : !RESOURCE_URI_REPRESENTATION_EDEFAULT.equals(this.getResourceURIRepresentation());
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__SYSTEM:
            return this.basicGetSystem() != null;
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
            case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__STRING_REPRESENTATION:
                return MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION;
            case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__RESOURCE_URI_REPRESENTATION:
                return MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION;
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
            case MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION:
                return PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__STRING_REPRESENTATION;
            case MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION:
                return PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT__RESOURCE_URI_REPRESENTATION;
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
