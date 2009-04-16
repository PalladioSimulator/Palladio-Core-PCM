package org.somox.metrics;


import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import de.fzi.gast.accesses.Access;
import de.fzi.gast.accesses.InheritanceTypeAccess;
import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.functions.Method;
import de.fzi.gast.types.GASTClass;

public class Coupling {
	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		double referencesToOtherElements = 0.0;
		double referencesElse = 0.0;
		double coupling = 0.0;

		HashSet<String> elements1NameSet = new HashSet<String>();
		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
				elements1NameSet.add(((GASTClass)current).getQualifiedName());
			}
		}
		HashSet<String> elements2NameSet = new HashSet<String>();
		for (ModelElement current : elements2) {
			if (current instanceof GASTClass) {
				elements2NameSet.add(((GASTClass)current).getQualifiedName());
			}
		}

		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
				EList<InheritanceTypeAccess> inheritances = ((GASTClass) current).getInheritanceTypeAccesses();
				for (InheritanceTypeAccess currentInheritance : inheritances) {
					if (elements2NameSet.contains(currentInheritance.getAccessedClass().getQualifiedName())) {
						referencesToOtherElements += 1.0;
					} else {
						referencesElse += 1.0;
					}
				}
				for (Method currentMethod : ((GASTClass)current).getMethods()) {
					for (Access currentAccess : currentMethod.getAccesses()) {
						if (elements2NameSet.contains(currentAccess.getAccessedClass().getQualifiedName())) {
							referencesToOtherElements += 1.0;
						} else {
							referencesElse += 1.0;
						}
					}
				}
			}
		}
		
		coupling = referencesToOtherElements/referencesElse;
		
		referencesElse = 0.0;
		referencesToOtherElements = 0.0;

		for (ModelElement current : elements2) {
			if (current instanceof GASTClass) {
				EList<InheritanceTypeAccess> inheritances = ((GASTClass) current).getInheritanceTypeAccesses();
				for (InheritanceTypeAccess currentInheritance : inheritances) {
					if (elements1NameSet.contains(currentInheritance.getAccessedClass().getQualifiedName())) {
						referencesToOtherElements += 1.0;
					} else {
						referencesElse += 1.0;
					}
				}
				for (Method currentMethod : ((GASTClass)current).getMethods()) {
					for (Access currentAccess : currentMethod.getAccesses()) {
						if (elements1NameSet.contains(currentAccess.getAccessedClass().getQualifiedName())) {
							referencesToOtherElements += 1.0;
						} else {
							referencesElse += 1.0;
						}
					}
				}
			}
		}
		
		referencesElse = referencesToOtherElements/referencesElse;
		if (referencesElse > coupling) {
			coupling = referencesElse;
		}

		return coupling;
	}
}
