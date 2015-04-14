package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.palladiosimulator.pcm.pcmstoex.ui.adapter.StochasticExpressionEditDialog;

import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/**
 * The Class ParametricResourceDemandConfigureCommand allows the selection of a parametric resource
 * and specification of the amout used.
 * 
 * @author roman
 */
public class ParametricResourceDemandConfigureCommand extends ConfigureElementCommand {

    /** The request. */
    private ConfigureRequest request = null;

    /**
     * Instantiates a new parametric resource demand configure command.
     * 
     * @param request
     *            the request
     */
    public ParametricResourceDemandConfigureCommand(final ConfigureRequest request) {
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

        CommandResult commandResult = this.setRequiredResource_ParametricResourceDemand(monitor, info);
        if (!this.isOK(commandResult)) {
            return CommandResult.newErrorCommandResult("Set RequiredResource for the ParametricResourceDemand failed!");
        }
        commandResult = this.setSpecification_ParametricResourceDemand(monitor, info);
        if (!this.isOK(commandResult)) {
            return CommandResult.newErrorCommandResult("Set Action for the ParametricResourceDemand failed!");
        }
        return CommandResult.newOKCommandResult();
    }

    /**
     * Sets the required resource_ parametric resource demand.
     * 
     * @param monitor
     *            the monitor
     * @param info
     *            the info
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     */
    private CommandResult setRequiredResource_ParametricResourceDemand(final IProgressMonitor monitor,
            final IAdaptable info) throws ExecutionException {

        EObject resource = null;
        final ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(ResourceRepository.class);
        filterList.add(ProcessingResourceType.class);

        final ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        final PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences, this.request
                .getEditingDomain().getResourceSet());
        dialog.setProvidedService(ProcessingResourceType.class);
        dialog.open();
        if (dialog.getResult() == null) {
            return CommandResult.newCancelledCommandResult();
        }
        if (!(dialog.getResult() instanceof ProcessingResourceType)) {
            return CommandResult.newCancelledCommandResult();
        }
        resource = dialog.getResult();

        final ICommand cmd = new SetValueCommand(new SetRequest(this.request.getElementToConfigure(),
                SeffPerformancePackage.eINSTANCE
                        .getParametricResourceDemand_RequiredResource_ParametricResourceDemand(), resource));
        cmd.execute(monitor, info);

        return cmd.getCommandResult();
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

        final ICommand cmd = new SetValueCommand(
                new SetRequest(((ParametricResourceDemand) this.request.getElementToConfigure())
                        .getSpecification_ParametericResourceDemand(), StoexPackage.eINSTANCE
                        .getRandomVariable_Specification(), dialog.getResultText()));
        cmd.execute(monitor, info);

        return cmd.getCommandResult();
    }
}
