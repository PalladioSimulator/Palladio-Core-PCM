package de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.helper.EntityComparator;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.Connector;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDegree;
import de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionFactoryImpl;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

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
	public List<AssembledComponentDegree> generateDesignDecisions(PCMInstance pcmInstance) {
		
		//Retrieve all components from all repositories
		
		List<Repository> repositories = pcmInstance.getRepositories();
		
		System s = pcmInstance.getSystem();

		List<RepositoryComponent> repoComponents = new ArrayList<RepositoryComponent>(15);
		for (Repository repository : repositories) {
			repoComponents.addAll(repository.getComponents__Repository());
		}
		 

		alternativeMap = findAlternatives(repoComponents,s.getAssemblyContexts__ComposedStructure(),s);
		logger.debug("I have a mapping for " + alternativeMap.size()
				+ " AssemblyContexts with the following alternatives:");

		return createAssembledComponentDecisionsInstances(pcmInstance, alternativeMap);
	}

	/**
	 * Creates a an {@link AssembledComponentDecision} for each alternative found. 
	 * Calls createDesignDecision for each alternative to be generated. 
	 * @param pcmInstance The current solution the new ones will base on
	 * @param alternativeMap2 The Map containing all replacement options
	 * @return A list of design decisions
	 */
	private List<AssembledComponentDegree> createAssembledComponentDecisionsInstances(
			PCMInstance pcmInstance,
			Map<AssemblyContext, Map<RepositoryComponent, ComponentReplacer>> alternativeMap2) {
		
		List<AssembledComponentDegree> l = new ArrayList<AssembledComponentDegree>();
		

		for (Map.Entry<AssemblyContext, Map<RepositoryComponent, ComponentReplacer>> mapping : alternativeMap2
				.entrySet()) {
			logger.debug("Assembly context " + mapping.getKey().getEntityName()
					+ " has " + mapping.getValue().size() + " fitting component(s).");
			
			//only save design decision if there are at least two components
			if (mapping.getValue().size() > 1){
				AssembledComponentDegree inst = createDesignDecision(pcmInstance, mapping); 
				l.add(inst);
			}
			
		}
		return l;
	}
	
	/**
	 * Creates a {@link AssembledComponentDecision} for the given Entry. 
	 * The design decisions has the domain of all {@link RepositoryComponent}s 
	 * that are alternatives for the given {@link AssemblyContext}.  
	 * @param pcmInstance
	 * @param mappingEntry
	 * @return
	 */
	private AssembledComponentDegree createDesignDecision(
			PCMInstance pcmInstance,
			Entry<AssemblyContext, Map<RepositoryComponent, ComponentReplacer>> mappingEntry) {
		AssembledComponentDegree decision = designdecisionFactoryImpl.eINSTANCE.createAssembledComponentDegree();
		
		//Set domain to be all alternative components, i.e. all RepositoryComponents in the mapping. 
		decision.getClassDesignOptions().addAll(mappingEntry.getValue().keySet());
		
		decision.setPrimaryChanged(mappingEntry.getKey());
	
		return decision;
	}


	/**
	 * Set the given {@link RepositoryComponent} as the encapsulated component of the given {@link AssemblyContext}
	 * 
	 * Fixes assembly connectors and delegation connectors that point to the 
	 * changed assembly so that they point to the new required and provided roles.
	 * 
	 * To do so, the right previously build component replacer is retrieved from {@link AlternativeComponent#alternativeMap}
	 * and replace is invoked, which applies the change.    
	 *
	 * @param changedAssemblyContext
	 * @param newComponent
	 * @param currentComponent
	 */
	public void applyChange(AssemblyContext changedAssemblyContext, RepositoryComponent newComponent) {
		
		//call AlternativeComponent.generateDesigndecisions first to initialize.
		if (this.alternativeMap == null){
			throw new RuntimeException("The AlternativeComponent operator has not properly been initialized. Check previous Exceptions or contact the developers.");
		}
		changedAssemblyContext.setEncapsulatedComponent__AssemblyContext(newComponent);
		
		Map<RepositoryComponent, ComponentReplacer> map =  this.alternativeMap.get(changedAssemblyContext);
		ComponentReplacer componentReplacer = map.get(newComponent);
		componentReplacer.replace();
	}

	private Map<AssemblyContext, Map<RepositoryComponent, ComponentReplacer>> findAlternatives(
			List<RepositoryComponent> repoComponents,
			List<AssemblyContext> assemblyContexts, System s) {
		
		// Use IdentityHashMap to compare BasicComponents only by reference
		// identity, i.e. two BasicComponents are only equal if they are the
		// same object.
		Comparator<Entity> c = new EntityComparator();

		Map<AssemblyContext, Map<RepositoryComponent,ComponentReplacer>> alternativeMap = new TreeMap<AssemblyContext, Map<RepositoryComponent,ComponentReplacer>>(c);

		for (AssemblyContext assemblyContext : assemblyContexts) {
			Map<RepositoryComponent,ComponentReplacer> map = getAlternatives(assemblyContext, repoComponents, s);
			if (map.size() > 0) {
				alternativeMap.put(assemblyContext, map);
			}
		}

		return alternativeMap;
	}

	/**
	 * Finds alternatives for a specific assembled component. To do so, this checks for each {@link RepositoryComponent} in the given {@link Repository}
	 * whether it fits in the given {@link AssemblyContext}.
	 * @param assemblyContext 
	 * @param repoComponents
	 * @param s 
	 * @return a Map of alternative {@link RepositoryComponent} with the {@link ComponentReplacer} that can put them in the {@link AssemblyContext}, which is possibly empty if no alternatives are found. 
	 */
	private Map<RepositoryComponent, ComponentReplacer> getAlternatives(
			AssemblyContext assemblyContext, List<RepositoryComponent> repoComponents, System s) {

		Comparator<Entity> c = new EntityComparator();
		Map<RepositoryComponent, ComponentReplacer> map = new TreeMap<RepositoryComponent, ComponentReplacer>(c);
		for (RepositoryComponent repoComponent : repoComponents) {
			
			//if compatible, this returns not null
			ComponentReplacer p = findRoleMappingFor(assemblyContext, repoComponent, s);
		
			if (p != null) {
				map.put(repoComponent,p);
				logger.debug("Found an alternative: "
						+ assemblyContext.getEntityName()
						+ " can encapsulate the component "
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
	 * the assembledComponent. 
	 * 
	 * At the same time, this already finds out how to replace the 
	 * {@link RepositoryComponent} alternativeComponent if needed. Builds 
	 * a {@link ComponentReplacer} that stores all information how to replace the components.  
	 * 
	 * Returns null if the {@link RepositoryComponent} alternativeComponent cannot 
	 * be assembled in the given {@link AssemblyContext} assemblyContext. 
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
	 *         assembledComponent, null otherwise.
	 */
	private ComponentReplacer findRoleMappingFor(AssemblyContext assemblyContext, 
			RepositoryComponent alternativeComponent, System s) {
		
		RepositoryComponent assembledComponent = assemblyContext.getEncapsulatedComponent__AssemblyContext();

		//logger.debug("isAlternativeFor(..) called");

		// first check whether the two parameters are the same component, if
		// yes, return false.
		//if (checkIdentity(assembledComponent, alternativeComponent))
		//	return null;
		//TODO: in the case above, we could save the whole calculation. But for now, leave it like this. 

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

		Map<OperationProvidedRole, OperationProvidedRole> providedMapping = new IdentityHashMap<OperationProvidedRole, OperationProvidedRole>();
		for (ProvidedRole asspr : assprl) {
			if (asspr instanceof OperationProvidedRole){
				OperationProvidedRole assembledOperationProvidedRole =  (OperationProvidedRole) asspr;
				for (ProvidedRole altpr : altprl) {
					if (altpr instanceof OperationProvidedRole){
						OperationProvidedRole alternativeOperationProvidedRole =  (OperationProvidedRole) altpr;
						// 	TODO: Allow derived interfaces at the alternativeComponent
/*						logger.debug("Interface "
							+ altpr.getProvidedInterface__ProvidedRole()
							+ " and Interface "
							+ asspr.getProvidedInterface__ProvidedRole());*/
				
						if (EMFHelper.checkIdentity(alternativeOperationProvidedRole.getProvidedInterface__OperationProvidedRole(),
								assembledOperationProvidedRole.getProvidedInterface__OperationProvidedRole())) {
							providedMapping.put(assembledOperationProvidedRole, alternativeOperationProvidedRole);

							break;
						}
					}
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
			List<ConnectorAdjuster> cas = findProvidedConnectors(assemblyContext, s, providedMapping);

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

		Map<OperationRequiredRole, OperationRequiredRole> requiredMapping = new IdentityHashMap<OperationRequiredRole, OperationRequiredRole>();
		// Outer loop is alternative, because it must require no more and must
		// be completely checked.
		for (RequiredRole altrr : altrrl) {
			if (altrr instanceof OperationRequiredRole){
				OperationRequiredRole alternativeOperationRequiredRole = (OperationRequiredRole)altrr;
				boolean foundMatch = false;
				for (RequiredRole assrr : assrrl) {
					if (assrr instanceof OperationRequiredRole){
						OperationRequiredRole assembledOperationRequiredRole = (OperationRequiredRole)assrr;
						// TODO: Allow derived interfaces at the alternativeComponent
						// TODO: Rather use same ImplementationComponentType?
						if (EMFHelper.checkIdentity(alternativeOperationRequiredRole.getRequiredInterface__OperationRequiredRole(),
								assembledOperationRequiredRole.getRequiredInterface__OperationRequiredRole())) {
							requiredMapping.put(assembledOperationRequiredRole, alternativeOperationRequiredRole);
							foundMatch = true;
							break;
						}
					}
				}
				// break loop and return false when noticing that one role
				// cannot be fit.
				if (!foundMatch){
					return null;
				}
			}
		}

		// If not all required interfaces of the alternative component are
		// required by the assembled one, return false.
		//TODO: This should be unreachable... but maybe leave it to be sure.  
		if (requiredMapping.size() != altrrl.size()) {
/*			logger.debug("The required interfaces of "
					+ assembledComponent.getEntityName() + " and "
					+ alternativeComponent.getEntityName() + " do not match.");
			logger.debug("Mapping size: " + requiredMapping.size()
					+ ", required role list size: " + altrrl.size());*/
			return null;
		} else {
			
			//find connector that points to this assembly context
			List<ConnectorAdjuster> cas = findRequiredConnectors(assemblyContext, s, requiredMapping);

			//add to list
			cr.addAllConnectorAdjuster(cas);
		}
		logger.debug("These two have matching required interfaces:" + assembledComponent.getEntityName()+ " and "+alternativeComponent.getEntityName());

		return cr;
	}

	/**
	 * Finds out how the Connectors to the {@link AssemblyContext} assemblyContext have to be adjusted on the required side in order
	 * to put another {@link RepositoryComponent} (given by its roles) there. The mapping requiredMapping already 
	 * contains a mapping of the {@link RequiredRole}s of the currently assembledComponent to the {@link RequiredRole}s of the
	 * {@link RepositoryComponent} to be assembled. 
	 * 
	 *  The results for each connector are stored in a {@link ConnectorAdjuster} object, which can fix the connector references if needed. 
	 *  A List of {@link ConnectorAdjuster} is returned with a {@link ConnectorAdjuster} for each connector pointing to or coming from this {@link AssemblyContext}. 
	 * @param assemblyContext
	 * @param assembledComponent
	 * @param s
	 * @param providedMapping
	 * @return a List of {@link ConnectorAdjuster}
	 */
	private List<ConnectorAdjuster> findRequiredConnectors(
			AssemblyContext assemblyContext,
			System s, Map<OperationRequiredRole, OperationRequiredRole> requiredMapping) {
		List<ConnectorAdjuster> result = new ArrayList<ConnectorAdjuster>();
		
		for (Connector conn : s.getConnectors__ComposedStructure()) {
			if (conn instanceof AssemblyConnector) {
				AssemblyConnector assemblyConnector = (AssemblyConnector) conn;
				if (EMFHelper.checkIdentity(assemblyConnector.getRequiringAssemblyContext_AssemblyConnector(), assemblyContext)){
					OperationRequiredRole role = requiredMapping.get(assemblyConnector.getRequiredRole_AssemblyConnector());
					result.add(new OutgoingAssemblyConnectorAdjuster(assemblyConnector, role));
				}
			}
		}
		
		for (Connector conn : s.getConnectors__ComposedStructure()) {
			if (conn instanceof RequiredDelegationConnector) {
				RequiredDelegationConnector requiredDelegationConnector = (RequiredDelegationConnector) conn;
				if (EMFHelper.checkIdentity(requiredDelegationConnector.getInnerRequiredRole_RequiredDelegationConnector(), assemblyContext)){
					OperationRequiredRole role = requiredMapping.get(requiredDelegationConnector.getInnerRequiredRole_RequiredDelegationConnector());
					result.add(new RequiredDelegationConnectorAdjuster(requiredDelegationConnector, role));
				}
			}
		}
		
		return result;
	}

	/**
	 * Finds out how the Connectors to the {@link AssemblyContext} assemblyContext have to be adjusted on the provided side in order
	 * to put another {@link RepositoryComponent} (given by its roles) there. The mapping providedMapping already 
	 * contains a mapping of the {@link ProvidedRole}s of the currently assembledComponent to the {@link ProvidedRole}s of the
	 * {@link RepositoryComponent} to be assembled. 
	 * 
	 *  The results for each connector are stored in a {@link ConnectorAdjuster} object, which can fix the connector references if needed. 
	 *  A List of {@link ConnectorAdjuster} is returned with a {@link ConnectorAdjuster} for each connector pointing to or coming from this {@link AssemblyContext}. 
	 * @param assemblyContext
	 * @param assembledComponent
	 * @param s
	 * @param providedMapping
	 * @return a List of {@link ConnectorAdjuster}
	 */
	private List<ConnectorAdjuster> findProvidedConnectors(
			AssemblyContext assemblyContext, System s, Map<OperationProvidedRole, OperationProvidedRole> providedMapping) {
		List<ConnectorAdjuster> result = new ArrayList<ConnectorAdjuster>();
		
		for (Connector conn : s.getConnectors__ComposedStructure()) {
			if (conn instanceof AssemblyConnector) {
				AssemblyConnector assemblyConnector = (AssemblyConnector) conn;
				if (EMFHelper.checkIdentity(assemblyConnector.getProvidingAssemblyContext_AssemblyConnector(), assemblyContext)){
					OperationProvidedRole role = providedMapping.get(assemblyConnector.getProvidedRole_AssemblyConnector());
					result.add(new IncomingAssemblyConnectorAdjuster(assemblyConnector, role));
				}
			}
		}
		
		for (Connector conn : s.getConnectors__ComposedStructure()) {
			if (conn instanceof ProvidedDelegationConnector) {
				ProvidedDelegationConnector providedDelegationConnector = (ProvidedDelegationConnector) conn;
				if (EMFHelper.checkIdentity(providedDelegationConnector.getAssemblyContext_ProvidedDelegationConnector(), assemblyContext)){
					OperationProvidedRole role = providedMapping.get(providedDelegationConnector.getInnerProvidedRole_ProvidedDelegationConnector());
					result.add(new ProvidedDelegationConnectorReplacer(providedDelegationConnector, role));
				}
			}
		}
		
		return result;
	}





}
