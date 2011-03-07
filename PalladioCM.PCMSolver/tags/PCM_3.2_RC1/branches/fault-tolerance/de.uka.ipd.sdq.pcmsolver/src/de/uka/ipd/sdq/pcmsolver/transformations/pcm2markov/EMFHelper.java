package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.TypeRelation;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;

/**
 * Provides utility functions for EMF models.
 * 
 * @author brosch
 * 
 */
public class EMFHelper {

	/**
	 * Retrieves all model elements of a given EMF type under some root element.
	 * 
	 * @param root
	 *            the root element
	 * @param type
	 *            the type of objects to find
	 * @return all objects of the given type or a sub type
	 */
	public EList<EObject> getElements(final EObject root, final EClass type) {

		// Prepare the result list:
		EList<EObject> resultList = new BasicEList<EObject>();

		// Search for elements that have the same type of a sub type of the
		// given type:
		EObjectCondition hasCompatibleType = new EObjectTypeRelationCondition(
				type, TypeRelation.SAMETYPE_OR_SUBTYPE_LITERAL);

		// Perform an EMF Model Query:
		IQueryResult queryResult = new SELECT(new FROM(root), new WHERE(
				hasCompatibleType)).execute();

		// Fill the resulting list:
		for (Object result : queryResult) {
			resultList.add((EObject) result);
		}

		// Return the result:
		return resultList;
	}
}
