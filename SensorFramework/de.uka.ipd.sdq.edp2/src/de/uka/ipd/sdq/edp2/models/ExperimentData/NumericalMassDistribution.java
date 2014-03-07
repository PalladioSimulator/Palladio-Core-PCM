/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import javax.measure.Measure;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numerical Mass Distribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalMassDistribution#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalMassDistribution#getValue <em>Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalMassDistribution#getNumericalNominalStatistics <em>Numerical Nominal Statistics</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalMassDistribution()
 * @model
 * @generated
 */
public interface NumericalMassDistribution extends EObject {
	/**
     * Returns the value of the '<em><b>Frequency</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frequency</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Frequency</em>' attribute.
     * @see #setFrequency(long)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalMassDistribution_Frequency()
     * @model required="true" ordered="false"
     * @generated
     */
	long getFrequency();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalMassDistribution#getFrequency <em>Frequency</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Frequency</em>' attribute.
     * @see #getFrequency()
     * @generated
     */
	void setFrequency(long value);

	/**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(Measure)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalMassDistribution_Value()
     * @model dataType="de.uka.ipd.sdq.edp2.models.ExperimentData.EJSMeasure" required="true" ordered="false"
     * @generated
     */
	Measure getValue();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalMassDistribution#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
	void setValue(Measure value);

	/**
     * Returns the value of the '<em><b>Numerical Nominal Statistics</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalNominalStatistics#getNumericalMassDistribution <em>Numerical Mass Distribution</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numerical Nominal Statistics</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Numerical Nominal Statistics</em>' container reference.
     * @see #setNumericalNominalStatistics(NumericalNominalStatistics)
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getNumericalMassDistribution_NumericalNominalStatistics()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalNominalStatistics#getNumericalMassDistribution
     * @model opposite="numericalMassDistribution" required="true" transient="false" ordered="false"
     * @generated
     */
	NumericalNominalStatistics getNumericalNominalStatistics();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalMassDistribution#getNumericalNominalStatistics <em>Numerical Nominal Statistics</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Numerical Nominal Statistics</em>' container reference.
     * @see #getNumericalNominalStatistics()
     * @generated
     */
	void setNumericalNominalStatistics(NumericalNominalStatistics value);

} // NumericalMassDistribution
