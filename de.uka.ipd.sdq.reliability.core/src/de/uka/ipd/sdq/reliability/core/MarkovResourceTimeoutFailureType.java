package de.uka.ipd.sdq.reliability.core;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;

/**
 * Represents a failure type for a failure-on-demand occurrence due to a timeout while requesting a
 * passive resource.
 * 
 * @author brosch
 * 
 */
public class MarkovResourceTimeoutFailureType extends MarkovFailureType {

    /**
     * A default id for new failure types.
     */
    private static String RESOURCE_ID = "Passive resource timeout failure";

    /**
     * A default name for new failure types.
     */
    private static String RESOURCE_NAME = "Passive resource timeout failure";

    /**
     * Creates a new resource timeout failure type.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param assemblyContext
     *            the assemblyContext in which the passive resource is instantiated
     * @param component
     *            the component to which the passive resource belongs
     * @param passiveResource
     *            the passive resource
     * @return the new failure type
     */
    public static MarkovResourceTimeoutFailureType createResourceTimeoutFailureType(
            final MarkovEvaluationType evaluationType, final AssemblyContext assemblyContext,
            final BasicComponent component, final PassiveResource passiveResource) {
        return new MarkovResourceTimeoutFailureType(evaluationType, assemblyContext.getId(),
                assemblyContext.getEntityName(), component.getId(), component.getEntityName(), passiveResource.getId(),
                passiveResource.getEntityName());
    }

    /**
     * Creates a new resource timeout failure type.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param assemblyContextId
     *            the ID of the component instance containing the passive resource, as specified
     *            through an AssemblyContext in a PCM System model
     * @param passiveResourceId
     *            the resource ID, as specified through a PassiveResource in a PCM Repository model
     * @return the new failure type
     */
    public static MarkovResourceTimeoutFailureType createResourceTimeoutFailureType(
            final MarkovEvaluationType evaluationType, final String assemblyContextId, final String passiveResourceId) {
        return new MarkovResourceTimeoutFailureType(evaluationType, assemblyContextId, "", "", "", passiveResourceId,
                "");
    }

    // /**
    // * Creates a new resource timeout failure type.
    // *
    // * @param assemblyContextId
    // * the ID of the component instance containing the passive
    // * resource, as specified through an AssemblyContext in a PCM
    // * System model
    // * @param componentId
    // * the id of the associated software component as specified in
    // * the PCM Repository model
    // * @param passiveResourceId
    // * the resource ID, as specified through a PassiveResource in a
    // * PCM Repository model
    // * @return the new failure type
    // */
    // public static MarkovResourceTimeoutFailureType
    // createResourceTimeoutFailureType(
    // final String assemblyContextId, final String componentId,
    // final String passiveResourceId) {
    // return new MarkovResourceTimeoutFailureType(assemblyContextId, "",
    // componentId, "", passiveResourceId, "");
    // }

    // /**
    // * Creates a new resource timeout failure type.
    // *
    // * @param assemblyContextId
    // * the ID of the component instance containing the passive
    // * resource, as specified through an AssemblyContext in a PCM
    // * System model
    // * @param assemblyContextName
    // * the name of the component instance containing the passive
    // * resource, as specified through an AssemblyContext in a PCM
    // * System model
    // * @param componentId
    // * the id of the associated software component as specified in
    // * the PCM Repository model
    // * @param componentName
    // * the name of the associated software component as specified in
    // * the PCM Repository model
    // * @param passiveResourceId
    // * the resource ID, as specified through a PassiveResource in a
    // * PCM Repository model
    // * @param passiveResourceName
    // * the resource name, as specified through a PassiveResource in a
    // * PCM Repository model
    // * @return the new failure type
    // */
    // public static MarkovResourceTimeoutFailureType
    // createResourceTimeoutFailureType(
    // final String assemblyContextId, final String assemblyContextName,
    // final String componentId, final String componentName,
    // final String passiveResourceId, final String passiveResourceName) {
    // return new MarkovResourceTimeoutFailureType(assemblyContextId,
    // assemblyContextName, componentId, componentName,
    // passiveResourceId, passiveResourceName);
    // }

    /**
     * The ID of the component instance containing the passive resource, as specified through an
     * AssemblyContext in a PCM System model.
     */
    private String assemblyContextId = "";

    /**
     * The name of the component instance containing the passive resource, as specified through an
     * AssemblyContext in a PCM System model.
     */
    private String assemblyContextName = "";

    /**
     * The id of the component which exhibits the failure.
     */
    private String componentId = "";

    /**
     * The name of the component which exhibits the failure.
     */
    private String componentName = "";

    /**
     * The resource ID, as specified for a PassiveResource in a PCM Repository model.
     */
    private String passiveResourceId = "";

    /**
     * The resource name, as specified for a PassiveResource in a PCM Repository model.
     */
    private String passiveResourceName = "";

    /**
     * The constructor.
     * 
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param assemblyContextId
     *            the ID of the component instance containing the passive resource, as specified
     *            through an AssemblyContext in a PCM System model
     * @param assemblyContextName
     *            the name of the component instance containing the passive resource, as specified
     *            through an AssemblyContext in a PCM System model
     * @param componentId
     *            the id of the associated software component as specified in the PCM Repository
     *            model
     * @param componentName
     *            the name of the associated software component as specified in the PCM Repository
     *            model
     * @param passiveResourceId
     *            the resource ID, as specified through a PassiveResource in a PCM Repository model
     * @param passiveResourceName
     *            the resource name, as specified through a PassiveResource in a PCM Repository
     *            model
     */
    private MarkovResourceTimeoutFailureType(final MarkovEvaluationType evaluationType, final String assemblyContextId,
            final String assemblyContextName, final String componentId, final String componentName,
            final String passiveResourceId, final String passiveResourceName) {
        switch (evaluationType) {
        case POINTSOFFAILURE:
            this.id = assemblyContextId + "/" + passiveResourceId;
            this.name = assemblyContextName + "/" + passiveResourceName
                    + " (system-internal passive resource timeout failure)";
            break;
        case TYPES:
            this.id = passiveResourceId;
            this.name = passiveResourceName + " (passive resource timeout failure)";
            break;
        case CLASSES:
            this.id = RESOURCE_ID;
            this.name = RESOURCE_NAME;
            break;
        default:
            this.id = DEFAULT_ID;
            this.name = DEFAULT_NAME;
        }
        this.evaluationType = evaluationType;
        this.assemblyContextId = assemblyContextId;
        this.assemblyContextName = assemblyContextName;
        this.componentId = componentId;
        this.componentName = componentName;
        this.passiveResourceId = passiveResourceId;
        this.passiveResourceName = passiveResourceName;
        this.systemExternal = false;
    }

    /**
     * Retrieves the assembly context ID.
     * 
     * @return the assembly context ID
     */
    public String getAssemblyContextId() {
        return assemblyContextId;
    }

    /**
     * Retrieves the assembly context name.
     * 
     * @return the assembly context name
     */
    public String getAssemblyContextName() {
        return assemblyContextName;
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
     * Retrieves the passive resource ID.
     * 
     * @return the passive resource ID
     */
    public String getPassiveResourceId() {
        return passiveResourceId;
    }

    /**
     * Retrieves the passive resource name.
     * 
     * @return the passive resource name
     */
    public String getPassiveResourceName() {
        return passiveResourceName;
    }
}
