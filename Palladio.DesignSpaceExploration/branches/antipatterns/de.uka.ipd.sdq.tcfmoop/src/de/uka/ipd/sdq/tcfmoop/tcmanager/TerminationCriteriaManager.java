package de.uka.ipd.sdq.tcfmoop.tcmanager;

import java.util.LinkedList;
import java.util.List;

import org.opt4j.core.Archive;
import org.opt4j.core.Population;
import org.opt4j.core.optimizer.Control;
import org.opt4j.core.optimizer.Optimizer;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.ElapsedTimeCriterion;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.GivenParetoFrontIsReachedCriterion;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.ITerminationCriterion;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.InsignificantParetoFrontChangeCriterion;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.InsignificantSetQualityImprovementCriterion;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.MaxGenerationNumber;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.MinimalQualityCriteriaValueCriterion;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.NoNewParetoOptimalCandidatesFoundCriterion;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.ParetoOptimalSetStabilityCriterion;

import com.google.inject.Inject;

public class TerminationCriteriaManager implements ITerminationCriteriaManager{

	private List<ITerminationCriterion> terminationCriteria = new LinkedList<ITerminationCriterion>();
	private boolean isInitialized = false;
	
	//So that all termination criteria can work with the same time.
	private long currentTime;
	
	//Required resources
	private Control control;
	private Optimizer optimizer;
	private Population population;
	private Archive archive;
	
	//if true - the manager will evaluate the termination criteria and report their output but this will not influence the evaluation in any way
	private boolean isInComparisionMode = false;
	
	@Inject
	public TerminationCriteriaManager(Control control,
									  Population population,
									  Archive archive){
		this.control = control;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void activateTCComparisionMode() {
		this.isInComparisionMode = true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deactivateTCComparisionMode() {
		this.isInComparisionMode = false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void evaluateTerminationCriteria(){
		if(this.isInitialized){
			this.currentTime = System.currentTimeMillis();
			for(ITerminationCriterion tc : this.terminationCriteria){
				tc.evaluate(this.optimizer.getIteration(), this.currentTime);
				if(tc.getEvaluationResult() && ! this.isInComparisionMode){
					control.doStop();
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getOutputInformation() {
		StringBuilder sb = new StringBuilder();
		if(this.isInitialized){
			sb.append("Elapsed Time: ???" + '\n');
			for(ITerminationCriterion tc : terminationCriteria){
				sb.append(tc.getOutputInformation());
				sb.append('\n');
			}
		}else{
			sb.append("TerminationCriteriaManager not initialized!" + '\n');
		}
		return sb.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(List<IConfiguration> tcConfigurations) {
		for(IConfiguration conf : tcConfigurations){
			if(!conf.validateConfiguration()){
				continue;
			}
			switch(conf.getTerminationCriterionName()){
			case MAXIMUM_NUMBER_OF_GENERATIONS:
				MaxGenerationNumber mgn = new MaxGenerationNumber();
				mgn.initialize(conf, this.population, this.archive);
				terminationCriteria.add(mgn);
				break;
			case ELAPSED_TIME:
				ElapsedTimeCriterion et = new ElapsedTimeCriterion();
				et.initialize(conf, this.population, this.archive);
				terminationCriteria.add(et);
				break;
			case PARETO_OPTIMAL_SET_STABILITY: 
				ParetoOptimalSetStabilityCriterion poss = new ParetoOptimalSetStabilityCriterion();
				poss.initialize(conf, population, archive);
				terminationCriteria.add(poss);
				break;
			case NO_NEW_PARETO_OPTIMAL_CANDIDATES_FOUND: 
				NoNewParetoOptimalCandidatesFoundCriterion nnpocf = new NoNewParetoOptimalCandidatesFoundCriterion();
				nnpocf.initialize(conf, population, archive);
				terminationCriteria.add(nnpocf);
				break;
			case MINIMAL_QUALITY_CIRTERIA_VALUE:
				MinimalQualityCriteriaValueCriterion mqcv = new MinimalQualityCriteriaValueCriterion();
				mqcv.initialize(conf, population, archive);
				terminationCriteria.add(mqcv);
				break;
			case INSIGNIFICANT_SET_QUALITY_IMPROVEMENT:
				InsignificantSetQualityImprovementCriterion isqc = new InsignificantSetQualityImprovementCriterion();
				isqc.initialize(conf, population, archive);
				terminationCriteria.add(isqc);
				break;
			case GIVEN_PARETO_FRONT_IS_REACHED:
				GivenParetoFrontIsReachedCriterion gpfir = new GivenParetoFrontIsReachedCriterion();
				gpfir.initialize(conf, population, archive);
				terminationCriteria.add(gpfir);
				break;
			case INSIGNIFICANT_PARETO_FRONT_CHANGE:
				InsignificantParetoFrontChangeCriterion ipfc = new InsignificantParetoFrontChangeCriterion();
				ipfc.initialize(conf, population, archive);
				terminationCriteria.add(ipfc);
				break;
			}
			
		}
		this.isInitialized = true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void iterationComplete(Optimizer optimizer, int iteration) {
		this.optimizer = optimizer;
		this.evaluateTerminationCriteria();
	}

}