//package edu.kit.ipd.sdq.eventsim.system.probespec.commands;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.palladiosimulator.pcm.allocation.AllocationContext;
//import org.palladiosimulator.pcm.core.composition.AssemblyContext;
//import org.palladiosimulator.pcm.seff.AbstractAction;
//import org.palladiosimulator.pcm.seff.ExternalCallAction;
//import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
//
//import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
//import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
//import edu.kit.ipd.sdq.eventsim.interpreter.listener.ITraversalListener;
//import edu.kit.ipd.sdq.eventsim.system.command.seff.FindExternalCallActionsInSeff;
//import edu.kit.ipd.sdq.eventsim.system.command.seff.FindSeffsForAssemblyContext;
//import edu.kit.ipd.sdq.eventsim.system.entities.Request;
//import edu.kit.ipd.sdq.eventsim.system.interpreter.listener.ISeffTraversalListener;
//import edu.kit.ipd.sdq.eventsim.system.interpreter.seff.SeffInterpreterConfiguration;
//import edu.kit.ipd.sdq.eventsim.system.interpreter.state.RequestState;
//import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
//import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
//
///**
// * This command registers a {@link ITraversalListener} before and after each
// * {@link ExternalCallAction}. The listeners take a {@link ProbeType#CURRENT_TIME} sample before and
// * after a call in order to enable the calculation of the call's response time.
// * 
// * @author Philipp Merkle
// * @author Christoph Föhrdes
// * 
// */
//public class MountExternalCallProbes implements IPCMCommand<Void> {
//
//    private final SeffInterpreterConfiguration interpreterConfig;
//	private ISimulationMiddleware middleware;
//    
//    public MountExternalCallProbes(SeffInterpreterConfiguration interpreterConfig, ISimulationMiddleware middleware) {
//        this.interpreterConfig = interpreterConfig;
//        this.middleware = middleware;
//    }
//    
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Void execute(IPCMModel pcm, ICommandExecutor<IPCMModel> executor) {
//        for (AllocationContext allocationCtx : pcm.getAllocationModel().getAllocationContexts_Allocation()) {
//            AssemblyContext assemblyCtx = allocationCtx.getAssemblyContext_AllocationContext();
//
//            // find all SEFFs in the assembly context
//            List<ResourceDemandingSEFF> seffs = executor.execute(new FindSeffsForAssemblyContext(assemblyCtx));
//
//            // find all calls in the SEFFs
//            List<ExternalCallAction> calls = new ArrayList<ExternalCallAction>();
//            for (ResourceDemandingSEFF s : seffs) {
//                calls.addAll(executor.execute(new FindExternalCallActionsInSeff(s)));
//            }
//
//            // mount a traversal listener before and after each call. The listener takes a current
//            // time sample before and after a call in order to enable the calculation of the call's
//            // response time.
//            for (final ExternalCallAction c : calls) {
//                this.interpreterConfig.addTraversalListener(c, new ISeffTraversalListener() {
//
//                    @Override
//                    public void before(AbstractAction action, Request r, RequestState state) {
//                        // take current time sample
//                        ProbeSpecContext probeSpecContext = middleware.getProbeSpecContext();
//                        AssemblyContext assemblyCtx = state.getComponent().getAssemblyCtx();
//                        probeSpecContext.getSampleBlackboard().addSample(
//                                ProbeSpecUtils.buildProbeSetSample(probeSpecContext.getProbeStrategyRegistry()
//                                        .getProbeStrategy(ProbeType.CURRENT_TIME, null).takeSample(c.getId(),
//                                                r.getModel().getSimulationControl()), r.getRequestContext(), c.getId(),
//                                        probeSpecContext.obtainProbeSetId(c.getId() + "," + assemblyCtx.getId()
//                                                + "_start")));
//                    }
//
//                    @Override
//                    public void after(AbstractAction action, Request r, RequestState state) {
//                        // take current time sample
//                        ProbeSpecContext probeSpecContext = middleware.getProbeSpecContext();
//                        AssemblyContext assemblyCtx = state.getComponent().getAssemblyCtx();
//                        probeSpecContext.getSampleBlackboard().addSample(
//                                ProbeSpecUtils.buildProbeSetSample(probeSpecContext.getProbeStrategyRegistry()
//                                        .getProbeStrategy(ProbeType.CURRENT_TIME, null).takeSample(c.getId(),
//                                                r.getModel().getSimulationControl()), r.getRequestContext(), c.getId(),
//                                        probeSpecContext.obtainProbeSetId(c.getId() + "," + assemblyCtx.getId()
//                                                + "_end")));
//                    }
//                });
//            }
//        }
//
//        // this command is not supposed to return a value
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public boolean cachable() {
//        return false;
//    }
//
//}
