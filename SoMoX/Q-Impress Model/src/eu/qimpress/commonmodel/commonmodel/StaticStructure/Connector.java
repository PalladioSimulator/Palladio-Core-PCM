/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The entity connector specifies binding between components. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector#isIsDelegation <em>Is Delegation</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector#getEndpoints <em>Endpoints</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getConnector()
 * @model
 * @generated
 */
public interface Connector extends Entity {
	/**
	 * Returns the value of the '<em><b>Is Delegation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Derived attribute isDelegation of element Connector differentiates assembly and delegation connectors in our models. For example for two endpoints if they are at the same hierarchy level the flag will be set to false and if they are on adjacent hierarchy levels the flag is set to true. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Delegation</em>' attribute.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getConnector_IsDelegation()
	 * @model unique="false" required="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isIsDelegation();

	/**
	 * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link eu.qimpress.commonmodel.commonmodel.StaticStructure.EndPoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property defines endpoints joined by one connector.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Endpoints</em>' containment reference list.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getConnector_Endpoints()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<EndPoint> getEndpoints();

} // Connector
