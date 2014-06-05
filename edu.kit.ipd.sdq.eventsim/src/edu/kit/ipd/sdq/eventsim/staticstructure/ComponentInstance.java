package edu.kit.ipd.sdq.eventsim.staticstructure;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

/**
 * A component instance is an instance of a component type (e.g. a BasicComponent). Component types
 * are instantiated by putting them into their contexts:
 * <ul>
 * <li>the {@link AssemblyContext} defines how the component instance is wired with other component
 * instances</li>
 * <li>the {@link AllocationContext} specifies the deployment of the component, i.e. on which
 * resource container the component instance is to be executed</li>
 * <li>the UsageContext specifies the component usage, which includes the component's parameter
 * characterisations</li>
 * </ul>
 * When constructing a component instance, all three contexts have to be specified. For the {@code
 * UsageContext}, however, it suffices to specify the component parameter characterisation.
 * <p>
 * Once created, a component instance gives convenient access to its contexts:
 * <ul>
 * <li>AssemblyContext: {@code findProvidingComponent()}</li>
 * <li>AllocationContext: {@code getResourceContainer()}</li>
 * <li>UsageContext: {@code getComponentParameters()}</li>
 * </ul>
 * 
 * @author Philipp Merkle
 * 
 */
public class ComponentInstance {

    private final EventSimModel model;
    // TODO use ImplementationComponentType to be more general
    private final BasicComponent componentType;
    private List<RoleInstance> providedRoles;
    private List<RoleInstance> requiredRoles;
    private final AssemblyContext assemblyCtx;
    private final SimulatedStackframe<Object> componentParameters;
    private final SimulatedResourceContainer resourceContainer;

    /**
     * Constructs a new component instance by specifying the three contexts as described in the
     * class-level documentation.
     * 
     * @param model
     *            the simulation model
     * @param type
     *            the component type that is to be instantiated
     * @para assemblyCtx the AssemblyContext
     */
    public ComponentInstance(final EventSimModel model, final BasicComponent type, final AssemblyContext assemblyCtx,
            final SimulatedResourceContainer deployedOn, final SimulatedStackframe<Object> parameters) {
        assert (model != null) : "The argument model may not be null.";
        assert (type != null) : "The argument type may not be null.";
        assert (assemblyCtx != null) : "The argument assemblyCtx may not be null.";

        this.model = model;
        this.componentType = type;
        this.assemblyCtx = assemblyCtx;
        this.resourceContainer = deployedOn;
        this.componentParameters = parameters;

        // create provided and required roles
        this.createRoles(this.componentType);
    }

    /**
     * Creates provided roles and required roles in accordance with the specified component type.
     * 
     * @param type
     *            the component type
     */
    private void createRoles(final BasicComponent type) {
        // create provided roles
        this.providedRoles = new ArrayList<RoleInstance>();
        for (final ProvidedRole r : type.getProvidedRoles_InterfaceProvidingEntity()) {
            if (r instanceof OperationProvidedRole) {
                final OperationProvidedRole prov = (OperationProvidedRole) r;
                final OperationInterface providedInterface = prov.getProvidedInterface__OperationProvidedRole();
                this.providedRoles.add(new RoleInstance(providedInterface, r.getId(), this));
            }
        }

        // create required roles
        this.requiredRoles = new ArrayList<RoleInstance>();
        for (final RequiredRole r : type.getRequiredRoles_InterfaceRequiringEntity()) {
            if (r instanceof OperationRequiredRole) {
                final OperationRequiredRole req = (OperationRequiredRole) r;
                final OperationInterface requiredInterface = req.getRequiredInterface__OperationRequiredRole();
                this.requiredRoles.add(new RoleInstance(requiredInterface, r.getId(), this));
            }
        }
    }

    /**
     * @param role
     *            the role type
     * @return the role instance for the specified role type
     */
    public RoleInstance getProvidedRole(final OperationProvidedRole role) {
        for (final RoleInstance r : this.providedRoles) {
            if (r.getId().equals(role.getId())) {
                return r;
            }
        }
        return null;
    }

    /**
     * @param role
     *            the role type
     * @return the role instance for the specified role type
     */
    public RoleInstance getRequiredRole(final OperationRequiredRole role) {
        for (final RoleInstance r : this.requiredRoles) {
            if (r.getId().equals(role.getId())) {
                return r;
            }
        }
        return null;
    }

    /**
     * @param signature
     *            the call's signature
     * @return the component instance that provides a call with the specified signature to this
     *         component instance
     */
    public ComponentInstance getProvidingComponent(final OperationSignature signature) {
        for (final RoleInstance r : this.requiredRoles) {
            for (final OperationSignature s : r.getInterface().getSignatures__OperationInterface()) {
                if (PCMEntityHelper.equals(s, signature)) {
                    return r.getLinkedRole().getComponent();
                }
            }
        }
        throw new EventSimException("There is no component that provides a call with the specified signature to this "
                + "component: " + PCMEntityHelper.toString(signature));
    }

    /**
     * Returns the AssemblyContext that encapsulates this component instance.
     * 
     * @return the AssemblyContext of this component instance
     */
    public AssemblyContext getAssemblyCtx() {
        return this.assemblyCtx;
    }

    /**
     * @param signature
     *            the signature
     * @return the service effect specification of the specified signature
     */
    public ResourceDemandingSEFF getServiceEffectSpecification(final OperationSignature signature) {
        for (final ServiceEffectSpecification s : this.componentType.getServiceEffectSpecifications__BasicComponent()) {
            if (PCMEntityHelper.equals(s.getDescribedService__SEFF(), signature)) {
                return (ResourceDemandingSEFF) s;
            }
        }
        return null;
    }

    /**
     * @return the parameter characterisations for the parameters of this component instance
     */
    public SimulatedStackframe<Object> getComponentParameters() {
        return this.componentParameters;
    }

    /**
     * @return the resource container in which the component instance is deployed
     */
    public SimulatedResourceContainer getResourceContainer() {
        return this.resourceContainer;
    }

    /**
     * @param specification
     *            the passive resource specification
     * @return the resource instance for the given resource specification
     */
    public SimPassiveResource getPassiveResource(final PassiveResource specification) {
        final SimPassiveResource simResource = this.model.getPassiveResourceRegistry().getPassiveResourceForContext(
                specification, this.assemblyCtx);
        if (simResource == null) {
            throw new RuntimeException("Passive resource " + PCMEntityHelper.toString(specification)
                    + " for assembly context " + PCMEntityHelper.toString(this.assemblyCtx) + " could not be found.");
        }
        return simResource;
    }

}
