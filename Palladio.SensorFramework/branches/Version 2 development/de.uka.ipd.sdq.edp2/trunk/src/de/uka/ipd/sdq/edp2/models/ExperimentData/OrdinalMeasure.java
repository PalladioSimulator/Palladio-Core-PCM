/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import java.util.Map;

import javax.measure.unit.Unit;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ordinal Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Measure which stores any comparable value. The values have to be described using the JScience framework.
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getOrdinalMeasure()
 * @model
 * @generated
 */
public interface OrdinalMeasure extends Edp2Measure {
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

} // OrdinalMeasure
