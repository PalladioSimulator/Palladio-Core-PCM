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
 * Instability metric
 * 
 * @author Grischa Liebel
 *
 */
public class Instability implements Metric {
	protected Set<String> wildcardBlacklist;
	protected Set<String> specifiedBlacklist;
	protected Set<String> wildcardWhitelist;
	protected Set<String> specifiedWhitelist;
	
	/**
	 * Boolean that indicates if blacklist or whitelist is used
	 * If set to <code>true</code> only the blacklist is used
	 * If set to <code>false</code> only the whitelist is used
	 * Default: true (blacklist used)
	 */
	protected boolean blacklistIndicator;	
	
	protected HashSet<String> externNameSet;
	protected HashSet<String> internNameSet;
	
	List<GASTClass> externClasses;
	List<GASTClass> internClasses;

	/**
	 * Default-constructor initializing the blacklists and the namesets
	 */
	public Instability () {
		blacklistIndicator = true;
		wildcardBlacklist = new HashSet<String>();
		specifiedBlacklist = new HashSet<String>();
		wildcardWhitelist = new HashSet<String>();
		specifiedWhitelist = new HashSet<String>();
		externNameSet = new HashSet<String>();
		internNameSet = new HashSet<String>();
		externClasses = new LinkedList<GASTClass>();
		internClasses = new LinkedList<GASTClass>();
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
	public void setBlacklist (HashSet<String> blacklist) {
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
	 * whitelist due to implementation reasons !
	 * 
	 * @param whitelist The String-Set with names that need to be whitelisted. Strings ending with ".*"
	 * are used to whitelist whole Packages, other Strings are used to whitelist single classes
	 */
	public void setWhitelist (HashSet<String> whitelist) {
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
		double efferentCoupling = 0.0;
		double afferentCoupling = 0.0;
		
		extractInternClasses(root,elements1,elements2);		
		extractExternClasses(root);
		
		if (externNameSet == null || externNameSet.size()==0) {
			return 0.0;
		}
		
		for (GASTClass currentClass : externClasses) {
			EList<Access> accesses = DerivationHelper.selectAccessesInSubtree(currentClass);

			for (Access currentAccess : accesses) {
				GASTClass accessedClass = currentAccess.getAccessedClass();

				if (accessedClass != null) {
					if (internNameSet.contains(accessedClass.getQualifiedName())) {
						afferentCoupling += 1.0;
					}
				}
					
			}
		}
		
		for (GASTClass currentClass : internClasses) {
			EList<Access> accesses = DerivationHelper.selectAccessesInSubtree(currentClass);

			for (Access currentAccess : accesses) {
				GASTClass accessedClass = currentAccess.getAccessedClass();
				
				if (accessedClass != null) {
					if (externNameSet.contains(accessedClass.getQualifiedName())) {
						efferentCoupling += 1.0;
					}
				}
			}
		}
		if (afferentCoupling == 0.0 && efferentCoupling == 0.0) {
			return 0.0;
		} else {
			return efferentCoupling/(afferentCoupling + efferentCoupling);
		}
	}
	
	/**
	 * Extracts from the ModelElement lists the non-blacklisted
	 * or whitelisted (depending on blacklistIndicator) classes
	 * 
	 * @param root Root-Object of the Software-Project modeled as GAST-model
	 * @param elements1 First part of the composite component
	 * @param elements2 Second part of the composite component
	 */
	private void extractInternClasses(Root root, List<ModelElement> elements1,
			List<ModelElement> elements2) {
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
							internClasses.add((GASTClass)current);
							internNameSet.add(((GASTClass)current).getQualifiedName());
						}
					}
				} else {
					if (specifiedWhitelist.contains(((GASTClass) current).getQualifiedName())) {
						internClasses.add((GASTClass)current);
						internNameSet.add(((GASTClass)current).getQualifiedName());
					} else {
						boolean contains = false;
						for (String currentWildcard : wildcardWhitelist) {
							if (((GASTClass) current).getQualifiedName().startsWith(currentWildcard)) {
								contains = true;
								break;
							}
						}
						if (contains) {
							internClasses.add((GASTClass)current);
							internNameSet.add(((GASTClass)current).getQualifiedName());
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
							internClasses.add((GASTClass)current);
							internNameSet.add(((GASTClass)current).getQualifiedName());
						}
					}
				} else {
					if (specifiedWhitelist.contains(((GASTClass) current).getQualifiedName())) {
						internClasses.add((GASTClass)current);
						internNameSet.add(((GASTClass)current).getQualifiedName());
					} else {
						boolean contains = false;
						for (String currentWildcard : wildcardWhitelist) {
							if (((GASTClass) current).getQualifiedName().startsWith(currentWildcard)) {
								contains = true;
								break;
							}
						}
						if (contains) {
							internClasses.add((GASTClass)current);
							internNameSet.add(((GASTClass)current).getQualifiedName());
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
	 * @param root Root-Object of the Software-Project modeled as GAST-model
	 */
	protected void extractExternClasses (Root root) {
		List<GASTClass> finalClasses = new LinkedList<GASTClass>();
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
					if (!internNameSet.contains(currentClass.getQualifiedName())) {
						finalClasses.add(currentClass);
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
					if (!internNameSet.contains(currentClass.getQualifiedName())) {
						finalClasses.add(currentClass);
						externNameSet.add(currentClass.getQualifiedName());
					}
				}
			}
		}
		this.externClasses = finalClasses;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public MetricTab getLaunchConfigurationTab() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public MetricID getMID() {
		return new MetricID(4);
	}

	/**
	 * {@inheritDoc}
	 */
	public void initialize(Root root) {		
	}
}
