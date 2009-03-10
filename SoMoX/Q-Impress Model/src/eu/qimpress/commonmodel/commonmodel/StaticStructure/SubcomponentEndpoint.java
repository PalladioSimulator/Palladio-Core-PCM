/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subcomponent Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The entity SubcomponentEndpoint defines Endpoint at the assembly connector level.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint#getSubcomponent <em>Subcomponent</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getSubcomponentEndpoint()
 * @model
 * @generated
 */
public interface SubcomponentEndpoint extends EndPoint {
	/**
	 * Returns the value of the '<em><b>Subcomponent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property specifies a subcomponent to which the endpoit belongs.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Subcomponent</em>' reference.
	 * @see #setSubcomponent(SubcomponentInstance)
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getSubcomponentEndpoint_Subcomponent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SubcomponentInstance getSubcomponent();

	/**
	 * Sets the value of the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint#getSubcomponent <em>Subcomponent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subcomponent</em>' reference.
	 * @see #getSubcomponent()
	 * @generated
	 */
	void setSubcomponent(SubcomponentInstance value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property specifies port type of subcomponent endpoint.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Port</em>' reference.
	 * @see #setPort(Port)
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getSubcomponentEndpoint_Port()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Port getPort();

	/**
	 * Sets the value of the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentEndpoint#getPort <em>Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' reference.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(Port value);

} // SubcomponentEndpoint
