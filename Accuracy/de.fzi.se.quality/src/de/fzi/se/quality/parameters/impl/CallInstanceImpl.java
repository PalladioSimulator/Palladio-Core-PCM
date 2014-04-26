/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.se.quality.parameters.CallInstance;
import de.fzi.se.quality.parameters.OperationReference;
import de.fzi.se.quality.parameters.ParameterInstance;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.impl.CallInstanceImpl#getOperationReference <em>Operation Reference</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.impl.CallInstanceImpl#getOutputParameterInstances <em>Output Parameter Instances</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.impl.CallInstanceImpl#getNumberOfCalls <em>Number Of Calls</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.impl.CallInstanceImpl#getInputParameterInstances <em>Input Parameter Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallInstanceImpl extends IdentifierImpl implements CallInstance {
	/**
     * The cached value of the '{@link #getOperationReference() <em>Operation Reference</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOperationReference()
     * @generated
     * @ordered
     */
	protected OperationReference operationReference;

	/**
     * The cached value of the '{@link #getOutputParameterInstances() <em>Output Parameter Instances</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOutputParameterInstances()
     * @generated
     * @ordered
     */
	protected EList<ParameterInstance> outputParameterInstances;

	/**
     * The default value of the '{@link #getNumberOfCalls() <em>Number Of Calls</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNumberOfCalls()
     * @generated
     * @ordered
     */
	protected static final long NUMBER_OF_CALLS_EDEFAULT = 1L;

	/**
     * The cached value of the '{@link #getNumberOfCalls() <em>Number Of Calls</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNumberOfCalls()
     * @generated
     * @ordered
     */
	protected long numberOfCalls = NUMBER_OF_CALLS_EDEFAULT;

	/**
     * The cached value of the '{@link #getInputParameterInstances() <em>Input Parameter Instances</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInputParameterInstances()
     * @generated
     * @ordered
     */
	protected EList<ParameterInstance> inputParameterInstances;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CallInstanceImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ParametersPackage.Literals.CALL_INSTANCE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OperationReference getOperationReference() {
        return operationReference;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOperationReference(OperationReference newOperationReference, NotificationChain msgs) {
        OperationReference oldOperationReference = operationReference;
        operationReference = newOperationReference;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE, oldOperationReference, newOperationReference);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOperationReference(OperationReference newOperationReference) {
        if (newOperationReference != operationReference) {
            NotificationChain msgs = null;
            if (operationReference != null)
                msgs = ((InternalEObject)operationReference).eInverseRemove(this, ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE, OperationReference.class, msgs);
            if (newOperationReference != null)
                msgs = ((InternalEObject)newOperationReference).eInverseAdd(this, ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE, OperationReference.class, msgs);
            msgs = basicSetOperationReference(newOperationReference, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE, newOperationReference, newOperationReference));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ParameterInstance> getOutputParameterInstances() {
        if (outputParameterInstances == null) {
            outputParameterInstances = new EObjectContainmentWithInverseEList<ParameterInstance>(ParameterInstance.class, this, ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES, ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE);
        }
        return outputParameterInstances;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public long getNumberOfCalls() {
        return numberOfCalls;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setNumberOfCalls(long newNumberOfCalls) {
        long oldNumberOfCalls = numberOfCalls;
        numberOfCalls = newNumberOfCalls;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.CALL_INSTANCE__NUMBER_OF_CALLS, oldNumberOfCalls, numberOfCalls));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ParameterInstance> getInputParameterInstances() {
        if (inputParameterInstances == null) {
            inputParameterInstances = new EObjectContainmentWithInverseEList<ParameterInstance>(ParameterInstance.class, this, ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES, ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE);
        }
        return inputParameterInstances;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE:
                if (operationReference != null)
                    msgs = ((InternalEObject)operationReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE, null, msgs);
                return basicSetOperationReference((OperationReference)otherEnd, msgs);
            case ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputParameterInstances()).basicAdd(otherEnd, msgs);
            case ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputParameterInstances()).basicAdd(otherEnd, msgs);
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
            case ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE:
                return basicSetOperationReference(null, msgs);
            case ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES:
                return ((InternalEList<?>)getOutputParameterInstances()).basicRemove(otherEnd, msgs);
            case ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES:
                return ((InternalEList<?>)getInputParameterInstances()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE:
                return getOperationReference();
            case ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES:
                return getOutputParameterInstances();
            case ParametersPackage.CALL_INSTANCE__NUMBER_OF_CALLS:
                return getNumberOfCalls();
            case ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES:
                return getInputParameterInstances();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE:
                setOperationReference((OperationReference)newValue);
                return;
            case ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES:
                getOutputParameterInstances().clear();
                getOutputParameterInstances().addAll((Collection<? extends ParameterInstance>)newValue);
                return;
            case ParametersPackage.CALL_INSTANCE__NUMBER_OF_CALLS:
                setNumberOfCalls((Long)newValue);
                return;
            case ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES:
                getInputParameterInstances().clear();
                getInputParameterInstances().addAll((Collection<? extends ParameterInstance>)newValue);
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
            case ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE:
                setOperationReference((OperationReference)null);
                return;
            case ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES:
                getOutputParameterInstances().clear();
                return;
            case ParametersPackage.CALL_INSTANCE__NUMBER_OF_CALLS:
                setNumberOfCalls(NUMBER_OF_CALLS_EDEFAULT);
                return;
            case ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES:
                getInputParameterInstances().clear();
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
            case ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE:
                return operationReference != null;
            case ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES:
                return outputParameterInstances != null && !outputParameterInstances.isEmpty();
            case ParametersPackage.CALL_INSTANCE__NUMBER_OF_CALLS:
                return numberOfCalls != NUMBER_OF_CALLS_EDEFAULT;
            case ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES:
                return inputParameterInstances != null && !inputParameterInstances.isEmpty();
        }
        return super.eIsSet(featureID);
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
        result.append(" (numberOfCalls: ");
        result.append(numberOfCalls);
        result.append(')');
        return result.toString();
    }

} //CallInstanceImpl
