package de.uka.ipd.sdq.dsexplore.newcandidates.alternativecomponents;
import java.io.Console;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.newcandidates.INewCandidates;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.system.System;



public class AlternativeComponent implements INewCandidates {
	
	private static Logger logger = 
		Logger.getLogger(AlternativeComponent.class.getName());

	public AlternativeComponent() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PCMInstance> generateNewCandidates(PCMInstance currentSolution) {
		
		logger.setLevel(Level.ALL);
		logger.addAppender(null);
		
		java.lang.System.out.println("Alternative Plugin called.");
		logger.info("Alternative Plugin called");
		
		// TODO Generate an alternative :D
		Repository r = currentSolution.getRepository();
		System s = currentSolution.getSystem();
		
		List<BasicComponent> bcs = filterBasicComponents(r.getComponents__Repository());
		
 
		/*TODO: Handle Composite Components, either by treating them equal to 
		 * BasiComponents (not looking inside) or by further checking them for
		 * alternatives. First do first option.*/
		
		//Get all Assembly Contexts in the System
		List<AssemblyContext> actxts = s.getChildComponentContexts_ComposedStructure();
		
		Map<AssemblyContext, List<BasicComponent>> alternativeMap = findAlternatives(bcs, actxts);
		
		
		OCL ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		OCL.Helper helper = ocl.createOCLHelper();
		
		// set the OCL context classifier
	    //helper.setContext(EXTLibraryPackage.Literals.WRITER);
		helper.setContext(r.eClass());
		
		
		java.lang.System.out.println(helper);
		try {
			//OCLExpression expr = helper.createQuery("self");
			OCLExpression expr = helper.createQuery("self"); //.oclIsTypeOf(ProvidesComponentType)  implies  self.providedRoles_InterfaceProvidingEntity->size() >= 1 ");
			Object o = ocl.evaluate(r, expr);
			java.lang.System.out.println("Is equal? "+ (o == r) );
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ocl.evaluate(r, ocl.parse(new OCLInput("")) );
	    
		
		
		
		List<PCMInstance> l = new ArrayList<PCMInstance>();
		l.add(currentSolution);
		return l;
	}

	private List<BasicComponent> filterBasicComponents(EList<AssemblyContext> childComponents) {
		List<BasicComponent> l = new ArrayList<BasicComponent>();
		for (AssemblyContext actxt : childComponents) {
			if (!BasicComponent.class.isInstance(actxt.getEncapsulatedComponent_ChildComponentContext())){
				l.add((BasicComponent)childComponents);
			}
		}
		return l;
	}

	private Map<AssemblyContext, List<BasicComponent>> findAlternatives(
			List<BasicComponent> bcs, List<AssemblyContext> actxts) {
		//Use IdentityHashMap to compare BasicComponents only by reference identity, i.e. two BasicComponents are only equal if they are the same object.
		Map<AssemblyContext, List<BasicComponent>> alternativeMap = new IdentityHashMap<AssemblyContext, List<BasicComponent>>();
		
		for (AssemblyContext assemblyContext : actxts) {
			List<BasicComponent> l = new ArrayList<BasicComponent>();
			for (BasicComponent basicComponent : bcs) {
				if (isAlternativeFor(assemblyContext.getEncapsulatedComponent_ChildComponentContext(), basicComponent)){
					l.add(basicComponent);
				}
			}
			alternativeMap.put(assemblyContext, l);
		}
		
		return null;
	}

	private boolean isAlternativeFor(
			ProvidesComponentType assembledProvidedComponentType,
			BasicComponent alternativeComponent) {
		
		
		
		//Only look at basic components
		if (!BasicComponent.class.isInstance(assembledProvidedComponentType)){
			return false;
		}
		BasicComponent assembledComponent = (BasicComponent) assembledProvidedComponentType;
		
		//check whether they have the same interfaces
		/* TODO Assumption: An interface is always used in the same way and fully defines 
		whether two components are exchangeable.*/
		/* TODO Assumption: Note that I allow that a component can require the same interface 
		 * multiple times. Two components are only alternatives to each other, if they 
		 * provide the same interfaces equally often. For provided interfaces, there just 
		 * needs to be one matching interface */  
		
		//Start with provided interfaces. Alternative component  
		EList<ProvidedRole> altprl = alternativeComponent.getProvidedRoles_InterfaceProvidingEntity();
		EList<ProvidedRole> assprl = assembledComponent.getProvidedRoles_InterfaceProvidingEntity();
		
		//TODO: store which provided role can replace which other provided role. 
		Map<ProvidedRole,ProvidedRole> mapping = new IdentityHashMap<ProvidedRole, ProvidedRole>();
		for (ProvidedRole asspr : assprl) {
			for (ProvidedRole altpr : altprl){
				//TODO: Allow derived interfaces at the alternativeComponent
				//TODO: Rather use same ImplementationComponentType?
				if (altpr.getProvidedInterface__ProvidedRole() == asspr.getProvidedInterface__ProvidedRole()){
					mapping.put(asspr, altpr);
					break;
				}
			}
		}
		
		//If not all provided interfaces of the assembled component are provided by the alternative, return false.  
		if (mapping.size() != assprl.size()) return false;
		
		//Now look at the required interfaces. alternativeComponent must not require 
		//more than assembled component requires.
		//TODO: Allow super interfaces at the alternative component
		
		//TODO
		
		return false;
	}

	private List<BasicComponent> filterBasicComponents(List<ProvidesComponentType> pcts) {
		List<BasicComponent> l = new ArrayList<BasicComponent>();
		for (ProvidesComponentType providesComponentType : pcts) {
			if (!BasicComponent.class.isInstance(providesComponentType)){
				l.add((BasicComponent)pcts);
			}
		}
		return l;
		
	}

}
