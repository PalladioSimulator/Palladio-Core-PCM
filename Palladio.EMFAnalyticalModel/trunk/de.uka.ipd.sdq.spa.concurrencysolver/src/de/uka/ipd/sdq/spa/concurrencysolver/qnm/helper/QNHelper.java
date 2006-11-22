package de.uka.ipd.sdq.spa.concurrencysolver.qnm.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.qnm.Task;
import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.CompositeResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.Resource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.util.ResourceModelSwitch;

public class QNHelper {
	
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
				list.add( seqResourceUsage.getPassiveResource() );
				for (Iterator iter = seqResourceUsage.getResourceUsages().iterator(); iter.hasNext();) {
					ResourceUsage resourceUsage = (ResourceUsage) iter.next();
					disjointUnion(list, (List<Resource>) this.doSwitch(resourceUsage));
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

}
