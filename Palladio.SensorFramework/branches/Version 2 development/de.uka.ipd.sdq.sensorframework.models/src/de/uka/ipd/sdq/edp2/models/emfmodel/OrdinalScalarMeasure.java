/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;

import java.util.Map;

import javax.measure.unit.Unit;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ordinal Scalar Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Measure which stores any comparable value. The values have to be described using the JScience framework.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalScalarMeasure#getDefaultUnitOfMeasurements <em>Default Unit Of Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getOrdinalScalarMeasure()
 * @model
 * @generated
 */
public interface OrdinalScalarMeasure extends Measure {
	/**
	 * Returns the value of the '<em><b>Default Unit Of Measurements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Unit Of Measurements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Unit Of Measurements</em>' attribute.
	 * @see #setDefaultUnitOfMeasurements(Unit)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getOrdinalScalarMeasure_DefaultUnitOfMeasurements()
	 * @model dataType="de.uka.ipd.sdq.edp2.models.emfmodel.EJSUnit" required="true" ordered="false"
	 * @generated
	 */
	Unit getDefaultUnitOfMeasurements();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.OrdinalScalarMeasure#getDefaultUnitOfMeasurements <em>Default Unit Of Measurements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Unit Of Measurements</em>' attribute.
	 * @see #getDefaultUnitOfMeasurements()
	 * @generated
	 */
	void setDefaultUnitOfMeasurements(Unit value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.persistencyKind != PersistenceKindOptions::Emf
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean PersistencyKindNotEmf(DiagnosticChain diagnostics, Map context);

} // OrdinalScalarMeasure
