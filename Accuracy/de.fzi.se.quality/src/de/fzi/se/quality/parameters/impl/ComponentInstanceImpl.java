/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import de.fzi.se.quality.parameters.ComponentInstance;
import de.fzi.se.quality.parameters.ComponentReference;
import de.fzi.se.quality.parameters.ParameterInstance;
import de.fzi.se.quality.parameters.ParametersPackage;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.impl.ComponentInstanceImpl#getComponentReference <em>Component Reference</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.impl.ComponentInstanceImpl#getParameterInstances <em>Parameter Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentInstanceImpl extends IdentifierImpl implements ComponentInstance {
	/**
	 * The cached value of the '{@link #getComponentReference() <em>Component Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentReference()
	 * @generated
	 * @ordered
	 */
	protected ComponentReference componentReference;

	/**
	 * The cached value of the '{@link #getParameterInstances() <em>Parameter Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterInstance> parameterInstances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParametersPackage.Literals.COMPONENT_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentReference getComponentReference() {
		return componentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentReference(ComponentReference newComponentReference, NotificationChain msgs) {
		ComponentReference oldComponentReference = componentReference;
		componentReference = newComponentReference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE, oldComponentReference, newComponentReference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentReference(ComponentReference newComponentReference) {
		if (newComponentReference != componentReference) {
			NotificationChain msgs = null;
			if (componentReference != null)
				msgs = ((InternalEObject)componentReference).eInverseRemove(this, ParametersPackage.COMPONENT_REFERENCE__COMPONENT_INSTANCE, ComponentReference.class, msgs);
			if (newComponentReference != null)
				msgs = ((InternalEObject)newComponentReference).eInverseAdd(this, ParametersPackage.COMPONENT_REFERENCE__COMPONENT_INSTANCE, ComponentReference.class, msgs);
			msgs = basicSetComponentReference(newComponentReference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE, newComponentReference, newComponentReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterInstance> getParameterInstances() {
		if (parameterInstances == null) {
			parameterInstances = new EObjectContainmentWithInverseEList<ParameterInstance>(ParameterInstance.class, this, ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES, ParametersPackage.PARAMETER_INSTANCE__COMPONENT_INSTANCE);
		}
		return parameterInstances;
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
			case ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE:
				if (componentReference != null)
					msgs = ((InternalEObject)componentReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE, null, msgs);
				return basicSetComponentReference((ComponentReference)otherEnd, msgs);
			case ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameterInstances()).basicAdd(otherEnd, msgs);
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
			case ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE:
				return basicSetComponentReference(null, msgs);
			case ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES:
				return ((InternalEList<?>)getParameterInstances()).basicRemove(otherEnd, msgs);
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
			case ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE:
				return getComponentReference();
			case ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES:
				return getParameterInstances();
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
			case ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE:
				setComponentReference((ComponentReference)newValue);
				return;
			case ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES:
				getParameterInstances().clear();
				getParameterInstances().addAll((Collection<? extends ParameterInstance>)newValue);
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
			case ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE:
				setComponentReference((ComponentReference)null);
				return;
			case ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES:
				getParameterInstances().clear();
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
			case ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE:
				return componentReference != null;
			case ParametersPackage.COMPONENT_INSTANCE__PARAMETER_INSTANCES:
				return parameterInstances != null && !parameterInstances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComponentInstanceImpl
