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
import de.uka.ipd.sdq.identifier.Identifier;
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
public class AlternativeComponent  {

	private static Logger logger = Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	

	/** Model files will get the suffix here plus the generation number**/
	//private static String modelFilesSuffix = "-AC";
	
	//Repository lastRepository = null;
	
	Map<AssemblyContext, Map<BasicComponent, ProvidedAndRequiredRoleMapping>> alternativeMap = null;
	
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
		
		//only if this is called for the first time on a given repository, find alternatives again. 
		//if (lastRepository == null || !checkIdentity(r, lastRepository) || alternativeMap == null || rootNode == null){
			//lastRepository = r;
		
			System s = currentPCMInstance.getSystem();

			List<BasicComponent> repoComponents = filterBasicComponents(r
					.getComponents__Repository());
			logger.debug("I found " + repoComponents.size()
					+ " BasicComponents in the repository");

			Map<AssemblyContext, BasicComponent> assemblyContextToBasicComponentMap = getComponentsInSystem(
					s, r);
			logger.debug("I found " + assemblyContextToBasicComponentMap.size()
					+ " AssemblyContexts in the system");

			alternativeMap = findAlternatives(repoComponents,
					assemblyContextToBasicComponentMap);
			logger.debug("I have a mapping for " + alternativeMap.size()
					+ " AssemblyContexts with the following alternatives:");
			
			//rootNode = createEvolutionGraph(currentPCMInstance, alternativeMap);
			//logger.debug(rootNode.toString());
		//}

		//Create a new PCM instance for each alternative found
		//Only change one component at a time. 
		//Generate alternatives with one component different each
		//List<PCMInstance> l = rootNode.getChildrenOf(currentPCMInstance);
		
