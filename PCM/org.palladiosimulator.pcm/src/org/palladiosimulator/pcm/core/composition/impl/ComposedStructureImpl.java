/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.composition.impl;

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
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.ComposedStructure;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.composition.Connector;
import org.palladiosimulator.pcm.core.composition.EventChannel;
import org.palladiosimulator.pcm.core.composition.ResourceRequiredDelegationConnector;
import org.palladiosimulator.pcm.core.composition.util.CompositionValidator;
import org.palladiosimulator.pcm.core.entity.impl.EntityImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Composed Structure</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.core.composition.impl.ComposedStructureImpl#getAssemblyContexts__ComposedStructure
 * <em>Assembly Contexts Composed Structure</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.core.composition.impl.ComposedStructureImpl#getResourceRequiredDelegationConnectors_ComposedStructure
 * <em>Resource Required Delegation Connectors Composed Structure</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.core.composition.impl.ComposedStructureImpl#getEventChannel__ComposedStructure
 * <em>Event Channel Composed Structure</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.core.composition.impl.ComposedStructureImpl#getConnectors__ComposedStructure
 * <em>Connectors Composed Structure</em>}</li>
 * </ul>
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
    @SuppressWarnings("unchecked")
    public EList<AssemblyContext> getAssemblyContexts__ComposedStructure() {
        return (EList<AssemblyContext>) this.eDynamicGet(
                CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE,
                CompositionPackage.Literals.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<ResourceRequiredDelegationConnector> getResourceRequiredDelegationConnectors_ComposedStructure() {
        return (EList<ResourceRequiredDelegationConnector>) this.eDynamicGet(
                CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE,
                CompositionPackage.Literals.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE,
                true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<EventChannel> getEventChannel__ComposedStructure() {
        return (EList<EventChannel>) this.eDynamicGet(
                CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE,
                CompositionPackage.Literals.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<Connector> getConnectors__ComposedStructure() {
        return (EList<Connector>) this.eDynamicGet(CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE,
                CompositionPackage.Literals.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean MultipleConnectorsConstraint(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, CompositionValidator.DIAGNOSTIC_SOURCE,
                                CompositionValidator.COMPOSED_STRUCTURE__MULTIPLE_CONNECTORS_CONSTRAINT,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "MultipleConnectorsConstraint",
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
    public boolean MultipleConnectorsConstraintForAssemblyConnectors(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, CompositionValidator.DIAGNOSTIC_SOURCE,
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
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getAssemblyContexts__ComposedStructure())
                    .basicAdd(otherEnd, msgs);
        case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getResourceRequiredDelegationConnectors_ComposedStructure()).basicAdd(otherEnd, msgs);
        case CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getEventChannel__ComposedStructure())
                    .basicAdd(otherEnd, msgs);
        case CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getConnectors__ComposedStructure())
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
        case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) this.getAssemblyContexts__ComposedStructure()).basicRemove(otherEnd, msgs);
        case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) this.getResourceRequiredDelegationConnectors_ComposedStructure())
                    .basicRemove(otherEnd, msgs);
        case CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) this.getEventChannel__ComposedStructure()).basicRemove(otherEnd, msgs);
        case CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE:
            return ((InternalEList<?>) this.getConnectors__ComposedStructure()).basicRemove(otherEnd, msgs);
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
        case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            return this.getAssemblyContexts__ComposedStructure();
        case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            return this.getResourceRequiredDelegationConnectors_ComposedStructure();
        case CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            return this.getEventChannel__ComposedStructure();
        case CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE:
            return this.getConnectors__ComposedStructure();
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
        case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            this.getAssemblyContexts__ComposedStructure().clear();
            this.getAssemblyContexts__ComposedStructure().addAll((Collection<? extends AssemblyContext>) newValue);
            return;
        case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            this.getResourceRequiredDelegationConnectors_ComposedStructure().clear();
            this.getResourceRequiredDelegationConnectors_ComposedStructure()
                    .addAll((Collection<? extends ResourceRequiredDelegationConnector>) newValue);
            return;
        case CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            this.getEventChannel__ComposedStructure().clear();
            this.getEventChannel__ComposedStructure().addAll((Collection<? extends EventChannel>) newValue);
            return;
        case CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE:
            this.getConnectors__ComposedStructure().clear();
            this.getConnectors__ComposedStructure().addAll((Collection<? extends Connector>) newValue);
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
        case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            this.getAssemblyContexts__ComposedStructure().clear();
            return;
        case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            this.getResourceRequiredDelegationConnectors_ComposedStructure().clear();
            return;
        case CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            this.getEventChannel__ComposedStructure().clear();
            return;
        case CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE:
            this.getConnectors__ComposedStructure().clear();
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
        case CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE:
            return !this.getAssemblyContexts__ComposedStructure().isEmpty();
        case CompositionPackage.COMPOSED_STRUCTURE__RESOURCE_REQUIRED_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE:
            return !this.getResourceRequiredDelegationConnectors_ComposedStructure().isEmpty();
        case CompositionPackage.COMPOSED_STRUCTURE__EVENT_CHANNEL_COMPOSED_STRUCTURE:
            return !this.getEventChannel__ComposedStructure().isEmpty();
        case CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE:
            return !this.getConnectors__ComposedStructure().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // ComposedStructureImpl
