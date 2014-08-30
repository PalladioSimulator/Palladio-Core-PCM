package de.uka.ipd.sdq.reliability.core;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

/**
 * Represents a failure type for a failure-on-demand occurrence due to an unavailable hardware
 * resource.
 * 
 * @author brosch
 * 
 */
public class MarkovHardwareInducedFailureType extends MarkovFailureType {

    /**
     * A default id for new failure types.
     */
    private static String HARDWARE_ID = "Hardware-induced failure";

    /**
     * A default name for new failure types.
     */
    private static String HARDWARE_NAME = "Hardware-induced failure";

    /**
     * Creates an external hardware-induced failure type.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param resoureType
     *            the failure causing processing resource type
     * @param signature
     *            the system-required signature that exhibits the failure type
     * @param role
     *            the system-required role that exhibits the failure type
     * @param iface
     *            the system-required interface that exhibits the failure type
     * @return the created failure type
     */
    public static MarkovHardwareInducedFailureType createExternalFailureType(final MarkovEvaluationType evaluationType,
            final ProcessingResourceType resoureType, final Signature signature, final Role role, final Interface iface) {
        return new MarkovHardwareInducedFailureType(evaluationType, resoureType.getId(), resoureType.getEntityName(),
                signature.getId(), signature.getEntityName(), role.getId(), role.getEntityName(), iface.getId(),
                iface.getEntityName());
    }

    /**
     * Creates an external hardware-induced failure type.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param resourceTypeId
     *            the ID of the resource type, as specified for a ProcessingResourceType in a PCM
     *            ResourceRepository model
     * @param signatureId
     *            the ID of a signature, as specified for a system-required role in a PCM Repository
     *            model
     * @param systemRequiredRoleId
     *            the ID of the system-required role, as specified in a PCM System model
     * @return the created failure type
     */
    public static MarkovHardwareInducedFailureType createExternalFailureType(final MarkovEvaluationType evaluationType,
            final String resourceTypeId, final String signatureId, final String systemRequiredRoleId) {
        return new MarkovHardwareInducedFailureType(evaluationType, resourceTypeId, "", signatureId, "",
                systemRequiredRoleId, "", "", "");
    }

    //
    // /**
    // * Creates an external hardware-induced failure type.
    // *
    // * @param resourceTypeId
    // * the ID of the resource type, as specified for a
    // * ProcessingResourceType in a PCM ResourceRepository model
    // * @param resourceTypeName
    // * the name of the resource type, as specified for a
    // * ProcessingResourceType in a PCM ResourceRepository model
    // * @param signatureId
    // * the ID of a signature, as specified for a system-required role
    // * in a PCM Repository model
    // * @param signatureName
    // * the name of a signature, as specified for a system-required
    // * role in a PCM Repository model
    // * @param systemRequiredRoleId
    // * the ID of the system-required role, as specified in a PCM
    // * System model
    // * @param systemRequiredRoleName
    // * the name of the system-required role, as specified in a PCM
    // * System model
    // * @return the created failure type
    // */
    // public static MarkovHardwareInducedFailureType createExternalFailureType(
    // final String resourceTypeId, final String resourceTypeName,
    // final String signatureId, final String signatureName,
    // final String systemRequiredRoleId,
    // final String systemRequiredRoleName) {
    // return new MarkovHardwareInducedFailureType(resourceTypeId,
    // resourceTypeName, signatureId, signatureName,
    // systemRequiredRoleId, systemRequiredRoleName, "", "");
    // }

    /**
     * Creates an internal hardware-induced failure type.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param resourceContainer
     *            the failure causing resource container
     * @param resourceType
     *            the failure causing processing resource type
     * @return the created failure type
     */
    public static MarkovHardwareInducedFailureType createInternalFailureType(final MarkovEvaluationType evaluationType,
            final ResourceContainer resourceContainer, final ProcessingResourceType resourceType) {
        return new MarkovHardwareInducedFailureType(evaluationType, resourceContainer.getId(),
                resourceContainer.getEntityName(), resourceType.getId(), resourceType.getEntityName());
    }

    /**
     * Creates an internal hardware-induced failure type.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param resourceContainerId
     *            the ID of the surrounding resource container, as specified for a ResourceContainer
     *            in a PCM ResourceEnvironment model
     * @param resourceTypeId
     *            the ID of the resource type, as specified for a ProcessingResourceType in a PCM
     *            ResourceRepository model
     * @return the created failure type
     */
    public static MarkovHardwareInducedFailureType createInternalFailureType(final MarkovEvaluationType evaluationType,
            final String resourceContainerId, final String resourceTypeId) {
        return new MarkovHardwareInducedFailureType(evaluationType, resourceContainerId, "", resourceTypeId, "");
    }

    // /**
    // * Creates an internal hardware-induced failure type.
    // *
    // * @param resourceContainerId
    // * the ID of the surrounding resource container, as specified for
    // * a ResourceContainer in a PCM ResourceEnvironment model
    // * @param resourceContainerName
    // * the name of the surrounding resource container, as specified
    // * for a ResourceContainer in a PCM ResourceEnvironment model
    // * @param resourceTypeId
    // * the ID of the resource type, as specified for a
    // * ProcessingResourceType in a PCM ResourceRepository model
    // * @param resourceTypeName
    // * the name of the resource type, as specified for a
    // * ProcessingResourceType in a PCM ResourceRepository model
    // * @return the created failure type
    // */
    // public static MarkovHardwareInducedFailureType createInternalFailureType(
    // final String resourceContainerId,
    // final String resourceContainerName, final String resourceTypeId,
    // final String resourceTypeName) {
    // return new MarkovHardwareInducedFailureType(resourceContainerId,
    // resourceContainerName, resourceTypeId, resourceTypeName);
    // }

