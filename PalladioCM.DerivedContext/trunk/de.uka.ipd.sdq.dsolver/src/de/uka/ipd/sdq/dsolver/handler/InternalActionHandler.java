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
import de.uka.ipd.sdq.dsolver.helper.ExpressionHelper;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.stoex.StoexFactory;

/**
 * @author Koziolek
 * 
 */
public class InternalActionHandler extends AbstractHandler{
	
	private static Logger logger = Logger.getLogger(InternalActionHandler.class.getName());
	
	private AllocationFactory actualAllocationFactory;

	private Context myContext;
	
	public InternalActionHandler(Context context, AbstractHandler nextHandler) {
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

			EList resourceList = getResourceList();
			Iterator iter = resourceList.iterator();
			while (iter.hasNext()) {
				ProcessingResourceSpecification prs = (ProcessingResourceSpecification) iter.next();
				ProcessingResourceType currentResourceType = prs
						.getActiveResourceType_ActiveResourceSpecification();
				if (currentResourceType.getEntityName().equals(
						requiredResourceType.getEntityName())) {
					createActualResourceDemand(prd);
				}
			}
		}
	}

	/**
	 * @param prd
	 */
	private void createActualResourceDemand(ParametricResourceDemand prd) {
		// TODO: include branch conditions and loop iterations
		String specification = prd.getSpecification();
		String solvedSpecification = ExpressionHelper
				.getSolvedExpressionAsString(specification,
						myContext);
		logger.debug("Computed Actual Resource Demand: "+solvedSpecification);
		
		ActualResourceDemand ard = actualAllocationFactory
				.createActualResourceDemand();
		ard.setParametricResourceDemand_ActualResourceDemand(prd);
		ard.setParametricResourceDemand_ActualResourceDemand(prd);

		ard.setSpecification(solvedSpecification);

		myContext.getActualAllocationContext()
				.getActualResourceDemands_ActualAllocationContext()
				.add(ard);
	}

	/**
	 * @return
	 */
	private EList getResourceList() {
		AllocationContext ac = findAllocationContext(myContext.getDerivedAssemblyContext());
		ResourceContainer currentResourceContainer = ac.getResourceContainer_AllocationContext();
		EList resourceList = currentResourceContainer
				.getActiveResourceSpecifications_ResourceContainer();
		return resourceList;
	}

	/**
	 * @param derivedAssemblyContext
	 * @return
	 */
	private AllocationContext findAllocationContext(
			AssemblyContext derivedAssemblyContext) {
		Allocation alloc = myContext.getAllocation();
		Iterator allocationContexts = alloc.getAllocationContexts_Allocation().iterator();
		
		while (allocationContexts.hasNext()) {
			AllocationContext context = (AllocationContext) allocationContexts
					.next();
			if (context.getAssemblyContext_AllocationContext().getId().equals(derivedAssemblyContext.getId()))
				return context;
		}
		return null;
	}
}
