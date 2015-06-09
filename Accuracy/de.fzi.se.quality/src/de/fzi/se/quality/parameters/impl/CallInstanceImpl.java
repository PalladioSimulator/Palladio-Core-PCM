/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
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
     * The default value of the '{@link #getNumberOfCalls() <em>Number Of Calls</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getNumberOfCalls()
     * @generated
     * @ordered
     */
    protected static final long NUMBER_OF_CALLS_EDEFAULT = 1L;

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
        return (OperationReference) this.eDynamicGet(ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE,
                ParametersPackage.Literals.CALL_INSTANCE__OPERATION_REFERENCE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetOperationReference(final OperationReference newOperationReference,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newOperationReference,
                ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOperationReference(final OperationReference newOperationReference) {
        this.eDynamicSet(ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE,
                ParametersPackage.Literals.CALL_INSTANCE__OPERATION_REFERENCE, newOperationReference);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ParameterInstance> getOutputParameterInstances() {
        return (EList<ParameterInstance>) this.eDynamicGet(ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES,
                ParametersPackage.Literals.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public long getNumberOfCalls() {
        return (Long) this.eDynamicGet(ParametersPackage.CALL_INSTANCE__NUMBER_OF_CALLS,
                ParametersPackage.Literals.CALL_INSTANCE__NUMBER_OF_CALLS, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setNumberOfCalls(final long newNumberOfCalls) {
        this.eDynamicSet(ParametersPackage.CALL_INSTANCE__NUMBER_OF_CALLS,
                ParametersPackage.Literals.CALL_INSTANCE__NUMBER_OF_CALLS, newNumberOfCalls);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ParameterInstance> getInputParameterInstances() {
        return (EList<ParameterInstance>) this.eDynamicGet(ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES,
                ParametersPackage.Literals.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES, true, true);
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
            final OperationReference operationReference = this.getOperationReference();
            if (operationReference != null) {
                msgs = ((InternalEObject) operationReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
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
            return this.getOperationReference() != null;
        case ParametersPackage.CALL_INSTANCE__OUTPUT_PARAMETER_INSTANCES:
            return !this.getOutputParameterInstances().isEmpty();
        case ParametersPackage.CALL_INSTANCE__NUMBER_OF_CALLS:
            return this.getNumberOfCalls() != NUMBER_OF_CALLS_EDEFAULT;
        case ParametersPackage.CALL_INSTANCE__INPUT_PARAMETER_INSTANCES:
            return !this.getInputParameterInstances().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // CallInstanceImpl
