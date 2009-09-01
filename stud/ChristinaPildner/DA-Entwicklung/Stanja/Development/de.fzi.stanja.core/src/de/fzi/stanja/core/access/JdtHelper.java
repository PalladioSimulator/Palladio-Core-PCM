package de.fzi.stanja.core.access;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.preference.IPreferenceStore;

import de.fzi.stanja.core.model.AbstractAnalyzer;

/**
 * The class contain useful methods to obtain information from Platform and from the core 
 * Elements:
 *  - ExtentionElement: Analyzer
 *  - ExtentionElement: Policy
 *  - WorkspaceProjects
 * @author Christina
 *
 */
public final class JdtHelper {
	
 private JdtHelper(){} /*no object instantiation*/
 
 
 	private static final Logger logger = Logger.getLogger(JdtHelper.class);
 	private static final IExtensionRegistry registry = Platform.getExtensionRegistry();
 	private static final IWorkspace workspace = ResourcesPlugin.getWorkspace();
 	private static final IWorkspaceRoot workspaceRoot = workspace.getRoot();
 	private static final IPreferenceStore store = StanjaConstants.STANJA_PREFERENCE_STORE; 
	
 	
 	public static IWorkspace getWorkspace(){
 		return workspace;
 	}
 	public static IWorkspaceRoot getWorkspaceRoot(){
 		return workspaceRoot;
 	}
 	
 	public static IExtensionRegistry getExtentionRegistry(){
 		return registry;
 	}
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
 	
 	public static final List<AbstractAnalyzer> getActiveAnalyzersListFromPreferences() throws CoreException{
 		List<AbstractAnalyzer> allAnalyzers =  getAnalyzerObjectList();
 		List<AbstractAnalyzer> activeAnalyzers = new ArrayList<AbstractAnalyzer>();
 		for (AbstractAnalyzer analyzer: allAnalyzers){
 			if(store.getBoolean("ANALYZER_"+analyzer.getId())){
 				activeAnalyzers.add(analyzer);
 			}
 		}
 		return activeAnalyzers;
 	}
 	
 	public static final List<AbstractAnalyzer> getAnalyzerObjectList() throws CoreException{
 		return getAnalyzerObjectList(getAllAnalyzersListFromExtentions());
 	}
 	
 	
 	public static IConfigurationElement[] getAnalyzerArrayFromExtentions(){
		return registry.getConfigurationElementsFor(StanjaConstants.STANJA_EP_ANALYZERS);
		 
	}
 	
 	public static List<IConfigurationElement> getAllAnalyzersListFromExtentions(){
 		List<IConfigurationElement> analyzerList = new ArrayList<IConfigurationElement>();
 		IConfigurationElement[] analyzerArray = getAnalyzerArrayFromExtentions();
 		for (IConfigurationElement analyzer : analyzerArray){
 			analyzerList.add(analyzer);
 		}
 		return analyzerList;
  	}
 	
 	/**
 	 * get the analyzer names List from extension.
 	 * this method is used f.e in the ui plugin to set the default active value of the
 	 * analyzer in the prefernces 
 	 * 
 	 * @return
 	 */
 	public static List<String> getAllAnalyzersNameListFromExtentions(){
 		List<String> analyzersNameList = new ArrayList<String>();
 		IConfigurationElement[] analyzerArray = getAnalyzerArrayFromExtentions();
 		for (IConfigurationElement analyzer : analyzerArray){
 			analyzersNameList.add(analyzer.getAttribute("name"));
 		}
  		return analyzersNameList;
 	}
 	
  	public static List<IConfigurationElement> getAllPoliciesListFromExtentions(){
  		List<IConfigurationElement> analyzersNameList = getAllAnalyzersListFromExtentions();
 		List<IConfigurationElement> policiesList = new ArrayList<IConfigurationElement>();
 		for(IConfigurationElement analyzer: analyzersNameList){
 			IConfigurationElement[] policies = analyzer.getChildren();
 			for(IConfigurationElement policy : policies){
 				policiesList.add(policy);
 			}
 		}
 		return policiesList;
  	}
  	
 	
 	public static List<String> getAllPoliciesNameListFromExtentions(){
 		List<IConfigurationElement> policiesList = getAllPoliciesListFromExtentions();
 		List<String> policiesNameList = new ArrayList<String>();
 		for(IConfigurationElement policy : policiesList){
 			policiesNameList.add(policy.getAttribute("name"));
 		}
 		return policiesNameList;
 	}
 	
 	public static IProject[] getProjectArrayFromWorkspace(){
 		return workspace.getRoot().getProjects();
 	}
 	
