package de.uka.ipd.sdq.pcmsolver.handler;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.usage.UsageContext;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcmsolver.visitors.ExpressionHelper;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.VariableReference;

public class SetVariableActionHandler {

	private SeffVisitor visitor; 
	
	private ParameterFactory parameterFactory = ParameterFactory.eINSTANCE;

	
	public SetVariableActionHandler(SeffVisitor seffVisitor){
		visitor = seffVisitor;
	}

	public void handle(SetVariableAction sva){
		
		UsageContext uc = visitor.getMyContext().getUsageContext();
		VariableUsage vu = sva.getVariableUsage_SetVariableAction();
		
		copySolvedVariableUsageToUsageContext(uc, vu);
		
//		AbstractNamedReference anr = vu.getNamedReference_VariableUsage();
//
//		EList charList = vu.getVariableCharacterisation_VariableUsage();
//		for (Object o : charList){
//			VariableCharacterisation vc = (VariableCharacterisation)o;
//			String specification = vc.getSpecification();
//			String solvedSpecification = 
//				ExpressionHelper.getSolvedExpressionAsString(specification, visitor.getMyContext());
//			vc.setSpecification(solvedSpecification);
//		}
//		
//		
//		EList varList = visitor.getMyContext().getUsageContext().getActualParameterUsage_UsageContext();
//		for(Object o : varList){
//			VariableUsage actVU = (VariableUsage)o;
//			AbstractNamedReference anrActVU = actVU.getNamedReference_VariableUsage();
//			if (anrActVU == anr){
//				varList.remove(o);
//			}
//		}
//				
//		varList.add(vu);
		
		
	}
	
	/**
	 * @param uc
	 * @param oldUsage
	 */
	private void copySolvedVariableUsageToUsageContext(UsageContext uc, VariableUsage oldUsage) {
		VariableUsage newUsage = parameterFactory.createVariableUsage();
		
		newUsage.setNamedReference_VariableUsage(getReferenceCopy(oldUsage.getNamedReference_VariableUsage()));
		//newUsage.setNamedReference_VariableUsage(oldUsage.getNamedReference_VariableUsage());

		EList characterisations = oldUsage.getVariableCharacterisation_VariableUsage();
		for (Object o2 : characterisations){
			VariableCharacterisation oldCharacterisation = (VariableCharacterisation)o2;

			String specification = oldCharacterisation.getSpecification();
			String solvedSpecification = ExpressionHelper
					.getSolvedExpressionAsString(specification, visitor.getMyContext()); 

			VariableCharacterisation solvedCharacterisation = parameterFactory
					.createVariableCharacterisation();
			solvedCharacterisation.setType(oldCharacterisation.getType());
			solvedCharacterisation.setSpecification(solvedSpecification);
			
			newUsage.getVariableCharacterisation_VariableUsage().add(solvedCharacterisation);
			
		}
		uc.getActualParameterUsage_UsageContext().add(newUsage);
	}
	
	private AbstractNamedReference getReferenceCopy(AbstractNamedReference anr){
		if (anr instanceof NamespaceReference){
			NamespaceReference nr = (NamespaceReference)anr;
			NamespaceReference newRef = StoexFactory.eINSTANCE.createNamespaceReference();
			newRef.setReferenceName(nr.getReferenceName());
			newRef.setInnerReference_NamespaceReference(getReferenceCopy(nr.getInnerReference_NamespaceReference()));
			return newRef;
		} else if (anr instanceof VariableReference){
			VariableReference vr = (VariableReference)anr;
			VariableReference varRef = StoexFactory.eINSTANCE.createVariableReference();
			varRef.setReferenceName(vr.getReferenceName());
			return varRef;
		} else 
			return null;
	}
	
}
