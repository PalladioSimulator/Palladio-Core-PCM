/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench.impl;

import de.uka.ipd.sdq.ByBench.ByBenchPackage;
import de.uka.ipd.sdq.ByBench.InstructionLooping;
import de.uka.ipd.sdq.ByBench.InstructionSequence;
import de.uka.ipd.sdq.ByBench.NamedCardinality;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instruction Looping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.InstructionLoopingImpl#getInstructionsequence <em>Instructionsequence</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.InstructionLoopingImpl#getNamedcardinality <em>Namedcardinality</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstructionLoopingImpl extends SequenceElementImpl implements InstructionLooping {
	/**
	 * The cached value of the '{@link #getInstructionsequence() <em>Instructionsequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstructionsequence()
	 * @generated
	 * @ordered
	 */
	protected EList<InstructionSequence> instructionsequence;

	/**
	 * The cached value of the '{@link #getNamedcardinality() <em>Namedcardinality</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedcardinality()
	 * @generated
	 * @ordered
	 */
	protected NamedCardinality namedcardinality;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstructionLoopingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ByBenchPackage.Literals.INSTRUCTION_LOOPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstructionSequence> getInstructionsequence() {
		if (instructionsequence == null) {
			instructionsequence = new EObjectContainmentEList<InstructionSequence>(InstructionSequence.class, this, ByBenchPackage.INSTRUCTION_LOOPING__INSTRUCTIONSEQUENCE);
		}
		return instructionsequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedCardinality getNamedcardinality() {
		if (namedcardinality != null && namedcardinality.eIsProxy()) {
			InternalEObject oldNamedcardinality = (InternalEObject)namedcardinality;
			namedcardinality = (NamedCardinality)eResolveProxy(oldNamedcardinality);
			if (namedcardinality != oldNamedcardinality) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ByBenchPackage.INSTRUCTION_LOOPING__NAMEDCARDINALITY, oldNamedcardinality, namedcardinality));
			}
		}
		return namedcardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedCardinality basicGetNamedcardinality() {
		return namedcardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNamedcardinality(NamedCardinality newNamedcardinality, NotificationChain msgs) {
		NamedCardinality oldNamedcardinality = namedcardinality;
		namedcardinality = newNamedcardinality;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ByBenchPackage.INSTRUCTION_LOOPING__NAMEDCARDINALITY, oldNamedcardinality, newNamedcardinality);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamedcardinality(NamedCardinality newNamedcardinality) {
		if (newNamedcardinality != namedcardinality) {
			NotificationChain msgs = null;
			if (namedcardinality != null)
				msgs = ((InternalEObject)namedcardinality).eInverseRemove(this, ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONLOOPING, NamedCardinality.class, msgs);
			if (newNamedcardinality != null)
				msgs = ((InternalEObject)newNamedcardinality).eInverseAdd(this, ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONLOOPING, NamedCardinality.class, msgs);
			msgs = basicSetNamedcardinality(newNamedcardinality, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ByBenchPackage.INSTRUCTION_LOOPING__NAMEDCARDINALITY, newNamedcardinality, newNamedcardinality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ByBenchPackage.INSTRUCTION_LOOPING__NAMEDCARDINALITY:
				if (namedcardinality != null)
					msgs = ((InternalEObject)namedcardinality).eInverseRemove(this, ByBenchPackage.NAMED_CARDINALITY__INSTRUCTIONLOOPING, NamedCardinality.class, msgs);
				return basicSetNamedcardinality((NamedCardinality)otherEnd, msgs);
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
			case ByBenchPackage.INSTRUCTION_LOOPING__INSTRUCTIONSEQUENCE:
				return ((InternalEList<?>)getInstructionsequence()).basicRemove(otherEnd, msgs);
			case ByBenchPackage.INSTRUCTION_LOOPING__NAMEDCARDINALITY:
				return basicSetNamedcardinality(null, msgs);
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
			case ByBenchPackage.INSTRUCTION_LOOPING__INSTRUCTIONSEQUENCE:
				return getInstructionsequence();
			case ByBenchPackage.INSTRUCTION_LOOPING__NAMEDCARDINALITY:
				if (resolve) return getNamedcardinality();
				return basicGetNamedcardinality();
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
			case ByBenchPackage.INSTRUCTION_LOOPING__INSTRUCTIONSEQUENCE:
				getInstructionsequence().clear();
				getInstructionsequence().addAll((Collection<? extends InstructionSequence>)newValue);
				return;
			case ByBenchPackage.INSTRUCTION_LOOPING__NAMEDCARDINALITY:
				setNamedcardinality((NamedCardinality)newValue);
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
			case ByBenchPackage.INSTRUCTION_LOOPING__INSTRUCTIONSEQUENCE:
				getInstructionsequence().clear();
				return;
			case ByBenchPackage.INSTRUCTION_LOOPING__NAMEDCARDINALITY:
				setNamedcardinality((NamedCardinality)null);
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
			case ByBenchPackage.INSTRUCTION_LOOPING__INSTRUCTIONSEQUENCE:
				return instructionsequence != null && !instructionsequence.isEmpty();
			case ByBenchPackage.INSTRUCTION_LOOPING__NAMEDCARDINALITY:
				return namedcardinality != null;
		}
		return super.eIsSet(featureID);
	}

} //InstructionLoopingImpl
