package de.uka.ipd.sdq.pcm.core.composition.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.composition.*;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyInfrastructureConnector;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.Connector;
import de.uka.ipd.sdq.pcm.core.composition.DelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.EventChannel;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSinkConnector;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedInfrastructureDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredInfrastructureDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredResourceDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.ResourceRequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.core.composition.CompositionPackage
 * @generated
 */
public class CompositionSwitch<T> {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached model package
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected static CompositionPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public CompositionSwitch() {
        if (modelPackage == null) {
            modelPackage = CompositionPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case CompositionPackage.DELEGATION_CONNECTOR: {
                DelegationConnector delegationConnector = (DelegationConnector)theEObject;
                T result = caseDelegationConnector(delegationConnector);
                if (result == null) result = caseConnector(delegationConnector);
                if (result == null) result = caseEntity(delegationConnector);
                if (result == null) result = caseIdentifier(delegationConnector);
                if (result == null) result = caseNamedElement(delegationConnector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.CONNECTOR: {
                Connector connector = (Connector)theEObject;
                T result = caseConnector(connector);
                if (result == null) result = caseEntity(connector);
                if (result == null) result = caseIdentifier(connector);
                if (result == null) result = caseNamedElement(connector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.COMPOSED_STRUCTURE: {
                ComposedStructure composedStructure = (ComposedStructure)theEObject;
                T result = caseComposedStructure(composedStructure);
                if (result == null) result = caseEntity(composedStructure);
                if (result == null) result = caseIdentifier(composedStructure);
                if (result == null) result = caseNamedElement(composedStructure);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.RESOURCE_REQUIRED_DELEGATION_CONNECTOR: {
                ResourceRequiredDelegationConnector resourceRequiredDelegationConnector = (ResourceRequiredDelegationConnector)theEObject;
                T result = caseResourceRequiredDelegationConnector(resourceRequiredDelegationConnector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.EVENT_CHANNEL: {
                EventChannel eventChannel = (EventChannel)theEObject;
                T result = caseEventChannel(eventChannel);
                if (result == null) result = caseEntity(eventChannel);
                if (result == null) result = caseIdentifier(eventChannel);
                if (result == null) result = caseNamedElement(eventChannel);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR: {
                EventChannelSourceConnector eventChannelSourceConnector = (EventChannelSourceConnector)theEObject;
                T result = caseEventChannelSourceConnector(eventChannelSourceConnector);
                if (result == null) result = caseConnector(eventChannelSourceConnector);
                if (result == null) result = caseEntity(eventChannelSourceConnector);
                if (result == null) result = caseIdentifier(eventChannelSourceConnector);
                if (result == null) result = caseNamedElement(eventChannelSourceConnector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR: {
                EventChannelSinkConnector eventChannelSinkConnector = (EventChannelSinkConnector)theEObject;
                T result = caseEventChannelSinkConnector(eventChannelSinkConnector);
                if (result == null) result = caseConnector(eventChannelSinkConnector);
                if (result == null) result = caseEntity(eventChannelSinkConnector);
                if (result == null) result = caseIdentifier(eventChannelSinkConnector);
                if (result == null) result = caseNamedElement(eventChannelSinkConnector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.PROVIDED_DELEGATION_CONNECTOR: {
                ProvidedDelegationConnector providedDelegationConnector = (ProvidedDelegationConnector)theEObject;
                T result = caseProvidedDelegationConnector(providedDelegationConnector);
                if (result == null) result = caseDelegationConnector(providedDelegationConnector);
                if (result == null) result = caseConnector(providedDelegationConnector);
                if (result == null) result = caseEntity(providedDelegationConnector);
                if (result == null) result = caseIdentifier(providedDelegationConnector);
                if (result == null) result = caseNamedElement(providedDelegationConnector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.REQUIRED_DELEGATION_CONNECTOR: {
                RequiredDelegationConnector requiredDelegationConnector = (RequiredDelegationConnector)theEObject;
                T result = caseRequiredDelegationConnector(requiredDelegationConnector);
                if (result == null) result = caseDelegationConnector(requiredDelegationConnector);
                if (result == null) result = caseConnector(requiredDelegationConnector);
                if (result == null) result = caseEntity(requiredDelegationConnector);
                if (result == null) result = caseIdentifier(requiredDelegationConnector);
                if (result == null) result = caseNamedElement(requiredDelegationConnector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.ASSEMBLY_CONNECTOR: {
                AssemblyConnector assemblyConnector = (AssemblyConnector)theEObject;
                T result = caseAssemblyConnector(assemblyConnector);
                if (result == null) result = caseConnector(assemblyConnector);
                if (result == null) result = caseEntity(assemblyConnector);
                if (result == null) result = caseIdentifier(assemblyConnector);
                if (result == null) result = caseNamedElement(assemblyConnector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR: {
                AssemblyEventConnector assemblyEventConnector = (AssemblyEventConnector)theEObject;
                T result = caseAssemblyEventConnector(assemblyEventConnector);
                if (result == null) result = caseConnector(assemblyEventConnector);
                if (result == null) result = caseEntity(assemblyEventConnector);
                if (result == null) result = caseIdentifier(assemblyEventConnector);
                if (result == null) result = caseNamedElement(assemblyEventConnector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.SOURCE_DELEGATION_CONNECTOR: {
                SourceDelegationConnector sourceDelegationConnector = (SourceDelegationConnector)theEObject;
                T result = caseSourceDelegationConnector(sourceDelegationConnector);
                if (result == null) result = caseDelegationConnector(sourceDelegationConnector);
                if (result == null) result = caseConnector(sourceDelegationConnector);
                if (result == null) result = caseEntity(sourceDelegationConnector);
                if (result == null) result = caseIdentifier(sourceDelegationConnector);
                if (result == null) result = caseNamedElement(sourceDelegationConnector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.SINK_DELEGATION_CONNECTOR: {
                SinkDelegationConnector sinkDelegationConnector = (SinkDelegationConnector)theEObject;
                T result = caseSinkDelegationConnector(sinkDelegationConnector);
                if (result == null) result = caseDelegationConnector(sinkDelegationConnector);
                if (result == null) result = caseConnector(sinkDelegationConnector);
                if (result == null) result = caseEntity(sinkDelegationConnector);
                if (result == null) result = caseIdentifier(sinkDelegationConnector);
                if (result == null) result = caseNamedElement(sinkDelegationConnector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.ASSEMBLY_INFRASTRUCTURE_CONNECTOR: {
                AssemblyInfrastructureConnector assemblyInfrastructureConnector = (AssemblyInfrastructureConnector)theEObject;
                T result = caseAssemblyInfrastructureConnector(assemblyInfrastructureConnector);
                if (result == null) result = caseConnector(assemblyInfrastructureConnector);
                if (result == null) result = caseEntity(assemblyInfrastructureConnector);
                if (result == null) result = caseIdentifier(assemblyInfrastructureConnector);
                if (result == null) result = caseNamedElement(assemblyInfrastructureConnector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.PROVIDED_INFRASTRUCTURE_DELEGATION_CONNECTOR: {
                ProvidedInfrastructureDelegationConnector providedInfrastructureDelegationConnector = (ProvidedInfrastructureDelegationConnector)theEObject;
                T result = caseProvidedInfrastructureDelegationConnector(providedInfrastructureDelegationConnector);
                if (result == null) result = caseDelegationConnector(providedInfrastructureDelegationConnector);
                if (result == null) result = caseConnector(providedInfrastructureDelegationConnector);
                if (result == null) result = caseEntity(providedInfrastructureDelegationConnector);
                if (result == null) result = caseIdentifier(providedInfrastructureDelegationConnector);
                if (result == null) result = caseNamedElement(providedInfrastructureDelegationConnector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.REQUIRED_INFRASTRUCTURE_DELEGATION_CONNECTOR: {
                RequiredInfrastructureDelegationConnector requiredInfrastructureDelegationConnector = (RequiredInfrastructureDelegationConnector)theEObject;
                T result = caseRequiredInfrastructureDelegationConnector(requiredInfrastructureDelegationConnector);
                if (result == null) result = caseDelegationConnector(requiredInfrastructureDelegationConnector);
                if (result == null) result = caseConnector(requiredInfrastructureDelegationConnector);
                if (result == null) result = caseEntity(requiredInfrastructureDelegationConnector);
                if (result == null) result = caseIdentifier(requiredInfrastructureDelegationConnector);
                if (result == null) result = caseNamedElement(requiredInfrastructureDelegationConnector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.REQUIRED_RESOURCE_DELEGATION_CONNECTOR: {
                RequiredResourceDelegationConnector requiredResourceDelegationConnector = (RequiredResourceDelegationConnector)theEObject;
                T result = caseRequiredResourceDelegationConnector(requiredResourceDelegationConnector);
                if (result == null) result = caseDelegationConnector(requiredResourceDelegationConnector);
                if (result == null) result = caseConnector(requiredResourceDelegationConnector);
                if (result == null) result = caseEntity(requiredResourceDelegationConnector);
                if (result == null) result = caseIdentifier(requiredResourceDelegationConnector);
                if (result == null) result = caseNamedElement(requiredResourceDelegationConnector);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case CompositionPackage.ASSEMBLY_CONTEXT: {
                AssemblyContext assemblyContext = (AssemblyContext)theEObject;
                T result = caseAssemblyContext(assemblyContext);
                if (result == null) result = caseEntity(assemblyContext);
                if (result == null) result = caseIdentifier(assemblyContext);
                if (result == null) result = caseNamedElement(assemblyContext);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Delegation Connector</em>'.
     * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Delegation Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDelegationConnector(DelegationConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Connector</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConnector(Connector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Composed Structure</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Composed Structure</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComposedStructure(ComposedStructure object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Resource Required Delegation Connector</em>'.
     * <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Resource Required Delegation Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourceRequiredDelegationConnector(ResourceRequiredDelegationConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Event Channel</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Channel</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventChannel(EventChannel object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Provided Delegation Connector</em>'.
     * <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Provided Delegation Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProvidedDelegationConnector(ProvidedDelegationConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Required Delegation Connector</em>'.
     * <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Required Delegation Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRequiredDelegationConnector(RequiredDelegationConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Assembly Connector</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Assembly Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAssemblyConnector(AssemblyConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Assembly Event Connector</em>'.
     * <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Assembly Event Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAssemblyEventConnector(AssemblyEventConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Source Delegation Connector</em>'.
     * <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Source Delegation Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSourceDelegationConnector(SourceDelegationConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Sink Delegation Connector</em>'.
     * <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sink Delegation Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSinkDelegationConnector(SinkDelegationConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Assembly Infrastructure Connector</em>'.
     * <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Assembly Infrastructure Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAssemblyInfrastructureConnector(AssemblyInfrastructureConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Provided Infrastructure Delegation Connector</em>'.
     * <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Provided Infrastructure Delegation Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProvidedInfrastructureDelegationConnector(ProvidedInfrastructureDelegationConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Required Infrastructure Delegation Connector</em>'.
     * <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Required Infrastructure Delegation Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRequiredInfrastructureDelegationConnector(RequiredInfrastructureDelegationConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Required Resource Delegation Connector</em>'.
     * <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Required Resource Delegation Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRequiredResourceDelegationConnector(RequiredResourceDelegationConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Event Channel Sink Connector</em>'.
     * <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Channel Sink Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventChannelSinkConnector(EventChannelSinkConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Event Channel Source Connector</em>'.
     * <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Channel Source Connector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventChannelSourceConnector(EventChannelSourceConnector object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Assembly Context</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Assembly Context</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAssemblyContext(AssemblyContext object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIdentifier(Identifier object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedElement(NamedElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Entity</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEntity(Entity object) {
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
    public T defaultCase(EObject object) {
        return null;
    }

} // CompositionSwitch