/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.providers;

import de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts.CustomPalladioComponentModelEditPartFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelEditPartProvider;

/**
 * The customized palladio component model edit part provider class.
 */
public class CustomPalladioComponentModelEditPartProvider extends PalladioComponentModelEditPartProvider {

    /**
     * Instantiates a new customized palladio component model edit part provider.
     */
    public CustomPalladioComponentModelEditPartProvider() {
        this.setFactory(new CustomPalladioComponentModelEditPartFactory());
        this.setAllowCaching(true);
    }
}
