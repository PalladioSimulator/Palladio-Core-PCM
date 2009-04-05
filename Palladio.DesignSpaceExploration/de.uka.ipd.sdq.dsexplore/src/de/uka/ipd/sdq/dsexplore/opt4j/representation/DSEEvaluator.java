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
	
	public DSEEvaluator(){
		this.objectives.add(new Objective("response time", Objective.Sign.MIN));
		this.objectives.add(new Objective("cost", Objective.Sign.MIN));
	}

	@Override
	public Objectives evaluate(PCMPhenotype pheno) {
		try {
			IAnalysisResult result = Opt4JStarter.analysisTool.analyse(pheno.getPcm());
			Objectives obj = new Objectives();
			obj.add(this.objectives.get(0), result.getMeanValue());
			//TODO: retrieve cost
			obj.add(this.objectives.get(1),0);
			return obj;
		} catch (AnalysisFailedException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<Objective> getObjectives() {
		return objectives;
	}

}
