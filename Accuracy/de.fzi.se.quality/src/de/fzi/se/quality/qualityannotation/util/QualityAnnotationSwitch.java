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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage
 * @generated
 */
public class QualityAnnotationSwitch<T> {

    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static QualityAnnotationPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public QualityAnnotationSwitch() {
        if (modelPackage == null) {
            modelPackage = QualityAnnotationPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(final EObject theEObject) {
        return this.doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(final EClass theEClass, final EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return this.doSwitch(theEClass.getClassifierID(), theEObject);
        } else {
            final List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return eSuperTypes.isEmpty() ? this.defaultCase(theEObject) : this.doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(final int classifierID, final EObject theEObject) {
        switch (classifierID) {
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION: {
            final ParameterValueDeviation parameterValueDeviation = (ParameterValueDeviation) theEObject;
            T result = this.caseParameterValueDeviation(parameterValueDeviation);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.QUALITY_ANNOTATION: {
            final QualityAnnotation qualityAnnotation = (QualityAnnotation) theEObject;
            T result = this.caseQualityAnnotation(qualityAnnotation);
            if (result == null) {
                result = this.caseQualityStatement(qualityAnnotation);
            }
            if (result == null) {
                result = this.caseIdentifier(qualityAnnotation);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.SERVICE_SPECIFICATION: {
            final ServiceSpecification serviceSpecification = (ServiceSpecification) theEObject;
            T result = this.caseServiceSpecification(serviceSpecification);
            if (result == null) {
                result = this.caseIdentifier(serviceSpecification);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.REQUIRED_ELEMENT: {
            final RequiredElement requiredElement = (RequiredElement) theEObject;
            T result = this.caseRequiredElement(requiredElement);
            if (result == null) {
                result = this.caseIdentifier(requiredElement);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION: {
            final RequiredElementDeviation requiredElementDeviation = (RequiredElementDeviation) theEObject;
            T result = this.caseRequiredElementDeviation(requiredElementDeviation);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION: {
            final InternalStateInfluenceAnalysisAggregation internalStateInfluenceAnalysisAggregation = (InternalStateInfluenceAnalysisAggregation) theEObject;
            T result = this.caseInternalStateInfluenceAnalysisAggregation(internalStateInfluenceAnalysisAggregation);
            if (result == null) {
                result = this.caseIdentifier(internalStateInfluenceAnalysisAggregation);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PRECISION: {
            final Precision precision = (Precision) theEObject;
            T result = this.casePrecision(precision);
            if (result == null) {
                result = this.caseIdentifier(precision);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.RE_PRECISION: {
            final REPrecision rePrecision = (REPrecision) theEObject;
            T result = this.caseREPrecision(rePrecision);
            if (result == null) {
                result = this.caseIdentifier(rePrecision);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT: {
            final ProbabilisticElement probabilisticElement = (ProbabilisticElement) theEObject;
            T result = this.caseProbabilisticElement(probabilisticElement);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION: {
            final CharacterisedPCMParameterPartition characterisedPCMParameterPartition = (CharacterisedPCMParameterPartition) theEObject;
            T result = this.caseCharacterisedPCMParameterPartition(characterisedPCMParameterPartition);
            if (result == null) {
                result = this.caseIdentifier(characterisedPCMParameterPartition);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCM_PARAMETER_PARTITION: {
            final PCMParameterPartition pcmParameterPartition = (PCMParameterPartition) theEObject;
            T result = this.casePCMParameterPartition(pcmParameterPartition);
            if (result == null) {
                result = this.caseParameterPartition(pcmParameterPartition);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmParameterPartition);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL: {
            final CharacterisedPCMParameterPartitionInterval characterisedPCMParameterPartitionInterval = (CharacterisedPCMParameterPartitionInterval) theEObject;
            T result = this.caseCharacterisedPCMParameterPartitionInterval(characterisedPCMParameterPartitionInterval);
            if (result == null) {
                result = this.caseCharacterisedPCMParameterPartition(characterisedPCMParameterPartitionInterval);
            }
            if (result == null) {
                result = this.caseIdentifier(characterisedPCMParameterPartitionInterval);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE: {
            final CharacterisedPCMParameterPartitionRange characterisedPCMParameterPartitionRange = (CharacterisedPCMParameterPartitionRange) theEObject;
            T result = this.caseCharacterisedPCMParameterPartitionRange(characterisedPCMParameterPartitionRange);
            if (result == null) {
                result = this.caseCharacterisedPCMParameterPartition(characterisedPCMParameterPartitionRange);
            }
            if (result == null) {
                result = this.caseIdentifier(characterisedPCMParameterPartitionRange);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.EXACTLY_AS_SPECIFIED_PRECISION: {
            final ExactlyAsSpecifiedPrecision exactlyAsSpecifiedPrecision = (ExactlyAsSpecifiedPrecision) theEObject;
            T result = this.caseExactlyAsSpecifiedPrecision(exactlyAsSpecifiedPrecision);
            if (result == null) {
                result = this.casePrecision(exactlyAsSpecifiedPrecision);
            }
            if (result == null) {
                result = this.caseIdentifier(exactlyAsSpecifiedPrecision);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION: {
            final LimitedDeviationPrecision limitedDeviationPrecision = (LimitedDeviationPrecision) theEObject;
            T result = this.caseLimitedDeviationPrecision(limitedDeviationPrecision);
            if (result == null) {
                result = this.casePrecision(limitedDeviationPrecision);
            }
            if (result == null) {
                result = this.caseIdentifier(limitedDeviationPrecision);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.NO_PRECISION: {
            final NoPrecision noPrecision = (NoPrecision) theEObject;
            T result = this.caseNoPrecision(noPrecision);
            if (result == null) {
                result = this.casePrecision(noPrecision);
            }
            if (result == null) {
                result = this.caseIdentifier(noPrecision);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMRE_CATEGORY: {
            final PCMRECategory pcmreCategory = (PCMRECategory) theEObject;
            T result = this.casePCMRECategory(pcmreCategory);
            if (result == null) {
                result = this.casePCMRE(pcmreCategory);
            }
            if (result == null) {
                result = this.caseRequiredElement(pcmreCategory);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmreCategory);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMRE: {
            final PCMRE pcmre = (PCMRE) theEObject;
            T result = this.casePCMRE(pcmre);
            if (result == null) {
                result = this.caseRequiredElement(pcmre);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmre);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMRE_INTERFACE: {
            final PCMREInterface pcmreInterface = (PCMREInterface) theEObject;
            T result = this.casePCMREInterface(pcmreInterface);
            if (result == null) {
                result = this.casePCMRE(pcmreInterface);
            }
            if (result == null) {
                result = this.caseRequiredElement(pcmreInterface);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmreInterface);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMRE_ROLE: {
            final PCMRERole pcmreRole = (PCMRERole) theEObject;
            T result = this.casePCMRERole(pcmreRole);
            if (result == null) {
                result = this.casePCMRE(pcmreRole);
            }
            if (result == null) {
                result = this.caseRequiredElement(pcmreRole);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmreRole);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMRE_SIGNATURE: {
            final PCMRESignature pcmreSignature = (PCMRESignature) theEObject;
            T result = this.casePCMRESignature(pcmreSignature);
            if (result == null) {
                result = this.casePCMRE(pcmreSignature);
            }
            if (result == null) {
                result = this.caseRequiredElement(pcmreSignature);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmreSignature);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION: {
            final PCMServiceSpecification pcmServiceSpecification = (PCMServiceSpecification) theEObject;
            T result = this.casePCMServiceSpecification(pcmServiceSpecification);
            if (result == null) {
                result = this.caseServiceSpecification(pcmServiceSpecification);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmServiceSpecification);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE: {
            final PCMREResourceInterface pcmreResourceInterface = (PCMREResourceInterface) theEObject;
            T result = this.casePCMREResourceInterface(pcmreResourceInterface);
            if (result == null) {
                result = this.casePCMRE(pcmreResourceInterface);
            }
            if (result == null) {
                result = this.caseRequiredElement(pcmreResourceInterface);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmreResourceInterface);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMRE_RESOURCE_SIGNATURE: {
            final PCMREResourceSignature pcmreResourceSignature = (PCMREResourceSignature) theEObject;
            T result = this.casePCMREResourceSignature(pcmreResourceSignature);
            if (result == null) {
                result = this.casePCMRE(pcmreResourceSignature);
            }
            if (result == null) {
                result = this.caseRequiredElement(pcmreResourceSignature);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmreResourceSignature);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMRE_RESOURCE: {
            final PCMREResource pcmreResource = (PCMREResource) theEObject;
            T result = this.casePCMREResource(pcmreResource);
            if (result == null) {
                result = this.casePCMRE(pcmreResource);
            }
            if (result == null) {
                result = this.caseRequiredElement(pcmreResource);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmreResource);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMRE_RESOURCE_ROLE: {
            final PCMREResourceRole pcmreResourceRole = (PCMREResourceRole) theEObject;
            T result = this.casePCMREResourceRole(pcmreResourceRole);
            if (result == null) {
                result = this.casePCMRE(pcmreResourceRole);
            }
            if (result == null) {
                result = this.caseRequiredElement(pcmreResourceRole);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmreResourceRole);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMRECI_BEHAVIOR: {
            final PCMRECIBehavior pcmreciBehavior = (PCMRECIBehavior) theEObject;
            T result = this.casePCMRECIBehavior(pcmreciBehavior);
            if (result == null) {
                result = this.casePCMRE(pcmreciBehavior);
            }
            if (result == null) {
                result = this.caseRequiredElement(pcmreciBehavior);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmreciBehavior);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_INTERFACE: {
            final PCMREInfrastructureInterface pcmreInfrastructureInterface = (PCMREInfrastructureInterface) theEObject;
            T result = this.casePCMREInfrastructureInterface(pcmreInfrastructureInterface);
            if (result == null) {
                result = this.casePCMRE(pcmreInfrastructureInterface);
            }
            if (result == null) {
                result = this.caseRequiredElement(pcmreInfrastructureInterface);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmreInfrastructureInterface);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_ROLE: {
            final PCMREInfrastructureRole pcmreInfrastructureRole = (PCMREInfrastructureRole) theEObject;
            T result = this.casePCMREInfrastructureRole(pcmreInfrastructureRole);
            if (result == null) {
                result = this.casePCMRE(pcmreInfrastructureRole);
            }
            if (result == null) {
                result = this.caseRequiredElement(pcmreInfrastructureRole);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmreInfrastructureRole);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMRE_INFRASTRUCTURE_SIGNATURE: {
            final PCMREInfrastructureSignature pcmreInfrastructureSignature = (PCMREInfrastructureSignature) theEObject;
            T result = this.casePCMREInfrastructureSignature(pcmreInfrastructureSignature);
            if (result == null) {
                result = this.casePCMRE(pcmreInfrastructureSignature);
            }
            if (result == null) {
                result = this.caseRequiredElement(pcmreInfrastructureSignature);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmreInfrastructureSignature);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMPE: {
            final PCMPE pcmpe = (PCMPE) theEObject;
            T result = this.casePCMPE(pcmpe);
            if (result == null) {
                result = this.caseProbabilisticElement(pcmpe);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMPE_ALL_DECISIONS: {
            final PCMPEAllDecisions pcmpeAllDecisions = (PCMPEAllDecisions) theEObject;
            T result = this.casePCMPEAllDecisions(pcmpeAllDecisions);
            if (result == null) {
                result = this.casePCMPE(pcmpeAllDecisions);
            }
            if (result == null) {
                result = this.caseProbabilisticElement(pcmpeAllDecisions);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QualityAnnotationPackage.PCMPE_DECISION: {
            final PCMPEDecision pcmpeDecision = (PCMPEDecision) theEObject;
            T result = this.casePCMPEDecision(pcmpeDecision);
            if (result == null) {
                result = this.casePCMPE(pcmpeDecision);
            }
            if (result == null) {
                result = this.caseProbabilisticElement(pcmpeDecision);
            }
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
     * <em>Parameter Value Deviation</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Parameter Value Deviation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParameterValueDeviation(final ParameterValueDeviation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Quality Annotation</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Quality Annotation</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseQualityAnnotation(final QualityAnnotation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Service Specification</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Service Specification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseServiceSpecification(final ServiceSpecification object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Required Element</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Required Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRequiredElement(final RequiredElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Required Element Deviation</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Required Element Deviation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRequiredElementDeviation(final RequiredElementDeviation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Internal State Influence Analysis Aggregation</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Internal State Influence Analysis Aggregation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInternalStateInfluenceAnalysisAggregation(final InternalStateInfluenceAnalysisAggregation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>RE Precision</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>RE Precision</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseREPrecision(final REPrecision object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Probabilistic Element</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Probabilistic Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProbabilisticElement(final ProbabilisticElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Precision</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Precision</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrecision(final Precision object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>PCM Parameter Partition</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>PCM Parameter Partition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMParameterPartition(final PCMParameterPartition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Characterised PCM Parameter Partition</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Characterised PCM Parameter Partition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCharacterisedPCMParameterPartition(final CharacterisedPCMParameterPartition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Characterised PCM Parameter Partition Interval</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Characterised PCM Parameter Partition Interval</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCharacterisedPCMParameterPartitionInterval(final CharacterisedPCMParameterPartitionInterval object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Characterised PCM Parameter Partition Range</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Characterised PCM Parameter Partition Range</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCharacterisedPCMParameterPartitionRange(final CharacterisedPCMParameterPartitionRange object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Exactly As Specified Precision</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Exactly As Specified Precision</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExactlyAsSpecifiedPrecision(final ExactlyAsSpecifiedPrecision object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Limited Deviation Precision</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Limited Deviation Precision</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLimitedDeviationPrecision(final LimitedDeviationPrecision object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>No Precision</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>No Precision</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNoPrecision(final NoPrecision object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Category</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Category</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMRECategory(final PCMRECategory object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMRE(final PCMRE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Interface</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Interface</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMREInterface(final PCMREInterface object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Role</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Role</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMRERole(final PCMRERole object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Signature</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Signature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMRESignature(final PCMRESignature object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>PCM Service Specification</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>PCM Service Specification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMServiceSpecification(final PCMServiceSpecification object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>PCMRE Resource Interface</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>PCMRE Resource Interface</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMREResourceInterface(final PCMREResourceInterface object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>PCMRE Resource Signature</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>PCMRE Resource Signature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMREResourceSignature(final PCMREResourceSignature object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Resource</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Resource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMREResource(final PCMREResource object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PCMRE Resource Role</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRE Resource Role</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMREResourceRole(final PCMREResourceRole object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PCMRECI Behavior</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMRECI Behavior</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMRECIBehavior(final PCMRECIBehavior object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>PCMRE Infrastructure Interface</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>PCMRE Infrastructure Interface</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMREInfrastructureInterface(final PCMREInfrastructureInterface object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>PCMRE Infrastructure Role</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>PCMRE Infrastructure Role</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMREInfrastructureRole(final PCMREInfrastructureRole object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>PCMRE Infrastructure Signature</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>PCMRE Infrastructure Signature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMREInfrastructureSignature(final PCMREInfrastructureSignature object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PCMPE</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMPE</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMPE(final PCMPE object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PCMPE All Decisions</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMPE All Decisions</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMPEAllDecisions(final PCMPEAllDecisions object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>PCMPE Decision</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>PCMPE Decision</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMPEDecision(final PCMPEDecision object) {
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
    public T caseIdentifier(final Identifier object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Statement</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseQualityStatement(final QualityStatement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Parameter Partition</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter Partition</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParameterPartition(final ParameterPartition object) {
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
    public T defaultCase(final EObject object) {
        return null;
    }

} // QualityAnnotationSwitch
