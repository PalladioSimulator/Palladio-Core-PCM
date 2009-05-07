package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.problem.Evaluator;

import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.cost.CostEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;

/**
 * The Evaluator is responsible for determining the objective functions values 
 * for an individual based on the phenotype (i.e. the PCM instance). Thus, 
 * it calls the simulation or LQN solver for performance and also a cost 
 * evaluator. 
 * 
 * It is a singleton  
 * 
 * @author Anne
 * 
 */
public class DSEEvaluator implements Evaluator<PCMPhenotype>{
	
	protected final List<Objective> objectives = new ArrayList<Objective>();
	
	private List<Exception> exceptionList = new ArrayList<Exception>();
	
	private boolean firstRunSuccessful = false;
	
	public DSEEvaluator(){
		this.objectives.add(new Objective("response time", Objective.Sign.MIN));
		this.objectives.add(new Objective("cost", Objective.Sign.MIN));
	}
	
	public void reset(){
		this.firstRunSuccessful = false;
		this.exceptionList = new ArrayList<Exception>();
	}

	@Override
	public Objectives evaluate(PCMPhenotype pheno) {
		
		Objectives obj = new Objectives();
		try{
			
			retrieveResponseTime(pheno, obj);

			retrieveCost(pheno, obj);
			
			firstRunSuccessful = true;

			return obj;
			
		} catch (Exception e){
			
			//If this is the first evaluation, then something severe seems to be wrong, throw an exception 
			if (!firstRunSuccessful){
				e.printStackTrace();
				throw new RuntimeException(e);
			} else {
				//if this is just a failure during the course of the run, ignore it and output it later
				this.exceptionList.add(new Exception("Evaluation of a candidate failed. Filling objectves with NaN.",e));
				
				//Check if response time is there
				if (obj.size() == 0){
					obj.add(this.objectives.get(0),Double.NaN);
				}
				//afterwards (now having one entry for sure) add cost if not there (i.e. if size == 1, not 2). 
				if (obj.size() == 1){
					obj.add(this.objectives.get(1), Double.NaN);
				}
				
				return obj;
			}
		}
	}

	private void retrieveCost(PCMPhenotype pheno, Objectives obj) {
		//retrieve cost
		double cost = Opt4JStarter.costEvaluator.getTotalCost(pheno.getPcm(), 0);
		obj.add(this.objectives.get(1),cost);
	}

	private void retrieveResponseTime(PCMPhenotype pheno, Objectives obj)
			throws AnalysisFailedException, CoreException {
		//retrieve response time
		IAnalysisResult result = Opt4JStarter.analysisTool.analyse(pheno.getPcm());
		obj.add(this.objectives.get(0), result.getMeanValue());
		
		//Maybe handle a demand too large exception in the simulation separately by setting the objective to infinity. 
		
	}

	@Override
	public Collection<Objective> getObjectives() {
		return objectives;
	}
	
	//TODO: Add an interface ExceptionTracker to unify exception handling. 
	public List<Exception> getExceptionList(){
		return this.exceptionList;
	}

}
