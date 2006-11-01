package de.uka.ipd.sdq.dsolver.handler;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.context.allocation.ActualAllocationContext;
import de.uka.ipd.sdq.context.allocation.AllocationFactory;
import de.uka.ipd.sdq.context.usage.UsageContext;
import de.uka.ipd.sdq.context.usage.UsageFactory;
import de.uka.ipd.sdq.dsolver.Context;
import de.uka.ipd.sdq.dsolver.PCMInstance;
import de.uka.ipd.sdq.dsolver.helper.EMFHelper;
import de.uka.ipd.sdq.dsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.CollectionParameterUsage;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.ParameterUsage;
import de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisation;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.CollectionParametricParameterUsage;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ParametricParameterUsage;
import de.uka.ipd.sdq.pcm.seff.PrimitiveParametricParameterUsage;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;

public class ExternalCallActionHandler extends AbstractHandler{
	
	private Context myContext;
	
	private PCMInstance pcmInstance;
	
	private UsageFactory usageFactory;
	
	private AllocationFactory actualAllocationFactory;
	
	private ParameterFactory parameterFactory;
	
	private static Logger logger = Logger.getLogger(ExternalCallActionHandler.class.getName());
	
	public ExternalCallActionHandler(PCMInstance _pcmInstance, Context context, AbstractHandler nextHandler){
		pcmInstance = _pcmInstance;
		myContext = context;
		successor = nextHandler;
		usageFactory = UsageFactory.eINSTANCE;
		actualAllocationFactory = AllocationFactory.eINSTANCE;
		parameterFactory = ParameterFactory.eINSTANCE;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsolver.handler.AbstractHandler#handle(org.eclipse.emf.ecore.EObject)
	 */
	public void handle(EObject object){
		if (object instanceof ExternalCallAction){
			handle((ExternalCallAction)object);
		} else {
			if (successor!=null) successor.handle(object);
		}
	}
	
	/**
	 * @param call
	 */
	private void handle(ExternalCallAction call) {
		Signature serviceToBeCalled = call.getCalledService_ExternalService();
		Interface requiredInterface = (Interface) serviceToBeCalled
				.eContainer();
		
		EList parametricParameterUsages = 
			call.getParametricParameterUsage_ParametricParameterUsage();
			
		AssemblyConnector foundAssemblyConnector = 
			findAssemblyConnector(requiredInterface);
		
		if (foundAssemblyConnector == null) {
			logger.debug("Found System External Call");
			// TODO: handle system external call
		} else {
			logger.debug("Found Assembly Connector");
			visitNextSeff(serviceToBeCalled, 
					parametricParameterUsages, 
					foundAssemblyConnector);
		}
	}
	
	/**
	 * @param requiredRole
	 * @return
	 */
	private AssemblyConnector findAssemblyConnector(
			Interface requiredRole) {
		Iterator connectorIterator = myContext.getSystem()
				.getCompositeAssemblyConnectors_ComposedStructure().iterator();

		AssemblyConnector result = null;

		while (result == null && connectorIterator.hasNext()) {
			AssemblyConnector connector = (AssemblyConnector) connectorIterator
					.next();
			if (connector
					.getRequiringChildComponentContext_CompositeAssemblyConnector()
					.getId().equals(
							myContext.getDerivedAssemblyContext().getId())
					&& connector.getRequiredRole_CompositeAssemblyConnector()
							.getRequiredInterface__RequiredRole().getId()
							.equals(requiredRole.getId())) {
				result = connector;
			}
		}
		return result;
	}
	
	/**
	 * @param serviceToBeCalled
	 * @param parametricParameterUsages TODO
	 * @param foundAssemblyConnector
	 */
	private void visitNextSeff(Signature serviceToBeCalled,
			EList parametricParameterUsages, 
			AssemblyConnector foundAssemblyConnector) {

		Context callContext = createCallContext(foundAssemblyConnector, 
				parametricParameterUsages);

		SeffSwitch visitor = new SeffVisitor(pcmInstance, callContext);
		
		ResourceDemandingSEFF b = getTargetBehaviourFromAssemblyConnector(
				foundAssemblyConnector, serviceToBeCalled);
		
		visitor.doSwitch(b);
	}

	/**
	 * @param foundAssemblyConnector
	 * @param newParam TODO
	 * @return
	 */
	private Context createCallContext(
			AssemblyConnector foundAssemblyConnector, 
			EList parametricParameterUsages) {
		Context callContext = new Context();

		callContext.setSystem(myContext.getSystem());
		callContext
				.setDerivedAssemblyContext(foundAssemblyConnector
						.getProvidingChildComponentContext_CompositeAssemblyConnector());
		callContext.setCurrentEvaluatedBranchConditions(myContext
				.getCurrentEvaluatedBranchConditions());
		callContext.setCurrentLoopIterationNumber(myContext
				.getCurrentLoopIterationNumber());
		
		
		UsageContext uc = usageFactory.createUsageContext();
		createActualParameters(parametricParameterUsages, uc);
		callContext.setUsageContext(uc);

		ActualAllocationContext aac = actualAllocationFactory
				.createActualAllocationContext();
		aac.setUsageContext_ActualAllocationContext(uc);
		callContext.setActualAllocationContext(aac);

		callContext.setCurrentEvaluatedBranchConditions(myContext
				.getCurrentEvaluatedBranchConditions());
		callContext.setCurrentLoopIterationNumber(myContext
				.getCurrentLoopIterationNumber());

		return callContext;
	}

	/**
	 * @param parametricParameterUsages
	 * @param uc
	 */
	private void createActualParameters(EList parametricParameterUsages, UsageContext uc) {
		Iterator iter = parametricParameterUsages.iterator();
		while (iter.hasNext()){
			Object ppu = iter.next();
			
			if (ppu instanceof PrimitiveParametricParameterUsage){
				createPrimitiveParameterUsage(uc, ppu);
				
			} else if (ppu instanceof CollectionParametricParameterUsage){
				createCollectionParameterUsage(uc, ppu);
				
			} /*else if (ppu instanceof CompositeParametricParameterUsage){
				// not implemented yet
			}*/
		}
	}

	/**
	 * @param uc
	 * @param ppu
	 */
	private void createPrimitiveParameterUsage(UsageContext uc, Object ppu) {
		ParameterUsage actPrimUsage = parameterFactory.createParameterUsage();
		PrimitiveParametricParameterUsage pppu = (PrimitiveParametricParameterUsage)ppu;
		
		ParametricParameterUsage ppu2 = (ParametricParameterUsage)ppu;
		Parameter param = ppu2.getCharacterisedParameter_ParametricParameterUsage();
		actPrimUsage.setParameter_ParameterUsage(param);

		PrimitiveParameterCharacterisation ppc = 
			parameterFactory.createPrimitiveParameterCharacterisation();
		ppc.setType(pppu.getType());
		ppc.setSpecification("foo"); // TODO: solve dependencies
		actPrimUsage.getParameterCharacterisation_ParameterUsage().add(ppc);
		
		uc.getActualParameterUsage_UsageContext().add(actPrimUsage);
	}
	
	/**
	 * @param uc
	 * @param ppu
	 */
	private void createCollectionParameterUsage(UsageContext uc, Object ppu) {
		CollectionParameterUsage actCollUsage = parameterFactory.createCollectionParameterUsage();
		CollectionParametricParameterUsage cppu = (CollectionParametricParameterUsage) ppu;
		
		ParametricParameterUsage ppu2 = (ParametricParameterUsage)ppu;
		Parameter param = ppu2.getCharacterisedParameter_ParametricParameterUsage();
		actCollUsage.setParameter_ParameterUsage(param);
		
		CollectionParameterCharacterisation cpc = 
			parameterFactory.createCollectionParameterCharacterisation();
		cpc.setType(cppu.getType());
		cpc.setSpecification("bar"); //TODO: solve dependencies
		actCollUsage.getParameterCharacterisation_ParameterUsage().add(cpc);
		
		//TODO: handle inner parameters
		
		uc.getActualParameterUsage_UsageContext().add(actCollUsage);
	}

	/**
	 * @param connector
	 * @param targetMethod
	 * @return
	 */
	private ResourceDemandingSEFF getTargetBehaviourFromAssemblyConnector(
			AssemblyConnector connector, Signature targetMethod) {
		BasicComponent targetBasicComponent = (BasicComponent) connector
				.getProvidedRole_CompositeAssemblyConnector()
				.getProvidingComponent__ProvidedRole();
	
		// TODO: Über Interfaces suchen...
		ServiceEffectSpecification seff = (ServiceEffectSpecification) EMFHelper
				.executeOCLQuery(
						targetBasicComponent,
						"self.serviceEffectSpecifications__BasicComponent->select(seff|seff.describedService__SEFF.serviceName = '"
								+ targetMethod.getServiceName()
								+ "')->asOrderedSet()->first()");
	
		return (ResourceDemandingSEFF) seff;
	}


	
}
