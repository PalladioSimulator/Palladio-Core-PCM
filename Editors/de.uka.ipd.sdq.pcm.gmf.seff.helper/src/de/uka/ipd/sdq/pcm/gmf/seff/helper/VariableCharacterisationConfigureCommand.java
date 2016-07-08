package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.palladiosimulator.editors.commons.dialogs.stoex.StochasticExpressionEditDialog;
import org.palladiosimulator.pcm.core.CoreFactory;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.parameter.ParameterPackage;
import org.palladiosimulator.pcm.parameter.VariableCharacterisation;

import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/**
 * The Class ParametricResourceDemandConfigureCommand allows the selection of a parametric resource
 * and specification of the amout used.
 *
 * @author roman
 */
public class VariableCharacterisationConfigureCommand extends ConfigureElementCommand {

    /** The request. */
    private ConfigureRequest request = null;

    /**
     * Instantiates a new parametric resource demand configure command.
     *
     * @param request
     *            the request
     */
    public VariableCharacterisationConfigureCommand(final ConfigureRequest request) {
        super(request);
        this.request = request;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#
     * doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
     * org.eclipse.core.runtime.IAdaptable)
     */
    /**
     * Do execute with result.
     *
     * @param monitor
     *            the monitor
     * @param info
     *            the info
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
     *      org.eclipse.core.runtime.IAdaptable)
     */
    @Override
    protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info)
            throws ExecutionException {
        final CommandResult commandResult = this.setSpecification_ParametricResourceDemand(monitor, info);
        if (!this.isOK(commandResult)) {
            return CommandResult.newErrorCommandResult("Set Action for the Usage Characterisation failed!");
        }
        return CommandResult.newOKCommandResult();
    }

    /**
     * Sets the specification_ parametric resource demand.
     *
     * @param monitor
     *            the monitor
     * @param info
     *            the info
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     */
    private CommandResult setSpecification_ParametricResourceDemand(final IProgressMonitor monitor,
            final IAdaptable info) throws ExecutionException {

        final StochasticExpressionEditDialog dialog = new StochasticExpressionEditDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), TypeEnum.DOUBLE, this.request.getElementToConfigure());
        dialog.open();

        if (dialog.getReturnCode() == Window.CANCEL) {
            return CommandResult.newCancelledCommandResult();
        }

        final PCMRandomVariable randomVariable = CoreFactory.eINSTANCE.createPCMRandomVariable();

        final SetRequest setRequest = new SetRequest(request.getElementToConfigure(),
                ParameterPackage.eINSTANCE.getVariableCharacterisation_Specification_VariableCharacterisation(), randomVariable);

        SetValueCommand cmd = new SetValueCommand(setRequest);
        cmd.execute(monitor, info);

        cmd = new SetValueCommand(
                new SetRequest(((VariableCharacterisation) this.request.getElementToConfigure()).getSpecification_VariableCharacterisation(),
                        StoexPackage.eINSTANCE.getRandomVariable_Specification(), dialog.getResultText()));
        cmd.execute(monitor, info);

        return cmd.getCommandResult();
    }
}
