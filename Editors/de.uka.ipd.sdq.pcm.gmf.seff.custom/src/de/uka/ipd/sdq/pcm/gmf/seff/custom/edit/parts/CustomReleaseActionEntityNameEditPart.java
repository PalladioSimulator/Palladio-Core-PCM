/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;

/**
 * The customized release action entity name edit part class.
 */
public class CustomReleaseActionEntityNameEditPart extends ReleaseActionEntityNameEditPart {

    /**
     * Instantiates a new customized release action entity name edit part.
     * 
     * @param view
     *            the view
     */
    public CustomReleaseActionEntityNameEditPart(final View view) {
        super(view);
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEntityNameEditPart#getLabelText()
     */
    /**
     * Gets the label text.
     * 
     * @return the label text
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEntityNameEditPart#getLabelText()
     */
    @Override
    protected String getLabelText() {
        String text = null;
        final EObject parserElement = this.getParserElement();
        if (parserElement != null && this.getParser() != null) {
            text = this.getParser().getPrintString(new EObjectAdapter(parserElement),
                    this.getParserOptions().intValue());
        }
        final EObject releaseAction = this.resolveSemanticElement();
        if (releaseAction != null && releaseAction instanceof ReleaseAction) {
            if (((ReleaseAction) releaseAction).getPassiveResource_ReleaseAction() != null) {
                text += " <Resource: "
                        + ((ReleaseAction) releaseAction).getPassiveResource_ReleaseAction().getEntityName() + ">";
            }
        }
        if (text == null || text.length() == 0) {
            text = this.getLabelTextHelper(this.getFigure());
        }
        return text;
    }
}
