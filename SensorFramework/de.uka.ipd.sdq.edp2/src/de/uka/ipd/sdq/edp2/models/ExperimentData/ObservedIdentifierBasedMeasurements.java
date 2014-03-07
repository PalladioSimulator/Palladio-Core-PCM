/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Observed Identifier Based Measurements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifierBasedMeasurements#getObservedIdentifiers <em>Observed Identifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getObservedIdentifierBasedMeasurements()
 * @model
 * @generated
 */
public interface ObservedIdentifierBasedMeasurements extends Identifiable {
	/**
     * Returns the value of the '<em><b>Observed Identifiers</b></em>' containment reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifier}.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifier#getObservedIdentifierBasedMeasurements <em>Observed Identifier Based Measurements</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observed Identifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Observed Identifiers</em>' containment reference list.
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getObservedIdentifierBasedMeasurements_ObservedIdentifiers()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifier#getObservedIdentifierBasedMeasurements
     * @model opposite="observedIdentifierBasedMeasurements" containment="true"
     * @generated
     */
	EList<ObservedIdentifier> getObservedIdentifiers();

} // ObservedIdentifierBasedMeasurements
