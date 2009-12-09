/**
 * 
 */
package de.uka.ipd.sdq.cip.workflow.jobs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.uka.ipd.sdq.cip.ConstantsContainer;
import de.uka.ipd.sdq.cip.runconfig.CompletionConfiguration;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;

/**
 * @author thomasS
 *
 */
public class SplitJob implements IBlackboardInteractingJob<MDSDBlackboard>{
	
	CompletionConfiguration config = null;
	MDSDBlackboard blackboard = null;

	public SplitJob(CompletionConfiguration configuration) {
		this.config = configuration;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void execute(IProgressMonitor arg0) throws JobFailedException,
			UserCanceledException {
		
		boolean createDumpRepository = true;
		boolean createFile;
		
		String prefix = "qvt";
		
		ArrayList<Resource> saveList = new ArrayList<Resource>();
		
		ResourceSetPartition partition = this.blackboard.getPartition(config.getLastPartition());
		Resource tempResource = partition.getResourceSet().getResources().get(0);
		
		PCMResourceSetPartition pcmResourceSetPartition = new PCMResourceSetPartition();
		ResourceSet rset = pcmResourceSetPartition.getResourceSet();
		Resource resource;
		
		IFolder outputFolder = config.getProject().getFolder(ConstantsContainer.outputFolder);
		
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
			if(name.equals("dump"))
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
				resource = rset.createResource(URI.createFileURI(partFile.getFullPath().toString()));
				saveList.add(resource);
			}
			else
				resource = rset.getResource(URI.createFileURI(partFile.getFullPath().toString()),true);
			
			resource.getContents().add(o);
			}
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("ENCODING", "UTF-8");
		
		/*try {
			tempResource.delete(map);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		for(Resource resource1 : saveList){
			try {
				resource1.save(map);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		
		//pcmResourceSetPartition.loadModel(config.getResourceRepository());
		pcmResourceSetPartition.loadModel(config.getFeatureConfigFile());
		
		this.blackboard.addPartition(config.getModelPartition(), pcmResourceSetPartition);
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

}
