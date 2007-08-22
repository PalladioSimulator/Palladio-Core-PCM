/**
 * 
 */
package de.uka.ipd.sdq.pcmsolver.handler;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.computed_allocation.ResourceDemand;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationFactory;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcmsolver.visitors.ExpressionHelper;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.PCMRandomVariable;
import de.uka.ipd.sdq.stoex.StoexFactory;

/**
 * @author Koziolek
 * 
 */
public class InternalActionHandler{
	
	private static Logger logger = Logger.getLogger(InternalActionHandler.class.getName());
	
	private ComputedAllocationFactory compAllocationFactory = ComputedAllocationFactory.eINSTANCE;

	private SeffVisitor visitor; 
	
	public InternalActionHandler(SeffVisitor seffVisitor) {
		visitor=seffVisitor;
	}

	/**
	 * @param action
	 */
	public void handle(InternalAction action) {
		//EList<ParametricResourceDemand> resourceDem = action.getResourceDemand_Action()
		
		Iterator resourceDemands = action.getResourceDemand_Action().iterator();
		while (resourceDemands.hasNext()) {
			ParametricResourceDemand prd = (ParametricResourceDemand) resourceDemands.next();
			ProcessingResourceType requiredResourceType = prd.getRequiredResource_ParametricResourceDemand();

			if (requiredResourceType.getEntityName().equals("SystemExternalResource")){
				EList<ResourceContainer> resConList = visitor.getContextWrapper().getPcmInstance().getResourceEnvironment().getResourceContainer_ResourceEnvironment();
				for (ResourceContainer resCon : resConList){
					if(resCon.getEntityName().equals("SystemExternalResourceContainer")){
						ProcessingResourceSpecification prs = resCon.getActiveResourceSpecifications_ResourceContainer().get(0);
						createActualResourceDemand(prd, prs);
					}
				}
			} else {
				EList<ProcessingResourceSpecification> resourceList = getResourceList();
				for (ProcessingResourceSpecification prs : resourceList) {
					ProcessingResourceType currentResourceType = prs
							.getActiveResourceType_ActiveResourceSpecification();
					if (currentResourceType.getEntityName().equals(
							requiredResourceType.getEntityName())) {
						createActualResourceDemand(prd, prs);
					}
				}
			}
		}
	}

	/**
	 * @param prd
	 */
	private void createActualResourceDemand(ParametricResourceDemand prd, ProcessingResourceSpecification prs) {
		// TODO: include branch conditions and loop iterations
		String actResDemSpecification = getSolvedSpecification(prd.getSpecification_ParametericResourceDemand().getSpecification(), prs);
		
		ResourceDemand ard = compAllocationFactory.createResourceDemand();
		ard.setParametricResourceDemand_ResourceDemand(prd);
		
		PCMRandomVariable rv = StoexFactory.eINSTANCE.createPCMRandomVariable();
		rv.setSpecification(actResDemSpecification);
		ard.setSpecification_ResourceDemand(rv);
		
		visitor.getContextWrapper().getCompAllCtx()
				.getResourceDemands_ComputedAllocationContext().add(ard);
	}

	private String getSolvedSpecification(String specification, ProcessingResourceSpecification prs) {

		// quickly incorporate processing rate
		specification = "("+ specification+") / "+prs.getProcessingRate_ProcessingResourceSpecification().getSpecification();
		logger.info("Actual Resource Demand (Expression): "+specification);
		
		Expression solvedExpr = (Expression) ExpressionHelper
				.getSolvedExpression(specification, visitor.getContextWrapper());
		
		
		
		String solvedSpecification = ExpressionHelper
				.getSolvedExpressionAsString(specification,
						visitor.getContextWrapper());
		logger.info("Computed Actual Resource Demand: "+solvedSpecification);
		return solvedSpecification;
	}

	/**
	 * @return
	 */
	private EList<ProcessingResourceSpecification> getResourceList() {
		AllocationContext ac = visitor.getContextWrapper().getAllCtx();
		ResourceContainer currentResourceContainer = ac.getResourceContainer_AllocationContext();
		EList<ProcessingResourceSpecification> resourceList = currentResourceContainer
				.getActiveResourceSpecifications_ResourceContainer();
		return resourceList;
	}

}
