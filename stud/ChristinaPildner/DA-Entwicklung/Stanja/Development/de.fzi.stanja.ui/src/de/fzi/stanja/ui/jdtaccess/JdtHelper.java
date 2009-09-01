package de.fzi.stanja.ui.jdtaccess;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import de.fzi.stanja.core.model.AbstractAnalyzer;
import de.fzi.stanja.ui.StanjaUiConstants;

/**
 * The class contain useful methods to obtain information from Platform.
 * Elements:
 *  - ExtentionElement: Analyzer
 *  - ExtentionElement: Policy
 *  - WorkspaceProjects
 * @author Christina
 *
 */
public final class JdtHelper {
	
 private JdtHelper(){} /*no object instantiation*/
 
 	private static final IExtensionRegistry registry = Platform.getExtensionRegistry();
 	private static final IWorkspace workspace = ResourcesPlugin.getWorkspace();
	
 	/**
 	 * create analyzer objects from the given AnalyserList
 	 * @return
 	 * @throws CoreException 
 	 */
 	public static final List<AbstractAnalyzer> getAnalyzerObjectList
 									(List<IConfigurationElement> analyzerList) throws CoreException{
 		List<AbstractAnalyzer> analyzerObjectList = new ArrayList<AbstractAnalyzer>();
 		for(IConfigurationElement analyzer : analyzerList ){
 			final AbstractAnalyzer analyzerObject = (AbstractAnalyzer) analyzer.createExecutableExtension("class"); 
 			analyzerObjectList.add(analyzerObject);
 		}
 		return analyzerObjectList;
 	}
 	
 	public static final List<AbstractAnalyzer> getAnalyzerObjectList() throws CoreException{
 		return getAnalyzerObjectList(getAnalyzerListFromExtentions());
 	}
 	
 	
 	public static IConfigurationElement[] getAnalyzerArrayFromExtentions(){
		return registry.getConfigurationElementsFor(StanjaUiConstants.STANJA_EP_ANALYZERS);
		 
	}
 	
 	public static List<IConfigurationElement> getAnalyzerListFromExtentions(){
 		List<IConfigurationElement> analyzerList = new ArrayList<IConfigurationElement>();
 		IConfigurationElement[] analyzerArray = getAnalyzerArrayFromExtentions();
 		for (IConfigurationElement analyzer : analyzerArray){
 			analyzerList.add(analyzer);
 		}
 		return analyzerList;
  	}
 	
 	public static List<String> getAnalyzerNameListFromExtentions(){
 		List<String> analyzerNameList = new ArrayList<String>();
 		IConfigurationElement[] analyzerArray = getAnalyzerArrayFromExtentions();
 		for (IConfigurationElement analyzer : analyzerArray){
 			analyzerNameList.add(analyzer.getAttribute("name"));
 		}
  		return analyzerNameList;
 	}
 	
 	public static IProject[] getProjectArrayFromWorkspace(){
 		return workspace.getRoot().getProjects();
 	}
 	
 	public static String[] getProjectNameArrayFromWorkspace(){
 		IProject[] projectArray = getProjectArrayFromWorkspace();
 		String[] projectNameArray = new String[projectArray.length];
 		for (int i = 0; i< projectNameArray.length; i++ ){
 			projectNameArray[i] = projectArray[i].getName();
 		}
 		return projectNameArray;
 	}
 	
 	public static int getNumberOfProjectsInWorkspace(){
 		return getProjectArrayFromWorkspace().length;
 	}
	

	
	
}
