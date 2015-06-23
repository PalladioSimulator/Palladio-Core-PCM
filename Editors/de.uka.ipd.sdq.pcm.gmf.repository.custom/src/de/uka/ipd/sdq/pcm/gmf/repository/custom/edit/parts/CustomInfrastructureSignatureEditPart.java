/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.custom.edit.parts;

import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.InfrastructureSignatureEditPart;
import org.palladiosimulator.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcmbench.ui.provider.SignaturePrinter;

/**
 * A custom infrastructure signature EditPart.
 */
public class CustomInfrastructureSignatureEditPart extends InfrastructureSignatureEditPart {

    /**
     * the maximum signature display length.
     */
    private static final int MAX_SIGNATURE_DISPLAY_LENGTH = 50;

    /**
     * The constructor.
     * 
     * @param view
     *            a View
     */
    public CustomInfrastructureSignatureEditPart(View view) {
        super(view);
    }

    @Override
    protected String getLabelText() {
        String text = "";
        if (resolveSemanticElement() instanceof InfrastructureSignature) {
            InfrastructureSignature sig = (InfrastructureSignature) resolveSemanticElement();
            text = new SignaturePrinter().doSwitch(sig);
            if (text.length() > MAX_SIGNATURE_DISPLAY_LENGTH) {
                text = text.substring(0, MAX_SIGNATURE_DISPLAY_LENGTH - 1) + "...";
            }
        } else if (getParserElement() != null && getParser() != null) {
            text = getParser().getPrintString(new EObjectAdapter(getParserElement()), getParserOptions().intValue());
        }
        if (text == null || text.length() == 0) {
            text = getLabelTextHelper(figure);
        }
        return text;
    }
}
