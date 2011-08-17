/**
 * 
 */
package de.uka.ipd.sdq.cip.pcm.jobs;


import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

/**
 * @author thomasS
 *
 */
public class SplitJob implements IBlackboardInteractingJob<MDSDBlackboard>{
	
	CompletionConfiguration config = null;
	MDSDBlackboard blackboard = null;
	private AbstractPCMWorkflowRunConfiguration pcmconfig;

	public SplitJob(CompletionConfiguration configuration, AbstractPCMWorkflowRunConfiguration pcmconfig) {
		this.config = configuration;
		this.pcmconfig = pcmconfig;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void execute(IProgressMonitor arg0) throws JobFailedException,
			UserCanceledException {
		
		/*String usageModelFile = null;
		ArrayList<String> allocationFiles = new ArrayList<String>();
		
		boolean createDumpRepository = true;
		boolean createFile;
		
		String prefix = "qvt";
		
		ArrayList<Resource> saveList = new ArrayList<Resource>();
		
		ResourceSetPartition partition = config.getLastPartition();
		Resource tempResource = partition.getResourceSet().getResources().get(0);
		
		//PCMResourceSetPartition pcmResourceSetPartition = new PCMResourceSetPartition();
		/*ResourceSetPartition middlewarePartition = this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.MIDDLEWARE_PARTITION_ID);
		middlewarePartition.loadModel(pcmconfig.getMiddlewareFile());
		middlewarePartition.resolveAllProxies();*/
		
		//PCMResourceSetPartition pcmResourceSetPartition = (PCMResourceSetPartition)this.blackboard.getPartition(config.getInputPartitionName());
		//ResourceSet rset = pcmResourceSetPartition.getResourceSet();
		/*ResourceSet rset = new ResourceSetImpl();
		Resource resource;
		
		
		IFolder outputFolder = getProject(config.getProjectID()).getFolder(ConstantsContainer.MODELFOLDER);
		
		EList<EObject> contentList = tempResource.getContents();
		while(true)
		{
			if(contentList.size() == 0)
				break;
			
			EObject o = contentList.get(0);
			
			String name = new String();
			String extension = new String();
			
			EClass eClass = o.eClass();
			for(EAttribute eAttribut : eClass.getEAllAttributes())
			{
				if(eAttribut.getName().equals("entityName"))
				{
					name = o.eGet(eAttribut).toString();
					break;
				}
			}
			
			if(eClass.getName().equals("UsageModel")){
				extension = "usagemodel";
			}
			else if(eClass.getName().equals("System")) {
				extension = "system";
			}
			else if(eClass.getName().equals("ResourceEnvironment")){
				extension = "resourceenvironment";
			}
			else if(eClass.getName().equals("Allocation")) {
				extension = "allocation";
			}
			else if(eClass.getName().equals("Repository")) {
				extension = "repository";
			}
			else {
				//contentList.remove(o);
				//continue;
				name = "dump";
				extension = "repository";
				//extension = "xmi";
			}
			
			if(name.isEmpty())
				name = extension;

			createFile = true;
			
			/*if(name.contains("_")) {
				if(!createCompletionRepository)
					createFile = false;
				createCompletionRepository = false;
				name = "completionRepository";
			}*/
			/*if(name.equals("dump"))
			{
				if(!createDumpRepository)
					createFile = false;
				createDumpRepository = false;
			}
			
			IFile partFile = outputFolder.getFile(prefix + "_" + name + "." + extension);
			//if(partFile.exists())
			//	partFile.delete(true, null);
			//partFile.refreshLocal(0, null);
			//partFile.create( null, true, null);
			
			if(createFile) {
				resource = rset.createResource(URI.createPlatformResourceURI(partFile.getFullPath().toString(),true));
				saveList.add(resource);
				if(eClass.getName().equals("Allocation")) {
					allocationFiles.add(partFile.getFullPath().toString());
				}else if (eClass.getName().equals("UsageModel")) {
					usageModelFile = partFile.getFullPath().toString();
				}
			}
			else
				resource = rset.getResource(URI.createPlatformResourceURI(partFile.getFullPath().toString(),true),true);
			
			resource.getContents().add(o);
			}
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ENCODING", "UTF-8");
		
		/*try {
			tempResource.delete(map);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
	/*	for(Resource resource1 : saveList){
			try {
				resource1.save(map);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		
		//pcmResourceSetPartition.loadModel(config.getResourceRepository());
		//pcmResourceSetPartition.loadModel(config.getFeatureConfigFile());
		
		//this.blackboard.addPartition(config.getInputPartitionName(), pcmResourceSetPartition);
		pcmconfig.setAllocationFiles(allocationFiles);
		pcmconfig.setUsageModelFile(usageModelFile);*/
		}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#getName()
	 */
	@Override
	public String getName() {
		return "Spliting transformated PCM-Models";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#rollback(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void rollback(IProgressMonitor arg0) throws RollbackFailedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
		
	}
	
	protected static IProject getProject(String projectId) {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(
				projectId);
	}

}
