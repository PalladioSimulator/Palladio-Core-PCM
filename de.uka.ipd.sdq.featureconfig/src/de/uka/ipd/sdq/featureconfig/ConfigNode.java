/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.featuremodel.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Config Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Holds ConfigState of a Feature. For a Feature it holds the actual value. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.ConfigNode#getOrigin <em>Origin</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.ConfigNode#getConfigState <em>Config State</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.ConfigNode#getAttributevalue <em>Attributevalue</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getConfigNode()
 * @model
 * @generated
 */
public interface ConfigNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Origin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin</em>' reference.
	 * @see #setOrigin(Feature)
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getConfigNode_Origin()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Feature getOrigin();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featureconfig.ConfigNode#getOrigin <em>Origin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' reference.
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(Feature value);

	/**
	 * Returns the value of the '<em><b>Config State</b></em>' attribute.
	 * The default value is <code>"DEFAULT"</code>.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.featureconfig.ConfigState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * actual state for annotated Features; for FeatureGroups it is a derived attribute
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Config State</em>' attribute.
	 * @see de.uka.ipd.sdq.featureconfig.ConfigState
	 * @see #setConfigState(ConfigState)
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getConfigNode_ConfigState()
	 * @model default="DEFAULT" required="true" ordered="false"
	 * @generated
	 */
	ConfigState getConfigState();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featureconfig.ConfigNode#getConfigState <em>Config State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config State</em>' attribute.
	 * @see de.uka.ipd.sdq.featureconfig.ConfigState
	 * @see #getConfigState()
	 * @generated
	 */
	void setConfigState(ConfigState value);

	/**
	 * Returns the value of the '<em><b>Attributevalue</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.featureconfig.AttributeValue}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.featureconfig.AttributeValue#getConfignode <em>Confignode</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributevalue</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributevalue</em>' containment reference list.
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getConfigNode_Attributevalue()
	 * @see de.uka.ipd.sdq.featureconfig.AttributeValue#getConfignode
	 * @model opposite="confignode" containment="true" ordered="false"
	 * @generated
	 */
	EList<AttributeValue> getAttributevalue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * true 
	 * --let childSelectedCount : Integer = self.children->select(c|c.configState = ConfigState::USER_SELECTED or c.configState = ConfigState::MASCHINE_SELECTED)->size() 
	 * --in 
	 * --	 if self.origin.oclIsTypeOf(featuremodel::FeatureGroup) then
	 * --	 	childSelectedCount >= self.origin.min and (childSelectedCount <= self.origin.max or self.origin.max = -1)
	 * --	 else
	 * --	 	self.origin.min  >= 1 implies (self.configState = ConfigState::USER_SELECTED or self.configState = ConfigState::MASCHINE_SELECTED)
	 * --	 endif
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='true \r\n--let childSelectedCount : Integer = self.children->select(c|c.configState = ConfigState::USER_SELECTED or c.configState = ConfigState::MASCHINE_SELECTED)->size() \r\n--in \r\n--\t if self.origin.oclIsTypeOf(featuremodel::FeatureGroup) then\r\n--\t \tchildSelectedCount >= self.origin.min and (childSelectedCount <= self.origin.max or self.origin.max = -1)\r\n--\t else\r\n--\t \tself.origin.min  >= 1 implies (self.configState = ConfigState::USER_SELECTED or self.configState = ConfigState::MASCHINE_SELECTED)\r\n--\t endif'"
	 * @generated
	 */
	boolean ConfigCardinalityInvalid(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * true
	 * --not self.origin.featuregroup->isEmpty() implies (self.origin.featuregroup.children->size() <=  self.origin.featuregroup.max and self.origin.featuregroup.children->size() >=  self.origin.featuregroup.min)
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='true\r\n--not self.origin.featuregroup->isEmpty() implies (self.origin.featuregroup.children->size() <=  self.origin.featuregroup.max and self.origin.featuregroup.children->size() >=  self.origin.featuregroup.min)'"
	 * @generated
	 */
	boolean CheckMultiplicityOfFeatureGroup(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ConfigNode
