/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Container for quality annotations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.QualityRepository#getQualityStatements <em>Quality Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.QualityPackage#getQualityRepository()
 * @model
 * @generated
 */
public interface QualityRepository extends Identifier {
	/**
	 * Returns the value of the '<em><b>Quality Statements</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.quality.QualityStatement}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.QualityStatement#getQualityRepository <em>Quality Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Statements</em>' containment reference list.
	 * @see de.fzi.se.quality.QualityPackage#getQualityRepository_QualityStatements()
	 * @see de.fzi.se.quality.QualityStatement#getQualityRepository
	 * @model opposite="qualityRepository" containment="true" ordered="false"
	 * @generated
	 */
	EList<QualityStatement> getQualityStatements();

} // QualityRepository
