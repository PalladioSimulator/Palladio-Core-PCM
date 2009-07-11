package org.somox.metrics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Package;
import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;

/**
 * SubsystemComponent metric
 * 
 * @author Grischa Liebel
 *
 */
public class SubsystemComponent implements Metric {
	protected Set<String> wildcardBlacklist;
	protected Set<String> wildcardWhitelist;
	
	/**
	 * Boolean that indicates if blacklist or whitelist is used
	 * If set to <code>true</code> only the blacklist is used
	 * If set to <code>false</code> only the whitelist is used
	 * Default: true (blacklist used)
	 */
	protected boolean blacklistIndicator;	
	
	/**
	 * Default-constructor initializing the namesets
	 */
	public SubsystemComponent () {
		blacklistIndicator = true;
		wildcardBlacklist = new HashSet<String>();
		wildcardWhitelist = new HashSet<String>();
	}
	
	/**
	 * Setter method for the name-blacklist
	 * 
	 * This method is used to set the "blacklist" for class- and Package-Names
	 * in the Project. The blacklistIndicator is set to <code>true</code> automatically.
	 * By setting the blacklist, the whitelist won't be used in the computation.
	 * 
	 * Be aware that computing the metric by using a blacklist is probably faster than using a 
	 * whitelist due to implementation reasons !
	 * 
	 * @param blacklist The String-Set with names that need to be blacklisted.
	 */
	public void setBlacklist (Set<String> blacklist) {
		blacklistIndicator = true;
		for (String current : blacklist) {
			if (current.endsWith(".*")) {
				wildcardBlacklist.add(current.substring(0, current.length()-2));
			} else {
				wildcardBlacklist.add(current);
			}
		}
	}
	
	/**
	 * Setter-method for the blacklist indicator. If set to <code>true</code> the blacklist is used,
	 * if set to <code>false</code> the whitelist is used
	 * 
	 * @param blacklistIndicator The indicator
	 */
	public void setBlacklistIndicator (boolean blacklistIndicator) {
		this.blacklistIndicator = blacklistIndicator;
	}
	
	/**
	 * Setter method for the name-whitelist
	 * 
	 * This method is used to set the "whitelist" for class- and Package-Names
	 * in the Project. The blacklistIndicator is set to <code>false</code> automatically.
	 * By setting the whitelist, the blacklist won't be used in the computation.
	 * 
	 * Be aware that computing the metric by using a blacklist is probably faster than using a 
	 * whitelist due to implementation reasons!
	 * 
	 * @param whitelist The String-Set with names that need to be whitelisted.
	 */
	public void setWhitelist (Set<String> whitelist) {
		blacklistIndicator = false;
		for (String current : whitelist) {
			if (current.endsWith(".*")) {
				wildcardWhitelist.add(current.substring(0, current.length()-2));
			} else {
				wildcardWhitelist.add(current);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public double compute(Root root, List<GASTClass> elements1,
			List<GASTClass> elements2) {
		//compute overall prefix
		Package prefixPackage = computePrefix(root.getPackages());
		
		if (prefixPackage == null) {
			return 0.0;
		}
		
		EList<de.fzi.gast.core.Package> slices = prefixPackage.getSubPackages();
		EList<de.fzi.gast.core.Package> layers = null;
		
		String subLayer = null;
		
		//compute the maximum number of layers in a slice
		int max = 0;
		for (Package current : slices) {
			if (current.getSubPackages().size()>=max) {
				layers = current.getSubPackages();
				max = layers.size();
			}
		}
		
		//0 expected Subsystems, return 0.0
		if (max == 0 || layers.size() == 0 || layers == null) {
			return 0.0;
		}
		
		for (ModelElement currentElement : elements1) {
			if (currentElement instanceof GASTClass) {
				Package currentPackage = ((GASTClass)currentElement).getSurroundingPackage();

				if (currentPackage != null) {
					if (subLayer == null) {
						for (Package slicePackage : slices) {
							if (currentPackage.getQualifiedName().startsWith(slicePackage.getQualifiedName())) {
								for (Package layerPackage : layers) {
									if (currentPackage.getQualifiedName().startsWith(slicePackage.getQualifiedName() + "." + layerPackage.getSimpleName())) {
										subLayer = slicePackage.getQualifiedName() + "." + layerPackage.getSimpleName();
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
		}
		
		for (ModelElement currentElement : elements2) {
			if (currentElement instanceof GASTClass) {
				Package currentPackage = ((GASTClass)currentElement).getSurroundingPackage();
				if (currentPackage != null) {
					if (subLayer == null) {
						for (Package slicePackage : slices) {
							if (currentPackage.getQualifiedName().startsWith(slicePackage.getQualifiedName())) {
								for (Package layerPackage : layers) {
									if (currentPackage.getQualifiedName().startsWith(slicePackage.getQualifiedName() + "." + layerPackage.getSimpleName())) {
										subLayer = slicePackage.getQualifiedName() + "." + layerPackage.getSimpleName();
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
		}
		
		SliceLayerArchitectureQuality slaq = new SliceLayerArchitectureQuality();
		return slaq.compute(root, elements1, elements2);
	}

	/**
	 * {@inheritDoc}
	 */
	public MetricTab getLaunchConfigurationTab() {
		return new SubsystemComponentTab();
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
			if (blacklistIndicator) {
				for (String currentWildcard : wildcardBlacklist) {
					if (current.getQualifiedName().startsWith(currentWildcard) || current.getQualifiedName().equals(currentWildcard)) {
						iterator.remove();
						break;
					}
				}
			} else {
				for (String currentWildcard : wildcardWhitelist) {
					if (!current.getQualifiedName().startsWith(currentWildcard) && !current.getQualifiedName().equals(currentWildcard)) {
						iterator.remove();
						break;
					}
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

	/**
	 * {@inheritDoc}
	 */
	public MetricID getMID() {
		return new MetricID(8);
	}

	/**
	 * {@inheritDoc}
	 */
	public void initialize(Root root) {		
	}
}
