/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.custom.providers;

import de.uka.ipd.sdq.pcm.gmf.resource.custom.edit.parts.CustomPalladioComponentModelEditPartFactory;
import de.uka.ipd.sdq.pcm.gmf.resource.providers.PalladioComponentModelEditPartProvider;


public class CustomPalladioComponentModelEditPartProvider extends
PalladioComponentModelEditPartProvider {

	
	public CustomPalladioComponentModelEditPartProvider() {
		setFactory(new CustomPalladioComponentModelEditPartFactory());
		setAllowCaching(true);
	}

}
