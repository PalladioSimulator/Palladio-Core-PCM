package edu.kit.ipd.sdq.eventsim.system.command.seff;

import java.util.ArrayList;
import java.util.List;

import org.palladiosimulator.pcm.allocation.AllocationContext;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;

import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.middleware.simulation.PCMModel;

/**
 * TODO
 * 
 * @author Philipp Merkle
 * @author Christoph Föhrdes
 * 
 */
public class FindAllActionsByType<A extends AbstractAction> implements IPCMCommand<List<ActionContext<A>>> {
    
	private Class<A> actionType;	
	
	public FindAllActionsByType(Class<A> actionType) {
		this.actionType = actionType;
	}
	
    /**
     * {@inheritDoc}
     */
    @Override
    public List<ActionContext<A>> execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
    	List<ActionContext<A>> result = new ArrayList<>();
        for (AllocationContext allocationCtx : pcm.getAllocationModel().getAllocationContexts_Allocation()) {
            AssemblyContext assemblyCtx = allocationCtx.getAssemblyContext_AllocationContext();

            // find all SEFFs in the assembly context
            List<ResourceDemandingSEFF> seffs = executor.execute(new FindSeffsForAssemblyContext(assemblyCtx));

            // find all calls in the SEFFs
            List<A> calls = new ArrayList<>();
            for (ResourceDemandingSEFF s : seffs) {
                calls.addAll(executor.execute(new FindActionsInSeff<A>(s, actionType)));
            }
            
            calls.forEach(c -> result.add(new ActionContext<A>(allocationCtx, assemblyCtx, c)));
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }
    
    
    

}
