package de.uka.ipd.sdq.cip.runtime.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.cip.completions.RegisteredCompletion;
import de.uka.ipd.sdq.cip.completions.RegisteredCompletions;

public class CompletionConfigNode {

	static public class FeatureConfig {

		private IFile file;

		public FeatureConfig(IFile file) {
			this.file = file;
		}

		public String getName() {
			return file.getName() + " - " + file.getProject().getName();
		}
		
		public String getFileURI() {
			return URI.createPlatformResourceURI(file.getLocationURI().toString(),true).toString();
		}
		
	}
	
	static public class UserDefined {
		
		private String caption;
		private UserDefinedID id;

		public UserDefined(String caption, UserDefinedID id) {
			this.caption = caption;
			this.id = id;
		}

		public String getCaption() {
			return caption;
		}
		public UserDefinedID getID() {
			return id;
		}

		
		
	}
	
	public enum CompletionConfigNodeID{
		WORKSPACE,
		REGISTRED,
		USERDEFINED
		
	};
	
	public enum UserDefinedID{
		FEATURECONFIG,
		ANNOTATED,
		PLAIN,
		PLAINQVTO
		
	};
	
	private CompletionConfigNodeID id;
	private Collection<?> configElements;
	private String caption;
	
	private CompletionConfigNode(CompletionConfigNodeID id, String caption,Collection<?> configElements) {
		this.id = id;
		this.caption = caption;
		this.configElements = configElements;
	}
	
	public static CompletionConfigNode createWorkspaceNode() throws CoreException {
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace(); 
		IWorkspaceRoot workspaceRoot = workspace.getRoot();
		List<?> featureConfigs = (List<?>) scanFolder(workspaceRoot);
		CompletionConfigNode node = new CompletionConfigNode(CompletionConfigNodeID.WORKSPACE,"Workspace FeatureConfigs",featureConfigs);
		return node;
	}
	
	private static List< FeatureConfig> scanFolder(IContainer container) throws CoreException {
		IResource[] resources = container.members();
		ArrayList<FeatureConfig> featureConfigs = new ArrayList<FeatureConfig>();
		for(int i = 0; i < resources.length; i++) {
			if(resources[i].getType() == IResource.PROJECT){
				IProject project = (IProject) resources[i];
				if(project.isOpen()) {
					featureConfigs.addAll(scanFolder((IContainer)resources[i]));
				}
			}
			if(resources[i].getType() == IResource.FOLDER)
				featureConfigs.addAll(scanFolder((IContainer)resources[i]));
			else if (resources[i].getType() == IResource.FILE){
				IFile file = (IFile) resources[i];
				if(file.getFileExtension() != null && file.getFileExtension().contains("featureconfig"))
				{
					FeatureConfig featureConfig = new FeatureConfig(file);
					featureConfigs.add(featureConfig);
				}
			}
		}
		
		return featureConfigs;
	}

	public static CompletionConfigNode createRegisteredNode() {
		Collection<RegisteredCompletion> completions = RegisteredCompletions.getCompletions();
		for(RegisteredCompletion completion : completions) {
			if(completion.getFeaturemodel() != null)
				completions.remove(completion);
		}
		CompletionConfigNode node = new CompletionConfigNode(CompletionConfigNodeID.REGISTRED,"Registered Completions", completions);
		return node;
	}
	public static CompletionConfigNode createUserDefinedNode() {
		ArrayList<UserDefined> userDefineds = new ArrayList<UserDefined>();
		userDefineds.add(new UserDefined("FeatureConfig based Completion",UserDefinedID.FEATURECONFIG));
		userDefineds.add(new UserDefined("Annotated Completion",UserDefinedID.ANNOTATED));
		userDefineds.add(new UserDefined("Plain Completion",UserDefinedID.PLAIN));
		userDefineds.add(new UserDefined("Plain QVTO Completion",UserDefinedID.PLAINQVTO));
		CompletionConfigNode node = new CompletionConfigNode(CompletionConfigNodeID.USERDEFINED,"User-defined", userDefineds);
		return node;
	}
	
	public  Object[] getChildren() {
		return configElements.toArray();
	}
	
	public String getCaption() {
		return caption;
	}
	
	public CompletionConfigNodeID getID() {
		return id;
	}
}