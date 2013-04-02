/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.providers;

import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelUsageDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

    protected ElementInitializers() {
        // use #getInstance to access cached instance
    }

    /**
     * @generated
     */
    public static ElementInitializers getInstance() {
        ElementInitializers cached = PalladioComponentModelUsageDiagramEditorPlugin.getInstance()
                .getElementInitializers();
        if (cached == null) {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().setElementInitializers(
                    cached = new ElementInitializers());
        }
        return cached;
    }
}
