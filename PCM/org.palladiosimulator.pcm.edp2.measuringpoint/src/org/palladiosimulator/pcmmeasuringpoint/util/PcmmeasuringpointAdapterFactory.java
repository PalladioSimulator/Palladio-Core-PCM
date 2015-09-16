/**
 */
package org.palladiosimulator.pcmmeasuringpoint.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyPassiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyReference;
import org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallReference;
import org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionReference;
import org.palladiosimulator.pcmmeasuringpoint.LinkingResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.LinkingResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.OperationReference;
import org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.ResourceContainerMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.ResourceContainerReference;
import org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentReference;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemReference;
import org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SystemReference;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage
 * @generated
 */
public class PcmmeasuringpointAdapterFactory extends AdapterFactoryImpl {

    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static PcmmeasuringpointPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public PcmmeasuringpointAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = PcmmeasuringpointPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc
     * --> This implementation returns <code>true</code> if the object is either the model's package
     * or is an instance object of the model. <!-- end-user-doc -->
     *
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(final Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected PcmmeasuringpointSwitch<Adapter> modelSwitch = new PcmmeasuringpointSwitch<Adapter>() {

        @Override
        public Adapter caseAssemblyOperationMeasuringPoint(final AssemblyOperationMeasuringPoint object) {
            return PcmmeasuringpointAdapterFactory.this.createAssemblyOperationMeasuringPointAdapter();
        }

        @Override
        public Adapter caseAssemblyPassiveResourceMeasuringPoint(final AssemblyPassiveResourceMeasuringPoint object) {
            return PcmmeasuringpointAdapterFactory.this.createAssemblyPassiveResourceMeasuringPointAdapter();
        }

        @Override
        public Adapter caseActiveResourceMeasuringPoint(final ActiveResourceMeasuringPoint object) {
            return PcmmeasuringpointAdapterFactory.this.createActiveResourceMeasuringPointAdapter();
        }

        @Override
        public Adapter caseSystemOperationMeasuringPoint(final SystemOperationMeasuringPoint object) {
            return PcmmeasuringpointAdapterFactory.this.createSystemOperationMeasuringPointAdapter();
        }

        @Override
        public Adapter caseOperationReference(final OperationReference object) {
            return PcmmeasuringpointAdapterFactory.this.createOperationReferenceAdapter();
        }

        @Override
        public Adapter caseAssemblyReference(final AssemblyReference object) {
            return PcmmeasuringpointAdapterFactory.this.createAssemblyReferenceAdapter();
        }

        @Override
        public Adapter caseSystemReference(final SystemReference object) {
            return PcmmeasuringpointAdapterFactory.this.createSystemReferenceAdapter();
        }

        @Override
        public Adapter casePassiveResourceReference(final PassiveResourceReference object) {
            return PcmmeasuringpointAdapterFactory.this.createPassiveResourceReferenceAdapter();
        }

        @Override
        public Adapter caseActiveResourceReference(final ActiveResourceReference object) {
            return PcmmeasuringpointAdapterFactory.this.createActiveResourceReferenceAdapter();
        }

        @Override
        public Adapter caseLinkingResourceMeasuringPoint(final LinkingResourceMeasuringPoint object) {
            return PcmmeasuringpointAdapterFactory.this.createLinkingResourceMeasuringPointAdapter();
        }

        @Override
        public Adapter caseLinkingResourceReference(final LinkingResourceReference object) {
            return PcmmeasuringpointAdapterFactory.this.createLinkingResourceReferenceAdapter();
        }

        @Override
        public Adapter caseSubSystemOperationMeasuringPoint(final SubSystemOperationMeasuringPoint object) {
            return PcmmeasuringpointAdapterFactory.this.createSubSystemOperationMeasuringPointAdapter();
        }

        @Override
        public Adapter caseSubSystemReference(final SubSystemReference object) {
            return PcmmeasuringpointAdapterFactory.this.createSubSystemReferenceAdapter();
        }

        @Override
        public Adapter caseUsageScenarioMeasuringPoint(final UsageScenarioMeasuringPoint object) {
            return PcmmeasuringpointAdapterFactory.this.createUsageScenarioMeasuringPointAdapter();
        }

        @Override
        public Adapter caseUsageScenarioReference(final UsageScenarioReference object) {
            return PcmmeasuringpointAdapterFactory.this.createUsageScenarioReferenceAdapter();
        }

        @Override
        public Adapter caseEntryLevelSystemCallMeasuringPoint(final EntryLevelSystemCallMeasuringPoint object) {
            return PcmmeasuringpointAdapterFactory.this.createEntryLevelSystemCallMeasuringPointAdapter();
        }

        @Override
        public Adapter caseExternalCallActionMeasuringPoint(final ExternalCallActionMeasuringPoint object) {
            return PcmmeasuringpointAdapterFactory.this.createExternalCallActionMeasuringPointAdapter();
        }

        @Override
        public Adapter caseExternalCallActionReference(final ExternalCallActionReference object) {
            return PcmmeasuringpointAdapterFactory.this.createExternalCallActionReferenceAdapter();
        }

        @Override
        public Adapter caseEntryLevelSystemCallReference(final EntryLevelSystemCallReference object) {
            return PcmmeasuringpointAdapterFactory.this.createEntryLevelSystemCallReferenceAdapter();
        }

        @Override
        public Adapter caseResourceEnvironmentMeasuringPoint(final ResourceEnvironmentMeasuringPoint object) {
            return PcmmeasuringpointAdapterFactory.this.createResourceEnvironmentMeasuringPointAdapter();
        }

        @Override
        public Adapter caseResourceEnvironmentReference(final ResourceEnvironmentReference object) {
            return PcmmeasuringpointAdapterFactory.this.createResourceEnvironmentReferenceAdapter();
        }

        @Override
        public Adapter caseResourceContainerMeasuringPoint(final ResourceContainerMeasuringPoint object) {
            return PcmmeasuringpointAdapterFactory.this.createResourceContainerMeasuringPointAdapter();
        }

        @Override
        public Adapter caseResourceContainerReference(final ResourceContainerReference object) {
            return PcmmeasuringpointAdapterFactory.this.createResourceContainerReferenceAdapter();
        }

        @Override
        public Adapter caseMeasuringPoint(final MeasuringPoint object) {
            return PcmmeasuringpointAdapterFactory.this.createMeasuringPointAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object) {
            return PcmmeasuringpointAdapterFactory.this.createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(final Notifier target) {
        return this.modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.AssemblyOperationMeasuringPoint
     * <em>Assembly Operation Measuring Point</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.AssemblyOperationMeasuringPoint
     * @generated
     */
    public Adapter createAssemblyOperationMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.AssemblyPassiveResourceMeasuringPoint
     * <em>Assembly Passive Resource Measuring Point</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.AssemblyPassiveResourceMeasuringPoint
     * @generated
     */
    public Adapter createAssemblyPassiveResourceMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint
     * <em>Active Resource Measuring Point</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint
     * @generated
     */
    public Adapter createActiveResourceMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint
     * <em>System Operation Measuring Point</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint
     * @generated
     */
    public Adapter createSystemOperationMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.OperationReference
     * <em>Operation Reference</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.OperationReference
     * @generated
     */
    public Adapter createOperationReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.AssemblyReference <em>Assembly Reference</em>}
     * '. <!-- begin-user-doc --> This default implementation returns null so that we can easily
     * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.AssemblyReference
     * @generated
     */
    public Adapter createAssemblyReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.SystemReference <em>System Reference</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.SystemReference
     * @generated
     */
    public Adapter createSystemReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference
     * <em>Passive Resource Reference</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference
     * @generated
     */
    public Adapter createPassiveResourceReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference
     * <em>Active Resource Reference</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference
     * @generated
     */
    public Adapter createActiveResourceReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.LinkingResourceMeasuringPoint
     * <em>Linking Resource Measuring Point</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.LinkingResourceMeasuringPoint
     * @generated
     */
    public Adapter createLinkingResourceMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.LinkingResourceReference
     * <em>Linking Resource Reference</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.LinkingResourceReference
     * @generated
     */
    public Adapter createLinkingResourceReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint
     * <em>Sub System Operation Measuring Point</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint
     * @generated
     */
    public Adapter createSubSystemOperationMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.SubSystemReference
     * <em>Sub System Reference</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.SubSystemReference
     * @generated
     */
    public Adapter createSubSystemReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint
     * <em>Usage Scenario Measuring Point</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint
     * @generated
     */
    public Adapter createUsageScenarioMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference
     * <em>Usage Scenario Reference</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference
     * @generated
     */
    public Adapter createUsageScenarioReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallMeasuringPoint
     * <em>Entry Level System Call Measuring Point</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallMeasuringPoint
     * @generated
     */
    public Adapter createEntryLevelSystemCallMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionMeasuringPoint
     * <em>External Call Action Measuring Point</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionMeasuringPoint
     * @generated
     */
    public Adapter createExternalCallActionMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionReference
     * <em>External Call Action Reference</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionReference
     * @generated
     */
    public Adapter createExternalCallActionReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallReference
     * <em>Entry Level System Call Reference</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallReference
     * @generated
     */
    public Adapter createEntryLevelSystemCallReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentMeasuringPoint
     * <em>Resource Environment Measuring Point</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentMeasuringPoint
     * @generated
     */
    public Adapter createResourceEnvironmentMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentReference
     * <em>Resource Environment Reference</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentReference
     * @generated
     */
    public Adapter createResourceEnvironmentReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ResourceContainerMeasuringPoint
     * <em>Resource Container Measuring Point</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.ResourceContainerMeasuringPoint
     * @generated
     */
    public Adapter createResourceContainerMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.pcmmeasuringpoint.ResourceContainerReference
     * <em>Resource Container Reference</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.ResourceContainerReference
     * @generated
     */
    public Adapter createResourceContainerReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint
     * <em>Measuring Point</em>}'. <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint
     * @generated
     */
    public Adapter createMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
     * implementation returns null. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // PcmmeasuringpointAdapterFactory
