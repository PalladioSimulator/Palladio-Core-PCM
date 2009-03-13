/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench.impl;

import de.uka.ipd.sdq.ByBench.ByBenchPackage;
import de.uka.ipd.sdq.ByBench.InstructionChaining;
import de.uka.ipd.sdq.ByBench.InstructionLooping;
import de.uka.ipd.sdq.ByBench.NamedCardinality;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Cardinality</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.NamedCardinalityImpl#getCardinalityValue <em>Cardinality Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.NamedCardinalityImpl#getCardinalityName <em>Cardinality Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.NamedCardinalityImpl#getInstructionchaining <em>Instructionchaining</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.NamedCardinalityImpl#getInstructionlooping <em>Instructionlooping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamedCardinalityImpl extends IdentifierImpl implements NamedCardinality {
	/**
	 * The default value of the '{@link #getCardinalityValue() <em>Cardinality Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardinalityValue()
	 * @generated
	 * @ordered
	 */
	protected static final int CARDINALITY_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCardinalityValue() <em>Cardinality Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardinalityValue()
	 * @generated
	 * @ordered
	 */
	protected int cardinalityValue = CARDINALITY_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCardinalityName() <em>Cardinality Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardinalityName()
	 * @generated
	 * @ordered
	 */
	protected static final String CARDINALITY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCardinalityName() <em>Cardinality Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCardinalityName()
	 * @generated
	 * @ordered
	 */
	protected String cardinalityName = CARDINALITY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInstructionchaining() <em>Instructionchaining</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstructionchaining()
	 * @generated
	 * @ordered
	 */
	protected EList<InstructionChaining> instructionchaining;

	/**
	 * The cached value of the '{@link #getInstructionlooping() <em>Instructionlooping</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstructionlooping()
	 * @generated
	 * @ordered
	 */
	protected EList<InstructionLooping> instructionlooping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedCardinalityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ByBenchPackage.Literals.NAMED_CARDINALITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCardinalityValue() {
		return cardinalityValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCardinalityValue(int newCardinalityValue) {
		int oldCardinalityValue = cardinalityValue;
		cardinalityValue = newCardinalityValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ByBenchPackage.NAMED_CARDINALITY__CARDINALITY_VALUE, oldCardinalityValue, cardinalityValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCardinalityName() {
		return cardinalityName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCardinalityName(String newCardinalityName) {
		String oldCardinalityName = cardinalityName;
		cardinalityName = newCardinalityName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ByBenchPackage.NAMED_CARDINALITY__CARDINALITY_NAME, oldCardinalityName, cardinalityName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstructionChaining> getInstructionchaining() {
		if (instructionchaining == null) {
			instructionchaining = new EObjectWithInverseResolvingEList<InstructionChaining>(InstructionChaining.class, this, ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONCHAINING, ByBenchPackage.INSTRUCTION_CHAINING__NAMEDCARDINALITY);
		}
		return instructionchaining;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstructionLooping> getInstructionlooping() {
		if (instructionlooping == null) {
			instructionlooping = new EObjectWithInverseResolvingEList<InstructionLooping>(InstructionLooping.class, this, ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONLOOPING, ByBenchPackage.INSTRUCTION_LOOPING__NAMEDCARDINALITY);
		}
		return instructionlooping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONCHAINING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInstructionchaining()).basicAdd(otherEnd, msgs);
			case ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONLOOPING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInstructionlooping()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONCHAINING:
				return ((InternalEList<?>)getInstructionchaining()).basicRemove(otherEnd, msgs);
			case ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONLOOPING:
				return ((InternalEList<?>)getInstructionlooping()).basicRemove(otherEnd, msgs);
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
			case ByBenchPackage.NAMED_CARDINALITY__CARDINALITY_VALUE:
				return new Integer(getCardinalityValue());
			case ByBenchPackage.NAMED_CARDINALITY__CARDINALITY_NAME:
				return getCardinalityName();
			case ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONCHAINING:
				return getInstructionchaining();
			case ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONLOOPING:
				return getInstructionlooping();
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
			case ByBenchPackage.NAMED_CARDINALITY__CARDINALITY_VALUE:
				setCardinalityValue(((Integer)newValue).intValue());
				return;
			case ByBenchPackage.NAMED_CARDINALITY__CARDINALITY_NAME:
				setCardinalityName((String)newValue);
				return;
			case ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONCHAINING:
				getInstructionchaining().clear();
				getInstructionchaining().addAll((Collection<? extends InstructionChaining>)newValue);
				return;
			case ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONLOOPING:
				getInstructionlooping().clear();
				getInstructionlooping().addAll((Collection<? extends InstructionLooping>)newValue);
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
			case ByBenchPackage.NAMED_CARDINALITY__CARDINALITY_VALUE:
				setCardinalityValue(CARDINALITY_VALUE_EDEFAULT);
				return;
			case ByBenchPackage.NAMED_CARDINALITY__CARDINALITY_NAME:
				setCardinalityName(CARDINALITY_NAME_EDEFAULT);
				return;
			case ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONCHAINING:
				getInstructionchaining().clear();
				return;
			case ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONLOOPING:
				getInstructionlooping().clear();
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
			case ByBenchPackage.NAMED_CARDINALITY__CARDINALITY_VALUE:
				return cardinalityValue != CARDINALITY_VALUE_EDEFAULT;
			case ByBenchPackage.NAMED_CARDINALITY__CARDINALITY_NAME:
				return CARDINALITY_NAME_EDEFAULT == null ? cardinalityName != null : !CARDINALITY_NAME_EDEFAULT.equals(cardinalityName);
			case ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONCHAINING:
				return instructionchaining != null && !instructionchaining.isEmpty();
			case ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONLOOPING:
				return instructionlooping != null && !instructionlooping.isEmpty();
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
		result.append(" (cardinalityValue: ");
		result.append(cardinalityValue);
		result.append(", cardinalityName: ");
		result.append(cardinalityName);
		result.append(')');
		return result.toString();
	}

} //NamedCardinalityImpl
