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
 * A representation of the model object '<em><b>Textual Base Metric Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * self.captureType = CaptureType::Identifier
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.TextualBaseMetricDescription#getIdentifiers <em>Identifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getTextualBaseMetricDescription()
 * @model
 * @generated
 */
public interface TextualBaseMetricDescription extends BaseMetricDescription {
	/**
     * Returns the value of the '<em><b>Identifiers</b></em>' containment reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.ExperimentData.Identifier}.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.edp2.models.ExperimentData.Identifier#getTextualBaseMetricDescription <em>Textual Base Metric Description</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Identifiers</em>' containment reference list.
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getTextualBaseMetricDescription_Identifiers()
     * @see de.uka.ipd.sdq.edp2.models.ExperimentData.Identifier#getTextualBaseMetricDescription
     * @model opposite="textualBaseMetricDescription" containment="true" required="true" ordered="false"
     * @generated
     */
	EList<Identifier> getIdentifiers();

} // TextualBaseMetricDescription
