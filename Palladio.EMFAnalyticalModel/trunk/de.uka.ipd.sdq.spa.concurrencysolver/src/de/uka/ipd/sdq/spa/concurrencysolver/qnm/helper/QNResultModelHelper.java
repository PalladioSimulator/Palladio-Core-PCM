package de.uka.ipd.sdq.spa.concurrencysolver.qnm.helper;

import java.util.List;

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import de.uka.ipd.sdq.qnm.Task;
import de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel;
import de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.Resource;

public class QNResultModelHelper {

	QNMResultModel resultModel;

	public QNResultModelHelper(QNMResultModel resultModel) {
		super();
		this.resultModel = resultModel;
	}
	
//	public TaskResult getResultForTask(Task task){
//		Query query = QueryFactory.eINSTANCE.createQuery("task.name = '"
//				+ task.getName() + "'", ResultModelPackage.eINSTANCE
//				.getTaskResult());
//		List result = query.select(resultModel.getTaskResults());
//		// TODO: check if result.size() == 1 
//		return (TaskResult) result.get(0);
//	}
//	
//	public ResourceResult getResultForResource(Resource resource){
//		Query query = QueryFactory.eINSTANCE.createQuery("resource.name = '"
//				+ resource.getName() + "'", ResultModelPackage.eINSTANCE
//				.getResourceResult());
//		List result = query.select(resultModel.getResourceResults());
//		// TODO: check if result.size() == 1 
//		return (ResourceResult) result.get(0);
//	}
	
	public TaskResourceUsage getTaskResourceUsage(Task task, Resource resource) {
		//TODO add condition for task
		Query q = QueryFactory.eINSTANCE.createQuery("taskResourceUsages.resource.name = '" + resource.getName() + "'", ResultModelPackage.eINSTANCE.getTaskResourceUsage());
		List result = (List) q.select(resultModel.getTaskResourceUsages());
		return (TaskResourceUsage) result.get(0);
	}

}

