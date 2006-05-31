package de.uka.ipd.sdq.simucom;

import java.util.Hashtable;

import desmoj.core.dist.IntDistEmpirical;
import desmoj.core.simulator.Model;

public class DistributionObjectsStorage {
	protected Model myModel = null;
	protected Hashtable<String,IntDistEmpirical> decisionNodeDistributions = new Hashtable<String,IntDistEmpirical>();
	
	public DistributionObjectsStorage(Model myModel)
	{
		this.myModel = myModel;
	}
	
	public IntDistEmpirical getDecisionNodeDistribution(Object n)
	{
//		if (decisionNodeDistributions.containsKey(n.getQualifiedName()))
//			return decisionNodeDistributions.get(n.getQualifiedName());
//		else
//		{
//			double sum = 0d;
//			EList outgoingEdges = n.getOutgoings();
//			IntDistEmpirical newDistribution = new IntDistEmpirical(myModel, n.getQualifiedName(), true, false);
//			newDistribution.setSeed(System.currentTimeMillis());
//			for (int i=0; i < outgoingEdges.size(); i++)
//			{
//				assert(UMLHelper.isStereotypeApplied((ControlFlow)outgoingEdges.get(i),"PA::DecisionProbability"));
//				double probability = (Double)UMLHelper.getStereotypeValue((ControlFlow)outgoingEdges.get(i), "PA::DecisionProbability", "probability");
//				sum += probability;
//				newDistribution.addEntry(i,sum);
//			}
//			decisionNodeDistributions.put(n.getQualifiedName(),newDistribution);
//			return newDistribution;
//		}
		return null;
	}
}
