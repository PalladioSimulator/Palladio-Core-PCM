/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;

public class CustomReleaseActionEntityName2EditPart extends ReleaseActionEntityName2EditPart {

	public CustomReleaseActionEntityName2EditPart(View view) {
		super(view);
	}

	@Override
	protected String getLabelText() {
		String text = null;
		EObject parserElement = getParserElement();
		if (parserElement != null && getParser() != null) {
			text = getParser().getPrintString(
					new EObjectAdapter(parserElement),
					getParserOptions().intValue());
		}
		EObject releaseAction = resolveSemanticElement();
		if (releaseAction != null && releaseAction instanceof ReleaseAction) {
			if (((ReleaseAction) releaseAction)
					.getPassiveResource_ReleaseAction() != null)
				text += " <Resource: "
						+ ((ReleaseAction) releaseAction)
								.getPassiveResource_ReleaseAction()
								.getEntityName() + ">";
		}
		if (text == null || text.length() == 0) {
			text = getLabelTextHelper(getFigure());
		}
		return text;
	}
}
