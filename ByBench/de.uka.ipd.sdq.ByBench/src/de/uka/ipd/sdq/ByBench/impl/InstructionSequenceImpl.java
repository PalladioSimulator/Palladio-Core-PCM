/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench.impl;

import de.uka.ipd.sdq.ByBench.ByBenchPackage;
import de.uka.ipd.sdq.ByBench.InstructionSequence;
import de.uka.ipd.sdq.ByBench.SequenceElement;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instruction Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.InstructionSequenceImpl#getSequenceelement <em>Sequenceelement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstructionSequenceImpl extends IdentifierImpl implements InstructionSequence {
	/**
	 * The cached value of the '{@link #getSequenceelement() <em>Sequenceelement</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceelement()
	 * @generated
	 * @ordered
	 */
	protected EList<SequenceElement> sequenceelement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstructionSequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ByBenchPackage.Literals.INSTRUCTION_SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SequenceElement> getSequenceelement() {
		if (sequenceelement == null) {
			sequenceelement = new EObjectContainmentEList<SequenceElement>(SequenceElement.class, this, ByBenchPackage.INSTRUCTION_SEQUENCE__SEQUENCEELEMENT);
		}
		return sequenceelement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ByBenchPackage.INSTRUCTION_SEQUENCE__SEQUENCEELEMENT:
				return ((InternalEList<?>)getSequenceelement()).basicRemove(otherEnd, msgs);
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
			case ByBenchPackage.INSTRUCTION_SEQUENCE__SEQUENCEELEMENT:
				return getSequenceelement();
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
			case ByBenchPackage.INSTRUCTION_SEQUENCE__SEQUENCEELEMENT:
				getSequenceelement().clear();
				getSequenceelement().addAll((Collection<? extends SequenceElement>)newValue);
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
			case ByBenchPackage.INSTRUCTION_SEQUENCE__SEQUENCEELEMENT:
				getSequenceelement().clear();
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
			case ByBenchPackage.INSTRUCTION_SEQUENCE__SEQUENCEELEMENT:
				return sequenceelement != null && !sequenceelement.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InstructionSequenceImpl
