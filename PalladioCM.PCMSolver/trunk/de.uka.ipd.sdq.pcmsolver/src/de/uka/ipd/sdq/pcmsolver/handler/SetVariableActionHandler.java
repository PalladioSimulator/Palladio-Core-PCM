package de.uka.ipd.sdq.pcmsolver.handler;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcmsolver.visitors.ExpressionHelper;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.pcmsolver.visitors.VariableUsageHelper;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.PCMRandomVariable;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.VariableReference;

public class SetVariableActionHandler {

	private SeffVisitor visitor; 
	
	private ParameterFactory parameterFactory = ParameterFactory.eINSTANCE;

	
	public SetVariableActionHandler(SeffVisitor seffVisitor){
		visitor = seffVisitor;
	}

	public void handle(SetVariableAction sva){
		EList<VariableUsage> vuList = sva.getLocalVariableUsages_SetVariableAction();
		for (VariableUsage vu : vuList){
			VariableUsageHelper.copySolvedVariableUsageToOutput(visitor.getContextWrapper(), vu);	
		}
	}
	
}
