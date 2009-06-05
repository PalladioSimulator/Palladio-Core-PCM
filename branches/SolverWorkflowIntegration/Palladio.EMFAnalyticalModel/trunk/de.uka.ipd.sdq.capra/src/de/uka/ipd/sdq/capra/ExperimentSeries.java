/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra;

import de.uka.ipd.sdq.capra.experiment.Experiment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Experiment Series</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.ExperimentSeries#getExperiment <em>Experiment</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.ExperimentSeries#getSystemConfigurationFile <em>System Configuration File</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.ExperimentSeries#getSchedulerLibraryFile <em>Scheduler Library File</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.ExperimentSeries#getOutputDirectory <em>Output Directory</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.ExperimentSeries#getSummaryFile <em>Summary File</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.ExperimentSeries#getCapraFile <em>Capra File</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.CapraPackage#getExperimentSeries()
 * @model
 * @generated
 */
public interface ExperimentSeries extends EObject {
	/**
	 * Returns the value of the '<em><b>Experiment</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.experiment.Experiment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Experiment</em>' containment reference list.
	 * @see de.uka.ipd.sdq.capra.CapraPackage#getExperimentSeries_Experiment()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Experiment> getExperiment();

	/**
	 * Returns the value of the '<em><b>System Configuration File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Configuration File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Configuration File</em>' attribute.
	 * @see #setSystemConfigurationFile(String)
	 * @see de.uka.ipd.sdq.capra.CapraPackage#getExperimentSeries_SystemConfigurationFile()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getSystemConfigurationFile();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.ExperimentSeries#getSystemConfigurationFile <em>System Configuration File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Configuration File</em>' attribute.
	 * @see #getSystemConfigurationFile()
	 * @generated
	 */
	void setSystemConfigurationFile(String value);

	/**
	 * Returns the value of the '<em><b>Scheduler Library File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduler Library File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduler Library File</em>' attribute.
	 * @see #setSchedulerLibraryFile(String)
	 * @see de.uka.ipd.sdq.capra.CapraPackage#getExperimentSeries_SchedulerLibraryFile()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getSchedulerLibraryFile();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.ExperimentSeries#getSchedulerLibraryFile <em>Scheduler Library File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduler Library File</em>' attribute.
	 * @see #getSchedulerLibraryFile()
	 * @generated
	 */
	void setSchedulerLibraryFile(String value);

	/**
	 * Returns the value of the '<em><b>Output Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Directory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Directory</em>' attribute.
	 * @see #setOutputDirectory(String)
	 * @see de.uka.ipd.sdq.capra.CapraPackage#getExperimentSeries_OutputDirectory()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getOutputDirectory();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.ExperimentSeries#getOutputDirectory <em>Output Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Directory</em>' attribute.
	 * @see #getOutputDirectory()
	 * @generated
	 */
	void setOutputDirectory(String value);

	/**
	 * Returns the value of the '<em><b>Summary File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Summary File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Summary File</em>' attribute.
	 * @see #setSummaryFile(String)
	 * @see de.uka.ipd.sdq.capra.CapraPackage#getExperimentSeries_SummaryFile()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getSummaryFile();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.ExperimentSeries#getSummaryFile <em>Summary File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Summary File</em>' attribute.
	 * @see #getSummaryFile()
	 * @generated
	 */
	void setSummaryFile(String value);

	/**
	 * Returns the value of the '<em><b>Capra File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capra File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capra File</em>' attribute.
	 * @see #setCapraFile(String)
	 * @see de.uka.ipd.sdq.capra.CapraPackage#getExperimentSeries_CapraFile()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getCapraFile();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.ExperimentSeries#getCapraFile <em>Capra File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capra File</em>' attribute.
	 * @see #getCapraFile()
	 * @generated
	 */
	void setCapraFile(String value);

} // ExperimentSeries
