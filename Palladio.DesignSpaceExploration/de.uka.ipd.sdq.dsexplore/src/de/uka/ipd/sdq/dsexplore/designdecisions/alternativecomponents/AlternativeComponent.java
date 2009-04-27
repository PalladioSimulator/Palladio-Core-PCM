package de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDecision;
import de.uka.ipd.sdq.pcm.designdecision.EquivalentComponents;
import de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionFactoryImpl;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.system.System;

//Singleton
/**
 * TODO: Currently, components must have the same provided _and_ required roles, otherwise, an erroneous system is created.   
 */
public class AlternativeComponent  {

	private static Logger logger = Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	

	/** Model files will get the suffix here plus the generation number**/
	//private static String modelFilesSuffix = "-AC";
	
	//Repository lastRepository = null;
	
	Map<AssemblyContext, Map<RepositoryComponent, ComponentReplacer>> alternativeMap = null;
	
	//EvolutionGraphNode rootNode = null;
	
	private static AlternativeComponent instance = new AlternativeComponent();

	private AlternativeComponent() {
		
	}
	
	public static AlternativeComponent getInstance(){
		return AlternativeComponent.instance;
	}

	/**
	 * @see de.uka.ipd.sdq.dsexplore.newcandidates.INewCandidates#generateNewCandidates(de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult)
	 */
	public List<AssembledComponentDecision> generateDesignDecisions(PCMInstance currentPCMInstance) {
		
		Repository r = currentPCMInstance.getRepository();

		
			System s = currentPCMInstance.getSystem();

			//TODO: Filter Repository components here to allow exchange of composite components
			//List<RepositoryComponent> repoComponents = filterBasicComponents(r.getComponents__Repository());
			List<RepositoryComponent> repoComponents = r.getComponents__Repository();
			logger.debug("I found " + repoComponents.size()
					+ " BasicComponents in the repository");

			Map<AssemblyContext, RepositoryComponent> assemblyContextToBasicComponentMap = getComponentsInSystem(
					s, r);
			logger.debug("I found " + assemblyContextToBasicComponentMap.size()
					+ " AssemblyContexts with basic components in the system");

			alternativeMap = findAlternatives(repoComponents,
					assemblyContextToBasicComponentMap, s);
			logger.debug("I have a mapping for " + alternativeMap.size()
					+ " AssemblyContexts with the following alternatives:");

		return createAlternativePCMInstances(currentPCMInstance, alternativeMap);
	}

	/**
	 * Creates a new PCM instance object for each alternative found. 
	 * Each instance is different in one component to the original. 
	 * Calls createNewPCMInstance for each alternative to be generated. 
	 * @param currentSolution The current solution the new ones will base on
	 * @param alternativeMap2 The Map containing all replacement options
	 * @param root 
	 * @return A list of new PCM instances
	 */
	private List<AssembledComponentDecision> createAlternativePCMInstances(
			PCMInstance currentSolution,
			Map<AssemblyContext, Map<RepositoryComponent, ComponentReplacer>> alternativeMap2) {
		
		List<AssembledComponentDecision> l = new ArrayList<AssembledComponentDecision>();
		

		for (Map.Entry<AssemblyContext, Map<RepositoryComponent, ComponentReplacer>> mapping : alternativeMap2
				.entrySet()) {
			logger.debug("Assembly context " + mapping.getKey().getEntityName()
					+ " has " + mapping.getValue().size() + " fitting component(s).");
			
			//only save design decision if there are at least two components
			if (mapping.getValue().size() > 1){
				AssembledComponentDecision inst = createDesignDecision(currentSolution, mapping); 
				l.add(inst);
			}
			
		}
		return l;
	}
	
	
	private AssembledComponentDecision createDesignDecision(
			PCMInstance currentSolution,
			Entry<AssemblyContext, Map<RepositoryComponent, ComponentReplacer>> mapping) {
		AssembledComponentDecision decision = designdecisionFactoryImpl.eINSTANCE.createAssembledComponentDecision();
		EquivalentComponents ec = designdecisionFactoryImpl.eINSTANCE.createEquivalentComponents();
		
		for (Entry<RepositoryComponent, ComponentReplacer> alternative : mapping.getValue().entrySet()) {
			ec.getRepositorycomponent().add(alternative.getKey());
		}
		
		decision.setAssemblycontext(mapping.getKey());
		decision.setDomain(ec);
		
		
		return decision;
	}


