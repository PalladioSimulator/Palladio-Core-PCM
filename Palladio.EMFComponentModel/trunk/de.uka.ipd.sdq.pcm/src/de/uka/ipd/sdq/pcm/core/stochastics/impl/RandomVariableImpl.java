
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.stochastics.impl;

import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;
import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Random Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.RandomVariableImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.RandomVariableImpl#getSpecification_RandomVariable <em>Specification Random Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RandomVariableImpl extends EObjectImpl implements RandomVariable {
	/**
	 * The default value of the '{@link #getSpecification() <em>Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIFICATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected String specification = SPECIFICATION_EDEFAULT;


	/**
	 * The cached value of the '{@link #getSpecification_RandomVariable() <em>Specification Random Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification_RandomVariable()
	 * @generated
	 * @ordered
	 */
	protected Expression specification_RandomVariable = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RandomVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return StochasticsPackage.Literals.RANDOM_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecification() {
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification(String newSpecification) {
		String oldSpecification = specification;
		specification = newSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION, oldSpecification, specification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getSpecification_RandomVariable() {
		return specification_RandomVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecification_RandomVariable(Expression newSpecification_RandomVariable, NotificationChain msgs) {
		Expression oldSpecification_RandomVariable = specification_RandomVariable;
		specification_RandomVariable = newSpecification_RandomVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION_RANDOM_VARIABLE, oldSpecification_RandomVariable, newSpecification_RandomVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification_RandomVariable(Expression newSpecification_RandomVariable) {
		if (newSpecification_RandomVariable != specification_RandomVariable) {
			NotificationChain msgs = null;
			if (specification_RandomVariable != null)
				msgs = ((InternalEObject)specification_RandomVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION_RANDOM_VARIABLE, null, msgs);
			if (newSpecification_RandomVariable != null)
				msgs = ((InternalEObject)newSpecification_RandomVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION_RANDOM_VARIABLE, null, msgs);
			msgs = basicSetSpecification_RandomVariable(newSpecification_RandomVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION_RANDOM_VARIABLE, newSpecification_RandomVariable, newSpecification_RandomVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION_RANDOM_VARIABLE:
				return basicSetSpecification_RandomVariable(null, msgs);
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
			case StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION:
				return getSpecification();
			case StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION_RANDOM_VARIABLE:
				return getSpecification_RandomVariable();
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
			case StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION:
				setSpecification((String)newValue);
				return;
			case StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION_RANDOM_VARIABLE:
				setSpecification_RandomVariable((Expression)newValue);
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
			case StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION:
				setSpecification(SPECIFICATION_EDEFAULT);
				return;
			case StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION_RANDOM_VARIABLE:
				setSpecification_RandomVariable((Expression)null);
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
			case StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION:
				return SPECIFICATION_EDEFAULT == null ? specification != null : !SPECIFICATION_EDEFAULT.equals(specification);
			case StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION_RANDOM_VARIABLE:
				return specification_RandomVariable != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (specification: ");
		result.append(specification);
		result.append(')');
		return result.toString();
	}

} //RandomVariableImpl