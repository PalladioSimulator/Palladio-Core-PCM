/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.effort.estimation.impl;

import de.fzi.se.validation.effort.estimation.EffortEstimationResult;
import de.fzi.se.validation.effort.estimation.EstimationPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Effort Estimation Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.effort.estimation.impl.EffortEstimationResultImpl#getNumberTestcases <em>Number Testcases</em>}</li>
 *   <li>{@link de.fzi.se.validation.effort.estimation.impl.EffortEstimationResultImpl#getIntermediate <em>Intermediate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EffortEstimationResultImpl extends EObjectImpl implements EffortEstimationResult {
	/**
	 * The default value of the '{@link #getNumberTestcases() <em>Number Testcases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberTestcases()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_TESTCASES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberTestcases() <em>Number Testcases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberTestcases()
	 * @generated
	 * @ordered
	 */
	protected int numberTestcases = NUMBER_TESTCASES_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntermediate() <em>Intermediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediate()
	 * @generated
	 * @ordered
	 */
	protected static final double INTERMEDIATE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getIntermediate() <em>Intermediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediate()
	 * @generated
	 * @ordered
	 */
	protected double intermediate = INTERMEDIATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EffortEstimationResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EstimationPackage.Literals.EFFORT_ESTIMATION_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberTestcases() {
		return numberTestcases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberTestcases(int newNumberTestcases) {
		int oldNumberTestcases = numberTestcases;
		numberTestcases = newNumberTestcases;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EstimationPackage.EFFORT_ESTIMATION_RESULT__NUMBER_TESTCASES, oldNumberTestcases, numberTestcases));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIntermediate() {
		return intermediate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediate(double newIntermediate) {
		double oldIntermediate = intermediate;
		intermediate = newIntermediate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EstimationPackage.EFFORT_ESTIMATION_RESULT__INTERMEDIATE, oldIntermediate, intermediate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__NUMBER_TESTCASES:
				return getNumberTestcases();
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__INTERMEDIATE:
				return getIntermediate();
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
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__NUMBER_TESTCASES:
				setNumberTestcases((Integer)newValue);
				return;
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__INTERMEDIATE:
				setIntermediate((Double)newValue);
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
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__NUMBER_TESTCASES:
				setNumberTestcases(NUMBER_TESTCASES_EDEFAULT);
				return;
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__INTERMEDIATE:
				setIntermediate(INTERMEDIATE_EDEFAULT);
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
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__NUMBER_TESTCASES:
				return numberTestcases != NUMBER_TESTCASES_EDEFAULT;
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__INTERMEDIATE:
				return intermediate != INTERMEDIATE_EDEFAULT;
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
		result.append(" (numberTestcases: ");
		result.append(numberTestcases);
		result.append(", intermediate: ");
		result.append(intermediate);
		result.append(')');
		return result.toString();
	}

} //EffortEstimationResultImpl
