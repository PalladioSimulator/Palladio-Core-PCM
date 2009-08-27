/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edp2 Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Describes and specifies the measure used. Needs to be subclassed to create concrete Measures which can handle specific data. Measures are attached to ExperimentGroup and referenced from ExperimentSetting to allow modeling that the same Measure is used throughout several experiment settings.
 * 
 * Characterizes the reading point how the measurements are collected. The Characerization is propertyable if additional context-specific information should be stored for the sensor.
 * 
 * For example measuring the response time of a request to a system in milliseconds could result in the following values of the attributes: metric='Response Time', measuredObject='System External Requests', and unitOfMeasurements='ms'. Another example is the number of lines of code of the class java.lang.System: metric='LOC', measuredObject='Class java.lang.System', and unitOfMeasurement='Positive Integer'.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getExperimentGroup <em>Experiment Group</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getExperimentSettings <em>Experiment Settings</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getPersistencyKind <em>Persistency Kind</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getMeasuredObject <em>Measured Object</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getMetric <em>Metric</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getEdp2Measure()
 * @model abstract="true"
 * @generated
 */
public interface Edp2Measure extends EObject {
	/**
	 * Returns the value of the '<em><b>Experiment Group</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup#getMeasure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment Group</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Experiment Group</em>' container reference.
	 * @see #setExperimentGroup(ExperimentGroup)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getEdp2Measure_ExperimentGroup()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup#getMeasure
	 * @model opposite="measure" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ExperimentGroup getExperimentGroup();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getExperimentGroup <em>Experiment Group</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Experiment Group</em>' container reference.
	 * @see #getExperimentGroup()
	 * @generated
	 */
	void setExperimentGroup(ExperimentGroup value);

	/**
	 * Returns the value of the '<em><b>Experiment Settings</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting#getMeasure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment Settings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Experiment Settings</em>' reference list.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getEdp2Measure_ExperimentSettings()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentSetting#getMeasure
	 * @model opposite="measure" ordered="false"
	 * @generated
	 */
	EList<ExperimentSetting> getExperimentSettings();

	/**
	 * Returns the value of the '<em><b>Persistency Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.edp2.models.emfmodel.PersistenceKindOptions}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistency Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persistency Kind</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.PersistenceKindOptions
	 * @see #setPersistencyKind(PersistenceKindOptions)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getEdp2Measure_PersistencyKind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PersistenceKindOptions getPersistencyKind();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getPersistencyKind <em>Persistency Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persistency Kind</em>' attribute.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.PersistenceKindOptions
	 * @see #getPersistencyKind()
	 * @generated
	 */
	void setPersistencyKind(PersistenceKindOptions value);

	/**
	 * Returns the value of the '<em><b>Measured Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measured Object</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measured Object</em>' attribute.
	 * @see #setMeasuredObject(String)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getEdp2Measure_MeasuredObject()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getMeasuredObject();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getMeasuredObject <em>Measured Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measured Object</em>' attribute.
	 * @see #getMeasuredObject()
	 * @generated
	 */
	void setMeasuredObject(String value);

	/**
	 * Returns the value of the '<em><b>Metric</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric</em>' reference.
	 * @see #setMetric(MetricDescription)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getEdp2Measure_Metric()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	MetricDescription getMetric();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure#getMetric <em>Metric</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric</em>' reference.
	 * @see #getMetric()
	 * @generated
	 */
	void setMetric(MetricDescription value);

} // Edp2Measure
