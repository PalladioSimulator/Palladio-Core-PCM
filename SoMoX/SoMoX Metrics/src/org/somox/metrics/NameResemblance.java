package org.somox.metrics;

import java.util.List;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;

public class NameResemblance {
	public static double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2, int percentage) {
		double nameResemblance = 0.0;
		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
				boolean resemblance = false;
				for (ModelElement currentCheck : elements1) {
					if (currentCheck instanceof GASTClass) {
						if (checkResemblance(((GASTClass)current).getSimpleName(), ((GASTClass)currentCheck).getSimpleName(), percentage)) {
							resemblance = true;
							break;
						}
					}
				}
				
				if (resemblance == false) {
					for (ModelElement currentCheck : elements2) {
						if (currentCheck instanceof GASTClass) {
							if (checkResemblance(((GASTClass)current).getSimpleName(), ((GASTClass)currentCheck).getSimpleName(), percentage)) {
								resemblance = true;
								break;
							}
						}
					}
				}
				
				if (resemblance) {
					nameResemblance += 1.0;
				}
			}
		}
		
		for (ModelElement current : elements2) {
			if (current instanceof GASTClass) {
				boolean resemblance = false;
				for (ModelElement currentCheck : elements1) {
					if (currentCheck instanceof GASTClass) {
						if (checkResemblance(((GASTClass)current).getSimpleName(), ((GASTClass)currentCheck).getSimpleName(), percentage)) {
							resemblance = true;
							break;
						}
					}
				}
				
				if (resemblance == false) {
					for (ModelElement currentCheck : elements2) {
						if (currentCheck instanceof GASTClass) {
							if (checkResemblance(((GASTClass)current).getSimpleName(), ((GASTClass)currentCheck).getSimpleName(), percentage)) {
								resemblance = true;
								break;
							}
						}
					}
				}
				
				if (resemblance) {
					nameResemblance += 1.0;
				}
			}
		}
		
		double totalSize = elements1.size() + elements2.size();
		
		return nameResemblance/totalSize;
	}
	
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
			steps = shortString.length()-i;
			for (int j=0;j<steps;j++) {
				String current = shortString.substring(j, i-1);
				if (longString.contains(current)) {
					resemblance = true;
					i = shortString.length();
					j = steps;
				}
			}
		}
		
		
		return resemblance;
	}
}
