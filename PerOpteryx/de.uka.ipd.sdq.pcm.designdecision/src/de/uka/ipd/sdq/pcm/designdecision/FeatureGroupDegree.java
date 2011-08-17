/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.featuremodel.FeatureGroup;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Group Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * For a FeatureGroup with Fatures F1, F2, F3 and range 2 to 3 the options are (F1,F2), (F1,F3), (F1,F2,F3). 
 * 
 * TODO define neighbourhood here.  Maybe (F1,F3) and (F1,F2,F3)  are closer to each other than (F1,F2) and (F1,F3). Partial order?
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.FeatureGroupDegree#getFeaturegroup <em>Featuregroup</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.FeatureGroupDegree#getDomainOfFeatureConfigCombinations <em>Domain Of Feature Config Combinations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getFeatureGroupDegree()
 * @model
 * @generated
 */
public interface FeatureGroupDegree extends FeatureConfigDegree {
	/**
	 * Returns the value of the '<em><b>Featuregroup</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Featuregroup</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Featuregroup</em>' reference.
	 * @see #setFeaturegroup(FeatureGroup)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getFeatureGroupDegree_Featuregroup()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FeatureGroup getFeaturegroup();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.FeatureGroupDegree#getFeaturegroup <em>Featuregroup</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Featuregroup</em>' reference.
	 * @see #getFeaturegroup()
	 * @generated
	 */
	void setFeaturegroup(FeatureGroup value);

	/**
	 * Returns the value of the '<em><b>Domain Of Feature Config Combinations</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.designdecision.FeatureSubset}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Of Feature Config Combinations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Of Feature Config Combinations</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getFeatureGroupDegree_DomainOfFeatureConfigCombinations()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<FeatureSubset> getDomainOfFeatureConfigCombinations();

} // FeatureGroupDegree
