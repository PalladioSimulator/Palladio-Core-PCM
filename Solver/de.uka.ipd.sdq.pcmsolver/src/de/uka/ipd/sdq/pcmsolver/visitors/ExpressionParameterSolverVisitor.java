package de.uka.ipd.sdq.pcmsolver.visitors;


import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput;
import de.uka.ipd.sdq.context.computed_usage.Input;
import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.Variable;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionSolveVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

public class ExpressionParameterSolverVisitor extends ExpressionSolveVisitor {

	private static Logger logger = Logger
	.getLogger(ExpressionParameterSolverVisitor.class.getName());

	//private Context context;
	private ContextWrapper contextWrapper;
	
	public ExpressionParameterSolverVisitor(HashMap<Expression, TypeEnum> typeAnn, ContextWrapper ctxWrp){
		super(typeAnn);
		this.contextWrapper = ctxWrp;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionSolveVisitor#caseVariable(de.uka.ipd.sdq.stoex.Variable)
	 *
	 * Solves a parametric dependency. For a given variable, it tries to 
	 * determine it's actual specification (e.g. probability distribution or
	 * constant) by looking it up in the usage context.
	 */
	@Override
	public Object caseVariable(Variable var){
		AbstractNamedReference anr = var.getId_Variable();
		CharacterisedVariable chVar = (CharacterisedVariable)var;
		
		//Contains both input parameters specified in the interface and component parameters. 
		EList<VariableUsage> vuList = new BasicEList<VariableUsage>();
		Input input = contextWrapper.getCompUsgCtx().getInput_ComputedUsageContext();
		if (input !=null){
			vuList.addAll(input.getParameterChacterisations_Input());
		}
		
		EList<ExternalCallOutput> ecoList = contextWrapper.getCompUsgCtx().getExternalCallOutput_ComputedUsageContext();
		for (ExternalCallOutput eco : ecoList){
			// TODO: recognise scopes
			EList<VariableUsage> vuList2 = eco.getParameterCharacterisations_ExternalCallOutput();
			vuList.addAll(vuList2); 
		}
		
		String soughtParameterName = getFullParameterName(anr);
		for (VariableUsage vu : vuList){ 
			AbstractNamedReference ref = vu.getNamedReference__VariableUsage();
			String currentParameterName = getFullParameterName(ref);

			if (currentParameterName.equals(soughtParameterName)){
				EList<VariableCharacterisation> varCharList = vu.getVariableCharacterisation_VariableUsage();

				for (VariableCharacterisation vc : varCharList){ // iterate over a parameter's characterisations
					if (vc.getType() == chVar.getCharacterisationType()){
						String specification = vc.getSpecification_VariableCharacterisation().getSpecification();
						Expression expr = ExpressionHelper.parseToExpression(specification);
						return expr;
					}
				}
				throw new RuntimeException("Variable Characterisation missing in Usage Context ("+soughtParameterName+")!");
			}
		}
		throw new RuntimeException("Variable Characterisation missing in Usage Context ("+soughtParameterName+")!");
	}

	/**
	 * @param currentParameterName
	 * @param ref
	 * @return
	 */
	private String getFullParameterName(AbstractNamedReference ref) {
		String name = ""; 
		while (ref instanceof NamespaceReference){
			NamespaceReference nsRef = (NamespaceReference)ref;
			name += nsRef.getReferenceName() + ".";
			ref = nsRef.getInnerReference_NamespaceReference();
		}
		return name += ref.getReferenceName();
	}
}
