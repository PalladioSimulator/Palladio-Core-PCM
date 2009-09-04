/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import javax.measure.Measure;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ratio Statistics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.RatioStatistics#getCoefficientOfVariation <em>Coefficient Of Variation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.RatioStatistics#getGeometricMean <em>Geometric Mean</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.RatioStatistics#getHarmonicMean <em>Harmonic Mean</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage#getRatioStatistics()
 * @model
 * @generated
 */
public interface RatioStatistics extends IntervalStatistics {
	/**
	 * Returns the value of the '<em><b>Coefficient Of Variation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coefficient Of Variation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coefficient Of Variation</em>' attribute.
	 * @see #setCoefficientOfVariation(double)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage#getRatioStatistics_CoefficientOfVariation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getCoefficientOfVariation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.RatioStatistics#getCoefficientOfVariation <em>Coefficient Of Variation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coefficient Of Variation</em>' attribute.
	 * @see #getCoefficientOfVariation()
	 * @generated
	 */
	void setCoefficientOfVariation(double value);

	/**
	 * Returns the value of the '<em><b>Geometric Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Geometric Mean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Geometric Mean</em>' attribute.
	 * @see #setGeometricMean(Measure)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage#getRatioStatistics_GeometricMean()
	 * @model dataType="de.uka.ipd.sdq.edp2.models.emfmodel.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getGeometricMean();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.RatioStatistics#getGeometricMean <em>Geometric Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Geometric Mean</em>' attribute.
	 * @see #getGeometricMean()
	 * @generated
	 */
	void setGeometricMean(Measure value);

	/**
	 * Returns the value of the '<em><b>Harmonic Mean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Harmonic Mean</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Harmonic Mean</em>' attribute.
	 * @see #setHarmonicMean(Measure)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.EmfmodelPackage#getRatioStatistics_HarmonicMean()
	 * @model dataType="de.uka.ipd.sdq.edp2.models.emfmodel.EJSMeasure" required="true" ordered="false"
	 * @generated
	 */
	Measure getHarmonicMean();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.RatioStatistics#getHarmonicMean <em>Harmonic Mean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Harmonic Mean</em>' attribute.
	 * @see #getHarmonicMean()
	 * @generated
	 */
	void setHarmonicMean(Measure value);

} // RatioStatistics
