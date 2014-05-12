package edu.kit.ipd.sdq.eventsim.resources.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.Connector;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;
import edu.kit.ipd.sdq.eventsim.resources.staticstructure.AllocationRegistry;
import edu.kit.ipd.sdq.eventsim.resources.staticstructure.SimulatedResourceContainer;
import edu.kit.ipd.sdq.eventsim.staticstructure.ComponentInstance;
import edu.kit.ipd.sdq.eventsim.staticstructure.RoleInstance;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;
import edu.kit.ipd.sdq.eventsim.util.ParameterHelper;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;

/**
 * This command creates a component instance for each {@link BasicComponent} encapsulated in an
 * {@link AssemblyContext}. The roles of the created components are connected in accordance with the
 * {@link System} model.
 * 
 * @author Philipp Merkle
 * 
 */
public class BuildComponentInstances implements IPCMCommand<Map<String, ComponentInstance>> {

    private static final Logger logger = Logger.getLogger(BuildComponentInstances.class);

    private final AbstractEventSimModel model;
    private final AllocationRegistry allocation;

    /**
     * Constructs a new command that creates component instances. The components' AllocationContexts
     * are contained in passed allocation registry.
     * 
     * @param model
     *            the simulation model
     * @param allocation
     *            the allocation registry
     */
    public BuildComponentInstances(AbstractEventSimModel model, AllocationRegistry allocation) {
        this.model = model;
        this.allocation = allocation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, ComponentInstance> execute(IPCMModel pcm, ICommandExecutor<IPCMModel> executor) {
        // create component instances and provided services
        Map<String, ComponentInstance> componentsMap = new HashMap<String, ComponentInstance>();

        for (AssemblyContext assemblyCtx : pcm.getSystemModel().getAssemblyContexts__ComposedStructure()) {
            RepositoryComponent c = assemblyCtx.getEncapsulatedComponent__AssemblyContext();
            if (RepositoryPackage.eINSTANCE.getBasicComponent().isInstance(c)) {
                BasicComponent basicComponent = (BasicComponent) c;

                // obtain resource container where the component instance is deployed on
                SimulatedResourceContainer resourceContainer = allocation.getResourceContainer(assemblyCtx);
                if (resourceContainer == null) {
                    throw new EventSimException("Encountered an undeployed assembly context: "
                            + PCMEntityHelper.toString(assemblyCtx) + ".");
                }

                SimulatedStackframe<Object> componentParameters = createComponentParameters(basicComponent, assemblyCtx);
                ComponentInstance componentInstance = new ComponentInstance(this.model, basicComponent, assemblyCtx, resourceContainer, componentParameters);
                componentsMap.put(assemblyCtx.getId(), componentInstance);
            } else {
            	if(logger.isEnabledFor(Level.WARN))
            		logger.warn("Encountered unsupported component type: " + c.getClass() + ". Ignoring component "
                        + PCMEntityHelper.toString(c) + ".");
            }
        }

        // link provided and required services
        for (Connector c : pcm.getSystemModel().getConnectors__ComposedStructure()) {
            if (AssemblyConnector.class.isInstance(c)) {
                AssemblyConnector ac = (AssemblyConnector) c;

                // find providing component instance
                ComponentInstance provComp = componentsMap.get(ac.getProvidingAssemblyContext_AssemblyConnector()
                        .getId());
                if (provComp == null) {
                	if(logger.isEnabledFor(Level.WARN))	
                		logger.warn("Could not find the providing component instance for " + PCMEntityHelper.toString(ac));
                }

                // find requiring component instance
                ComponentInstance reqComp = componentsMap.get(ac.getRequiringAssemblyContext_AssemblyConnector()
                        .getId());
                if (reqComp == null) {
                	if(logger.isEnabledFor(Level.WARN))
                		logger.warn("Could not find the providing component instance for " + PCMEntityHelper.toString(ac));
                }

                if (provComp != null && reqComp != null) {
                    RoleInstance reqRole = reqComp.getRequiredRole(ac.getRequiredRole_AssemblyConnector());
                    RoleInstance provRole = provComp.getProvidedRole(ac.getProvidedRole_AssemblyConnector());
                    RoleInstance.linkRoles(reqRole, provRole);
                } else {
                	if(logger.isEnabledFor(Level.WARN))
                		logger.warn("Ignoring " + PCMEntityHelper.toString(ac));
                }
            } else if (ProvidedDelegationConnector.class.isInstance(c)) {
                // do nothing
            } else if (RequiredDelegationConnector.class.isInstance(c)) {
                // do nothing
            } else {
            	if(logger.isEnabledFor(Level.WARN))
            		logger.warn("Unknown connector type: " + c.getClass() + ". Ignoring connector "
                        + PCMEntityHelper.toString(c) + ".");
            }
        }

        return componentsMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

    /**
     * Creates a stack frame containing the parameters of the specified component type.
     * 
     * @param componentType
     *            the component type containing the component's default parameters
     * @param assemblyCtx
     *            the AssemblyContext that may overwrite the component's default parameters
     * @return the stack frame containing the parameters as specified by the component type and the
     *         AssemblyContext
     */
    private SimulatedStackframe<Object> createComponentParameters(BasicComponent componentType,
            AssemblyContext assemblyCtx) {
        final SimulatedStackframe<Object> componentParameters = new SimulatedStackframe<Object>();

        // create stack frame with default component parameters...
        SimulatedStackframe<Object> defaultComponentFrame = new SimulatedStackframe<Object>();
        List<VariableUsage> defaultComponentParameters = componentType
                .getComponentParameterUsage_ImplementationComponentType();
        ParameterHelper.createEvaluationProxiesAndCopyToFrame(defaultComponentParameters, defaultComponentFrame);
        // ...and copy them to the component's stack frame
        componentParameters.addVariables(defaultComponentFrame);

        // create stack frame with component parameters overwritten by the AssemblyContext...
        SimulatedStackframe<Object> overwritingComponentFrame = new SimulatedStackframe<Object>();
        List<VariableUsage> overwritingComponentParameter = assemblyCtx.getConfigParameterUsages__AssemblyContext();
        ParameterHelper.createEvaluationProxiesAndCopyToFrame(overwritingComponentParameter, overwritingComponentFrame);

        // ...and copy them to the component's stack frame. Existing variables are overwritten.
        componentParameters.addVariables(defaultComponentFrame);

        return componentParameters;
    }

}
