/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.featuremodel.Simple;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optional Feature Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A boolean range: Selected or Eliminated (ignore default here). 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.OptionalFeatureDegree#getSimple <em>Simple</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getOptionalFeatureDegree()
 * @model
 * @generated
 */
public interface OptionalFeatureDegree extends FeatureConfigDegree {
	/**
	 * Returns the value of the '<em><b>Simple</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple</em>' reference.
	 * @see #setSimple(Simple)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getOptionalFeatureDegree_Simple()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Simple getSimple();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.OptionalFeatureDegree#getSimple <em>Simple</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple</em>' reference.
	 * @see #getSimple()
	 * @generated
	 */
	void setSimple(Simple value);

} // OptionalFeatureDegree
