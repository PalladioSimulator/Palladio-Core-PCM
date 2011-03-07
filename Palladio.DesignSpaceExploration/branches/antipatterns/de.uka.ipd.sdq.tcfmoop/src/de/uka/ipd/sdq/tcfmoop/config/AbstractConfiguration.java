package de.uka.ipd.sdq.tcfmoop.config;

public abstract class AbstractConfiguration implements IConfiguration{

	protected TerminationCriteriaNames criterionName;
	
	public AbstractConfiguration(){
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final TerminationCriteriaNames getTerminationCriterionName() {
		return criterionName;
	}

}