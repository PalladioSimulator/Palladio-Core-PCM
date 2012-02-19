/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Feature#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Feature#getChildrelation <em>Childrelation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Feature#getSimpleMandatory <em>Simple Mandatory</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Feature#getSimpleOptional <em>Simple Optional</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Feature#getFeaturegroup <em>Featuregroup</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.featuremodel.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature_Attributes()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Childrelation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Childrelation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Childrelation</em>' containment reference.
	 * @see #setChildrelation(ChildRelation)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature_Childrelation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ChildRelation getChildrelation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.Feature#getChildrelation <em>Childrelation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Childrelation</em>' containment reference.
	 * @see #getChildrelation()
	 * @generated
	 */
	void setChildrelation(ChildRelation value);

	/**
	 * Returns the value of the '<em><b>Simple Mandatory</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.featuremodel.Simple#getMandatoryChildren <em>Mandatory Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Mandatory</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Mandatory</em>' container reference.
	 * @see #setSimpleMandatory(Simple)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature_SimpleMandatory()
	 * @see de.uka.ipd.sdq.featuremodel.Simple#getMandatoryChildren
	 * @model opposite="mandatoryChildren" transient="false" ordered="false"
	 * @generated
	 */
	Simple getSimpleMandatory();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.Feature#getSimpleMandatory <em>Simple Mandatory</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Mandatory</em>' container reference.
	 * @see #getSimpleMandatory()
	 * @generated
	 */
	void setSimpleMandatory(Simple value);

	/**
	 * Returns the value of the '<em><b>Simple Optional</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.featuremodel.Simple#getOptionalChildren <em>Optional Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Optional</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Optional</em>' container reference.
	 * @see #setSimpleOptional(Simple)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature_SimpleOptional()
	 * @see de.uka.ipd.sdq.featuremodel.Simple#getOptionalChildren
	 * @model opposite="optionalChildren" transient="false" ordered="false"
	 * @generated
	 */
	Simple getSimpleOptional();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.Feature#getSimpleOptional <em>Simple Optional</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Optional</em>' container reference.
	 * @see #getSimpleOptional()
	 * @generated
	 */
	void setSimpleOptional(Simple value);

	/**
	 * Returns the value of the '<em><b>Featuregroup</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.featuremodel.FeatureGroup#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Featuregroup</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Featuregroup</em>' container reference.
	 * @see #setFeaturegroup(FeatureGroup)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature_Featuregroup()
	 * @see de.uka.ipd.sdq.featuremodel.FeatureGroup#getChildren
	 * @model opposite="children" transient="false" ordered="false"
	 * @generated
	 */
	FeatureGroup getFeaturegroup();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.Feature#getFeaturegroup <em>Featuregroup</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Featuregroup</em>' container reference.
	 * @see #getFeaturegroup()
	 * @generated
	 */
	void setFeaturegroup(FeatureGroup value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * true 
	 * --each attribute name is unique for this feature
	 * --self.attributes->isUnique(attr | attr.name)
	 * 
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='true \r\n--each attribute name is unique for this feature\r\n--self.attributes->isUnique(attr | attr.name)\r\n'"
	 * @generated
	 */
	boolean EachAttributeNameDefinedJustOnce(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Feature