	/**
	 * Fix assembly connectors and delegation connectors that point to the 
	 * changed assembly so that they point to the new required and provided roles.
	 * 
	 * If an alternative does not require a required interface of the original 
	 * anymore, delete the AssemblyConnector.  
	 * 
	 *  TODO: Does not work with the initially assembled component. 
	 *   
	 * @param changedAssemblyContext
	 * @param currentComponent 
	 * @param providedAndRequiredRoleMapping 
	 */
	public void fixReferencesToAssemblyContext(System system, AssemblyContext changedAssemblyContext, RepositoryComponent newComponent, RepositoryComponent currentComponent) {
		
		//call AlternativeComponent.generateDesigndecisions first to initialize.
		if (this.alternativeMap == null){
			throw new RuntimeException("The AlternativeComponent operator has not properly been initialized. Check previous Exceptions or contact the developers.");
		}
		
		ComponentReplacer providedAndRequiredRoleMapping = this.alternativeMap.get(changedAssemblyContext).get(newComponent);
		providedAndRequiredRoleMapping.replace();
		
	}

	private List<BasicComponent> filterBasicComponents(
			EList<RepositoryComponent> list) {
		logger.debug("filterBasicComponent(..) called with a list of "
				+ list.size() + " ProvidesComponentTypes.");
		List<BasicComponent> l = new ArrayList<BasicComponent>();
		for (RepositoryComponent repositoryComponentType : list) {
			if (BasicComponent.class.isInstance(repositoryComponentType)) {
				l.add((BasicComponent) repositoryComponentType);
			}
		}
		return l;

	}

	private Map<AssemblyContext, RepositoryComponent> getComponentsInSystem(
			System s, Repository r) {

		logger.debug("getComponentsInSystem(..) called");

		Map<AssemblyContext, RepositoryComponent> result = new HashMap<AssemblyContext, RepositoryComponent>();

		/*
		 * Get all components assembled in the current system using the assembly
		 * contexts
		 */

		EList<AssemblyContext> assemblyContexts = s
				.getAssemblyContexts_ComposedStructure(); 

		for (AssemblyContext ac : assemblyContexts) {

			RepositoryComponent pct = ac.getEncapsulatedComponent_AssemblyContext();
			result.put(ac, pct);
		}

		return result;

	}

	private Map<AssemblyContext, Map<RepositoryComponent, ComponentReplacer>> findAlternatives(
			List<RepositoryComponent> repoComponents,
			Map<AssemblyContext, RepositoryComponent> assemblyContextToBasicComponentMap, System s) {
		//logger.debug("findAlternatives(..) called");
		// Use IdentityHashMap to compare BasicComponents only by reference
		// identity, i.e. two BasicComponents are only equal if they are the
		// same object.
		Map<AssemblyContext, Map<RepositoryComponent,ComponentReplacer>> alternativeMap = new IdentityHashMap<AssemblyContext, Map<RepositoryComponent,ComponentReplacer>>();

		for (AssemblyContext assemblyContext : assemblyContextToBasicComponentMap
				.keySet()) {
			Map<RepositoryComponent,ComponentReplacer> map = getAlternatives(assemblyContext, assemblyContextToBasicComponentMap.get(assemblyContext),repoComponents, s);
			if (map.size() > 0) {
				alternativeMap.put(assemblyContext, map);
			}
		}

		return alternativeMap;
	}

	/**
	 * Finds alternatives for a specific assembled component.
	 * @param assemblyContext 
	 * @param assembledComponent
	 * @param repoComponents
	 * @param s 
	 * @return a Map of alternatives, which is possibly empty if no alternatives are found. 
	 */
	private Map<RepositoryComponent, ComponentReplacer> getAlternatives(
			AssemblyContext assemblyContext, RepositoryComponent assembledComponent,
			List<RepositoryComponent> repoComponents, System s) {
		//logger.debug("getAlternatives(..) called");
		Map<RepositoryComponent, ComponentReplacer> map = new IdentityHashMap<RepositoryComponent, ComponentReplacer>();
		for (RepositoryComponent repoComponent : repoComponents) {
			//if compatible, this returns not null
			ComponentReplacer p = findRoleMappingFor(assemblyContext, assembledComponent, repoComponent, s);
			
			
			
			if (p != null) {
				map.put(repoComponent,p);
				logger.debug("Found an alternative: "
						+ assembledComponent.getEntityName()
						+ " can be replaced by "
						+ repoComponent.getEntityName() + ".");
			} /*else {
				logger.debug(repoComponent.getEntityName()
						+ " is no alternative for "
						+ assembledComponent.getEntityName());
			}*/
		}
		return map;
	}

