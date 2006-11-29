package de.uka.ipd.sdq.spa.concurrencysolver.qnm.helper;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import de.uka.ipd.sdq.qnm.Task;
import de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel;
import de.uka.ipd.sdq.qnm.resultmodel.TimeConsumption;
import de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage;
import de.uka.ipd.sdq.qnm.resultmodel.ServiceTimeBreakDown;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.CompositeResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.Resource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.util.ResourceModelSwitch;

public class QNHelper {

	QNMResultModel resultModel;

	public QNHelper(QNMResultModel resultModel) {
		super();
		this.resultModel = resultModel;
	}
	
	public TaskResourceUsage getTaskResourceUsage(Task task, Resource resource) {
		Query q = QueryFactory.eINSTANCE.createQuery("self.resource.name = '" + resource.getName() + "' and self.task.name = '"+ task.getName() + "'", ResultModelPackage.eINSTANCE.getTaskResourceUsage());
		List result = (List) q.select(resultModel.getTaskResourceUsages());
		return (TaskResourceUsage) result.get(0);
	}
	
	/**
	 * Returns the time an abstract resource usage consumes.
	 * @param abstractResourceUsage
	 * @return
	 */
	public TimeConsumption getTimeConsumptionFor(AbstractResourceUsage abstractResourceUsage){
		
		for (Object usageTimeObj  : resultModel.getResourceUsageTimes()) {
			TimeConsumption usageTime = (TimeConsumption) usageTimeObj;
			if( usageTime.getResourceUsage().equals(abstractResourceUsage) )
				return usageTime;
		}
		
		return null;
	}
	
	public static List<Resource> getUsedResources(AbstractResourceUsage resourceUsage){
		
		ResourceModelSwitch rmSwitch = new ResourceModelSwitch() {
			@Override
			public Object caseResourceUsage(ResourceUsage resourceUsage) {
				List<Resource> list = new ArrayList<Resource>();				
				list.add( resourceUsage.getResource() );
				return list;
			}
			
			@Override
			public Object caseSequentialResourceUsage(SequentialResourceUsage seqResourceUsage) {
				List<Resource> list = new ArrayList<Resource>();				
				list.add( seqResourceUsage.getResource() );
				for (Iterator iter = seqResourceUsage.getResourceUsages().iterator(); iter.hasNext();) {
					AbstractResourceUsage abstractUsage = (AbstractResourceUsage) iter.next();
					disjointUnion(list, (List<Resource>) this.doSwitch(abstractUsage));
				}
				return list;
			}
		};
		
		return (List<Resource>) rmSwitch.doSwitch(resourceUsage);
	}
	
	
	public static List<AbstractResourceUsage> getAllResourceUsages(Task task){
		@SuppressWarnings("unchecked")
		ResourceModelSwitch resourceUsageCollector = new ResourceModelSwitch(){
			
			@Override
			public Object caseCompositeResourceUsage(CompositeResourceUsage compositeResourceUsage) {
				List<AbstractResourceUsage> result = new ArrayList<AbstractResourceUsage>();
				for (Object subResourceUsage : compositeResourceUsage.getResourceUsages()) {
					result.addAll((List<AbstractResourceUsage>)doSwitch((EObject)subResourceUsage));
				}
				result.add(compositeResourceUsage);
				return result;
			}
			
			
			@Override
			public Object caseResourceUsage(ResourceUsage ru) {
				List<AbstractResourceUsage> result = new ArrayList<AbstractResourceUsage>();
				result.add(ru);
				return result;
			}
		};		
		return (List<AbstractResourceUsage>) resourceUsageCollector.doSwitch(task.getResourceUsage());
	}
	
	protected static void disjointUnion(List<Resource> addList, List<Resource> inList) {
		for (Resource resource : inList) {
			if (!addList.contains(resource)){
				addList.add(resource);
			}
		}
	}	

	public List<Task> getUsingTasks(Resource resource) {
		List<Task> resultList = new ArrayList<Task>();
		for (Iterator iter = this.resultModel.getQnmodel().getTasks().iterator(); iter.hasNext();) {
			Task task = (Task) iter.next();
			if (getUsedResources(task.getResourceUsage()).contains(resource)){
				resultList.add(task);
			}
		}
		return resultList;
	}

	public List<AbstractResourceUsage> getUsagesOf(Task task, Resource resource) {
		List<AbstractResourceUsage> resultList = new ArrayList<AbstractResourceUsage>();
		List<AbstractResourceUsage> allList = getAllResourceUsages(task);
		for (AbstractResourceUsage usage : allList) {
			if (usage.getResource().equals(resource)){
				resultList.add(usage);
			}
		}
		return resultList;
	}


	public ServiceTimeBreakDown getServiceTimeBreakDown(TimeConsumption time, Resource resource) {
		for (Iterator iter = time.getServiceTimeBreakDowns().iterator(); iter.hasNext();) {
			ServiceTimeBreakDown breakdown = (ServiceTimeBreakDown) iter.next();
			if (breakdown.getUsedResource().equals(resource)){
				return breakdown;
			}
		}
		return null;
	}

	public ServiceTimeBreakDown getServiceTimeBreakDown(AbstractResourceUsage resourceUsage, Resource resource) {
		TimeConsumption ruTime = getTimeConsumptionFor(resourceUsage);
		return getServiceTimeBreakDown(ruTime, resource);
	}

	public Hashtable<Resource, ServiceTimeBreakDown> createInitialServiceTimeBreakDownTable(AbstractResourceUsage abstractUsage) {
		Hashtable<Resource, ServiceTimeBreakDown> resultTable = new Hashtable<Resource, ServiceTimeBreakDown>();
		
		List<Resource> usedResources = getUsedResources(abstractUsage);
		for (Resource resource : usedResources) {
			ServiceTimeBreakDown breakdown = getServiceTimeBreakDown(abstractUsage, resource);
			resultTable.put(resource, breakdown);
		}
		
		return resultTable;
	}
}

