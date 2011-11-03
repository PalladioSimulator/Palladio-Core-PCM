package de.uka.ipd.sdq.simulation.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.Connector;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.staticstructure.AllocationRegistry;
import de.uka.ipd.sdq.simulation.staticstructure.ComponentInstance;
import de.uka.ipd.sdq.simulation.staticstructure.RoleInstance;
import de.uka.ipd.sdq.simulation.staticstructure.SimulatedResourceContainer;
import de.uka.ipd.sdq.simulation.util.ParameterHelper;

/**
 * This command creates a component instance for each {@link BasicComponent} encapsulated in an
 * {@link AssemblyContext}. The roles of the created components are connected in accordance with the
 * {@link System} model.
 * 
 * @author Philipp Merkle
 * 
 */
public class BuildComponentInstances implements IPCMCommand<Map<String, ComponentInstance>> {

    private final EventSimModel model;
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
    public BuildComponentInstances(EventSimModel model, AllocationRegistry allocation) {
        this.model = model;
        this.allocation = allocation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, ComponentInstance> execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        // create component instances and provided services
        Map<String, ComponentInstance> componentsMap = new HashMap<String, ComponentInstance>();
        for (AllocationContext a : pcm.getAllocationModel().getAllocationContexts_Allocation()) {
            AssemblyContext assemblyCtx = a.getAssemblyContext_AllocationContext();
            RepositoryComponent c = assemblyCtx.getEncapsulatedComponent__AssemblyContext();
            if (RepositoryPackage.eINSTANCE.getBasicComponent().isInstance(c)) {
                BasicComponent basicComponent = (BasicComponent) c;
                SimulatedResourceContainer resourceContainer = allocation.getResourceContainer(assemblyCtx);
                SimulatedStackframe<Object> componentParameters = createComponentParameters(basicComponent, assemblyCtx);
                ComponentInstance componentInstance = new ComponentInstance(this.model,
                        basicComponent, assemblyCtx, resourceContainer, componentParameters);
                componentsMap.put(assemblyCtx.getId(), componentInstance);
            }
        }

        // link provided and required services
        for (Connector c : pcm.getSystemModel().getConnectors__ComposedStructure()) {
            if (AssemblyConnector.class.isInstance(c)) {
                AssemblyConnector ac = (AssemblyConnector) c;
                ComponentInstance provComp = componentsMap.get(ac.getProvidingAssemblyContext_AssemblyConnector()
                        .getId());
                ComponentInstance reqComp = componentsMap.get(ac.getRequiringAssemblyContext_AssemblyConnector()
                        .getId());
                RoleInstance reqRole = reqComp.getRequiredRole(ac.getRequiredRole_AssemblyConnector());
                RoleInstance provRole = provComp.getProvidedRole(ac.getProvidedRole_AssemblyConnector());
                RoleInstance.linkRoles(reqRole, provRole);
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
