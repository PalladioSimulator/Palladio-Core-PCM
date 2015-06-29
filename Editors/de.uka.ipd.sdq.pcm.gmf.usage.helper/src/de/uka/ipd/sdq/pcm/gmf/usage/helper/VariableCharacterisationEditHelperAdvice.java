/**
 *
 */
package de.uka.ipd.sdq.pcm.gmf.usage.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.palladiosimulator.pcm.parameter.ParameterPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

/**
 * The Class VariableCharacterisationEditHelperAdvice.
 *
 * @author Roman Andrej
 */
public class VariableCharacterisationEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

    /*
     * (non-Javadoc)
     *
     * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#
     * getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
     */
    /**
     * Gets the after configure command.
     *
     * @param request
     *            the request
     * @return the after configure command
     * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
     */
    @Override
    protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {

        final ConfigureElementCommand confElementReq = new ConfigureElementCommand(request) {

            @Override
            protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info)
                    throws ExecutionException {

                final IElementType elementType = ElementTypeRegistry.getInstance().getType(
                        "de.uka.ipd.sdq.pcm.gmf.seff.PCMRandomVariable_9000");
                final CreateElementRequest createRequest = new CreateElementRequest(request.getElementToConfigure(),
                        elementType);
                final CreateElementCommand createCommand = new CreateElementCommand(createRequest);
                createCommand.execute(monitor, info);

                final SetRequest setSpecReq = new SetRequest(createCommand.getNewElement(),
                        StoexPackage.eINSTANCE.getRandomVariable_Specification(), "1");
                final SetValueCommand setRndVarCmd = new SetValueCommand(setSpecReq);
                setRndVarCmd.execute(monitor, info);

                final SetRequest setRequest = new SetRequest(request.getElementToConfigure(),
                        ParameterPackage.eINSTANCE.getVariableCharacterisation_Specification_VariableCharacterisation(), createCommand.getNewElement());
                final SetValueCommand cmd = new SetValueCommand(setRequest);
                cmd.execute(monitor, info);

                return CommandResult.newOKCommandResult();
            }

        };
        return confElementReq;

    }

}
