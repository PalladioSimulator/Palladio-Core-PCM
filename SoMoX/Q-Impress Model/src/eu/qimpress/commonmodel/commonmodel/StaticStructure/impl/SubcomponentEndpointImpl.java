/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure.impl;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.Port;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentInstance;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subcomponent Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.SubcomponentEndpointImpl#getSubcomponent <em>Subcomponent</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.SubcomponentEndpointImpl#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubcomponentEndpointImpl extends EndPointImpl implements SubcomponentEndpoint {
	/**
	 * The cached value of the '{@link #getSubcomponent() <em>Subcomponent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubcomponent()
	 * @generated
	 * @ordered
	 */
	protected SubcomponentInstance subcomponent;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected Port port;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubcomponentEndpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StaticStructurePackage.Literals.SUBCOMPONENT_ENDPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubcomponentInstance getSubcomponent() {
		if (subcomponent != null && subcomponent.eIsProxy()) {
			InternalEObject oldSubcomponent = (InternalEObject)subcomponent;
			subcomponent = (SubcomponentInstance)eResolveProxy(oldSubcomponent);
			if (subcomponent != oldSubcomponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StaticStructurePackage.SUBCOMPONENT_ENDPOINT__SUBCOMPONENT, oldSubcomponent, subcomponent));
			}
		}
		return subcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubcomponentInstance basicGetSubcomponent() {
		return subcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubcomponent(SubcomponentInstance newSubcomponent) {
		SubcomponentInstance oldSubcomponent = subcomponent;
		subcomponent = newSubcomponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StaticStructurePackage.SUBCOMPONENT_ENDPOINT__SUBCOMPONENT, oldSubcomponent, subcomponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getPort() {
		if (port != null && port.eIsProxy()) {
			InternalEObject oldPort = (InternalEObject)port;
			port = (Port)eResolveProxy(oldPort);
			if (port != oldPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StaticStructurePackage.SUBCOMPONENT_ENDPOINT__PORT, oldPort, port));
			}
		}
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(Port newPort) {
		Port oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StaticStructurePackage.SUBCOMPONENT_ENDPOINT__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StaticStructurePackage.SUBCOMPONENT_ENDPOINT__SUBCOMPONENT:
				if (resolve) return getSubcomponent();
				return basicGetSubcomponent();
			case StaticStructurePackage.SUBCOMPONENT_ENDPOINT__PORT:
				if (resolve) return getPort();
				return basicGetPort();
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
			case StaticStructurePackage.SUBCOMPONENT_ENDPOINT__SUBCOMPONENT:
				setSubcomponent((SubcomponentInstance)newValue);
				return;
			case StaticStructurePackage.SUBCOMPONENT_ENDPOINT__PORT:
				setPort((Port)newValue);
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
			case StaticStructurePackage.SUBCOMPONENT_ENDPOINT__SUBCOMPONENT:
				setSubcomponent((SubcomponentInstance)null);
				return;
			case StaticStructurePackage.SUBCOMPONENT_ENDPOINT__PORT:
				setPort((Port)null);
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
			case StaticStructurePackage.SUBCOMPONENT_ENDPOINT__SUBCOMPONENT:
				return subcomponent != null;
			case StaticStructurePackage.SUBCOMPONENT_ENDPOINT__PORT:
				return port != null;
		}
		return super.eIsSet(featureID);
	}

} //SubcomponentEndpointImpl
