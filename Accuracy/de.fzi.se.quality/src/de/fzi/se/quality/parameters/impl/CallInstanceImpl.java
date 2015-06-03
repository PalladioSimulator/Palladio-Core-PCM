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
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Call Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.impl.CallInstanceImpl#getOperationReference <em>Operation
 * Reference</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.impl.CallInstanceImpl#getOutputParameterInstances <em>
 * Output Parameter Instances</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.impl.CallInstanceImpl#getNumberOfCalls <em>Number Of
 * Calls</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.impl.CallInstanceImpl#getInputParameterInstances <em>
 * Input Parameter Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallInstanceImpl extends IdentifierImpl implements CallInstance {

    /**
     * The cached value of the '{@link #getOperationReference() <em>Operation Reference</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOperationReference()
     * @generated
     * @ordered
     */
    protected OperationReference operationReference;

    /**
     * The cached value of the '{@link #getOutputParameterInstances()
     * <em>Output Parameter Instances</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getOutputParameterInstances()
     * @generated
     * @ordered
     */
    protected EList<ParameterInstance> outputParameterInstances;

    /**
     * The default value of the '{@link #getNumberOfCalls() <em>Number Of Calls</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getNumberOfCalls()
     * @generated
     * @ordered
     */
    protected static final long NUMBER_OF_CALLS_EDEFAULT = 1L;

    /**
     * The cached value of the '{@link #getNumberOfCalls() <em>Number Of Calls</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getNumberOfCalls()
     * @generated
     * @ordered
     */
    protected long numberOfCalls = NUMBER_OF_CALLS_EDEFAULT;

    /**
     * The cached value of the '{@link #getInputParameterInstances()
     * <em>Input Parameter Instances</em>}' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getInputParameterInstances()
     * @generated
     * @ordered
     */
    protected EList<ParameterInstance> inputParameterInstances;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected CallInstanceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ParametersPackage.Literals.CALL_INSTANCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OperationReference getOperationReference() {
        return this.operationReference;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetOperationReference(final OperationReference newOperationReference,
            NotificationChain msgs) {
        final OperationReference oldOperationReference = this.operationReference;
        this.operationReference = newOperationReference;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE, oldOperationReference, newOperationReference);
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
    public void setOperationReference(final OperationReference newOperationReference) {
        if (newOperationReference != this.operationReference) {
            NotificationChain msgs = null;
            if (this.operationReference != null) {
                msgs = ((InternalEObject) this.operationReference).eInverseRemove(this,
                        ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE, OperationReference.class, msgs);
            }
            if (newOperationReference != null) {
                msgs = ((InternalEObject) newOperationReference).eInverseAdd(this,
                        ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE, OperationReference.class, msgs);
            }
            msgs = this.basicSetOperationReference(newOperationReference, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE, newOperationReference, newOperationReference));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ParameterInstance> getOutputParameterInstances() {
        if (this.outputParameterInstances == null) {
            this.outputParameterInstances = new EObjectContainmentWithInverseEList<ParameterInstance>(
                    ParameterInstance.class, this, ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES,
                    ParametersPackage.PARAMETER_INSTANCE__OUTPUT_CALL_INSTANCE);
        }
        return this.outputParameterInstances;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public long getNumberOfCalls() {
        return this.numberOfCalls;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setNumberOfCalls(final long newNumberOfCalls) {
        final long oldNumberOfCalls = this.numberOfCalls;
        this.numberOfCalls = newNumberOfCalls;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.CALL_INSTANCE__NUMBER_OF_CALLS, oldNumberOfCalls, this.numberOfCalls));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ParameterInstance> getInputParameterInstances() {
        if (this.inputParameterInstances == null) {
            this.inputParameterInstances = new EObjectContainmentWithInverseEList<ParameterInstance>(
                    ParameterInstance.class, this, ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES,
                    ParametersPackage.PARAMETER_INSTANCE__INPUT_CALL_INSTANCE);
        }
        return this.inputParameterInstances;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE:
            if (this.operationReference != null) {
                msgs = ((InternalEObject) this.operationReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE, null, msgs);
            }
            return this.basicSetOperationReference((OperationReference) otherEnd, msgs);
        case ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getOutputParameterInstances()).basicAdd(
                    otherEnd, msgs);
        case ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getInputParameterInstances()).basicAdd(
                    otherEnd, msgs);
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
        case ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE:
            return this.basicSetOperationReference(null, msgs);
        case ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES:
            return ((InternalEList<?>) this.getOutputParameterInstances()).basicRemove(otherEnd, msgs);
        case ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES:
            return ((InternalEList<?>) this.getInputParameterInstances()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE:
            return this.getOperationReference();
        case ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES:
            return this.getOutputParameterInstances();
        case ParametersPackage.CALL_INSTANCE__NUMBER_OF_CALLS:
            return this.getNumberOfCalls();
        case ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES:
            return this.getInputParameterInstances();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE:
            this.setOperationReference((OperationReference) newValue);
            return;
        case ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES:
            this.getOutputParameterInstances().clear();
            this.getOutputParameterInstances().addAll((Collection<? extends ParameterInstance>) newValue);
            return;
        case ParametersPackage.CALL_INSTANCE__NUMBER_OF_CALLS:
            this.setNumberOfCalls((Long) newValue);
            return;
        case ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES:
            this.getInputParameterInstances().clear();
            this.getInputParameterInstances().addAll((Collection<? extends ParameterInstance>) newValue);
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
        case ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE:
            this.setOperationReference((OperationReference) null);
            return;
        case ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES:
            this.getOutputParameterInstances().clear();
            return;
        case ParametersPackage.CALL_INSTANCE__NUMBER_OF_CALLS:
            this.setNumberOfCalls(NUMBER_OF_CALLS_EDEFAULT);
            return;
        case ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES:
            this.getInputParameterInstances().clear();
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
        case ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE:
            return this.operationReference != null;
        case ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES:
            return this.outputParameterInstances != null && !this.outputParameterInstances.isEmpty();
        case ParametersPackage.CALL_INSTANCE__NUMBER_OF_CALLS:
            return this.numberOfCalls != NUMBER_OF_CALLS_EDEFAULT;
        case ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES:
            return this.inputParameterInstances != null && !this.inputParameterInstances.isEmpty();
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
        result.append(" (numberOfCalls: ");
        result.append(this.numberOfCalls);
        result.append(')');
        return result.toString();
    }

} // CallInstanceImpl
