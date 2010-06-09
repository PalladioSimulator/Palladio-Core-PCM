/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package StoExAlternatives.impl;

import StoExAlternatives.ExpressionProxy;
import StoExAlternatives.ProxyRepository;
import StoExAlternatives.StoExAlternativesPackage;
import StoExAlternatives.StoExPart;

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
 * An implementation of the model object '<em><b>Proxy Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link StoExAlternatives.impl.ProxyRepositoryImpl#getExpressionProxy <em>Expression Proxy</em>}</li>
 *   <li>{@link StoExAlternatives.impl.ProxyRepositoryImpl#getStoExPart <em>Sto Ex Part</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProxyRepositoryImpl extends EObjectImpl implements ProxyRepository {
	/**
	 * The cached value of the '{@link #getExpressionProxy() <em>Expression Proxy</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionProxy()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpressionProxy> expressionProxy;

	/**
	 * The cached value of the '{@link #getStoExPart() <em>Sto Ex Part</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStoExPart()
	 * @generated
	 * @ordered
	 */
	protected EList<StoExPart> stoExPart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProxyRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoExAlternativesPackage.Literals.PROXY_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpressionProxy> getExpressionProxy() {
		if (expressionProxy == null) {
			expressionProxy = new EObjectContainmentEList<ExpressionProxy>(ExpressionProxy.class, this, StoExAlternativesPackage.PROXY_REPOSITORY__EXPRESSION_PROXY);
		}
		return expressionProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StoExPart> getStoExPart() {
		if (stoExPart == null) {
			stoExPart = new EObjectContainmentEList<StoExPart>(StoExPart.class, this, StoExAlternativesPackage.PROXY_REPOSITORY__STO_EX_PART);
		}
		return stoExPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoExAlternativesPackage.PROXY_REPOSITORY__EXPRESSION_PROXY:
				return ((InternalEList<?>)getExpressionProxy()).basicRemove(otherEnd, msgs);
			case StoExAlternativesPackage.PROXY_REPOSITORY__STO_EX_PART:
				return ((InternalEList<?>)getStoExPart()).basicRemove(otherEnd, msgs);
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
			case StoExAlternativesPackage.PROXY_REPOSITORY__EXPRESSION_PROXY:
				return getExpressionProxy();
			case StoExAlternativesPackage.PROXY_REPOSITORY__STO_EX_PART:
				return getStoExPart();
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
			case StoExAlternativesPackage.PROXY_REPOSITORY__EXPRESSION_PROXY:
				getExpressionProxy().clear();
				getExpressionProxy().addAll((Collection<? extends ExpressionProxy>)newValue);
				return;
			case StoExAlternativesPackage.PROXY_REPOSITORY__STO_EX_PART:
				getStoExPart().clear();
				getStoExPart().addAll((Collection<? extends StoExPart>)newValue);
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
			case StoExAlternativesPackage.PROXY_REPOSITORY__EXPRESSION_PROXY:
				getExpressionProxy().clear();
				return;
			case StoExAlternativesPackage.PROXY_REPOSITORY__STO_EX_PART:
				getStoExPart().clear();
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
			case StoExAlternativesPackage.PROXY_REPOSITORY__EXPRESSION_PROXY:
				return expressionProxy != null && !expressionProxy.isEmpty();
			case StoExAlternativesPackage.PROXY_REPOSITORY__STO_EX_PART:
				return stoExPart != null && !stoExPart.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProxyRepositoryImpl
