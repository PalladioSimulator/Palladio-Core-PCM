/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.custom.providers;

import de.uka.ipd.sdq.pcm.gmf.usage.custom.edit.part.CustomPalladioComponentModelEditPartFactory;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelEditPartProvider;

/**
 * The Class CustomPalladioComponentModelEditPartProvider.
 */
public class CustomPalladioComponentModelEditPartProvider extends PalladioComponentModelEditPartProvider {

    /**
     * Instantiates a new custom palladio component model edit part provider.
     */
    public CustomPalladioComponentModelEditPartProvider() {
        super();
        setFactory(new CustomPalladioComponentModelEditPartFactory());
        setAllowCaching(true);
    }

}
