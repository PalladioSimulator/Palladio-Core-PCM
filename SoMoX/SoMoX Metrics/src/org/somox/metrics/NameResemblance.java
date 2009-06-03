package org.somox.metrics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.somox.analyzer.MetricTab;

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
	 * The percentage is used to determine how much percent of 2 Strings 
	 * need to be equal so that these Strings are treated to have a name resemblance 
	 */
	protected int percentage = 80;
	
	protected int [][] resemblances;
	
	protected Map<String,Map<String,Integer>> resemblancePuffer;
	
	public NameResemblance () {
		resemblancePuffer = new HashMap<String,Map<String,Integer>>();
	}
	
	/**
	 * Setter-method for the percentage paramter
	 * 
	 * @param percentage a given percentage
	 */
	public void setPercentage (int percentage) {
		if (percentage < 0 || percentage > 100) {
			this.percentage = 100;
		} else {
			this.percentage = percentage;
		}
	}
	
	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		HashMap<String, Boolean> resemblanceMap = new HashMap<String, Boolean>();
		
		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
				if (!resemblanceMap.containsKey(((GASTClass) current).getSimpleName())) {
					resemblanceMap.put(((GASTClass)current).getSimpleName(), false);
				}
				for (ModelElement currentCheck : elements1) {
					if (!((GASTClass)current).getSimpleName().equals(((GASTClass)currentCheck).getSimpleName())) {
						if (currentCheck instanceof GASTClass) {
							if (!resemblanceMap.containsKey(((GASTClass) currentCheck).getSimpleName())) {
								resemblanceMap.put(((GASTClass)currentCheck).getSimpleName(), false);
							}
							int res = resemblancePuffer.get(((GASTClass)current).getQualifiedName()).get(((GASTClass)currentCheck).getQualifiedName());
							if (res == -1) {
								if (checkResemblance(((GASTClass)current).getSimpleName(), ((GASTClass)currentCheck).getSimpleName(), percentage)) {
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

				for (ModelElement currentCheck : elements2) {
					if (currentCheck instanceof GASTClass) {
						if (!resemblanceMap.containsKey(((GASTClass) currentCheck).getSimpleName())) {
							resemblanceMap.put(((GASTClass)currentCheck).getSimpleName(), false);
						}
						int res = resemblancePuffer.get(((GASTClass)current).getQualifiedName()).get(((GASTClass)currentCheck).getQualifiedName());
						if (res == -1) {
							if (checkResemblance(((GASTClass)current).getSimpleName(), ((GASTClass)currentCheck).getSimpleName(), percentage)) {
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
				for (ModelElement currentCheck : elements2) {
					if (!((GASTClass)current).getSimpleName().equals(((GASTClass)currentCheck).getSimpleName())) {
						if (currentCheck instanceof GASTClass) {
							if (!resemblanceMap.containsKey(((GASTClass) currentCheck).getSimpleName())) {
								resemblanceMap.put(((GASTClass)currentCheck).getSimpleName(), false);
							}
							int res = resemblancePuffer.get(((GASTClass)current).getQualifiedName()).get(((GASTClass)currentCheck).getQualifiedName());
							if (res == -1) {
								if (checkResemblance(((GASTClass)current).getSimpleName(), ((GASTClass)currentCheck).getSimpleName(), percentage)) {
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
	 * 2 Strings have a resemblance if they both have a substring with 
	 * length = (length of shorter String)/100*percentage
	 * 
	 * @param a first String
	 * @param b second String
	 * @param percentage the given percentage for a resemblance
	 * @return <code>true</code> if the Strings have a resemblance
	 * <code>false</code> else
	 */
	private static boolean checkResemblance (String a, String b, int percentage) {
		boolean resemblance = false;
		int lengthA = a.length();
		int lengthB = b.length();
		String shortString;
		String longString;
		int neededSubstring = 0;
		int steps = 0;
		
		if (lengthA > lengthB) {
			shortString = b;
			longString = a;
		} else {
			shortString = a;
			longString = b;
		}
		neededSubstring = (int)((double)shortString.length()/100.0*(double)percentage);
		
		for (int i=neededSubstring; i<=shortString.length();i++) {
			steps = shortString.length()+1-i;
			for (int j=0;j<steps;j++) {
				String current = shortString.substring(j, i+j);
				if (longString.contains(current)) {
					resemblance = true;
					i = shortString.length();
					j = steps;
				}
			}
		}
		
		
		return resemblance;
	}
	
	public MetricTab getLaunchConfigurationTab() {
		return new TestMetricTab();
		//return null;
	}

	public MetricID getMID() {
		return new MetricID(122);
	}

	public void initialize(Root root) {
		
		EList<GASTClass> classList = root.getAllNormalClasses();
		for (GASTClass currentClass : classList)  {
			resemblancePuffer.put(currentClass.getQualifiedName(), new HashMap<String,Integer>());
		}
		
		Set<String> keys = resemblancePuffer.keySet();
		
		for (String currentKey : keys) {
			for (GASTClass currentClass : classList) {
				if (!currentKey.equals(currentClass.getQualifiedName())) {
					resemblancePuffer.get(currentKey).put(currentClass.getQualifiedName(), -1);
				}
			}
		}
	}
}
