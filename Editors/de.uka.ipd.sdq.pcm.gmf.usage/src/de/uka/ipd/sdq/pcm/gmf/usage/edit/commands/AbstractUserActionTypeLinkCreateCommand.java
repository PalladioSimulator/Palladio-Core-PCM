/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * The Class AbstractUserActionTypeLinkCreateCommand.
 *
 * @generated
 */
public class AbstractUserActionTypeLinkCreateCommand extends CreateRelationshipCommand {

    /** The my source. @generated */
    private ScenarioBehaviour mySource;

    /** The my target. @generated */
    private AbstractUserAction myTarget;

    /**
     * Instantiates a new abstract user action type link create command.
     *
     * @param req the req
     * @param source the source
     * @param target the target
     * @generated
     */
    public AbstractUserActionTypeLinkCreateCommand(CreateRelationshipRequest req, ScenarioBehaviour source,
            AbstractUserAction target) {
        super(req);
        super.setElementToEdit(source);
        mySource = source;
        myTarget = target;
    }

    /**
     * Gets the source.
     *
     * @return the source
     * @generated
     */
    public EObject getSource() {
        return mySource;
    }

    /**
     * Gets the target.
     *
     * @return the target
     * @generated
     */
    public EObject getTarget() {
        return myTarget;
    }

    /**
     * Gets the e class to edit.
     *
     * @return the e class to edit
     * @generated
     */
    protected EClass getEClassToEdit() {
        return UsagemodelPackage.eINSTANCE.getScenarioBehaviour();
    }

    /**
     * Sets the element to edit.
     *
     * @param element the new element to edit
     * @generated
     */
    protected void setElementToEdit(EObject element) {
        throw new UnsupportedOperationException();
    }

    /**
     * Do default element creation.
     *
     * @return the e object
     * @generated
     */
    protected EObject doDefaultElementCreation() {
        AbstractUserAction newElement = (AbstractUserAction) super.doDefaultElementCreation();
        if (newElement != null) {
            newElement.setSuccessor(myTarget);
        }
        return newElement;
    }

}
