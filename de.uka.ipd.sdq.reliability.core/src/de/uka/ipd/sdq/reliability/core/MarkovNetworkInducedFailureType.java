package de.uka.ipd.sdq.reliability.core;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;

/**
 * Represents a failure type for a failure-on-demand occurrence due to a communication link
 * transmission error.
 * 
 * @author brosch
 * 
 */
public class MarkovNetworkInducedFailureType extends MarkovFailureType {

    /**
     * A default id for new failure types.
     */
    private static String NETWORK_ID = "Network-induced failure";

    /**
     * A default name for new failure types.
     */
    private static String NETWORK_NAME = "Network-induced failure";

    /**
     * Creates an external network-induced failure type.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param commLinkResourceType
     *            the failure causing communication link resource type
     * @param signature
     *            the system-required signature that exhibits the failure type
     * @param role
     *            the system-required role that exhibits the failure type
     * @param iface
     *            the system-required interface that exhibits the failure type
     * @return the created failure type
     */
    public static MarkovNetworkInducedFailureType createExternalFailureType(final MarkovEvaluationType evaluationType,
            final CommunicationLinkResourceType commLinkResourceType, final Signature signature, final Role role,
            final Interface iface) {
        return new MarkovNetworkInducedFailureType(evaluationType, commLinkResourceType.getId(),
                commLinkResourceType.getEntityName(), signature.getId(), signature.getEntityName(), role.getId(),
                role.getEntityName(), iface.getId(), iface.getEntityName());
    }

    /**
     * Creates an external network-induced failure type.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param commLinkResourceTypeId
     *            the ID of the resource type, as specified through a CommunicationLinkResourceType
     *            in a PCM ResourceRepository model
     * @param signatureId
     *            the ID of a signature, as specified for a system-required role in a PCM Repository
     *            model
     * @param systemRequiredRoleId
     *            the ID of the system-required role, as specified in a PCM System model
     * @return the created failure type
     */
    public static MarkovNetworkInducedFailureType createExternalFailureType(final MarkovEvaluationType evaluationType,
            final String commLinkResourceTypeId, final String signatureId, final String systemRequiredRoleId) {
        return new MarkovNetworkInducedFailureType(evaluationType, commLinkResourceTypeId, "", signatureId, "",
                systemRequiredRoleId, "", "", "");
    }

    // /**
    // * Creates an external network-induced failure type.
    // *
    // * @param commLinkResourceTypeId
    // * the ID of the resource type, as specified through a
    // * CommunicationLinkResourceType in a PCM ResourceRepository
    // * model
    // * @param commLinkResourceTypeName
    // * the name of the resource type, as specified through a
    // * CommunicationLinkResourceType in a PCM ResourceRepository
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
    // public static MarkovNetworkInducedFailureType createExternalFailureType(
    // final String commLinkResourceTypeId,
    // final String commLinkResourceTypeName, final String signatureId,
    // final String signatureName, final String systemRequiredRoleId,
    // final String systemRequiredRoleName) {
    // return new MarkovNetworkInducedFailureType(commLinkResourceTypeId,
    // commLinkResourceTypeName, signatureId, signatureName,
    // systemRequiredRoleId, systemRequiredRoleName, "", "");
    // }

    /**
     * Creates an internal network-induced failure type.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param linkingResource
     *            the failure causing linking resource
     * @param commLinkResourceType
     *            the failure causing communication link resource type
     * @return the created failure type
     */
    public static MarkovNetworkInducedFailureType createInternalFailureType(final MarkovEvaluationType evaluationType,
            final LinkingResource linkingResource, final CommunicationLinkResourceType commLinkResourceType) {
        return new MarkovNetworkInducedFailureType(evaluationType, linkingResource.getId(),
                linkingResource.getEntityName(), commLinkResourceType.getId(), commLinkResourceType.getEntityName());
    }

    /**
     * Creates an internal network-induced failure type.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param linkingResourceId
     *            the ID of the surrounding linking resource, as specified for a LinkingResource in
     *            a PCM ResourceEnvironment model
     * @param commLinkResourceTypeId
     *            the ID of the resource type, as specified through a CommunicationLinkResourceType
     *            in a PCM ResourceRepository model
     * @return the created failure type
     */
    public static MarkovNetworkInducedFailureType createInternalFailureType(final MarkovEvaluationType evaluationType,
            final String linkingResourceId, final String commLinkResourceTypeId) {
        return new MarkovNetworkInducedFailureType(evaluationType, linkingResourceId, "", commLinkResourceTypeId, "");
    }

    // /**
    // * Creates an internal network-induced failure type.
    // *
    // * @param linkingResourceId
    // * the ID of the communication link, as specified through a
    // * LinkingResource in a PCM ResourceEnvironment model
    // * @param linkingResourceName
    // * the name of the communication link, as specified through a
    // * LinkingResource in a PCM ResourceEnvironment model
    // * @param commLinkResourceTypeId
    // * the ID of the resource type, as specified through a
    // * CommunicationLinkResourceType in a PCM ResourceRepository
    // * model
    // * @param commLinkResourceTypeName
    // * the name of the resource type, as specified through a
    // * CommunicationLinkResourceType in a PCM ResourceRepository
    // * @return the created failure type
    // */
    // public static MarkovNetworkInducedFailureType createInternalFailureType(
    // final String linkingResourceId, final String linkingResourceName,
    // final String commLinkResourceTypeId,
    // final String commLinkResourceTypeName) {
    // return new MarkovNetworkInducedFailureType(linkingResourceId,
    // linkingResourceName, commLinkResourceTypeId,
    // commLinkResourceTypeName);
    // }

