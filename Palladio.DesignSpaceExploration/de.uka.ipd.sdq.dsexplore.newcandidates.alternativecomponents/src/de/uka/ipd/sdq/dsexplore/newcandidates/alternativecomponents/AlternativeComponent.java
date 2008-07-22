package de.uka.ipd.sdq.dsexplore.newcandidates.alternativecomponents;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.dsedecorator.RepositorySystemDecorator;
import de.uka.ipd.sdq.dsexplore.dsedecorator.dsedecoratorFactory;
import de.uka.ipd.sdq.dsexplore.newcandidates.INewCandidates;
import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.system.System;



public class AlternativeComponent implements INewCandidates {
	
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");

	public AlternativeComponent() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PCMInstance> generateNewCandidates(PCMInstance currentSolution) {
		
		/*logger.setLevel(Level.ALL);
		logger.addAppender(null);*/
		
		logger.debug("Alternative Plugin called.");
				
		// TODO Generate an alternative :D
		Repository r = currentSolution.getRepository();
		System s = currentSolution.getSystem();
		
		RepositorySystemDecorator rsd = dsedecoratorFactory.eINSTANCE.createRepositorySystemDecorator();
		rsd.setSystem(s);
		rsd.getRepositories().add(r);
		
			
			List<BasicComponent> repoComponents = filterBasicComponents(r.getComponents__Repository());
			logger.debug("I found "+repoComponents.size() +" BasicComponents in the repository");
			
			Map<AssemblyContext, BasicComponent> assemblyContextToBasicComponentMap = getComponentsInSystem(s, r);
			logger.debug("I found "+assemblyContextToBasicComponentMap.size() +" AssemblyContexts in the system");
			
			Map<AssemblyContext, Set<BasicComponent>> alternativeMap = findAlternatives(repoComponents, assemblyContextToBasicComponentMap);
			logger.debug("I have a mapping for "+alternativeMap.size() + " AssemblyContexts with the following alternatives:");
									
			for (Map.Entry<AssemblyContext, Set<BasicComponent>> e : alternativeMap.entrySet()) {
				logger.debug("Assembly context "+e.getKey().getEntityName() +" has "+e.getValue().size()+" alternatives:");
				for (BasicComponent basicComponent : e.getValue()) {
					logger.debug("    Alternative: "+basicComponent.getEntityName());
				}
			}
			
  
		
		
		
		List<PCMInstance> l = new ArrayList<PCMInstance>();
		l.add(null);
		return l;
	}

	private List<BasicComponent> filterBasicComponents(
			EList<ProvidesComponentType> components__Repository) {
		logger.debug("filterBasicComponent(..) called with a list of "+components__Repository.size()+" ProvidesComponentTypes.");
		List<BasicComponent> l = new ArrayList<BasicComponent>();
		for (ProvidesComponentType providesComponentType : components__Repository) {
			if (BasicComponent.class.isInstance(providesComponentType)) {
				l.add((BasicComponent) providesComponentType);
			}
		}
		return l;

	}


	private Map<AssemblyContext, BasicComponent> getComponentsInSystem(System s, Repository r)  {
		
		logger.debug("getComponentsInSystem(..) called");
		
		Map<AssemblyContext, BasicComponent> result = new HashMap<AssemblyContext, BasicComponent>();
		
		/* Get all components assembled in the current system using the assembly contexts*/
		//helper.setContext(s.eClass());
		//expr = helper.createQuery("self.childComponentContexts_ComposedStructure");//"->collect(assembly | assembly.encapsulatedComponent_ChildComponentContext))");
		EList<AssemblyContext> assemblyContexts = s.getChildComponentContexts_ComposedStructure(); //(Set<AssemblyContext>)helper.getOCL().evaluate(s, expr);
		

		for (AssemblyContext ac : assemblyContexts) {

			ProvidesComponentType pct = ac.getEncapsulatedComponent_ChildComponentContext();
			if (BasicComponent.class.isInstance(pct)) {			
			  result.put(ac, (BasicComponent)pct);
			}
		}

		return result;

	}


	private Map<AssemblyContext, Set<BasicComponent>> findAlternatives(
			List<BasicComponent> repoComponents, Map<AssemblyContext, BasicComponent> assemblyContextToBasicComponentMap) {
		logger.debug("findAlternatives(..) called");
		//Use IdentityHashMap to compare BasicComponents only by reference identity, i.e. two BasicComponents are only equal if they are the same object.
		Map<AssemblyContext, Set<BasicComponent>> alternativeMap = new IdentityHashMap<AssemblyContext, Set<BasicComponent>>();
		
		for (AssemblyContext assemblyContext : assemblyContextToBasicComponentMap.keySet()) {
			alternativeMap.put(assemblyContext, getAlternatives(assemblyContextToBasicComponentMap.get(assemblyContext), repoComponents));
		}
		
		return alternativeMap;
	}

