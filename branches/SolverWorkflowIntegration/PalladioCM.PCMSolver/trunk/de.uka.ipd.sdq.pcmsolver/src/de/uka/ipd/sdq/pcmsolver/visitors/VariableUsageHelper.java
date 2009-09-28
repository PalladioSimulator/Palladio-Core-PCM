package de.uka.ipd.sdq.pcmsolver.visitors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.computed_usage.ComputedUsageFactory;
import de.uka.ipd.sdq.context.computed_usage.ExternalCallInput;
import de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput;
import de.uka.ipd.sdq.context.computed_usage.Input;
import de.uka.ipd.sdq.context.computed_usage.Output;
import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.VariableReference;

public class VariableUsageHelper {

	private static ParameterFactory parameterFactory = ParameterFactory.eINSTANCE;
	private static ComputedUsageFactory compUsageFactory = ComputedUsageFactory.eINSTANCE;

	public static void copySolvedVariableUsageToUsageContext(ContextWrapper ctxWrp, VariableUsage oldUsage) {
		VariableUsage newUsage = getCopiedSolvedVariableUsage(ctxWrp, oldUsage);
		ctxWrp.getCompUsgCtx().getInput_ComputedUsageContext().getParameterChacterisations_Input().add(newUsage);
	}

	public static void copySolvedVariableUsageToInput(Input input, ContextWrapper oldContextWrapper, VariableUsage oldUsage) {
		VariableUsage newUsage = getCopiedSolvedVariableUsage(oldContextWrapper, oldUsage);
		input.getParameterChacterisations_Input().add(newUsage);
	}
	
	public static void copySolvedVariableUsageToOutput(
			ContextWrapper contextWrapper, VariableUsage vu) {
		Output output = contextWrapper.getCompUsgCtx().getOutput_ComputedUsageContext();
		if (output == null)	{
			output = compUsageFactory.createOutput();
			contextWrapper.getCompUsgCtx().setOutput_ComputedUsageContext(output);
		}
		VariableUsage newUsage = getCopiedSolvedVariableUsage(contextWrapper, vu);
		output.getParameterCharacterisations_Output().add(newUsage);
	}
	
	public static void copySolvedVariableUsageToExternalCallInput(
			ContextWrapper contextWrapper, ExternalCallInput eci, VariableUsage vu) {
		VariableUsage newUsage = getCopiedSolvedVariableUsage(contextWrapper, vu);
		eci.getParameterCharacterisations_ExternalCallInput().add(newUsage);
	}
	

	public static void copySolvedVariableUsageToExternalCallOutput(
			ContextWrapper contextWrapper, ExternalCallOutput eco,
			VariableUsage vu) {
		VariableUsage newUsage = getCopiedSolvedVariableUsage(contextWrapper, vu);
		eco.getParameterCharacterisations_ExternalCallOutput().add(newUsage);
	}
	
