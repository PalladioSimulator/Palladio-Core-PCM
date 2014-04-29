package edu.kit.ipd.sdq.eventsim.system.staticstructure.commands;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;
import edu.kit.ipd.sdq.eventsim.system.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.system.resources.ResourceFactory;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.AllocationRegistry;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.PassiveResourceRegistry;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;

/**
 * This command creates all passive resources contained in a PCM model and registers them with the
 * {@link PassiveResourceRegistry}.
 * 
 * @author Philipp Merkle
 * 
 */
public class BuildAndRegisterPassiveResources implements IPCMCommand<Void> {

    private final AbstractEventSimModel model;
    private final AllocationRegistry allocation;
	private PassiveResourceRegistry passiveResourceRegistry;

    /**
     * Constructs a command that builds up a registry containing all passive resources of a PCM
     * model.
     * 
     * @param model
     *            the simulation model
     * @param allocation
     *            the allocation registry
     * @param passiveResourceRegistry 
     */
    public BuildAndRegisterPassiveResources(AbstractEventSimModel model, AllocationRegistry allocation, PassiveResourceRegistry passiveResourceRegistry) {
        this.model = model;
        this.allocation = allocation;
        this.passiveResourceRegistry = passiveResourceRegistry;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Void execute(IPCMModel pcm, ICommandExecutor<IPCMModel> executor) {
        for (AllocationContext ctx : pcm.getAllocationModel().getAllocationContexts_Allocation()) {
            RepositoryComponent component = ctx.getAssemblyContext_AllocationContext()
                    .getEncapsulatedComponent__AssemblyContext();
            BasicComponent basicComponent = null;
            if (RepositoryPackage.eINSTANCE.getBasicComponent().isInstance(component)) {
                basicComponent = (BasicComponent) component;
            } else {
                throw new EventSimException("Currently, only BasicComponents are supported, but found a "
                        + component.eClass().getName());
            }

            // for each passive resource specification
            for (PassiveResource specification : basicComponent.getPassiveResource_BasicComponent()) {
                // create passive resource
                SimPassiveResource simResource = ResourceFactory.createPassiveResource(model, specification,
                        ctx.getAssemblyContext_AllocationContext());

                // register the created passive resource
                this.passiveResourceRegistry.registerPassiveResource(specification, simResource, ctx.getAssemblyContext_AllocationContext());
            }
        }

        // this command is not supposed to return a value
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

}
