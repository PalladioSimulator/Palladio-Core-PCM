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
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Context</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl#getResourceContainer_AllocationContext <em>Resource Container Allocation Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl#getAssemblyContext_AllocationContext <em>Assembly Context Allocation Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl#getAllocation_AllocationContext <em>Allocation Allocation Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.allocation.impl.AllocationContextImpl#getEventChannel__AllocationContext <em>Event Channel Allocation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllocationContextImpl extends EntityImpl implements AllocationContext {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getResourceContainer_AllocationContext() <em>Resource Container Allocation Context</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getResourceContainer_AllocationContext()
     * @generated
     * @ordered
     */
    protected ResourceContainer resourceContainer_AllocationContext;

    /**
     * The cached value of the '{@link #getAssemblyContext_AllocationContext() <em>Assembly Context Allocation Context</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getAssemblyContext_AllocationContext()
     * @generated
     * @ordered
     */
    protected AssemblyContext assemblyContext_AllocationContext;

    /**
     * The cached value of the '{@link #getEventChannel__AllocationContext() <em>Event Channel Allocation Context</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getEventChannel__AllocationContext()
     * @generated
     * @ordered
     */
    protected EventChannel eventChannel__AllocationContext;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected AllocationContextImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return AllocationPackage.Literals.ALLOCATION_CONTEXT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ResourceContainer getResourceContainer_AllocationContext() {
        if (resourceContainer_AllocationContext != null && resourceContainer_AllocationContext.eIsProxy()) {
            InternalEObject oldResourceContainer_AllocationContext = (InternalEObject)resourceContainer_AllocationContext;
            resourceContainer_AllocationContext = (ResourceContainer)eResolveProxy(oldResourceContainer_AllocationContext);
            if (resourceContainer_AllocationContext != oldResourceContainer_AllocationContext) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT, oldResourceContainer_AllocationContext, resourceContainer_AllocationContext));
            }
        }
        return resourceContainer_AllocationContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ResourceContainer basicGetResourceContainer_AllocationContext() {
        return resourceContainer_AllocationContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setResourceContainer_AllocationContext(ResourceContainer newResourceContainer_AllocationContext) {
        ResourceContainer oldResourceContainer_AllocationContext = resourceContainer_AllocationContext;
        resourceContainer_AllocationContext = newResourceContainer_AllocationContext;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT, oldResourceContainer_AllocationContext, resourceContainer_AllocationContext));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getAssemblyContext_AllocationContext() {
        if (assemblyContext_AllocationContext != null && assemblyContext_AllocationContext.eIsProxy()) {
            InternalEObject oldAssemblyContext_AllocationContext = (InternalEObject)assemblyContext_AllocationContext;
            assemblyContext_AllocationContext = (AssemblyContext)eResolveProxy(oldAssemblyContext_AllocationContext);
            if (assemblyContext_AllocationContext != oldAssemblyContext_AllocationContext) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT, oldAssemblyContext_AllocationContext, assemblyContext_AllocationContext));
            }
        }
        return assemblyContext_AllocationContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext_AllocationContext() {
        return assemblyContext_AllocationContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setAssemblyContext_AllocationContext(AssemblyContext newAssemblyContext_AllocationContext) {
        AssemblyContext oldAssemblyContext_AllocationContext = assemblyContext_AllocationContext;
        assemblyContext_AllocationContext = newAssemblyContext_AllocationContext;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT, oldAssemblyContext_AllocationContext, assemblyContext_AllocationContext));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Allocation getAllocation_AllocationContext() {
        if (eContainerFeatureID() != AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT) return null;
        return (Allocation)eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetAllocation_AllocationContext(Allocation newAllocation_AllocationContext,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newAllocation_AllocationContext, AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setAllocation_AllocationContext(Allocation newAllocation_AllocationContext) {
        if (newAllocation_AllocationContext != eInternalContainer() || (eContainerFeatureID() != AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT && newAllocation_AllocationContext != null)) {
            if (EcoreUtil.isAncestor(this, newAllocation_AllocationContext))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newAllocation_AllocationContext != null)
                msgs = ((InternalEObject)newAllocation_AllocationContext).eInverseAdd(this, AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION, Allocation.class, msgs);
            msgs = basicSetAllocation_AllocationContext(newAllocation_AllocationContext, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT, newAllocation_AllocationContext, newAllocation_AllocationContext));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EventChannel getEventChannel__AllocationContext() {
        if (eventChannel__AllocationContext != null && eventChannel__AllocationContext.eIsProxy()) {
            InternalEObject oldEventChannel__AllocationContext = (InternalEObject)eventChannel__AllocationContext;
            eventChannel__AllocationContext = (EventChannel)eResolveProxy(oldEventChannel__AllocationContext);
            if (eventChannel__AllocationContext != oldEventChannel__AllocationContext) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationPackage.ALLOCATION_CONTEXT__EVENT_CHANNEL_ALLOCATION_CONTEXT, oldEventChannel__AllocationContext, eventChannel__AllocationContext));
            }
        }
        return eventChannel__AllocationContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EventChannel basicGetEventChannel__AllocationContext() {
        return eventChannel__AllocationContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setEventChannel__AllocationContext(EventChannel newEventChannel__AllocationContext) {
        EventChannel oldEventChannel__AllocationContext = eventChannel__AllocationContext;
        eventChannel__AllocationContext = newEventChannel__AllocationContext;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AllocationPackage.ALLOCATION_CONTEXT__EVENT_CHANNEL_ALLOCATION_CONTEXT, oldEventChannel__AllocationContext, eventChannel__AllocationContext));
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
     * The cached OCL invariant for the '{@link #OneAssemblyContextOrOneEventChannelShouldBeReferred(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>One Assembly Context Or One Event Channel Should Be Referred</em>}' invariant operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #OneAssemblyContextOrOneEventChannelShouldBeReferred(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint ONE_ASSEMBLY_CONTEXT_OR_ONE_EVENT_CHANNEL_SHOULD_BE_REFERRED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean OneAssemblyContextOrOneEventChannelShouldBeReferred(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (ONE_ASSEMBLY_CONTEXT_OR_ONE_EVENT_CHANNEL_SHOULD_BE_REFERRED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(AllocationPackage.Literals.ALLOCATION_CONTEXT);
            try {
                ONE_ASSEMBLY_CONTEXT_OR_ONE_EVENT_CHANNEL_SHOULD_BE_REFERRED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ONE_ASSEMBLY_CONTEXT_OR_ONE_EVENT_CHANNEL_SHOULD_BE_REFERRED__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            }
            catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(ONE_ASSEMBLY_CONTEXT_OR_ONE_EVENT_CHANNEL_SHOULD_BE_REFERRED__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         AllocationValidator.DIAGNOSTIC_SOURCE,
                         AllocationValidator.ALLOCATION_CONTEXT__ONE_ASSEMBLY_CONTEXT_OR_ONE_EVENT_CHANNEL_SHOULD_BE_REFERRED,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "OneAssemblyContextOrOneEventChannelShouldBeReferred", EObjectValidator.getObjectLabel(this, context) }),
                         new Object [] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetAllocation_AllocationContext((Allocation)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT:
                return basicSetAllocation_AllocationContext(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT:
                return eInternalContainer().eInverseRemove(this, AllocationPackage.ALLOCATION__ALLOCATION_CONTEXTS_ALLOCATION, Allocation.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
                if (resolve) return getResourceContainer_AllocationContext();
                return basicGetResourceContainer_AllocationContext();
            case AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
                if (resolve) return getAssemblyContext_AllocationContext();
                return basicGetAssemblyContext_AllocationContext();
            case AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT:
                return getAllocation_AllocationContext();
            case AllocationPackage.ALLOCATION_CONTEXT__EVENT_CHANNEL_ALLOCATION_CONTEXT:
                if (resolve) return getEventChannel__AllocationContext();
                return basicGetEventChannel__AllocationContext();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
                setResourceContainer_AllocationContext((ResourceContainer)newValue);
                return;
            case AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
                setAssemblyContext_AllocationContext((AssemblyContext)newValue);
                return;
            case AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT:
                setAllocation_AllocationContext((Allocation)newValue);
                return;
            case AllocationPackage.ALLOCATION_CONTEXT__EVENT_CHANNEL_ALLOCATION_CONTEXT:
                setEventChannel__AllocationContext((EventChannel)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
                setResourceContainer_AllocationContext((ResourceContainer)null);
                return;
            case AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
                setAssemblyContext_AllocationContext((AssemblyContext)null);
                return;
            case AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT:
                setAllocation_AllocationContext((Allocation)null);
                return;
            case AllocationPackage.ALLOCATION_CONTEXT__EVENT_CHANNEL_ALLOCATION_CONTEXT:
                setEventChannel__AllocationContext((EventChannel)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case AllocationPackage.ALLOCATION_CONTEXT__RESOURCE_CONTAINER_ALLOCATION_CONTEXT:
                return resourceContainer_AllocationContext != null;
            case AllocationPackage.ALLOCATION_CONTEXT__ASSEMBLY_CONTEXT_ALLOCATION_CONTEXT:
                return assemblyContext_AllocationContext != null;
            case AllocationPackage.ALLOCATION_CONTEXT__ALLOCATION_ALLOCATION_CONTEXT:
                return getAllocation_AllocationContext() != null;
            case AllocationPackage.ALLOCATION_CONTEXT__EVENT_CHANNEL_ALLOCATION_CONTEXT:
                return eventChannel__AllocationContext != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * The cached environment for evaluating OCL expressions.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // AllocationContextImpl
