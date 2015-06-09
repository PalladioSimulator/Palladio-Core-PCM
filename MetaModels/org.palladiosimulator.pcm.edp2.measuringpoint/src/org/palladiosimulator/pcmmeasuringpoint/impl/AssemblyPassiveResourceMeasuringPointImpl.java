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
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyPassiveResourceMeasuringPointImpl#getStringRepresentation
 * <em>String Representation</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyPassiveResourceMeasuringPointImpl#getResourceURIRepresentation
 * <em>Resource URI Representation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssemblyPassiveResourceMeasuringPointImpl extends AssemblyReferenceImpl implements
        AssemblyPassiveResourceMeasuringPoint {

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
        return (PassiveResource) this.eDynamicGet(
                PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE,
                PcmmeasuringpointPackage.Literals.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PassiveResource basicGetPassiveResource() {
        return (PassiveResource) this.eDynamicGet(
                PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE,
                PcmmeasuringpointPackage.Literals.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPassiveResource(final PassiveResource newPassiveResource) {
        this.eDynamicSet(PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__PASSIVE_RESOURCE,
                PcmmeasuringpointPackage.Literals.PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE, newPassiveResource);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MeasuringPointRepository getMeasuringPointRepository() {
        return (MeasuringPointRepository) this.eDynamicGet(
                PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY,
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
        this.eDynamicSet(
                PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY,
                MeasuringpointPackage.Literals.MEASURING_POINT__MEASURING_POINT_REPOSITORY, newMeasuringPointRepository);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getStringRepresentation() {
        if (this.getAssembly() == null || this.getPassiveResource() == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);
        final StringBuilder result = new StringBuilder();

        result.append("Passive Resource: ");
        result.append(this.getAssembly().getEntityName());
        result.append(".");
        result.append(this.getPassiveResource().getEntityName());

        return result.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getResourceURIRepresentation() {
        if (this.getPassiveResource() == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);
        return EMFLoadHelper.getResourceURI(this.getPassiveResource());
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
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__STRING_REPRESENTATION:
            return this.getStringRepresentation();
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__RESOURCE_URI_REPRESENTATION:
            return this.getResourceURIRepresentation();
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
            return this.basicGetPassiveResource() != null;
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
            return this.getMeasuringPointRepository() != null;
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__STRING_REPRESENTATION:
            return STRING_REPRESENTATION_EDEFAULT == null ? this.getStringRepresentation() != null
                    : !STRING_REPRESENTATION_EDEFAULT.equals(this.getStringRepresentation());
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__RESOURCE_URI_REPRESENTATION:
            return RESOURCE_URI_REPRESENTATION_EDEFAULT == null ? this.getResourceURIRepresentation() != null
                    : !RESOURCE_URI_REPRESENTATION_EDEFAULT.equals(this.getResourceURIRepresentation());
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
            case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__STRING_REPRESENTATION:
                return MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION;
            case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__RESOURCE_URI_REPRESENTATION:
                return MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION;
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
            case MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION:
                return PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__STRING_REPRESENTATION;
            case MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION:
                return PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT__RESOURCE_URI_REPRESENTATION;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // AssemblyPassiveResourceMeasuringPointImpl
