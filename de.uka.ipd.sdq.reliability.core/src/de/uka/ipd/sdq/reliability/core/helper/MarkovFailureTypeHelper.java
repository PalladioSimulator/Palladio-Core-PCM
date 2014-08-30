package de.uka.ipd.sdq.reliability.core.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation;
import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.SpecifiedReliabilityAnnotation;
import de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.FailureType;
import de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.NetworkInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.ipd.sdq.reliability.core.MarkovEvaluationType;
import de.uka.ipd.sdq.reliability.core.MarkovFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovHardwareInducedFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovNetworkInducedFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovResourceTimeoutFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovSoftwareInducedFailureType;

/**
 * This class provides auxiliary functionality for managing MarkovFailureTypes.
 * 
 * @author brosch
 * 
 */
public class MarkovFailureTypeHelper {

    /**
     * Provides EMF utility functions.
     */
    private EMFHelper helper = new EMFHelper();

    /**
     * Retrieves a list of potential failure types from a given PCM model instance.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param repositories
     *            the list of PCm Repository models
     * @param environment
     *            the PCM ResourceEnvironment model
     * @param system
     *            the PCM System model
     * @return the list of potential failure types
     */
    public List<MarkovFailureType> getFailureTypes(final MarkovEvaluationType evaluationType,
            final List<Repository> repositories, final ResourceEnvironment environment, final System system) {
        List<MarkovFailureType> failureTypes = getNetworkFailureTypes(evaluationType, environment, system);
        failureTypes.addAll(getHardwareFailureTypes(evaluationType, environment, system));
        failureTypes.addAll(getResourceTimeoutFailureTypes(evaluationType, system));
        failureTypes.addAll(getSoftwareFailureTypes(evaluationType, repositories, system));
        return removeDoubleFailureTypes(failureTypes);

    }

    /**
     * Retrieves the list of processing resource failure types from the given PCM model.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param environment
     *            the PCM Resource Environment model
     * @param system
     *            the PCM System model
     * @return the list of processing resource failure types
     */
    private List<MarkovFailureType> getHardwareFailureTypes(final MarkovEvaluationType evaluationType,
            final ResourceEnvironment environment, final System system) {

        // Initialize the list of results:
        ArrayList<MarkovFailureType> resultList = new ArrayList<MarkovFailureType>();

        // Handle the PCM resource environment model:
        for (ResourceContainer container : environment.getResourceContainer_ResourceEnvironment()) {
            for (ProcessingResourceSpecification specification : container
                    .getActiveResourceSpecifications_ResourceContainer()) {
                ProcessingResourceType resourceType = specification.getActiveResourceType_ActiveResourceSpecification();
                resultList.add(MarkovHardwareInducedFailureType.createInternalFailureType(evaluationType, container,
                        resourceType));
            }
        }

        // Handle the PCM system model:
        for (QoSAnnotations qos : system.getQosAnnotations_System()) {
            for (SpecifiedQoSAnnotation annotation : qos.getSpecifiedQoSAnnotations_QoSAnnotations()) {
                if (annotation instanceof SpecifiedReliabilityAnnotation) {
                    SpecifiedReliabilityAnnotation relAnnotation = ((SpecifiedReliabilityAnnotation) annotation);
                    for (ExternalFailureOccurrenceDescription description : relAnnotation
                            .getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation()) {
                        FailureType failureType = description.getFailureType__ExternalFailureOccurrenceDescription();
                        if (failureType instanceof HardwareInducedFailureType) {
                            HardwareInducedFailureType hardwareFailureType = ((HardwareInducedFailureType) failureType);
                            resultList.add(MarkovHardwareInducedFailureType.createExternalFailureType(evaluationType,
                                    hardwareFailureType.getProcessingResourceType__HardwareInducedFailureType(),
                                    annotation.getSignature_SpecifiedQoSAnnation(), annotation
                                            .getRole_SpecifiedQoSAnnotation(), ((OperationRequiredRole) annotation
                                            .getRole_SpecifiedQoSAnnotation())
                                            .getRequiredInterface__OperationRequiredRole()));
                        }
                    }
                }
            }
        }

        // Return the result:
        return resultList;
    }

