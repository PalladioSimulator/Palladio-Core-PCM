package de.uka.ipd.sdq.capra.simulator.builder;

import umontreal.iro.lecuyer.probdist.DiscreteDistribution;
import de.uka.ipd.sdq.capra.simulator.expressions.SimAcquireAction;
import de.uka.ipd.sdq.capra.simulator.expressions.SimAction;
import de.uka.ipd.sdq.capra.simulator.expressions.SimBoundedLoop;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.expressions.SimDemandAction;
import de.uka.ipd.sdq.capra.simulator.expressions.SimInternalSelector;
import de.uka.ipd.sdq.capra.simulator.expressions.SimProbabilisticPrefix;
import de.uka.ipd.sdq.capra.simulator.expressions.SimReleaseAction;
import de.uka.ipd.sdq.capra.simulator.expressions.SimSuccessfulTermination;
import de.uka.ipd.sdq.capra.simulator.measurement.probes.SimTimeProbe;
import de.uka.ipd.sdq.capra.simulator.resources.SimActiveResource;
import de.uka.ipd.sdq.capra.simulator.resources.SimPassiveResource;


public class CapraExpressionFactory {
	
	
	public CapraExpressionFactory(){
	}
		
	public SimDemandAction createDemandAction(String name, DiscreteDistribution distribution, SimActiveResource resource){
		return new SimDemandAction(name,resource,distribution);
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

	public SimCapraExpression createAcquireAction(SimPassiveResource resource, int numberRequested) {
		return new SimAcquireAction(resource, numberRequested);
	}

	public SimCapraExpression createReleaseAction(SimPassiveResource resource,
			int numberReleased) {
		return new SimReleaseAction(resource, numberReleased);
	}
}
