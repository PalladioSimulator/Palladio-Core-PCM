package org.somox.analyzer.metriccomputation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.somox.analyzerrules.TestAnalyzerRule;
import org.somox.metrics.Metric;
import org.somox.metrics.MetricID;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;

public class TupleIterator {
	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		Map<MetricID, Double> argAB = new HashMap<MetricID, Double>();
		Map<MetricID, Double> argBA = new HashMap<MetricID, Double>();
		
		IExtensionPoint point = Platform.getExtensionRegistry().getExtensionPoint("org.somox.core","metric");
		
		if (point == null) {
			return 0.0;
		}
		for (IExtension extension : point.getExtensions()){
			for (IConfigurationElement configuration : extension.getConfigurationElements()) {
				try {
					Object o = configuration.createExecutableExtension("class");

					if (o instanceof Metric) {
						argAB.put(((Metric)o).getMID(), ((Metric)o).compute(root, elements1, elements2));
						argBA.put(((Metric)o).getMID(), ((Metric)o).compute(root, elements2, elements1));
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
		
		if (argAB.size() != 0 && argBA.size() != 0) {
			TestAnalyzerRule rule = new TestAnalyzerRule();
			
			return rule.computeOverallMetricValue(argAB, argBA);
		} else {
			return 0.0;
		}
	}

}
