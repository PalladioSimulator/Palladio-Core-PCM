package org.somox.analyzer.metriccomputation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Preferences;
import org.somox.analyzerrules.TestAnalyzerRule;
import org.somox.metrics.Coupling;
import org.somox.metrics.DMS;
import org.somox.metrics.Metric;
import org.somox.metrics.MetricID;
import org.somox.metrics.NameResemblance;
import org.somox.metrics.SubsystemComponent;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;

public class TupleIterator {
	private LinkedList<Object> metricList;
	private final String DELIMITER = "§";
	
	private boolean couplingBlacklistIndicator;
	private boolean dmsBlacklistIndicator;
	private boolean subsystemComponentBlacklistIndicator;
	
	private Set<String> couplingBlacklist;
	private Set<String> dmsBlacklist;
	private Set<String> subsystemComponentBlacklist;
	
	private Set<String> nameResemblancePrefixes;
	private Set<String> nameResemblanceSuffixes;
	
	public TupleIterator () {
		metricList = new LinkedList<Object>();
	}
	
	public void configure (Preferences preferences) {
		String nameResemblancePrefixString = preferences.getString("org.somox.metrics.nameResemblance.excludedPrefixes");
		String nameResemblanceSuffixString = preferences.getString("org.somox.metrics.nameResemblance.excludedSuffixes");
		
		String couplingWildcardString = preferences.getString("org.somox.metrics.coupling.wildcards");
		couplingBlacklistIndicator = preferences.getBoolean("org.somox.metrics.coupling.blacklistIndicator");
		
		String dmsWildcardString = preferences.getString("org.somox.metrics.dms.wildcards");
		dmsBlacklistIndicator = preferences.getBoolean("org.somox.metrics.dms.blacklistIndicator");
		
		String subsystemComponentWildcardString = preferences.getString("org.somox.metrics.subsystemComponent.wildcards");
		subsystemComponentBlacklistIndicator = preferences.getBoolean("org.somox.metrics.subsystemComponent.blacklistIndicator");
		if (subsystemComponentBlacklistIndicator == false) {
			System.out.println("GOT FALSE");
		} else {
			System.out.println("GOT TRUE");
		}
		
		StringTokenizer tokenizer = new StringTokenizer(nameResemblancePrefixString, DELIMITER);
		int tokenCount = tokenizer.countTokens();
		nameResemblancePrefixes = new HashSet<String>();
		for (int i = 0; i < tokenCount; i++) {
			nameResemblancePrefixes.add(tokenizer.nextToken());
		}
		
		tokenizer = new StringTokenizer(nameResemblanceSuffixString, DELIMITER);
		tokenCount = tokenizer.countTokens();
		nameResemblanceSuffixes = new HashSet<String>();
		for (int i = 0; i < tokenCount; i++) {
			nameResemblanceSuffixes.add(tokenizer.nextToken());
		}
		
		tokenizer = new StringTokenizer(couplingWildcardString, DELIMITER);
		tokenCount = tokenizer.countTokens();
		couplingBlacklist = new HashSet<String>();
		for (int i = 0; i < tokenCount; i++) {
			couplingBlacklist.add(tokenizer.nextToken());
		}
		
		tokenizer = new StringTokenizer(dmsWildcardString, DELIMITER);
		tokenCount = tokenizer.countTokens();
		dmsBlacklist = new HashSet<String>();
		for (int i = 0; i < tokenCount; i++) {
			dmsBlacklist.add(tokenizer.nextToken());
		}
		
		tokenizer = new StringTokenizer(subsystemComponentWildcardString, DELIMITER);
		tokenCount = tokenizer.countTokens();
		subsystemComponentBlacklist = new HashSet<String>();
		for (int i = 0; i < tokenCount; i++) {
			subsystemComponentBlacklist.add(tokenizer.nextToken());
		}
	}
	
	public void initialize(Root root) {
		IExtensionPoint point = Platform.getExtensionRegistry().getExtensionPoint("org.somox.core","metric");
		
		if (point == null) {
			throw new NullPointerException ("ExtensionPoint not found");
		}
		for (IExtension extension : point.getExtensions()){
			for (IConfigurationElement configuration : extension.getConfigurationElements()) {
				try {
					Object o = configuration.createExecutableExtension("class");

					if (o instanceof Metric) {
						metricList.add(o);
						((Metric)o).initialize(root);

						if (((Metric)o).getMID().equals(new NameResemblance().getMID())) {
							((NameResemblance)o).setExcludedPrefixes(nameResemblancePrefixes);
							((NameResemblance)o).setExcludedSuffixes(nameResemblanceSuffixes);
						} else if (((Metric)o).getMID().equals(new Coupling().getMID())) {
							if (couplingBlacklistIndicator) {
								((Coupling)o).setBlacklist(couplingBlacklist);
							} else {
								((Coupling)o).setWhitelist(couplingBlacklist);
							}

						} else if (((Metric)o).getMID().equals(new DMS().getMID())) {
							if (dmsBlacklistIndicator) {
								((DMS)o).setBlacklist(dmsBlacklist);
							} else {
								((DMS)o).setWhitelist(dmsBlacklist);
							}
						} else if (((Metric)o).getMID().equals(new SubsystemComponent().getMID())) {
							if (subsystemComponentBlacklistIndicator) {
								((SubsystemComponent)o).setBlacklist(subsystemComponentBlacklist);
							} else {
								((SubsystemComponent)o).setWhitelist(subsystemComponentBlacklist);
							}
						}
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		Map<MetricID, Double> argAB = new HashMap<MetricID, Double>();
		Map<MetricID, Double> argBA = new HashMap<MetricID, Double>();
		
		for (Object o : metricList) {
			if (o instanceof Metric) {
				argAB.put(((Metric)o).getMID(), ((Metric)o).compute(root, elements1, elements2));
				argBA.put(((Metric)o).getMID(), ((Metric)o).compute(root, elements2, elements1));
			}
		}
		
		if (argAB.size() != 0 && argBA.size() != 0) {
			TestAnalyzerRule rule = new TestAnalyzerRule();
			
			return rule.computeOverallMetricValue(argAB, argBA);
		} else {
			throw new NullPointerException ("Metric lists empty");
		}
	}

}
