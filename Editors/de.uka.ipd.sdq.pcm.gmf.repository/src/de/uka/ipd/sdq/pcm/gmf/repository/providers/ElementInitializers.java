/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.providers;

import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelRepositoryDiagramEditorPlugin;

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
        ElementInitializers cached = PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance()
                .getElementInitializers();
        if (cached == null) {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().setElementInitializers(
                    cached = new ElementInitializers());
        }
        return cached;
    }
}
