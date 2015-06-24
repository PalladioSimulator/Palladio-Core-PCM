package de.uka.ipd.sdq.pcm.gmf.repository.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.ui.PlatformUI;
import org.palladiosimulator.editors.dialogs.variablenames.SetOutputVariableNameDialog;
import org.palladiosimulator.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;

/**
 * A component parameter EditHelperAdvice.
 */
public class ComponentParameterEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

    @Override
    protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
        SetOutputVariableNameDialog dialog = new SetOutputVariableNameDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell());
        dialog.open();

        String enteredName = dialog.getResult();
        if (enteredName == null) {
            return new CanceledCommand();
        }

        AbstractNamedReference namedReference = dialog.getOutputVariableReference();

        ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                ParameterPackage.eINSTANCE.getVariableUsage_NamedReference__VariableUsage(), namedReference));
        return cmd;
    }

}
