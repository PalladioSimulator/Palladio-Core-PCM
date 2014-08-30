package de.uka.ipd.sdq.pcm.gmf.resource.helper;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.ui.PlatformUI;
import org.palladiosimulator.pcm.pcmstoex.ui.adapter.StochasticExpressionEditDialog;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/**
 * A command.
 */
public class AddLatencyAndThroughputRecordingCommand extends RecordingCommand {

    /**
     * A resource specification.
     */
    private CommunicationLinkResourceSpecification communicationLinkResourceSpecification;

    /**
     * 
     * @param domain
     *            a TransactionalEditingDomain
     * @param communicationLinkResourceSpecification
     *            a communicationLinkResourceSpecification
     */
    public AddLatencyAndThroughputRecordingCommand(TransactionalEditingDomain domain,
            CommunicationLinkResourceSpecification communicationLinkResourceSpecification) {
        super(domain);
        this.communicationLinkResourceSpecification = communicationLinkResourceSpecification;
    }

    /**
     * 
     * @param domain
     *            a TransactionalEditingDomain
     */
    private AddLatencyAndThroughputRecordingCommand(TransactionalEditingDomain domain) {
        super(domain);
    }

    @Override
    protected void doExecute() {
        // Throughput
        PCMRandomVariable rv = CoreFactory.eINSTANCE.createPCMRandomVariable();
        rv.setSpecification("");

        StochasticExpressionEditDialog dialog = new StochasticExpressionEditDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), TypeEnum.ANY, rv);
        dialog.open();

        rv.setSpecification(dialog.getResultText());

        ICommand cmd = new MySetValueCommand(new SetRequest(communicationLinkResourceSpecification,
                ResourceenvironmentPackage.eINSTANCE
                        .getCommunicationLinkResourceSpecification_Throughput_CommunicationLinkResourceSpecification(),
                rv));
        cmd.setLabel("Throughput");

        // Latency
        rv = CoreFactory.eINSTANCE.createPCMRandomVariable();
        rv.setSpecification("");

        dialog = new StochasticExpressionEditDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                TypeEnum.ANY, rv);
        dialog.open();

        rv.setSpecification(dialog.getResultText());

        cmd = new SetValueCommand(
                new SetRequest(communicationLinkResourceSpecification, ResourceenvironmentPackage.eINSTANCE
                        .getCommunicationLinkResourceSpecification_Latency_CommunicationLinkResourceSpecification(), rv));

    }

}
