/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Random Number Generator Seed</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.RandomNumberGeneratorSeedImpl#getSeed0 <em>Seed0</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.RandomNumberGeneratorSeedImpl#getSeed1 <em>Seed1</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.RandomNumberGeneratorSeedImpl#getSeed2 <em>Seed2</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.RandomNumberGeneratorSeedImpl#getSeed3 <em>Seed3</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.RandomNumberGeneratorSeedImpl#getSeed4 <em>Seed4</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.RandomNumberGeneratorSeedImpl#getSeed5 <em>Seed5</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RandomNumberGeneratorSeedImpl extends EObjectImpl implements RandomNumberGeneratorSeed {
	/**
	 * The default value of the '{@link #getSeed0() <em>Seed0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed0()
	 * @generated
	 * @ordered
	 */
	protected static final int SEED0_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSeed0() <em>Seed0</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed0()
	 * @generated
	 * @ordered
	 */
	protected int seed0 = SEED0_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeed1() <em>Seed1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed1()
	 * @generated
	 * @ordered
	 */
	protected static final int SEED1_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSeed1() <em>Seed1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed1()
	 * @generated
	 * @ordered
	 */
	protected int seed1 = SEED1_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeed2() <em>Seed2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed2()
	 * @generated
	 * @ordered
	 */
	protected static final int SEED2_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSeed2() <em>Seed2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed2()
	 * @generated
	 * @ordered
	 */
	protected int seed2 = SEED2_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeed3() <em>Seed3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed3()
	 * @generated
	 * @ordered
	 */
	protected static final int SEED3_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSeed3() <em>Seed3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed3()
	 * @generated
	 * @ordered
	 */
	protected int seed3 = SEED3_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeed4() <em>Seed4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed4()
	 * @generated
	 * @ordered
	 */
	protected static final int SEED4_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSeed4() <em>Seed4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed4()
	 * @generated
	 * @ordered
	 */
	protected int seed4 = SEED4_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeed5() <em>Seed5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed5()
	 * @generated
	 * @ordered
	 */
	protected static final int SEED5_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSeed5() <em>Seed5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeed5()
	 * @generated
	 * @ordered
	 */
	protected int seed5 = SEED5_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RandomNumberGeneratorSeedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AbstractSimulationPackage.Literals.RANDOM_NUMBER_GENERATOR_SEED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSeed0() {
		return seed0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeed0(int newSeed0) {
		int oldSeed0 = seed0;
		seed0 = newSeed0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED0, oldSeed0, seed0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSeed1() {
		return seed1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeed1(int newSeed1) {
		int oldSeed1 = seed1;
		seed1 = newSeed1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED1, oldSeed1, seed1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSeed2() {
		return seed2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeed2(int newSeed2) {
		int oldSeed2 = seed2;
		seed2 = newSeed2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED2, oldSeed2, seed2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSeed3() {
		return seed3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeed3(int newSeed3) {
		int oldSeed3 = seed3;
		seed3 = newSeed3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED3, oldSeed3, seed3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSeed4() {
		return seed4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeed4(int newSeed4) {
		int oldSeed4 = seed4;
		seed4 = newSeed4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED4, oldSeed4, seed4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSeed5() {
		return seed5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeed5(int newSeed5) {
		int oldSeed5 = seed5;
		seed5 = newSeed5;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED5, oldSeed5, seed5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED0:
				return getSeed0();
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED1:
				return getSeed1();
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED2:
				return getSeed2();
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED3:
				return getSeed3();
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED4:
				return getSeed4();
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED5:
				return getSeed5();
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
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED0:
				setSeed0((Integer)newValue);
				return;
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED1:
				setSeed1((Integer)newValue);
				return;
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED2:
				setSeed2((Integer)newValue);
				return;
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED3:
				setSeed3((Integer)newValue);
				return;
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED4:
				setSeed4((Integer)newValue);
				return;
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED5:
				setSeed5((Integer)newValue);
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
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED0:
				setSeed0(SEED0_EDEFAULT);
				return;
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED1:
				setSeed1(SEED1_EDEFAULT);
				return;
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED2:
				setSeed2(SEED2_EDEFAULT);
				return;
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED3:
				setSeed3(SEED3_EDEFAULT);
				return;
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED4:
				setSeed4(SEED4_EDEFAULT);
				return;
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED5:
				setSeed5(SEED5_EDEFAULT);
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
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED0:
				return seed0 != SEED0_EDEFAULT;
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED1:
				return seed1 != SEED1_EDEFAULT;
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED2:
				return seed2 != SEED2_EDEFAULT;
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED3:
				return seed3 != SEED3_EDEFAULT;
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED4:
				return seed4 != SEED4_EDEFAULT;
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED__SEED5:
				return seed5 != SEED5_EDEFAULT;
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
		result.append(" (seed0: ");
		result.append(seed0);
		result.append(", seed1: ");
		result.append(seed1);
		result.append(", seed2: ");
		result.append(seed2);
		result.append(", seed3: ");
		result.append(seed3);
		result.append(", seed4: ");
		result.append(seed4);
		result.append(", seed5: ");
		result.append(seed5);
		result.append(')');
		return result.toString();
	}

} //RandomNumberGeneratorSeedImpl