    /**
     * The ID of the resource type, as specified through a CommunicationLinkResourceType in a PCM
     * ResourceRepository model.
     */
    private String commLinkResourceTypeId = "";

    /**
     * The name of the resource type, as specified through a CommunicationLinkResourceType in a PCM
     * ResourceRepository model.
     */
    private String commLinkResourceTypeName = "";

    /**
     * The ID of the communication link, as specified through a LinkingResource in a PCM
     * ResourceEnvironment model.
     */
    private String linkingResourceId = "";

    /**
     * The name of the communication link, as specified through a LinkingResource in a PCM
     * ResourceEnvironment model.
     */
    private String linkingResourceName = "";

    /**
     * The constructor.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param linkingResourceId
     *            the ID of the communication link, as specified through a LinkingResource in a PCM
     *            ResourceEnvironment model
     * @param linkingResourceName
     *            the name of the communication link, as specified through a LinkingResource in a
     *            PCM ResourceEnvironment model
     * @param commLinkResourceTypeId
     *            the ID of the resource type, as specified through a CommunicationLinkResourceType
     *            in a PCM ResourceRepository model
     * @param commLinkResourceTypeName
     *            the name of the resource type, as specified through a
     *            CommunicationLinkResourceType in a PCM ResourceRepository
     */
    private MarkovNetworkInducedFailureType(final MarkovEvaluationType evaluationType, final String linkingResourceId,
            final String linkingResourceName, final String commLinkResourceTypeId, final String commLinkResourceTypeName) {
        switch (evaluationType) {
        case POINTSOFFAILURE:
            this.id = linkingResourceId + "/" + commLinkResourceTypeId;
            this.name = linkingResourceName + "/" + commLinkResourceTypeName
                    + " (system-internal network-induced failure)";
            break;
        case TYPES:
            this.id = commLinkResourceTypeId;
            this.name = commLinkResourceTypeName + " (network-induced failure)";
            break;
        case CLASSES:
            this.id = NETWORK_ID;
            this.name = NETWORK_NAME;
            break;
        default:
            this.id = DEFAULT_ID;
            this.name = DEFAULT_NAME;
        }
        this.evaluationType = evaluationType;
        this.linkingResourceId = linkingResourceId;
        this.linkingResourceName = linkingResourceName;
        this.commLinkResourceTypeId = commLinkResourceTypeId;
        this.commLinkResourceTypeName = commLinkResourceTypeName;
        this.systemExternal = false;
    }

    /**
     * The constructor for communication failures outside the system, as annotated to
     * system-external calls.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param commLinkResourceTypeId
     *            the ID of the resource type, as specified through a CommunicationLinkResourceType
     *            in a PCM ResourceRepository model
     * @param commLinkResourceTypeName
     *            the name of the resource type, as specified through a
     *            CommunicationLinkResourceType in a PCM ResourceRepository
     * @param systemRequiredRoleId
     *            the ID of the system-required role, as specified in a PCM System model
     * @param systemRequiredRoleName
     *            the name of the system-required role, as specified in a PCM System model
     * @param signatureId
     *            the ID of a signature, as specified for a system-required role in a PCM Repository
     *            model
     * @param signatureName
     *            the name of a signature, as specified for a system-required role in a PCM
     *            Repository model
     * @param interfaceId
     *            the id of the associated system-required service interface as specified in the PCM
     *            Repository model
     * @param interfaceName
     *            the name of the associated system-required service interface as specified in the
     *            PCM Repository model
     */
    private MarkovNetworkInducedFailureType(final MarkovEvaluationType evaluationType,
            final String commLinkResourceTypeId, final String commLinkResourceTypeName, final String signatureId,
            final String signatureName, final String systemRequiredRoleId, final String systemRequiredRoleName,
            final String interfaceId, final String interfaceName) {
        switch (evaluationType) {
        case POINTSOFFAILURE:
            this.id = systemRequiredRoleId + "/" + signatureId + "/" + commLinkResourceTypeId;
            this.name = systemRequiredRoleName + "/" + signatureName + "/" + commLinkResourceTypeName
                    + " (system-external network-induced failure)";
            break;
        case TYPES:
            this.id = commLinkResourceTypeId;
            this.name = commLinkResourceTypeName + " (network-induced failure)";
            break;
        case CLASSES:
            this.id = NETWORK_ID;
            this.name = NETWORK_NAME;
            break;
        default:
            this.id = DEFAULT_ID;
            this.name = DEFAULT_NAME;
        }
        this.evaluationType = evaluationType;
        this.commLinkResourceTypeId = commLinkResourceTypeId;
        this.commLinkResourceTypeName = commLinkResourceTypeName;
        this.signatureId = signatureId;
        this.signatureName = signatureName;
        this.roleId = systemRequiredRoleId;
        this.roleName = systemRequiredRoleName;
        this.interfaceId = interfaceId;
        this.interfaceName = interfaceName;
        this.commLinkResourceTypeId = commLinkResourceTypeId;
        this.systemExternal = true;
    }

    /**
     * Retrieves the ID of the communication resource type.
     * 
     * @return the ID of the communication resource type
     */
    public String getCommLinkResourceTypeId() {
        return commLinkResourceTypeId;
    }

    /**
     * Retrieves the name of the communication resource type.
     * 
     * @return the name of the communication resource type
     */
    public String getCommLinkResourceTypeName() {
        return commLinkResourceTypeName;
    }

    /**
     * Retrieves the ID of the communication link.
     * 
     * @return the ID of the communication link
     */
    public String getLinkingResourceId() {
        return linkingResourceId;
    }

    /**
     * Retrieves the name of the communication link.
     * 
     * @return the name of the communication link
     */
    public String getLinkingResourceName() {
        return linkingResourceName;
    }
}
