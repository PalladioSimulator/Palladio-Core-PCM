/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.custom.edit.parts;

import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationSignatureEditPart;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcmbench.ui.provider.SignaturePrinter;

public class CustomOperationSignatureEditPart extends OperationSignatureEditPart {

	public CustomOperationSignatureEditPart(View view) {
		super(view);
	}

	private static final int MAX_SIGNATURE_DISPLAY_LENGTH = 50;

	@Override
	protected String getLabelText() {
		String text = "";
		if (resolveSemanticElement() instanceof OperationSignature) {
			OperationSignature sig = (OperationSignature) resolveSemanticElement();
			text = new SignaturePrinter().doSwitch(sig);
			if (text.length() > MAX_SIGNATURE_DISPLAY_LENGTH)
				text = text.substring(0, MAX_SIGNATURE_DISPLAY_LENGTH - 1)
						+ "...";
		}
		if (text == null || text.length() == 0) {
			text = getLabelTextHelper(figure);
		}
		return text;
	}

}
