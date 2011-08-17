package de.uka.ipd.sdq.tcfmoop.config;

/**
 * Abstract Configuration class for a termination criterion.
 * @author Atanas Dimitrov
 */
public abstract class AbstractConfiguration implements IConfiguration{

	private TerminationCriteriaNames criterionName;
	
	protected AbstractConfiguration(TerminationCriteriaNames criterionName){
		this.criterionName = criterionName;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TerminationCriteriaNames getTerminationCriterionName() {
		return criterionName;
	}

}