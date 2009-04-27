package org.somox.metrics;

import java.util.List;

import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.emf.common.util.EList;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;

public class SliceLayerArchitectureQuality implements Metric {

	@Override
	public double compute(Root root, List<ModelElement> elements1,
			List<ModelElement> elements2) {

		de.fzi.gast.core.Package prefixPackage = computePrefix(elements1, elements2);
		EList<de.fzi.gast.core.Package> slices = prefixPackage.getSubPackages();
		EList<de.fzi.gast.core.Package> layers = null;

		int max = 0;
		for (de.fzi.gast.core.Package current : slices) {
			if (current.getSubPackages().size()>=max) {
				layers = current.getSubPackages();
				max = layers.size();
			}
		}

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
				return existingSubsystems/expectedSubsystems;
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
	private de.fzi.gast.core.Package computePrefix(List<ModelElement> elements1, List<ModelElement> elements2) {
		String prefix = "";
		boolean prefixFound = false;
		de.fzi.gast.core.Package currentPackage = null;
		
		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
				currentPackage = ((GASTClass)current).getSurroundingPackage();
				break;
			}
		}
		
		if (currentPackage == null) {
			for (ModelElement current : elements2) {
				if (current instanceof GASTClass) {
					currentPackage = ((GASTClass)current).getSurroundingPackage();
					break;
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
					if (!((GASTClass) current).getSurroundingPackage().getQualifiedName().contains(prefix)) {
						prefixFound = false;
						break;
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
					if (!((GASTClass) current).getSurroundingPackage().getQualifiedName().contains(prefix)) {
						prefixFound = false;
						break;
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
	
	@Override
	public ILaunchConfigurationTab getLaunchConfigurationTab() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MetricID getMetricID() {
		return new MetricID(0);
	}

}
