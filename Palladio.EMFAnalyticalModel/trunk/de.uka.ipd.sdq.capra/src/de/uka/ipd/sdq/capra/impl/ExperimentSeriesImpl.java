/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.impl;

import de.uka.ipd.sdq.capra.CapraPackage;
import de.uka.ipd.sdq.capra.ExperimentSeries;

import de.uka.ipd.sdq.capra.experiment.Experiment;

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
 * An implementation of the model object '<em><b>Experiment Series</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.impl.ExperimentSeriesImpl#getExperiment <em>Experiment</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.impl.ExperimentSeriesImpl#getSystemConfigurationFile <em>System Configuration File</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.impl.ExperimentSeriesImpl#getSchedulerLibraryFile <em>Scheduler Library File</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.impl.ExperimentSeriesImpl#getOutputDirectory <em>Output Directory</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.impl.ExperimentSeriesImpl#getSummaryFile <em>Summary File</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.impl.ExperimentSeriesImpl#getCapraFile <em>Capra File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExperimentSeriesImpl extends EObjectImpl implements ExperimentSeries {
	/**
	 * The cached value of the '{@link #getExperiment() <em>Experiment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExperiment()
	 * @generated
	 * @ordered
	 */
	protected EList<Experiment> experiment;

	/**
	 * The default value of the '{@link #getSystemConfigurationFile() <em>System Configuration File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemConfigurationFile()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_CONFIGURATION_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemConfigurationFile() <em>System Configuration File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemConfigurationFile()
	 * @generated
	 * @ordered
	 */
	protected String systemConfigurationFile = SYSTEM_CONFIGURATION_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchedulerLibraryFile() <em>Scheduler Library File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulerLibraryFile()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHEDULER_LIBRARY_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchedulerLibraryFile() <em>Scheduler Library File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulerLibraryFile()
	 * @generated
	 * @ordered
	 */
	protected String schedulerLibraryFile = SCHEDULER_LIBRARY_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputDirectory() <em>Output Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputDirectory()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_DIRECTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputDirectory() <em>Output Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputDirectory()
	 * @generated
	 * @ordered
	 */
	protected String outputDirectory = OUTPUT_DIRECTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSummaryFile() <em>Summary File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSummaryFile()
	 * @generated
	 * @ordered
	 */
	protected static final String SUMMARY_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSummaryFile() <em>Summary File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSummaryFile()
	 * @generated
	 * @ordered
	 */
	protected String summaryFile = SUMMARY_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCapraFile() <em>Capra File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapraFile()
	 * @generated
	 * @ordered
	 */
	protected static final String CAPRA_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCapraFile() <em>Capra File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapraFile()
	 * @generated
	 * @ordered
	 */
	protected String capraFile = CAPRA_FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExperimentSeriesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CapraPackage.Literals.EXPERIMENT_SERIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Experiment> getExperiment() {
		if (experiment == null) {
			experiment = new EObjectContainmentEList<Experiment>(Experiment.class, this, CapraPackage.EXPERIMENT_SERIES__EXPERIMENT);
		}
		return experiment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSystemConfigurationFile() {
		return systemConfigurationFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemConfigurationFile(String newSystemConfigurationFile) {
		String oldSystemConfigurationFile = systemConfigurationFile;
		systemConfigurationFile = newSystemConfigurationFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CapraPackage.EXPERIMENT_SERIES__SYSTEM_CONFIGURATION_FILE, oldSystemConfigurationFile, systemConfigurationFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchedulerLibraryFile() {
		return schedulerLibraryFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedulerLibraryFile(String newSchedulerLibraryFile) {
		String oldSchedulerLibraryFile = schedulerLibraryFile;
		schedulerLibraryFile = newSchedulerLibraryFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CapraPackage.EXPERIMENT_SERIES__SCHEDULER_LIBRARY_FILE, oldSchedulerLibraryFile, schedulerLibraryFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputDirectory() {
		return outputDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputDirectory(String newOutputDirectory) {
		String oldOutputDirectory = outputDirectory;
		outputDirectory = newOutputDirectory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CapraPackage.EXPERIMENT_SERIES__OUTPUT_DIRECTORY, oldOutputDirectory, outputDirectory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSummaryFile() {
		return summaryFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSummaryFile(String newSummaryFile) {
		String oldSummaryFile = summaryFile;
		summaryFile = newSummaryFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CapraPackage.EXPERIMENT_SERIES__SUMMARY_FILE, oldSummaryFile, summaryFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCapraFile() {
		return capraFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapraFile(String newCapraFile) {
		String oldCapraFile = capraFile;
		capraFile = newCapraFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CapraPackage.EXPERIMENT_SERIES__CAPRA_FILE, oldCapraFile, capraFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CapraPackage.EXPERIMENT_SERIES__EXPERIMENT:
				return ((InternalEList<?>)getExperiment()).basicRemove(otherEnd, msgs);
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
			case CapraPackage.EXPERIMENT_SERIES__EXPERIMENT:
				return getExperiment();
			case CapraPackage.EXPERIMENT_SERIES__SYSTEM_CONFIGURATION_FILE:
				return getSystemConfigurationFile();
			case CapraPackage.EXPERIMENT_SERIES__SCHEDULER_LIBRARY_FILE:
				return getSchedulerLibraryFile();
			case CapraPackage.EXPERIMENT_SERIES__OUTPUT_DIRECTORY:
				return getOutputDirectory();
			case CapraPackage.EXPERIMENT_SERIES__SUMMARY_FILE:
				return getSummaryFile();
			case CapraPackage.EXPERIMENT_SERIES__CAPRA_FILE:
				return getCapraFile();
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
			case CapraPackage.EXPERIMENT_SERIES__EXPERIMENT:
				getExperiment().clear();
				getExperiment().addAll((Collection<? extends Experiment>)newValue);
				return;
			case CapraPackage.EXPERIMENT_SERIES__SYSTEM_CONFIGURATION_FILE:
				setSystemConfigurationFile((String)newValue);
				return;
			case CapraPackage.EXPERIMENT_SERIES__SCHEDULER_LIBRARY_FILE:
				setSchedulerLibraryFile((String)newValue);
				return;
			case CapraPackage.EXPERIMENT_SERIES__OUTPUT_DIRECTORY:
				setOutputDirectory((String)newValue);
				return;
			case CapraPackage.EXPERIMENT_SERIES__SUMMARY_FILE:
				setSummaryFile((String)newValue);
				return;
			case CapraPackage.EXPERIMENT_SERIES__CAPRA_FILE:
				setCapraFile((String)newValue);
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
			case CapraPackage.EXPERIMENT_SERIES__EXPERIMENT:
				getExperiment().clear();
				return;
			case CapraPackage.EXPERIMENT_SERIES__SYSTEM_CONFIGURATION_FILE:
				setSystemConfigurationFile(SYSTEM_CONFIGURATION_FILE_EDEFAULT);
				return;
			case CapraPackage.EXPERIMENT_SERIES__SCHEDULER_LIBRARY_FILE:
				setSchedulerLibraryFile(SCHEDULER_LIBRARY_FILE_EDEFAULT);
				return;
			case CapraPackage.EXPERIMENT_SERIES__OUTPUT_DIRECTORY:
				setOutputDirectory(OUTPUT_DIRECTORY_EDEFAULT);
				return;
			case CapraPackage.EXPERIMENT_SERIES__SUMMARY_FILE:
				setSummaryFile(SUMMARY_FILE_EDEFAULT);
				return;
			case CapraPackage.EXPERIMENT_SERIES__CAPRA_FILE:
				setCapraFile(CAPRA_FILE_EDEFAULT);
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
			case CapraPackage.EXPERIMENT_SERIES__EXPERIMENT:
				return experiment != null && !experiment.isEmpty();
			case CapraPackage.EXPERIMENT_SERIES__SYSTEM_CONFIGURATION_FILE:
				return SYSTEM_CONFIGURATION_FILE_EDEFAULT == null ? systemConfigurationFile != null : !SYSTEM_CONFIGURATION_FILE_EDEFAULT.equals(systemConfigurationFile);
			case CapraPackage.EXPERIMENT_SERIES__SCHEDULER_LIBRARY_FILE:
				return SCHEDULER_LIBRARY_FILE_EDEFAULT == null ? schedulerLibraryFile != null : !SCHEDULER_LIBRARY_FILE_EDEFAULT.equals(schedulerLibraryFile);
			case CapraPackage.EXPERIMENT_SERIES__OUTPUT_DIRECTORY:
				return OUTPUT_DIRECTORY_EDEFAULT == null ? outputDirectory != null : !OUTPUT_DIRECTORY_EDEFAULT.equals(outputDirectory);
			case CapraPackage.EXPERIMENT_SERIES__SUMMARY_FILE:
				return SUMMARY_FILE_EDEFAULT == null ? summaryFile != null : !SUMMARY_FILE_EDEFAULT.equals(summaryFile);
			case CapraPackage.EXPERIMENT_SERIES__CAPRA_FILE:
				return CAPRA_FILE_EDEFAULT == null ? capraFile != null : !CAPRA_FILE_EDEFAULT.equals(capraFile);
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
		result.append(" (systemConfigurationFile: ");
		result.append(systemConfigurationFile);
		result.append(", schedulerLibraryFile: ");
		result.append(schedulerLibraryFile);
		result.append(", outputDirectory: ");
		result.append(outputDirectory);
		result.append(", summaryFile: ");
		result.append(summaryFile);
		result.append(", capraFile: ");
		result.append(capraFile);
		result.append(')');
		return result.toString();
	}

} //ExperimentSeriesImpl
