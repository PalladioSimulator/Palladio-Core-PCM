//package edu.kit.ipd.sdq.eventsim.workload.probespec.commands;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//import org.palladiosimulator.pcm.repository.OperationInterface;
//import org.palladiosimulator.pcm.repository.OperationSignature;
//import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
//import org.palladiosimulator.pcm.usagemodel.UsageModel;
//import org.palladiosimulator.pcm.usagemodel.UsageScenario;
//import org.palladiosimulator.probeframework.calculator.Calculator;
//
//import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
//import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
//import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
//import edu.kit.ipd.sdq.eventsim.workload.command.usage.FindSystemCallsOfScenario;
//import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
//
///**
// * This command creates and returns a list of {@link ResponseTimeCalculator}s. The following
// * calculators are created:
// * <ul>
// * <li>one for each {@link UsageScenario}</li>
// * <li>one for each {@link EntryLevelSystemCall} contained in a {@link UsageScenario}</li>
// * </ul>
// * 
// * @author Philipp Merkle
// * @author Christoph Föhrdes
// * 
// */
//public class BuildUsageResponseTimeCalculators implements IPCMCommand<List<Calculator>> {
//
//    private AbstractEventSimModel model;
//
//    public BuildUsageResponseTimeCalculators(AbstractEventSimModel model) {
//        this.model = model;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public List<Calculator> execute(IPCMModel pcm, ICommandExecutor<IPCMModel> executor) {
//
//        List<Calculator> calculators = new ArrayList<Calculator>();
//        ProbeSpecContext probeSpecContext = model.getSimulationMiddleware().getProbeSpecContext();
//        CalculatorRegistry registry = probeSpecContext.getCalculatorRegistry();
//
//        // build a calculator for each UsageScenario
//        UsageModel usageModel = pcm.getUsageModel();
//        for (UsageScenario s : usageModel.getUsageScenario_UsageModel()) {
//            Calculator calculator = probeSpecContext.getCalculatorFactory().buildResponseTimeCalculator(
//                    s.getEntityName(), probeSpecContext.obtainProbeSetId(s.getId() + "_start"),
//                    probeSpecContext.obtainProbeSetId(s.getId() + "_end"));
//            calculators.add(calculator);
//            registry.registerCalculator(s.getId(), calculator);
//        }
//
//        // build a calculator for each EntryLevelSystemCall
//        for (UsageScenario s : usageModel.getUsageScenario_UsageModel()) {
//            Set<EntryLevelSystemCall> calls = executor.execute(new FindSystemCallsOfScenario(s));
//            for (EntryLevelSystemCall c : calls) {
//                Calculator calculator = probeSpecContext.getCalculatorFactory().buildResponseTimeCalculator(
//                        buildSystemCallName(c), probeSpecContext.obtainProbeSetId(c.getId() + "_start"),
//                        probeSpecContext.obtainProbeSetId(c.getId() + "_end"));
//                calculators.add(calculator);
//                registry.registerCalculator(c.getId(), calculator);
//            }
//        }
//
//        return calculators;
//    }
//
//    /**
//     * Creates and returns a string describing the specified {@link EntryLevelSystemCall}.
//     * 
//     * @param call
//     *            the system call
//     * @return a description of the specified call
//     */
//    private String buildSystemCallName(EntryLevelSystemCall call) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Call_");
//        builder.append(call.getOperationSignature__EntryLevelSystemCall().getEntityName());
//        builder.append(getPositionInInterface(call.getOperationSignature__EntryLevelSystemCall()));
//        builder.append(" <EntryLevelSystemCall id: ");
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
