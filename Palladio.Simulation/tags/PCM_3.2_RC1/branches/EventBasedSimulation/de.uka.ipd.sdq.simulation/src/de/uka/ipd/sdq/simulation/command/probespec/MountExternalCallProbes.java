package de.uka.ipd.sdq.simulation.command.probespec;

import java.util.List;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.command.usage.FindExternalCallActionsOfRDSEFF;
import de.uka.ipd.sdq.simulation.command.usage.FindRDSEFFForAssemblyContext;
import de.uka.ipd.sdq.simulation.entities.Request;
import de.uka.ipd.sdq.simulation.traversal.listener.ISeffTraversalListener;
import de.uka.ipd.sdq.simulation.traversal.rdseff.SeffTraversal;

public class MountExternalCallProbes implements IPCMCommand<Void> {

    @Override
    public Void execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        for (AllocationContext allocationCtx : pcm.getAllocationModel().getAllocationContexts_Allocation()) {
            final AssemblyContext assemblyCtx = allocationCtx.getAssemblyContext_AllocationContext();
            ResourceDemandingSEFF seff = executor.execute(new FindRDSEFFForAssemblyContext(assemblyCtx));
            List<ExternalCallAction> calls = executor.execute(new FindExternalCallActionsOfRDSEFF(seff));
            for (final ExternalCallAction c : calls) {
//                AssemblyContext ctx = executor.execute(new FindAssemblyContextOfProvidingRole(assemblyCtx, c.getRole_ExternalService()));
//                ResourceDemandingSEFF s = executor.execute(new FindRDSEFFForAssemblyContext(ctx));
//                StartAction startAction = executor.execute(new FindActionInSEFF<StartAction>(s, StartAction.class));
//                StopAction stopAction = executor.execute(new FindActionInSEFF<StopAction>(s, StopAction.class));
                
                SeffTraversal.addTraversalListener(c, new ISeffTraversalListener() {

                    @Override
                    public void before(AbstractAction action, Request r) {
                        // Take current time
//                        AssemblyContext assemblyCtx = r.getTraversalContext().getStack().currentScope().getComponent().getAssemblyCtx();
                        ProbeSpecContext.instance().getSampleBlackboard().addSample(
                                ProbeSpecUtils.buildProbeSetSample(ProbeSpecContext.instance()
                                        .getProbeStrategyRegistry().getProbeStrategy(ProbeType.CURRENT_TIME, null)
                                        .takeSample(c.getId(), r.getModel().getSimulationControl()), r
                                        .getRequestContext(), c.getId(), ProbeSpecContext.instance().obtainProbeSetId(
                                        c.getId() + "," + assemblyCtx.getId() + "_start")));
                    }

                    @Override
                    public void after(AbstractAction action, Request r) {
//                        AssemblyContext assemblyCtx = r.getTraversalContext().getStack().currentScope().getComponent().getAssemblyCtx();
                        ProbeSpecContext.instance().getSampleBlackboard().addSample(
                                ProbeSpecUtils.buildProbeSetSample(ProbeSpecContext.instance()
                                        .getProbeStrategyRegistry().getProbeStrategy(ProbeType.CURRENT_TIME, null)
                                        .takeSample(c.getId(), r.getModel().getSimulationControl()), r
                                        .getRequestContext(), c.getId(), ProbeSpecContext.instance().obtainProbeSetId(
                                        c.getId() + "," + assemblyCtx.getId() + "_end")));
                    }
                });
            }
        }

        return null;
    }

    @Override
    public boolean cachable() {
        return false;
    }

}