    /**
     * Retrieves the list of communication failure types from the given PCM model.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param environment
     *            the PCM Resource Environment model
     * @param system
     *            the PCM System model
     * @return the list of communication resource failure types
     */
    private List<MarkovFailureType> getNetworkFailureTypes(final MarkovEvaluationType evaluationType,
            final ResourceEnvironment environment, final System system) {

        // Initialize the list of results:
        ArrayList<MarkovFailureType> resultList = new ArrayList<MarkovFailureType>();

        // Handle the PCM resource environment model:
        for (LinkingResource commLink : environment.getLinkingResources__ResourceEnvironment()) {
            CommunicationLinkResourceSpecification specification = commLink
                    .getCommunicationLinkResourceSpecifications_LinkingResource();
            CommunicationLinkResourceType resourceType = specification
                    .getCommunicationLinkResourceType_CommunicationLinkResourceSpecification();
            resultList.add(MarkovNetworkInducedFailureType.createInternalFailureType(evaluationType, commLink,
                    resourceType));
        }

        // Handle the PCM system model:
        for (QoSAnnotations qos : system.getQosAnnotations_System()) {
            for (SpecifiedQoSAnnotation annotation : qos.getSpecifiedQoSAnnotations_QoSAnnotations()) {
                if (annotation instanceof SpecifiedReliabilityAnnotation) {
                    SpecifiedReliabilityAnnotation relAnnotation = ((SpecifiedReliabilityAnnotation) annotation);
                    for (ExternalFailureOccurrenceDescription description : relAnnotation
                            .getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation()) {
                        FailureType failureType = description.getFailureType__ExternalFailureOccurrenceDescription();
                        if (failureType instanceof NetworkInducedFailureType) {
                            CommunicationLinkResourceType resourceType = ((NetworkInducedFailureType) failureType)
                                    .getCommunicationLinkResourceType__NetworkInducedFailureType();
                            resultList.add(MarkovNetworkInducedFailureType.createExternalFailureType(evaluationType,
                                    resourceType, annotation.getSignature_SpecifiedQoSAnnation(), annotation
                                            .getRole_SpecifiedQoSAnnotation(), ((OperationRequiredRole) annotation
                                            .getRole_SpecifiedQoSAnnotation())
                                            .getRequiredInterface__OperationRequiredRole()));
                        }
                    }
                }
            }
        }

        // Return the result:
        return resultList;
    }

    /**
     * Retrieves the list of resource timeout failure types from the given PCM model.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param system
     *            the PCM System model
     * @return the list of resource timeout failure types
     */
    private List<MarkovFailureType> getResourceTimeoutFailureTypes(final MarkovEvaluationType evaluationType,
            final System system) {

        // Initialize the list of results:
        ArrayList<MarkovFailureType> resultList = new ArrayList<MarkovFailureType>();

        // Handle the PCM system model:
        for (AssemblyContext context : system.getAssemblyContexts__ComposedStructure()) {
            RepositoryComponent component = context.getEncapsulatedComponent__AssemblyContext();
            if (!(component instanceof BasicComponent)) {
                continue;
            }
            for (PassiveResource resource : ((BasicComponent) component).getPassiveResource_BasicComponent()) {
                resultList.add(MarkovResourceTimeoutFailureType.createResourceTimeoutFailureType(evaluationType,
                        context, ((BasicComponent) component), resource));
            }
        }

        // Return the result:
        return resultList;
    }

