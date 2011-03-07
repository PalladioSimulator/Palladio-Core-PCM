/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.experiment.impl;

import de.uka.ipd.sdq.capra.core.ResourceUsage;
import de.uka.ipd.sdq.capra.core.VariableResourceUsage;

import de.uka.ipd.sdq.capra.experiment.ExperimentPackage;
import de.uka.ipd.sdq.capra.experiment.ResourceUsageSpecification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Usage Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.experiment.impl.ResourceUsageSpecificationImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.experiment.impl.ResourceUsageSpecificationImpl#getResourceUsageSpecification <em>Resource Usage Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceUsageSpecificationImpl extends EObjectImpl implements ResourceUsageSpecification {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableResourceUsage variable;

	/**
	 * The cached value of the '{@link #getResourceUsageSpecification() <em>Resource Usage Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUsageSpecification()
	 * @generated
	 * @ordered
	 */
	protected ResourceUsage resourceUsageSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceUsageSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExperimentPackage.Literals.RESOURCE_USAGE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableResourceUsage getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject)variable;
			variable = (VariableResourceUsage)eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentPackage.RESOURCE_USAGE_SPECIFICATION__VARIABLE, oldVariable, variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableResourceUsage basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(VariableResourceUsage newVariable) {
		VariableResourceUsage oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentPackage.RESOURCE_USAGE_SPECIFICATION__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceUsage getResourceUsageSpecification() {
		return resourceUsageSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceUsageSpecification(ResourceUsage newResourceUsageSpecification, NotificationChain msgs) {
		ResourceUsage oldResourceUsageSpecification = resourceUsageSpecification;
		resourceUsageSpecification = newResourceUsageSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExperimentPackage.RESOURCE_USAGE_SPECIFICATION__RESOURCE_USAGE_SPECIFICATION, oldResourceUsageSpecification, newResourceUsageSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceUsageSpecification(ResourceUsage newResourceUsageSpecification) {
		if (newResourceUsageSpecification != resourceUsageSpecification) {
			NotificationChain msgs = null;
			if (resourceUsageSpecification != null)
				msgs = ((InternalEObject)resourceUsageSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExperimentPackage.RESOURCE_USAGE_SPECIFICATION__RESOURCE_USAGE_SPECIFICATION, null, msgs);
			if (newResourceUsageSpecification != null)
				msgs = ((InternalEObject)newResourceUsageSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExperimentPackage.RESOURCE_USAGE_SPECIFICATION__RESOURCE_USAGE_SPECIFICATION, null, msgs);
			msgs = basicSetResourceUsageSpecification(newResourceUsageSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentPackage.RESOURCE_USAGE_SPECIFICATION__RESOURCE_USAGE_SPECIFICATION, newResourceUsageSpecification, newResourceUsageSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExperimentPackage.RESOURCE_USAGE_SPECIFICATION__RESOURCE_USAGE_SPECIFICATION:
				return basicSetResourceUsageSpecification(null, msgs);
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
			case ExperimentPackage.RESOURCE_USAGE_SPECIFICATION__VARIABLE:
				if (resolve) return getVariable();
				return basicGetVariable();
			case ExperimentPackage.RESOURCE_USAGE_SPECIFICATION__RESOURCE_USAGE_SPECIFICATION:
				return getResourceUsageSpecification();
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
			case ExperimentPackage.RESOURCE_USAGE_SPECIFICATION__VARIABLE:
				setVariable((VariableResourceUsage)newValue);
				return;
			case ExperimentPackage.RESOURCE_USAGE_SPECIFICATION__RESOURCE_USAGE_SPECIFICATION:
				setResourceUsageSpecification((ResourceUsage)newValue);
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
			case ExperimentPackage.RESOURCE_USAGE_SPECIFICATION__VARIABLE:
				setVariable((VariableResourceUsage)null);
				return;
			case ExperimentPackage.RESOURCE_USAGE_SPECIFICATION__RESOURCE_USAGE_SPECIFICATION:
				setResourceUsageSpecification((ResourceUsage)null);
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
			case ExperimentPackage.RESOURCE_USAGE_SPECIFICATION__VARIABLE:
				return variable != null;
			case ExperimentPackage.RESOURCE_USAGE_SPECIFICATION__RESOURCE_USAGE_SPECIFICATION:
				return resourceUsageSpecification != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceUsageSpecificationImpl
