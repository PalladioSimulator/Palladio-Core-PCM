package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;

import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualBuilder;

/*
 * FIXME: Dummy classes to distinguish which tactic has been applie. Refactor and put different rules into different tactics.  
 */
public class ConcurrentProcessingSystem extends ConcurrentProcessingSystemImplCatia{

	public ConcurrentProcessingSystem(Copy<Genotype> copy,
			DSEIndividualBuilder individualBuilder,
			DSEWorkflowConfiguration configuration) {
		super(copy, individualBuilder, configuration, true);
		// TODO Auto-generated constructor stub
	}
	
}
