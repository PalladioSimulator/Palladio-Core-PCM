package de.uka.ipd.sdq.capra.simulator.builder;

import umontreal.iro.lecuyer.probdist.DiscreteDistribution;
import de.uka.ipd.sdq.capra.simulator.actions.SimAcquireAction;
import de.uka.ipd.sdq.capra.simulator.actions.SimAction;
import de.uka.ipd.sdq.capra.simulator.actions.SimDemandAction;
import de.uka.ipd.sdq.capra.simulator.actions.SimReleaseAction;
import de.uka.ipd.sdq.capra.simulator.actions.SimSuccessfulTermination;
import de.uka.ipd.sdq.capra.simulator.actions.SimTimeProbe;
import de.uka.ipd.sdq.capra.simulator.expressions.SimBoundedLoop;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.expressions.SimInternalSelector;
import de.uka.ipd.sdq.capra.simulator.expressions.SimProbabilisticPrefix;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IPassiveResource;


public class CapraExpressionFactory {
	
	
	public CapraExpressionFactory(){
	}
		
	public SimDemandAction createDemandAction(String name, DiscreteDistribution distribution, double samplingWidth, IActiveResource resource){
		return new SimDemandAction(name,resource,distribution,samplingWidth);
	}
	
	public SimProbabilisticPrefix createSimProbabilisticPrefix(SimAction action,
			SimInternalSelector[] targetOptions){
		return new SimProbabilisticPrefix(action, targetOptions);
	}

	public SimInternalSelector createInternalSelector(double probability,
			SimCapraExpression simExpression) {
		return new SimInternalSelector(probability,simExpression);
	}
	
	public SimSuccessfulTermination createSuccessfulTermination(){
		return new SimSuccessfulTermination();
	}

	public SimTimeProbe createSimTimeProbe() {
		return new SimTimeProbe();
	}

	public SimBoundedLoop createBoundedLoop(
			DiscreteDistribution numIterations,
			SimCapraExpression repeatedProcess, SimCapraExpression targetProcess) {
		
		return new SimBoundedLoop(numIterations,repeatedProcess,targetProcess);
	}

	public SimCapraExpression createAcquireAction(IPassiveResource resource, int numberRequested) {
		return new SimAcquireAction(resource, numberRequested);
	}

	public SimCapraExpression createReleaseAction(IPassiveResource resource,
			int numberReleased) {
		return new SimReleaseAction(resource, numberReleased);
	}
}
