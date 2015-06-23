package de.uka.ipd.sdq.pcm.gmf.resource.helper;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;
import org.palladiosimulator.pcm.dialogs.stoex.StochasticExpressionEditDialog;

import org.palladiosimulator.pcm.core.CoreFactory;
import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.LinkingResource;
import org.palladiosimulator.pcm.resourcetype.CommunicationLinkResourceType;
import org.palladiosimulator.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/**
 * A Command.
 */
public class SetLatencyThroughputAndLanTypeCommand extends ConfigureElementCommand {

    /**
     * The latency display title.
     */
    private static final String LATENCY_DISPLAY_TITLE = "Set Latency";

    /**
     * The throughput display title.
     */
    private static final String THROUGHPUT_DISPLAY_TITLE = "Set Throughput";

    /**
     * The configure request.
     */
    private ConfigureRequest request = null;

    /**
     * id of LAN in PCM resource repository.
     */
    private static final String LAN_COMMUNICATION_LINK_RESOURCE_TYPE = "_o3sScH2AEdyH8uerKnHYug";

    /**
     * 
     * @param request
     *            a request
     */
    public SetLatencyThroughputAndLanTypeCommand(ConfigureRequest request) {
        super(request);
        this.request = request;
    }

    /**
     * Method opens latency and throughput StoEx-dialogs and sets attributes of Communication Link
     * Resource Specification accordingly.
     * 
     * @param info
     *            an IAdaptable
     * @param monitor
     *            an IProgressMonitor
     * @throws ExecutionException
     *             an execution exception
     * @return a CommandResult
     */
    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        // get Linking Resource and Communication Link Resource Specification
        LinkingResource linkingResource = (LinkingResource) request.getElementToConfigure();
        // this containment was set before by
        // AddCommunicationLinkResourceSpecificationEditHelperAdvice.getBeforeConfigureCommand()
        CommunicationLinkResourceSpecification communicationLinkResourceSpecification = linkingResource
                .getCommunicationLinkResourceSpecifications_LinkingResource();

        PCMRandomVariable latency = getRandomVariableFromStoExDialog(LATENCY_DISPLAY_TITLE);
        if (latency == null) {
            return CommandResult.newCancelledCommandResult();
        }
        communicationLinkResourceSpecification.setLatency_CommunicationLinkResourceSpecification(latency);

        PCMRandomVariable throughput = getRandomVariableFromStoExDialog(THROUGHPUT_DISPLAY_TITLE);
        if (throughput == null) {
            return CommandResult.newCancelledCommandResult();
        }
        communicationLinkResourceSpecification.setThroughput_CommunicationLinkResourceSpecification(throughput);

        CommunicationLinkResourceType lanType = getLanType();
        communicationLinkResourceSpecification
                .setCommunicationLinkResourceType_CommunicationLinkResourceSpecification(lanType);

        return CommandResult.newOKCommandResult();
    }

    /**
     * @return LAN type from resource repository
     */
    private CommunicationLinkResourceType getLanType() {
        EObject requestElement = (EObject) request.getElementsToEdit().get(0);
        EditingDomain editingDomain = TransactionUtil.getEditingDomain(requestElement);
        EList<Resource> resources = editingDomain.getResourceSet().getResources();
        Collection<EObject> c = new ArrayList<EObject>();
        for (Resource r : resources) {
            c.addAll(r.getContents());
        }
        SELECT statement = new SELECT(new FROM(c), new WHERE(new EObjectAttributeValueCondition(
                ResourcetypePackage.eINSTANCE.getCommunicationLinkResourceType().getEIDAttribute(),
                new org.eclipse.emf.query.conditions.strings.StringValue(LAN_COMMUNICATION_LINK_RESOURCE_TYPE))));
        IQueryResult queryResult = statement.execute();
        CommunicationLinkResourceType lanType = (CommunicationLinkResourceType) queryResult.iterator().next();
        return lanType;
    }

    /**
     * Opens a StoxEx dialog and returns the resulting {@link PCMRandomVariable}.
     * 
     * @param displayTitle
     *            Title of the StoEx dialog
     * @return PCMRandomVariable if user entered valid data and confirmed. Will return null if user
     *         canceled dialog
     */
    private PCMRandomVariable getRandomVariableFromStoExDialog(String displayTitle) {
        PCMRandomVariable randomVariable = CoreFactory.eINSTANCE.createPCMRandomVariable();
        randomVariable.setSpecification("");

        StochasticExpressionEditDialog dialog = new StochasticExpressionEditDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), TypeEnum.DOUBLE, randomVariable);
        dialog.setDisplayTitle(displayTitle);
        dialog.open();

        if (dialog.getReturnCode() == Dialog.CANCEL) {
            return null;
        }

        randomVariable.setSpecification(dialog.getResultText());
        return randomVariable;
    }

}
