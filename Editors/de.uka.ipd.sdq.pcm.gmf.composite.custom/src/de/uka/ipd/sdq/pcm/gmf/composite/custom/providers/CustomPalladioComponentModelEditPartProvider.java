/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.providers;

import de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.parts.CustomPalladioComponentModelEditPartFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelEditPartProvider;

/**
 * A custom Palladio component model EditPart provider.
 */
public class CustomPalladioComponentModelEditPartProvider extends PalladioComponentModelEditPartProvider {

    /**
     * The constructor.
     */
    public CustomPalladioComponentModelEditPartProvider() {
        super();
        setFactory(new CustomPalladioComponentModelEditPartFactory());
        setAllowCaching(true);
    }
}
