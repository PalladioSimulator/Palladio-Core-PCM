/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalFailureOccurrenceDescriptionEditPart;
import org.palladiosimulator.pcm.reliability.InternalFailureOccurrenceDescription;

/**
 * The customized internal failure occurrence description edit part class.
 */
public class CustomInternalFailureOccurrenceDescriptionEditPart extends InternalFailureOccurrenceDescriptionEditPart {

    /** The change listener. */
    private EContentAdapter changeListener = null;

    /** The adapted element. */
    private EObject adaptedElement = null;

    /**
     * Instantiates a new customized internal failure occurrence description edit part.
     * 
     * @param view
     *            the view
     */
    public CustomInternalFailureOccurrenceDescriptionEditPart(final View view) {
        super(view);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalFailureOccurrenceDescriptionEditPart#getLabelText
     * ()
     */
    /**
     * Gets the label text.
     * 
     * @return the label text
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalFailureOccurrenceDescriptionEditPart#getLabelText()
     */
    @Override
    protected String getLabelText() {
        String text = null;
        if (this.resolveSemanticElement() instanceof InternalFailureOccurrenceDescription) {
            final InternalFailureOccurrenceDescription description = (InternalFailureOccurrenceDescription) this
                    .resolveSemanticElement();
            if (description.getSoftwareInducedFailureType__InternalFailureOccurrenceDescription() != null) {
                text = description.getSoftwareInducedFailureType__InternalFailureOccurrenceDescription()
                        .getEntityName();
            } else {
                text = "[UNSPECIFIED]";
            }
            text += " (" + description.getFailureProbability() + ")";
        }
        if (text == null || text.length() == 0) {
            text = this.getLabelTextHelper(this.getFigure());
        }
        return text;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalFailureOccurrenceDescriptionEditPart#
     * addSemanticListeners()
     */
    /**
     * Adds the semantic listeners.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalFailureOccurrenceDescriptionEditPart#addSemanticListeners()
     */
    @Override
    protected void addSemanticListeners() {
        final InternalFailureOccurrenceDescription element = (InternalFailureOccurrenceDescription) this
                .resolveSemanticElement();
        this.changeListener = new EContentAdapter() {

            @Override
            public void notifyChanged(final Notification notification) {
                super.notifyChanged(notification);
                CustomInternalFailureOccurrenceDescriptionEditPart.this.refreshLabel();
            }

        };
        this.adaptedElement = element;
        element.eAdapters().add(this.changeListener);
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalFailureOccurrenceDescriptionEditPart#
     * removeSemanticListeners()
     */
    /**
     * Removes the semantic listeners.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalFailureOccurrenceDescriptionEditPart#removeSemanticListeners()
     */
    @Override
    protected void removeSemanticListeners() {
        this.adaptedElement.eAdapters().remove(this.changeListener);
    }

}
