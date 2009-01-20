/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;

import de.uka.ipd.sdq.pcm.allocation.AllocationConnector;
import de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentAllocationConnector;
import de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.resourcetype.ControllerStack;
import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ResourceContainer denotes a physical machine which contains resources and on which components are deployed.
 * It contains ProcessingResourceSpecifications which describe the deployed resources, as well as ControllerInstances, which are instances of controller types.
 * Controller instances are layered. Such layered controllers can be reused (see ControllerStack)
 * If no controllers are reused, ControllerInstances can be specified nevertheless.
 * Two ResourceContainers can be connected by a LinkingResource, which denotes some kind of network connection.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getActiveResourceSpecifications_ResourceContainer <em>Active Resource Specifications Resource Container</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getControllerInstances_ResourceContainer <em>Controller Instances Resource Container</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getControllerStack_ResourceContainer <em>Controller Stack Resource Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceContainer()
 * @model
 * @generated
 */
public interface ResourceContainer extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Active Resource Specifications Resource Container</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Resource Specifications Resource Container</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Resource Specifications Resource Container</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceContainer_ActiveResourceSpecifications_ResourceContainer()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ProcessingResourceSpecification> getActiveResourceSpecifications_ResourceContainer();

	/**
	 * Returns the value of the '<em><b>Controller Instances Resource Container</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourceenvironment.ControllerInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controller Instances Resource Container</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controller Instances Resource Container</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceContainer_ControllerInstances_ResourceContainer()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ControllerInstance> getControllerInstances_ResourceContainer();

	/**
	 * Returns the value of the '<em><b>Controller Stack Resource Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controller Stack Resource Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controller Stack Resource Container</em>' reference.
	 * @see #setControllerStack_ResourceContainer(ControllerStack)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceContainer_ControllerStack_ResourceContainer()
	 * @model ordered="false"
	 * @generated
	 */
	ControllerStack getControllerStack_ResourceContainer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getControllerStack_ResourceContainer <em>Controller Stack Resource Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Controller Stack Resource Container</em>' reference.
	 * @see #getControllerStack_ResourceContainer()
	 * @generated
	 */
	void setControllerStack_ResourceContainer(ControllerStack value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.controllerInstances_ResourceContainer->select(instance|instance.controllerLayer_ControllerInstance.upperLayer->asBag()->isEmpty())->size() = 1
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ForAllControllerLayersOnlyOneLayerIsTheUppestOne(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.controllerInstances_ResourceContainer->select(instance|instance.controllerLayer_ControllerInstance.lowerLayer->asBag()->isEmpty())->size() = 1
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ForAllControllerLayersOnlyOneLayerIsTheLowestOne(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ResourceContainer
