package org.somox.metrics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;

/**
 * NameResemblance metric
 * 
 * @author Grischa Liebel
 *
 */
public class NameResemblance implements Metric {

	/**
	 * Set with prefix Strings that will be excluded in every metric-computation
	 */
	protected Set<String> excludedPrefixes;
	/**
	 * Set with suffix Strings that will be excluded in every metric-computation
	 */
	protected Set<String> excludedSuffixes;
	
	
	/**
	 * Puffer for name resemblances. For every Qualified class name a Map 
	 * is provided with every other class and an Integer indicating the resemblance
	 * whereas <code>-1</code> means not yet calculated, <code>0</code> means no resemblance
	 * and <code>1<code> means resemblance
	 */
	protected Map<String,Map<String,Integer>> resemblancePuffer;
	
	/**
	 * Default constructor initializing the attributes
	 */
	public NameResemblance () {
		resemblancePuffer = new HashMap<String,Map<String,Integer>>();
		
		excludedPrefixes = new HashSet<String>();
		excludedSuffixes = new HashSet<String>();
	}
	
	/**
	 * Setter method setting the prefixes, that need to be excluded in the computation
	 * 
	 * @param excludedPrefixes The String map with the prefixes
	 */
	public void setExcludedPrefixes (Set<String> excludedPrefixes) {
		if (excludedPrefixes != null) {
			this.excludedPrefixes = excludedPrefixes;
		}
	}
	
	/**
	 * Setter method setting the suffixes, that need to be excluded in the computation
	 * 
	 * @param excludedSuffixes The String map with the suffixes
	 */
	public void setExcludedSuffixes (Set<String> excludedSuffixes) {
		if (excludedSuffixes != null) {
			this.excludedSuffixes = excludedSuffixes;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		HashMap<String, Boolean> resemblanceMap = new HashMap<String, Boolean>();
		
		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
				if (!resemblanceMap.containsKey(((GASTClass) current).getSimpleName())) {
					resemblanceMap.put(((GASTClass)current).getSimpleName(), false);
				}
				//compute name resemblances between elements in elements1
				for (ModelElement currentCheck : elements1) {
					if (currentCheck instanceof GASTClass) {
						if (!((GASTClass)current).getSimpleName().equals(((GASTClass)currentCheck).getSimpleName())) {
							if (!resemblanceMap.containsKey(((GASTClass) currentCheck).getSimpleName())) {
								resemblanceMap.put(((GASTClass)currentCheck).getSimpleName(), false);
							}
							int res = resemblancePuffer.get(((GASTClass)current).getQualifiedName()).get(((GASTClass)currentCheck).getQualifiedName());
							if (res == -1) {
								if (checkResemblance(((GASTClass)current).getSimpleName(), ((GASTClass)currentCheck).getSimpleName())) {
									resemblancePuffer.get(((GASTClass)current).getQualifiedName()).put((((GASTClass)currentCheck).getQualifiedName()),1);
									resemblanceMap.put(((GASTClass)current).getSimpleName(), true);
									resemblanceMap.put(((GASTClass)currentCheck).getSimpleName(), true);
								} else {
									resemblancePuffer.get(((GASTClass)current).getQualifiedName()).put((((GASTClass)currentCheck).getQualifiedName()),0);
								}
							} else if (res > 0) {
								resemblanceMap.put(((GASTClass)current).getSimpleName(), true);
								resemblanceMap.put(((GASTClass)currentCheck).getSimpleName(), true);
							}
						}
					}
				}

				//compute name resemblances between elements in elements1 and 2
				for (ModelElement currentCheck : elements2) {
					if (currentCheck instanceof GASTClass) {
						if (!resemblanceMap.containsKey(((GASTClass) currentCheck).getSimpleName())) {
							resemblanceMap.put(((GASTClass)currentCheck).getSimpleName(), false);
						}
						int res = resemblancePuffer.get(((GASTClass)current).getQualifiedName()).get(((GASTClass)currentCheck).getQualifiedName());
						if (res == -1) {
							if (checkResemblance(((GASTClass)current).getSimpleName(), ((GASTClass)currentCheck).getSimpleName())) {
								resemblancePuffer.get(((GASTClass)current).getQualifiedName()).put((((GASTClass)currentCheck).getQualifiedName()),1);
								resemblanceMap.put(((GASTClass)current).getSimpleName(), true);
								resemblanceMap.put(((GASTClass)currentCheck).getSimpleName(), true);
							} else {
								resemblancePuffer.get(((GASTClass)current).getQualifiedName()).put((((GASTClass)currentCheck).getQualifiedName()),0);
							}
						} else if (res > 0) {
							resemblanceMap.put(((GASTClass)current).getSimpleName(), true);
							resemblanceMap.put(((GASTClass)currentCheck).getSimpleName(), true);
						}
					}
				}
			}
		}
		
