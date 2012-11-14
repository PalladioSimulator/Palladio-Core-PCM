package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.ParameterModifier;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

/**
 * This class defines an EditHelper to handle the creation of an SetVariableAction.
 * 
 * @author Christian Busch
 */
public class SetVariableActionEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#
     * getBeforeConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
     */
    /**
     * Gets the before configure command.
     *
     * @param request the request
     * @return the before configure command
     * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
     */
    @Override
    protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {

        if (this.hasReturn(request)) {
            return new OKCommand();
        } else {
            final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

            final MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING);
            messageBox.setText("Notice");
            messageBox.setMessage("In order to create a SetVariableAction there must be a "
                    + "return type specified for the signature of the interface.");
            messageBox.open();

            return new CanceledCommand();
        }
    }

    /**
     * Checks whether the SEFF corresponding to the request has a signature with at least one return
     * type specified.
     * 
     * @param request
     *            to be checked
     * @return true if return parameter(s) of signature specified
     */
    protected boolean hasReturn(final ConfigureRequest request) {

        boolean hasReturn = false;
        EObject node = request.getElementToConfigure();

        /* walk through the tree */
        while (!(node instanceof ResourceDemandingSEFF)) {
            node = node.eContainer();
            if (node == null) {
                return false;
            }
        }
        node = ((ResourceDemandingSEFF) node).getDescribedService__SEFF();
        if (node instanceof OperationSignature) {
            final OperationSignature signature = (OperationSignature) node;
            /* check signature */
            for (final Parameter p : signature.getParameters__OperationSignature()) {
                if (p.getModifier__Parameter() == ParameterModifier.OUT
                        || p.getModifier__Parameter() == ParameterModifier.INOUT) {
                    hasReturn = true;
                    break;
                }
            }
            if (signature.getReturnType__OperationSignature() != null) {
                hasReturn = true;
            }
        }
        return hasReturn;
    }
}
