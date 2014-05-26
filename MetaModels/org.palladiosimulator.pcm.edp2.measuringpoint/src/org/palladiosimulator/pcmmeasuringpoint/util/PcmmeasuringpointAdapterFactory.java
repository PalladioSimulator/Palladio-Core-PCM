/**
 */
package org.palladiosimulator.pcmmeasuringpoint.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;

import org.palladiosimulator.pcmmeasuringpoint.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage
 * @generated
 */
public class PcmmeasuringpointAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static PcmmeasuringpointPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PcmmeasuringpointAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = PcmmeasuringpointPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PcmmeasuringpointSwitch<Adapter> modelSwitch =
        new PcmmeasuringpointSwitch<Adapter>() {
            @Override
            public Adapter caseAssemblyOperationMeasuringPoint(AssemblyOperationMeasuringPoint object) {
                return createAssemblyOperationMeasuringPointAdapter();
            }
            @Override
            public Adapter caseAssemblyPassiveResourceMeasuringPoint(AssemblyPassiveResourceMeasuringPoint object) {
                return createAssemblyPassiveResourceMeasuringPointAdapter();
            }
            @Override
            public Adapter caseActiveResourceMeasuringPoint(ActiveResourceMeasuringPoint object) {
                return createActiveResourceMeasuringPointAdapter();
            }
            @Override
            public Adapter caseSystemOperationMeasuringPoint(SystemOperationMeasuringPoint object) {
                return createSystemOperationMeasuringPointAdapter();
            }
            @Override
            public Adapter caseOperationReference(OperationReference object) {
                return createOperationReferenceAdapter();
            }
            @Override
            public Adapter caseAssemblyReference(AssemblyReference object) {
                return createAssemblyReferenceAdapter();
            }
            @Override
            public Adapter caseSystemReference(SystemReference object) {
                return createSystemReferenceAdapter();
            }
            @Override
            public Adapter casePassiveResourceReference(PassiveResourceReference object) {
                return createPassiveResourceReferenceAdapter();
            }
            @Override
            public Adapter caseActiveResourceReference(ActiveResourceReference object) {
                return createActiveResourceReferenceAdapter();
            }
            @Override
            public Adapter caseLinkingResourceMeasuringPoint(LinkingResourceMeasuringPoint object) {
                return createLinkingResourceMeasuringPointAdapter();
            }
            @Override
            public Adapter caseLinkingResourceReference(LinkingResourceReference object) {
                return createLinkingResourceReferenceAdapter();
            }
            @Override
            public Adapter caseSubSystemOperationMeasuringPoint(SubSystemOperationMeasuringPoint object) {
                return createSubSystemOperationMeasuringPointAdapter();
            }
            @Override
            public Adapter caseSubSystemReference(SubSystemReference object) {
                return createSubSystemReferenceAdapter();
            }
            @Override
            public Adapter caseUsageScenarioMeasuringPoint(UsageScenarioMeasuringPoint object) {
                return createUsageScenarioMeasuringPointAdapter();
            }
            @Override
            public Adapter caseUsageScenarioReference(UsageScenarioReference object) {
                return createUsageScenarioReferenceAdapter();
            }
            @Override
            public Adapter caseMeasuringPoint(MeasuringPoint object) {
                return createMeasuringPointAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcmmeasuringpoint.AssemblyOperationMeasuringPoint <em>Assembly Operation Measuring Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.AssemblyOperationMeasuringPoint
     * @generated
     */
    public Adapter createAssemblyOperationMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcmmeasuringpoint.AssemblyPassiveResourceMeasuringPoint <em>Assembly Passive Resource Measuring Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.AssemblyPassiveResourceMeasuringPoint
     * @generated
     */
    public Adapter createAssemblyPassiveResourceMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint <em>Active Resource Measuring Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint
     * @generated
     */
    public Adapter createActiveResourceMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint <em>System Operation Measuring Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint
     * @generated
     */
    public Adapter createSystemOperationMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcmmeasuringpoint.OperationReference <em>Operation Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.OperationReference
     * @generated
     */
    public Adapter createOperationReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcmmeasuringpoint.AssemblyReference <em>Assembly Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.AssemblyReference
     * @generated
     */
    public Adapter createAssemblyReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcmmeasuringpoint.SystemReference <em>System Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.SystemReference
     * @generated
     */
    public Adapter createSystemReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference <em>Passive Resource Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference
     * @generated
     */
    public Adapter createPassiveResourceReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference <em>Active Resource Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference
     * @generated
     */
    public Adapter createActiveResourceReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcmmeasuringpoint.LinkingResourceMeasuringPoint <em>Linking Resource Measuring Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.LinkingResourceMeasuringPoint
     * @generated
     */
    public Adapter createLinkingResourceMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcmmeasuringpoint.LinkingResourceReference <em>Linking Resource Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.LinkingResourceReference
     * @generated
     */
    public Adapter createLinkingResourceReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint <em>Sub System Operation Measuring Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint
     * @generated
     */
    public Adapter createSubSystemOperationMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcmmeasuringpoint.SubSystemReference <em>Sub System Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.SubSystemReference
     * @generated
     */
    public Adapter createSubSystemReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint <em>Usage Scenario Measuring Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint
     * @generated
     */
    public Adapter createUsageScenarioMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference <em>Usage Scenario Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference
     * @generated
     */
    public Adapter createUsageScenarioReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint <em>Measuring Point</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint
     * @generated
     */
    public Adapter createMeasuringPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //PcmmeasuringpointAdapterFactory
