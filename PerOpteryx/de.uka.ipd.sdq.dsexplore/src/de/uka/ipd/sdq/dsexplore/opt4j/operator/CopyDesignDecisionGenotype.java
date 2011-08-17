package de.uka.ipd.sdq.dsexplore.opt4j.operator;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.pcm.designdecision.Choice;

public class CopyDesignDecisionGenotype implements Copy<DesignDecisionGenotype> {

	@Override
	public DesignDecisionGenotype copy(DesignDecisionGenotype genotype) {
		DesignDecisionGenotype copy = genotype.newInstance();
		
		for (Choice choice : genotype) {
			//only copies the object and contained other model elements 
			//(i.e. the full tree that is made out of containment references).
			//As the PCm model elements are never in a containment relation here, 
			//the PCM will not be tampered with here.  
			Choice copiedChoice = (Choice)EcoreUtil.copy(choice);
			copy.add(copiedChoice);
		}
		return copy;
	}

}
