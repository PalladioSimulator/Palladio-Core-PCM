package org.somox.metrics;

import java.util.List;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;

public interface Metric {
	double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2);
}
