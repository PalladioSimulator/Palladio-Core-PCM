package de.uka.ipd.sdq.spa.concurrencysolver.simplify;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.spa.expression.Acquire;
import de.uka.ipd.sdq.spa.expression.Alternative;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.Loop;
import de.uka.ipd.sdq.spa.expression.Parallel;
import de.uka.ipd.sdq.spa.expression.Release;
import de.uka.ipd.sdq.spa.expression.Sequence;
import de.uka.ipd.sdq.spa.expression.Symbol;
import de.uka.ipd.sdq.spa.expression.util.ExpressionSwitch;
import de.uka.ipd.sdq.spa.resourcemodel.PassiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.Resource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;

/**
 * Finds all resources used by an expression.
 * 
 * @author jens
 *
 */
public class ResourceUsageAnalyser {
	

	private ExpressionSwitch exprswitch = new ExpressionSwitch() {

		@Override
		public Object caseAcquire(Acquire object) {
			
			return getResourceList(object.getResource());
		}

		@Override
		public Object caseAlternative(Alternative object) {
			return joinResources(doSwitch(object.getLeftOption().getRegexp()),	doSwitch(object.getRightOption().getRegexp()));
		}

		@Override
		public Object caseLoop(Loop object) {
			return doSwitch(object.getRegExp());
		}

		@Override
		public Object caseParallel(Parallel object) {
			return joinResources(doSwitch(object.getLeftTask()), doSwitch(object.getRightTask()));
		}

		@Override
		public Object caseRelease(Release object) {
			return getResourceList(object.getResource());
		}

		@Override
		public Object caseSequence(Sequence object) {
			return joinResources(doSwitch(object.getLeftRegExp()), doSwitch(object.getRightRegExp()));
		}

		@Override
		public Object caseSymbol(Symbol object) {
			return  getResources(object.getResourceUsages());
		}

	};

	public ResourceUsageAnalyser() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Resource> getUsedResources(Expression expr) {
		return (List<Resource>)exprswitch.doSwitch(expr);
	}

	@SuppressWarnings("unchecked")
	private List<Resource> joinResources(Object rList1, Object rList2) {
		return joinResources((List<Resource>) rList1,(List<Resource>) rList2);
	}
	
	private List<Resource> joinResources(List<Resource> rList1, List<Resource> rList2) {
		List<Resource> resultList = new ArrayList<Resource>(rList1);
		for (Resource resource : rList2) {
			if (!resultList.contains(resource)){
				resultList.add(resource);
			}
		}
		return resultList;
	}
	
	private List<Resource> getResources(EList demandList){
		List<Resource> resultList = new ArrayList<Resource>();
		for (Iterator iter = demandList.iterator(); iter.hasNext();) {
			ResourceUsage demand = (ResourceUsage) iter.next();
			if (!resultList.contains(demand.getResource())){
				resultList.add(demand.getResource());
			}
		}
		return resultList;
	}

	private List<Resource> getResourceList(PassiveResource resource) {
		List<Resource> resultList = new ArrayList<Resource>();
		resultList.add(resource);
		return resultList;
	}

}
