package de.uka.ipd.sdq.pcmsolver.visitors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
	
	protected static Logger logger = Logger.getLogger(VariableUsageHelper.class
			.getName());

	public static void copySolvedVariableUsageToUsageContext(ContextWrapper ctxWrp, VariableUsage oldUsage) {
		VariableUsage newUsage = getCopiedSolvedVariableUsage(ctxWrp, oldUsage);
		ctxWrp.getCompUsgCtx().getInput_ComputedUsageContext().getParameterChacterisations_Input().add(newUsage);
	}

	/**
	 * Create new VariableUsages, fill it with the solved values of the passed VariableUsages and
	 * add it to the input parameter. 
	 * This method assumes that it is called last with the variables with the highest priority, 
	 * because if a variable name is already defined in the input, it deletes the old
	 * definition and uses the new ones from the parameter variableUsages.
	 */
	public static void copySolvedVariableUsageToInput(Input input,ContextWrapper oldContextWrapper, Collection<VariableUsage> variableUsages) {
		for (VariableUsage compParams : variableUsages) {
			VariableUsage newUsage = getCopiedSolvedVariableUsage(
					oldContextWrapper, compParams);

			//check if there already exists a variable with the same name in this set of variable usages. 
			String varName = getFullParameterName(newUsage.getNamedReference__VariableUsage());
			
			List<VariableUsage> usagesToBeOverwritten = new ArrayList<VariableUsage>(5);
			for (VariableUsage usage : input.getParameterChacterisations_Input()){
				if (getFullParameterName(usage.getNamedReference__VariableUsage()).equals(varName)){
					// replace the old definition, it could be overwritten e.g. in UserData. So it is ok if one definition occurs several times.
					// XXX: Catch cases where there should only be one definition?
					usagesToBeOverwritten.add(usage);
					//throw new RuntimeException("Multiple definition of variable '" + varName + "' in a SEFF of assembly context "+((ComputedUsageContext)input.eContainer()).getAssemblyContext_ComputedUsageContext().getEntityName());
					logger.info("Variable "+varName+" is defined twice, one definition has been overwritten.");
				}
			}
			input.getParameterChacterisations_Input().removeAll(usagesToBeOverwritten);
			
			input.getParameterChacterisations_Input().add(newUsage);
		}
		
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
	
	/**
	 * Adds the usage information from {@link VariableUsage} vu to the 
	 * {@link ExternalCallOutput} eco. 
	 * @param contextWrapper
	 * @param eco
	 * @param vu
	 */
	public static void copySolvedVariableUsageToExternalCallOutput(
			ContextWrapper contextWrapper, ExternalCallOutput eco,
			VariableUsage vu) {
		VariableUsage newUsage = getCopiedSolvedVariableUsage(contextWrapper, vu);
		eco.getParameterCharacterisations_ExternalCallOutput().add(newUsage);
	}
	
	private static VariableUsage getCopiedSolvedVariableUsage(
			ContextWrapper ctxWrp, VariableUsage oldUsage) {
		VariableUsage newUsage = parameterFactory.createVariableUsage();
		
		newUsage.setNamedReference__VariableUsage(getReferenceCopy(oldUsage.getNamedReference__VariableUsage()));
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
	

	
	public static AbstractNamedReference getReferenceCopy(AbstractNamedReference anr){
		if(anr == null) {
			return null;
		}
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
		} else { 
			throw new IllegalArgumentException("Unsupported Reference type "+anr.getClass().getName());
		}
	}

	public static void copyVariableUsageToInput(Input input, VariableUsage vu) {
		// TODO: support dependencies on output parameters
		VariableUsage newUsage = parameterFactory.createVariableUsage();
		newUsage.setNamedReference__VariableUsage(getReferenceCopy(vu.getNamedReference__VariableUsage()));

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

		if (describeSameReference(vu1.getNamedReference__VariableUsage(),vu2.getNamedReference__VariableUsage())){
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

	/**
	 * Copies the passed list using the EcoreUtils class. 
	 * @param originalVariableUsages. A list containing VariableUsage
	 * @return A copy of the list.
	 */
	public static Collection<VariableUsage> copyVariableUsageList(List<VariableUsage> originalVariableUsages) {
		return EcoreUtil.copyAll(originalVariableUsages);
	}

	/**
	 * Copies the passed list using the EcoreUtils class. 
	 * @param variableCharacterisations. A list containing VariableCharacterisation
	 * @return A copy of the list.
	 */
	public static Collection<VariableCharacterisation> copyVariableCharacterisations(
			List<VariableCharacterisation> variableCharacterisations) {
		return EcoreUtil.copyAll(variableCharacterisations);
	}

	private static String getFullParameterName(AbstractNamedReference ref) {
		String name = "";
		while (ref instanceof NamespaceReference) {
			NamespaceReference nsRef = (NamespaceReference) ref;
			name += nsRef.getReferenceName() + ".";
			ref = nsRef.getInnerReference_NamespaceReference();
		}
		return name += ref.getReferenceName();
	}
}
