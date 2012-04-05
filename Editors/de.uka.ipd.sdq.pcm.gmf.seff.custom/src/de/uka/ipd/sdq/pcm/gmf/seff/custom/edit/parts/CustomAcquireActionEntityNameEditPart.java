/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;


public class CustomAcquireActionEntityNameEditPart extends AcquireActionEntityNameEditPart {

	public CustomAcquireActionEntityNameEditPart(View view) {
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
		EObject acquireAction = resolveSemanticElement();
		if (acquireAction != null && acquireAction instanceof AcquireAction) {
			if (((AcquireAction) acquireAction)
					.getPassiveresource_AcquireAction() != null)
				text += " <Resource: "
						+ ((AcquireAction) acquireAction)
								.getPassiveresource_AcquireAction()
								.getEntityName() + ">";
		}
		if (text == null || text.length() == 0) {
			text = getLabelTextHelper(getFigure());
		}
		return text;
	}
}
