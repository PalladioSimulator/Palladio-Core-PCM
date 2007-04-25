/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.eclipse.core.internal.events.BuildCommand;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.WorkspaceModelManager;
import org.eclipse.pde.internal.core.natures.PDE;
import org.eclipse.pde.internal.ui.wizards.plugin.ClasspathComputer;
import org.eclipse.pde.internal.ui.wizards.tools.UpdateClasspathJob;
import org.eclipse.pde.ui.launcher.PDESourcePathProvider;

/**
 * @author admin
 * 
 */
public class CreatePluginProject {

	public static String PROJECT_ID = "de.uka.ipd.sdq.codegen.simucominstance";

	private IProject project;

	public CreatePluginProject(IProgressMonitor monitor) throws CoreException {
		createProject(monitor);
	}

	/**
	 * @param monitor
	 * @param workspace
	 * @param project
	 * @return
	 * @throws CoreException
	 */
	private void createProject(IProgressMonitor monitor) throws CoreException {

		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_ID);

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

		new OawEclipseProjectResourceLoader(project);
	}

	public void setClasspath(IProject project) throws CoreException {
		ClasspathComputer.setClasspath(project, PluginRegistry
				.findModel(project));
	}

	public void setProjectToJavaProject(IProject project)
			throws JavaModelException, CoreException {
		// create class path entry
		IJavaProject javaProject = JavaCore.create(project);
		IPath srcPath = javaProject.getPath().append("src");
		IPath binPath = javaProject.getPath().append("bin");
		IClasspathEntry[] buildPath = { JavaCore.newSourceEntry(srcPath),
				JavaRuntime.getDefaultJREContainerEntry() };
		javaProject.setRawClasspath(buildPath, binPath, null);
	}

	private void createDescription(IProject project, IProgressMonitor monitor)
			throws CoreException {
		IProjectDescription description = ResourcesPlugin.getWorkspace()
				.newProjectDescription(project.getName());
		description.setNatureIds(new String[] { JavaCore.NATURE_ID,
				PDE.PLUGIN_NATURE });
		//description.setNatureIds(new String[] { JavaCore.NATURE_ID});
		description.setLocation(null);
		// set java bulders
		ICommand command = description.newCommand();
		command.setBuilderName(JavaCore.BUILDER_ID);
		description.setBuildSpec(new BuildCommand[] {(BuildCommand) command});
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

	public void createPlugin(IProject project, IProgressMonitor monitor)
			throws CoreException {
		ArrayList<IPluginModelBase> models = new ArrayList<IPluginModelBase>();
		if (project != null && WorkspaceModelManager.isPluginProject(project)
				&& project.hasNature(JavaCore.NATURE_ID)) {
			IPluginModelBase model = PluginRegistry.findModel(project);
			if (model != null) {
				models.add(model);
			}
		}

		final IPluginModelBase[] modelArray = (IPluginModelBase[]) models
				.toArray(new IPluginModelBase[models.size()]);

		new UpdateClasspathJob(modelArray).doUpdateClasspath(monitor,
				modelArray);

	}

	private void createPluginXml(IProject project) throws CoreException {

		String PLUGIN_XML = "plugin.xml";
		ByteArrayOutputStream baos;
		PrintStream out;

		baos = new ByteArrayOutputStream();
		out = new PrintStream(baos);

		
		out.println("<?xml version='1.0'?>"); 			//$NON-NLS-1$
		out.println("<plugin>"); 						//$NON-NLS-1$
		out.println("   <extension"); 					//$NON-NLS-1$
		out.println("         point=\"de.uka.ipd.sdq.codegen.simucontroller.controller\">"); //$NON-NLS-1$
		out.println("      <actionDelegate");			 //$NON-NLS-1$
		out.println("            class=\"main.SimuComControl\""); //$NON-NLS-1$
		out.println("            id=\"de.uka.ipd.sdq.codegen.simucominstance.actionDelegate\">"); //$NON-NLS-1$
		out.println("      </actionDelegate>"); 		//$NON-NLS-1$
		out.println("   </extension>"); 				//$NON-NLS-1$
		out.println("</plugin>"); //$NON-NLS-1$
		out.close();

		IFile pluginXml = project.getFile(PLUGIN_XML);
		if (!pluginXml.exists())
			pluginXml.create(new ByteArrayInputStream(baos.toByteArray()),
					true, null);
	}

	private void createBuildProperties(IProject project) throws CoreException {

		String BUILD_PROPERTIES = "build.properties";
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

		IFile buildProperties = project.getFile(BUILD_PROPERTIES);
		if (!buildProperties.exists())
			buildProperties.create(
					new ByteArrayInputStream(baos.toByteArray()), true, null);
	}

	private void createManifestMf(IProject project) throws CoreException {

		String MANIFEST_MF = "MANIFEST.MF";

		ByteArrayOutputStream baos;
		PrintStream out;

		baos = new ByteArrayOutputStream();
		out = new PrintStream(baos);

		out.println("Manifest-Version: 1.0"); //$NON-NLS-1$
		out.println("Bundle-ManifestVersion: 2"); //$NON-NLS-1$
		out.println("Bundle-Name: SimuCom Instance Plug-in"); //$NON-NLS-1$
		out.println("Bundle-SymbolicName: " + project.getName() + ";singleton:=true"); //$NON-NLS-1$
		out.println("Bundle-Version: 1.0.0"); //$NON-NLS-1$
		out.println("Require-Bundle: org.eclipse.ui,"); //$NON-NLS-1$
		out.println(" org.eclipse.core.runtime,"); //$NON-NLS-1$
		out.println(" de.uka.ipd.sdq.simucomframework,"); //$NON-NLS-1$
		out.println(" de.uka.ipd.sdq.simucomframework.variables,"); //$NON-NLS-1$
		out.println(" de.uka.ipd.sdq.desmojwrapper,"); //$NON-NLS-1$
		out.println(" de.uka.ipd.sdq.codegen.simucontroller"); //$NON-NLS-1$
		out.println("Eclipse-LazyStart: true"); //$NON-NLS-1$
		out.println("Bundle-ClassPath: bin/,");
		out.println(" .");
		out.println("Export-Package: main");
		out.close();

		IFile manifestMf = project.getFile("META-INF/" + MANIFEST_MF);
		if (!manifestMf.exists())
			manifestMf.create(new ByteArrayInputStream(baos.toByteArray()),
					true, null);
	}

	/**
	 * @return the project
	 */
	public IProject getProject() {
		return project;
	}

}
