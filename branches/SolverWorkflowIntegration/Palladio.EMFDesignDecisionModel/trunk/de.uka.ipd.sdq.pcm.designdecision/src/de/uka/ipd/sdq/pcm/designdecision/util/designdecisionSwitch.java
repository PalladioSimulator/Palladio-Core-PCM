/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.util;

import de.uka.ipd.sdq.pcm.designdecision.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage
 * @generated
 */
public class designdecisionSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static designdecisionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designdecisionSwitch() {
		if (modelPackage == null) {
			modelPackage = designdecisionPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case designdecisionPackage.DESIGN_DECISION: {
				DesignDecision designDecision = (DesignDecision)theEObject;
				T result = caseDesignDecision(designDecision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.DOMAIN: {
				Domain domain = (Domain)theEObject;
				T result = caseDomain(domain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.CHOICE: {
				Choice choice = (Choice)theEObject;
				T result = caseChoice(choice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.RANGE: {
				Range range = (Range)theEObject;
				T result = caseRange(range);
				if (result == null) result = caseDomain(range);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.ENUMERATION: {
				Enumeration enumeration = (Enumeration)theEObject;
				T result = caseEnumeration(enumeration);
				if (result == null) result = caseDomain(enumeration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.EQUIVALENT_COMPONENTS: {
				EquivalentComponents equivalentComponents = (EquivalentComponents)theEObject;
				T result = caseEquivalentComponents(equivalentComponents);
				if (result == null) result = caseEnumeration(equivalentComponents);
				if (result == null) result = caseDomain(equivalentComponents);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.AVAILABLE_SERVERS: {
				AvailableServers availableServers = (AvailableServers)theEObject;
				T result = caseAvailableServers(availableServers);
				if (result == null) result = caseEnumeration(availableServers);
				if (result == null) result = caseDomain(availableServers);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.COMPONENT_CHOICE: {
				ComponentChoice componentChoice = (ComponentChoice)theEObject;
				T result = caseComponentChoice(componentChoice);
				if (result == null) result = caseChoice(componentChoice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.ALLOCATION_CHOICE: {
				AllocationChoice allocationChoice = (AllocationChoice)theEObject;
				T result = caseAllocationChoice(allocationChoice);
				if (result == null) result = caseChoice(allocationChoice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.PROCESSING_RATE_CHOICE: {
				ProcessingRateChoice processingRateChoice = (ProcessingRateChoice)theEObject;
				T result = caseProcessingRateChoice(processingRateChoice);
				if (result == null) result = caseChoice(processingRateChoice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.PROCESSING_RATE_DECISION: {
				ProcessingRateDecision processingRateDecision = (ProcessingRateDecision)theEObject;
				T result = caseProcessingRateDecision(processingRateDecision);
				if (result == null) result = caseDesignDecision(processingRateDecision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.ALLOCATION_DECISION: {
				AllocationDecision allocationDecision = (AllocationDecision)theEObject;
				T result = caseAllocationDecision(allocationDecision);
				if (result == null) result = caseDesignDecision(allocationDecision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.ASSEMBLED_COMPONENT_DECISION: {
				AssembledComponentDecision assembledComponentDecision = (AssembledComponentDecision)theEObject;
				T result = caseAssembledComponentDecision(assembledComponentDecision);
				if (result == null) result = caseDesignDecision(assembledComponentDecision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.INTEGER_RANGE: {
				IntegerRange integerRange = (IntegerRange)theEObject;
				T result = caseIntegerRange(integerRange);
				if (result == null) result = caseRange(integerRange);
				if (result == null) result = caseDomain(integerRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.DOUBLE_RANGE: {
				DoubleRange doubleRange = (DoubleRange)theEObject;
				T result = caseDoubleRange(doubleRange);
				if (result == null) result = caseRange(doubleRange);
				if (result == null) result = caseDomain(doubleRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_CHOICE: {
				ResourceContainerReplicationChoice resourceContainerReplicationChoice = (ResourceContainerReplicationChoice)theEObject;
				T result = caseResourceContainerReplicationChoice(resourceContainerReplicationChoice);
				if (result == null) result = caseChoice(resourceContainerReplicationChoice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_DECISION: {
				ResourceContainerReplicationDecision resourceContainerReplicationDecision = (ResourceContainerReplicationDecision)theEObject;
				T result = caseResourceContainerReplicationDecision(resourceContainerReplicationDecision);
				if (result == null) result = caseDesignDecision(resourceContainerReplicationDecision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.GENOTYPE: {
				Genotype genotype = (Genotype)theEObject;
				T result = caseGenotype(genotype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.PROBLEM: {
				Problem problem = (Problem)theEObject;
				T result = caseProblem(problem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.DISCRETE_DOMAIN: {
				DiscreteDomain discreteDomain = (DiscreteDomain)theEObject;
				T result = caseDiscreteDomain(discreteDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.CONNECTOR_CONFIG_DECISION: {
				ConnectorConfigDecision connectorConfigDecision = (ConnectorConfigDecision)theEObject;
				T result = caseConnectorConfigDecision(connectorConfigDecision);
				if (result == null) result = caseDesignDecision(connectorConfigDecision);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case designdecisionPackage.SOAP_OR_RMI: {
				SoapOrRmi soapOrRmi = (SoapOrRmi)theEObject;
				T result = caseSoapOrRmi(soapOrRmi);
				if (result == null) result = caseEnumeration(soapOrRmi);
				if (result == null) result = caseDomain(soapOrRmi);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Design Decision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Design Decision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDesignDecision(DesignDecision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomain(Domain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoice(Choice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRange(Range object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumeration(Enumeration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equivalent Components</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equivalent Components</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEquivalentComponents(EquivalentComponents object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Available Servers</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Available Servers</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAvailableServers(AvailableServers object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentChoice(ComponentChoice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Allocation Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Allocation Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllocationChoice(AllocationChoice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processing Rate Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processing Rate Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessingRateChoice(ProcessingRateChoice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processing Rate Decision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processing Rate Decision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessingRateDecision(ProcessingRateDecision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Allocation Decision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Allocation Decision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllocationDecision(AllocationDecision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assembled Component Decision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assembled Component Decision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssembledComponentDecision(AssembledComponentDecision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerRange(IntegerRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleRange(DoubleRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Container Replication Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Container Replication Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceContainerReplicationChoice(ResourceContainerReplicationChoice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Container Replication Decision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Container Replication Decision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceContainerReplicationDecision(ResourceContainerReplicationDecision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Genotype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Genotype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenotype(Genotype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Problem</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Problem</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProblem(Problem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Discrete Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Discrete Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiscreteDomain(DiscreteDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Config Decision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Config Decision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorConfigDecision(ConnectorConfigDecision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Soap Or Rmi</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Soap Or Rmi</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSoapOrRmi(SoapOrRmi object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //designdecisionSwitch
