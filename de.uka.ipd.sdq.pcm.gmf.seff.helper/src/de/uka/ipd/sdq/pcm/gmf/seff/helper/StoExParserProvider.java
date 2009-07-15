package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

public class StoExParserProvider extends AbstractProvider implements IParserProvider {

	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(PalladioComponentModelVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(PalladioComponentModelVisualIDRegistry
					.getVisualID(view));
		}
		return null;
	}

	private IParser getParser(int visualID) {
		switch(visualID) {
		case VariableCharacterisationEditPart.VISUAL_ID:
		case VariableCharacterisation2EditPart.VISUAL_ID:
		case VariableCharacterisation3EditPart.VISUAL_ID:
			return createStoExParser();
		default:
			return null;
		}
	}

	private IParser createStoExParser() {
		return new StoExParser();
	}

	public boolean provides(IOperation operation) {
		if (!(operation instanceof GetParserOperation))
			return false;
		GetParserOperation gpo = (GetParserOperation) operation;
		return false; //getParser(gpo.getHint()) != null; 
	}

}
