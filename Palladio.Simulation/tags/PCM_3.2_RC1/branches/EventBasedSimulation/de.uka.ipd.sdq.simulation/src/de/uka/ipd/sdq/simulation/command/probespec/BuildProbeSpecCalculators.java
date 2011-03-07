package de.uka.ipd.sdq.simulation.command.probespec;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.CalculatorRegistry;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.command.usage.FindEntryLevelSystemCallsOfScenario;
import de.uka.ipd.sdq.simulation.command.usage.FindExternalCallActionsOfRDSEFF;
import de.uka.ipd.sdq.simulation.command.usage.FindRDSEFFForAssemblyContext;

public class BuildProbeSpecCalculators implements IPCMCommand<List<Calculator>> {

    @Override
    public List<Calculator> execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        List<Calculator> calculators = new ArrayList<Calculator>();
        CalculatorRegistry registry = ProbeSpecContext.instance().getCalculatorRegistry();

        // build a calculator for each UsageScenario
        UsageModel usageModel = pcm.getUsageModel();
        for (UsageScenario s : usageModel.getUsageScenario_UsageModel()) {
            Calculator calculator = ProbeSpecContext.instance().getCalculatorFactory().buildResponseTimeCalculator(
                    s.getEntityName(), ProbeSpecContext.instance().obtainProbeSetId(s.getId() + "_start"),
                    ProbeSpecContext.instance().obtainProbeSetId(s.getId() + "_end"));
            calculators.add(calculator);
            registry.registerCalculator(s.getId(), calculator); // TODO really needed?
        }

        // build a calculator for each EntryLevelSystemCall
        for (UsageScenario s : usageModel.getUsageScenario_UsageModel()) {
            List<EntryLevelSystemCall> calls = executor.execute(new FindEntryLevelSystemCallsOfScenario(s));
            for (EntryLevelSystemCall c : calls) {
                Calculator calculator = ProbeSpecContext.instance().getCalculatorFactory().buildResponseTimeCalculator(
                        getCallName(c), ProbeSpecContext.instance().obtainProbeSetId(c.getId() + "_start"),
                        ProbeSpecContext.instance().obtainProbeSetId(c.getId() + "_end"));
                calculators.add(calculator);
                registry.registerCalculator(c.getId(), calculator);
            }
        }

        // build a calculator for each ExternalCallAction contained in an assembly
        for (AllocationContext allocationCtx : pcm.getAllocationModel().getAllocationContexts_Allocation()) {
            AssemblyContext assemblyCtx = allocationCtx.getAssemblyContext_AllocationContext();
            ResourceDemandingSEFF seff = executor.execute(new FindRDSEFFForAssemblyContext(assemblyCtx));
            List<ExternalCallAction> calls = executor.execute(new FindExternalCallActionsOfRDSEFF(seff));
            for (ExternalCallAction c : calls) {
                Calculator calculator = ProbeSpecContext.instance().getCalculatorFactory().buildResponseTimeCalculator(
                        getExternalCallName(c, assemblyCtx),
                        ProbeSpecContext.instance().obtainProbeSetId(c.getId() + "," + assemblyCtx.getId() + "_start"),
                        ProbeSpecContext.instance().obtainProbeSetId(c.getId() + "," + assemblyCtx.getId() + "_end"));
                calculators.add(calculator);
                registry.registerCalculator(c.getId(), calculator);

                System.out.println();
            }
        }

        return calculators;
    }

    private String getCallName(EntryLevelSystemCall call) {
        StringBuilder builder = new StringBuilder();
        builder.append("Call_");
        builder.append(call.getOperationSignature__EntryLevelSystemCall().getEntityName());
        builder.append(getPositionInInterface(call.getOperationSignature__EntryLevelSystemCall()));
        builder.append(" <EntryLevelSystemCall id: ");
        builder.append(call.getId());
        return builder.toString();
    }

    private String getExternalCallName(ExternalCallAction call, AssemblyContext assemblyCtx) {
        StringBuilder builder = new StringBuilder();
        builder.append("Call ");
        builder.append(call.getCalledService_ExternalService().getInterface__OperationSignature().getEntityName());
        builder.append(".");
        builder.append(call.getCalledService_ExternalService().getEntityName());
        builder.append(" <Component: ");
        builder.append(assemblyCtx.getEncapsulatedComponent_AssemblyContext().getEntityName());
        builder.append(", AssemblyCtx: ");
        builder.append(assemblyCtx.getId());
        builder.append(", CallID: ");
        builder.append(call.getId());
        return builder.toString();
    }

    private int getPositionInInterface(OperationSignature signature) {
        OperationInterface interfaze = signature.getInterface__OperationSignature();
        return interfaze.getSignatures__OperationInterface().indexOf(signature);
    }

    @Override
    public boolean cachable() {
        return false;
    }

}