	/**
	 * Checks provided and required interfaces and returns whether the
	 * interfaces are compatible so that the alternativeComponent can replace
	 * the assembledComponent. Returns the mapping of the provided and 
	 * required roles to their counterparts, to be able to replace the 
	 * component later. Returns null if both parameters refer to the
	 * same BasicComponent.
	 * 
	 * Current notion of compatible: allows the alternative to provide more and
	 * require less. TODO: Allow super interfaces and sub interfaces where
	 * appropriate
	 * @param assemblyContext 
	 * 
	 * @param assembledComponent
	 * @param alternativeComponent
	 * @param s 
	 * @return a map if alternativeComponent has compatible interfaces to replace
	 *         assembledComponent AND alternativeComponent !=
	 *         assembledComponent, null otherwise.
	 */
	private ComponentReplacer findRoleMappingFor(AssemblyContext assemblyContext, RepositoryComponent assembledComponent,
			RepositoryComponent alternativeComponent, System s) {

		//logger.debug("isAlternativeFor(..) called");

		// first check whether the two parameters are the same component, if
		// yes, return false.
		//if (checkIdentity(assembledComponent, alternativeComponent))
		//	return null;
		//TODO: in the case above, we could save te whole calculation. But for now, leave it like this. 

		// check whether they have compatible interfaces
		/*
		 * TODO Assumption: An interface is always used in the same way and
		 * fully defines whether two components are exchangeable.
		 */

		/*
		 * TODO Assumption: Note that I allow that a component can require the
		 * same interface multiple times. Two components are only alternatives
		 * to each other, if they provide the same interfaces equally often. For
		 * provided interfaces, there just needs to be one matching interface
		 */
		ComponentReplacer cr = new ComponentReplacer();

		// Start with provided interfaces. Alternative component
		EList<ProvidedRole> altprl = alternativeComponent
				.getProvidedRoles_InterfaceProvidingEntity();
		EList<ProvidedRole> assprl = assembledComponent
				.getProvidedRoles_InterfaceProvidingEntity();

		// TODO: store which provided role can replace which other provided
		// role.
		Map<ProvidedRole, ProvidedRole> providedMapping = new IdentityHashMap<ProvidedRole, ProvidedRole>();
		for (ProvidedRole asspr : assprl) {
			for (ProvidedRole altpr : altprl) {
				// TODO: Allow derived interfaces at the alternativeComponent
				// TODO: Rather use same ImplementationComponentType?
/*				logger.debug("Interface "
						+ altpr.getProvidedInterface__ProvidedRole()
						+ " and Interface "
						+ asspr.getProvidedInterface__ProvidedRole());*/
				if (EMFHelper.checkIdentity(altpr.getProvidedInterface__ProvidedRole(),
						asspr.getProvidedInterface__ProvidedRole())) {
					providedMapping.put(asspr, altpr);

					break;
				}
			}
		}

		// If not all provided interfaces of the assembled component are
		// provided by the alternative, return false.
		if (providedMapping.size() != assprl.size()) {
/*			logger.debug("The provided interfaces of "
					+ assembledComponent.getEntityName() + " and "
					+ alternativeComponent.getEntityName() + " do not match.");
			logger.debug("Mapping size: " + providedMapping.size()
					+ ", provided role list size: " + altprl.size());*/
			return null;
		} else {
			
			//find connector that points to this assembly context
			List<ConnectorAdjuster> cas = findProvidedConnectors(assemblyContext, assembledComponent, s, providedMapping);

			//add to list
			cr.addAllConnectorAdjuster(cas);
		}
		
		logger.debug("These two have matching provided interfaces:" + assembledComponent.getEntityName()+ " and "+alternativeComponent.getEntityName());

		// Now look at the required interfaces. alternativeComponent must not
		// require
		// more than assembled component requires.
		// TODO: Allow super interfaces at the alternative component
		EList<RequiredRole> altrrl = alternativeComponent
				.getRequiredRoles_InterfaceRequiringEntity();
		EList<RequiredRole> assrrl = assembledComponent
				.getRequiredRoles_InterfaceRequiringEntity();

		// TODO: store which required role can replace which other required
		// role.
		Map<RequiredRole, RequiredRole> requiredMapping = new IdentityHashMap<RequiredRole, RequiredRole>();
		// Outer loop is alternative, because it must require no more and must
		// be completely checked.
		for (RequiredRole altrr : altrrl) {
			for (RequiredRole assrr : assrrl) {
				// TODO: Allow derived interfaces at the alternativeComponent
				// TODO: Rather use same ImplementationComponentType?
				if (EMFHelper.checkIdentity(altrr.getRequiredInterface__RequiredRole(),
						assrr.getRequiredInterface__RequiredRole())) {
					requiredMapping.put(assrr, altrr);
					break;
				}
				// TODO: break loop and return false when noticing that one role
				// cannot be fit.
			}
		}

		// If not all required interfaces of the alternative component are
		// required by the assembled one, return false.
		if (requiredMapping.size() != altrrl.size()) {
/*			logger.debug("The required interfaces of "
					+ assembledComponent.getEntityName() + " and "
					+ alternativeComponent.getEntityName() + " do not match.");
			logger.debug("Mapping size: " + requiredMapping.size()
					+ ", required role list size: " + altrrl.size());*/
			return null;
		} else {
			
			//find connector that points to this assembly context
			List<ConnectorAdjuster> cas = findRequiredConnectors(assemblyContext, assembledComponent, s, requiredMapping);

			//add to list
			cr.addAllConnectorAdjuster(cas);
		}
		logger.debug("These two have matching required interfaces:" + assembledComponent.getEntityName()+ " and "+alternativeComponent.getEntityName());

		//ProvidedAndRequiredRoleMapping prrm = new ProvidedAndRequiredRoleMapping(providedMapping, requiredMapping);
		return cr;
	}

