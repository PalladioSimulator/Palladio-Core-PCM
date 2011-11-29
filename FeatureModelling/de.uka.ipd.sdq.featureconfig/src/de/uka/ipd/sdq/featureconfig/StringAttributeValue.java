/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Attribute Value</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getStringAttributeValue()
 * @model
 * @generated
 */
public interface StringAttributeValue extends AttributeValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.confignode.origin.attributes->one(a | a.name = self.name)
	 *  and
	 *  self.confignode.origin.attributes->any(a | a.name = self.name).oclIsTypeOf(featuremodel::StringAttribute)
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.confignode.origin.attributes->one(a | a.name = self.name)\r\n and\r\n self.confignode.origin.attributes->any(a | a.name = self.name).oclIsTypeOf(featuremodel::StringAttribute)'"
	 * @generated
	 */
	boolean AttributeValueIsDefinedInFeatureAndEqualsTypeString(DiagnosticChain diagnostics, Map<Object, Object> context);

} // StringAttributeValue
