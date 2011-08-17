package de.uka.ipd.sdq.pcmsolver.handler;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;

/**
 * @author Koziolek
 *
 */
public class CollectionIteratorActionHandler extends AbstractLoopActionHandler{

	private static Logger logger = Logger.getLogger(CollectionIteratorActionHandler.class.getName());

	public CollectionIteratorActionHandler(SeffVisitor seffVisitor) {
		super(seffVisitor);
	}
	
	/**
	 * @param loop
	 */
	public void handle(CollectionIteratorAction collIterAction) {
		Parameter parameter = collIterAction.getParameter_CollectionIteratorAction();
		String parameterName = parameter.getParameterName();
		
		String iterCount = getIterationExpression(parameterName);
		if (iterCount == null){
			logger.error("Skipping execution of loop body!");
			return;
		}
		
		storeToUsageContext(collIterAction, iterCount);
		
		visitLoopBody(collIterAction, iterCount);
	}


	
	/**
	 * Fetches the expression describing the number of loop iteration
	 * from the usage context. It is the NUMBER_OF_ELEMENTS of the parameter
	 * in the SEFF, whose name is passed here as input parameter.
	 * 
	 * @param soughtParameterName
	 * @return
	 */
	private String getIterationExpression(String soughtParameterName){
		EList<VariableUsage> vuList = visitor.getContextWrapper().getCompUsgCtx().getInput_ComputedUsageContext().getParameterChacterisations_Input();

		for (VariableUsage vu : vuList){ // iterate over parameters
			String currentParameterName = "";
			AbstractNamedReference ref = vu.getNamedReference__VariableUsage();
			while (ref instanceof NamespaceReference){
				NamespaceReference nsRef = (NamespaceReference)ref;
				currentParameterName += nsRef.getReferenceName() + ".";
				ref = nsRef.getInnerReference_NamespaceReference();
			}
			currentParameterName += ref.getReferenceName();
			
			if (currentParameterName.equals(soughtParameterName)){
				EList<VariableCharacterisation> varChars = vu.getVariableCharacterisation_VariableUsage();
				for (VariableCharacterisation vc : varChars){ // iterate over a parameter's characterisations
					if (vc.getType() == VariableCharacterisationType.NUMBER_OF_ELEMENTS){
						return vc.getSpecification_VariableCharacterisation().getSpecification();
					}
				}
				logger.error("Variable Characterisation NUMBER_OF_ELEMENTS missing " +
						"in Usage Context for parameter "+soughtParameterName+")! " +
								"It is needed for a CollectionIteratorAction.");
				return null;
			}
		}
		logger.error("Variable "+soughtParameterName+" missing " +
				"in Usage Context!");
		return null;
	}
	
}