		return createAlternativePCMInstances(currentPCMInstance, alternativeMap);
	}

	/**
	 * Problem: This is not evolutionary, it traverses the whole design space at
	 * once. With the assumption that we always have a limited amount of
	 * alternative components, it might work. As this only looks at alternative 
	 * components in the current repository, it might not be too bad...
	 * 
	 * XXX: Check that we can evolve back to previous version, because other 
	 * things might have changed (combination) that we want to visit an 
	 * alternative component again. Probably cut away this whole graph thing. 
	 * 
	 * @param currentSolution
	 * @param alternativeMap2
	 * @return
	 */
	/*private EvolutionGraphNode createEvolutionGraph(
			PCMInstance currentSolution, Map<AssemblyContext, Map<BasicComponent, ProvidedAndRequiredRoleMapping>> alternativeMap2) {
		
		EvolutionGraphNode root = new EvolutionGraphNode(currentSolution);
		
		Vector<EvolutionGraphNode> allNodes = new Vector<EvolutionGraphNode>();
		allNodes.add(root);
		
		int counter = 0;
		//for each option, apply it once to each element of the set and keep one without applying it.
		for (Map.Entry<AssemblyContext, Map<BasicComponent, ProvidedAndRequiredRoleMapping>> e : alternativeMap2
				.entrySet()) {
			logger.debug("Assembly context " + e.getKey().getEntityName()
					+ " has " + e.getValue().size() + " alternatives:");
			
			/*
			 * Do not all the new nodes right away to the set of allNodes, but
			 * wait until we handled the alternatives of one assemblyContext.
			 * The reason is that we do not want the alternatives of one
			 * assemblyContext to be alternatives to each other. Example:
			 * Assembly Context A has alternatives B and C. Then, replacing B
			 * with C in a second step is not a new alternative, but already
			 * covered by the node that replaced A with C directly.
			 *
			Vector<EvolutionGraphNode> newCommonAlternativeNodes = new Vector<EvolutionGraphNode>();
			
			for (Map.Entry<BasicComponent, ProvidedAndRequiredRoleMapping> basicComponentEntry : e.getValue().entrySet()) {
				
				Vector<EvolutionGraphNode> newNodes = new Vector<EvolutionGraphNode>();
				//This is executed once for each option. 
				for (Iterator<EvolutionGraphNode> iterator = allNodes
						.iterator(); iterator.hasNext();) {
					EvolutionGraphNode evolutionGraphNode = iterator.next();
					//apply the MapEntry to this instance and add it to the set.
					PCMInstance inst = createNewPCMInstance(evolutionGraphNode.getNode(), e.getKey(), basicComponentEntry, counter);
					EvolutionGraphNode newNode = new EvolutionGraphNode(inst);
					evolutionGraphNode.addChild(newNode);
					newNodes.add(newNode);
				}
				//Only add to the temporary list (see explanation at declaration of this list above).
				newCommonAlternativeNodes.addAll(newNodes);
				counter++;
				
			}
			allNodes.addAll(newCommonAlternativeNodes);
		}
		
		return root;
	}*/

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
			Map<AssemblyContext, Map<BasicComponent, ProvidedAndRequiredRoleMapping>> alternativeMap2) {
		
		List<AssembledComponentDecision> l = new ArrayList<AssembledComponentDecision>();
		

		for (Map.Entry<AssemblyContext, Map<BasicComponent, ProvidedAndRequiredRoleMapping>> mapping : alternativeMap2
				.entrySet()) {
			logger.debug("Assembly context " + mapping.getKey().getEntityName()
					+ " has " + mapping.getValue().size() + " alternatives:");
			
			AssembledComponentDecision inst = createDesignDecision(currentSolution, mapping); 
			l.add(inst);
			
		}
		return l;
	}
	
	
	private AssembledComponentDecision createDesignDecision(
			PCMInstance currentSolution,
			Entry<AssemblyContext, Map<BasicComponent, ProvidedAndRequiredRoleMapping>> e) {
		AssembledComponentDecision decision = designdecisionFactoryImpl.eINSTANCE.createAssembledComponentDecision();
		EquivalentComponents ec = designdecisionFactoryImpl.eINSTANCE.createEquivalentComponents();
		
		for (Entry<BasicComponent, ProvidedAndRequiredRoleMapping> alternative : e.getValue().entrySet()) {
			ec.getRepositorycomponent().add(alternative.getKey());
		}
		
		decision.setAssemblycontext(e.getKey());
		decision.setDomain(ec);
		
		
		return decision;
	}

	/**
	 * 
	 * @param currentSolution
	 * @param assemblyContext
	 * @param basicComponentEntry
	 * @param counter to name the files differently, count. 
	 * @return
	 */
	/*public PCMInstance createNewPCMInstance(PCMInstance currentSolution,
			AssemblyContext assemblyContext, Entry<BasicComponent, ProvidedAndRequiredRoleMapping> basicComponentEntry, int counter) {

		PCMInstance newSolution = currentSolution.shallowCopy();
		
		*Used the ecore copy. For this, I needed to fix de.uka.ipd.sdq.stoex.impl.RandomVariableImpl,
		 * as setExpression threw a UnsupportedOperationException when trying to copy. Now 
		 * setExpression just does nothing*
		System newSystem = (System)EcoreUtil.copy(newSolution.getSystem());
		logger.debug("The new system: "+newSystem);
		
		newSolution.setSystem(newSystem);
		newSolution.appendToSystemFileName(modelFilesSuffix+counter);
		
		newSolution.setName(newSolution.getName()+modelFilesSuffix+counter);
		
		logger.debug("The old assembly we look for: "+assemblyContext);
		AssemblyContext changedAssemblyContext = null;
		
		EList<AssemblyContext> newAssemblyContexts = newSystem.getAssemblyContexts_ComposedStructure();
		for (AssemblyContext ac : newAssemblyContexts) {
			//logger.debug("An assembly in the new system: "+ac);
			if (checkIdentity(ac, assemblyContext)){
				logger.debug("This is the one:"+ac);
				changedAssemblyContext = ac;
				//Replace the assembly.
				int index = newAssemblyContexts.indexOf(ac);
				newAssemblyContexts.remove(ac);
				newAssemblyContexts.add(index, changedAssemblyContext);
				break;
			}
		}
		changedAssemblyContext.setEncapsulatedComponent_AssemblyContext(basicComponentEntry.getKey());
		
		//fix the required and provided roles
		fixReferencesToAssemblyContext(newSystem, changedAssemblyContext, basicComponentEntry.getKey());
		
		//I do not have to fix the allocation because I updated the assembly 
		//context, which is just referenced by the allocation. 
		//fixAllocation(changedAssemblyContext);
		
		return newSolution;
	}*/

	/**
	 * Fix assembly connectors and delegation connectors that point to the 
	 * changed assembly so that they point to the new required and provided roles.
	 * 
	 * If an alternative does not require a required interface of the original 
	 * anymore, delete the AssemblyConnector.   
	 *   
	 * @param changedAssemblyContext
	 * @param providedAndRequiredRoleMapping 
	 */
	public void fixReferencesToAssemblyContext(System system, AssemblyContext changedAssemblyContext, RepositoryComponent rc) {
		
		//call AlternativeComponent.generateDesigndecisions first to initialize.
		if (this.alternativeMap == null){
			throw new RuntimeException("The AlternativeComponent operator has not properly been initialized. Check previous Exceptions or contact the developers.");
		}
		
		ProvidedAndRequiredRoleMapping providedAndRequiredRoleMapping = this.alternativeMap.get(changedAssemblyContext).get(rc);
		
		EList<AssemblyConnector> acons = system.getAssemblyConnectors_ComposedStructure();
		
		//Lazy initialization of aconsToDelete, as I don't need it in most cases.
		List<AssemblyConnector> aconsToDelete = null;
		
		for (AssemblyConnector assemblyConnector : acons) {
			//check provided
			if ((checkIdentity(assemblyConnector.getProvidingAssemblyContext_AssemblyConnector(), changedAssemblyContext))){
				assemblyConnector.setProvidedRole_AssemblyConnector(providedAndRequiredRoleMapping.getProvidedMapping().get(assemblyConnector.getProvidedRole_AssemblyConnector()));
			}
			
			//check required. Delete assembly connector if required role is not needed anymore.
			if ((checkIdentity(assemblyConnector.getRequiringAssemblyContext_AssemblyConnector(), changedAssemblyContext))){
				RequiredRole rRole = providedAndRequiredRoleMapping.getRequiredMapping().get(assemblyConnector.getRequiredRole_AssemblyConnector());
				if (rRole != null){
					assemblyConnector.setRequiredRole_AssemblyConnector(rRole);
				} else {
					//store assembly connector to be deleted. Cannot delete them right away because of concurrentModificationException.
					if (aconsToDelete == null) {
						aconsToDelete =  new ArrayList<AssemblyConnector>();
					}
					aconsToDelete.add(assemblyConnector);
				}
			}
		}
		//delete all AssemblyConnectors not needed anymore.
		if (aconsToDelete != null){
			for (AssemblyConnector assemblyConnector : aconsToDelete) {
				acons.remove(assemblyConnector);
			}
		}
		
		//check provided delegation connectors
		EList<ProvidedDelegationConnector> pdecons = system.getProvidedDelegationConnectors_ComposedStructure();
		for (ProvidedDelegationConnector pdecon : pdecons) {
			if (checkIdentity(pdecon.getAssemblyContext_ProvidedDelegationConnector(), changedAssemblyContext)){
				pdecon.setInnerProvidedRole_ProvidedDelegationConnector(providedAndRequiredRoleMapping.getProvidedMapping().get(pdecon.getInnerProvidedRole_ProvidedDelegationConnector()));
			}
		}
		
		//check required delegation connectors. Delete the Connector if the new component does not need the role anymore.
		EList<RequiredDelegationConnector> rdecons = system.getRequiredDelegationConnectors_ComposedStructure();
		
		//Lazy initialization of rdeconsToDelete, as I don't need it in most cases.
		List<RequiredDelegationConnector> rdeconsToDelete = null;
		
		for (RequiredDelegationConnector rdecon : rdecons) {
			if (checkIdentity(rdecon.getAssemblyContext_RequiredDelegationConnector(), changedAssemblyContext)){
				RequiredRole reqRole = providedAndRequiredRoleMapping.getRequiredMapping().get(rdecon.getInnerRequiredRole_RequiredDelegationConnector());
				if (reqRole != null){
					rdecon.setInnerRequiredRole_RequiredDelegationConnector(reqRole);
				} else {
					//store delegation connector to be deleted. Cannot delete them right away because of concurrentModificationException
					if (rdeconsToDelete == null){
						rdeconsToDelete = new ArrayList<RequiredDelegationConnector>();
					}
					rdeconsToDelete.add(rdecon);
				}
			}
		}
		//delete all DelegationConnectors not needed anymore.
		if (rdeconsToDelete != null){
			for (RequiredDelegationConnector requiredDelegationConnector : rdeconsToDelete) {
				rdecons.remove(requiredDelegationConnector);
			}
		}
		
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

	private Map<AssemblyContext, BasicComponent> getComponentsInSystem(
			System s, Repository r) {

		logger.debug("getComponentsInSystem(..) called");

		Map<AssemblyContext, BasicComponent> result = new HashMap<AssemblyContext, BasicComponent>();

		/*
		 * Get all components assembled in the current system using the assembly
		 * contexts
		 */

		EList<AssemblyContext> assemblyContexts = s
				.getAssemblyContexts_ComposedStructure(); 

		for (AssemblyContext ac : assemblyContexts) {

			RepositoryComponent pct = ac.getEncapsulatedComponent_AssemblyContext();
			if (BasicComponent.class.isInstance(pct)) {
				result.put(ac, (BasicComponent) pct);
			}
		}

		return result;

	}

	private Map<AssemblyContext, Map<BasicComponent, ProvidedAndRequiredRoleMapping>> findAlternatives(
			List<BasicComponent> repoComponents,
			Map<AssemblyContext, BasicComponent> assemblyContextToBasicComponentMap) {
		//logger.debug("findAlternatives(..) called");
		// Use IdentityHashMap to compare BasicComponents only by reference
		// identity, i.e. two BasicComponents are only equal if they are the
		// same object.
		Map<AssemblyContext, Map<BasicComponent,ProvidedAndRequiredRoleMapping>> alternativeMap = new IdentityHashMap<AssemblyContext, Map<BasicComponent,ProvidedAndRequiredRoleMapping>>();

		for (AssemblyContext assemblyContext : assemblyContextToBasicComponentMap
				.keySet()) {
			Map<BasicComponent,ProvidedAndRequiredRoleMapping> map = getAlternatives(assemblyContextToBasicComponentMap.get(assemblyContext),repoComponents);
			if (map.size() > 0) {
				alternativeMap.put(assemblyContext, map);
			}
		}

		return alternativeMap;
	}

	/**
	 * Finds alternatives for a specific assembled component.
	 * @param assembledComponent
	 * @param repoComponents
	 * @return a Map of alternatives, which is possibly empty if no alternatives are found. 
	 */
	private Map<BasicComponent, ProvidedAndRequiredRoleMapping> getAlternatives(
			BasicComponent assembledComponent,
			List<BasicComponent> repoComponents) {
		//logger.debug("getAlternatives(..) called");
		Map<BasicComponent, ProvidedAndRequiredRoleMapping> map = new IdentityHashMap<BasicComponent, ProvidedAndRequiredRoleMapping>();
		for (BasicComponent repoComponent : repoComponents) {
			ProvidedAndRequiredRoleMapping p = findRoleMappingFor(assembledComponent, repoComponent);
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
	 * 
	 * @param assembledComponent
	 * @param alternativeComponent
	 * @return a map if alternativeComponent has compatible interfaces to replace
	 *         assembledComponent AND alternativeComponent !=
	 *         assembledComponent, null otherwise.
	 */
	private ProvidedAndRequiredRoleMapping findRoleMappingFor(BasicComponent assembledComponent,
			BasicComponent alternativeComponent) {

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
				if (checkIdentity(altpr.getProvidedInterface__ProvidedRole(),
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
				if (checkIdentity(altrr.getRequiredInterface__RequiredRole(),
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
		}
		logger.debug("These two have matching required interfaces:" + assembledComponent.getEntityName()+ " and "+alternativeComponent.getEntityName());

		ProvidedAndRequiredRoleMapping prrm = new ProvidedAndRequiredRoleMapping(providedMapping, requiredMapping);
		return prrm;
	}

	/**
	 * Checks for two PCM model elements whether they are the same, i.e. whether
	 * they have the same ID. The model elements have to be derived from
	 * Identifier.
	 * 
	 * @param i1
	 *            One Identifier
	 * @param i2
	 *            Another Identifier
	 * @return true if i1.getId().equals(i2.getId()), false otherwise
	 */
	public static boolean checkIdentity(Identifier i1, Identifier i2) {
		if (i1.getId().equals(i2.getId())){
			//logger.debug("Two model elements match with Id: "+i1.getId());
			return true;
		} else {
			return false;
		}
	}




}
