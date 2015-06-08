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
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.ParameterModifier;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceSignature;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Parameter</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl#getDataType__Parameter <em>Data Type
 * Parameter</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl#getInfrastructureSignature__Parameter
 * <em>Infrastructure Signature Parameter</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl#getOperationSignature__Parameter <em>
 * Operation Signature Parameter</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl#getEventType__Parameter <em>Event
 * Type Parameter</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl#getParameterName <em>Parameter Name
 * </em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl#getModifier__Parameter <em>Modifier
 * Parameter</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl#getResourceSignature__Parameter <em>
 * Resource Signature Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterImpl extends CDOObjectImpl implements Parameter {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getDataType__Parameter() <em>Data Type Parameter</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getDataType__Parameter()
     * @generated
     * @ordered
     */
    protected DataType dataType__Parameter;

    /**
     * The default value of the '{@link #getParameterName() <em>Parameter Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getParameterName()
     * @generated
     * @ordered
     */
    protected static final String PARAMETER_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getParameterName() <em>Parameter Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getParameterName()
     * @generated
     * @ordered
     */
    protected String parameterName = PARAMETER_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getModifier__Parameter() <em>Modifier Parameter</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getModifier__Parameter()
     * @generated
     * @ordered
     */
    protected static final ParameterModifier MODIFIER_PARAMETER_EDEFAULT = ParameterModifier.NONE;

    /**
     * The cached value of the '{@link #getModifier__Parameter() <em>Modifier Parameter</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getModifier__Parameter()
     * @generated
     * @ordered
     */
    protected ParameterModifier modifier__Parameter = MODIFIER_PARAMETER_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ParameterImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.PARAMETER;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getParameterName() {
        return this.parameterName;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setParameterName(final String newParameterName) {
        final String oldParameterName = this.parameterName;
        this.parameterName = newParameterName;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.PARAMETER__PARAMETER_NAME,
                    oldParameterName, this.parameterName));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ParameterModifier getModifier__Parameter() {
        return this.modifier__Parameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setModifier__Parameter(final ParameterModifier newModifier__Parameter) {
        final ParameterModifier oldModifier__Parameter = this.modifier__Parameter;
        this.modifier__Parameter = newModifier__Parameter == null ? MODIFIER_PARAMETER_EDEFAULT
                : newModifier__Parameter;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.PARAMETER__MODIFIER_PARAMETER,
                    oldModifier__Parameter, this.modifier__Parameter));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OperationSignature getOperationSignature__Parameter() {
        if (this.eContainerFeatureID() != RepositoryPackage.PARAMETER__OPERATION_SIGNATURE_PARAMETER) {
            return null;
        }
        return (OperationSignature) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetOperationSignature__Parameter(
            final OperationSignature newOperationSignature__Parameter, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newOperationSignature__Parameter,
                RepositoryPackage.PARAMETER__OPERATION_SIGNATURE_PARAMETER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOperationSignature__Parameter(final OperationSignature newOperationSignature__Parameter) {
        if (newOperationSignature__Parameter != this.eInternalContainer()
                || (this.eContainerFeatureID() != RepositoryPackage.PARAMETER__OPERATION_SIGNATURE_PARAMETER && newOperationSignature__Parameter != null)) {
            if (EcoreUtil.isAncestor(this, newOperationSignature__Parameter)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newOperationSignature__Parameter != null) {
                msgs = ((InternalEObject) newOperationSignature__Parameter).eInverseAdd(this,
                        RepositoryPackage.OPERATION_SIGNATURE__PARAMETERS_OPERATION_SIGNATURE,
                        OperationSignature.class, msgs);
            }
            msgs = this.basicSetOperationSignature__Parameter(newOperationSignature__Parameter, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.PARAMETER__OPERATION_SIGNATURE_PARAMETER, newOperationSignature__Parameter,
                    newOperationSignature__Parameter));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public DataType getDataType__Parameter() {
        if (this.dataType__Parameter != null && ((EObject) this.dataType__Parameter).eIsProxy()) {
            final InternalEObject oldDataType__Parameter = (InternalEObject) this.dataType__Parameter;
            this.dataType__Parameter = (DataType) this.eResolveProxy(oldDataType__Parameter);
            if (this.dataType__Parameter != oldDataType__Parameter) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            RepositoryPackage.PARAMETER__DATA_TYPE_PARAMETER, oldDataType__Parameter,
                            this.dataType__Parameter));
                }
            }
        }
        return this.dataType__Parameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public DataType basicGetDataType__Parameter() {
        return this.dataType__Parameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDataType__Parameter(final DataType newDataType__Parameter) {
        final DataType oldDataType__Parameter = this.dataType__Parameter;
        this.dataType__Parameter = newDataType__Parameter;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.PARAMETER__DATA_TYPE_PARAMETER, oldDataType__Parameter, this.dataType__Parameter));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceSignature getResourceSignature__Parameter() {
        if (this.eContainerFeatureID() != RepositoryPackage.PARAMETER__RESOURCE_SIGNATURE_PARAMETER) {
            return null;
        }
        return (ResourceSignature) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetResourceSignature__Parameter(
            final ResourceSignature newResourceSignature__Parameter, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newResourceSignature__Parameter,
                RepositoryPackage.PARAMETER__RESOURCE_SIGNATURE_PARAMETER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceSignature__Parameter(final ResourceSignature newResourceSignature__Parameter) {
        if (newResourceSignature__Parameter != this.eInternalContainer()
                || (this.eContainerFeatureID() != RepositoryPackage.PARAMETER__RESOURCE_SIGNATURE_PARAMETER && newResourceSignature__Parameter != null)) {
            if (EcoreUtil.isAncestor(this, newResourceSignature__Parameter)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newResourceSignature__Parameter != null) {
                msgs = ((InternalEObject) newResourceSignature__Parameter).eInverseAdd(this,
                        ResourcetypePackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE, ResourceSignature.class,
                        msgs);
            }
            msgs = this.basicSetResourceSignature__Parameter(newResourceSignature__Parameter, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.PARAMETER__RESOURCE_SIGNATURE_PARAMETER, newResourceSignature__Parameter,
                    newResourceSignature__Parameter));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InfrastructureSignature getInfrastructureSignature__Parameter() {
        if (this.eContainerFeatureID() != RepositoryPackage.PARAMETER__INFRASTRUCTURE_SIGNATURE_PARAMETER) {
            return null;
        }
        return (InfrastructureSignature) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetInfrastructureSignature__Parameter(
            final InfrastructureSignature newInfrastructureSignature__Parameter, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newInfrastructureSignature__Parameter,
                RepositoryPackage.PARAMETER__INFRASTRUCTURE_SIGNATURE_PARAMETER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setInfrastructureSignature__Parameter(
            final InfrastructureSignature newInfrastructureSignature__Parameter) {
        if (newInfrastructureSignature__Parameter != this.eInternalContainer()
                || (this.eContainerFeatureID() != RepositoryPackage.PARAMETER__INFRASTRUCTURE_SIGNATURE_PARAMETER && newInfrastructureSignature__Parameter != null)) {
            if (EcoreUtil.isAncestor(this, newInfrastructureSignature__Parameter)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newInfrastructureSignature__Parameter != null) {
                msgs = ((InternalEObject) newInfrastructureSignature__Parameter).eInverseAdd(this,
                        RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE,
                        InfrastructureSignature.class, msgs);
            }
            msgs = this.basicSetInfrastructureSignature__Parameter(newInfrastructureSignature__Parameter, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.PARAMETER__INFRASTRUCTURE_SIGNATURE_PARAMETER,
                    newInfrastructureSignature__Parameter, newInfrastructureSignature__Parameter));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EventType getEventType__Parameter() {
        if (this.eContainerFeatureID() != RepositoryPackage.PARAMETER__EVENT_TYPE_PARAMETER) {
            return null;
        }
        return (EventType) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetEventType__Parameter(final EventType newEventType__Parameter,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newEventType__Parameter,
                RepositoryPackage.PARAMETER__EVENT_TYPE_PARAMETER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setEventType__Parameter(final EventType newEventType__Parameter) {
        if (newEventType__Parameter != this.eInternalContainer()
                || (this.eContainerFeatureID() != RepositoryPackage.PARAMETER__EVENT_TYPE_PARAMETER && newEventType__Parameter != null)) {
            if (EcoreUtil.isAncestor(this, newEventType__Parameter)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newEventType__Parameter != null) {
                msgs = ((InternalEObject) newEventType__Parameter).eInverseAdd(this,
                        RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE, EventType.class, msgs);
            }
            msgs = this.basicSetEventType__Parameter(newEventType__Parameter, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.PARAMETER__EVENT_TYPE_PARAMETER, newEventType__Parameter, newEventType__Parameter));
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
        case RepositoryPackage.PARAMETER__INFRASTRUCTURE_SIGNATURE_PARAMETER:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetInfrastructureSignature__Parameter((InfrastructureSignature) otherEnd, msgs);
        case RepositoryPackage.PARAMETER__OPERATION_SIGNATURE_PARAMETER:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetOperationSignature__Parameter((OperationSignature) otherEnd, msgs);
        case RepositoryPackage.PARAMETER__EVENT_TYPE_PARAMETER:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetEventType__Parameter((EventType) otherEnd, msgs);
        case RepositoryPackage.PARAMETER__RESOURCE_SIGNATURE_PARAMETER:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetResourceSignature__Parameter((ResourceSignature) otherEnd, msgs);
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
        case RepositoryPackage.PARAMETER__INFRASTRUCTURE_SIGNATURE_PARAMETER:
            return this.basicSetInfrastructureSignature__Parameter(null, msgs);
        case RepositoryPackage.PARAMETER__OPERATION_SIGNATURE_PARAMETER:
            return this.basicSetOperationSignature__Parameter(null, msgs);
        case RepositoryPackage.PARAMETER__EVENT_TYPE_PARAMETER:
            return this.basicSetEventType__Parameter(null, msgs);
        case RepositoryPackage.PARAMETER__RESOURCE_SIGNATURE_PARAMETER:
            return this.basicSetResourceSignature__Parameter(null, msgs);
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
        case RepositoryPackage.PARAMETER__INFRASTRUCTURE_SIGNATURE_PARAMETER:
            return this.eInternalContainer().eInverseRemove(this,
                    RepositoryPackage.INFRASTRUCTURE_SIGNATURE__PARAMETERS_INFRASTRUCTURE_SIGNATURE,
                    InfrastructureSignature.class, msgs);
        case RepositoryPackage.PARAMETER__OPERATION_SIGNATURE_PARAMETER:
            return this.eInternalContainer().eInverseRemove(this,
                    RepositoryPackage.OPERATION_SIGNATURE__PARAMETERS_OPERATION_SIGNATURE, OperationSignature.class,
                    msgs);
        case RepositoryPackage.PARAMETER__EVENT_TYPE_PARAMETER:
            return this.eInternalContainer().eInverseRemove(this, RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE,
                    EventType.class, msgs);
        case RepositoryPackage.PARAMETER__RESOURCE_SIGNATURE_PARAMETER:
            return this.eInternalContainer()
                    .eInverseRemove(this, ResourcetypePackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE,
                            ResourceSignature.class, msgs);
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
        case RepositoryPackage.PARAMETER__DATA_TYPE_PARAMETER:
            if (resolve) {
                return this.getDataType__Parameter();
            }
            return this.basicGetDataType__Parameter();
        case RepositoryPackage.PARAMETER__INFRASTRUCTURE_SIGNATURE_PARAMETER:
            return this.getInfrastructureSignature__Parameter();
        case RepositoryPackage.PARAMETER__OPERATION_SIGNATURE_PARAMETER:
            return this.getOperationSignature__Parameter();
        case RepositoryPackage.PARAMETER__EVENT_TYPE_PARAMETER:
            return this.getEventType__Parameter();
        case RepositoryPackage.PARAMETER__PARAMETER_NAME:
            return this.getParameterName();
        case RepositoryPackage.PARAMETER__MODIFIER_PARAMETER:
            return this.getModifier__Parameter();
        case RepositoryPackage.PARAMETER__RESOURCE_SIGNATURE_PARAMETER:
            return this.getResourceSignature__Parameter();
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
        case RepositoryPackage.PARAMETER__DATA_TYPE_PARAMETER:
            this.setDataType__Parameter((DataType) newValue);
            return;
        case RepositoryPackage.PARAMETER__INFRASTRUCTURE_SIGNATURE_PARAMETER:
            this.setInfrastructureSignature__Parameter((InfrastructureSignature) newValue);
            return;
        case RepositoryPackage.PARAMETER__OPERATION_SIGNATURE_PARAMETER:
            this.setOperationSignature__Parameter((OperationSignature) newValue);
            return;
        case RepositoryPackage.PARAMETER__EVENT_TYPE_PARAMETER:
            this.setEventType__Parameter((EventType) newValue);
            return;
        case RepositoryPackage.PARAMETER__PARAMETER_NAME:
            this.setParameterName((String) newValue);
            return;
        case RepositoryPackage.PARAMETER__MODIFIER_PARAMETER:
            this.setModifier__Parameter((ParameterModifier) newValue);
            return;
        case RepositoryPackage.PARAMETER__RESOURCE_SIGNATURE_PARAMETER:
            this.setResourceSignature__Parameter((ResourceSignature) newValue);
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
        case RepositoryPackage.PARAMETER__DATA_TYPE_PARAMETER:
            this.setDataType__Parameter((DataType) null);
            return;
        case RepositoryPackage.PARAMETER__INFRASTRUCTURE_SIGNATURE_PARAMETER:
            this.setInfrastructureSignature__Parameter((InfrastructureSignature) null);
            return;
        case RepositoryPackage.PARAMETER__OPERATION_SIGNATURE_PARAMETER:
            this.setOperationSignature__Parameter((OperationSignature) null);
            return;
        case RepositoryPackage.PARAMETER__EVENT_TYPE_PARAMETER:
            this.setEventType__Parameter((EventType) null);
            return;
        case RepositoryPackage.PARAMETER__PARAMETER_NAME:
            this.setParameterName(PARAMETER_NAME_EDEFAULT);
            return;
        case RepositoryPackage.PARAMETER__MODIFIER_PARAMETER:
            this.setModifier__Parameter(MODIFIER_PARAMETER_EDEFAULT);
            return;
        case RepositoryPackage.PARAMETER__RESOURCE_SIGNATURE_PARAMETER:
            this.setResourceSignature__Parameter((ResourceSignature) null);
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
        case RepositoryPackage.PARAMETER__DATA_TYPE_PARAMETER:
            return this.dataType__Parameter != null;
        case RepositoryPackage.PARAMETER__INFRASTRUCTURE_SIGNATURE_PARAMETER:
            return this.getInfrastructureSignature__Parameter() != null;
        case RepositoryPackage.PARAMETER__OPERATION_SIGNATURE_PARAMETER:
            return this.getOperationSignature__Parameter() != null;
        case RepositoryPackage.PARAMETER__EVENT_TYPE_PARAMETER:
            return this.getEventType__Parameter() != null;
        case RepositoryPackage.PARAMETER__PARAMETER_NAME:
            return PARAMETER_NAME_EDEFAULT == null ? this.parameterName != null : !PARAMETER_NAME_EDEFAULT
            .equals(this.parameterName);
        case RepositoryPackage.PARAMETER__MODIFIER_PARAMETER:
            return this.modifier__Parameter != MODIFIER_PARAMETER_EDEFAULT;
        case RepositoryPackage.PARAMETER__RESOURCE_SIGNATURE_PARAMETER:
            return this.getResourceSignature__Parameter() != null;
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
        result.append(" (parameterName: ");
        result.append(this.parameterName);
        result.append(", modifier__Parameter: ");
        result.append(this.modifier__Parameter);
        result.append(')');
        return result.toString();
    }

} // ParameterImpl
