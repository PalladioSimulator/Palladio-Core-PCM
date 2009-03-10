package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.eclipse.core.internal.events.BuildCommand;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.natures.PDE;
import org.eclipse.pde.internal.core.ClasspathComputer;

/**
 * This class is responsible for the generation of a container Plug-In. That
 * means, a project is generated, with that Java-Nature and Plugin-Nature and
 * also a src folder. Thereby all configuration elements are along-generated,
 * Plug in necessarily also (MANIFEST.MF, plugin.xml, build.properties).
 * 
 * @author Roman Andrej
 */
public class PluginProject {
	
	public static final String F_MANIFEST = "MANIFEST.MF"; //$NON-NLS-1$
	public static final String F_MANIFEST_FP = "META-INF/" + F_MANIFEST; //$NON-NLS-1$
	public static final String F_PLUGIN = "plugin.xml"; //$NON-NLS-1$
	public static final String F_FRAGMENT = "fragment.xml"; //$NON-NLS-1$
	public static final String F_PROPERTIES = ".properties"; //$NON-NLS-1$
	public static final String F_BUILD = "build" + F_PROPERTIES; //$NON-NLS-1$

	/**
	 * name of generated instance
	 */
	// public static String PROJECT_ID = "de.uka.ipd.sdq.codegen.simucominstance";

	private PluginProject(){
		
	}
	
	public static PluginProject createInstance(){
		return new PluginProject();
	}
	
	/**
	 * deletes a folder and all of its contents recursively
	 * 
	 * @param folder the folder to be deleted
	 * @return true on success, false otherwise
	 */
	private boolean deleteFolder(File folder) {
		if (folder.isDirectory()) {
			for(File child:folder.listFiles()) {
				System.out.println(child.toString());
				if (!deleteFolder(child)) {
					return false;
				}
	        }	       
	    }
		
		 // empty folders can be deleted directly
        return folder.delete();
	}
	
	/**
	 * clears the simulation plugin folder
	 */	
	private void clearPluginFolder(String projectId) {
		File pluginFolder = ResourcesPlugin
		.getWorkspace()
		.getRoot()
		.getRawLocation()
		.append(projectId)
		.toFile();
	
		deleteFolder(pluginFolder);
	}
	
	/**
	 * removes the simulation plugin project from the workspace
	 * if it exists
	 * @throws CoreException 
	 */
	private void deleteSimulationProject(String projectId, IProgressMonitor monitor) throws CoreException {
		for (IProject project:ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			if (project.getName().equals(projectId)) {
				IResource[] projects = {project};
				ResourcesPlugin.getWorkspace().delete(projects, true, monitor);
			}
		}
	}
	
	/**
	 * returns a new project to be used for the simulation
	 * 
	 * @return a handle to the project to be used for the simulation
	 */
	private IProject createSimulationProject(String projectId) {
						
		return ResourcesPlugin.getWorkspace().getRoot().getProject(
				projectId);
	}
	
	/**
	 * The function implements all steps, which are necessary for the creation of
	 * a Plugin Project
	 * @param projectId The ID of the new project
	 * @param monitor The progress monitor which displays progress
	 * @return - container project (Plug-In)
	 */
	public IProject createContainerPlugin(String projectId, IProgressMonitor monitor) throws CoreException {

		// remove any existing project references and files
		deleteSimulationProject(projectId,monitor);		
		clearPluginFolder(projectId);
		
		IProject project = createSimulationProject(projectId);

		IFolder srcFolder = project.getFolder("src");
		IFolder manifestFolder = project.getFolder("META-INF");

		// create resourcen
		createProject(project, monitor);
		createFolder(project, srcFolder);
		createFolder(project, manifestFolder);

		// create deskription
		createDescription(project, monitor);

		// create JavaProject
		setProjectToJavaProject(project);

		createPluginXml(project);
		createManifestMf(project);
		createBuildProperties(project);
		// set Plug-In class path
		setClasspath(project);

		return project;
	}

	/* (non-Javadoc)
	 * @See org.eclipse.pde.internal.ui.wizards.plugin.ClasspathComputer.setClasspath(IProject)
	 */
	private void setClasspath(IProject project) throws CoreException {
		ClasspathComputer.setClasspath(project, PluginRegistry
				.findModel(project));
	}

	/**
	 * Create the Java-Project from IProject and set "src", "bin" folder to
	 * classpath
	 */
	private void setProjectToJavaProject(IProject project)
			throws JavaModelException, CoreException {
		// create class path entry
		IJavaProject javaProject = JavaCore.create(project);
		IPath srcPath = javaProject.getPath().append("src");
		IPath binPath = javaProject.getPath().append("bin");
		IClasspathEntry[] buildPath = { JavaCore.newSourceEntry(srcPath),
				JavaRuntime.getDefaultJREContainerEntry() };
		javaProject.setRawClasspath(buildPath, binPath, null);
	}

