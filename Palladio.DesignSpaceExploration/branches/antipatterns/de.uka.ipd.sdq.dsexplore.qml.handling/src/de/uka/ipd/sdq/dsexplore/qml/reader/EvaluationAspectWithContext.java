/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.qml.reader;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Criterion;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractType;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.Requirement;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;

/**
 * @author Qais
 *
 */
public class EvaluationAspectWithContext {
	private final QMLContractType contractType;
	private final Dimension dimension;
	private final Criterion criterion;
	/**
	 * @return the criterion
	 */
	public Criterion getCriterion() {
		return criterion;
	}

	private final EvaluationAspect evaluationAspect;
	private final UsageModel usageModel;
	private final Requirement requirement;
	
	public EvaluationAspectWithContext(QMLContractType contractType, Dimension dimension, Criterion criterion, EvaluationAspect evaluationAspect, UsageModel usageModel, Requirement requirement){
		this.contractType = contractType;
		this.dimension = dimension;
		this.criterion = criterion;
		this.evaluationAspect = evaluationAspect;
		this.usageModel = usageModel;
		this.requirement = requirement;
	}

	/**
	 * @return the contractType
	 */
	public QMLContractType getContractType() {
		return contractType;
	}

	/**
	 * @return the dimension
	 */
	public Dimension getDimension() {
		return dimension;
	}

	/**
	 * @return the evaluationAspect
	 */
	public EvaluationAspect getEvaluationAspect() {
		return evaluationAspect;
	}

	/**
	 * @return the usageModel
	 */
	public UsageModel getUsageModel() {
		return usageModel;
	}

	/**
	 * @return the requirement
	 */
	public Requirement getRequirement() {
		return requirement;
	}
}