		for (ModelElement current : elements2) {
			if (current instanceof GASTClass) {
				if (!resemblanceMap.containsKey(((GASTClass) current).getSimpleName())) {
					resemblanceMap.put(((GASTClass)current).getSimpleName(), false);
				}
				//compute name resemblances between elements in elements2
				for (ModelElement currentCheck : elements2) {
					if (currentCheck instanceof GASTClass) {
						if (!((GASTClass)current).getSimpleName().equals(((GASTClass)currentCheck).getSimpleName())) {

							if (!resemblanceMap.containsKey(((GASTClass) currentCheck).getSimpleName())) {
								resemblanceMap.put(((GASTClass)currentCheck).getSimpleName(), false);
							}
							int res = resemblancePuffer.get(((GASTClass)current).getQualifiedName()).get(((GASTClass)currentCheck).getQualifiedName());
							if (res == -1) {
								if (checkResemblance(((GASTClass)current).getSimpleName(), ((GASTClass)currentCheck).getSimpleName())) {
									resemblancePuffer.get(((GASTClass)current).getQualifiedName()).put((((GASTClass)currentCheck).getQualifiedName()),1);
									resemblanceMap.put(((GASTClass)current).getSimpleName(), true);
									resemblanceMap.put(((GASTClass)currentCheck).getSimpleName(), true);
								} else {
									resemblancePuffer.get(((GASTClass)current).getQualifiedName()).put((((GASTClass)currentCheck).getQualifiedName()),0);
								}
							} else if (res > 0) {
								resemblanceMap.put(((GASTClass)current).getSimpleName(), true);
								resemblanceMap.put(((GASTClass)currentCheck).getSimpleName(), true);
							}
						}
					}
				}
			}
		}
				
		double totalSize = resemblanceMap.size();
		double nameResemblance = 0.0;
		
		for (Boolean current : resemblanceMap.values()) {
			if (current) {
				nameResemblance += 1.0;
			}
		}
		
		return nameResemblance/totalSize;
	}
	
	/**
	 * Helper method to check if 2 Strings have a nameResemblance
	 * 
	 * 2 Strings have a resemblance if they are equal after cutting 
	 * specified pre- and suffixes from the classname
	 * 
	 * @param a first String
	 * @param b second String
	 * @return <code>true</code> if the Strings have a resemblance
	 * <code>false</code> else
	 */
	private boolean checkResemblance (String a, String b) {
		
		//exclude prefixes
		boolean changed = true;
		while (changed) {
			changed = false;
			for (String currentPrefix : excludedPrefixes) {
				if (a.startsWith(currentPrefix)) {
					changed = true;
					a = a.substring(currentPrefix.length());
				}
				if (b.startsWith(currentPrefix)) {
					changed = true;
					b = b.substring(currentPrefix.length());
				}
			}
		}
		
		//exclude suffixes
		changed = true;
		while (changed) {
			changed = false;
			for (String currentSuffix : excludedSuffixes) {
				if (a.endsWith(currentSuffix)) {
					changed = true;
					a = a.substring(0, a.length()-currentSuffix.length());
				}
				if (b.endsWith(currentSuffix)) {
					changed = true;
					b = b.substring(0, b.length()-currentSuffix.length());
				}
			}
		}
		
		return a.equals(b);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public MetricTab getLaunchConfigurationTab() {
		return new NameResemblanceTab();
	}

	/**
	 * {@inheritDoc}
	 */
	public MetricID getMID() {
		return new MetricID(122);
	}


	/**
	 * {@inheritDoc}
	 */
	public void initialize(Root root) {
		
		EList<GASTClass> classList = root.getAllNormalClasses();
		classList.addAll(root.getAllInnerClasses());
		classList.addAll(root.getAllInterfaces());
		
		for (GASTClass currentClass : classList)  {
			resemblancePuffer.put(currentClass.getQualifiedName(), new HashMap<String,Integer>());
		}
		
		Set<String> keys = resemblancePuffer.keySet();
		
		for (String currentKey : keys) {
			for (GASTClass currentClass : classList) {
				resemblancePuffer.get(currentKey).put(currentClass.getQualifiedName(), -1);
			}
		}
	}
}
