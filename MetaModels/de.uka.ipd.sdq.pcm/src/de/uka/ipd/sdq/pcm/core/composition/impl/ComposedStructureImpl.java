/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.Connector;
import de.uka.ipd.sdq.pcm.core.composition.EventChannel;
import de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.util.CompositionValidator;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Composed Structure</b></em> '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getAssemblyContexts__ComposedStructure
 * <em>Assembly Contexts Composed Structure</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getResourceRequiredDelegationConnectors_ComposedStructure
 * <em>Resource Required Delegation Connectors Composed Structure</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getEventChannel__ComposedStructure
 * <em>Event Channel Composed Structure</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl#getConnectors__ComposedStructure
 * <em>Connectors Composed Structure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComposedStructureImpl extends EntityImpl implements ComposedStructure {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the ' {@link #getAssemblyContexts__ComposedStructure()
     * <em>Assembly Contexts Composed Structure</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getAssemblyContexts__ComposedStructure()
     * @generated
     * @ordered
     */
    protected EList<AssemblyContext> assemblyContexts__ComposedStructure;

    /**
     * The cached value of the '{@link #getResourceRequiredDelegationConnectors_ComposedStructure()
     * <em>Resource Required Delegation Connectors Composed Structure</em>}' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getResourceRequiredDelegationConnectors_ComposedStructure()
     * @generated
     * @ordered
     */
    protected EList<ResourceRequiredDelegationConnector> resourceRequiredDelegationConnectors_ComposedStructure;

    /**
     * The cached value of the '{@link #getEventChannel__ComposedStructure()
     * <em>Event Channel Composed Structure</em>}' containment reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getEventChannel__ComposedStructure()
     * @generated
     * @ordered
     */
    protected EList<EventChannel> eventChannel__ComposedStructure;

    /**
     * The cached value of the '{@link #getConnectors__ComposedStructure()
     * <em>Connectors Composed Structure</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getConnectors__ComposedStructure()
     * @generated
     * @ordered
     */
    protected EList<Connector> connectors__ComposedStructure;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ComposedStructureImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.COMPOSED_STRUCTURE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<AssemblyContext> getAssemblyContexts__ComposedStructure() {
        if (assemblyContexts__ComposedStructure == null) {
            assemblyContexts__ComposedStructure = new EObjectContainmentWithInverseEList<AssemblyContext>(
                    AssemblyContext.class, this,
                    CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE,
                    CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT);
        }
        return assemblyContexts__ComposedStructure;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<ResourceRequiredDelegationConnector> getResourceRequiredDelegationConnectors_ComposedStructure() {
        if (resourceRequiredDelegationConnectors_ComposedStructure == null) {
            resourceRequiredDelegationConnectors_ComposedStructure = new EObjectContainmentWithInverseEList<ResourceRequiredDelegationConnector>(
                    ResourceRequiredDelegationConnector.class,
                    this,
                    CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE,
                    CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR__PARENT_STRUCTURE_RESOURCE_REQUIRED_DELEGATION_CONNECTOR);
        }
        return resourceRequiredDelegationConnectors_ComposedStructure;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<EventChannel> getEventChannel__ComposedStructure() {
        if (eventChannel__ComposedStructure == null) {
            eventChannel__ComposedStructure = new EObjectContainmentWithInverseEList<EventChannel>(EventChannel.class,
                    this, CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE,
                    CompositionPackage.EVENT_CHANNEL__PARENT_STRUCTURE_EVENT_CHANNEL);
        }
        return eventChannel__ComposedStructure;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Connector> getConnectors__ComposedStructure() {
        if (connectors__ComposedStructure == null) {
            connectors__ComposedStructure = new EObjectContainmentWithInverseEList<Connector>(Connector.class, this,
                    CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE,
                    CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR);
        }
        return connectors__ComposedStructure;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #MultipleConnectorsConstraint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Multiple Connectors Constraint</em>}' operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #MultipleConnectorsConstraint(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.connectors__ComposedStructure->select(conn | conn.oclIsTypeOf(pcm::core::composition::ProvidedDelegationConnector)).oclAsType(pcm::core::composition::ProvidedDelegationConnector)->forAll( c1, c2 | c1 <> c2 implies c1.outerProvidedRole_ProvidedDelegationConnector <> c2.outerProvidedRole_ProvidedDelegationConnector)\n"
            + "";

    /**
     * The cached OCL invariant for the '
     * {@link #MultipleConnectorsConstraint(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Multiple Connectors Constraint</em>}' invariant operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #MultipleConnectorsConstraint(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean MultipleConnectorsConstraint(DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(CompositionPackage.Literals.COMPOSED_STRUCTURE);
            try {
                MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(MULTIPLE_CONNECTORS_CONSTRAINT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, CompositionValidator.DIAGNOSTIC_SOURCE,
                        CompositionValidator.COMPOSED_STRUCTURE__MULTIPLE_CONNECTORS_CONSTRAINT, EcorePlugin.INSTANCE
                                .getString(
                                        "_UI_GenericInvariant_diagnostic",
                                        new Object[] { "MultipleConnectorsConstraint",
                                                EObjectValidator.getObjectLabel(this, context) }),
                        new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #MultipleConnectorsConstraintForAssemblyConnectors(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Multiple Connectors Constraint For Assembly Connectors</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #MultipleConnectorsConstraintForAssemblyConnectors(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String MULTIPLE_CONNECTORS_CONSTRAINT_FOR_ASSEMBLY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.connectors__ComposedStructure->select(conn | conn.oclIsTypeOf(pcm::core::composition::AssemblyConnector)).oclAsType(AssemblyConnector)->forAll( c1, c2 | ( (c1 <> c2) and ( c1.requiringAssemblyContext_AssemblyConnector = c2.requiringAssemblyContext_AssemblyConnector ) ) implies c1.requiredRole_AssemblyConnector <> c2.requiredRole_AssemblyConnector )\n"
            + "";

    /**
     * The cached OCL invariant for the '
     * {@link #MultipleConnectorsConstraintForAssemblyConnectors(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Multiple Connectors Constraint For Assembly Connectors</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #MultipleConnectorsConstraintForAssemblyConnectors(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint MULTIPLE_CONNECTORS_CONSTRAINT_FOR_ASSEMBLY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean MultipleConnectorsConstraintForAssemblyConnectors(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (MULTIPLE_CONNECTORS_CONSTRAINT_FOR_ASSEMBLY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(CompositionPackage.Literals.COMPOSED_STRUCTURE);
            try {
                MULTIPLE_CONNECTORS_CONSTRAINT_FOR_ASSEMBLY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(MULTIPLE_CONNECTORS_CONSTRAINT_FOR_ASSEMBLY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                MULTIPLE_CONNECTORS_CONSTRAINT_FOR_ASSEMBLY_CONNECTORS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(
                                Diagnostic.ERROR,
                                CompositionValidator.DIAGNOSTIC_SOURCE,
                                CompositionValidator.COMPOSED_STRUCTURE__MULTIPLE_CONNECTORS_CONSTRAINT_FOR_ASSEMBLY_CONNECTORS,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "MultipleConnectorsConstraintForAssemblyConnectors",
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
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getAssemblyContexts__ComposedStructure())
                    .basicAdd(otherEnd, msgs);
        case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getResourceRequiredDelegationConnectors_ComposedStructure())
                    .basicAdd(otherEnd, msgs);
        case CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getEventChannel__ComposedStructure()).basicAdd(
                    otherEnd, msgs);
        case CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getConnectors__ComposedStructure()).basicAdd(
                    otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) getAssemblyContexts__ComposedStructure()).basicRemove(otherEnd, msgs);
        case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) getResourceRequiredDelegationConnectors_ComposedStructure()).basicRemove(
                    otherEnd, msgs);
        case CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) getEventChannel__ComposedStructure()).basicRemove(otherEnd, msgs);
        case CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) getConnectors__ComposedStructure()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            return getAssemblyContexts__ComposedStructure();
        case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            return getResourceRequiredDelegationConnectors_ComposedStructure();
        case CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            return getEventChannel__ComposedStructure();
        case CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE:
            return getConnectors__ComposedStructure();
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
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            getAssemblyContexts__ComposedStructure().clear();
            getAssemblyContexts__ComposedStructure().addAll((Collection<? extends AssemblyContext>) newValue);
            return;
        case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            getResourceRequiredDelegationConnectors_ComposedStructure().clear();
            getResourceRequiredDelegationConnectors_ComposedStructure().addAll(
                    (Collection<? extends ResourceRequiredDelegationConnector>) newValue);
            return;
        case CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            getEventChannel__ComposedStructure().clear();
            getEventChannel__ComposedStructure().addAll((Collection<? extends EventChannel>) newValue);
            return;
        case CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE:
            getConnectors__ComposedStructure().clear();
            getConnectors__ComposedStructure().addAll((Collection<? extends Connector>) newValue);
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
    public void eUnset(int featureID) {
        switch (featureID) {
        case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            getAssemblyContexts__ComposedStructure().clear();
            return;
        case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            getResourceRequiredDelegationConnectors_ComposedStructure().clear();
            return;
        case CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            getEventChannel__ComposedStructure().clear();
            return;
        case CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE:
            getConnectors__ComposedStructure().clear();
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
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            return assemblyContexts__ComposedStructure != null && !assemblyContexts__ComposedStructure.isEmpty();
        case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            return resourceRequiredDelegationConnectors_ComposedStructure != null
                    && !resourceRequiredDelegationConnectors_ComposedStructure.isEmpty();
        case CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            return eventChannel__ComposedStructure != null && !eventChannel__ComposedStructure.isEmpty();
        case CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE:
            return connectors__ComposedStructure != null && !connectors__ComposedStructure.isEmpty();
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

} // ComposedStructureImpl
