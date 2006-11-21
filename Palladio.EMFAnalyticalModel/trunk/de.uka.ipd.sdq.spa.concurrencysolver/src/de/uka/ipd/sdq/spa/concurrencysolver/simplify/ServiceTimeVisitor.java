//package de.uka.ipd.sdq.spa.concurrencysolver.simplify;
//
//import java.util.List;
//import java.util.Stack;
//
//import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
//import de.uka.ipd.sdq.spa.basicsolver.visitor.PerformanceVisitor;
//import de.uka.ipd.sdq.spa.basicsolver.visitor.perfhandler.PerformanceHandlerFactory;
//import de.uka.ipd.sdq.spa.environment.PassiveResource;
//import de.uka.ipd.sdq.spa.environment.Resource;
//import de.uka.ipd.sdq.spa.expression.Acquire;
//import de.uka.ipd.sdq.spa.expression.Expression;
//import de.uka.ipd.sdq.spa.expression.Release;
//import de.uka.ipd.sdq.spa.expression.util.ExpressionSwitch;
//
//public class ServiceTimeVisitor {
//	
//	int domainSize;
//	Stack<PassiveResource> resourceStack;
//	
//	ExpressionSwitch eSwitch = new ExpressionSwitch() {
//		
//		@Override
//		public Object caseAcquire(Acquire object) {
//			resourceStack.push(object.getResource());
//			return object;
//		}
//
//		@Override
//		public Object caseExpression(Expression object) {
//			PerformanceVisitor pv = new PerformanceVisitor(new PerformanceHandlerFactory(domainSize));
//			IProbabilityDensityFunction time = pv.getResponseTime(object);
//			
//			PrintVisitor prv = new PrintVisitor();
//			String name = prv.visit(object);
//			
//			ResourceVisitor rv = new ResourceVisitor();
//			List<Resource> resourceList = rv.getUsedResources(object);
//			
//		}
//
//		@Override
//		public Object caseRelease(Release object) {
//
//			ServiceCentre stime = new ServiceCentre(resource,time,name);
//			times.add(stime);
//			return stime;
//		}
//
//		@Override
//		public Object caseSleep(Sleep object) {
//			
//			ServiceCentre sTime = null;
//			try {
//				ISamplePDF spdf = IProbabilityFunctionFactory.eINSTANCE.transformToSamplePDF(object.getPdf());
//				spdf.expand(domainSize);
//				sTime = new ServiceCentre( thinkResource,spdf , "Sleep");
//				times.add(sTime);
//			} catch (ProbabilityFunctionException e) {
//				e.printStackTrace();
//				System.exit(1);
//			}
//			return sTime;
//		}
//	};
//	
//
//	public ServiceTimeVisitor(int domainSize) {
//		super();
//		this.domainSize = domainSize;
//		thinkResource.setName("Brain");
//		thinkResource.setNumReplicas(-1); // infinite
//	}
//
//	public List<ServiceCentre> visit(List<Expression> expressionList) {
//		for (Expression expression : expressionList) {
//			eSwitch.doSwitch(expression);
//		}
//		return times;
//	}
//
//	
//
//}