 	public static List<IProject> gettAllProjectsListFromWorkspace(){
 		List<IProject> projectList = new ArrayList<IProject>();
 		IProject[] projectArray =  getProjectArrayFromWorkspace();
 		for (IProject project : projectArray){
 			projectList.add(project);
 		}
 		return projectList;
 	}
 	
 	
 	public static List<String> getProjectNameListFromWorkspace(){
 		IProject[] projectArray = getProjectArrayFromWorkspace();
 		List<String> projectList = new ArrayList<String>();
 		for (IProject project : projectArray){
 			projectList.add(project.getName());
 		}
 		return projectList;
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
 	
 	public static List<String> extractSourceFoldersFromAllJavaProjects(){
 		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();
		IProject[] projects = workspaceRoot.getProjects();
		List<String> projectNames = new ArrayList<String>();
		for(IProject project: projects){
			projectNames.add(project.getName());
		}
		return extractSourceFoldersFromJavaProjects(projectNames) ;
 	}
	
 	public static List<String> extractSourceFoldersFromJavaProjects(Collection<String> projectNames) {
		List<IProject> foundProjects = getProjectsFromWorkspace(projectNames);
		return new ArrayList<String>(extractSourceFoldersFromJavaProjects(foundProjects));
	}
 	
	
 	private static List<IProject> getProjectsFromWorkspace(Collection<String> projectNames) {
		IWorkspaceRoot workspaceRoot = workspace.getRoot();
		IProject[] projects = workspaceRoot.getProjects();
		List<String> copyOfProjectNames = new ArrayList<String>(projectNames);

		List<IProject> foundProjects = new ArrayList<IProject>();
		for (IProject project : projects) {
			if (copyOfProjectNames.contains(project.getName())) {
				foundProjects.add(project);
				copyOfProjectNames.remove(project.getName());
			}
		}

		for (String projectName : copyOfProjectNames) {
			logger.error("project is not in workspace: \"" + projectName + "\"");
		}
		return foundProjects;
	}
	
 	private static Set<String> extractSourceFoldersFromJavaProjects(List<IProject> projects) {
		List<IJavaProject> javaProjects = filterNonJavaProjects(projects);
		Set<String> sourceFolders = new HashSet<String>();
		IWorkspaceRoot root = workspace.getRoot();

		for (IJavaProject javaProject : javaProjects) {
			try {
				IClasspathEntry[] resolvedClasspath = javaProject.getResolvedClasspath(false);
				for (IClasspathEntry classPathEntry : resolvedClasspath) {
					if (IClasspathEntry.CPE_SOURCE == classPathEntry.getEntryKind()) {
						IFile file = root.getFile(classPathEntry.getPath());
						sourceFolders.add(file.getLocation().toOSString());
					}
				}
			} catch (CoreException e) {
				logger.error("unable to determin sourcefolder for java project "
						+ javaProject, e);
			}
		}
		return sourceFolders;
	}
 	
 	public static List<IJavaProject> filterNonJavaProjects(List<IProject> projects) {
		final String nature = JavaCore.NATURE_ID;
		List<IJavaProject> javaProjects = new ArrayList<IJavaProject>();
		for (IProject project : projects) {
			try {
				if (!project.hasNature(nature)) {
					logger.warn("\"" + project.getName()
							+ "\" is not a java project -> skip project");
					continue;
				}
				javaProjects.add(JavaCore.create(project));
			} catch (CoreException e) {
				logger.error("Error converting an IProject to an IJavaProject", e);
			}
		}

		return javaProjects;
	}
 	
 	public static List<String> extractRequiredJavaLibraries(Collection<String> projectNames) {
		List<IProject> foundProjects = getProjectsFromWorkspace(projectNames);
		return extractRequiredJavaLibraries(foundProjects);
	}
 	
 	private static List<String> extractRequiredJavaLibraries(List<IProject> projects) {
		List<IJavaProject> javaProjects = filterNonJavaProjects(projects);
		List<String> resolvedLibraries = new ArrayList<String>();
		collectProjectsCombinedClassPath(javaProjects, resolvedLibraries);
		removeProjectsOutputFolders(javaProjects, resolvedLibraries);
		return resolvedLibraries;
	}
 	
 	private static void collectProjectsCombinedClassPath(List<IJavaProject> javaProjects,
			List<String> resolvedLibraries) {
		for (IJavaProject javaProject : javaProjects) {
			try {
				String[] classPath = JavaRuntime.computeDefaultRuntimeClassPath(javaProject);
				for (String element : classPath) {
					if (!resolvedLibraries.contains(element)) {
						resolvedLibraries.add(element);
					} else {
						logger.trace("dependency already known: \"" + element + "\"");
					}
				}
			} catch (CoreException e) {
				logger.error(
						"unable to determin RefaultRuntimeClasspath of the javaproject  "
								+ javaProject, e);
			}
		}
	}
 	
	private static void removeProjectsOutputFolders(Collection<IJavaProject> projects,
			List<String> resolvedLibraries) {
		for (IJavaProject javaProject : projects) {
			try {
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IWorkspaceRoot root = workspace.getRoot();
				IPath path = javaProject.getOutputLocation();
				IResource member = root.findMember(path);
				String buildFolder = member.getLocation().makeAbsolute().toOSString();
				if (!resolvedLibraries.remove(buildFolder)) {
					throw new IllegalArgumentException();
				}
			} catch (JavaModelException e) {
				logger.error("unable to remove projects bin path");
			}
		}
	}
	
	public static String getCompilerJavaSourceLevel(){
		return "5,0";
	}
}
