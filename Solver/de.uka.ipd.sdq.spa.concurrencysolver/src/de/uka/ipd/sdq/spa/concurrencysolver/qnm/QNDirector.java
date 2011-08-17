package de.uka.ipd.sdq.spa.concurrencysolver.qnm;

import java.util.Hashtable;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.spa.ProcessBehaviour;
import de.uka.ipd.sdq.spa.SPAModel;
import de.uka.ipd.sdq.spa.basicsolver.PerformanceSolver;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.ResourceUsageBuilder;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.ResourceModelBuilder;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.ResourceModelBuilderException;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.UnknownTaskException;
import de.uka.ipd.sdq.spa.concurrencysolver.simplify.ExpressionSlicer;
import de.uka.ipd.sdq.spa.expression.Acquire;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.Release;
import de.uka.ipd.sdq.spa.expression.util.ExpressionSwitch;
import de.uka.ipd.sdq.spa.resourcemodel.ActiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.DelayResource;
import de.uka.ipd.sdq.spa.resourcemodel.PassiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.ProcessingResource;
import de.uka.ipd.sdq.spa.resourcemodel.util.ResourceModelSwitch;

public class QNDirector {
	

	public QNDirector() {
		super();
	}

	public void buildFrom(SPAModel spaModel, ResourceModelBuilder builder){
		
		try {
			BuildEnvironmentSwitch envSwitch = new BuildEnvironmentSwitch(builder);
			for (Object object : spaModel.getResources()) {
				envSwitch.doSwitch((EObject) object);
			}
			
			for (Object object : spaModel.getProcesses()){
				ProcessBehaviour customer = (ProcessBehaviour) object;
				builder.addTask(
						customer.getName(), 
						customer.getNumReplicas());
				
				ResourceUsageBuilder rdBuilder = builder.addSequentialResourceUsage(customer.getName());
				ExpressionSlicer slicer = new ExpressionSlicer();
				List<Expression> expressionList = slicer.slice(customer.getBehaviour());
				BuildExpressionSwitch exprSwitch = new BuildExpressionSwitch(rdBuilder);
				for (Expression expression : expressionList) {
					exprSwitch.doSwitch(expression);
				}
			}
		} catch (UnknownTaskException e) {
			e.printStackTrace();
			System.exit(1); // should never happen
		}
	}
	
	private class BuildEnvironmentSwitch extends ResourceModelSwitch {

		private ResourceModelBuilder builder;
		
		public BuildEnvironmentSwitch(ResourceModelBuilder builder) {
			this.builder = builder;
		}

		@Override
		public Object casePassiveResource(PassiveResource passiveResource) {
			builder.addPassivResource(
					passiveResource.getName(), 
					passiveResource.getNumReplicas());
			return passiveResource;
		}

		@Override
		public Object caseProcessingResource(ProcessingResource processingResource) {
			builder.addProcessingResource(
					processingResource.getName(), 
					processingResource.getNumReplicas());
			return processingResource;
		}
		
		@Override
		public Object caseDelayResource(DelayResource delayResource) {
			builder.addDelayResource(delayResource.getName());
			return delayResource;
		}
	}

	private class BuildExpressionSwitch extends ExpressionSwitch {
		private ResourceUsageBuilder currentBuilder;
		private PerformanceSolver perfSolver;
		
		
		
		public BuildExpressionSwitch(ResourceUsageBuilder builder) {
			this.currentBuilder = builder;
			this.perfSolver = new PerformanceSolver();
		}

		@Override
		public Object caseAcquire(Acquire acquire) {
			try {
				currentBuilder = currentBuilder.addSequentialResourceUsage(acquire.getResource().getName());
			} catch (ResourceModelBuilderException e) {
				e.printStackTrace();
				System.exit(1);
			}
			return acquire;
		}

		@Override
		public Object caseExpression(Expression expression) {
			try {
				Hashtable<ActiveResource, ManagedPDF> timeTable = perfSolver.getResourceUsageTimes(expression);
				for (ActiveResource resource : timeTable.keySet()) {
					currentBuilder.addResourceUsage(
							resource.getName(), 
							timeTable.get(resource));
				}
			} catch (ResourceModelBuilderException e) {
				e.printStackTrace();
				System.exit(1);
			}
			return expression;
		}

		@Override
		public Object caseRelease(Release release) {
			currentBuilder = currentBuilder.getParentBuilder();
			return release;
		}		
	};
	

}