	private static VariableUsage getCopiedSolvedVariableUsage(
			ContextWrapper ctxWrp, VariableUsage oldUsage) {
		VariableUsage newUsage = parameterFactory.createVariableUsage();
		
		newUsage.setNamedReference_VariableUsage(getReferenceCopy(oldUsage.getNamedReference_VariableUsage()));
		//newUsage.setNamedReference_VariableUsage(oldUsage.getNamedReference_VariableUsage());

		EList<VariableCharacterisation> varCharList = oldUsage.getVariableCharacterisation_VariableUsage();
		for (VariableCharacterisation oldVC : varCharList){

			String specification = oldVC.getSpecification_VariableCharacterisation().getSpecification();
			String solvedSpecification = ExpressionHelper
					.getSolvedExpressionAsString(specification, ctxWrp); 

			VariableCharacterisation solvedCharacterisation = parameterFactory
					.createVariableCharacterisation();
			solvedCharacterisation.setType(oldVC.getType());

			PCMRandomVariable rv = CoreFactory.eINSTANCE.createPCMRandomVariable();
			rv.setSpecification(solvedSpecification);
			solvedCharacterisation.setSpecification_VariableCharacterisation(rv);
			
			newUsage.getVariableCharacterisation_VariableUsage().add(solvedCharacterisation);
			
		}
		return newUsage;
	}
	

	
	private static AbstractNamedReference getReferenceCopy(AbstractNamedReference anr){
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

	public static void copyVariableUsageToInput(Input input, VariableUsage vu) {
		// TODO: support dependencies on output parameters
		VariableUsage newUsage = parameterFactory.createVariableUsage();
		newUsage.setNamedReference_VariableUsage(getReferenceCopy(vu.getNamedReference_VariableUsage()));

		EList<VariableCharacterisation> characterisations = vu.getVariableCharacterisation_VariableUsage();
		for (VariableCharacterisation oldCharacterisation : characterisations){
			String specification = oldCharacterisation.getSpecification_VariableCharacterisation().getSpecification();
			String solvedSpecification = ExpressionHelper
					.getSolvedExpressionAsString(specification, null); 

			VariableCharacterisation solvedCharacterisation = parameterFactory
					.createVariableCharacterisation();
			solvedCharacterisation.setType(oldCharacterisation.getType());

			PCMRandomVariable rv = CoreFactory.eINSTANCE.createPCMRandomVariable();
			rv.setSpecification(solvedSpecification);
			solvedCharacterisation.setSpecification_VariableCharacterisation(rv);
			
			newUsage.getVariableCharacterisation_VariableUsage().add(solvedCharacterisation);
			
		}
		input.getParameterChacterisations_Input().add(newUsage);
	}

	/**
	 * Returns all characterisation from the first argument that are also specified in the second argument. 
	 * @param vu1
	 * @param vu2
	 * @return A list that is not null, but may be empty. 
	 */
	public static List<VariableCharacterisation> getCommonCharacterisationsFromFirst(VariableUsage vu1, VariableUsage vu2){
		if (vu1 == vu2){
			return vu1.getVariableCharacterisation_VariableUsage();
		}
		
		if (describeSameReference(vu1.getNamedReference_VariableUsage(),vu2.getNamedReference_VariableUsage())){
			return vu1.getVariableCharacterisation_VariableUsage();
		}
		
		List<VariableCharacterisation> characterisations1 = vu1.getVariableCharacterisation_VariableUsage();
		List<VariableCharacterisation> characterisations2 = vu2.getVariableCharacterisation_VariableUsage();
		
		//Return all characterisations that are there in both lists from list 1
		//or better select all from vu1 that are not in vu2
		List<VariableCharacterisation> listFrom1ThatAreAlsoIn2 = new ArrayList<VariableCharacterisation>();
		for (VariableCharacterisation variableCharacterisation1 : characterisations1) {
			for (VariableCharacterisation variableCharacterisation2 : characterisations2) {
				if (variableCharacterisation1.getType().equals(variableCharacterisation2.getType())){
					listFrom1ThatAreAlsoIn2.add(variableCharacterisation1);
				}
			}
		}
		
		return listFrom1ThatAreAlsoIn2;
		
	}

	private static boolean describeSameReference(
			AbstractNamedReference ref1,
			AbstractNamedReference ref2) {
		
		if (!ref1.getReferenceName().equals(ref2.getReferenceName())){
			return false;
		}
		
		if (ref1 instanceof VariableReference 
				&& ref2 instanceof VariableReference)
		return true;
		
		if (ref1 instanceof NamespaceReference 
				&& ref2 instanceof NamespaceReference){
			NamespaceReference nref1 = (NamespaceReference)ref1;
			NamespaceReference nref2 = (NamespaceReference)ref2;
			return describeSameReference(nref1.getInnerReference_NamespaceReference(), nref2.getInnerReference_NamespaceReference());
		}
		return false;
		
	}



	
}
