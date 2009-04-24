package org.somox.metrics;

import java.util.HashMap;
import java.util.List;

import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;

public class NameResemblance implements Metric {

	/**
	 * The percentage is used to determine how much percent of 2 Strings 
	 * need to be equal so that these Strings are treated to have a name resemblance 
	 */
	protected int percentage = 80;
	
	
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
	
	@Override
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
							if (checkResemblance(((GASTClass)current).getSimpleName(), ((GASTClass)currentCheck).getSimpleName(), percentage)) {
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
						if (checkResemblance(((GASTClass)current).getSimpleName(), ((GASTClass)currentCheck).getSimpleName(), percentage)) {
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
							if (checkResemblance(((GASTClass)current).getSimpleName(), ((GASTClass)currentCheck).getSimpleName(), percentage)) {
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
	
	@Override
	public ILaunchConfigurationTab getLaunchConfigurationTab() {
		// TODO Auto-generated method stub
		return null;
	}
}
