package de.uka.ipd.sdq.spa.concurrencysolver.simplify;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.spa.basicsolver.visitor.PerformanceVisitor;
import de.uka.ipd.sdq.spa.basicsolver.visitor.perfhandler.PerformanceHandlerFactory;
import de.uka.ipd.sdq.spa.environment.EnvironmentFactory;
import de.uka.ipd.sdq.spa.environment.PassiveResource;
import de.uka.ipd.sdq.spa.expression.Acquire;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.Release;
import de.uka.ipd.sdq.spa.expression.Sleep;
import de.uka.ipd.sdq.spa.expression.util.ExpressionSwitch;

public class ServiceTimeVisitor {
	
	IProbabilityDensityFunction time = null;
	String name = null;
	PassiveResource resource = null;
	PassiveResource thinkResource = EnvironmentFactory.eINSTANCE.createPassiveResource();
	List<ServiceCentre> times = new ArrayList<ServiceCentre>();
	int domainSize;
	

	ExpressionSwitch eSwitch = new ExpressionSwitch() {
		
		@Override
		public Object caseAcquire(Acquire object) {
			resource = object.getResource();
			return resource;
		}

		@Override
		public Object caseExpression(Expression object) {
			PerformanceVisitor pv = new PerformanceVisitor(new PerformanceHandlerFactory(domainSize));
			time = pv.getResponseTime(object);
			
			PrintVisitor prv = new PrintVisitor();
			name = resource.getName() + "(" + prv.visit(object) + ")";
			
			return time;
		}

		@Override
		public Object caseRelease(Release object) {

			ServiceCentre stime = new ServiceCentre(resource,time,name);
			times.add(stime);
			return stime;
		}

		@Override
		public Object caseSleep(Sleep object) {
			
			ServiceCentre sTime = null;
			try {
				ISamplePDF spdf = IProbabilityFunctionFactory.eINSTANCE.transformToSamplePDF(object.getPdf());
				spdf.expand(domainSize);
				sTime = new ServiceCentre( thinkResource,spdf , "Sleep");
				times.add(sTime);
			} catch (ProbabilityFunctionException e) {
				e.printStackTrace();
				System.exit(1);
			}
			return sTime;
		}
	};
	

	public ServiceTimeVisitor(int domainSize) {
		super();
		this.domainSize = domainSize;
		thinkResource.setName("Brain");
		thinkResource.setNumReplicas(-1); // infinite
	}

	public List<ServiceCentre> visit(List<Expression> expressionList) {
		for (Expression expression : expressionList) {
			eSwitch.doSwitch(expression);
		}
		return times;
	}

	

}
