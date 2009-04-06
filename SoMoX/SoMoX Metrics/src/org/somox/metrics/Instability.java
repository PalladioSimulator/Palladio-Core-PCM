package org.somox.metrics;

import java.util.LinkedList;

import org.eclipse.emf.common.util.EList;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;

public class Instability {
	public static double compute (Root root, ModelElement [] elements1, ModelElement [] elements2) {
		double efferentCoupling = 0.0;
		double afferentCoupling = 0.0;
		
		ModelElement[] allElements = new ModelElement[elements1.length + elements2.length];
		System.arraycopy(elements1, 0, allElements, 0, elements1.length);
		System.arraycopy(elements2, 0, allElements, elements1.length, elements2.length);
		LinkedList<String> fqnList = new LinkedList<String>();
		EList<GASTClass> friendlyList = null;
		
		for (ModelElement current : allElements) {
			if (current instanceof GASTClass) {
				fqnList.add(((GASTClass) current).getQualifiedName());
			}
		}
		
		for (ModelElement element : elements1) {
			GASTClass gClass1 = null;

			if (element instanceof GASTClass) {
				gClass1 = (GASTClass)element;
				if (friendlyList == null) {
					friendlyList = gClass1.getFriendClasses();
				} else {
					friendlyList.addAll(gClass1.getFriendClasses());
				}
			}
		}
		
		for (ModelElement element : elements2) {
			GASTClass gClass1 = null;

			if (element instanceof GASTClass) {
				gClass1 = (GASTClass)element;
				if (friendlyList == null) {
					friendlyList = gClass1.getFriendClasses();
				} else {
					friendlyList.addAll(gClass1.getFriendClasses());
				}
			}
		}
		
		for (GASTClass currentClass : friendlyList) {
			if (!(fqnList.contains(currentClass.getQualifiedName()))) {
				efferentCoupling = efferentCoupling + 1.0;
			}
		}
		
		EList<ModelElement> totalElements = root.getRepository().getModelElements();
		EList<GASTClass> outsideFriendlyClasses = null;
		
		for (ModelElement current : totalElements) {
			if (current instanceof GASTClass) {
				if (!(fqnList.contains(((GASTClass)current).getQualifiedName()))) {
					if (outsideFriendlyClasses == null) {
						outsideFriendlyClasses = ((GASTClass)current).getFriendClasses();
					} else {
						outsideFriendlyClasses.addAll(((GASTClass)current).getFriendClasses());
					}
				}
			}
		}
		
		for (GASTClass current : outsideFriendlyClasses) {
			if (fqnList.contains(current.getQualifiedName())) {
				afferentCoupling = afferentCoupling + 1.0;
			}
		}
		
		return (efferentCoupling)/(efferentCoupling+afferentCoupling);
	}
}
