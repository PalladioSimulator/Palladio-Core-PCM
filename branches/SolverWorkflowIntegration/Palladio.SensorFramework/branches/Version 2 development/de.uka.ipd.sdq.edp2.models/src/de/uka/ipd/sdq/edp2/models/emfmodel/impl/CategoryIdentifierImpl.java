/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.CategoryIdentifier;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Category Identifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.CategoryIdentifierImpl#getStateLiteral <em>State Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CategoryIdentifierImpl extends IdentifiableImpl implements CategoryIdentifier {
	/**
	 * The default value of the '{@link #getStateLiteral() <em>State Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String STATE_LITERAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStateLiteral() <em>State Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateLiteral()
	 * @generated
	 * @ordered
	 */
	protected String stateLiteral = STATE_LITERAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CategoryIdentifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.CATEGORY_IDENTIFIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStateLiteral() {
		return stateLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateLiteral(String newStateLiteral) {
		String oldStateLiteral = stateLiteral;
		stateLiteral = newStateLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.CATEGORY_IDENTIFIER__STATE_LITERAL, oldStateLiteral, stateLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfmodelPackage.CATEGORY_IDENTIFIER__STATE_LITERAL:
				return getStateLiteral();
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
			case EmfmodelPackage.CATEGORY_IDENTIFIER__STATE_LITERAL:
				setStateLiteral((String)newValue);
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
			case EmfmodelPackage.CATEGORY_IDENTIFIER__STATE_LITERAL:
				setStateLiteral(STATE_LITERAL_EDEFAULT);
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
			case EmfmodelPackage.CATEGORY_IDENTIFIER__STATE_LITERAL:
				return STATE_LITERAL_EDEFAULT == null ? stateLiteral != null : !STATE_LITERAL_EDEFAULT.equals(stateLiteral);
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
		result.append(" (stateLiteral: ");
		result.append(stateLiteral);
		result.append(')');
		return result.toString();
	}

} //CategoryIdentifierImpl
