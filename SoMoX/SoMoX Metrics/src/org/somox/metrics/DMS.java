package org.somox.metrics;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;

public class DMS {
	public static double compute (Root root, ModelElement [] elements1, ModelElement [] elements2) {
		double abstractness = Abstractness.compute(root, elements1, elements2);
		double instability = Instability.compute(root, elements1, elements2);
		
		double dms = Math.abs(abstractness + instability - 1.0);
		
		return dms;
	}
}
