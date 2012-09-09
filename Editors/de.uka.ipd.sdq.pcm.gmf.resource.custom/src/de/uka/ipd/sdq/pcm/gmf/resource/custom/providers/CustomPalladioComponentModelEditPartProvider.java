/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.custom.providers;

import de.uka.ipd.sdq.pcm.gmf.resource.custom.edit.parts.CustomPalladioComponentModelEditPartFactory;
import de.uka.ipd.sdq.pcm.gmf.resource.providers.PalladioComponentModelEditPartProvider;

/**
 * Am edit part provider.
 */
public class CustomPalladioComponentModelEditPartProvider extends PalladioComponentModelEditPartProvider {

    /**
     * Initializes the edit part provider.
     */
    public CustomPalladioComponentModelEditPartProvider() {
        setFactory(new CustomPalladioComponentModelEditPartFactory());
        setAllowCaching(true);
    }

}
