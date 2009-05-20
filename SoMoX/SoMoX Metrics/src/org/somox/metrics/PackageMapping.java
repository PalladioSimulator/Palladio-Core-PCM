package org.somox.metrics;

import java.util.List;

import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;

/**
 * PackageMapping metric
 * 
 * @author Grischa Liebel
 *
 */
public class PackageMapping implements Metric {

	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		boolean samePackage = true;
		String packageName = null;

		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
				if (packageName == null) {
					packageName = ((GASTClass)current).getSurroundingPackage().getQualifiedName();
				} else {
					if (!((GASTClass)current).getSurroundingPackage().getQualifiedName().equals(packageName)) {
						samePackage = false;
						break;
					}
				}
			}
		}
		if (samePackage) {
			for (ModelElement current : elements2) {
				if (current instanceof GASTClass) {					
					if (packageName == null) {
						packageName = ((GASTClass)current).getSurroundingPackage().getQualifiedName();
					} else {
						if (!((GASTClass)current).getSurroundingPackage().getQualifiedName().equals(packageName)) {
							samePackage = false;
							break;
						}
					}
				}
			}
		}

		if (samePackage) {
			return 1.0;
		} else {
			return 0.0;
		}
	}

	public ILaunchConfigurationTab getLaunchConfigurationTab() {
		// TODO Auto-generated method stub
		return null;
	}

	public MetricID getMID() {
		return new MetricID(6);
	}

	public void initialize(Root root) {
	}
}
