/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.custom.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.PassiveResourceEditPart;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;

/**
 * A custom passive resource EditPart.
 */
public class CustomPassiveResourceEditPart extends PassiveResourceEditPart {

    /**
     * The changeListener.
     */
    private EContentAdapter changeListener = null;
    
    /**
     * An adaptedElement.
     */
    private EObject adaptedElement = null;

    /**
     * The constructor.
     * @param view a View
     */
    public CustomPassiveResourceEditPart(View view) {
        super(view);
    }

    
    @Override
    protected String getLabelText() {
        String stoex = null, text = null;
        if (resolveSemanticElement() instanceof PassiveResource) {
            PassiveResource pr = (PassiveResource) resolveSemanticElement();
            if (pr.getCapacity_PassiveResource() != null) {
                stoex = new PCMStoExPrettyPrintVisitor().prettyPrint(pr.getCapacity_PassiveResource().getExpression());
            }
            text = pr.getEntityName();
            if (stoex == null) {
                stoex = "not set";
            }
            text += " <Capacity: " + stoex + ">";
        }
        if (text == null || text.length() == 0) {
            text = getLabelTextHelper(figure);
        }
        return text;
    }

    @Override
    protected void addSemanticListeners() {
        PassiveResource element = (PassiveResource) resolveSemanticElement();
        changeListener = new EContentAdapter() {

            @Override
            public void notifyChanged(Notification notification) {
                super.notifyChanged(notification);
                refreshLabel();
            }

        };
        adaptedElement = element;
        element.eAdapters().add(changeListener);
    }

    @Override
    protected void removeSemanticListeners() {
        adaptedElement.eAdapters().remove(changeListener);
    }
}