    /**
     * The ID of the surrounding resource container, as specified for a ResourceContainer in a PCM
     * ResourceEnvironment model.
     */
    private String resourceContainerId = "";

    /**
     * The name of the surrounding resource container, as specified for a ResourceContainer in a PCM
     * ResourceEnvironment model.
     */
    private String resourceContainerName = "";

    /**
     * The ID of the resource type, as specified for a ProcessingResourceType in a PCM
     * ResourceRepository.
     */
    private String resourceTypeId = "";

    /**
     * The name of the resource type, as specified for a ProcessingResourceType in a PCM
     * ResourceRepository.
     */
    private String resourceTypeName = "";

    /**
     * The constructor.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param resourceContainerId
     *            the ID of the surrounding resource container, as specified for a ResourceContainer
     *            in a PCM ResourceEnvironment model
     * @param resourceContainerName
     *            the name of the surrounding resource container, as specified for a
     *            ResourceContainer in a PCM ResourceEnvironment model
     * @param resourceTypeId
     *            the ID of the resource type, as specified for a ProcessingResourceType in a PCM
     *            ResourceRepository model
     * @param resourceTypeName
     *            the name of the resource type, as specified for a ProcessingResourceType in a PCM
     *            ResourceRepository model
     */
    private MarkovHardwareInducedFailureType(final MarkovEvaluationType evaluationType,
            final String resourceContainerId, final String resourceContainerName, final String resourceTypeId,
            final String resourceTypeName) {
        switch (evaluationType) {
        case POINTSOFFAILURE:
            this.id = resourceContainerId + "/" + resourceTypeId;
            this.name = resourceContainerName + "/" + resourceTypeName + " (system-internal hardware-induced failure)";
            break;
        case TYPES:
            this.id = resourceTypeId;
            this.name = resourceTypeName + " (hardware-induced failure)";
            break;
        case CLASSES:
            this.id = HARDWARE_ID;
            this.name = HARDWARE_NAME;
            break;
        default:
            this.id = DEFAULT_ID;
            this.name = DEFAULT_NAME;
        }
        this.evaluationType = evaluationType;
        this.resourceContainerId = resourceContainerId;
        this.resourceContainerName = resourceContainerName;
        this.resourceTypeId = resourceTypeId;
        this.resourceTypeName = resourceTypeName;
        this.resourceTypeId = resourceTypeId;
        this.systemExternal = false;
    }

    /**
     * The constructor for resource failures outside the system, as annotated to system-external
     * calls.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param resourceTypeId
     *            the ID of the resource type, as specified for a ProcessingResourceType in a PCM
     *            ResourceRepository model
     * @param resourceTypeName
     *            the name of the resource type, as specified for a ProcessingResourceType in a PCM
     *            ResourceRepository model
     * @param signatureId
     *            the ID of a signature, as specified for a system-required role in a PCM Repository
     *            model
     * @param signatureName
     *            the name of a signature, as specified for a system-required role in a PCM
     *            Repository model
     * @param systemRequiredRoleId
     *            the ID of the system-required role, as specified in a PCM System model
     * @param systemRequiredRoleName
     *            the name of the system-required role, as specified in a PCM System model
     * @param interfaceId
     *            the id of the associated system-required service interface as specified in the PCM
     *            Repository model
     * @param interfaceName
     *            the name of the associated system-required service interface as specified in the
     *            PCM Repository model
     */
    private MarkovHardwareInducedFailureType(final MarkovEvaluationType evaluationType, final String resourceTypeId,
            final String resourceTypeName, final String signatureId, final String signatureName,
            final String systemRequiredRoleId, final String systemRequiredRoleName, final String interfaceId,
            final String interfaceName) {
        switch (evaluationType) {
        case POINTSOFFAILURE:
            this.id = systemRequiredRoleId + "/" + signatureId + "/" + resourceTypeId;
            this.name = systemRequiredRoleName + "/" + signatureName + "/" + resourceTypeName
                    + " (system-external hardware-induced failure)";
            break;
        case TYPES:
            this.id = resourceTypeId;
            this.name = resourceTypeName + " (hardware-induced failure)";
            break;
        case CLASSES:
            this.id = HARDWARE_ID;
            this.name = HARDWARE_NAME;
            break;
        default:
            this.id = DEFAULT_ID;
            this.name = DEFAULT_NAME;
        }
        this.evaluationType = evaluationType;
        this.resourceTypeId = resourceTypeId;
        this.resourceTypeName = resourceTypeName;
        this.signatureId = signatureId;
        this.signatureName = signatureName;
        this.roleId = systemRequiredRoleId;
        this.roleName = systemRequiredRoleName;
        this.interfaceId = interfaceId;
        this.interfaceName = interfaceName;
        this.systemExternal = true;
    }

    /**
     * Retrieves the ID of the resource container.
     * 
     * @return the ID of the resource container
     */
    public String getResourceContainerId() {
        return resourceContainerId;
    }

    /**
     * Retrieves the name of the resource container.
     * 
     * @return the resource type container
     */
    public String getResourceContainerName() {
        return resourceContainerName;
    }

    /**
     * Retrieves the ID of the resource type.
     * 
     * @return the resource type ID
     */
    public String getResourceTypeId() {
        return resourceTypeId;
    }

    /**
     * Retrieves the name of the resource type.
     * 
     * @return the resource type name
     */
    public String getResourceTypeName() {
        return resourceTypeName;
    }
}
