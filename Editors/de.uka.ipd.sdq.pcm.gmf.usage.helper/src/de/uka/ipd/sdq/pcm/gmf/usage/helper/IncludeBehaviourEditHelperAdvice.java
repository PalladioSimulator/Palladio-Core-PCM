/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.usage.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @author admin
 * 
 */
public class IncludeBehaviourEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#
     * getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
     */
    @Override
    protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
        IElementType elementType = ElementTypeRegistry.getInstance().getType(
                "de.uka.ipd.sdq.pcm.gmf.usage.ScenarioBehaviour_3007");

        CreateElementRequest createElementRequest = new CreateElementRequest(request.getElementToConfigure(),
                elementType);
        return new CreateElementCommand(createElementRequest);
    }

}
