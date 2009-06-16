/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measurement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * There is exactly one instance of this class for each combination of experiment run and corresponding measure declaration.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Measurement#getMeasure <em>Measure</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Measurement#getExperimentRun <em>Experiment Run</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Measurement#getMeasurementRange <em>Measurement Range</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getMeasurement()
 * @model
 * @generated
 */
public interface Measurement extends Propertyable {
	/**
	 * Returns the value of the '<em><b>Measure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure</em>' reference.
	 * @see #setMeasure(Edp2Measure)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getMeasurement_Measure()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Edp2Measure getMeasure();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Measurement#getMeasure <em>Measure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measure</em>' reference.
	 * @see #getMeasure()
	 * @generated
	 */
	void setMeasure(Edp2Measure value);

	/**
	 * Returns the value of the '<em><b>Experiment Run</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun#getMeasurement <em>Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Experiment Run</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Experiment Run</em>' container reference.
	 * @see #setExperimentRun(ExperimentRun)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getMeasurement_ExperimentRun()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentRun#getMeasurement
	 * @model opposite="measurement" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ExperimentRun getExperimentRun();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Measurement#getExperimentRun <em>Experiment Run</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Experiment Run</em>' container reference.
	 * @see #getExperimentRun()
	 * @generated
	 */
	void setExperimentRun(ExperimentRun value);

	/**
	 * Returns the value of the '<em><b>Measurement Range</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getMeasurement <em>Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurement Range</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurement Range</em>' containment reference list.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getMeasurement_MeasurementRange()
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange#getMeasurement
	 * @model opposite="measurement" containment="true" ordered="false"
	 * @generated
	 */
	EList<MeasurementRange> getMeasurementRange();

} // Measurement
