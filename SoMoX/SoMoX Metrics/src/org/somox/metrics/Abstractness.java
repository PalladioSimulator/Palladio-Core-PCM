package org.somox.metrics;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;

public class Abstractness {
	public double compute (Root root, ModelElement [] elements1, ModelElement [] elements2) {
		double abstractness = 0.0;
		double numberAbstract = 0.0;
		double numberTotal = 0.0;
		
		for (ModelElement element : elements1) {
			if (element instanceof GASTClass) {
				GASTClass gClass = (GASTClass)element;
				if (gClass.isInterface() || gClass.isAbstract()) {
					numberAbstract = numberAbstract + 1.0;
				}
				numberTotal = numberTotal + 1.0;
			}
		}
		for (ModelElement element : elements2) {
			if (element instanceof GASTClass) {
				GASTClass gClass = (GASTClass)element;
				if (gClass.isInterface() || gClass.isAbstract()) {
					numberAbstract = numberAbstract + 1.0;
				}
				numberTotal = numberTotal + 1.0;
			}
		}
		
		abstractness = numberAbstract/numberTotal;
		
		return abstractness;
	}
}