/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.custom.edit.parts;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.OperationSignatureEditPart;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcmbench.ui.provider.SignaturePrinter;

/**
 * A custom operations signature EditPart.
 */
public class CustomOperationSignatureEditPart extends OperationSignatureEditPart {

	/**
     * An adaptedElement.
     */
    private OperationSignature adaptedElement = null;
    
    /**
     * A custom operation signature EditPart.
     * @param view a View
     */
    public CustomOperationSignatureEditPart(View view) {
        super(view);
    }

    /**
     * Maximum signature display length.
     */
    private static final int MAX_SIGNATURE_DISPLAY_LENGTH = 50;

    @Override
    protected String getLabelText() {
        String text = "";
        if (resolveSemanticElement() instanceof OperationSignature) {
            OperationSignature sig = (OperationSignature) resolveSemanticElement();
            text = new SignaturePrinter().doSwitch(sig);
            if (text.length() > MAX_SIGNATURE_DISPLAY_LENGTH) {
                text = text.substring(0, MAX_SIGNATURE_DISPLAY_LENGTH - 1) + "...";
            }
        }
        if (text == null || text.length() == 0) {
            text = getLabelTextHelper(figure);
        }
        return text;
    }
    
    @Override
    protected void addSemanticListeners() {
    	adaptedElement = (OperationSignature) resolveSemanticElement();
        super.addSemanticListeners();
        
    }

    @Override
    protected void removeSemanticListeners() {

        OperationSignature element =  adaptedElement;
        removeListenerFilter("SemanticModel"); //$NON-NLS-1$
        DataType returnType = element.getReturnType__OperationSignature();
        if (returnType != null) {
            removeListenerFilter("SemanticModel-RT"); //$NON-NLS-1$
        }

        EList<Parameter> params = element.getParameters__OperationSignature();
        for (int i = 0; i < params.size(); i++) {
            removeListenerFilter("SemanticModel-Param" + i); //$NON-NLS-1$
        }

    }

}
