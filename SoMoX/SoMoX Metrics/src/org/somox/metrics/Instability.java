package org.somox.metrics;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.emf.common.util.EList;

import de.fzi.gast.accesses.Access;
import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Package;
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
	protected HashSet<String> externNameSet;
	protected HashSet<String> internNameSet;

	/**
	 * Default-constructor initializing the blacklists and the namesets
	 */
	public Instability () {
		wildcardBlacklist = new HashSet<String>();
		specifiedBlacklist = new HashSet<String>();
		externNameSet = new HashSet<String>();
		internNameSet = new HashSet<String>();
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
	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		double efferentCoupling = 0.0;
		double afferentCoupling = 0.0;
		
		List<GASTClass> externClasses = new LinkedList<GASTClass>();
		List<GASTClass> internClasses = new LinkedList<GASTClass>();
		
		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
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
			}
		}
		for (ModelElement current : elements2) {
			if (current instanceof GASTClass) {
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
			}
		}

		
		EList<Package> packages = root.getPackages();
		
		externClasses = extractExternClasses(packages);
		if (externClasses == null || externClasses.size()==0) {
			return 0.0;
		}
		
		for (GASTClass currentClass : externClasses) {
			EList<Access> accesses = DerivationHelper.selectAccessesInSubtree(currentClass);

			for (Access currentAccess : accesses) {
				GASTClass accessedClass = currentAccess.getAccessedClass();

				if (accessedClass != null) {
					if (internNameSet.contains(accessedClass.getQualifiedName())) {
						afferentCoupling += 1.0;
						System.out.println("ACCESS from " + currentClass.getQualifiedName() + " to " + accessedClass.getQualifiedName());
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
						System.out.println("ACCESS from " + currentClass.getQualifiedName() + " to " + accessedClass.getQualifiedName());
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
	 * Extracts all non-blacklisted Classes from a given package-EList
	 * that are not included in the given ModelElement-lists 
	 * 
	 * @param packages The EList containing the packages that need to be searched
	 * @return a list of GASTClasses that are non-blacklisted an not included in 
	 * the ModelElement-lists given as parameters in the compute-method
	 */
	protected List<GASTClass> extractExternClasses (EList<Package> packages) {
		List<GASTClass> externClasses = new LinkedList<GASTClass>();
		
		if (packages == null || packages.size() == 0) {
			return externClasses;
		}
		
		for (Package current : packages) {
			boolean contains = false;
			for (String currentWildcard : wildcardBlacklist) {
				if (current.getQualifiedName().startsWith(currentWildcard)) {
					contains = true;
					break;
				}
			}
			if (!contains) {
				EList<GASTClass> packageClasses = current.getClasses();
				for (GASTClass currentClass : packageClasses) {
					if (!specifiedBlacklist.contains(currentClass.getQualifiedName())) {
						if (!internNameSet.contains(currentClass.getQualifiedName())) {
							externClasses.add(currentClass);
							externNameSet.add(currentClass.getQualifiedName());
						}
						
					}
				}
				externClasses.addAll(extractExternClasses(current.getSubPackages()));
			}
		}
		
		return externClasses;
	}
	
	@Override
	public ILaunchConfigurationTab getLaunchConfigurationTab() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MetricID getMID() {
		return new MetricID(4);
	}
}
