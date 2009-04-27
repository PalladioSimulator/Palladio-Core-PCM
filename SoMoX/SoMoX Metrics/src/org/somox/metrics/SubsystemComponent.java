package org.somox.metrics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.emf.common.util.EList;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Package;
import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;

public class SubsystemComponent implements Metric {
	protected Set<String> wildcardBlacklist;
	protected Set<String> specifiedBlacklist;
	
	public SubsystemComponent () {
		wildcardBlacklist = new HashSet<String>();
		specifiedBlacklist = new HashSet<String>();
	}
	
	/**
	 * Setter method for the name-blacklist
	 * 
	 * This method is used to set the "blacklist" for class- and Package-Names
	 * in the Project.
	 * 
	 * @param blacklist The String-Set with names that need to be blacklisted. Strings ending with ".*"
	 * are used to blacklist whole Packages, other Strings are used to blacklist single classes
	 */
	public void setBlacklist (HashSet<String> blacklist) {		
		for (String current : blacklist) {
			if (current.endsWith(".*")) {
				wildcardBlacklist.add(current.substring(0, current.length()-2));
			} else {
				specifiedBlacklist.add(current);
			}
		}
	}

	@Override
	public double compute(Root root, List<ModelElement> elements1,
			List<ModelElement> elements2) {
		Package prefixPackage = computePrefix(root.getPackages());
		
		if (prefixPackage == null) {
			return 0.0;
		}
		
		EList<de.fzi.gast.core.Package> slices = prefixPackage.getSubPackages();
		EList<de.fzi.gast.core.Package> layers = null;
		
		String subLayer = null;
		
		int max = 0;
		for (Package current : slices) {
			if (current.getSubPackages().size()>=max) {
				layers = current.getSubPackages();
				max = layers.size();
			}
		}
		
		if (max == 0 || layers.size() == 0 || layers == null) {
			System.out.println("NULL");
			return 0.0;
		}
		
		for (ModelElement currentElement : elements1) {
			if (currentElement instanceof GASTClass) {
				Package currentPackage = ((GASTClass)currentElement).getSurroundingPackage();
				if (subLayer == null) {
					for (Package slicePackage : slices) {
						if (currentPackage.getQualifiedName().startsWith(slicePackage.getQualifiedName())) {
							for (Package layerPackage : layers) {
								if (currentPackage.getQualifiedName().startsWith(slicePackage.getQualifiedName() + "." + layerPackage.getSimpleName())) {
									subLayer = slicePackage.getQualifiedName() + layerPackage.getSimpleName();
									break;
								}
							}
							break;
						}
					}
				} else {
					if (!currentPackage.getQualifiedName().startsWith(subLayer)) {
						return 0.0;
					}
				}
			}
		}
		
		for (ModelElement currentElement : elements2) {
			if (currentElement instanceof GASTClass) {
				Package currentPackage = ((GASTClass)currentElement).getSurroundingPackage();
				if (subLayer == null) {
					for (Package slicePackage : slices) {
						if (currentPackage.getQualifiedName().startsWith(slicePackage.getQualifiedName())) {
							for (Package layerPackage : layers) {
								if (currentPackage.getQualifiedName().startsWith(slicePackage.getQualifiedName() + "." + layerPackage.getSimpleName())) {
									subLayer = slicePackage.getQualifiedName() + layerPackage.getSimpleName();
									break;
								}
							}
							break;
						}
					}
				} else {
					if (!currentPackage.getQualifiedName().startsWith(subLayer)) {
						return 0.0;
					}
				}
			}
		}
		
		SliceLayerArchitectureQuality slaq = new SliceLayerArchitectureQuality();
		return slaq.compute(root, elements1, elements2);
	}

	@Override
	public ILaunchConfigurationTab getLaunchConfigurationTab() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Computes the longest prefix for the given packages excluding the blacklisted packages and classes
	 * 
	 * @param packages a given package-hierarchy
	 * @return the last package in the package-hierarchy in which all non-blacklisted elements are included
	 */
	protected Package computePrefix (EList<Package> packages) {
		
		if (packages == null || packages.size() == 0) {
			return null;
		}
		
		java.util.ListIterator<Package> iterator = packages.listIterator();
		
		while (iterator.hasNext()) {
			Package current = iterator.next();
			for (String currentWildcard : wildcardBlacklist) {
				if (current.getQualifiedName().startsWith(currentWildcard)) {
					iterator.remove();
					break;
				}
			}
		}
		
		if (packages.size() != 1) {
			return null;
		} else {
			EList<Package> subList = null;
			for (Package current : packages) {
				subList = current.getSubPackages();
			}
			
			Package sub = computePrefix(subList);
			
			if (sub == null) {
				for (Package current : packages) {
					sub = current;
				}
			}
			return sub;
		}
	}

	@Override
	public MetricID getMetricID() {
		return new MetricID(0);
	}
}
