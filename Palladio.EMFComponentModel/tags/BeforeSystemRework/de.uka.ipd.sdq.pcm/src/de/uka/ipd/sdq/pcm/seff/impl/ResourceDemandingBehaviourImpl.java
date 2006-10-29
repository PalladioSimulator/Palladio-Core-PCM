
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ParametricParameterUsage;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Demanding Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingBehaviourImpl#getSteps_Behaviour <em>Steps Behaviour</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingBehaviourImpl#getParametricResourceDemands_Behaviour <em>Parametric Resource Demands Behaviour</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingBehaviourImpl#getParametricParameterUsage_Behaviour <em>Parametric Parameter Usage Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceDemandingBehaviourImpl extends EObjectImpl implements ResourceDemandingBehaviour {
	/**
	 * The cached value of the '{@link #getSteps_Behaviour() <em>Steps Behaviour</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteps_Behaviour()
	 * @generated
	 * @ordered
	 */
	protected EList steps_Behaviour = null;

	/**
	 * The cached value of the '{@link #getParametricResourceDemands_Behaviour() <em>Parametric Resource Demands Behaviour</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParametricResourceDemands_Behaviour()
	 * @generated
	 * @ordered
	 */
	protected EList parametricResourceDemands_Behaviour = null;

	/**
	 * The cached value of the '{@link #getParametricParameterUsage_Behaviour() <em>Parametric Parameter Usage Behaviour</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParametricParameterUsage_Behaviour()
	 * @generated
	 * @ordered
	 */
	protected EList parametricParameterUsage_Behaviour = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceDemandingBehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSteps_Behaviour() {
		if (steps_Behaviour == null) {
			steps_Behaviour = new EObjectContainmentEList(AbstractAction.class, this, SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR);
		}
		return steps_Behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getParametricResourceDemands_Behaviour() {
		if (parametricResourceDemands_Behaviour == null) {
			parametricResourceDemands_Behaviour = new EObjectContainmentEList(ParametricResourceDemand.class, this, SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__PARAMETRIC_RESOURCE_DEMANDS_BEHAVIOUR);
		}
		return parametricResourceDemands_Behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getParametricParameterUsage_Behaviour() {
		if (parametricParameterUsage_Behaviour == null) {
			parametricParameterUsage_Behaviour = new EObjectContainmentEList(ParametricParameterUsage.class, this, SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__PARAMETRIC_PARAMETER_USAGE_BEHAVIOUR);
		}
		return parametricParameterUsage_Behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR:
				return ((InternalEList)getSteps_Behaviour()).basicRemove(otherEnd, msgs);
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__PARAMETRIC_RESOURCE_DEMANDS_BEHAVIOUR:
				return ((InternalEList)getParametricResourceDemands_Behaviour()).basicRemove(otherEnd, msgs);
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__PARAMETRIC_PARAMETER_USAGE_BEHAVIOUR:
				return ((InternalEList)getParametricParameterUsage_Behaviour()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR:
				return getSteps_Behaviour();
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__PARAMETRIC_RESOURCE_DEMANDS_BEHAVIOUR:
				return getParametricResourceDemands_Behaviour();
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__PARAMETRIC_PARAMETER_USAGE_BEHAVIOUR:
				return getParametricParameterUsage_Behaviour();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR:
				getSteps_Behaviour().clear();
				getSteps_Behaviour().addAll((Collection)newValue);
				return;
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__PARAMETRIC_RESOURCE_DEMANDS_BEHAVIOUR:
				getParametricResourceDemands_Behaviour().clear();
				getParametricResourceDemands_Behaviour().addAll((Collection)newValue);
				return;
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__PARAMETRIC_PARAMETER_USAGE_BEHAVIOUR:
				getParametricParameterUsage_Behaviour().clear();
				getParametricParameterUsage_Behaviour().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR:
				getSteps_Behaviour().clear();
				return;
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__PARAMETRIC_RESOURCE_DEMANDS_BEHAVIOUR:
				getParametricResourceDemands_Behaviour().clear();
				return;
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__PARAMETRIC_PARAMETER_USAGE_BEHAVIOUR:
				getParametricParameterUsage_Behaviour().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR:
				return steps_Behaviour != null && !steps_Behaviour.isEmpty();
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__PARAMETRIC_RESOURCE_DEMANDS_BEHAVIOUR:
				return parametricResourceDemands_Behaviour != null && !parametricResourceDemands_Behaviour.isEmpty();
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__PARAMETRIC_PARAMETER_USAGE_BEHAVIOUR:
				return parametricParameterUsage_Behaviour != null && !parametricParameterUsage_Behaviour.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ResourceDemandingBehaviourImpl