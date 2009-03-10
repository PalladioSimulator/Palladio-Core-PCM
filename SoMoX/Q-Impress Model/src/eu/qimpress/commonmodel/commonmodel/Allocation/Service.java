/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.Allocation;

import eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.Node;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeStructure;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Under the Element Service we understand service as (implicitly) deployed component, therefore Service Metaclass is part of Allocation Package. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.Allocation.Service#isIsBlackBox <em>Is Black Box</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.Allocation.Service#getNode <em>Node</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.Allocation.Service#getComponent <em>Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.Allocation.AllocationPackage#getService()
 * @model
 * @generated
 */
public interface Service extends CompositeStructure {
	/**
	 * Returns the value of the '<em><b>Is Black Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Each service could be BlackBox (derived attribute isBlackBox is true if subcomponents = 0) or composition that is readable and has no BlackBox property.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Black Box</em>' attribute.
	 * @see #setIsBlackBox(boolean)
	 * @see eu.qimpress.commonmodel.commonmodel.Allocation.AllocationPackage#getService_IsBlackBox()
	 * @model required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isIsBlackBox();

	/**
	 * Sets the value of the '{@link eu.qimpress.commonmodel.commonmodel.Allocation.Service#isIsBlackBox <em>Is Black Box</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Black Box</em>' attribute.
	 * @see #isIsBlackBox()
	 * @generated
	 */
	void setIsBlackBox(boolean value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference list.
	 * The list contents are of type {@link eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The node property of class Service determines the hardware node on which the service is run, i.e., this is the node on which the component referenced by the component property is allocated. The allocated component uses the hardware parts (e.g., CPU, disk, or memory) of this node.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node</em>' reference list.
	 * @see eu.qimpress.commonmodel.commonmodel.Allocation.AllocationPackage#getService_Node()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Node> getNode();

	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Each of introduced Services has a one component type associated. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see #setComponent(ComponentType)
	 * @see eu.qimpress.commonmodel.commonmodel.Allocation.AllocationPackage#getService_Component()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ComponentType getComponent();

	/**
	 * Sets the value of the '{@link eu.qimpress.commonmodel.commonmodel.Allocation.Service#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(ComponentType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.subcomponents->size() = 0
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean isBlackBox(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Service
