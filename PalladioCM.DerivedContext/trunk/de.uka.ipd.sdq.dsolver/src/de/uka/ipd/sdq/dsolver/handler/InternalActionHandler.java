/**
 * 
 */
package de.uka.ipd.sdq.dsolver.handler;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.allocation.ActualResourceDemand;
import de.uka.ipd.sdq.context.allocation.AllocationFactory;
import de.uka.ipd.sdq.dsolver.helper.ExpressionHelper;
import de.uka.ipd.sdq.dsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.stoex.Expression;

/**
 * @author Koziolek
 * 
 */
public class InternalActionHandler{
	
	private static Logger logger = Logger.getLogger(InternalActionHandler.class.getName());
	
	private AllocationFactory actualAllocationFactory = AllocationFactory.eINSTANCE;

	private SeffVisitor visitor; 
	
	public InternalActionHandler(SeffVisitor seffVisitor) {
		visitor=seffVisitor;
	}

	/**
	 * @param action
	 */
	public void handle(InternalAction action) {
		Iterator resourceDemands = action.getResourceDemand_Action().iterator();
		while (resourceDemands.hasNext()) {
			ParametricResourceDemand prd = (ParametricResourceDemand) resourceDemands.next();
			ProcessingResourceType requiredResourceType = prd.getRequiredResource_ParametricResourceDemand();

			EList resourceList = getResourceList();
			Iterator resource = resourceList.iterator();
			while (resource.hasNext()) {
				ProcessingResourceSpecification prs = (ProcessingResourceSpecification) resource.next();
				ProcessingResourceType currentResourceType = prs
						.getActiveResourceType_ActiveResourceSpecification();
				if (currentResourceType.getEntityName().equals(
						requiredResourceType.getEntityName())) {
					
					createActualResourceDemand(prd, prs);
				}
			}
		}
	}

	/**
	 * @param prd
	 */
	private void createActualResourceDemand(ParametricResourceDemand prd, ProcessingResourceSpecification prs) {
		// TODO: include branch conditions and loop iterations
		String actResDemSpecification = getSolvedSpecification(prd.getSpecification(), prs);
		
		ActualResourceDemand ard = actualAllocationFactory
				.createActualResourceDemand();
		ard.setParametricResourceDemand_ActualResourceDemand(prd);
		ard.setParametricResourceDemand_ActualResourceDemand(prd);

		ard.setSpecification(actResDemSpecification);
		
		visitor.getMyContext().getActualAllocationContext()
				.getActualResourceDemands_ActualAllocationContext()
				.add(ard);
	}

	private String getSolvedSpecification(String specification, ProcessingResourceSpecification prs) {

		// quickly incorporate processing rate
		specification = "("+ specification+") / "+prs.getProcessingRate();
		logger.debug("Actual Resource Demand (Expression): "+specification);
		
		Expression solvedExpr = (Expression) ExpressionHelper.getSolvedExpression(specification, visitor.getMyContext());
		
		
		
		String solvedSpecification = ExpressionHelper
				.getSolvedExpressionAsString(specification,
						visitor.getMyContext());
		logger.debug("Computed Actual Resource Demand: "+solvedSpecification);
		return solvedSpecification;
	}

	/**
	 * @return
	 */
	private EList getResourceList() {
		AllocationContext ac = findAllocationContext(visitor.getMyContext().getDerivedAssemblyContext());
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
		Allocation alloc = visitor.getMyContext().getAllocation();
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
