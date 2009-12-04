/**
 * 
 */
package de.uka.ipd.sdq.workflow.mdsd.emf.qvtr;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

/**
 * @author thomasS
 *
 */
public class RelationalQVTJob implements IJob,
		IBlackboardInteractingJob<MDSDBlackboard> {
	
	protected MDSDBlackboard blackboard = null;
	private SimpleMediniQVT mediniQvt;
	
	private String[] modelPartitionNames;
	private String tracesPartitionName;
	
	private String qvtFile;
	private String transformation;
	private String direction;
	private String workingDirectory;
	
	public void setModelPartitionNames(String[] modelPartitionNames) {
		this.modelPartitionNames = modelPartitionNames;
	}

	public void setTracesPartitionName(String tracesPartitionName) {
		this.tracesPartitionName = tracesPartitionName;
	}

	public void setWorkingDirectory(String workingDirectory) {
		this.workingDirectory = workingDirectory;
	}

	public void setQvtFile(String qvtFile) {
		this.qvtFile = qvtFile;
	}

	public void setTransformation(String transformation) {
		this.transformation = transformation;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}	
	
	public void setDebug(Boolean debug) {
		this.mediniQvt.setDebug(debug, debug);
	}
	
	public RelationalQVTJob(String[] modelPartitionNames, String tracesPartitionName,
			String qvtFile, String transformation, String direction){
		super();
		this.modelPartitionNames = modelPartitionNames;
		this.tracesPartitionName = tracesPartitionName;
		this.transformation = transformation;
		this.direction = direction;
		this.qvtFile = qvtFile;
		
		mediniQvt = new SimpleMediniQVT();
	}
	
	public RelationalQVTJob() {
		super();
		mediniQvt = new SimpleMediniQVT();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		
		ResourceSetPartition tracesPartition = this.blackboard.getPartition(this.tracesPartitionName);
		if(tracesPartition == null)
		{
			tracesPartition = new ResourceSetPartition();
			this.blackboard.addPartition(this.tracesPartitionName, tracesPartition);
		}
		
		for(int i = 0; i < this.modelPartitionNames.length;i++) {
			ResourceSetPartition modelPartition = this.blackboard.getPartition(this.modelPartitionNames[i]);
			modelPartition.resolveAllProxies();
			mediniQvt.addModelResourceSet(modelPartition.getResourceSet());
		}
		
		mediniQvt.setWorkingResourceSet(tracesPartition.getResourceSet());
		mediniQvt.setWorkingDirectory(workingDirectory);
		mediniQvt.setQVTFile(this.qvtFile);
		try {
			mediniQvt.transform(this.transformation, this.direction);
		} catch (Throwable e) {
			throw new JobFailedException("Error in mediniQVT Transformation",e);
		}

	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#getName()
	 */
	@Override
	public String getName() {
		return "Run a relational mediniQVT Transformation";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#rollback(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
		
	}
	

}
