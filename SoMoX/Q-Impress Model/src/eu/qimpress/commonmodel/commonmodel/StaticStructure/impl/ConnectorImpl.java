/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure.impl;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.EndPoint;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ConnectorImpl#isIsDelegation <em>Is Delegation</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ConnectorImpl#getEndpoints <em>Endpoints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectorImpl extends EntityImpl implements Connector {
	/**
	 * The default value of the '{@link #isIsDelegation() <em>Is Delegation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDelegation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DELEGATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getEndpoints() <em>Endpoints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<EndPoint> endpoints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StaticStructurePackage.Literals.CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDelegation() {
		// TODO: implement this method to return the 'Is Delegation' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndPoint> getEndpoints() {
		if (endpoints == null) {
			endpoints = new EObjectContainmentEList<EndPoint>(EndPoint.class, this, StaticStructurePackage.CONNECTOR__ENDPOINTS);
		}
		return endpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StaticStructurePackage.CONNECTOR__ENDPOINTS:
				return ((InternalEList<?>)getEndpoints()).basicRemove(otherEnd, msgs);
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
			case StaticStructurePackage.CONNECTOR__IS_DELEGATION:
				return isIsDelegation() ? Boolean.TRUE : Boolean.FALSE;
			case StaticStructurePackage.CONNECTOR__ENDPOINTS:
				return getEndpoints();
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
			case StaticStructurePackage.CONNECTOR__ENDPOINTS:
				getEndpoints().clear();
				getEndpoints().addAll((Collection<? extends EndPoint>)newValue);
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
			case StaticStructurePackage.CONNECTOR__ENDPOINTS:
				getEndpoints().clear();
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
			case StaticStructurePackage.CONNECTOR__IS_DELEGATION:
				return isIsDelegation() != IS_DELEGATION_EDEFAULT;
			case StaticStructurePackage.CONNECTOR__ENDPOINTS:
				return endpoints != null && !endpoints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConnectorImpl
