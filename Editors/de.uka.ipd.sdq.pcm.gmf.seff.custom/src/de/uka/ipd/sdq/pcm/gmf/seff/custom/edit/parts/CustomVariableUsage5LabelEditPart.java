/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage5LabelEditPart;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;

public class CustomVariableUsage5LabelEditPart extends VariableUsage5LabelEditPart {

	public CustomVariableUsage5LabelEditPart(View view) {
		super(view);
	}

	/**
	 * Displays the name of the referenced variable.
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
