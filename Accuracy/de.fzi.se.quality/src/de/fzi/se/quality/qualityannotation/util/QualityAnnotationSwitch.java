/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.fzi.se.quality.QualityStatement;
import de.fzi.se.quality.parameters.ParameterPartition;
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition;
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval;
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionRange;
import de.fzi.se.quality.qualityannotation.ExactlyAsSpecifiedPrecision;
import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision;
import de.fzi.se.quality.qualityannotation.NoPrecision;
import de.fzi.se.quality.qualityannotation.PCMPE;
import de.fzi.se.quality.qualityannotation.PCMPEAllDecisions;
import de.fzi.se.quality.qualityannotation.PCMPEDecision;
import de.fzi.se.quality.qualityannotation.PCMParameterPartition;
import de.fzi.se.quality.qualityannotation.PCMRE;
import de.fzi.se.quality.qualityannotation.PCMRECIBehavior;
import de.fzi.se.quality.qualityannotation.PCMRECategory;
import de.fzi.se.quality.qualityannotation.PCMREInfrastructureInterface;
import de.fzi.se.quality.qualityannotation.PCMREInfrastructureRole;
import de.fzi.se.quality.qualityannotation.PCMREInfrastructureSignature;
import de.fzi.se.quality.qualityannotation.PCMREInterface;
import de.fzi.se.quality.qualityannotation.PCMREResource;
import de.fzi.se.quality.qualityannotation.PCMREResourceInterface;
import de.fzi.se.quality.qualityannotation.PCMREResourceRole;
import de.fzi.se.quality.qualityannotation.PCMREResourceSignature;
import de.fzi.se.quality.qualityannotation.PCMRERole;
import de.fzi.se.quality.qualityannotation.PCMRESignature;
import de.fzi.se.quality.qualityannotation.PCMServiceSpecification;
import de.fzi.se.quality.qualityannotation.ParameterValueDeviation;
import de.fzi.se.quality.qualityannotation.Precision;
import de.fzi.se.quality.qualityannotation.ProbabilisticElement;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.REPrecision;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.fzi.se.quality.qualityannotation.RequiredElementDeviation;
import de.fzi.se.quality.qualityannotation.ServiceSpecification;
import de.uka.ipd.sdq.identifier.Identifier;

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
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage
 * @generated
 */
