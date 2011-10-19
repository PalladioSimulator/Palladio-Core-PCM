/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Object Attribute Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.ExternalObjectAttributeValue#getReferencedObject <em>Referenced Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getExternalObjectAttributeValue()
 * @model
 * @generated
 */
public interface ExternalObjectAttributeValue extends AttributeValue {
	/**
	 * Returns the value of the '<em><b>Referenced Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Object</em>' reference.
	 * @see #setReferencedObject(EObject)
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getExternalObjectAttributeValue_ReferencedObject()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EObject getReferencedObject();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featureconfig.ExternalObjectAttributeValue#getReferencedObject <em>Referenced Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Object</em>' reference.
	 * @see #getReferencedObject()
	 * @generated
	 */
	void setReferencedObject(EObject value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.confignode.origin.attributes->one(a | a.name = self.name)
	 *  and
	 *  self.confignode.origin.attributes->any(a | a.name = self.name).oclIsTypeOf(featuremodel::ExternalObjectAttribute)
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.confignode.origin.attributes->one(a | a.name = self.name)\r\n and\r\n self.confignode.origin.attributes->any(a | a.name = self.name).oclIsTypeOf(featuremodel::ExternalObjectAttribute)'"
	 * @generated
	 */
	boolean AttributeValueIsDefinedInFeatureAndEqualsTypeExternalObject(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ExternalObjectAttributeValue
