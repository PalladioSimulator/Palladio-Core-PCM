/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import scheduler.configuration.ConfigurationPackage;
import scheduler.configuration.PriorityDegradation;
import scheduler.configuration.StaticPriorityBoost;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Priority Boost</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.StaticPriorityBoostImpl#isResetTimeslice <em>Reset Timeslice</em>}</li>
 *   <li>{@link scheduler.configuration.impl.StaticPriorityBoostImpl#getBonus <em>Bonus</em>}</li>
 *   <li>{@link scheduler.configuration.impl.StaticPriorityBoostImpl#getDegradation <em>Degradation</em>}</li>
 *   <li>{@link scheduler.configuration.impl.StaticPriorityBoostImpl#getTimePenalty <em>Time Penalty</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StaticPriorityBoostImpl extends EObjectImpl implements StaticPriorityBoost {
	/**
	 * The default value of the '{@link #isResetTimeslice() <em>Reset Timeslice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResetTimeslice()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESET_TIMESLICE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isResetTimeslice() <em>Reset Timeslice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResetTimeslice()
	 * @generated
	 * @ordered
	 */
	protected boolean resetTimeslice = RESET_TIMESLICE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBonus() <em>Bonus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBonus()
	 * @generated
	 * @ordered
	 */
	protected static final int BONUS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBonus() <em>Bonus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBonus()
	 * @generated
	 * @ordered
	 */
	protected int bonus = BONUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDegradation() <em>Degradation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDegradation()
	 * @generated
	 * @ordered
	 */
	protected static final PriorityDegradation DEGRADATION_EDEFAULT = PriorityDegradation.RESET;

	/**
	 * The cached value of the '{@link #getDegradation() <em>Degradation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDegradation()
	 * @generated
	 * @ordered
	 */
	protected PriorityDegradation degradation = DEGRADATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimePenalty() <em>Time Penalty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimePenalty()
	 * @generated
	 * @ordered
	 */
	protected static final double TIME_PENALTY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTimePenalty() <em>Time Penalty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimePenalty()
	 * @generated
	 * @ordered
	 */
	protected double timePenalty = TIME_PENALTY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticPriorityBoostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.STATIC_PRIORITY_BOOST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResetTimeslice() {
		return resetTimeslice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResetTimeslice(boolean newResetTimeslice) {
		boolean oldResetTimeslice = resetTimeslice;
		resetTimeslice = newResetTimeslice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.STATIC_PRIORITY_BOOST__RESET_TIMESLICE, oldResetTimeslice, resetTimeslice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBonus() {
		return bonus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBonus(int newBonus) {
		int oldBonus = bonus;
		bonus = newBonus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.STATIC_PRIORITY_BOOST__BONUS, oldBonus, bonus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityDegradation getDegradation() {
		return degradation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDegradation(PriorityDegradation newDegradation) {
		PriorityDegradation oldDegradation = degradation;
		degradation = newDegradation == null ? DEGRADATION_EDEFAULT : newDegradation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.STATIC_PRIORITY_BOOST__DEGRADATION, oldDegradation, degradation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTimePenalty() {
		return timePenalty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimePenalty(double newTimePenalty) {
		double oldTimePenalty = timePenalty;
		timePenalty = newTimePenalty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.STATIC_PRIORITY_BOOST__TIME_PENALTY, oldTimePenalty, timePenalty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__RESET_TIMESLICE:
				return isResetTimeslice();
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__BONUS:
				return getBonus();
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__DEGRADATION:
				return getDegradation();
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__TIME_PENALTY:
				return getTimePenalty();
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
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__RESET_TIMESLICE:
				setResetTimeslice((Boolean)newValue);
				return;
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__BONUS:
				setBonus((Integer)newValue);
				return;
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__DEGRADATION:
				setDegradation((PriorityDegradation)newValue);
				return;
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__TIME_PENALTY:
				setTimePenalty((Double)newValue);
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
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__RESET_TIMESLICE:
				setResetTimeslice(RESET_TIMESLICE_EDEFAULT);
				return;
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__BONUS:
				setBonus(BONUS_EDEFAULT);
				return;
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__DEGRADATION:
				setDegradation(DEGRADATION_EDEFAULT);
				return;
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__TIME_PENALTY:
				setTimePenalty(TIME_PENALTY_EDEFAULT);
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
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__RESET_TIMESLICE:
				return resetTimeslice != RESET_TIMESLICE_EDEFAULT;
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__BONUS:
				return bonus != BONUS_EDEFAULT;
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__DEGRADATION:
				return degradation != DEGRADATION_EDEFAULT;
			case ConfigurationPackage.STATIC_PRIORITY_BOOST__TIME_PENALTY:
				return timePenalty != TIME_PENALTY_EDEFAULT;
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
		result.append(" (resetTimeslice: ");
		result.append(resetTimeslice);
		result.append(", bonus: ");
		result.append(bonus);
		result.append(", degradation: ");
		result.append(degradation);
		result.append(", timePenalty: ");
		result.append(timePenalty);
		result.append(')');
		return result.toString();
	}

} //StaticPriorityBoostImpl
