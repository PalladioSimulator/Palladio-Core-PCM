package edu.kit.ipd.sdq.eventsim.staticstructure.commands;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;
import edu.kit.ipd.sdq.eventsim.resources.ResourceFactory;
import edu.kit.ipd.sdq.eventsim.staticstructure.AllocationRegistry;
import edu.kit.ipd.sdq.eventsim.staticstructure.PassiveResourceRegistry;

/**
 * This command creates all passive resources contained in a PCM model and registers them with the
 * {@link PassiveResourceRegistry}.
 * 
 * @author Philipp Merkle
 * 
 */
public class BuildAndRegisterPassiveResources implements IPCMCommand<Void> {

    private final EventSimModel model;
    private final AllocationRegistry allocation;

    /**
     * Constructs a command that builds up a registry containing all passive resources of a PCM
     * model.
     * 
     * @param model
     *            the simulation model
     * @param allocation
     *            the allocation registry
     */
    public BuildAndRegisterPassiveResources(EventSimModel model, AllocationRegistry allocation) {
        this.model = model;
        this.allocation = allocation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Void execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
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
                model.getPassiveResourceRegistry().registerPassiveResource(specification, simResource,
                        ctx.getAssemblyContext_AllocationContext());
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
