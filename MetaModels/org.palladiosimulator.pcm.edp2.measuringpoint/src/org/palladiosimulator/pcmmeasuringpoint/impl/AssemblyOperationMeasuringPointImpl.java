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
import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPointRepository;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Assembly Operation Measuring Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyOperationMeasuringPointImpl#getAssembly
 * <em>Assembly</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyOperationMeasuringPointImpl#getMeasuringPointRepository
 * <em>Measuring Point Repository</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyOperationMeasuringPointImpl#getStringRepresentation
 * <em>String Representation</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyOperationMeasuringPointImpl#getResourceURIRepresentation
 * <em>Resource URI Representation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssemblyOperationMeasuringPointImpl extends OperationReferenceImpl implements
        AssemblyOperationMeasuringPoint {
    /**
     * The cached value of the '{@link #getAssembly() <em>Assembly</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAssembly()
     * @generated
     * @ordered
     */
    protected AssemblyContext assembly;

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
    protected AssemblyOperationMeasuringPointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.ASSEMBLY_OPERATION_MEASURING_POINT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContext getAssembly() {
        if (this.assembly != null && ((EObject) this.assembly).eIsProxy()) {
            final InternalEObject oldAssembly = (InternalEObject) this.assembly;
            this.assembly = (AssemblyContext) this.eResolveProxy(oldAssembly);
            if (this.assembly != oldAssembly) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY, oldAssembly,
                            this.assembly));
                }
            }
        }
        return this.assembly;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AssemblyContext basicGetAssembly() {
        return this.assembly;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAssembly(final AssemblyContext newAssembly) {
        final AssemblyContext oldAssembly = this.assembly;
        this.assembly = newAssembly;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY, oldAssembly, this.assembly));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public MeasuringPointRepository getMeasuringPointRepository() {
        if (this.eContainerFeatureID() != PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY) {
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
                PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY, msgs);
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
                || (this.eContainerFeatureID() != PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY && newMeasuringPointRepository != null)) {
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
                    PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY,
                    newMeasuringPointRepository, newMeasuringPointRepository));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getStringRepresentation() {
        if (this.assembly == null || this.role == null || this.operationSignature == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);
        final StringBuilder result = new StringBuilder();

        result.append("Operation: ");
        result.append(this.assembly.getEntityName());
        result.append(".");
        result.append(this.role.getEntityName());
        result.append(".");
        result.append(this.operationSignature.getEntityName());

        return result.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getResourceURIRepresentation() {
        if (this.operationSignature == null) {
            return "";
        }
        EcoreUtil.resolveAll(this);
        return EMFLoadHelper.getResourceURI(this.operationSignature);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
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
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
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
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
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
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY:
            if (resolve) {
                return this.getAssembly();
            }
            return this.basicGetAssembly();
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
            return this.getMeasuringPointRepository();
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__STRING_REPRESENTATION:
            return this.getStringRepresentation();
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__RESOURCE_URI_REPRESENTATION:
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
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY:
            this.setAssembly((AssemblyContext) newValue);
            return;
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
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
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY:
            this.setAssembly((AssemblyContext) null);
            return;
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
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
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY:
            return this.assembly != null;
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
            return this.getMeasuringPointRepository() != null;
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__STRING_REPRESENTATION:
            return STRING_REPRESENTATION_EDEFAULT == null ? this.getStringRepresentation() != null
                    : !STRING_REPRESENTATION_EDEFAULT.equals(this.getStringRepresentation());
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__RESOURCE_URI_REPRESENTATION:
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
        if (baseClass == AssemblyReference.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY:
                return PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY;
            default:
                return -1;
            }
        }
        if (baseClass == MeasuringPoint.class) {
            switch (derivedFeatureID) {
            case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY:
                return MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY;
            case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__STRING_REPRESENTATION:
                return MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION;
            case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__RESOURCE_URI_REPRESENTATION:
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
        if (baseClass == AssemblyReference.class) {
            switch (baseFeatureID) {
            case PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY:
                return PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__ASSEMBLY;
            default:
                return -1;
            }
        }
        if (baseClass == MeasuringPoint.class) {
            switch (baseFeatureID) {
            case MeasuringpointPackage.MEASURING_POINT__MEASURING_POINT_REPOSITORY:
                return PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__MEASURING_POINT_REPOSITORY;
            case MeasuringpointPackage.MEASURING_POINT__STRING_REPRESENTATION:
                return PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__STRING_REPRESENTATION;
            case MeasuringpointPackage.MEASURING_POINT__RESOURCE_URI_REPRESENTATION:
                return PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT__RESOURCE_URI_REPRESENTATION;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // AssemblyOperationMeasuringPointImpl