public class QualityAnnotationSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static QualityAnnotationPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public QualityAnnotationSwitch() {
        if (modelPackage == null) {
            modelPackage = QualityAnnotationPackage.eINSTANCE;
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
            case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION: {
                ParameterValueDeviation parameterValueDeviation = (ParameterValueDeviation)theEObject;
                T result = caseParameterValueDeviation(parameterValueDeviation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.QUALITY_ANNOTATION: {
                QualityAnnotation qualityAnnotation = (QualityAnnotation)theEObject;
                T result = caseQualityAnnotation(qualityAnnotation);
                if (result == null) result = caseQualityStatement(qualityAnnotation);
                if (result == null) result = caseIdentifier(qualityAnnotation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.SERVICE_SPECIFICATION: {
                ServiceSpecification serviceSpecification = (ServiceSpecification)theEObject;
                T result = caseServiceSpecification(serviceSpecification);
                if (result == null) result = caseIdentifier(serviceSpecification);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.REQUIRED_ELEMENT: {
                RequiredElement requiredElement = (RequiredElement)theEObject;
                T result = caseRequiredElement(requiredElement);
                if (result == null) result = caseIdentifier(requiredElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION: {
                RequiredElementDeviation requiredElementDeviation = (RequiredElementDeviation)theEObject;
                T result = caseRequiredElementDeviation(requiredElementDeviation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION: {
                InternalStateInfluenceAnalysisAggregation internalStateInfluenceAnalysisAggregation = (InternalStateInfluenceAnalysisAggregation)theEObject;
                T result = caseInternalStateInfluenceAnalysisAggregation(internalStateInfluenceAnalysisAggregation);
                if (result == null) result = caseIdentifier(internalStateInfluenceAnalysisAggregation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PRECISION: {
                Precision precision = (Precision)theEObject;
                T result = casePrecision(precision);
                if (result == null) result = caseIdentifier(precision);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.RE_PRECISION: {
                REPrecision rePrecision = (REPrecision)theEObject;
                T result = caseREPrecision(rePrecision);
                if (result == null) result = caseIdentifier(rePrecision);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PROBABILISTIC_ELEMENT: {
                ProbabilisticElement probabilisticElement = (ProbabilisticElement)theEObject;
                T result = caseProbabilisticElement(probabilisticElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION: {
                CharacterisedPCMParameterPartition characterisedPCMParameterPartition = (CharacterisedPCMParameterPartition)theEObject;
                T result = caseCharacterisedPCMParameterPartition(characterisedPCMParameterPartition);
                if (result == null) result = caseIdentifier(characterisedPCMParameterPartition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCM_PARAMETER_PARTITION: {
                PCMParameterPartition pcmParameterPartition = (PCMParameterPartition)theEObject;
                T result = casePCMParameterPartition(pcmParameterPartition);
                if (result == null) result = caseParameterPartition(pcmParameterPartition);
                if (result == null) result = caseIdentifier(pcmParameterPartition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL: {
                CharacterisedPCMParameterPartitionInterval characterisedPCMParameterPartitionInterval = (CharacterisedPCMParameterPartitionInterval)theEObject;
                T result = caseCharacterisedPCMParameterPartitionInterval(characterisedPCMParameterPartitionInterval);
                if (result == null) result = caseCharacterisedPCMParameterPartition(characterisedPCMParameterPartitionInterval);
                if (result == null) result = caseIdentifier(characterisedPCMParameterPartitionInterval);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE: {
                CharacterisedPCMParameterPartitionRange characterisedPCMParameterPartitionRange = (CharacterisedPCMParameterPartitionRange)theEObject;
                T result = caseCharacterisedPCMParameterPartitionRange(characterisedPCMParameterPartitionRange);
                if (result == null) result = caseCharacterisedPCMParameterPartition(characterisedPCMParameterPartitionRange);
                if (result == null) result = caseIdentifier(characterisedPCMParameterPartitionRange);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.EXACTLY_AS_SPECIFIED_PRECISION: {
                ExactlyAsSpecifiedPrecision exactlyAsSpecifiedPrecision = (ExactlyAsSpecifiedPrecision)theEObject;
                T result = caseExactlyAsSpecifiedPrecision(exactlyAsSpecifiedPrecision);
                if (result == null) result = casePrecision(exactlyAsSpecifiedPrecision);
                if (result == null) result = caseIdentifier(exactlyAsSpecifiedPrecision);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION: {
                LimitedDeviationPrecision limitedDeviationPrecision = (LimitedDeviationPrecision)theEObject;
                T result = caseLimitedDeviationPrecision(limitedDeviationPrecision);
                if (result == null) result = casePrecision(limitedDeviationPrecision);
                if (result == null) result = caseIdentifier(limitedDeviationPrecision);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.NO_PRECISION: {
                NoPrecision noPrecision = (NoPrecision)theEObject;
                T result = caseNoPrecision(noPrecision);
                if (result == null) result = casePrecision(noPrecision);
                if (result == null) result = caseIdentifier(noPrecision);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMRE_CATEGORY: {
                PCMRECategory pcmreCategory = (PCMRECategory)theEObject;
                T result = casePCMRECategory(pcmreCategory);
                if (result == null) result = casePCMRE(pcmreCategory);
                if (result == null) result = caseRequiredElement(pcmreCategory);
                if (result == null) result = caseIdentifier(pcmreCategory);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMRE: {
                PCMRE pcmre = (PCMRE)theEObject;
                T result = casePCMRE(pcmre);
                if (result == null) result = caseRequiredElement(pcmre);
                if (result == null) result = caseIdentifier(pcmre);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMRE_INTERFACE: {
                PCMREInterface pcmreInterface = (PCMREInterface)theEObject;
                T result = casePCMREInterface(pcmreInterface);
                if (result == null) result = casePCMRE(pcmreInterface);
                if (result == null) result = caseRequiredElement(pcmreInterface);
                if (result == null) result = caseIdentifier(pcmreInterface);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMRE_ROLE: {
                PCMRERole pcmreRole = (PCMRERole)theEObject;
                T result = casePCMRERole(pcmreRole);
                if (result == null) result = casePCMRE(pcmreRole);
                if (result == null) result = caseRequiredElement(pcmreRole);
                if (result == null) result = caseIdentifier(pcmreRole);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMRE_SIGNATURE: {
                PCMRESignature pcmreSignature = (PCMRESignature)theEObject;
                T result = casePCMRESignature(pcmreSignature);
                if (result == null) result = casePCMRE(pcmreSignature);
                if (result == null) result = caseRequiredElement(pcmreSignature);
                if (result == null) result = caseIdentifier(pcmreSignature);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION: {
                PCMServiceSpecification pcmServiceSpecification = (PCMServiceSpecification)theEObject;
                T result = casePCMServiceSpecification(pcmServiceSpecification);
                if (result == null) result = caseServiceSpecification(pcmServiceSpecification);
                if (result == null) result = caseIdentifier(pcmServiceSpecification);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE: {
                PCMREResourceInterface pcmreResourceInterface = (PCMREResourceInterface)theEObject;
                T result = casePCMREResourceInterface(pcmreResourceInterface);
                if (result == null) result = casePCMRE(pcmreResourceInterface);
                if (result == null) result = caseRequiredElement(pcmreResourceInterface);
                if (result == null) result = caseIdentifier(pcmreResourceInterface);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE: {
                PCMREResourceSignature pcmreResourceSignature = (PCMREResourceSignature)theEObject;
                T result = casePCMREResourceSignature(pcmreResourceSignature);
                if (result == null) result = casePCMRE(pcmreResourceSignature);
                if (result == null) result = caseRequiredElement(pcmreResourceSignature);
                if (result == null) result = caseIdentifier(pcmreResourceSignature);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMRE_RESOURCE: {
                PCMREResource pcmreResource = (PCMREResource)theEObject;
                T result = casePCMREResource(pcmreResource);
                if (result == null) result = casePCMRE(pcmreResource);
                if (result == null) result = caseRequiredElement(pcmreResource);
                if (result == null) result = caseIdentifier(pcmreResource);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMRE_RESOURCE_ROLE: {
                PCMREResourceRole pcmreResourceRole = (PCMREResourceRole)theEObject;
                T result = casePCMREResourceRole(pcmreResourceRole);
                if (result == null) result = casePCMRE(pcmreResourceRole);
                if (result == null) result = caseRequiredElement(pcmreResourceRole);
                if (result == null) result = caseIdentifier(pcmreResourceRole);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMRECI_BEHAVIOR: {
                PCMRECIBehavior pcmreciBehavior = (PCMRECIBehavior)theEObject;
                T result = casePCMRECIBehavior(pcmreciBehavior);
                if (result == null) result = casePCMRE(pcmreciBehavior);
                if (result == null) result = caseRequiredElement(pcmreciBehavior);
                if (result == null) result = caseIdentifier(pcmreciBehavior);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_INTERFACE: {
                PCMREInfrastructureInterface pcmreInfrastructureInterface = (PCMREInfrastructureInterface)theEObject;
                T result = casePCMREInfrastructureInterface(pcmreInfrastructureInterface);
                if (result == null) result = casePCMRE(pcmreInfrastructureInterface);
                if (result == null) result = caseRequiredElement(pcmreInfrastructureInterface);
                if (result == null) result = caseIdentifier(pcmreInfrastructureInterface);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_ROLE: {
                PCMREInfrastructureRole pcmreInfrastructureRole = (PCMREInfrastructureRole)theEObject;
                T result = casePCMREInfrastructureRole(pcmreInfrastructureRole);
                if (result == null) result = casePCMRE(pcmreInfrastructureRole);
                if (result == null) result = caseRequiredElement(pcmreInfrastructureRole);
                if (result == null) result = caseIdentifier(pcmreInfrastructureRole);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_SIGNATURE: {
                PCMREInfrastructureSignature pcmreInfrastructureSignature = (PCMREInfrastructureSignature)theEObject;
                T result = casePCMREInfrastructureSignature(pcmreInfrastructureSignature);
                if (result == null) result = casePCMRE(pcmreInfrastructureSignature);
                if (result == null) result = caseRequiredElement(pcmreInfrastructureSignature);
                if (result == null) result = caseIdentifier(pcmreInfrastructureSignature);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMPE: {
                PCMPE pcmpe = (PCMPE)theEObject;
                T result = casePCMPE(pcmpe);
                if (result == null) result = caseProbabilisticElement(pcmpe);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMPE_ALL_DECISIONS: {
                PCMPEAllDecisions pcmpeAllDecisions = (PCMPEAllDecisions)theEObject;
                T result = casePCMPEAllDecisions(pcmpeAllDecisions);
                if (result == null) result = casePCMPE(pcmpeAllDecisions);
                if (result == null) result = caseProbabilisticElement(pcmpeAllDecisions);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case QualityAnnotationPackage.PCMPE_DECISION: {
                PCMPEDecision pcmpeDecision = (PCMPEDecision)theEObject;
                T result = casePCMPEDecision(pcmpeDecision);
                if (result == null) result = casePCMPE(pcmpeDecision);
                if (result == null) result = caseProbabilisticElement(pcmpeDecision);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Parameter Value Deviation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter Value Deviation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseParameterValueDeviation(ParameterValueDeviation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Quality Annotation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Quality Annotation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseQualityAnnotation(QualityAnnotation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Service Specification</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Service Specification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseServiceSpecification(ServiceSpecification object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Required Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Required Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseRequiredElement(RequiredElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Required Element Deviation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Required Element Deviation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseRequiredElementDeviation(RequiredElementDeviation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Internal State Influence Analysis Aggregation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Internal State Influence Analysis Aggregation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseInternalStateInfluenceAnalysisAggregation(InternalStateInfluenceAnalysisAggregation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>RE Precision</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>RE Precision</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseREPrecision(REPrecision object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Probabilistic Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Probabilistic Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseProbabilisticElement(ProbabilisticElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Precision</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Precision</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePrecision(Precision object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCM Parameter Partition</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCM Parameter Partition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMParameterPartition(PCMParameterPartition object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Characterised PCM Parameter Partition</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Characterised PCM Parameter Partition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCharacterisedPCMParameterPartition(CharacterisedPCMParameterPartition object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Characterised PCM Parameter Partition Interval</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Characterised PCM Parameter Partition Interval</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCharacterisedPCMParameterPartitionInterval(CharacterisedPCMParameterPartitionInterval object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Characterised PCM Parameter Partition Range</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Characterised PCM Parameter Partition Range</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCharacterisedPCMParameterPartitionRange(CharacterisedPCMParameterPartitionRange object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Exactly As Specified Precision</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Exactly As Specified Precision</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseExactlyAsSpecifiedPrecision(ExactlyAsSpecifiedPrecision object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Limited Deviation Precision</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Limited Deviation Precision</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLimitedDeviationPrecision(LimitedDeviationPrecision object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>No Precision</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>No Precision</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNoPrecision(NoPrecision object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Category</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Category</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMRECategory(PCMRECategory object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMRE(PCMRE object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Interface</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Interface</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMREInterface(PCMREInterface object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Role</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Role</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMRERole(PCMRERole object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Signature</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Signature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMRESignature(PCMRESignature object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCM Service Specification</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCM Service Specification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMServiceSpecification(PCMServiceSpecification object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Resource Interface</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Resource Interface</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMREResourceInterface(PCMREResourceInterface object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Resource Signature</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Resource Signature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMREResourceSignature(PCMREResourceSignature object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Resource</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Resource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMREResource(PCMREResource object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Resource Role</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Resource Role</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMREResourceRole(PCMREResourceRole object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMRECI Behavior</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRECI Behavior</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMRECIBehavior(PCMRECIBehavior object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Infrastructure Interface</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Infrastructure Interface</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMREInfrastructureInterface(PCMREInfrastructureInterface object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Infrastructure Role</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Infrastructure Role</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMREInfrastructureRole(PCMREInfrastructureRole object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Infrastructure Signature</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Infrastructure Signature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMREInfrastructureSignature(PCMREInfrastructureSignature object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMPE</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMPE</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMPE(PCMPE object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMPE All Decisions</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMPE All Decisions</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMPEAllDecisions(PCMPEAllDecisions object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>PCMPE Decision</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMPE Decision</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T casePCMPEDecision(PCMPEDecision object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseIdentifier(Identifier object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseQualityStatement(QualityStatement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Parameter Partition</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter Partition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseParameterPartition(ParameterPartition object) {
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

} //QualityAnnotationSwitch