    /**
     * Retrieves the list of software failure types from the given PCM model.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param repositories
     *            the PCM Repository models
     * @param system
     *            the PCM System model
     * @return the list of software failure types
     */
    private List<MarkovFailureType> getSoftwareFailureTypes(final MarkovEvaluationType evaluationType,
            final List<Repository> repositories, final System system) {

        // Initialize the list of results:
        ArrayList<MarkovFailureType> resultList = new ArrayList<MarkovFailureType>();

        // Handle the PCM repository models:
        for (Repository repository : repositories) {
            EList<EObject> components = helper.getElements(repository, RepositoryFactory.eINSTANCE
                    .createBasicComponent().eClass());
            for (Object c_object : components) {
                BasicComponent component = (BasicComponent) c_object;
                for (ProvidedRole role : component.getProvidedRoles_InterfaceProvidingEntity()) {
                    if (role instanceof OperationProvidedRole) {
                        OperationProvidedRole opRole = (OperationProvidedRole) role;
                        OperationInterface iface = opRole.getProvidedInterface__OperationProvidedRole();
                        for (OperationSignature signature : iface.getSignatures__OperationInterface()) {
                            ServiceEffectSpecification rdseff = getRDSEFF(component, signature);
                            EList<EObject> internalActions = helper.getElements(rdseff, SeffFactory.eINSTANCE
                                    .createInternalAction().eClass());
                            for (Object a_object : internalActions) {
                                InternalAction internalAction = (InternalAction) a_object;
                                for (InternalFailureOccurrenceDescription description : internalAction
                                        .getInternalFailureOccurrenceDescriptions__InternalAction()) {
                                    resultList
                                            .add(MarkovSoftwareInducedFailureType.createInternalFailureType(
                                                    evaluationType,
                                                    description
                                                            .getSoftwareInducedFailureType__InternalFailureOccurrenceDescription(),
                                                    internalAction, signature, opRole, iface, component));
                                }
                            }
                        }
                    }
                }
            }
        }

        // Handle the PCM system model:
        for (QoSAnnotations qos : system.getQosAnnotations_System()) {
            for (SpecifiedQoSAnnotation annotation : qos.getSpecifiedQoSAnnotations_QoSAnnotations()) {
                if (annotation instanceof SpecifiedReliabilityAnnotation) {
                    SpecifiedReliabilityAnnotation relAnnotation = ((SpecifiedReliabilityAnnotation) annotation);
                    for (ExternalFailureOccurrenceDescription description : relAnnotation
                            .getExternalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation()) {
                        FailureType failureType = description.getFailureType__ExternalFailureOccurrenceDescription();
                        if (failureType instanceof SoftwareInducedFailureType) {
                            SoftwareInducedFailureType softwareFailureType = ((SoftwareInducedFailureType) failureType);
                            resultList.add(MarkovSoftwareInducedFailureType.createExternalFailureType(evaluationType,
                                    softwareFailureType, annotation.getSignature_SpecifiedQoSAnnation(), annotation
                                            .getRole_SpecifiedQoSAnnotation(), ((OperationRequiredRole) annotation
                                            .getRole_SpecifiedQoSAnnotation())
                                            .getRequiredInterface__OperationRequiredRole()));
                        }
                    }
                }
            }
        }

        // Return the result:
        return resultList;
    }

    /**
     * Retrieves an RDSEFF for a given component and signature.
     * 
     * @param component
     *            the component
     * @param signature
     *            the signature
     * @return the RDSEFF
     */
    private ServiceEffectSpecification getRDSEFF(final BasicComponent component, final OperationSignature signature) {
        for (ServiceEffectSpecification rdseff : component.getServiceEffectSpecifications__BasicComponent()) {
            if (rdseff.getDescribedService__SEFF().getId().equals(signature.getId())) {
                return rdseff;
            }
        }
        return null;
    }

    /**
     * Removes doubles from the list of failure types.
     * 
     * Double failure types can occur if the distinction of failure types is not at the most
     * fine-granular level.
     * 
     * @param failureTypes
     *            the list of failure types
     * @return the result list
     */
    private List<MarkovFailureType> removeDoubleFailureTypes(final List<MarkovFailureType> failureTypes) {
        ArrayList<MarkovFailureType> resultList = new ArrayList<MarkovFailureType>();
        Iterator<MarkovFailureType> iterator = failureTypes.iterator();
        while (iterator.hasNext()) {
            MarkovFailureType failureType = iterator.next();
            if (!resultList.contains(failureType)) {
                resultList.add(failureType);
            }
        }
        return resultList;
    }
}
