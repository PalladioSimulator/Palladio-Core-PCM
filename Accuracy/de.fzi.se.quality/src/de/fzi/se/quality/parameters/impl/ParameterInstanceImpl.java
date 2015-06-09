/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

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
        return (ParameterReference) this.eDynamicGet(ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE,
                ParametersPackage.Literals.PARAMETER_INSTANCE__PARAMETER_REFERENCE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParameterReference(final ParameterReference newParameterReference,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newParameterReference,
                ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParameterReference(final ParameterReference newParameterReference) {
        this.eDynamicSet(ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE,
                ParametersPackage.Literals.PARAMETER_INSTANCE__PARAMETER_REFERENCE, newParameterReference);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CallInstance getInputCallInstance() {
        return (CallInstance) this.eDynamicGet(ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE,
                ParametersPackage.Literals.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE, true, true);
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
        this.eDynamicSet(ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE,
                ParametersPackage.Literals.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE, newInputCallInstance);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CallInstance getOutputCallInstance() {
        return (CallInstance) this.eDynamicGet(ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE,
                ParametersPackage.Literals.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE, true, true);
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
        this.eDynamicSet(ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE,
                ParametersPackage.Literals.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE, newOutputCallInstance);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ComponentInstance getComponentInstance() {
        return (ComponentInstance) this.eDynamicGet(ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE,
                ParametersPackage.Literals.PARAMETER_INSTANCE__COMPONENT_INSTANCE, true, true);
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
        this.eDynamicSet(ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE,
                ParametersPackage.Literals.PARAMETER_INSTANCE__COMPONENT_INSTANCE, newComponentInstance);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ParameterValue getParameterValue() {
        return (ParameterValue) this.eDynamicGet(ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE,
                ParametersPackage.Literals.PARAMETER_INSTANCE__PARAMETER_VALUE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParameterValue(final ParameterValue newParameterValue, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newParameterValue,
                ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParameterValue(final ParameterValue newParameterValue) {
        this.eDynamicSet(ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE,
                ParametersPackage.Literals.PARAMETER_INSTANCE__PARAMETER_VALUE, newParameterValue);
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
            final ParameterReference parameterReference = this.getParameterReference();
            if (parameterReference != null) {
                msgs = ((InternalEObject) parameterReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
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
            final ParameterValue parameterValue = this.getParameterValue();
            if (parameterValue != null) {
                msgs = ((InternalEObject) parameterValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
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
            return this.getParameterReference() != null;
        case ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE:
            return this.getInputCallInstance() != null;
        case ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE:
            return this.getOutputCallInstance() != null;
        case ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE:
            return this.getComponentInstance() != null;
        case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE:
            return this.getParameterValue() != null;
        }
        return super.eIsSet(featureID);
    }

} // ParameterInstanceImpl
