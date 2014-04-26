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
import de.fzi.se.quality.parameters.OperationReference;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.impl.OperationReferenceImpl#getCallInstance <em>Call Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OperationReferenceImpl extends IdentifierImpl implements OperationReference {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected OperationReferenceImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ParametersPackage.Literals.OPERATION_REFERENCE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CallInstance getCallInstance() {
        if (eContainerFeatureID() != ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE) return null;
        return (CallInstance)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetCallInstance(CallInstance newCallInstance, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newCallInstance, ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCallInstance(CallInstance newCallInstance) {
        if (newCallInstance != eInternalContainer() || (eContainerFeatureID() != ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE && newCallInstance != null)) {
            if (EcoreUtil.isAncestor(this, newCallInstance))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newCallInstance != null)
                msgs = ((InternalEObject)newCallInstance).eInverseAdd(this, ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE, CallInstance.class, msgs);
            msgs = basicSetCallInstance(newCallInstance, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE, newCallInstance, newCallInstance));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetCallInstance((CallInstance)otherEnd, msgs);
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
            case ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE:
                return basicSetCallInstance(null, msgs);
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
            case ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE:
                return eInternalContainer().eInverseRemove(this, ParametersPackage.CALL_INSTANCE__OPERATION_REFERENCE, CallInstance.class, msgs);
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
            case ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE:
                return getCallInstance();
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
            case ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE:
                setCallInstance((CallInstance)newValue);
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
            case ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE:
                setCallInstance((CallInstance)null);
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
            case ParametersPackage.OPERATION_REFERENCE__CALL_INSTANCE:
                return getCallInstance() != null;
        }
        return super.eIsSet(featureID);
    }

} //OperationReferenceImpl
