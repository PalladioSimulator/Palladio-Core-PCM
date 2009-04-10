package org.somox.metrics;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.query.conditions.booleans.BooleanCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;
import de.fzi.gast.types.typesPackage;

public class Abstractness {
	public static double compute (Root root, ModelElement [] elements1, ModelElement [] elements2) {
		double abstractness = 0.0;
		
		List<GASTClass> elementList = new LinkedList<GASTClass>();
		
		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
				elementList.add((GASTClass)current);

			}
		}
		for (ModelElement current : elements2) {
			if (current instanceof GASTClass) {
				elementList.add((GASTClass)current);
			}
		}
		EObjectAttributeValueCondition abstractCondition = new EObjectAttributeValueCondition(typesPackage.eINSTANCE.getMember_Abstract(), new BooleanCondition(true));
		EObjectAttributeValueCondition interfaceCondition = new EObjectAttributeValueCondition(typesPackage.eINSTANCE.getGASTClass_Interface(), new BooleanCondition(true));
		SELECT abstractnessQuery = new SELECT(new FROM(elementList), new WHERE(abstractCondition.OR(interfaceCondition)));
		
		IQueryResult result = abstractnessQuery.execute();
		
		abstractness = (double)result.size()/(double)elementList.size();
		
		return abstractness;
	}
}