/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.ResourceSignature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     A named variable, e.g. a component, call, or return parameter.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.Variable#getEventType__Variable <em>Event Type Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.Variable#getImplementationComponentType_Variable <em>Implementation Component Type Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.Variable#getDataType__Variable <em>Data Type Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.Variable#getCompositeDataType_Variable <em>Composite Data Type Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.Variable#getResourceSignature__Variable <em>Resource Signature Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.Variable#getInfrastructureSignature__Variable <em>Infrastructure Signature Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.Variable#getOperationSignature__Variable <em>Operation Signature Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Event Type Variable</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.EventType#getPayload__EventType <em>Payload Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Type Variable</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Type Variable</em>' container reference.
	 * @see #setEventType__Variable(EventType)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariable_EventType__Variable()
	 * @see de.uka.ipd.sdq.pcm.repository.EventType#getPayload__EventType
	 * @model opposite="payload__EventType" transient="false" ordered="false"
	 * @generated
	 */
	EventType getEventType__Variable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getEventType__Variable <em>Event Type Variable</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Type Variable</em>' container reference.
	 * @see #getEventType__Variable()
	 * @generated
	 */
	void setEventType__Variable(EventType value);

	/**
	 * Returns the value of the '<em><b>Implementation Component Type Variable</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.ImplementationComponentType#getComponentParameter_ImplementationComponentType <em>Component Parameter Implementation Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Component Type Variable</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Component Type Variable</em>' container reference.
	 * @see #setImplementationComponentType_Variable(ImplementationComponentType)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariable_ImplementationComponentType_Variable()
	 * @see de.uka.ipd.sdq.pcm.repository.ImplementationComponentType#getComponentParameter_ImplementationComponentType
	 * @model opposite="componentParameter_ImplementationComponentType" transient="false" ordered="false"
	 * @generated
	 */
	ImplementationComponentType getImplementationComponentType_Variable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getImplementationComponentType_Variable <em>Implementation Component Type Variable</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Component Type Variable</em>' container reference.
	 * @see #getImplementationComponentType_Variable()
	 * @generated
	 */
	void setImplementationComponentType_Variable(ImplementationComponentType value);

	/**
	 * Returns the value of the '<em><b>Data Type Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type Variable</em>' reference.
	 * @see #setDataType__Variable(DataType)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariable_DataType__Variable()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getDataType__Variable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getDataType__Variable <em>Data Type Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type Variable</em>' reference.
	 * @see #getDataType__Variable()
	 * @generated
	 */
	void setDataType__Variable(DataType value);

	/**
	 * Returns the value of the '<em><b>Composite Data Type Variable</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.CompositeDataType#getMembers_CompositeDataType <em>Members Composite Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite Data Type Variable</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Data Type Variable</em>' container reference.
	 * @see #setCompositeDataType_Variable(CompositeDataType)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariable_CompositeDataType_Variable()
	 * @see de.uka.ipd.sdq.pcm.repository.CompositeDataType#getMembers_CompositeDataType
	 * @model opposite="members_CompositeDataType" transient="false" ordered="false"
	 * @generated
	 */
	CompositeDataType getCompositeDataType_Variable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getCompositeDataType_Variable <em>Composite Data Type Variable</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Data Type Variable</em>' container reference.
	 * @see #getCompositeDataType_Variable()
	 * @generated
	 */
	void setCompositeDataType_Variable(CompositeDataType value);

	/**
	 * Returns the value of the '<em><b>Resource Signature Variable</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.ResourceSignature#getParmeter__ResourceSignature <em>Parmeter Resource Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Signature Variable</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Signature Variable</em>' container reference.
	 * @see #setResourceSignature__Variable(ResourceSignature)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariable_ResourceSignature__Variable()
	 * @see de.uka.ipd.sdq.pcm.repository.ResourceSignature#getParmeter__ResourceSignature
	 * @model opposite="parmeter__ResourceSignature" transient="false" ordered="false"
	 * @generated
	 */
	ResourceSignature getResourceSignature__Variable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getResourceSignature__Variable <em>Resource Signature Variable</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Signature Variable</em>' container reference.
	 * @see #getResourceSignature__Variable()
	 * @generated
	 */
	void setResourceSignature__Variable(ResourceSignature value);

	/**
	 * Returns the value of the '<em><b>Infrastructure Signature Variable</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.InfrastructureSignature#getParameters__InfrastructureSignature <em>Parameters Infrastructure Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infrastructure Signature Variable</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infrastructure Signature Variable</em>' container reference.
	 * @see #setInfrastructureSignature__Variable(InfrastructureSignature)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariable_InfrastructureSignature__Variable()
	 * @see de.uka.ipd.sdq.pcm.repository.InfrastructureSignature#getParameters__InfrastructureSignature
	 * @model opposite="parameters__InfrastructureSignature" transient="false" ordered="false"
	 * @generated
	 */
	InfrastructureSignature getInfrastructureSignature__Variable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getInfrastructureSignature__Variable <em>Infrastructure Signature Variable</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infrastructure Signature Variable</em>' container reference.
	 * @see #getInfrastructureSignature__Variable()
	 * @generated
	 */
	void setInfrastructureSignature__Variable(InfrastructureSignature value);

	/**
	 * Returns the value of the '<em><b>Operation Signature Variable</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.OperationSignature#getParameters__OperationSignature <em>Parameters Operation Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property navigates to the signature this parameter is a part of.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operation Signature Variable</em>' container reference.
	 * @see #setOperationSignature__Variable(OperationSignature)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariable_OperationSignature__Variable()
	 * @see de.uka.ipd.sdq.pcm.repository.OperationSignature#getParameters__OperationSignature
	 * @model opposite="parameters__OperationSignature" transient="false" ordered="false"
	 * @generated
	 */
	OperationSignature getOperationSignature__Variable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getOperationSignature__Variable <em>Operation Signature Variable</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Signature Variable</em>' container reference.
	 * @see #getOperationSignature__Variable()
	 * @generated
	 */
	void setOperationSignature__Variable(OperationSignature value);

} // Variable
