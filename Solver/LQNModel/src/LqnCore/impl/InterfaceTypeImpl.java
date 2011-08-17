/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore.impl;

import LqnCore.InPortType;
import LqnCore.InterfaceType;
import LqnCore.LqnCorePackage;
import LqnCore.OutPortType;

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
 * An implementation of the model object '<em><b>Interface Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link LqnCore.impl.InterfaceTypeImpl#getInPort <em>In Port</em>}</li>
 *   <li>{@link LqnCore.impl.InterfaceTypeImpl#getOutPort <em>Out Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceTypeImpl extends EObjectImpl implements InterfaceType {
	/**
	 * The cached value of the '{@link #getInPort() <em>In Port</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInPort()
	 * @generated
	 * @ordered
	 */
	protected EList<InPortType> inPort;

	/**
	 * The cached value of the '{@link #getOutPort() <em>Out Port</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutPort()
	 * @generated
	 * @ordered
	 */
	protected EList<OutPortType> outPort;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LqnCorePackage.Literals.INTERFACE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InPortType> getInPort() {
		if (inPort == null) {
			inPort = new EObjectContainmentEList<InPortType>(InPortType.class, this, LqnCorePackage.INTERFACE_TYPE__IN_PORT);
		}
		return inPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutPortType> getOutPort() {
		if (outPort == null) {
			outPort = new EObjectContainmentEList<OutPortType>(OutPortType.class, this, LqnCorePackage.INTERFACE_TYPE__OUT_PORT);
		}
		return outPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LqnCorePackage.INTERFACE_TYPE__IN_PORT:
				return ((InternalEList<?>)getInPort()).basicRemove(otherEnd, msgs);
			case LqnCorePackage.INTERFACE_TYPE__OUT_PORT:
				return ((InternalEList<?>)getOutPort()).basicRemove(otherEnd, msgs);
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
			case LqnCorePackage.INTERFACE_TYPE__IN_PORT:
				return getInPort();
			case LqnCorePackage.INTERFACE_TYPE__OUT_PORT:
				return getOutPort();
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
			case LqnCorePackage.INTERFACE_TYPE__IN_PORT:
				getInPort().clear();
				getInPort().addAll((Collection<? extends InPortType>)newValue);
				return;
			case LqnCorePackage.INTERFACE_TYPE__OUT_PORT:
				getOutPort().clear();
				getOutPort().addAll((Collection<? extends OutPortType>)newValue);
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
			case LqnCorePackage.INTERFACE_TYPE__IN_PORT:
				getInPort().clear();
				return;
			case LqnCorePackage.INTERFACE_TYPE__OUT_PORT:
				getOutPort().clear();
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
			case LqnCorePackage.INTERFACE_TYPE__IN_PORT:
				return inPort != null && !inPort.isEmpty();
			case LqnCorePackage.INTERFACE_TYPE__OUT_PORT:
				return outPort != null && !outPort.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InterfaceTypeImpl
