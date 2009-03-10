/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure.impl;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation;
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
 * An implementation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.InterfaceImpl#getSignatures <em>Signatures</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.InterfaceImpl#getInheritance <em>Inheritance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceImpl extends NamedEntityImpl implements Interface {
	/**
	 * The cached value of the '{@link #getSignatures() <em>Signatures</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> signatures;

	/**
	 * The cached value of the '{@link #getInheritance() <em>Inheritance</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritance()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> inheritance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StaticStructurePackage.Literals.INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getSignatures() {
		if (signatures == null) {
			signatures = new EObjectContainmentEList<Operation>(Operation.class, this, StaticStructurePackage.INTERFACE__SIGNATURES);
		}
		return signatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getInheritance() {
		if (inheritance == null) {
			inheritance = new EObjectResolvingEList<Interface>(Interface.class, this, StaticStructurePackage.INTERFACE__INHERITANCE);
		}
		return inheritance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StaticStructurePackage.INTERFACE__SIGNATURES:
				return ((InternalEList<?>)getSignatures()).basicRemove(otherEnd, msgs);
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
			case StaticStructurePackage.INTERFACE__SIGNATURES:
				return getSignatures();
			case StaticStructurePackage.INTERFACE__INHERITANCE:
				return getInheritance();
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
			case StaticStructurePackage.INTERFACE__SIGNATURES:
				getSignatures().clear();
				getSignatures().addAll((Collection<? extends Operation>)newValue);
				return;
			case StaticStructurePackage.INTERFACE__INHERITANCE:
				getInheritance().clear();
				getInheritance().addAll((Collection<? extends Interface>)newValue);
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
			case StaticStructurePackage.INTERFACE__SIGNATURES:
				getSignatures().clear();
				return;
			case StaticStructurePackage.INTERFACE__INHERITANCE:
				getInheritance().clear();
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
			case StaticStructurePackage.INTERFACE__SIGNATURES:
				return signatures != null && !signatures.isEmpty();
			case StaticStructurePackage.INTERFACE__INHERITANCE:
				return inheritance != null && !inheritance.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InterfaceImpl
