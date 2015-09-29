//package edu.kit.ipd.sdq.eventsim.system.probespec.commands;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.palladiosimulator.pcm.allocation.AllocationContext;
//import org.palladiosimulator.pcm.core.composition.AssemblyContext;
//import org.palladiosimulator.pcm.repository.OperationInterface;
//import org.palladiosimulator.pcm.repository.OperationSignature;
//import org.palladiosimulator.pcm.seff.ExternalCallAction;
//import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
//import org.palladiosimulator.probeframework.calculator.Calculator;
//
//import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
//import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
//import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
//import edu.kit.ipd.sdq.eventsim.system.command.seff.FindExternalCallActionsInSeff;
//import edu.kit.ipd.sdq.eventsim.system.command.seff.FindSeffsForAssemblyContext;
//import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
//
///**
// * This command creates and returns a list of {@link ResponseTimeCalculator}s. The following
// * calculators are created:
// * <ul>
// * <li>one for each {@link ExternalCallAction} contained in a {@link AssemblyContext}
// * </ul>
// * 
// * @author Philipp Merkle
// * @author Christoph Föhrdes
// * 
// */
//public class BuildResponseTimeCalculators implements IPCMCommand<List<Calculator>> {
//
//    private AbstractEventSimModel model;
//
//    public BuildResponseTimeCalculators(AbstractEventSimModel model) {
//        this.model = model;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public List<Calculator> execute(IPCMModel pcm, ICommandExecutor<IPCMModel> executor) {
//        List<Calculator> calculators = new ArrayList<Calculator>();
//        ProbeSpecContext probeSpecContext = model.getSimulationMiddleware().getProbeSpecContext();
//        CalculatorRegistry registry = probeSpecContext.getCalculatorRegistry();
//
//        // build a calculator for each ExternalCallAction
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
//            // build and register a calculator for each call
//            for (ExternalCallAction c : calls) {
//                Calculator calculator = probeSpecContext.getCalculatorFactory().buildResponseTimeCalculator(
//                        buildExternalCallName(c, assemblyCtx),
//                        probeSpecContext.obtainProbeSetId(c.getId() + "," + assemblyCtx.getId() + "_start"),
//                        probeSpecContext.obtainProbeSetId(c.getId() + "," + assemblyCtx.getId() + "_end"));
//                calculators.add(calculator);
//                registry.registerCalculator(c.getId(), calculator);
//            }
//        }
//
//        return calculators;
//    }
//
//    /**
//     * Creates and returns a string describing the specified {@link ExternalCallAction}.
//     * 
//     * @param call
//     *            the external call
//     * @param assemblyCtx
//     *            the assembly context from which the call is issued
//     * @return a description of the specified call
//     */
//    private String buildExternalCallName(ExternalCallAction call, AssemblyContext assemblyCtx) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Call ");
//        builder.append(call.getCalledService_ExternalService().getInterface__OperationSignature().getEntityName());
//        builder.append(".");
//        builder.append(call.getCalledService_ExternalService().getEntityName());
//        builder.append(getPositionInInterface(call.getCalledService_ExternalService()));
//        builder.append(" <Component: ");
//        builder.append(assemblyCtx.getEncapsulatedComponent__AssemblyContext().getEntityName());
//        builder.append(", AssemblyCtx: ");
//        builder.append(assemblyCtx.getId());
//        builder.append(", CallID: ");
//        builder.append(call.getId());
//        builder.append(">");
//        return builder.toString();
//    }
//
//    /**
//     * Returns the position of the specified signature in its interface.
//     * 
//     * @param signature
//     *            the signature
//     * @return the position of the signature, starting at 0 for the first position.
//     */
//    private int getPositionInInterface(OperationSignature signature) {
//        OperationInterface interfaze = signature.getInterface__OperationSignature();
//        return interfaze.getSignatures__OperationInterface().indexOf(signature);
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
