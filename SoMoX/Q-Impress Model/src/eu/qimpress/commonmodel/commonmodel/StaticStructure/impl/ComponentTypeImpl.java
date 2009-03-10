/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure.impl;

import eu.qimpress.commonmodel.commonmodel.Behavior.Behavior;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Port;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ComponentTypeImpl#getRequired <em>Required</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ComponentTypeImpl#getProvided <em>Provided</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ComponentTypeImpl#getBehaviour <em>Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComponentTypeImpl extends NamedEntityImpl implements ComponentType {
	/**
	 * The cached value of the '{@link #getRequired() <em>Required</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequired()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> required;

	/**
	 * The cached value of the '{@link #getProvided() <em>Provided</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvided()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> provided;

	/**
	 * The cached value of the '{@link #getBehaviour() <em>Behaviour</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviour()
	 * @generated
	 * @ordered
	 */
	protected EList<Behavior> behaviour;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StaticStructurePackage.Literals.COMPONENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getRequired() {
		if (required == null) {
			required = new EObjectContainmentEList<Port>(Port.class, this, StaticStructurePackage.COMPONENT_TYPE__REQUIRED);
		}
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getProvided() {
		if (provided == null) {
			provided = new EObjectContainmentEList<Port>(Port.class, this, StaticStructurePackage.COMPONENT_TYPE__PROVIDED);
		}
		return provided;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Behavior> getBehaviour() {
		if (behaviour == null) {
			behaviour = new EObjectResolvingEList<Behavior>(Behavior.class, this, StaticStructurePackage.COMPONENT_TYPE__BEHAVIOUR);
		}
		return behaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StaticStructurePackage.COMPONENT_TYPE__REQUIRED:
				return ((InternalEList<?>)getRequired()).basicRemove(otherEnd, msgs);
			case StaticStructurePackage.COMPONENT_TYPE__PROVIDED:
				return ((InternalEList<?>)getProvided()).basicRemove(otherEnd, msgs);
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
			case StaticStructurePackage.COMPONENT_TYPE__REQUIRED:
				return getRequired();
			case StaticStructurePackage.COMPONENT_TYPE__PROVIDED:
				return getProvided();
			case StaticStructurePackage.COMPONENT_TYPE__BEHAVIOUR:
				return getBehaviour();
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
			case StaticStructurePackage.COMPONENT_TYPE__REQUIRED:
				getRequired().clear();
				getRequired().addAll((Collection<? extends Port>)newValue);
				return;
			case StaticStructurePackage.COMPONENT_TYPE__PROVIDED:
				getProvided().clear();
				getProvided().addAll((Collection<? extends Port>)newValue);
				return;
			case StaticStructurePackage.COMPONENT_TYPE__BEHAVIOUR:
				getBehaviour().clear();
				getBehaviour().addAll((Collection<? extends Behavior>)newValue);
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
			case StaticStructurePackage.COMPONENT_TYPE__REQUIRED:
				getRequired().clear();
				return;
			case StaticStructurePackage.COMPONENT_TYPE__PROVIDED:
				getProvided().clear();
				return;
			case StaticStructurePackage.COMPONENT_TYPE__BEHAVIOUR:
				getBehaviour().clear();
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
			case StaticStructurePackage.COMPONENT_TYPE__REQUIRED:
				return required != null && !required.isEmpty();
			case StaticStructurePackage.COMPONENT_TYPE__PROVIDED:
				return provided != null && !provided.isEmpty();
			case StaticStructurePackage.COMPONENT_TYPE__BEHAVIOUR:
				return behaviour != null && !behaviour.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComponentTypeImpl
