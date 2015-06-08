/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.allocation.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.util.AllocationValidator;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.EventChannel;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Context</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl#getResourceContainer_AllocationContext
 * <em>Resource Container Allocation Context</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl#getAssemblyContext_AllocationContext
 * <em>Assembly Context Allocation Context</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl#getAllocation_AllocationContext
 * <em>Allocation Allocation Context</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl#getEventChannel__AllocationContext
 * <em>Event Channel Allocation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllocationContextImpl extends EntityImpl implements AllocationContext {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getResourceContainer_AllocationContext()
     * <em>Resource Container Allocation Context</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getResourceContainer_AllocationContext()
     * @generated
     * @ordered
     */
    protected ResourceContainer resourceContainer_AllocationContext;

    /**
     * The cached value of the '{@link #getAssemblyContext_AllocationContext()
     * <em>Assembly Context Allocation Context</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getAssemblyContext_AllocationContext()
     * @generated
     * @ordered
     */
    protected AssemblyContext assemblyContext_AllocationContext;

    /**
     * The cached value of the '{@link #getEventChannel__AllocationContext()
     * <em>Event Channel Allocation Context</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getEventChannel__AllocationContext()
     * @generated
     * @ordered
     */
    protected EventChannel eventChannel__AllocationContext;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AllocationContextImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AllocationPackage.Literals.ALLOCATION_CONTEXT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceContainer getResourceContainer_AllocationContext() {
        if (this.resourceContainer_AllocationContext != null
                && ((EObject) this.resourceContainer_AllocationContext).eIsProxy()) {
            final InternalEObject oldResourceContainer_AllocationContext = (InternalEObject) this.resourceContainer_AllocationContext;
            this.resourceContainer_AllocationContext = (ResourceContainer) this
                    .eResolveProxy(oldResourceContainer_AllocationContext);
            if (this.resourceContainer_AllocationContext != oldResourceContainer_AllocationContext) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT,
                            oldResourceContainer_AllocationContext, this.resourceContainer_AllocationContext));
                }
            }
        }
        return this.resourceContainer_AllocationContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceContainer basicGetResourceContainer_AllocationContext() {
        return this.resourceContainer_AllocationContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceContainer_AllocationContext(final ResourceContainer newResourceContainer_AllocationContext) {
        final ResourceContainer oldResourceContainer_AllocationContext = this.resourceContainer_AllocationContext;
        this.resourceContainer_AllocationContext = newResourceContainer_AllocationContext;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT,
                    oldResourceContainer_AllocationContext, this.resourceContainer_AllocationContext));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContext getAssemblyContext_AllocationContext() {
        if (this.assemblyContext_AllocationContext != null
                && ((EObject) this.assemblyContext_AllocationContext).eIsProxy()) {
            final InternalEObject oldAssemblyContext_AllocationContext = (InternalEObject) this.assemblyContext_AllocationContext;
            this.assemblyContext_AllocationContext = (AssemblyContext) this
                    .eResolveProxy(oldAssemblyContext_AllocationContext);
            if (this.assemblyContext_AllocationContext != oldAssemblyContext_AllocationContext) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT,
                            oldAssemblyContext_AllocationContext, this.assemblyContext_AllocationContext));
                }
            }
        }
        return this.assemblyContext_AllocationContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext_AllocationContext() {
        return this.assemblyContext_AllocationContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAssemblyContext_AllocationContext(final AssemblyContext newAssemblyContext_AllocationContext) {
        final AssemblyContext oldAssemblyContext_AllocationContext = this.assemblyContext_AllocationContext;
        this.assemblyContext_AllocationContext = newAssemblyContext_AllocationContext;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT,
                    oldAssemblyContext_AllocationContext, this.assemblyContext_AllocationContext));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Allocation getAllocation_AllocationContext() {
        if (this.eContainerFeatureID() != AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT) {
            return null;
        }
        return (Allocation) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetAllocation_AllocationContext(final Allocation newAllocation_AllocationContext,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newAllocation_AllocationContext,
                AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAllocation_AllocationContext(final Allocation newAllocation_AllocationContext) {
        if (newAllocation_AllocationContext != this.eInternalContainer()
                || (this.eContainerFeatureID() != AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT && newAllocation_AllocationContext != null)) {
            if (EcoreUtil.isAncestor(this, newAllocation_AllocationContext)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newAllocation_AllocationContext != null) {
                msgs = ((InternalEObject) newAllocation_AllocationContext).eInverseAdd(this,
                        AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION, Allocation.class, msgs);
            }
            msgs = this.basicSetAllocation_AllocationContext(newAllocation_AllocationContext, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT,
                    newAllocation_AllocationContext, newAllocation_AllocationContext));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EventChannel getEventChannel__AllocationContext() {
        if (this.eventChannel__AllocationContext != null && ((EObject) this.eventChannel__AllocationContext).eIsProxy()) {
            final InternalEObject oldEventChannel__AllocationContext = (InternalEObject) this.eventChannel__AllocationContext;
            this.eventChannel__AllocationContext = (EventChannel) this
                    .eResolveProxy(oldEventChannel__AllocationContext);
            if (this.eventChannel__AllocationContext != oldEventChannel__AllocationContext) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            AllocationPackage.ALLOCATION_CONTEXT__EVENT_CHANNEL_ALLOCATION_CONTEXT,
                            oldEventChannel__AllocationContext, this.eventChannel__AllocationContext));
                }
            }
        }
        return this.eventChannel__AllocationContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public EventChannel basicGetEventChannel__AllocationContext() {
        return this.eventChannel__AllocationContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setEventChannel__AllocationContext(final EventChannel newEventChannel__AllocationContext) {
        final EventChannel oldEventChannel__AllocationContext = this.eventChannel__AllocationContext;
        this.eventChannel__AllocationContext = newEventChannel__AllocationContext;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    AllocationPackage.ALLOCATION_CONTEXT__EVENT_CHANNEL_ALLOCATION_CONTEXT,
                    oldEventChannel__AllocationContext, this.eventChannel__AllocationContext));
        }
    }

    /**
     * The cached OCL expression body for the '
     * {@link #OneAssemblyContextOrOneEventChannelShouldBeReferred(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>One Assembly Context Or One Event Channel Should Be Referred</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #OneAssemblyContextOrOneEventChannelShouldBeReferred(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String ONE_ASSEMBLY_CONTEXT_OR_ONE_EVENT_CHANNEL_SHOULD_BE_REFERRED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not(self.assemblyContext_AllocationContext.oclIsUndefined()) xor not(self.eventChannel__AllocationContext.oclIsUndefined())";

    /**
     * The cached OCL invariant for the '
     * {@link #OneAssemblyContextOrOneEventChannelShouldBeReferred(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>One Assembly Context Or One Event Channel Should Be Referred</em>}' invariant operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #OneAssemblyContextOrOneEventChannelShouldBeReferred(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint ONE_ASSEMBLY_CONTEXT_OR_ONE_EVENT_CHANNEL_SHOULD_BE_REFERRED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean OneAssemblyContextOrOneEventChannelShouldBeReferred(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (ONE_ASSEMBLY_CONTEXT_OR_ONE_EVENT_CHANNEL_SHOULD_BE_REFERRED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(AllocationPackage.Literals.ALLOCATION_CONTEXT);
            try {
                ONE_ASSEMBLY_CONTEXT_OR_ONE_EVENT_CHANNEL_SHOULD_BE_REFERRED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(ONE_ASSEMBLY_CONTEXT_OR_ONE_EVENT_CHANNEL_SHOULD_BE_REFERRED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                ONE_ASSEMBLY_CONTEXT_OR_ONE_EVENT_CHANNEL_SHOULD_BE_REFERRED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(
                        this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        AllocationValidator.DIAGNOSTIC_SOURCE,
                        AllocationValidator.ALLOCATION_CONTEXT__ONE_ASSEMBLY_CONTEXT_OR_ONE_EVENT_CHANNEL_SHOULD_BE_REFERRED,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                new Object[] { "OneAssemblyContextOrOneEventChannelShouldBeReferred",
                                EObjectValidator.getObjectLabel(this, context) }),
                                new Object[] { this }));
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
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetAllocation_AllocationContext((Allocation) otherEnd, msgs);
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
        case AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT:
            return this.basicSetAllocation_AllocationContext(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT:
            return this.eInternalContainer().eInverseRemove(this,
                    AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION, Allocation.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
            if (resolve) {
                return this.getResourceContainer_AllocationContext();
            }
            return this.basicGetResourceContainer_AllocationContext();
        case AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
            if (resolve) {
                return this.getAssemblyContext_AllocationContext();
            }
            return this.basicGetAssemblyContext_AllocationContext();
        case AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT:
            return this.getAllocation_AllocationContext();
        case AllocationPackage.ALLOCATION_CONTEXT__EVENT_CHANNEL_ALLOCATION_CONTEXT:
            if (resolve) {
                return this.getEventChannel__AllocationContext();
            }
            return this.basicGetEventChannel__AllocationContext();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
            this.setResourceContainer_AllocationContext((ResourceContainer) newValue);
            return;
        case AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
            this.setAssemblyContext_AllocationContext((AssemblyContext) newValue);
            return;
        case AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT:
            this.setAllocation_AllocationContext((Allocation) newValue);
            return;
        case AllocationPackage.ALLOCATION_CONTEXT__EVENT_CHANNEL_ALLOCATION_CONTEXT:
            this.setEventChannel__AllocationContext((EventChannel) newValue);
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
        case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
            this.setResourceContainer_AllocationContext((ResourceContainer) null);
            return;
        case AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
            this.setAssemblyContext_AllocationContext((AssemblyContext) null);
            return;
        case AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT:
            this.setAllocation_AllocationContext((Allocation) null);
            return;
        case AllocationPackage.ALLOCATION_CONTEXT__EVENT_CHANNEL_ALLOCATION_CONTEXT:
            this.setEventChannel__AllocationContext((EventChannel) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
            return this.resourceContainer_AllocationContext != null;
        case AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
            return this.assemblyContext_AllocationContext != null;
        case AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT:
            return this.getAllocation_AllocationContext() != null;
        case AllocationPackage.ALLOCATION_CONTEXT__EVENT_CHANNEL_ALLOCATION_CONTEXT:
            return this.eventChannel__AllocationContext != null;
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

} // AllocationContextImpl
