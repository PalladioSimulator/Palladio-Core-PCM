package edu.kit.ipd.sdq.eventsim.system.command.seff;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;

/**
 * This command returns all {@link ResourceDemandingSEFF}s provided by the component that is
 * encapsulated in a specified {@link AssemblyContext}.
 * 
 * @author Philipp Merkle
 * 
 */
public class FindSeffsForAssemblyContext implements IPCMCommand<List<ResourceDemandingSEFF>> {

    private AssemblyContext assemblyCtx;

    /**
     * Constructs a new command to find all SEFFs in the specified AssemblyContext.
     * 
     * @param assemblyCtx
     *            the AssemblyContext
     */
    public FindSeffsForAssemblyContext(AssemblyContext assemblyCtx) {
        this.assemblyCtx = assemblyCtx;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ResourceDemandingSEFF> execute(IPCMModel pcm, ICommandExecutor<IPCMModel> executor) {
        // find basic component
        // TODO: support composite components etc.
        BasicComponent basicComponent = findBasicComponent(assemblyCtx);

        // collect all SEFFs of the component
        List<ResourceDemandingSEFF> seffs = new ArrayList<ResourceDemandingSEFF>();
        for (ServiceEffectSpecification s : basicComponent.getServiceEffectSpecifications__BasicComponent()) {
            if (SeffPackage.eINSTANCE.getResourceDemandingSEFF().isInstance(s)) {
                seffs.add((ResourceDemandingSEFF) s);
            } else {
                throw new EventSimException("Currently, only resource demanding SEFFs are supported.");
            }
        }

        return seffs;
    }

    /**
     * Returns the component that is encapsulated in the given assembly context. If this component
     * is not a BasicComponent, an exception is thrown.
     * 
     * @param assemblyCtx
     *            the assembly context
     * @return the component, if the encapsulated component is a BasicComponent
     */
    private BasicComponent findBasicComponent(AssemblyContext assemblyCtx) {
        RepositoryComponent component = assemblyCtx.getEncapsulatedComponent__AssemblyContext();
        if (RepositoryPackage.eINSTANCE.getBasicComponent().isInstance(component)) {
            return (BasicComponent) component;
        } else {
            throw new EventSimException("Currently only BasicComponents are supported.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

}
