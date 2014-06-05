package edu.kit.ipd.sdq.eventsim.probespec.commands;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.command.seff.FindExternalCallActionsInSeff;
import edu.kit.ipd.sdq.eventsim.command.seff.FindSeffsForAssemblyContext;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.ISeffTraversalListener;
import edu.kit.ipd.sdq.eventsim.interpreter.listener.ITraversalListener;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.SeffInterpreterConfiguration;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;

/**
 * This command registers a {@link ITraversalListener} before and after each
 * {@link ExternalCallAction}. The listeners take a {@link ProbeType#CURRENT_TIME} sample before and
 * after a call in order to enable the calculation of the call's response time.
 * 
 * @author Philipp Merkle
 * 
 */
public class MountExternalCallProbes implements IPCMCommand<Void> {

    private final SeffInterpreterConfiguration interpreterConfig;
    
    public MountExternalCallProbes(SeffInterpreterConfiguration interpreterConfig) {
        this.interpreterConfig = interpreterConfig;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Void execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        for (AllocationContext allocationCtx : pcm.getAllocationModel().getAllocationContexts_Allocation()) {
            AssemblyContext assemblyCtx = allocationCtx.getAssemblyContext_AllocationContext();

            // find all SEFFs in the assembly context
            List<ResourceDemandingSEFF> seffs = executor.execute(new FindSeffsForAssemblyContext(assemblyCtx));

            // find all calls in the SEFFs
            List<ExternalCallAction> calls = new ArrayList<ExternalCallAction>();
            for (ResourceDemandingSEFF s : seffs) {
                calls.addAll(executor.execute(new FindExternalCallActionsInSeff(s)));
            }

            // mount a traversal listener before and after each call. The listener takes a current
            // time sample before and after a call in order to enable the calculation of the call's
            // response time.
            for (final ExternalCallAction c : calls) {
                this.interpreterConfig.addTraversalListener(c, new ISeffTraversalListener() {

                    @Override
                    public void before(AbstractAction action, Request r, RequestState state) {
                        // take current time sample
                        ProbeSpecContext probeSpecContext = r.getModel().getProbeSpecContext();
                        AssemblyContext assemblyCtx = state.getComponent().getAssemblyCtx();
                        probeSpecContext.getSampleBlackboard().addSample(
                                ProbeSpecUtils.buildProbeSetSample(probeSpecContext.getProbeStrategyRegistry()
                                        .getProbeStrategy(ProbeType.CURRENT_TIME, null).takeSample(c.getId(),
                                                r.getModel().getSimulationControl()), r.getRequestContext(), c.getId(),
                                        probeSpecContext.obtainProbeSetId(c.getId() + "," + assemblyCtx.getId()
                                                + "_start")));
                    }

                    @Override
                    public void after(AbstractAction action, Request r, RequestState state) {
                        // take current time sample
                        ProbeSpecContext probeSpecContext = r.getModel().getProbeSpecContext();
                        AssemblyContext assemblyCtx = state.getComponent().getAssemblyCtx();
                        probeSpecContext.getSampleBlackboard().addSample(
                                ProbeSpecUtils.buildProbeSetSample(probeSpecContext.getProbeStrategyRegistry()
                                        .getProbeStrategy(ProbeType.CURRENT_TIME, null).takeSample(c.getId(),
                                                r.getModel().getSimulationControl()), r.getRequestContext(), c.getId(),
                                        probeSpecContext.obtainProbeSetId(c.getId() + "," + assemblyCtx.getId()
                                                + "_end")));
                    }
                });
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
