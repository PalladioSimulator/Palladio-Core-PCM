package de.uka.ipd.sdq.cip.workflow.jobs;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import de.uka.ipd.sdq.cip.ConstantsContainer;
import de.uka.ipd.sdq.cip.completions.CompletionEntry;
import de.uka.ipd.sdq.cip.runconfig.CompletionConfiguration;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;
import de.uka.ipd.sdq.workflow.mdsd.emf.qvtr.RelationalQVTJob;

public class CompletionTransformationJob extends RelationalQVTJob {

	//private Logger logger = Logger.getLogger(CompletionTransformationJob.class);
	private CompletionConfiguration config;
	private CompletionEntry completionEntry;
	private String outputPartitionName;

	public CompletionTransformationJob(CompletionEntry completionEntry, CompletionConfiguration configuration) {
		super();
		this.config = configuration;
		this.completionEntry = completionEntry;
		outputPartitionName = ConstantsContainer.outputPartition + "." + completionEntry.getType().getName();
	}

	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		//preload config from last execution
		loadConfig();
		super.execute(monitor);
		debug_save();
	}
	
	private void debug_save() {
		/*ResourceSetPartition rp = this.blackboard.getPartition(config.getModelPartition());
		ResourceSet rset = new ResourceSetImpl();
		Resource resource = null;
		ArrayList<Resource> saveList = new ArrayList<Resource>();
		
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, 
				new XMIResourceFactoryImpl()); 
		
		IFolder intermediateFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("PCM_test/debug-models"));
		if(!intermediateFolder.exists())
			try {
				intermediateFolder.create(true, true, null);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		TreeIterator<Notifier> iterator = rp.getResourceSet().getAllContents();
		while(iterator.hasNext())
		{
			Notifier n = iterator.next();
			if(n instanceof Resource)
			{
				Resource r = (Resource) n;
				
				IFile partFile = intermediateFolder.getFile(r.getURI().lastSegment());
				resource = rset.createResource(URI.createFileURI(partFile.getFullPath().toString()));
				saveList.add(resource);
			}
			else if(n instanceof EObject)
			{
				resource.getContents().add((EObject) n);
			}
		}*/
		
		/*HashMap<String, String> map = new HashMap<String, String>();
		map.put("ENCODING", "UTF-8");
			
			
		for(Resource resource1 : this.blackboard.getPartition("output-partition").getResourceSet().getResources()){
			try {
				resource1.save(map);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}*/
		
		//this.blackboard.addPartition(config.getModelPartition(), this.blackboard.getPartition("output-partition"));
		config.setLastPartition(outputPartitionName);
	
	}

	public void loadConfig() {
		
		String[] partitions = new String[3];
		String prefix = completionEntry.getType().getName();
		
		//logger.debug("Loading config into CompletionTransformationJob");
		
		setDebug(true);
		setTracesPartitionName(ConstantsContainer.tracesPartition);
		IFolder tracesFolder = config.getProject().getFolder(ConstantsContainer.tracesFolder);
		if(!tracesFolder.exists())
			try {
				tracesFolder.create(true, true, null);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		setWorkingDirectory(tracesFolder.getRawLocationURI().toString());
		setDirection(ConstantsContainer.direction);
		setQvtFile(completionEntry.getType().getCompletionFile());
		setTransformation(null);
		
		createNewPartition(outputPartitionName, null, null);
		createNewPartition(ConstantsContainer.annotationPartition, new String[]{completionEntry.getFeatureFile()}, new String[]{completionEntry.getType().getAnnotationMetaFile()});
		
		IFolder intermediateFolder = config.getProject().getFolder(ConstantsContainer.outputFolder);
		if(!intermediateFolder.exists())
			try {
				intermediateFolder.create(true, true, null);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		IFile partFile = intermediateFolder.getFile(prefix + "_output.repository");
		this.blackboard.getPartition(outputPartitionName).getResourceSet().createResource(URI.createFileURI(partFile.getFullPath().toString()));
		//outputPartition.getResourceSet().createResource(URI.createFileURI(partFile.getFullPath().toString()));
		
		partitions[0] = config.getModelPartition();
		partitions[1] = outputPartitionName;
		partitions[2] = ConstantsContainer.annotationPartition;
		
		setModelPartitionNames(partitions);
	}
	
	void createNewPartition(String partitionName, String models[], String metaModels[]){
		ResourceSetPartition partition = new ResourceSetPartition();
		this.blackboard.addPartition(partitionName,partition);
		
		if(metaModels != null)
		{
			for(String metamodel:metaModels)
			{
				EPackage[] ePackages = initMetaModels(partition,metamodel);
				partition.initialiseResourceSetEPackages(ePackages);
			}
		}
		if(models != null)
			for(String model : models)
				partition.loadModel(model);
		
	}
	
	EPackage[] initMetaModels(ResourceSetPartition partition, String metamodel){
		Resource r = partition.getResourceSet().getResource(URI.createURI(metamodel), true);
		EList<EObject> content = r.getContents();
		List<EPackage> ePackages = new ArrayList<EPackage>();
		if(content.size() > 0) {
			for (EObject eObject : content) {
				if(eObject instanceof EPackage){
					ePackages.add((EPackage) eObject);
				}
			}
		}
		return ePackages.toArray(new EPackage[0]);
	}

}
