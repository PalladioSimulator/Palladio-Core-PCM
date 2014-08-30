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
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.impl.ParameterInstanceImpl#getParameterReference <em>Parameter Reference</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.impl.ParameterInstanceImpl#getInputCallInstance <em>Input Call Instance</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.impl.ParameterInstanceImpl#getOutputCallInstance <em>Output Call Instance</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.impl.ParameterInstanceImpl#getComponentInstance <em>Component Instance</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.impl.ParameterInstanceImpl#getParameterValue <em>Parameter Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterInstanceImpl extends IdentifierImpl implements ParameterInstance {
	/**
     * The cached value of the '{@link #getParameterReference() <em>Parameter Reference</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getParameterReference()
     * @generated
     * @ordered
     */
	protected ParameterReference parameterReference;

	/**
     * The cached value of the '{@link #getParameterValue() <em>Parameter Value</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getParameterValue()
     * @generated
     * @ordered
     */
	protected ParameterValue parameterValue;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ParameterInstanceImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ParametersPackage.Literals.PARAMETER_INSTANCE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ParameterReference getParameterReference() {
        return parameterReference;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetParameterReference(ParameterReference newParameterReference, NotificationChain msgs) {
        ParameterReference oldParameterReference = parameterReference;
        parameterReference = newParameterReference;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE, oldParameterReference, newParameterReference);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setParameterReference(ParameterReference newParameterReference) {
        if (newParameterReference != parameterReference) {
            NotificationChain msgs = null;
            if (parameterReference != null)
                msgs = ((InternalEObject)parameterReference).eInverseRemove(this, ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE, ParameterReference.class, msgs);
            if (newParameterReference != null)
                msgs = ((InternalEObject)newParameterReference).eInverseAdd(this, ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE, ParameterReference.class, msgs);
            msgs = basicSetParameterReference(newParameterReference, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE, newParameterReference, newParameterReference));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CallInstance getInputCallInstance() {
        if (eContainerFeatureID() != ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE) return null;
        return (CallInstance)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetInputCallInstance(CallInstance newInputCallInstance, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newInputCallInstance, ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setInputCallInstance(CallInstance newInputCallInstance) {
        if (newInputCallInstance != eInternalContainer() || (eContainerFeatureID() != ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE && newInputCallInstance != null)) {
            if (EcoreUtil.isAncestor(this, newInputCallInstance))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInputCallInstance != null)
                msgs = ((InternalEObject)newInputCallInstance).eInverseAdd(this, ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES, CallInstance.class, msgs);
            msgs = basicSetInputCallInstance(newInputCallInstance, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE, newInputCallInstance, newInputCallInstance));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CallInstance getOutputCallInstance() {
        if (eContainerFeatureID() != ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE) return null;
        return (CallInstance)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOutputCallInstance(CallInstance newOutputCallInstance, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOutputCallInstance, ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOutputCallInstance(CallInstance newOutputCallInstance) {
        if (newOutputCallInstance != eInternalContainer() || (eContainerFeatureID() != ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE && newOutputCallInstance != null)) {
            if (EcoreUtil.isAncestor(this, newOutputCallInstance))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOutputCallInstance != null)
                msgs = ((InternalEObject)newOutputCallInstance).eInverseAdd(this, ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES, CallInstance.class, msgs);
            msgs = basicSetOutputCallInstance(newOutputCallInstance, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE, newOutputCallInstance, newOutputCallInstance));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ComponentInstance getComponentInstance() {
        if (eContainerFeatureID() != ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE) return null;
        return (ComponentInstance)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetComponentInstance(ComponentInstance newComponentInstance, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newComponentInstance, ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setComponentInstance(ComponentInstance newComponentInstance) {
        if (newComponentInstance != eInternalContainer() || (eContainerFeatureID() != ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE && newComponentInstance != null)) {
            if (EcoreUtil.isAncestor(this, newComponentInstance))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newComponentInstance != null)
                msgs = ((InternalEObject)newComponentInstance).eInverseAdd(this, ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES, ComponentInstance.class, msgs);
            msgs = basicSetComponentInstance(newComponentInstance, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE, newComponentInstance, newComponentInstance));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ParameterValue getParameterValue() {
        return parameterValue;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetParameterValue(ParameterValue newParameterValue, NotificationChain msgs) {
        ParameterValue oldParameterValue = parameterValue;
        parameterValue = newParameterValue;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE, oldParameterValue, newParameterValue);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setParameterValue(ParameterValue newParameterValue) {
        if (newParameterValue != parameterValue) {
            NotificationChain msgs = null;
            if (parameterValue != null)
                msgs = ((InternalEObject)parameterValue).eInverseRemove(this, ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE, ParameterValue.class, msgs);
            if (newParameterValue != null)
                msgs = ((InternalEObject)newParameterValue).eInverseAdd(this, ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE, ParameterValue.class, msgs);
            msgs = basicSetParameterValue(newParameterValue, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE, newParameterValue, newParameterValue));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE:
                if (parameterReference != null)
                    msgs = ((InternalEObject)parameterReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE, null, msgs);
                return basicSetParameterReference((ParameterReference)otherEnd, msgs);
            case ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetInputCallInstance((CallInstance)otherEnd, msgs);
            case ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOutputCallInstance((CallInstance)otherEnd, msgs);
            case ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetComponentInstance((ComponentInstance)otherEnd, msgs);
            case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE:
                if (parameterValue != null)
                    msgs = ((InternalEObject)parameterValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE, null, msgs);
                return basicSetParameterValue((ParameterValue)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE:
                return basicSetParameterReference(null, msgs);
            case ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE:
                return basicSetInputCallInstance(null, msgs);
            case ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE:
                return basicSetOutputCallInstance(null, msgs);
            case ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE:
                return basicSetComponentInstance(null, msgs);
            case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE:
                return basicSetParameterValue(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE:
                return eInternalContainer().eInverseRemove(this, ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES, CallInstance.class, msgs);
            case ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE:
                return eInternalContainer().eInverseRemove(this, ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES, CallInstance.class, msgs);
            case ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE:
                return eInternalContainer().eInverseRemove(this, ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES, ComponentInstance.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE:
                return getParameterReference();
            case ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE:
                return getInputCallInstance();
            case ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE:
                return getOutputCallInstance();
            case ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE:
                return getComponentInstance();
            case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE:
                return getParameterValue();
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
            case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE:
                setParameterReference((ParameterReference)newValue);
                return;
            case ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE:
                setInputCallInstance((CallInstance)newValue);
                return;
            case ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE:
                setOutputCallInstance((CallInstance)newValue);
                return;
            case ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE:
                setComponentInstance((ComponentInstance)newValue);
                return;
            case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE:
                setParameterValue((ParameterValue)newValue);
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
            case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE:
                setParameterReference((ParameterReference)null);
                return;
            case ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE:
                setInputCallInstance((CallInstance)null);
                return;
            case ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE:
                setOutputCallInstance((CallInstance)null);
                return;
            case ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE:
                setComponentInstance((ComponentInstance)null);
                return;
            case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE:
                setParameterValue((ParameterValue)null);
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
            case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE:
                return parameterReference != null;
            case ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE:
                return getInputCallInstance() != null;
            case ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE:
                return getOutputCallInstance() != null;
            case ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE:
                return getComponentInstance() != null;
            case ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE:
                return parameterValue != null;
        }
        return super.eIsSet(featureID);
    }

} //ParameterInstanceImpl
