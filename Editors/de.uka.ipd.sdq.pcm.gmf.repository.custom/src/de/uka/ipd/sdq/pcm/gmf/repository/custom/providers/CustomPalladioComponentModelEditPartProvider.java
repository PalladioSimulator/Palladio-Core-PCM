/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.custom.providers;

import de.uka.ipd.sdq.pcm.gmf.repository.custom.edit.parts.CustomPalladioComponentModelEditPartFactory;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelEditPartProvider;

public class CustomPalladioComponentModelEditPartProvider extends PalladioComponentModelEditPartProvider {

    public CustomPalladioComponentModelEditPartProvider() {
        super();
        setFactory(new CustomPalladioComponentModelEditPartFactory());
        setAllowCaching(true);
    }
}