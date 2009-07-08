package org.somox.metrics;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import de.fzi.gast.accesses.Access;
import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.helpers.DerivationHelper;
import de.fzi.gast.types.GASTClass;

/**
 * Coupling metric
 * 
 * @author Grischa Liebel
 *
 */
/**
 * @author fish
 *
 */
public class Coupling implements Metric {
	protected Set<String> wildcardBlacklist;
	protected Set<String> specifiedBlacklist;
	protected Set<String> wildcardWhitelist;
	protected Set<String> specifiedWhitelist;
	protected List<GASTClass> componentAClasses;
	protected List<GASTClass> componentBClasses;
	
	/**
	 * Boolean that indicates if blacklist or whitelist is used
	 * If set to <code>true</code> only the blacklist is used
	 * If set to <code>false</code> only the whitelist is used
	 * Default: true (blacklist used)
	 */
	protected boolean blacklistIndicator;	
	
	protected HashSet<String> externNameSet;
	protected HashSet<String> componentANameSet, componentBNameSet;

	/**
	 * Default-constructor initializing the blacklists and the namesets
	 */
	public Coupling () {
		blacklistIndicator = true;
		wildcardWhitelist = new HashSet<String>();
		specifiedWhitelist = new HashSet<String>();
		wildcardBlacklist = new HashSet<String>();
		specifiedBlacklist = new HashSet<String>();
		externNameSet = new HashSet<String>();
		componentANameSet = new HashSet<String>();
		componentBNameSet = new HashSet<String>();
		componentAClasses = new LinkedList<GASTClass>();
		componentBClasses = new LinkedList<GASTClass>();
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
	 * Setter method for the name-blacklist
	 * 
	 * This method is used to set the "blacklist" for class- and Package-Names
	 * in the Project. The blacklistIndicator is set to <code>true</code> automatically.
	 * By setting the blacklist, the whitelist won't be used in the computation.
	 * 
	 * Be aware that computing the metric by using a blacklist is probably faster than using a 
	 * whitelist due to implementation reasons !
	 * 
	 * @param blacklist The String-Set with names that need to be blacklisted. Strings ending with ".*"
	 * are used to blacklist whole Packages, other Strings are used to blacklist single classes
	 */
	public void setBlacklist (Set<String> blacklist) {
		blacklistIndicator = true;
		for (String current : blacklist) {
			if (current.endsWith(".*")) {
				wildcardBlacklist.add(current.substring(0, current.length()-2));
			} else {
				specifiedBlacklist.add(current);
			}
		}
	}
	
	/**
	 * Setter method for the name-whitelist
	 * 
	 * This method is used to set the "whitelist" for class- and Package-Names
	 * in the Project. The blacklistIndicator is set to <code>false</code> automatically.
	 * By setting the whitelist, the blacklist won't be used in the computation.
	 * 
	 * Be aware that computing the metric by using a blacklist is probably faster than using a 
	 * whitelist due to implementation reasons !
	 * 
	 * @param whitelist The String-Set with names that need to be whitelisted. Strings ending with ".*"
	 * are used to whitelist whole Packages, other Strings are used to whitelist single classes
	 */
	public void setWhitelist (Set<String> whitelist) {
		blacklistIndicator = false;
		for (String current : whitelist) {
			if (current.endsWith(".*")) {
				wildcardWhitelist.add(current.substring(0, current.length()-2));
			} else {
				specifiedWhitelist.add(current);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		double referencesToOtherComp = 0.0;
		double referencesToWholeProject = 0.0;
		double coupling = 0.0;
		
		extractLists(root, elements1, elements2);
		extractExternClasses(root);
		
		if (externNameSet == null || externNameSet.size()==0) {
			return 0.0;
		}
		
		for (GASTClass currentClass : componentAClasses) {
			EList<Access> accesses = DerivationHelper.selectAccessesInSubtree(currentClass);

			for (Access currentAccess : accesses) {
				GASTClass accessedClass = currentAccess.getAccessedClass();
				
				if (accessedClass != null) {
					if (componentBNameSet.contains(accessedClass.getQualifiedName())) {
						referencesToOtherComp += 1.0;
						referencesToWholeProject += 1.0;
					} else if (externNameSet.contains(accessedClass.getQualifiedName())) {
						referencesToWholeProject += 1.0;
					}
				}
			}
		}
		
		if (referencesToWholeProject != 0.0) {
			coupling = referencesToOtherComp/referencesToWholeProject;
		}
		
		referencesToOtherComp = 0.0;
		referencesToWholeProject = 0.0;
		
		return coupling;

	}
	
	/**
	 * Extracts from the ModelElement lists the non-blacklisted
	 * or whitelisted (depending on blacklistIndicator) classes
	 * 
	 * @param root Root-Object of the Software-Project modeled as GAST-model
	 * @param elements1 First part of the composite component
	 * @param elements2 Second part of the composite component
	 */
	private void extractLists(Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
				if (blacklistIndicator) {
					if (!specifiedBlacklist.contains(((GASTClass) current).getQualifiedName())) {
						boolean contains = false;
						for (String currentWildcard : wildcardBlacklist) {
							if (((GASTClass) current).getQualifiedName().startsWith(currentWildcard)) {
								contains = true;
								break;
							}
						}
						if (!contains) {
							componentAClasses.add((GASTClass)current);
							componentANameSet.add(((GASTClass)current).getQualifiedName());
						}
					}
				} else {
					if (specifiedWhitelist.contains(((GASTClass) current).getQualifiedName())) {
						componentAClasses.add((GASTClass)current);
						componentANameSet.add(((GASTClass)current).getQualifiedName());
					} else {
						boolean contains = false;
						for (String currentWildcard : wildcardWhitelist) {
							if (((GASTClass) current).getQualifiedName().startsWith(currentWildcard)) {
								contains = true;
								break;
							}
						}
						if (contains) {
							componentAClasses.add((GASTClass)current);
							componentANameSet.add(((GASTClass)current).getQualifiedName());
						}
					}
				}
			}
		}
		for (ModelElement current : elements2) {
			if (current instanceof GASTClass) {
				if (blacklistIndicator) {
					if (!specifiedBlacklist.contains(((GASTClass) current).getQualifiedName())) {
						boolean contains = false;
						for (String currentWildcard : wildcardBlacklist) {
							if (((GASTClass) current).getQualifiedName().startsWith(currentWildcard)) {
								contains = true;
								break;
							}
						}
						if (!contains) {
							componentBClasses.add((GASTClass)current);
							componentBNameSet.add(((GASTClass)current).getQualifiedName());
						}
					}
				} else {
					if (specifiedWhitelist.contains(((GASTClass) current).getQualifiedName())) {
						componentBClasses.add((GASTClass)current);
						componentBNameSet.add(((GASTClass)current).getQualifiedName());
					} else {
						boolean contains = false;
						for (String currentWildcard : wildcardWhitelist) {
							if (((GASTClass) current).getQualifiedName().startsWith(currentWildcard)) {
								contains = true;
								break;
							}
						}
						if (contains) {
							componentBClasses.add((GASTClass)current);
							componentBNameSet.add(((GASTClass)current).getQualifiedName());
						}
					}
				}
			}
		}
	}

	/**
	 * Extracts all non-black- or whitelisted classes that are not in the
	 * component namesets
	 * 
	 * @param root The Root-Object
	 */
	protected void extractExternClasses (Root root) {
		List<GASTClass> externClasses = new LinkedList<GASTClass>();
		
		externClasses = root.getAllNormalClasses();
		externClasses.addAll(root.getAllInterfaces());
		externClasses.addAll(root.getAllInnerClasses());
		
		for (GASTClass currentClass : externClasses) {
			if (blacklistIndicator) {
				boolean contains = false;
				for (String currentWildcard : wildcardBlacklist) {
					if (currentClass.getQualifiedName().startsWith(currentWildcard) || specifiedBlacklist.contains(currentClass.getQualifiedName())) {
						contains = true;
						break;
					}
				}
				if (!contains) {
					if (!componentANameSet.contains(currentClass.getQualifiedName()) && !componentBNameSet.contains(currentClass.getQualifiedName())) {
						externNameSet.add(currentClass.getQualifiedName());
					}

				}
			} else {
				boolean contains = false;
				for (String currentWildcard : wildcardWhitelist) {
					if (currentClass.getQualifiedName().startsWith(currentWildcard) || specifiedWhitelist.contains(currentClass.getQualifiedName())) {
						contains = true;
						break;
					}
				}
				if (contains) {
					if (!componentANameSet.contains(currentClass.getQualifiedName()) && !componentBNameSet.contains(currentClass.getQualifiedName())) {
						externNameSet.add(currentClass.getQualifiedName());
					}
				}
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public MetricTab getLaunchConfigurationTab() {
		return new CouplingTab();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public MetricID getMID() {
		return new MetricID(2342);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void initialize(Root root) {
		
	}
}
