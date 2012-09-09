package de.uka.ipd.sdq.pcm.gmf.resource.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.dialogs.stoex.StochasticExpressionEditDialog;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/**
 * An edit helper advice.
 */
public class LatencyEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

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
    // ResourceenvironmentPackage.eINSTANCE.getCommunicationLinkResourceSpecification_Latency_CommunicationLinkResourceSpecification(),
    // rv));
    //
    // return cmd;
    // }

    /**
     * 
     * @param communicationLinkResourceSpecification
     *            a link specification
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

        ICommand cmd = new SetValueCommand(
                new SetRequest(communicationLinkResourceSpecification, ResourceenvironmentPackage.eINSTANCE
                        .getCommunicationLinkResourceSpecification_Latency_CommunicationLinkResourceSpecification(), rv));

        return cmd;
    }
}
