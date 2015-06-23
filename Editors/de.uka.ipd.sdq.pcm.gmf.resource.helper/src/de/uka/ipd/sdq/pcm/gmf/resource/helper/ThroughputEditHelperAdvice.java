package de.uka.ipd.sdq.pcm.gmf.resource.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;
import org.palladiosimulator.pcm.dialogs.stoex.StochasticExpressionEditDialog;

import org.palladiosimulator.pcm.core.CoreFactory;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/**
 * An edit helper advice.
 */
public class ThroughputEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

    // @Override
    // protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
    // PCMRandomVariable rv = CoreFactory.eINSTANCE.createPCMRandomVariable();
    // rv.setSpecification("");
    //
    // StochasticExpressionEditDialog dialog = new StochasticExpressionEditDialog(
    // PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
    // TypeEnum.ANY, rv);
    // dialog.open();
    //
    // if (dialog.getReturnCode() == Dialog.CANCEL)
    // return new CanceledCommand();
    //
    // rv.setSpecification(dialog.getResultText());
    //
    // ICommand cmd = new SetValueCommand(new SetRequest(request
    // .getElementToConfigure(),
    // ResourceenvironmentPackage.eINSTANCE.getCommunicationLinkResourceSpecification_Throughput_CommunicationLinkResourceSpecification(),
    // rv));
    //
    // return cmd;
    // }

    /**
     * 
     * @param communicationLinkResourceSpecification
     *            a specification
     * @return an ICommand
     */
    protected ICommand getCommand(CommunicationLinkResourceSpecification communicationLinkResourceSpecification) {
        PCMRandomVariable rv = CoreFactory.eINSTANCE.createPCMRandomVariable();
        rv.setSpecification("");

        StochasticExpressionEditDialog dialog = new StochasticExpressionEditDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), TypeEnum.ANY, rv);
        dialog.open();

        if (dialog.getReturnCode() == Dialog.CANCEL) {
            return new CanceledCommand();
        }

        rv.setSpecification(dialog.getResultText());

        ICommand cmd = new MySetValueCommand(new SetRequest(communicationLinkResourceSpecification,
                ResourceenvironmentPackage.eINSTANCE
                        .getCommunicationLinkResourceSpecification_Throughput_CommunicationLinkResourceSpecification(),
                rv));
        cmd.setLabel("Throughput");
        return cmd;
    }
}
