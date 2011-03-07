/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation;

import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Component Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An InfrastructureComponentScope contains components which are used as infrastructure components, i. e. which are 
 * accessed through resource demands. As it inherits from ComposedProvidingRequiringEntity, it may contain any amount of 
 * components in an AssemblyContext.
 * An InfrastructureComponentScope references a ResourceContainer, on which the internal components of the 
 * InfrastructureComponentScope are deployed.
 * 
 * This entity is used for stacking Controllers. Any resource access on this ResourceContainer first has to go through the 
 * InfrastructureComponentScopes before it is issued to controllers and resources: If a Component specifies a ResourceDemand, it has to specify the ResourceService of the corresponding ResourceInterface.
 * Then, the most upper InfrastructureComponentScope is being checked if it provides the same ResourceInterface. If it provides the ResourceInterface, the resource demand is being issued 
 * to the InfrastructureComponentScope. Otherwise, the search is being repeated for the next InfrastructureComponentScope (lowerLayer). The last InfrastructureComponentScope does not have a further lowerLayer reference. Instead, the controllers and resources are being accessed.
 * This lookup occurs before simulation (automatically) and creates appropriate AllocationConnectors.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getLowerLayer <em>Lower Layer</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getUpperLayer <em>Upper Layer</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getResourceContainer_InfrastructureComponentScope <em>Resource Container Infrastructure Component Scope</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#isIsPartOfCycle <em>Is Part Of Cycle</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getInfrastructureComponentScope()
 * @model
 * @generated
 */
public interface InfrastructureComponentScope extends ComposedProvidingRequiringEntity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Lower Layer</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getUpperLayer <em>Upper Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Layer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Layer</em>' reference.
	 * @see #setLowerLayer(InfrastructureComponentScope)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getInfrastructureComponentScope_LowerLayer()
	 * @see de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getUpperLayer
	 * @model opposite="upperLayer" ordered="false"
	 * @generated
	 */
	InfrastructureComponentScope getLowerLayer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getLowerLayer <em>Lower Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Layer</em>' reference.
	 * @see #getLowerLayer()
	 * @generated
	 */
	void setLowerLayer(InfrastructureComponentScope value);

	/**
	 * Returns the value of the '<em><b>Upper Layer</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getLowerLayer <em>Lower Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Layer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Layer</em>' reference.
	 * @see #setUpperLayer(InfrastructureComponentScope)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getInfrastructureComponentScope_UpperLayer()
	 * @see de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getLowerLayer
	 * @model opposite="lowerLayer" ordered="false"
	 * @generated
	 */
	InfrastructureComponentScope getUpperLayer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getUpperLayer <em>Upper Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Layer</em>' reference.
	 * @see #getUpperLayer()
	 * @generated
	 */
	void setUpperLayer(InfrastructureComponentScope value);

	/**
	 * Returns the value of the '<em><b>Resource Container Infrastructure Component Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Container Infrastructure Component Scope</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Container Infrastructure Component Scope</em>' reference.
	 * @see #setResourceContainer_InfrastructureComponentScope(ResourceContainer)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getInfrastructureComponentScope_ResourceContainer_InfrastructureComponentScope()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ResourceContainer getResourceContainer_InfrastructureComponentScope();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#getResourceContainer_InfrastructureComponentScope <em>Resource Container Infrastructure Component Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Container Infrastructure Component Scope</em>' reference.
	 * @see #getResourceContainer_InfrastructureComponentScope()
	 * @generated
	 */
	void setResourceContainer_InfrastructureComponentScope(ResourceContainer value);

	/**
	 * Returns the value of the '<em><b>Is Part Of Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Part Of Cycle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Part Of Cycle</em>' attribute.
	 * @see #setIsPartOfCycle(boolean)
	 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getInfrastructureComponentScope_IsPartOfCycle()
	 * @model required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isIsPartOfCycle();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.InfrastructureComponentScope#isIsPartOfCycle <em>Is Part Of Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Part Of Cycle</em>' attribute.
	 * @see #isIsPartOfCycle()
	 * @generated
	 */
	void setIsPartOfCycle(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.requiredRoles_InterfaceRequiringEntity->size() = 0
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ScopeMustNotContainRequiredRoles(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.isPartOfCycle = false
	 * --not (self.lowerLayer->closure(self.lowerLayer))->includes(self.upperLayer)
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ScopeMustNotBePartOfACycle(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.resourceRequiredRoles_ResourceInterfaceRequiringEntity->size() = 0
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ScopeMustNotContainResourceRequiredRoles(DiagnosticChain diagnostics, Map<Object, Object> context);

} // InfrastructureComponentScope
