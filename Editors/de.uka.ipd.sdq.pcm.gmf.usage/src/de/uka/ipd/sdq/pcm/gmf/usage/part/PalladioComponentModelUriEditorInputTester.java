/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.common.ui.URIEditorInput;

/**
 * The Class PalladioComponentModelUriEditorInputTester.
 *
 * @generated
 */
public class PalladioComponentModelUriEditorInputTester extends PropertyTester {

    /**
     * Test.
     *
     * @param receiver the receiver
     * @param method the method
     * @param args the args
     * @param expectedValue the expected value
     * @return true, if successful
     * @generated
     */
    public boolean test(Object receiver, String method, Object[] args, Object expectedValue) {
        if (false == receiver instanceof URIEditorInput) {
            return false;
        }
        URIEditorInput editorInput = (URIEditorInput) receiver;
        return "usagemodel_diagram".equals(editorInput.getURI().fileExtension()); //$NON-NLS-1$
    }

}
