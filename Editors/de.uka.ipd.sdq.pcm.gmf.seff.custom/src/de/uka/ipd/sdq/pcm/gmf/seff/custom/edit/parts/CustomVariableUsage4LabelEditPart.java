/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage4LabelEditPart;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;

/**
 * The customized variable usage4 label edit part class.
 */
public class CustomVariableUsage4LabelEditPart extends VariableUsage4LabelEditPart {

    /**
     * Instantiates a new customized variable usage4 label edit part.
     * 
     * @param view
     *            the view
     */
    public CustomVariableUsage4LabelEditPart(final View view) {
        super(view);
    }

    /**
     * Enhanced method to present the name of the VariableReference of the VariableUsage this
     * wrapping label edit part is about.
     * 
     * @return the label text
     */
    @Override
    protected String getLabelText() {
        String text = null;
        final EObject parserElement = this.getParserElement();
        if (parserElement != null) {
            if (parserElement instanceof VariableUsage) {
                // customized
                final VariableUsage usage = (VariableUsage) this.resolveSemanticElement();
                if (usage.getNamedReference__VariableUsage() != null) {
                    text = new PCMStoExPrettyPrintVisitor().prettyPrint(usage.getNamedReference__VariableUsage());
                }
            } else {
                if (parserElement != null && this.getParser() != null) {
                    text = this.getParser().getPrintString(new EObjectAdapter(parserElement),
                            this.getParserOptions().intValue());
                }
            }
        }
        if (text == null || text.length() == 0) {
            text = this.getLabelTextHelper(this.getFigure());
        }
        return text;
    }

}
