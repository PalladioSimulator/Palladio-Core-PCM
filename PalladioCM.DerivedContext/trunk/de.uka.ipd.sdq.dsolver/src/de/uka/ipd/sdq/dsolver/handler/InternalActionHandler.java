/**
 * 
 */
package de.uka.ipd.sdq.dsolver.handler;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.context.allocation.ActualResourceDemand;
import de.uka.ipd.sdq.context.allocation.AllocationFactory;
import de.uka.ipd.sdq.dsolver.Context;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.assembly.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;
import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;

/**
 * @author Koziolek
 * 
 */
public class InternalActionHandler extends AbstractHandler{
	
	private static Logger logger = Logger.getLogger(InternalActionHandler.class.getName());
	
	private StochasticsFactory stochasticsFactory;

	private AllocationFactory actualAllocationFactory;

	private Context myContext;
	
	public InternalActionHandler(Context context, AbstractHandler nextHandler) {
		stochasticsFactory = StochasticsFactory.eINSTANCE;
		actualAllocationFactory = AllocationFactory.eINSTANCE;
		myContext = context;
		successor = nextHandler;
	}

	public void handle(EObject object){
		if (object instanceof InternalAction){
			handle((InternalAction)object);
		} else {
			if (successor!=null) successor.handle(object);
		}
	}

	public void handle(InternalAction action) {
		Iterator resourceDemands = action.getResourceDemand_Action().iterator();
		while (resourceDemands.hasNext()) {
			ParametricResourceDemand prd = (ParametricResourceDemand) resourceDemands.next();
			ProcessingResourceType requiredResourceType = prd.getRequiredResource_ParametricResourceDemand();

			AllocationContext ac = findAllocationContext(myContext.getDerivedAssemblyContext());
			ResourceContainer currentResourceContainer = ac.getResourceContainer_AllocationContext();
			EList resourceList = currentResourceContainer
					.getActiveResourceSpecifications_ResourceContainer();
			Iterator iter = resourceList.iterator();
			while (iter.hasNext()) {
				ProcessingResourceSpecification prs = (ProcessingResourceSpecification) iter.next();
				ProcessingResourceType currentResourceType = prs
						.getActiveResourceType_ActiveResourceSpecification();
				if (currentResourceType.getEntityName().equals(
						requiredResourceType.getEntityName())) {
					// TODO: solve dependency, include branch conditions and loop iterations
					// here: only copy random variable specification
					Expression expression = prd.getSpecification_RandomVariable();
					RandomVariable rv = stochasticsFactory
							.createRandomVariable();
					rv.setSpecification_RandomVariable(expression);

					ActualResourceDemand ard = actualAllocationFactory
							.createActualResourceDemand();
					ard.setParametricResourceDemand_ActualResourceDemand(prd);
					ard.setRandomVariable_ActualResourceDemand(rv);

					myContext.getActualAllocationContext()
							.getActualResourceDemands_ActualAllocationContext()
							.add(ard);
				}
			}
		}
	}

	/**
	 * @param derivedAssemblyContext
	 * @return
	 */
	private AllocationContext findAllocationContext(
			AssemblyContext derivedAssemblyContext) {
		Iterator allocationContexts = myContext.getSystem()
				.getAllocation_System().getAllocationContexts().iterator();
		while (allocationContexts.hasNext()) {
			AllocationContext context = (AllocationContext) allocationContexts
					.next();
			if (context.getReferencedAssemblyContext_AllocationContext() == derivedAssemblyContext)
				return context;
		}
		return null;
	}
}
