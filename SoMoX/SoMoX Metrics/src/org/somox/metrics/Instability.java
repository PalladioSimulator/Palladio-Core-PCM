package org.somox.metrics;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import de.fzi.gast.accesses.Access;
import de.fzi.gast.accesses.InheritanceTypeAccess;
import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.functions.Constructor;
import de.fzi.gast.functions.Method;
import de.fzi.gast.statements.BlockStatement;
import de.fzi.gast.statements.Statement;
import de.fzi.gast.types.GASTClass;

public class Instability implements Metric {
	@Override
	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
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

		TreeIterator<EObject> repository = root.eAllContents();
		List<GASTClass> externClasses = new LinkedList<GASTClass>();
		HashSet<String> externNameSet = new HashSet<String>();
		

		while (repository.hasNext()) {
			EObject current = repository.next();
			if (current instanceof GASTClass) {
				if (!internNameSet.contains(((GASTClass)current).getQualifiedName())) {
					externClasses.add((GASTClass)current);
					externNameSet.add(((GASTClass)current).getQualifiedName());
				}
			}
		}

		for (GASTClass current : externClasses) {
			EList<InheritanceTypeAccess> inheritances = ((GASTClass) current).getInheritanceTypeAccesses();
			for (InheritanceTypeAccess currentInheritance : inheritances) {
				if (internNameSet.contains(currentInheritance.getAccessedClass().getQualifiedName())) {
					afferentCoupling += 1.0;
				}
			}
			for (Method currentMethod : current.getMethods()) {
				System.out.println(currentMethod.getAccesses().size());
				for (Access currentAccess : currentMethod.getAccesses()) {
					if (internNameSet.contains(currentAccess.getAccessedClass().getQualifiedName())) {
						afferentCoupling += 1.0;
					}
				}
			}
			for (Constructor currentConstr : current.getConstructors()) {
				System.out.println(currentConstr.getAccesses().size());
				for (Access currentAccess : currentConstr.getAccesses()) {
					if (internNameSet.contains(currentAccess.getAccessedClass().getQualifiedName())) {
						afferentCoupling += 1.0;
					}
				}
			}
		}

		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
				EList<InheritanceTypeAccess> inheritances = ((GASTClass) current).getInheritanceTypeAccesses();
				for (InheritanceTypeAccess currentInheritance : inheritances) {
					if (externNameSet.contains(currentInheritance.getAccessedClass().getQualifiedName())) {
						efferentCoupling += 1.0;
					}
				}
				for (Method currentMethod : ((GASTClass)current).getMethods()) {
					System.out.println(currentMethod.getAccesses().size());
					for (Access currentAccess : currentMethod.getAccesses()) {
						if (externNameSet.contains(currentAccess.getAccessedClass().getQualifiedName())) {
							efferentCoupling += 1.0;
						}
					}
				}
				for (Constructor currentConstr : ((GASTClass)current).getConstructors()) {
					System.out.println(currentConstr.getAccesses().size());
					for (Access currentAccess : currentConstr.getAccesses()) {
						if (externNameSet.contains(currentAccess.getAccessedClass().getQualifiedName())) {
							efferentCoupling += 1.0;
						}
					}
				}
			}
		}

		for (ModelElement current : elements2) {
			if (current instanceof GASTClass) {
				EList<InheritanceTypeAccess> inheritances = ((GASTClass) current).getInheritanceTypeAccesses();
				for (InheritanceTypeAccess currentInheritance : inheritances) {
					if (externNameSet.contains(currentInheritance.getAccessedClass().getQualifiedName())) {
						efferentCoupling += 1.0;
					}
				}
				for (Method currentMethod : ((GASTClass)current).getMethods()) {
					System.out.println(currentMethod.getAccesses().size());
					for (Access currentAccess : currentMethod.getAccesses()) {
						if (externNameSet.contains(currentAccess.getAccessedClass().getQualifiedName())) {
							efferentCoupling += 1.0;
						}
					}
				}
				for (Constructor currentConstr : ((GASTClass)current).getConstructors()) {
					System.out.println(currentConstr.getAccesses().size());
					for (Access currentAccess : currentConstr.getAccesses()) {
						if (externNameSet.contains(currentAccess.getAccessedClass().getQualifiedName())) {
							efferentCoupling += 1.0;
						}
					}
				}
			}
		}
		
		System.out.println("Efferent coupling: " + efferentCoupling);
		System.out.println("Afferent coupling: " + afferentCoupling);

		return efferentCoupling/(afferentCoupling + efferentCoupling);
	}
}
