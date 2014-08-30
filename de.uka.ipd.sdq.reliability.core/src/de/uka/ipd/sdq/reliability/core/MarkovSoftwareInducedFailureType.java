package de.uka.ipd.sdq.reliability.core;

import de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.InternalAction;

/**
 * Represents a failure type for a software-induced failure-on-demand occurrence.
 * 
 * This failure type specification corresponds to the specification of SoftwareInducedFailureTypes
 * in a PCM Repository model.
 * 
 * @author brosch
 * 
 */
public class MarkovSoftwareInducedFailureType extends MarkovFailureType {

    /**
     * A default id for new failure types.
     */
    private static String SOFTWARE_ID = "Software-induced failure";

    /**
     * A default name for new failure types.
     */
    private static String SOFTWARE_NAME = "Software-induced failure";

    /**
     * Creates an external software-induced failure type.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param failureType
     *            the failure type
     * @param signature
     *            the system-required signature that exhibits the failure type
     * @param role
     *            the system-required role that exhibits the failure type
     * @param iface
     *            the system-required interface that exhibits the failure type
     * @return the created failure type
     */
    public static MarkovSoftwareInducedFailureType createExternalFailureType(final MarkovEvaluationType evaluationType,
            final SoftwareInducedFailureType failureType, final Signature signature, final Role role,
            final Interface iface) {
        return new MarkovSoftwareInducedFailureType(evaluationType, failureType.getId(), failureType.getEntityName(),
                signature.getId(), signature.getEntityName(), role.getId(), role.getEntityName(), iface.getId(),
                iface.getEntityName());
    }

    /**
     * Creates an external software-induced failure type.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param softwareFailureId
     *            the ID of this software failure type
     * @param signatureId
     *            the ID of a signature, as specified for a system-required role in a PCM Repository
     *            model
     * @param systemRequiredRoleId
     *            the ID of the system-required role, as specified in a PCM System model
     * @return the created failure type
     */
    public static MarkovSoftwareInducedFailureType createExternalFailureType(final MarkovEvaluationType evaluationType,
            final String softwareFailureId, final String signatureId, final String systemRequiredRoleId) {
        return new MarkovSoftwareInducedFailureType(evaluationType, softwareFailureId, "", signatureId, "",
                systemRequiredRoleId, "", "", "");
    }

    /**
     * Creates an internal software-induced failure type.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param failureType
     *            the failure type
     * @param internalAction
     *            the internal action that exhibits the failure type
     * @param signature
     *            the component-provided signature that exhibits the failure type
     * @param role
     *            the component-provided role that exhibits the failure type
     * @param iface
     *            the component-provided interface that exhibits the failure type
     * @param component
     *            the component that exhibits the failure type
     * @return the created failure type
     */
    public static MarkovSoftwareInducedFailureType createInternalFailureType(final MarkovEvaluationType evaluationType,
            final SoftwareInducedFailureType failureType, final InternalAction internalAction,
            final Signature signature, final Role role, final Interface iface, final BasicComponent component) {
        return new MarkovSoftwareInducedFailureType(evaluationType, failureType.getId(), failureType.getEntityName(),
                internalAction.getId(), internalAction.getEntityName(), signature.getId(), signature.getEntityName(),
                role.getId(), role.getEntityName(), iface.getId(), iface.getEntityName(), component.getId(),
                component.getEntityName());
    }

    /**
     * Creates an internal software-induced failure type.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param softwareFailureId
     *            the ID of this software failure type
     * @param internalActionId
     *            the ID of the associated internal action as specified in the PCM Repository model
     * @return the created failure type
     */
    public static MarkovSoftwareInducedFailureType createInternalFailureType(final MarkovEvaluationType evaluationType,
            final String softwareFailureId, final String internalActionId) {
        return new MarkovSoftwareInducedFailureType(evaluationType, softwareFailureId, "", internalActionId, "", "",
                "", "", "", "", "", "", "");
    }

    // /**
    // * Creates an internal software-induced failure type.
    // *
    // * @param softwareFailureId
    // * the ID of this software failure type
    // * @param softwareFailureName
    // * the name of this software failure type as determined in the
    // * PCM Repository model
    // * @param internalActionId
    // * the ID of the associated internal action as specified in the
    // * PCM Repository model
    // * @param internalActionName
    // * the name of the associated internal action as specified in the
    // * PCM Repository model
    // * @return the created failure type
    // */
    // public static MarkovSoftwareInducedFailureType createInternalFailureType(
    // final String softwareFailureId, final String softwareFailureName,
    // final String internalActionId, final String internalActionName) {
    // return new MarkovSoftwareInducedFailureType(softwareFailureId,
    // softwareFailureName, internalActionId, internalActionName, "",
    // "", "", "", "", "", "", "");
    // }

    /**
     * The id of the component which exhibits the failure.
     */
    private String componentId = "";

    /**
     * The name of the component which exhibits the failure.
     */
    private String componentName = "";

    /**
     * The id of the internal action which exhibits the failure.
     */
    private String internalActionId = "";

    /**
     * The name of the internal action which exhibits the failure.
     */
    private String internalActionName = "";

    /**
     * The ID of this software failure type.
     */
    private String softwareFailureId = "";

    /**
     * The name of this software failure type.
     */
    private String softwareFailureName = "";

