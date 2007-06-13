
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scenario Behaviour</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.ScenarioBehaviourImpl#getActions_ScenarioBehaviour <em>Actions Scenario Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScenarioBehaviourImpl extends EntityImpl implements ScenarioBehaviour {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getActions_ScenarioBehaviour() <em>Actions Scenario Behaviour</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions_ScenarioBehaviour()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractUserAction> actions_ScenarioBehaviour;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScenarioBehaviourImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsagemodelPackage.Literals.SCENARIO_BEHAVIOUR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractUserAction> getActions_ScenarioBehaviour() {
		if (actions_ScenarioBehaviour == null) {
			actions_ScenarioBehaviour = new EObjectContainmentEList<AbstractUserAction>(AbstractUserAction.class, this, UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR);
		}
		return actions_ScenarioBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
				return ((InternalEList<?>)getActions_ScenarioBehaviour()).basicRemove(otherEnd, msgs);
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
			case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
				return getActions_ScenarioBehaviour();
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
			case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
				getActions_ScenarioBehaviour().clear();
				getActions_ScenarioBehaviour().addAll((Collection<? extends AbstractUserAction>)newValue);
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
			case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
				getActions_ScenarioBehaviour().clear();
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
			case UsagemodelPackage.SCENARIO_BEHAVIOUR__ACTIONS_SCENARIO_BEHAVIOUR:
				return actions_ScenarioBehaviour != null && !actions_ScenarioBehaviour.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ScenarioBehaviourImpl
