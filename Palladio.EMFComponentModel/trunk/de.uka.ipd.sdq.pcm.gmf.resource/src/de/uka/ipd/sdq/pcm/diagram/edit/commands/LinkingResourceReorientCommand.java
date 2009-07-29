package de.uka.ipd.sdq.pcm.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.uka.ipd.sdq.pcm.diagram.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;

/**
 * @generated
 */
public class LinkingResourceReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public LinkingResourceReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof LinkingResource) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof ResourceContainer && newEnd instanceof ResourceContainer)) {
			return false;
		}
		CommunicationLinkResourceSpecification target = getLink()
				.getCommunicationLinkResourceSpecifications_LinkingResource();
		if (!(getLink().eContainer() instanceof ResourceEnvironment)) {
			return false;
		}
		ResourceEnvironment container = (ResourceEnvironment) getLink()
				.eContainer();
		return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
				.canExistLinkingResource_4001(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof CommunicationLinkResourceSpecification && newEnd instanceof CommunicationLinkResourceSpecification)) {
			return false;
		}
		if (getLink().getFromResourceContainer_LinkingResource().size() != 1) {
			return false;
		}
		ResourceContainer source = (ResourceContainer) getLink()
				.getFromResourceContainer_LinkingResource().get(0);
		if (!(getLink().eContainer() instanceof ResourceEnvironment)) {
			return false;
		}
		ResourceEnvironment container = (ResourceEnvironment) getLink()
				.eContainer();
		return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
				.canExistLinkingResource_4001(container, source, getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().getFromResourceContainer_LinkingResource().remove(getOldSource());
		getLink().getFromResourceContainer_LinkingResource().add(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setCommunicationLinkResourceSpecifications_LinkingResource(
				getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected LinkingResource getLink() {
		return (LinkingResource) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected ResourceContainer getOldSource() {
		return (ResourceContainer) oldEnd;
	}

	/**
	 * @generated
	 */
	protected ResourceContainer getNewSource() {
		return (ResourceContainer) newEnd;
	}

	/**
	 * @generated
	 */
	protected CommunicationLinkResourceSpecification getOldTarget() {
		return (CommunicationLinkResourceSpecification) oldEnd;
	}

	/**
	 * @generated
	 */
	protected CommunicationLinkResourceSpecification getNewTarget() {
		return (CommunicationLinkResourceSpecification) newEnd;
	}
}
