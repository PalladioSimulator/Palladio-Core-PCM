/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.Experiment;
import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentRepository;
import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Experiment Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentRepositoryImpl#getExperiments <em>Experiments</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentRepositoryImpl#getToolConfiguration <em>Tool Configuration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.ExperimentRepositoryImpl#getRepetitions <em>Repetitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExperimentRepositoryImpl extends EObjectImpl implements ExperimentRepository {
	/**
	 * The cached value of the '{@link #getExperiments() <em>Experiments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExperiments()
	 * @generated
	 * @ordered
	 */
	protected EList<Experiment> experiments;

	/**
	 * The cached value of the '{@link #getToolConfiguration() <em>Tool Configuration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToolConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList<ToolConfiguration> toolConfiguration;

	/**
	 * The default value of the '{@link #getRepetitions() <em>Repetitions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepetitions()
	 * @generated
	 * @ordered
	 */
	protected static final int REPETITIONS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRepetitions() <em>Repetitions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepetitions()
	 * @generated
	 * @ordered
	 */
	protected int repetitions = REPETITIONS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExperimentRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExperimentsPackage.Literals.EXPERIMENT_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Experiment> getExperiments() {
		if (experiments == null) {
			experiments = new EObjectContainmentEList<Experiment>(Experiment.class, this, ExperimentsPackage.EXPERIMENT_REPOSITORY__EXPERIMENTS);
		}
		return experiments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ToolConfiguration> getToolConfiguration() {
		if (toolConfiguration == null) {
			toolConfiguration = new EObjectContainmentEList<ToolConfiguration>(ToolConfiguration.class, this, ExperimentsPackage.EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION);
		}
		return toolConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRepetitions() {
		return repetitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepetitions(int newRepetitions) {
		int oldRepetitions = repetitions;
		repetitions = newRepetitions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.EXPERIMENT_REPOSITORY__REPETITIONS, oldRepetitions, repetitions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExperimentsPackage.EXPERIMENT_REPOSITORY__EXPERIMENTS:
				return ((InternalEList<?>)getExperiments()).basicRemove(otherEnd, msgs);
			case ExperimentsPackage.EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION:
				return ((InternalEList<?>)getToolConfiguration()).basicRemove(otherEnd, msgs);
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
			case ExperimentsPackage.EXPERIMENT_REPOSITORY__EXPERIMENTS:
				return getExperiments();
			case ExperimentsPackage.EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION:
				return getToolConfiguration();
			case ExperimentsPackage.EXPERIMENT_REPOSITORY__REPETITIONS:
				return getRepetitions();
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
			case ExperimentsPackage.EXPERIMENT_REPOSITORY__EXPERIMENTS:
				getExperiments().clear();
				getExperiments().addAll((Collection<? extends Experiment>)newValue);
				return;
			case ExperimentsPackage.EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION:
				getToolConfiguration().clear();
				getToolConfiguration().addAll((Collection<? extends ToolConfiguration>)newValue);
				return;
			case ExperimentsPackage.EXPERIMENT_REPOSITORY__REPETITIONS:
				setRepetitions((Integer)newValue);
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
			case ExperimentsPackage.EXPERIMENT_REPOSITORY__EXPERIMENTS:
				getExperiments().clear();
				return;
			case ExperimentsPackage.EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION:
				getToolConfiguration().clear();
				return;
			case ExperimentsPackage.EXPERIMENT_REPOSITORY__REPETITIONS:
				setRepetitions(REPETITIONS_EDEFAULT);
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
			case ExperimentsPackage.EXPERIMENT_REPOSITORY__EXPERIMENTS:
				return experiments != null && !experiments.isEmpty();
			case ExperimentsPackage.EXPERIMENT_REPOSITORY__TOOL_CONFIGURATION:
				return toolConfiguration != null && !toolConfiguration.isEmpty();
			case ExperimentsPackage.EXPERIMENT_REPOSITORY__REPETITIONS:
				return repetitions != REPETITIONS_EDEFAULT;
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
		result.append(" (repetitions: ");
		result.append(repetitions);
		result.append(')');
		return result.toString();
	}

} //ExperimentRepositoryImpl
