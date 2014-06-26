/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.PersistenceFramework;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.ProbeSpecConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.StopCondition;

import de.uka.ipd.sdq.experimentautomation.experiments.impl.ToolConfigurationImpl;

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
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationConfigurationImpl#getPersistenceFramework <em>Persistence Framework</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationConfigurationImpl#getStopConditions <em>Stop Conditions</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationConfigurationImpl#getRandomNumberGeneratorSeed <em>Random Number Generator Seed</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationConfigurationImpl#isSimulateLinkingResources <em>Simulate Linking Resources</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationConfigurationImpl#isSimulateFailures <em>Simulate Failures</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl.AbstractSimulationConfigurationImpl#getProbeSpecConfiguration <em>Probe Spec Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractSimulationConfigurationImpl extends ToolConfigurationImpl implements AbstractSimulationConfiguration {
	/**
	 * The cached value of the '{@link #getPersistenceFramework() <em>Persistence Framework</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistenceFramework()
	 * @generated
	 * @ordered
	 */
	protected PersistenceFramework persistenceFramework;

	/**
	 * The cached value of the '{@link #getStopConditions() <em>Stop Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<StopCondition> stopConditions;

	/**
	 * The cached value of the '{@link #getRandomNumberGeneratorSeed() <em>Random Number Generator Seed</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRandomNumberGeneratorSeed()
	 * @generated
	 * @ordered
	 */
	protected RandomNumberGeneratorSeed randomNumberGeneratorSeed;

	/**
	 * The default value of the '{@link #isSimulateLinkingResources() <em>Simulate Linking Resources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSimulateLinkingResources()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SIMULATE_LINKING_RESOURCES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSimulateLinkingResources() <em>Simulate Linking Resources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSimulateLinkingResources()
	 * @generated
	 * @ordered
	 */
	protected boolean simulateLinkingResources = SIMULATE_LINKING_RESOURCES_EDEFAULT;

	/**
	 * The default value of the '{@link #isSimulateFailures() <em>Simulate Failures</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSimulateFailures()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SIMULATE_FAILURES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSimulateFailures() <em>Simulate Failures</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSimulateFailures()
	 * @generated
	 * @ordered
	 */
	protected boolean simulateFailures = SIMULATE_FAILURES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProbeSpecConfiguration() <em>Probe Spec Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbeSpecConfiguration()
	 * @generated
	 * @ordered
	 */
	protected ProbeSpecConfiguration probeSpecConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractSimulationConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AbstractSimulationPackage.Literals.ABSTRACT_SIMULATION_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersistenceFramework getPersistenceFramework() {
		return persistenceFramework;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPersistenceFramework(PersistenceFramework newPersistenceFramework, NotificationChain msgs) {
		PersistenceFramework oldPersistenceFramework = persistenceFramework;
		persistenceFramework = newPersistenceFramework;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK, oldPersistenceFramework, newPersistenceFramework);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersistenceFramework(PersistenceFramework newPersistenceFramework) {
		if (newPersistenceFramework != persistenceFramework) {
			NotificationChain msgs = null;
			if (persistenceFramework != null)
				msgs = ((InternalEObject)persistenceFramework).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK, null, msgs);
			if (newPersistenceFramework != null)
				msgs = ((InternalEObject)newPersistenceFramework).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK, null, msgs);
			msgs = basicSetPersistenceFramework(newPersistenceFramework, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK, newPersistenceFramework, newPersistenceFramework));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StopCondition> getStopConditions() {
		if (stopConditions == null) {
			stopConditions = new EObjectContainmentEList<StopCondition>(StopCondition.class, this, AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS);
		}
		return stopConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomNumberGeneratorSeed getRandomNumberGeneratorSeed() {
		return randomNumberGeneratorSeed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRandomNumberGeneratorSeed(RandomNumberGeneratorSeed newRandomNumberGeneratorSeed, NotificationChain msgs) {
		RandomNumberGeneratorSeed oldRandomNumberGeneratorSeed = randomNumberGeneratorSeed;
		randomNumberGeneratorSeed = newRandomNumberGeneratorSeed;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED, oldRandomNumberGeneratorSeed, newRandomNumberGeneratorSeed);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRandomNumberGeneratorSeed(RandomNumberGeneratorSeed newRandomNumberGeneratorSeed) {
		if (newRandomNumberGeneratorSeed != randomNumberGeneratorSeed) {
			NotificationChain msgs = null;
			if (randomNumberGeneratorSeed != null)
				msgs = ((InternalEObject)randomNumberGeneratorSeed).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED, null, msgs);
			if (newRandomNumberGeneratorSeed != null)
				msgs = ((InternalEObject)newRandomNumberGeneratorSeed).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED, null, msgs);
			msgs = basicSetRandomNumberGeneratorSeed(newRandomNumberGeneratorSeed, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED, newRandomNumberGeneratorSeed, newRandomNumberGeneratorSeed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSimulateLinkingResources() {
		return simulateLinkingResources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimulateLinkingResources(boolean newSimulateLinkingResources) {
		boolean oldSimulateLinkingResources = simulateLinkingResources;
		simulateLinkingResources = newSimulateLinkingResources;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES, oldSimulateLinkingResources, simulateLinkingResources));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSimulateFailures() {
		return simulateFailures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimulateFailures(boolean newSimulateFailures) {
		boolean oldSimulateFailures = simulateFailures;
		simulateFailures = newSimulateFailures;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES, oldSimulateFailures, simulateFailures));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbeSpecConfiguration getProbeSpecConfiguration() {
		return probeSpecConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProbeSpecConfiguration(ProbeSpecConfiguration newProbeSpecConfiguration, NotificationChain msgs) {
		ProbeSpecConfiguration oldProbeSpecConfiguration = probeSpecConfiguration;
		probeSpecConfiguration = newProbeSpecConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION, oldProbeSpecConfiguration, newProbeSpecConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbeSpecConfiguration(ProbeSpecConfiguration newProbeSpecConfiguration) {
		if (newProbeSpecConfiguration != probeSpecConfiguration) {
			NotificationChain msgs = null;
			if (probeSpecConfiguration != null)
				msgs = ((InternalEObject)probeSpecConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION, null, msgs);
			if (newProbeSpecConfiguration != null)
				msgs = ((InternalEObject)newProbeSpecConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION, null, msgs);
			msgs = basicSetProbeSpecConfiguration(newProbeSpecConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION, newProbeSpecConfiguration, newProbeSpecConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK:
				return basicSetPersistenceFramework(null, msgs);
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS:
				return ((InternalEList<?>)getStopConditions()).basicRemove(otherEnd, msgs);
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED:
				return basicSetRandomNumberGeneratorSeed(null, msgs);
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION:
				return basicSetProbeSpecConfiguration(null, msgs);
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
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK:
				return getPersistenceFramework();
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS:
				return getStopConditions();
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED:
				return getRandomNumberGeneratorSeed();
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES:
				return isSimulateLinkingResources();
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES:
				return isSimulateFailures();
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION:
				return getProbeSpecConfiguration();
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
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK:
				setPersistenceFramework((PersistenceFramework)newValue);
				return;
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS:
				getStopConditions().clear();
				getStopConditions().addAll((Collection<? extends StopCondition>)newValue);
				return;
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED:
				setRandomNumberGeneratorSeed((RandomNumberGeneratorSeed)newValue);
				return;
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES:
				setSimulateLinkingResources((Boolean)newValue);
				return;
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES:
				setSimulateFailures((Boolean)newValue);
				return;
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION:
				setProbeSpecConfiguration((ProbeSpecConfiguration)newValue);
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
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK:
				setPersistenceFramework((PersistenceFramework)null);
				return;
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS:
				getStopConditions().clear();
				return;
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED:
				setRandomNumberGeneratorSeed((RandomNumberGeneratorSeed)null);
				return;
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES:
				setSimulateLinkingResources(SIMULATE_LINKING_RESOURCES_EDEFAULT);
				return;
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES:
				setSimulateFailures(SIMULATE_FAILURES_EDEFAULT);
				return;
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION:
				setProbeSpecConfiguration((ProbeSpecConfiguration)null);
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
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PERSISTENCE_FRAMEWORK:
				return persistenceFramework != null;
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__STOP_CONDITIONS:
				return stopConditions != null && !stopConditions.isEmpty();
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__RANDOM_NUMBER_GENERATOR_SEED:
				return randomNumberGeneratorSeed != null;
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_LINKING_RESOURCES:
				return simulateLinkingResources != SIMULATE_LINKING_RESOURCES_EDEFAULT;
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__SIMULATE_FAILURES:
				return simulateFailures != SIMULATE_FAILURES_EDEFAULT;
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION__PROBE_SPEC_CONFIGURATION:
				return probeSpecConfiguration != null;
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
		result.append(" (simulateLinkingResources: ");
		result.append(simulateLinkingResources);
		result.append(", simulateFailures: ");
		result.append(simulateFailures);
		result.append(')');
		return result.toString();
	}

} //AbstractSimulationConfigurationImpl
