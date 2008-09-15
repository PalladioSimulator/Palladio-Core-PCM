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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.FeatureConfig#getReferencedObject <em>Referenced Object</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.FeatureConfig#getConfignode <em>Confignode</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getFeatureConfig()
 * @model
 * @generated
 */
public interface FeatureConfig extends EObject {
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
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getFeatureConfig_ReferencedObject()
	 * @model ordered="false"
	 * @generated
	 */
	EObject getReferencedObject();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featureconfig.FeatureConfig#getReferencedObject <em>Referenced Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Object</em>' reference.
	 * @see #getReferencedObject()
	 * @generated
	 */
	void setReferencedObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Confignode</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.featureconfig.ConfigNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Confignode</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confignode</em>' containment reference list.
	 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getFeatureConfig_Confignode()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ConfigNode> getConfignode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.origin.oclIsTypeOf(featuremodel::FeatureDiagram)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean RootIsFeatureModel(DiagnosticChain diagnostics, Map<Object, Object> context);

} // FeatureConfig