	private List<ConnectorAdjuster> findRequiredConnectors(
			AssemblyContext assemblyContext, RepositoryComponent assembledComponent,
			System s, Map<RequiredRole, RequiredRole> requiredMapping) {
		List<ConnectorAdjuster> result = new ArrayList<ConnectorAdjuster>();
		
		List<AssemblyConnector> ascs = s.getAssemblyConnectors_ComposedStructure();
		for (AssemblyConnector assemblyConnector : ascs) {
			if (EMFHelper.checkIdentity(assemblyConnector.getRequiringAssemblyContext_AssemblyConnector(), assemblyContext)){
				RequiredRole role = requiredMapping.get(assemblyConnector.getRequiredRole_AssemblyConnector());
				result.add(new OutgoingAssemblyConnectorAdjuster(assemblyConnector, role));
			}
		}
		
		List<RequiredDelegationConnector> rdcs = s.getRequiredDelegationConnectors_ComposedStructure();
		
		for (RequiredDelegationConnector requiredDelegationConnector : rdcs) {
			if (EMFHelper.checkIdentity(requiredDelegationConnector.getInnerRequiredRole_RequiredDelegationConnector(), assemblyContext)){
				RequiredRole role = requiredMapping.get(requiredDelegationConnector.getInnerRequiredRole_RequiredDelegationConnector());
				result.add(new RequiredDelegationConnectorAdjuster(requiredDelegationConnector, role));
			}
		}
		
		return result;
	}

	private List<ConnectorAdjuster> findProvidedConnectors(
			AssemblyContext assemblyContext, RepositoryComponent assembledComponent, System s, Map<ProvidedRole, ProvidedRole> providedMapping) {
		List<ConnectorAdjuster> result = new ArrayList<ConnectorAdjuster>();
		
		List<AssemblyConnector> ascs = s.getAssemblyConnectors_ComposedStructure();
		for (AssemblyConnector assemblyConnector : ascs) {
			if (EMFHelper.checkIdentity(assemblyConnector.getProvidingAssemblyContext_AssemblyConnector(), assemblyContext)){
				ProvidedRole role = providedMapping.get(assemblyConnector.getProvidedRole_AssemblyConnector());
				result.add(new IncomingAssemblyConnectorAdjuster(assemblyConnector, role));
			}
		}
		
		List<ProvidedDelegationConnector> pdcs = s.getProvidedDelegationConnectors_ComposedStructure();
		
		for (ProvidedDelegationConnector providedDelegationConnector : pdcs) {
			if (EMFHelper.checkIdentity(providedDelegationConnector.getAssemblyContext_ProvidedDelegationConnector(), assemblyContext)){
				ProvidedRole role = providedMapping.get(providedDelegationConnector.getInnerProvidedRole_ProvidedDelegationConnector());
				result.add(new ProvidedDelegationConnectorReplacer(providedDelegationConnector, role));
			}
		}
		
		return result;
	}





}
