/**
 */
package org.palladiosimulator.pcmmeasuringpoint.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
import org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentReference;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemReference;
import org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SystemReference;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage
 * @generated
 */
public class PcmmeasuringpointSwitch<T> extends Switch<T> {

    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static PcmmeasuringpointPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PcmmeasuringpointSwitch() {
        if (modelPackage == null) {
            modelPackage = PcmmeasuringpointPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(final EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(final int classifierID, final EObject theEObject) {
        switch (classifierID) {
        case PcmmeasuringpointPackage.ASSEMBLY_OPERATION_MEASURING_POINT: {
            final AssemblyOperationMeasuringPoint assemblyOperationMeasuringPoint = (AssemblyOperationMeasuringPoint) theEObject;
            T result = this.caseAssemblyOperationMeasuringPoint(assemblyOperationMeasuringPoint);
            if (result == null) {
                result = this.caseOperationReference(assemblyOperationMeasuringPoint);
            }
            if (result == null) {
                result = this.caseAssemblyReference(assemblyOperationMeasuringPoint);
            }
            if (result == null) {
                result = this.caseMeasuringPoint(assemblyOperationMeasuringPoint);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT: {
            final AssemblyPassiveResourceMeasuringPoint assemblyPassiveResourceMeasuringPoint = (AssemblyPassiveResourceMeasuringPoint) theEObject;
            T result = this.caseAssemblyPassiveResourceMeasuringPoint(assemblyPassiveResourceMeasuringPoint);
            if (result == null) {
                result = this.caseAssemblyReference(assemblyPassiveResourceMeasuringPoint);
            }
            if (result == null) {
                result = this.casePassiveResourceReference(assemblyPassiveResourceMeasuringPoint);
            }
            if (result == null) {
                result = this.caseMeasuringPoint(assemblyPassiveResourceMeasuringPoint);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.ACTIVE_RESOURCE_MEASURING_POINT: {
            final ActiveResourceMeasuringPoint activeResourceMeasuringPoint = (ActiveResourceMeasuringPoint) theEObject;
            T result = this.caseActiveResourceMeasuringPoint(activeResourceMeasuringPoint);
            if (result == null) {
                result = this.caseMeasuringPoint(activeResourceMeasuringPoint);
            }
            if (result == null) {
                result = this.caseActiveResourceReference(activeResourceMeasuringPoint);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.SYSTEM_OPERATION_MEASURING_POINT: {
            final SystemOperationMeasuringPoint systemOperationMeasuringPoint = (SystemOperationMeasuringPoint) theEObject;
            T result = this.caseSystemOperationMeasuringPoint(systemOperationMeasuringPoint);
            if (result == null) {
                result = this.caseOperationReference(systemOperationMeasuringPoint);
            }
            if (result == null) {
                result = this.caseMeasuringPoint(systemOperationMeasuringPoint);
            }
            if (result == null) {
                result = this.caseSystemReference(systemOperationMeasuringPoint);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.OPERATION_REFERENCE: {
            final OperationReference operationReference = (OperationReference) theEObject;
            T result = this.caseOperationReference(operationReference);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.ASSEMBLY_REFERENCE: {
            final AssemblyReference assemblyReference = (AssemblyReference) theEObject;
            T result = this.caseAssemblyReference(assemblyReference);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.SYSTEM_REFERENCE: {
            final SystemReference systemReference = (SystemReference) theEObject;
            T result = this.caseSystemReference(systemReference);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.PASSIVE_RESOURCE_REFERENCE: {
            final PassiveResourceReference passiveResourceReference = (PassiveResourceReference) theEObject;
            T result = this.casePassiveResourceReference(passiveResourceReference);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.ACTIVE_RESOURCE_REFERENCE: {
            final ActiveResourceReference activeResourceReference = (ActiveResourceReference) theEObject;
            T result = this.caseActiveResourceReference(activeResourceReference);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.LINKING_RESOURCE_MEASURING_POINT: {
            final LinkingResourceMeasuringPoint linkingResourceMeasuringPoint = (LinkingResourceMeasuringPoint) theEObject;
            T result = this.caseLinkingResourceMeasuringPoint(linkingResourceMeasuringPoint);
            if (result == null) {
                result = this.caseMeasuringPoint(linkingResourceMeasuringPoint);
            }
            if (result == null) {
                result = this.caseLinkingResourceReference(linkingResourceMeasuringPoint);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.LINKING_RESOURCE_REFERENCE: {
            final LinkingResourceReference linkingResourceReference = (LinkingResourceReference) theEObject;
            T result = this.caseLinkingResourceReference(linkingResourceReference);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.SUB_SYSTEM_OPERATION_MEASURING_POINT: {
            final SubSystemOperationMeasuringPoint subSystemOperationMeasuringPoint = (SubSystemOperationMeasuringPoint) theEObject;
            T result = this.caseSubSystemOperationMeasuringPoint(subSystemOperationMeasuringPoint);
            if (result == null) {
                result = this.caseMeasuringPoint(subSystemOperationMeasuringPoint);
            }
            if (result == null) {
                result = this.caseSubSystemReference(subSystemOperationMeasuringPoint);
            }
            if (result == null) {
                result = this.caseOperationReference(subSystemOperationMeasuringPoint);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE: {
            final SubSystemReference subSystemReference = (SubSystemReference) theEObject;
            T result = this.caseSubSystemReference(subSystemReference);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.USAGE_SCENARIO_MEASURING_POINT: {
            final UsageScenarioMeasuringPoint usageScenarioMeasuringPoint = (UsageScenarioMeasuringPoint) theEObject;
            T result = this.caseUsageScenarioMeasuringPoint(usageScenarioMeasuringPoint);
            if (result == null) {
                result = this.caseMeasuringPoint(usageScenarioMeasuringPoint);
            }
            if (result == null) {
                result = this.caseUsageScenarioReference(usageScenarioMeasuringPoint);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.USAGE_SCENARIO_REFERENCE: {
            final UsageScenarioReference usageScenarioReference = (UsageScenarioReference) theEObject;
            T result = this.caseUsageScenarioReference(usageScenarioReference);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT: {
            final EntryLevelSystemCallMeasuringPoint entryLevelSystemCallMeasuringPoint = (EntryLevelSystemCallMeasuringPoint) theEObject;
            T result = this.caseEntryLevelSystemCallMeasuringPoint(entryLevelSystemCallMeasuringPoint);
            if (result == null) {
                result = this.caseMeasuringPoint(entryLevelSystemCallMeasuringPoint);
            }
            if (result == null) {
                result = this.caseEntryLevelSystemCallReference(entryLevelSystemCallMeasuringPoint);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_MEASURING_POINT: {
            final ExternalCallActionMeasuringPoint externalCallActionMeasuringPoint = (ExternalCallActionMeasuringPoint) theEObject;
            T result = this.caseExternalCallActionMeasuringPoint(externalCallActionMeasuringPoint);
            if (result == null) {
                result = this.caseMeasuringPoint(externalCallActionMeasuringPoint);
            }
            if (result == null) {
                result = this.caseExternalCallActionReference(externalCallActionMeasuringPoint);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.EXTERNAL_CALL_ACTION_REFERENCE: {
            final ExternalCallActionReference externalCallActionReference = (ExternalCallActionReference) theEObject;
            T result = this.caseExternalCallActionReference(externalCallActionReference);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.ENTRY_LEVEL_SYSTEM_CALL_REFERENCE: {
            final EntryLevelSystemCallReference entryLevelSystemCallReference = (EntryLevelSystemCallReference) theEObject;
            T result = this.caseEntryLevelSystemCallReference(entryLevelSystemCallReference);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_MEASURING_POINT: {
            final ResourceEnvironmentMeasuringPoint resourceEnvironmentMeasuringPoint = (ResourceEnvironmentMeasuringPoint) theEObject;
            T result = this.caseResourceEnvironmentMeasuringPoint(resourceEnvironmentMeasuringPoint);
            if (result == null) {
                result = this.caseResourceEnvironmentReference(resourceEnvironmentMeasuringPoint);
            }
            if (result == null) {
                result = this.caseMeasuringPoint(resourceEnvironmentMeasuringPoint);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PcmmeasuringpointPackage.RESOURCE_ENVIRONMENT_REFERENCE: {
            final ResourceEnvironmentReference resourceEnvironmentReference = (ResourceEnvironmentReference) theEObject;
            T result = this.caseResourceEnvironmentReference(resourceEnvironmentReference);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        default:
            return this.defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Assembly Operation Measuring Point</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Assembly Operation Measuring Point</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAssemblyOperationMeasuringPoint(final AssemblyOperationMeasuringPoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Assembly Passive Resource Measuring Point</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Assembly Passive Resource Measuring Point</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAssemblyPassiveResourceMeasuringPoint(final AssemblyPassiveResourceMeasuringPoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Active Resource Measuring Point</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Active Resource Measuring Point</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseActiveResourceMeasuringPoint(final ActiveResourceMeasuringPoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>System Operation Measuring Point</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>System Operation Measuring Point</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSystemOperationMeasuringPoint(final SystemOperationMeasuringPoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Reference</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Reference</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOperationReference(final OperationReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Assembly Reference</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Assembly Reference</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAssemblyReference(final AssemblyReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>System Reference</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>System Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSystemReference(final SystemReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Passive Resource Reference</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Passive Resource Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePassiveResourceReference(final PassiveResourceReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Active Resource Reference</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Active Resource Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseActiveResourceReference(final ActiveResourceReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Linking Resource Measuring Point</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Linking Resource Measuring Point</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLinkingResourceMeasuringPoint(final LinkingResourceMeasuringPoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Linking Resource Reference</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Linking Resource Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLinkingResourceReference(final LinkingResourceReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Sub System Operation Measuring Point</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Sub System Operation Measuring Point</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSubSystemOperationMeasuringPoint(final SubSystemOperationMeasuringPoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Sub System Reference</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Sub System Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSubSystemReference(final SubSystemReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Usage Scenario Measuring Point</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Usage Scenario Measuring Point</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUsageScenarioMeasuringPoint(final UsageScenarioMeasuringPoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Usage Scenario Reference</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Usage Scenario Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUsageScenarioReference(final UsageScenarioReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Entry Level System Call Measuring Point</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Entry Level System Call Measuring Point</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEntryLevelSystemCallMeasuringPoint(final EntryLevelSystemCallMeasuringPoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>External Call Action Measuring Point</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>External Call Action Measuring Point</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExternalCallActionMeasuringPoint(final ExternalCallActionMeasuringPoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>External Call Action Reference</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>External Call Action Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExternalCallActionReference(final ExternalCallActionReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Entry Level System Call Reference</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Entry Level System Call Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEntryLevelSystemCallReference(final EntryLevelSystemCallReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Resource Environment Measuring Point</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Resource Environment Measuring Point</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourceEnvironmentMeasuringPoint(final ResourceEnvironmentMeasuringPoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Resource Environment Reference</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Resource Environment Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourceEnvironmentReference(final ResourceEnvironmentReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Measuring Point</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Measuring Point</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMeasuringPoint(final MeasuringPoint object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(final EObject object) {
        return null;
    }

} // PcmmeasuringpointSwitch