	private Set<BasicComponent> getAlternatives(BasicComponent assembledComponent,	List<BasicComponent> repoComponents) {
		logger.debug("getAlternatives(..) called");
		Set<BasicComponent> l = new HashSet<BasicComponent>();
		for (BasicComponent repoComponent : repoComponents) {
			if (isAlternativeFor(assembledComponent, repoComponent)){
				l.add(repoComponent);
				logger.debug("Found an alternative: "
					+repoComponent.getEntityName()+" can be replaced by "
					+assembledComponent.getEntityName()+".");
			}
			logger.debug(repoComponent.getEntityName()+" is no alternative for "+assembledComponent.getEntityName());
		}
		return l;
	}

	/**
	 * Checks provided and required interfaces and returns whether the 
	 * interfaces are compatible so that the alternativeComponent can 
	 * replace the assembledComponent. Returns false if both parameters 
	 * refer to the same BasicComponent.  
	 * 
	 * Current notion of compatible: allows the alternative to provide more and 
	 * require less. TODO: Allow super interfaces and sub interfaces where appropriate
	 * 
	 * @param assembledComponent
	 * @param alternativeComponent
	 * @return true if alternativeComponent has compatible interfaces to 
	 * replace assembledComponent AND alternativeComponent != assembledComponent, 
	 * false otherwise. 
	 */
	private boolean isAlternativeFor(BasicComponent assembledComponent,	BasicComponent alternativeComponent) {
		
		logger.debug("isAlternativeFor(..) called");
		
		//first check whether the two parameters are the same component, if yes, return false.
		if (checkIdentity(assembledComponent, alternativeComponent))
			return false;
		
		//check whether they have compatible interfaces
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
		Map<ProvidedRole,ProvidedRole> providedMapping = new IdentityHashMap<ProvidedRole, ProvidedRole>();
		for (ProvidedRole asspr : assprl) {
			for (ProvidedRole altpr : altprl){
				//TODO: Allow derived interfaces at the alternativeComponent
				//TODO: Rather use same ImplementationComponentType?
				logger.debug("Interface "+altpr.getProvidedInterface__ProvidedRole()+ " and Interface "+asspr.getProvidedInterface__ProvidedRole());
				if (checkIdentity(altpr.getProvidedInterface__ProvidedRole(), asspr.getProvidedInterface__ProvidedRole())){
					providedMapping.put(asspr, altpr);
					break;
				}
			}
		}
		
		//If not all provided interfaces of the assembled component are provided by the alternative, return false.  
		if (providedMapping.size() != assprl.size()){
			logger.debug("The provided interfaces of "+assembledComponent.getEntityName()+" and "+alternativeComponent.getEntityName()+" do not match.");
			logger.debug("Mapping size: "+providedMapping.size()+", provided role list size: "+altprl.size());
			return false;
		}
		
		//Now look at the required interfaces. alternativeComponent must not require 
		//more than assembled component requires.
		//TODO: Allow super interfaces at the alternative component
		EList<RequiredRole> altrrl = alternativeComponent.getRequiredRoles_InterfaceRequiringEntity();
		EList<RequiredRole> assrrl = assembledComponent.getRequiredRoles_InterfaceRequiringEntity();
		
		//TODO: store which required role can replace which other required role. 
		Map<RequiredRole,RequiredRole> requiredMapping = new IdentityHashMap<RequiredRole, RequiredRole>();
		//Outer loop is alternative, because it must require no more and must be completely checked. 
		for (RequiredRole altrr : altrrl) {
			for (RequiredRole assrr : assrrl){
				//TODO: Allow derived interfaces at the alternativeComponent
				//TODO: Rather use same ImplementationComponentType?
				if (checkIdentity(altrr.getRequiredInterface__RequiredRole(), assrr.getRequiredInterface__RequiredRole())){
					requiredMapping.put(assrr, altrr);
					break;
				}
				//TODO: break loop and return false when noticing that one role cannot be fit.
			}
		}
		
		//If not all required interfaces of the alternative component are required by the assembled one, return false.  
		if (requiredMapping.size() != altrrl.size()){
			logger.debug("The required interfaces of "+assembledComponent.getEntityName()+" and "+alternativeComponent.getEntityName()+" do not match.");
			logger.debug("Mapping size: "+requiredMapping.size()+", required role list size: "+altrrl.size());
			return false;
		}
		
		
		return true;
	}

	/** Checks for two PCM model elements whether they are the same, i.e. 
	 *  whether they have the same ID. The model elements have to be derived 
	 *  from Identifier.  
	 *  @param i1 One Identifier
	 *  @param i2 Another Identifier
	 *  @return true if i1.getId().equals(i2.getId()), fals otherwise
	 */
	private boolean checkIdentity(Identifier i1, Identifier i2) {
		if (i1.getId().equals(i2.getId()))
			return true;
		else
			return false;
	}

}


