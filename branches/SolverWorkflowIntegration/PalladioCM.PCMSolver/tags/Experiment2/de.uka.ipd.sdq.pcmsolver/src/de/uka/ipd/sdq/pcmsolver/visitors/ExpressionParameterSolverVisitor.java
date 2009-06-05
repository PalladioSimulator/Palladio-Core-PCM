package de.uka.ipd.sdq.pcmsolver.visitors;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcmsolver.models.Context;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.Variable;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionSolveVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

public class ExpressionParameterSolverVisitor extends ExpressionSolveVisitor {

	private static Logger logger = Logger
	.getLogger(ExpressionParameterSolverVisitor.class.getName());

	private Context context;
	
	public ExpressionParameterSolverVisitor(HashMap<Expression, TypeEnum> typeAnn, Context context){
		super(typeAnn);
		this.context = context;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionSolveVisitor#caseVariable(de.uka.ipd.sdq.stoex.Variable)
	 *
	 * Solves a parametric dependency. For a given variable, it tries to 
	 * determine it's actual specification (e.g. probability distribution or
	 * constant) by looking it up in the usage context.
	 */
	public Object caseVariable(Variable var){
		AbstractNamedReference anr = var.getId_Variable();
		CharacterisedVariable chVar = (CharacterisedVariable)var;
		
		EList parList = context.getUsageContext().getActualParameterUsage_UsageContext();

		String soughtParameterName = getFullParameterName(anr);
		for (Object o : parList){ // iterate over parameters
			VariableUsage vu = (VariableUsage)o;

			AbstractNamedReference ref = vu.getNamedReference_VariableUsage();
			String currentParameterName = getFullParameterName(ref);
			
			//String currentParameterName = vu.getNamedReference_VariableUsage().getReferenceName();

			if (currentParameterName.equals(soughtParameterName)){
				EList parChars = vu.getVariableCharacterisation_VariableUsage();

				for (Object p: parChars){ // iterate over a parameter's characterisations
					VariableCharacterisation vc = (VariableCharacterisation)p;
					if (vc.getType() == chVar.getCharacterisationType()){
						String specification = vc.getSpecification();
						Expression expr = ExpressionHelper.parseToExpression(specification);
						return expr;
					}
				}
				logger.error("Variable Characterisation missing " +
						"in Usage Context ("+soughtParameterName+")!");
				return null;
			}
		}
		logger.error("Variable missing " +
				"in Usage Context ("+soughtParameterName+")!");
		return null;
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
