/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fzi.se.quality.parameters.CallInstance;
import de.fzi.se.quality.parameters.ComponentInstance;
import de.fzi.se.quality.parameters.ParameterInstance;
import de.fzi.se.quality.parameters.ParameterReference;
import de.fzi.se.quality.parameters.ParameterValue;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Parameter Instance</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.impl.ParameterInstanceImpl#getParameterReference <em>
 * Parameter Reference</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.impl.ParameterInstanceImpl#getInputCallInstance <em>Input
 * Call Instance</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.impl.ParameterInstanceImpl#getOutputCallInstance <em>
 * Output Call Instance</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.impl.ParameterInstanceImpl#getComponentInstance <em>
 * Component Instance</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.impl.ParameterInstanceImpl#getParameterValue <em>
 * Parameter Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterInstanceImpl extends IdentifierImpl implements ParameterInstance {

    /**
     * The cached value of the '{@link #getParameterReference() <em>Parameter Reference</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getParameterReference()
     * @generated
     * @ordered
     */
    protected ParameterReference parameterReference;

    /**
     * The cached value of the '{@link #getParameterValue() <em>Parameter Value</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getParameterValue()
     * @generated
     * @ordered
     */
    protected ParameterValue parameterValue;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ParameterInstanceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ParametersPackage.Literals.PARAMETER_INSTANCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ParameterReference getParameterReference() {
        return this.parameterReference;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParameterReference(final ParameterReference newParameterReference,
            NotificationChain msgs) {
        final ParameterReference oldParameterReference = this.parameterReference;
        this.parameterReference = newParameterReference;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE, oldParameterReference,
                    newParameterReference);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParameterReference(final ParameterReference newParameterReference) {
        if (newParameterReference != this.parameterReference) {
            NotificationChain msgs = null;
            if (this.parameterReference != null) {
                msgs = ((InternalEObject) this.parameterReference).eInverseRemove(this,
                        ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE, ParameterReference.class, msgs);
            }
            if (newParameterReference != null) {
                msgs = ((InternalEObject) newParameterReference).eInverseAdd(this,
                        ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE, ParameterReference.class, msgs);
            }
            msgs = this.basicSetParameterReference(newParameterReference, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE, newParameterReference,
                    newParameterReference));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CallInstance getInputCallInstance() {
        if (this.eContainerFeatureID() != ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE) {
            return null;
        }
        return (CallInstance) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetInputCallInstance(final CallInstance newInputCallInstance, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newInputCallInstance,
                ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setInputCallInstance(final CallInstance newInputCallInstance) {
        if (newInputCallInstance != this.eInternalContainer()
                || (this.eContainerFeatureID() != ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE && newInputCallInstance != null)) {
            if (EcoreUtil.isAncestor(this, newInputCallInstance)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newInputCallInstance != null) {
                msgs = ((InternalEObject) newInputCallInstance).eInverseAdd(this,
                        ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES, CallInstance.class, msgs);
            }
            msgs = this.basicSetInputCallInstance(newInputCallInstance, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE, newInputCallInstance,
                    newInputCallInstance));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CallInstance getOutputCallInstance() {
        if (this.eContainerFeatureID() != ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE) {
            return null;
        }
        return (CallInstance) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetOutputCallInstance(final CallInstance newOutputCallInstance, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newOutputCallInstance,
                ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOutputCallInstance(final CallInstance newOutputCallInstance) {
        if (newOutputCallInstance != this.eInternalContainer()
                || (this.eContainerFeatureID() != ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE && newOutputCallInstance != null)) {
            if (EcoreUtil.isAncestor(this, newOutputCallInstance)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newOutputCallInstance != null) {
                msgs = ((InternalEObject) newOutputCallInstance).eInverseAdd(this,
                        ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES, CallInstance.class, msgs);
            }
            msgs = this.basicSetOutputCallInstance(newOutputCallInstance, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE, newOutputCallInstance,
                    newOutputCallInstance));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ComponentInstance getComponentInstance() {
        if (this.eContainerFeatureID() != ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE) {
            return null;
        }
        return (ComponentInstance) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetComponentInstance(final ComponentInstance newComponentInstance,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newComponentInstance,
                ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setComponentInstance(final ComponentInstance newComponentInstance) {
        if (newComponentInstance != this.eInternalContainer()
                || (this.eContainerFeatureID() != ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE && newComponentInstance != null)) {
            if (EcoreUtil.isAncestor(this, newComponentInstance)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newComponentInstance != null) {
                msgs = ((InternalEObject) newComponentInstance).eInverseAdd(this,
                        ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES, ComponentInstance.class, msgs);
            }
            msgs = this.basicSetComponentInstance(newComponentInstance, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE, newComponentInstance,
                    newComponentInstance));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ParameterValue getParameterValue() {
        return this.parameterValue;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParameterValue(final ParameterValue newParameterValue, NotificationChain msgs) {
        final ParameterValue oldParameterValue = this.parameterValue;
        this.parameterValue = newParameterValue;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE, oldParameterValue, newParameterValue);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParameterValue(final ParameterValue newParameterValue) {
        if (newParameterValue != this.parameterValue) {
            NotificationChain msgs = null;
            if (this.parameterValue != null) {
                msgs = ((InternalEObject) this.parameterValue).eInverseRemove(this,
                        ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE, ParameterValue.class, msgs);
            }
            if (newParameterValue != null) {
                msgs = ((InternalEObject) newParameterValue).eInverseAdd(this,
                        ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE, ParameterValue.class, msgs);
            }
            msgs = this.basicSetParameterValue(newParameterValue, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE, newParameterValue, newParameterValue));
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
        case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE:
            if (this.parameterReference != null) {
                msgs = ((InternalEObject) this.parameterReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE, null, msgs);
            }
            return this.basicSetParameterReference((ParameterReference) otherEnd, msgs);
        case ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetInputCallInstance((CallInstance) otherEnd, msgs);
        case ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetOutputCallInstance((CallInstance) otherEnd, msgs);
        case ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetComponentInstance((ComponentInstance) otherEnd, msgs);
        case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE:
            if (this.parameterValue != null) {
                msgs = ((InternalEObject) this.parameterValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE, null, msgs);
            }
            return this.basicSetParameterValue((ParameterValue) otherEnd, msgs);
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
        case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE:
            return this.basicSetParameterReference(null, msgs);
        case ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE:
            return this.basicSetInputCallInstance(null, msgs);
        case ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE:
            return this.basicSetOutputCallInstance(null, msgs);
        case ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE:
            return this.basicSetComponentInstance(null, msgs);
        case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE:
            return this.basicSetParameterValue(null, msgs);
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
        case ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE:
            return this.eInternalContainer().eInverseRemove(this,
                    ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES, CallInstance.class, msgs);
        case ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE:
            return this.eInternalContainer().eInverseRemove(this,
                    ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES, CallInstance.class, msgs);
        case ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE:
            return this.eInternalContainer().eInverseRemove(this,
                    ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES, ComponentInstance.class, msgs);
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
        case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE:
            return this.getParameterReference();
        case ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE:
            return this.getInputCallInstance();
        case ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE:
            return this.getOutputCallInstance();
        case ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE:
            return this.getComponentInstance();
        case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE:
            return this.getParameterValue();
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
        case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE:
            this.setParameterReference((ParameterReference) newValue);
            return;
        case ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE:
            this.setInputCallInstance((CallInstance) newValue);
            return;
        case ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE:
            this.setOutputCallInstance((CallInstance) newValue);
            return;
        case ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE:
            this.setComponentInstance((ComponentInstance) newValue);
            return;
        case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE:
            this.setParameterValue((ParameterValue) newValue);
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
        case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE:
            this.setParameterReference((ParameterReference) null);
            return;
        case ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE:
            this.setInputCallInstance((CallInstance) null);
            return;
        case ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE:
            this.setOutputCallInstance((CallInstance) null);
            return;
        case ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE:
            this.setComponentInstance((ComponentInstance) null);
            return;
        case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE:
            this.setParameterValue((ParameterValue) null);
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
        case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE:
            return this.parameterReference != null;
        case ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE:
            return this.getInputCallInstance() != null;
        case ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE:
            return this.getOutputCallInstance() != null;
        case ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE:
            return this.getComponentInstance() != null;
        case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE:
            return this.parameterValue != null;
        }
        return super.eIsSet(featureID);
    }

} // ParameterInstanceImpl
