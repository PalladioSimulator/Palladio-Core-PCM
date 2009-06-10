/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.featureconfig.FeatureConfig;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector Config Decision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.ConnectorConfigDecision#getFeatureconfig <em>Featureconfig</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getConnectorConfigDecision()
 * @model
 * @generated
 */
public interface ConnectorConfigDecision extends DesignDecision {

	/**
	 * Returns the value of the '<em><b>Featureconfig</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Featureconfig</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Featureconfig</em>' reference.
	 * @see #setFeatureconfig(FeatureConfig)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getConnectorConfigDecision_Featureconfig()
	 * @model ordered="false"
	 * @generated
	 */
	FeatureConfig getFeatureconfig();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.ConnectorConfigDecision#getFeatureconfig <em>Featureconfig</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Featureconfig</em>' reference.
	 * @see #getFeatureconfig()
	 * @generated
	 */
	void setFeatureconfig(FeatureConfig value);
} // ConnectorConfigDecision
