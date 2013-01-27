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
 * @generated
 */
public class AbstractUserActionTypeLinkCreateCommand extends CreateRelationshipCommand {

    /**
     * @generated
     */
    private ScenarioBehaviour mySource;

    /**
     * @generated
     */
    private AbstractUserAction myTarget;

    /**
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
     * @generated
     */
    public EObject getSource() {
        return mySource;
    }

    /**
     * @generated
     */
    public EObject getTarget() {
        return myTarget;
    }

    /**
     * @generated
     */
    protected EClass getEClassToEdit() {
        return UsagemodelPackage.eINSTANCE.getScenarioBehaviour();
    }

    /**
     * @generated
     */
    protected void setElementToEdit(EObject element) {
        throw new UnsupportedOperationException();
    }

    /**
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
