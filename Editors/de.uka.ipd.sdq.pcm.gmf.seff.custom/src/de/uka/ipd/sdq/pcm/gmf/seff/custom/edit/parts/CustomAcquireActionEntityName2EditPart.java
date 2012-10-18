/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;

/**
 * The customized acquire action entity name2 edit part class.
 */
public class CustomAcquireActionEntityName2EditPart extends AcquireActionEntityName2EditPart {

    /**
     * Instantiates a new customized acquire action entity name2 edit part.
     * 
     * @param view
     *            the view
     */
    public CustomAcquireActionEntityName2EditPart(final View view) {
        super(view);
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEntityName2EditPart#getLabelText()
     */
    /**
     * Gets the label text.
     *
     * @return the label text
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEntityName2EditPart#getLabelText()
     */
    @Override
    protected String getLabelText() {
        String text = null;
        final EObject parserElement = this.getParserElement();
        if (parserElement != null && this.getParser() != null) {
            text = this.getParser().getPrintString(new EObjectAdapter(parserElement),
                    this.getParserOptions().intValue());
        }
        final EObject acquireAction = this.resolveSemanticElement();
        if (acquireAction != null && acquireAction instanceof AcquireAction) {
            if (((AcquireAction) acquireAction).getPassiveresource_AcquireAction() != null) {
                text += " <Resource: "
                        + ((AcquireAction) acquireAction).getPassiveresource_AcquireAction().getEntityName() + ">";
            }
        }
        if (text == null || text.length() == 0) {
            text = this.getLabelTextHelper(this.getFigure());
        }
        return text;
    }
}
