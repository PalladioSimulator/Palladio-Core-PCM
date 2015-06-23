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

/**
 * The Class StoExParserProvider.
 */
public class StoExParserProvider extends AbstractProvider implements IParserProvider {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider#getParser(org.eclipse.core
     * .runtime.IAdaptable)
     */
    /**
     * Gets the parser.
     * 
     * @param hint
     *            the hint
     * @return the parser
     * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider#getParser(org.eclipse.core.runtime.IAdaptable)
     */
    @Override
    public IParser getParser(final IAdaptable hint) {
        final String vid = (String) hint.getAdapter(String.class);
        if (vid != null) {
            return this.getParser(PalladioComponentModelVisualIDRegistry.getVisualID(vid));
        }
        final View view = (View) hint.getAdapter(View.class);
        if (view != null) {
            return this.getParser(PalladioComponentModelVisualIDRegistry.getVisualID(view));
        }
        return null;
    }

    /**
     * Gets the parser.
     * 
     * @param visualID
     *            the visual id
     * @return the parser
     */
    private IParser getParser(final int visualID) {
        switch (visualID) {
        case VariableCharacterisationEditPart.VISUAL_ID:
        case VariableCharacterisation2EditPart.VISUAL_ID:
        case VariableCharacterisation3EditPart.VISUAL_ID:
            return this.createStoExParser();
        default:
            return null;
        }
    }

    /**
     * Creates the stoex parser.
     * 
     * @return the i parser
     */
    private IParser createStoExParser() {
        return new StoExParser();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common
     * .core.service.IOperation)
     */
    /**
     * Provides.
     * 
     * @param operation
     *            the operation
     * @return true, if successful
     * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
     */
    @Override
    public boolean provides(final IOperation operation) {
        if (!(operation instanceof GetParserOperation)) {
            return false;
        }
        final GetParserOperation gpo = (GetParserOperation) operation;
        return false; // getParser(gpo.getHint()) != null;
        // FIXME: Decide if comment above is needed. Commented out since 20.6.2007!
    }

}
