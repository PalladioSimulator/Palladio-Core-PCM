/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.util.AllocationValidator;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Allocation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationImpl#getTargetResourceEnvironment_Allocation
 * <em>Target Resource Environment Allocation</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationImpl#getSystem_Allocation <em>System
 * Allocation</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationImpl#getAllocationContexts_Allocation
 * <em>Allocation Contexts Allocation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllocationImpl extends EntityImpl implements Allocation {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getTargetResourceEnvironment_Allocation()
     * <em>Target Resource Environment Allocation</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getTargetResourceEnvironment_Allocation()
     * @generated
     * @ordered
     */
    protected ResourceEnvironment targetResourceEnvironment_Allocation;

    /**
     * The cached value of the '{@link #getSystem_Allocation() <em>System Allocation</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSystem_Allocation()
     * @generated
     * @ordered
     */
    protected de.uka.ipd.sdq.pcm.system.System system_Allocation;

    /**
     * The cached value of the '{@link #getAllocationContexts_Allocation()
     * <em>Allocation Contexts Allocation</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getAllocationContexts_Allocation()
     * @generated
     * @ordered
     */
    protected EList<AllocationContext> allocationContexts_Allocation;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AllocationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AllocationPackage.Literals.ALLOCATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceEnvironment getTargetResourceEnvironment_Allocation() {
        if (this.targetResourceEnvironment_Allocation != null
                && ((EObject) this.targetResourceEnvironment_Allocation).eIsProxy()) {
            final InternalEObject oldTargetResourceEnvironment_Allocation = (InternalEObject) this.targetResourceEnvironment_Allocation;
            this.targetResourceEnvironment_Allocation = (ResourceEnvironment) this
                    .eResolveProxy(oldTargetResourceEnvironment_Allocation);
            if (this.targetResourceEnvironment_Allocation != oldTargetResourceEnvironment_Allocation) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION,
                            oldTargetResourceEnvironment_Allocation, this.targetResourceEnvironment_Allocation));
                }
            }
        }
        return this.targetResourceEnvironment_Allocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceEnvironment basicGetTargetResourceEnvironment_Allocation() {
        return this.targetResourceEnvironment_Allocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTargetResourceEnvironment_Allocation(
            final ResourceEnvironment newTargetResourceEnvironment_Allocation) {
        final ResourceEnvironment oldTargetResourceEnvironment_Allocation = this.targetResourceEnvironment_Allocation;
        this.targetResourceEnvironment_Allocation = newTargetResourceEnvironment_Allocation;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION,
                    oldTargetResourceEnvironment_Allocation, this.targetResourceEnvironment_Allocation));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public de.uka.ipd.sdq.pcm.system.System getSystem_Allocation() {
        if (this.system_Allocation != null && ((EObject) this.system_Allocation).eIsProxy()) {
            final InternalEObject oldSystem_Allocation = (InternalEObject) this.system_Allocation;
            this.system_Allocation = (de.uka.ipd.sdq.pcm.system.System) this.eResolveProxy(oldSystem_Allocation);
            if (this.system_Allocation != oldSystem_Allocation) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION, oldSystem_Allocation,
                            this.system_Allocation));
                }
            }
        }
        return this.system_Allocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public de.uka.ipd.sdq.pcm.system.System basicGetSystem_Allocation() {
        return this.system_Allocation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSystem_Allocation(final de.uka.ipd.sdq.pcm.system.System newSystem_Allocation) {
        final de.uka.ipd.sdq.pcm.system.System oldSystem_Allocation = this.system_Allocation;
        this.system_Allocation = newSystem_Allocation;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION,
                    oldSystem_Allocation, this.system_Allocation));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<AllocationContext> getAllocationContexts_Allocation() {
        if (this.allocationContexts_Allocation == null) {
            this.allocationContexts_Allocation = new EObjectContainmentWithInverseEList<AllocationContext>(
                    AllocationContext.class, this, AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION,
                    AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT);
        }
        return this.allocationContexts_Allocation;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Each Assembly Context Within System Has To Be Allocated Exactly Once</em>}' operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String EACH_ASSEMBLY_CONTEXT_WITHIN_SYSTEM_HAS_TO_BE_ALLOCATED_EXACTLY_ONCE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "-- Get all AssemblyContexts used by this system, that is \n"
            + "-- 1) the AssemblyContexts directly used in the system and \n"
            + "self.system_Allocation.assemblyContexts__ComposedStructure\n"
            + "-- 2) the AssemblyContexts used by SubSystems in the System. Note that if a SubSystem also contains other Subsystems,\n"
            + "-- we need to get those AssemblyContexts too: Thus, we use a closure here\n"
            + "->union(self.system_Allocation.assemblyContexts__ComposedStructure->closure(\n"
            + "encapsulatedComponent__AssemblyContext->select(composites|composites.oclIsTypeOf(pcm::subsystem::SubSystem)).oclAsType(pcm::subsystem::SubSystem)\n"
            + ".assemblyContexts__ComposedStructure))\n"
            + "--Now, after we collected all AssemblyContexts somehow used, we check whether they need to be allocated \n"
            + "--and if yes, if they are allocated.\n"
            + "->forAll(assemblyCtx|\n"
            + "--AssemblyContexts that contain SubSystems do not need to be allocated\n"
            + "assemblyCtx.encapsulatedComponent__AssemblyContext.oclIsTypeOf(pcm::subsystem::SubSystem) or\n"
            + "--All others need to be allocated. \n"
            + "self.allocationContexts_Allocation->select(allocationCtx|\n"
            + "allocationCtx.assemblyContext_AllocationContext = assemblyCtx)->size() = 1)";

    /**
     * The cached OCL invariant for the '
     * {@link #EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Each Assembly Context Within System Has To Be Allocated Exactly Once</em>}' invariant
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint EACH_ASSEMBLY_CONTEXT_WITHIN_SYSTEM_HAS_TO_BE_ALLOCATED_EXACTLY_ONCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (EACH_ASSEMBLY_CONTEXT_WITHIN_SYSTEM_HAS_TO_BE_ALLOCATED_EXACTLY_ONCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(AllocationPackage.Literals.ALLOCATION);
            try {
                EACH_ASSEMBLY_CONTEXT_WITHIN_SYSTEM_HAS_TO_BE_ALLOCATED_EXACTLY_ONCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(EACH_ASSEMBLY_CONTEXT_WITHIN_SYSTEM_HAS_TO_BE_ALLOCATED_EXACTLY_ONCE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                EACH_ASSEMBLY_CONTEXT_WITHIN_SYSTEM_HAS_TO_BE_ALLOCATED_EXACTLY_ONCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        AllocationValidator.DIAGNOSTIC_SOURCE,
                        AllocationValidator.ALLOCATION__EACH_ASSEMBLY_CONTEXT_WITHIN_SYSTEM_HAS_TO_BE_ALLOCATED_EXACTLY_ONCE,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                new Object[] { "EachAssemblyContextWithinSystemHasToBeAllocatedExactlyOnce",
                                EObjectValidator.getObjectLabel(this, context) }),
                                new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #CommunicatingServersHaveToBeConnectedByLinkingResource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Communicating Servers Have To Be Connected By Linking Resource</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #CommunicatingServersHaveToBeConnectedByLinkingResource(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String COMMUNICATING_SERVERS_HAVE_TO_BE_CONNECTED_BY_LINKING_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.allocationContexts_Allocation->forAll(a | self.allocationContexts_Allocation->forAll(b | \n"
            + "    --- if a and b are not on the same server\n"
            + "    (a.resourceContainer_AllocationContext <> b.resourceContainer_AllocationContext \n"
            + "    and\n"
            + "    --  and if the assembly contexts of a and b are connected\n"
            + "      self.system_Allocation.connectors__ComposedStructure->select(conn | conn.oclIsTypeOf(pcm::core::composition::AssemblyConnector)).oclAsType(pcm::core::composition::AssemblyConnector)->exists(conn | \n"
            + "         (conn.providingAssemblyContext_AssemblyConnector = a.assemblyContext_AllocationContext  \n"
            + "         and \n"
            + "         conn.requiringAssemblyContext_AssemblyConnector = b.assemblyContext_AllocationContext )\n"
            + "         or \n"
            + "          (conn.providingAssemblyContext_AssemblyConnector = b.assemblyContext_AllocationContext  \n"
            + "         and \n"
            + "         conn.requiringAssemblyContext_AssemblyConnector = a.assemblyContext_AllocationContext )\n"
            + "       )\n"
            + "     )\n"
            + "     -- then the servers have to be connected by a linking resource\n"
            + "     implies \n"
            + "     self.targetResourceEnvironment_Allocation.linkingResources__ResourceEnvironment->exists(l | \n"
            + "        -- l connects the two\n"
            + "        l.connectedResourceContainers_LinkingResource->includes(a.resourceContainer_AllocationContext)\n"
            + "        and \n"
            + "        l.connectedResourceContainers_LinkingResource->includes(b.resourceContainer_AllocationContext)\n"
            + "     )\n" + "  ))";

    /**
     * The cached OCL invariant for the '
     * {@link #CommunicatingServersHaveToBeConnectedByLinkingResource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Communicating Servers Have To Be Connected By Linking Resource</em>}' invariant
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #CommunicatingServersHaveToBeConnectedByLinkingResource(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint COMMUNICATING_SERVERS_HAVE_TO_BE_CONNECTED_BY_LINKING_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean CommunicatingServersHaveToBeConnectedByLinkingResource(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (COMMUNICATING_SERVERS_HAVE_TO_BE_CONNECTED_BY_LINKING_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(AllocationPackage.Literals.ALLOCATION);
            try {
                COMMUNICATING_SERVERS_HAVE_TO_BE_CONNECTED_BY_LINKING_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(COMMUNICATING_SERVERS_HAVE_TO_BE_CONNECTED_BY_LINKING_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                COMMUNICATING_SERVERS_HAVE_TO_BE_CONNECTED_BY_LINKING_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(
                        this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, AllocationValidator.DIAGNOSTIC_SOURCE,
                        AllocationValidator.ALLOCATION__COMMUNICATING_SERVERS_HAVE_TO_BE_CONNECTED_BY_LINKING_RESOURCE,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                new Object[] { "CommunicatingServersHaveToBeConnectedByLinkingResource",
                                EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getAllocationContexts_Allocation())
                    .basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
            return ((InternalEList<?>) this.getAllocationContexts_Allocation()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
            if (resolve) {
                return this.getTargetResourceEnvironment_Allocation();
            }
            return this.basicGetTargetResourceEnvironment_Allocation();
        case AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION:
            if (resolve) {
                return this.getSystem_Allocation();
            }
            return this.basicGetSystem_Allocation();
        case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
            return this.getAllocationContexts_Allocation();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
            this.setTargetResourceEnvironment_Allocation((ResourceEnvironment) newValue);
            return;
        case AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION:
            this.setSystem_Allocation((de.uka.ipd.sdq.pcm.system.System) newValue);
            return;
        case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
            this.getAllocationContexts_Allocation().clear();
            this.getAllocationContexts_Allocation().addAll((Collection<? extends AllocationContext>) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
            this.setTargetResourceEnvironment_Allocation((ResourceEnvironment) null);
            return;
        case AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION:
            this.setSystem_Allocation((de.uka.ipd.sdq.pcm.system.System) null);
            return;
        case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
            this.getAllocationContexts_Allocation().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case AllocationPackage.ALLOCATION__TARGET_RESOURCE_ENVIRONMENT_ALLOCATION:
            return this.targetResourceEnvironment_Allocation != null;
        case AllocationPackage.ALLOCATION__SYSTEM_ALLOCATION:
            return this.system_Allocation != null;
        case AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION:
            return this.allocationContexts_Allocation != null && !this.allocationContexts_Allocation.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * The cached environment for evaluating OCL expressions. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // AllocationImpl
