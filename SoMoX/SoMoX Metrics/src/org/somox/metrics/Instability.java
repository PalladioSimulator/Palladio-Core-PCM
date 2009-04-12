package org.somox.metrics;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import de.fzi.gast.accesses.Access;
import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.functions.Method;
import de.fzi.gast.types.GASTClass;

public class Instability {
	public static double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		double efferentCoupling = 0.0;
		double afferentCoupling = 0.0;

		HashSet<String> internNameSet = new HashSet<String>();
		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
				internNameSet.add(((GASTClass)current).getQualifiedName());
			}
		}
		for (ModelElement current : elements2) {
			if (current instanceof GASTClass) {
				internNameSet.add(((GASTClass)current).getQualifiedName());
			}
		}

		EList<ModelElement> elementList = root.getRepository().getModelElements();
		List<GASTClass> externClasses = new LinkedList<GASTClass>();
		HashSet<String> externNameSet = new HashSet<String>();

		for (ModelElement current : elementList) {
			if (current instanceof GASTClass) {
				if (!internNameSet.contains(((GASTClass)current).getQualifiedName())) {
					externClasses.add((GASTClass)current);
					externNameSet.add(((GASTClass)current).getQualifiedName());
				}
			}
		}

		for (GASTClass current : externClasses) {
			for (Method currentMethod : current.getMethods()) {
				for (Access currentAccess : currentMethod.getAccesses()) {
					if (internNameSet.contains(currentAccess.getAccessedClass().getQualifiedName())) {
						afferentCoupling += 1.0;
					}
				}
			}
		}

		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
				for (Method currentMethod : ((GASTClass)current).getMethods()) {
					for (Access currentAccess : currentMethod.getAccesses()) {
						if (externNameSet.contains(currentAccess.getAccessedClass().getQualifiedName())) {
							efferentCoupling += 1.0;
						}
					}
				}
			}
		}

		for (ModelElement current : elements2) {
			if (current instanceof GASTClass) {
				for (Method currentMethod : ((GASTClass)current).getMethods()) {
					for (Access currentAccess : currentMethod.getAccesses()) {
						if (externNameSet.contains(currentAccess.getAccessedClass().getQualifiedName())) {
							efferentCoupling += 1.0;
						}
					}
				}
			}
		}

		return efferentCoupling/(afferentCoupling + efferentCoupling);
	}
}
