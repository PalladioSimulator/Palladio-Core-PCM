package org.somox.metrics;

import java.util.List;

import org.eclipse.debug.ui.ILaunchConfigurationTab;
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

/**
 * Abstractness metric
 * 
 * @author Grischa Liebel
 *
 */
public class Abstractness implements Metric {

	@Override
	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		double abstractness = 0.0;
		double abstractClasses = 0.0;
		double totalClasses = 0.0;

		EObjectAttributeValueCondition abstractCondition = new EObjectAttributeValueCondition(typesPackage.eINSTANCE.getMember_Abstract(), new BooleanCondition(true));
		SELECT abstractnessQuery = new SELECT(new FROM(elements1), new WHERE(abstractCondition));

		IQueryResult result = abstractnessQuery.execute();
		
		abstractClasses = result.size();
		totalClasses = elements1.size();

		abstractnessQuery = new SELECT(new FROM(elements2), new WHERE(abstractCondition));

		result = abstractnessQuery.execute();
		abstractClasses += result.size();
		totalClasses += elements2.size();
		
		abstractness = abstractClasses/totalClasses;

		return abstractness;
	}
	
	
	/**
	 * Same as "compute" with a different way of calculating the metric
	 * 
	 * This method uses EMF-Query to calculate the metric
	 * 
	 * @param root Root-Object of the Software-Project modeled as GAST-model
	 * @param elements1 First part of the composite component
	 * @param elements2 Second part of the composite component
	 * @return the computed metric between 0.0 and 1.0
	 */
	public double computeWithOutEMF (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		double abstractness = 0.0;
		double abstractClasses = 0.0;
		double totalClasses = 0.0;

		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
				if (((GASTClass) current).isAbstract()) {
					abstractClasses += 1.0;
				}
				totalClasses += 1.0;
			}
		}
		
		for (ModelElement current : elements2) {
			if (current instanceof GASTClass) {
				if (((GASTClass) current).isAbstract()) {
					abstractClasses += 1.0;
				}
				totalClasses += 1.0;
			}
		}
		
		abstractness = abstractClasses/totalClasses;

		return abstractness;
	}
	
	@Override
	public ILaunchConfigurationTab getLaunchConfigurationTab() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MetricID getMID() {
		return new MetricID(234);
	}
}