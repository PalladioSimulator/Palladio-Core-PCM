/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore.impl;

import LqnCore.LqnCorePackage;
import LqnCore.OutPortType;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Out Port Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link LqnCore.impl.OutPortTypeImpl#getConnectTo <em>Connect To</em>}</li>
 *   <li>{@link LqnCore.impl.OutPortTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link LqnCore.impl.OutPortTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutPortTypeImpl extends EObjectImpl implements OutPortType {
	/**
	 * The default value of the '{@link #getConnectTo() <em>Connect To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectTo()
	 * @generated
	 * @ordered
	 */
	protected static final List<String> CONNECT_TO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectTo() <em>Connect To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectTo()
	 * @generated
	 * @ordered
	 */
	protected List<String> connectTo = CONNECT_TO_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutPortTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LqnCorePackage.Literals.OUT_PORT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<String> getConnectTo() {
		return connectTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectTo(List<String> newConnectTo) {
		List<String> oldConnectTo = connectTo;
		connectTo = newConnectTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LqnCorePackage.OUT_PORT_TYPE__CONNECT_TO, oldConnectTo, connectTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LqnCorePackage.OUT_PORT_TYPE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LqnCorePackage.OUT_PORT_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LqnCorePackage.OUT_PORT_TYPE__CONNECT_TO:
				return getConnectTo();
			case LqnCorePackage.OUT_PORT_TYPE__DESCRIPTION:
				return getDescription();
			case LqnCorePackage.OUT_PORT_TYPE__NAME:
				return getName();
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
			case LqnCorePackage.OUT_PORT_TYPE__CONNECT_TO:
				setConnectTo((List<String>)newValue);
				return;
			case LqnCorePackage.OUT_PORT_TYPE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case LqnCorePackage.OUT_PORT_TYPE__NAME:
				setName((String)newValue);
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
			case LqnCorePackage.OUT_PORT_TYPE__CONNECT_TO:
				setConnectTo(CONNECT_TO_EDEFAULT);
				return;
			case LqnCorePackage.OUT_PORT_TYPE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case LqnCorePackage.OUT_PORT_TYPE__NAME:
				setName(NAME_EDEFAULT);
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
			case LqnCorePackage.OUT_PORT_TYPE__CONNECT_TO:
				return CONNECT_TO_EDEFAULT == null ? connectTo != null : !CONNECT_TO_EDEFAULT.equals(connectTo);
			case LqnCorePackage.OUT_PORT_TYPE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case LqnCorePackage.OUT_PORT_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (connectTo: ");
		result.append(connectTo);
		result.append(", description: ");
		result.append(description);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //OutPortTypeImpl
