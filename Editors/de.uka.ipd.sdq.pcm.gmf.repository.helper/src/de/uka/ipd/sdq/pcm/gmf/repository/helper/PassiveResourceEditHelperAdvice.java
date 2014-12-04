package de.uka.ipd.sdq.pcm.gmf.repository.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * A passive resource EditHelperAdvice.
 */
public class PassiveResourceEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

    @Override
    protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
        PCMRandomVariable rv = CoreFactory.eINSTANCE.createPCMRandomVariable();
        rv.setSpecification("1");

        /*
         * StochasticExpressionEditDialog dialog = new StochasticExpressionEditDialog(
         * PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), TypeEnum.INT, rv);
         * dialog.open();
         * 
         * if (dialog.getReturnCode() == Dialog.CANCEL) return new CanceledCommand();
         * 
         * rv.setSpecification(dialog.getResultText());
         */

        ICommand cmd = new SetValueCommand(new SetRequest((PassiveResource) request.getElementToConfigure(),
                RepositoryPackage.eINSTANCE.getPassiveResource_Capacity_PassiveResource(), rv));

        return cmd;
    }

}
