package de.uka.ipd.sdq.pcm.gmf.usage.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.usagemodel.Delay;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * The Class CreateDelaySpecificationEditHelperAdvice.
 * 
 * @author christophrathfelder
 */

public class CreateDelaySpecificationEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {
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
    protected ICommand getAfterConfigureCommand(ConfigureRequest request) {

        PCMRandomVariable randomVariable = CoreFactory.eINSTANCE.createPCMRandomVariable();

        randomVariable.setSpecification("0.0");

        SetRequest setRequest = new SetRequest((Delay) request.getElementToConfigure(),
                UsagemodelPackage.eINSTANCE.getDelay_TimeSpecification_Delay(), randomVariable);

        return new SetValueCommand(setRequest);
    }
}
