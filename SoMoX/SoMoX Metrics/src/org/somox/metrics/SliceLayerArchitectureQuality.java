package org.somox.metrics;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;

/**
 * SliceLayerArchitectureQuality (SLAQ) metric
 * 
 * @author Grischa Liebel
 *
 */
public class SliceLayerArchitectureQuality implements Metric {

	/**
	 * {@inheritDoc}
	 */
	public double compute(Root root, List<GASTClass> elements1,
			List<GASTClass> elements2) {

		//compute overall prefix
		de.fzi.gast.core.Package prefixPackage = computePrefix(elements1, elements2);
		
		if (prefixPackage == null) {
			return 0.0;
		}
		EList<de.fzi.gast.core.Package> slices = prefixPackage.getSubPackages();
		EList<de.fzi.gast.core.Package> layers = null;

		//compute the maximum number of layers in a slice
		int max = 0;
		for (de.fzi.gast.core.Package current : slices) {
			if (current.getSubPackages().size()>=max) {
				layers = current.getSubPackages();
				max = layers.size();
			}
		}

		//check how many of the computed layers exist in every slice 
		if (max == 0) {
			return 1.0;
		} else {
			int expectedSubsystems = slices.size()*layers.size();
			int existingSubsystems = 0;
			
			for (de.fzi.gast.core.Package currentSlice : slices) {
				EList<de.fzi.gast.core.Package> currentLayers = currentSlice.getSubPackages();
				for (de.fzi.gast.core.Package currentReferencePackage : layers) {
					for (de.fzi.gast.core.Package currentLayer : currentLayers) {
						if (currentLayer.getSimpleName().equals(currentReferencePackage.getSimpleName())) {
							existingSubsystems++;
							break;
						}
					}
				}
			}
			
			if (expectedSubsystems == 0) {
				return 1.0;
			} else {
				return (double)existingSubsystems/(double)expectedSubsystems;
			}
		}
	}
	
	/**
	 * Computes the longest prefix for the given elements
	 * 
	 * @param elements1 first list of elements
	 * @param elements2 second list of elements
	 * @return the last package in the package-hierarchy in which all elements are included
	 */
	private de.fzi.gast.core.Package computePrefix(List<GASTClass> elements1, List<GASTClass> elements2) {
		String prefix = "";
		boolean prefixFound = false;
		de.fzi.gast.core.Package currentPackage = null;
		
		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
				if (((GASTClass)current).getSurroundingPackage() != null) {
					currentPackage = ((GASTClass)current).getSurroundingPackage();
					break;
				}
			}
		}
		
		if (currentPackage == null) {
			for (ModelElement current : elements2) {
				if (current instanceof GASTClass) {
					if (((GASTClass)current).getSurroundingPackage() != null) {
						currentPackage = ((GASTClass)current).getSurroundingPackage();
						break;
					}
				}
			}
		}
		
		if (currentPackage == null) {
			return null;
		}
		
		prefix = currentPackage.getQualifiedName();
		
		while(!prefixFound) {
			prefixFound = true;
			
			for (ModelElement current : elements1) {
				if (current instanceof GASTClass) {
					if (!((GASTClass) current).isInner()) {
						if (((GASTClass)current).getSurroundingPackage() != null) {
							if (!((GASTClass) current).getSurroundingPackage().getQualifiedName().contains(prefix)) {
								prefixFound = false;
								break;
							}
						}
					}
				}
			}
			
			if (!prefixFound) {
				currentPackage = currentPackage.getSurroundingPackage();
				if (currentPackage == null) {
					return null;
				} else {
					prefix = currentPackage.getQualifiedName();
				}
			}
		}
		prefixFound = false;
		
		while(!prefixFound) {
			prefixFound = true;
			
			for (ModelElement current : elements2) {
				if (current instanceof GASTClass) {
					if (!((GASTClass) current).isInner()) {
						if (((GASTClass)current).getSurroundingPackage() != null) {
							if (!((GASTClass) current).getSurroundingPackage().getQualifiedName().contains(prefix)) {
								prefixFound = false;
								break;
							}
						}
					}
				}
			}
			
			if (!prefixFound) {
				currentPackage = currentPackage.getSurroundingPackage();
				if (currentPackage == null) {
					return null;
				} else {
					prefix = currentPackage.getQualifiedName();
				}
			}
		}
		return currentPackage;
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
		return new MetricID(7);
	}

	/**
	 * {@inheritDoc}
	 */
	public void initialize(Root root) {
		
	}

}
