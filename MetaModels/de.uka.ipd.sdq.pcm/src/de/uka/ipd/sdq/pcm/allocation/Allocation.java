/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.mdsdprofiles.ProfileableElement;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Allocation</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc --> The allocation repository holding all available allocation contexts of a
 * model. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getTargetResourceEnvironment_Allocation <em>
 * Target Resource Environment Allocation</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getSystem_Allocation <em>System Allocation
 * </em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getAllocationContexts_Allocation <em>
 * Allocation Contexts Allocation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation()
 * @model
 * @generated
 */
public interface Allocation extends ProfileableElement, Entity {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Target Resource Environment Allocation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Resource Environment Allocation</em>' reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Target Resource Environment Allocation</em>' reference.
     * @see #setTargetResourceEnvironment_Allocation(ResourceEnvironment)
     * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation_TargetResourceEnvironment_Allocation()
     * @model ordered="false"
     * @generated
     */
    ResourceEnvironment getTargetResourceEnvironment_Allocation();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.allocation.Allocation#getTargetResourceEnvironment_Allocation
     * <em>Target Resource Environment Allocation</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Target Resource Environment Allocation</em>' reference.
     * @see #getTargetResourceEnvironment_Allocation()
     * @generated
     */
    void setTargetResourceEnvironment_Allocation(ResourceEnvironment value);

    /**
     * Returns the value of the '<em><b>System Allocation</b></em>' reference. <!-- begin-user-doc
     * -->
     * <p>
     * If the meaning of the '<em>System Allocation</em>' reference isn't clear, there really should
     * be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>System Allocation</em>' reference.
     * @see #setSystem_Allocation(de.uka.ipd.sdq.pcm.system.System)
     * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation_System_Allocation()
     * @model required="true" ordered="false"
     * @generated
     */
    de.uka.ipd.sdq.pcm.system.System getSystem_Allocation();

    /**
     * Sets the value of the '{@link de.uka.ipd.sdq.pcm.allocation.Allocation#getSystem_Allocation
     * <em>System Allocation</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>System Allocation</em>' reference.
     * @see #getSystem_Allocation()
     * @generated
     */
    void setSystem_Allocation(de.uka.ipd.sdq.pcm.system.System value);

    /**
     * Returns the value of the '<em><b>Allocation Contexts Allocation</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.pcm.allocation.AllocationContext}. It is bidirectional and its opposite
     * is '{@link de.uka.ipd.sdq.pcm.allocation.AllocationContext#getAllocation_AllocationContext
     * <em>Allocation Allocation Context</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Allocation Contexts Allocation</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Allocation Contexts Allocation</em>' containment reference
     *         list.
     * @see de.uka.ipd.sdq.pcm.allocation.AllocationPackage#getAllocation_AllocationContexts_Allocation()
     * @see de.uka.ipd.sdq.pcm.allocation.AllocationContext#getAllocation_AllocationContext
     * @model opposite="allocation_AllocationContext" containment="true" ordered="false"
     * @generated
     */
    EList<AllocationContext> getAllocationContexts_Allocation();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Each Assembly of
     * BasicComponents and CompositeComponents used in the referenced System must be allocated.
     *
     * Things are complicated by the introduction of SubSystems. Here, the Assembly of the SubSystem
     * itself does not have to be allocated. If it is not allocated, all BasicComponents and
     * CompositeComponents contained in this SubSystem (also transitively over several nested and
     * not-allocated SubSystems) need to be allocated.
     *
     * The constraint is realised wth a closure over the AssemblyContext contained in a
     * ComposedStructure.
     *
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model annotation=
     *        "http://www.eclipse.org/uml2/1.1.0/GenModel body='-- Get all AssemblyContexts used by this system, that is \r\n-- 1) the AssemblyContexts directly used in the system and \r\nself.system_Allocation.assemblyContexts__ComposedStructure\r\n-- 2) the AssemblyContexts used by SubSystems in the System. Note that if a SubSystem also contains other Subsystems,\r\n-- we need to get those AssemblyContexts too: Thus, we use a closure here\r\n->union(self.system_Allocation.assemblyContexts__ComposedStructure->closure(\r\nencapsulatedComponent__AssemblyContext->select(composites|composites.oclIsTypeOf(pcm::subsystem::SubSystem)).oclAsType(pcm::subsystem::SubSystem)\r\n.assemblyContexts__ComposedStructure))\r\n--Now, after we collected all AssemblyContexts somehow used, we check whether they need to be allocated \r\n--and if yes, if they are allocated.\r\n->forAll(assemblyCtx|\r\n--AssemblyContexts that contain SubSystems do not need to be allocated\r\nassemblyCtx.encapsulatedComponent__AssemblyContext.oclIsTypeOf(pcm::subsystem::SubSystem) or\r\n--All others need to be allocated. \r\nself.allocationContexts_Allocation->select(allocationCtx|\r\nallocationCtx.assemblyContext_AllocationContext = assemblyCtx)->size() = 1)'"
     * @generated
     */
    boolean EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce(DiagnosticChain diagnostics,
            Map<Object, Object> context);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     *
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model annotation=
     *        "http://www.eclipse.org/uml2/1.1.0/GenModel body='self.allocationContexts_Allocation->forAll(a | self.allocationContexts_Allocation->forAll(b | \r\n    --- if a and b are not on the same server\r\n    (a.resourceContainer_AllocationContext <> b.resourceContainer_AllocationContext \r\n    and\r\n    --  and if the assembly contexts of a and b are connected\r\n      self.system_Allocation.connectors__ComposedStructure->select(conn | conn.oclIsTypeOf(pcm::core::composition::AssemblyConnector)).oclAsType(pcm::core::composition::AssemblyConnector)->exists(conn | \r\n         (conn.providingAssemblyContext_AssemblyConnector = a.assemblyContext_AllocationContext  \r\n         and \r\n         conn.requiringAssemblyContext_AssemblyConnector = b.assemblyContext_AllocationContext )\r\n         or \r\n          (conn.providingAssemblyContext_AssemblyConnector = b.assemblyContext_AllocationContext  \r\n         and \r\n         conn.requiringAssemblyContext_AssemblyConnector = a.assemblyContext_AllocationContext )\r\n       )\r\n     )\r\n     -- then the servers have to be connected by a linking resource\r\n     implies \r\n     self.targetResourceEnvironment_Allocation.linkingResources__ResourceEnvironment->exists(l | \r\n        -- l connects the two\r\n        l.connectedResourceContainers_LinkingResource->includes(a.resourceContainer_AllocationContext)\r\n        and \r\n        l.connectedResourceContainers_LinkingResource->includes(b.resourceContainer_AllocationContext)\r\n     )\r\n  ))'"
     * @generated
     */
    boolean CommunicatingServersHaveToBeConnectedByLinkingResource(DiagnosticChain diagnostics,
            Map<Object, Object> context);

} // Allocation