	/**
	 * Create a projeckt description and set the JavaCore.NATURE_ID and
	 * PDE.PLUGIN_NATURE
	 */
	private void createDescription(IProject project, IProgressMonitor monitor)
			throws CoreException {
		IProjectDescription description = ResourcesPlugin.getWorkspace()
				.newProjectDescription(project.getName());
		description.setNatureIds(new String[] { JavaCore.NATURE_ID,
				PDE.PLUGIN_NATURE });
		description.setLocation(null);
		// set java bulders
		ICommand command = description.newCommand();
		command.setBuilderName(JavaCore.BUILDER_ID);
		description.setBuildSpec(new BuildCommand[] { (BuildCommand) command });
		project.setDescription(description, monitor);
	}

	private void createFolder(IProject project, IFolder folder)
			throws CoreException {
		if (project.isOpen() && !folder.exists()) {
			folder.create(false, true, null);
		}
	}

	private void createProject(IProject project, IProgressMonitor monitor)
			throws CoreException {
		if (!project.exists())
			project.create(monitor);
		project.open(monitor);
	}

	private void createPluginXml(IProject project) throws CoreException {

		ByteArrayOutputStream baos;
		PrintStream out;

		baos = new ByteArrayOutputStream();
		out = new PrintStream(baos);

		
		out.println("<?xml version='1.0'?>"); 			//$NON-NLS-1$
		out.println("<plugin>"); 						//$NON-NLS-1$
		out.println("   <extension"); 					//$NON-NLS-1$
		out.println("         point=\"de.uka.ipd.sdq.simucomframework.controller\">"); //$NON-NLS-1$
		out.println("      <actionDelegate");			 //$NON-NLS-1$
		out.println("            class=\"main.SimuComControl\""); //$NON-NLS-1$
		out.println("            id=\"de.uka.ipd.sdq.codegen.simucominstance.actionDelegate\">"); //$NON-NLS-1$
		out.println("      </actionDelegate>"); 		//$NON-NLS-1$
		out.println("   </extension>"); 				//$NON-NLS-1$
		out.println("</plugin>"); //$NON-NLS-1$
		out.close();

		IFile pluginXml = project.getFile(F_PLUGIN);
		if (!pluginXml.exists())
			pluginXml.create(new ByteArrayInputStream(baos.toByteArray()),
					true, null);
	}

	private void createBuildProperties(IProject project) throws CoreException {

		ByteArrayOutputStream baos;
		PrintStream out;

		baos = new ByteArrayOutputStream();
		out = new PrintStream(baos);

		out.println("output.. = bin/"); //$NON-NLS-1$
		out.println("source.. = src/"); //$NON-NLS-1$
		out.println("bin.includes = plugin.xml,\\"); //$NON-NLS-1$
		out.println("				META-INF/,\\"); //$NON-NLS-1$
		out.println("				."); //$NON-NLS-1$
		out.close();

		IFile buildProperties = project.getFile(F_BUILD);
		if (!buildProperties.exists())
			buildProperties.create(
					new ByteArrayInputStream(baos.toByteArray()), true, null);
	}

	private void createManifestMf(IProject project) throws CoreException {

		ByteArrayOutputStream baos;
		PrintStream out;

		baos = new ByteArrayOutputStream();
		out = new PrintStream(baos);

		out.println("Manifest-Version: 1.0"); //$NON-NLS-1$
		out.println("Bundle-ManifestVersion: 2"); //$NON-NLS-1$
		out.println("Bundle-Name: SimuCom Instance Plug-in"); //$NON-NLS-1$
		out.println("Bundle-SymbolicName: " + project.getName() + ";singleton:=true"); //$NON-NLS-1$
		out.println("Bundle-Version: 1.0.0"); //$NON-NLS-1$
		out.println("Bundle-Activator: main.SimuComControl");
		out.println("Require-Bundle: de.uka.ipd.sdq.simucomframework,"); //$NON-NLS-1$
		out.println(" de.uka.ipd.sdq.simucomframework.simucomstatus,"); //$NON-NLS-1$
		out.println(" de.uka.ipd.sdq.sensorframework,"); //$NON-NLS-1$
		out.println(" de.uka.ipd.sdq.simucomframework.variables,"); //$NON-NLS-1$
		out.println(" org.apache.log4j,"); //$NON-NLS-1$
		out.println(" org.eclipse.osgi,"); //$NON-NLS-1$
		out.println(" de.uka.ipd.sdq.scheduler"); //$NON-NLS-1$
		out.println("Eclipse-LazyStart: true"); //$NON-NLS-1$
		out.println("Bundle-ClassPath: bin/,");
		out.println(" .");
		//out.println("Export-Package: main");
		out.close();

		IFile manifestMf = project.getFile(F_MANIFEST_FP);
		if (!manifestMf.exists())
			manifestMf.create(new ByteArrayInputStream(baos.toByteArray()),
					true, null);
	}
}