    /**
     * The constructor for software-induced failures outside the system, as annotated to
     * system-external calls.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param softwareFailureId
     *            the ID of this software failure type
     * @param softwareFailureName
     *            the name of this software failure type as determined in the PCM Repository model
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
    private MarkovSoftwareInducedFailureType(final MarkovEvaluationType evaluationType, final String softwareFailureId,
            final String softwareFailureName, final String signatureId, final String signatureName,
            final String systemRequiredRoleId, final String systemRequiredRoleName, final String interfaceId,
            final String interfaceName) {
        switch (evaluationType) {
        case POINTSOFFAILURE:
            this.id = systemRequiredRoleId + "/" + signatureId + "/" + softwareFailureId;
            this.name = systemRequiredRoleName + "/" + signatureName + "/" + softwareFailureName
                    + " (system-external software-induced failure)";
            break;
        case TYPES:
            this.id = softwareFailureId;
            this.name = softwareFailureName + " (software-induced failure)";
            break;
        case CLASSES:
            this.id = SOFTWARE_ID;
            this.name = SOFTWARE_NAME;
            break;
        default:
            this.id = DEFAULT_ID;
            this.name = DEFAULT_NAME;
        }
        this.evaluationType = evaluationType;
        this.softwareFailureId = softwareFailureId;
        this.softwareFailureName = softwareFailureName;
        this.signatureId = signatureId;
        this.signatureName = signatureName;
        this.roleId = systemRequiredRoleId;
        this.roleName = systemRequiredRoleName;
        this.interfaceId = interfaceId;
        this.interfaceName = interfaceName;
        this.systemExternal = true;
    }

    /**
     * The constructor.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param softwareFailureId
     *            the ID of this software failure type
     * @param softwareFailureName
     *            the name of this software failure type as determined in the PCM Repository model
     * @param internalActionId
     *            the ID of the associated internal action as specified in the PCM Repository model
     * @param internalActionName
     *            the name of the associated internal action as specified in the PCM Repository
     *            model
     * @param signatureId
     *            the id of the associated service signature as specified in the PCM Repository
     *            model
     * @param signatureName
     *            the name of the associated service signature as specified in the PCM Repository
     *            model
     * @param providedRoleId
     *            the id of the associated component-provided role as specified in the PCM
     *            Repository model
     * @param providedRoleName
     *            the name of the associated component-provided role as specified in the PCM
     *            Repository model
     * @param interfaceId
     *            the id of the associated component-provided service interface as specified in the
     *            PCM Repository model
     * @param interfaceName
     *            the name of the associated component-provided service interface as specified in
     *            the PCM Repository model
     * @param componentId
     *            the id of the associated software component as specified in the PCM Repository
     *            model
     * @param componentName
     *            the name of the associated software component as specified in the PCM Repository
     *            model
     */
    private MarkovSoftwareInducedFailureType(final MarkovEvaluationType evaluationType, final String softwareFailureId,
            final String softwareFailureName, final String internalActionId, final String internalActionName,
            final String signatureId, final String signatureName, final String providedRoleId,
            final String providedRoleName, final String interfaceId, final String interfaceName,
            final String componentId, final String componentName) {
        switch (evaluationType) {
        case POINTSOFFAILURE:
            this.id = internalActionId + "/" + softwareFailureId;
            // this.name = internalActionName + "/" + softwareFailureName
            // + " (system-internal software-induced failure)";
            this.name = componentName + "/" + interfaceName + "/" + signatureName + "/" + internalActionName + "/"
                    + softwareFailureName + " (system-internal software-induced failure)";
            break;
        case TYPES:
            this.id = softwareFailureId;
            this.name = softwareFailureName + " (software-induced failure)";
            break;
        case CLASSES:
            this.id = SOFTWARE_ID;
            this.name = SOFTWARE_NAME;
            break;
        default:
            this.id = DEFAULT_ID;
            this.name = DEFAULT_NAME;
        }
        this.evaluationType = evaluationType;
        this.softwareFailureId = softwareFailureId;
        this.softwareFailureName = softwareFailureName;
        this.internalActionId = internalActionId;
        this.internalActionName = internalActionName;
        this.signatureId = signatureId;
        this.signatureName = signatureName;
        this.roleId = providedRoleId;
        this.roleName = providedRoleName;
        this.interfaceId = interfaceId;
        this.interfaceName = interfaceName;
        this.componentId = componentId;
        this.componentName = componentName;
        this.systemExternal = false;
    }

    /**
     * Retrieves the id of the component which exhibits the failure.
     * 
     * @return the component id
     */
    public String getComponentId() {
        return componentId;
    }

    /**
     * Retrieves the name of the component which exhibits the failure.
     * 
     * @return the component name
     */
    public String getComponentName() {
        return componentName;
    }

    /**
     * Retrieves the id of the internal action which exhibits the failure.
     * 
     * @return the internal action id
     */
    public String getInternalActionId() {
        return internalActionId;
    }

    /**
     * Retrieves the name of the internal action which exhibits the failure.
     * 
     * @return the internal action name
     */
    public String getInternalActionName() {
        return internalActionName;
    }

    /**
     * Retrieves the id of this software failure type.
     * 
     * @return the software failure type id
     */
    public String getSoftwareFailureId() {
        return softwareFailureId;
    }

    /**
     * Retrieves the name of this software failure type.
     * 
     * @return the software failure type name
     */
    public String getSoftwareFailureName() {
        return softwareFailureName;
    }
}
