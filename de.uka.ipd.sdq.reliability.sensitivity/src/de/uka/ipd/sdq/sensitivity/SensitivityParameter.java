/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specifies&nbsp;a&nbsp;variation&nbsp;of&nbsp;a&nbsp;certain&nbsp;parameter&nbsp;in&nbsp;a&nbsp;given&nbsp;PCM&nbsp;model.&nbsp;Thereby,&nbsp;a&nbsp;"parameter"&nbsp;may&nbsp;be&nbsp;a&nbsp;single&nbsp;value&nbsp;(such&nbsp;as
 * a
 * resource&nbsp;demand),&nbsp;a&nbsp;group&nbsp;of&nbsp;values&nbsp;(such&nbsp;as&nbsp;all&nbsp;software&nbsp;failure&nbsp;probabilities&nbsp;in&nbsp;a&nbsp;given&nbsp;RDSEFF),
 * or a combination of other parameters.&nbsp;If&nbsp;the&nbsp;parameter&nbsp;is&nbsp;a
 * single&nbsp;value,&nbsp;it&nbsp;may&nbsp;be&nbsp;of&nbsp;different&nbsp;types,&nbsp;such&nbsp;as&nbsp;DOUBLE&nbsp;or&nbsp;STRING.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.SensitivityParameter#getParentParameter__SensitivityParameter <em>Parent Parameter Sensitivity Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.SensitivityParameter#getSensitivityConfiguration__SensitivityParameter <em>Sensitivity Configuration Sensitivity Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getSensitivityParameter()
 * @model abstract="true"
 * @generated
 */
public interface SensitivityParameter extends Entity {
	/**
	 * Returns the value of the '<em><b>Parent Parameter Sensitivity Parameter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter#getChildParameters__CombinedSensitivityParameter <em>Child Parameters Combined Sensitivity Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Parameter Sensitivity Parameter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Parameter Sensitivity Parameter</em>' container reference.
	 * @see #setParentParameter__SensitivityParameter(CombinedSensitivityParameter)
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getSensitivityParameter_ParentParameter__SensitivityParameter()
	 * @see de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter#getChildParameters__CombinedSensitivityParameter
	 * @model opposite="childParameters__CombinedSensitivityParameter" transient="false" ordered="false"
	 * @generated
	 */
	CombinedSensitivityParameter getParentParameter__SensitivityParameter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.SensitivityParameter#getParentParameter__SensitivityParameter <em>Parent Parameter Sensitivity Parameter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Parameter Sensitivity Parameter</em>' container reference.
	 * @see #getParentParameter__SensitivityParameter()
	 * @generated
	 */
	void setParentParameter__SensitivityParameter(CombinedSensitivityParameter value);

	/**
	 * Returns the value of the '<em><b>Sensitivity Configuration Sensitivity Parameter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensitivity.SensitivityConfiguration#getSensitivityParameters__SensitivityConfiguration <em>Sensitivity Parameters Sensitivity Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sensitivity Configuration Sensitivity Parameter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sensitivity Configuration Sensitivity Parameter</em>' container reference.
	 * @see #setSensitivityConfiguration__SensitivityParameter(SensitivityConfiguration)
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getSensitivityParameter_SensitivityConfiguration__SensitivityParameter()
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityConfiguration#getSensitivityParameters__SensitivityConfiguration
	 * @model opposite="sensitivityParameters__SensitivityConfiguration" transient="false" ordered="false"
	 * @generated
	 */
	SensitivityConfiguration getSensitivityConfiguration__SensitivityParameter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.SensitivityParameter#getSensitivityConfiguration__SensitivityParameter <em>Sensitivity Configuration Sensitivity Parameter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sensitivity Configuration Sensitivity Parameter</em>' container reference.
	 * @see #getSensitivityConfiguration__SensitivityParameter()
	 * @generated
	 */
	void setSensitivityConfiguration__SensitivityParameter(SensitivityConfiguration value);

} // SensitivityParameter
