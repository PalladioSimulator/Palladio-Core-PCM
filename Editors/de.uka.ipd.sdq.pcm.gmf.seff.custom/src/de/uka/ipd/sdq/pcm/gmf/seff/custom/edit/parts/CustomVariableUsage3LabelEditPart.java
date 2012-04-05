/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage3LabelEditPart;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;

public class CustomVariableUsage3LabelEditPart extends VariableUsage3LabelEditPart {

	public CustomVariableUsage3LabelEditPart(View view) {
		super(view);
	}

	/**
	 * Enhanced method to present the name of the
	 * VariableReference of the VariableUsage this
	 * wrapping label edit part is about
	 */
	@Override
	protected String getLabelText() {
		String text = null;
		EObject parserElement = getParserElement();
		if (parserElement != null) {
			if (parserElement instanceof VariableUsage) {
				// customized
				VariableUsage usage = (VariableUsage) this
						.resolveSemanticElement();
				if (usage.getNamedReference__VariableUsage() != null) {
					text = new PCMStoExPrettyPrintVisitor().prettyPrint(usage
							.getNamedReference__VariableUsage());
				}
			} else {
				if (parserElement != null && getParser() != null) {
					text = getParser().getPrintString(
							new EObjectAdapter(parserElement),
							getParserOptions().intValue());
				}
			}
		}
		if (text == null || text.length() == 0) {
			text = getLabelTextHelper(getFigure());
		}
		return text;
	}

}
