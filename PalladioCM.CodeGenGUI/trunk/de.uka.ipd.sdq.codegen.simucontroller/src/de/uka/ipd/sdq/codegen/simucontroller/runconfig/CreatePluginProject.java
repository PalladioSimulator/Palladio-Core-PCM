/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
	private void createProject(IProgressMonitor monitor)
			throws CoreException {

		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_ID);

		IFolder srcFolder = project.getFolder("src");
		IFolder manifestFolder = project.getFolder("META-INF");

		createProject(project, monitor);
		createFolder(project, srcFolder);
		createFolder(project, manifestFolder);

		// create deskription
		createDescription(project, monitor);
		setProjectToJavaProject();
		
		new OawEclipseProjectResourceLoader(project);
	}

	public void setProjectToJavaProject() throws JavaModelException,
			CoreException {
		// create class path entry
		IJavaProject javaProject = JavaCore.create(project);
		IPath srcPath = javaProject.getPath().append("src");
		IPath binPath = javaProject.getPath().append("bin");
		IClasspathEntry[] buildPath = { JavaCore.newSourceEntry(srcPath),
				JavaRuntime.getDefaultJREContainerEntry() };
		javaProject.setRawClasspath(buildPath, binPath, null);
		// createPlugin(project, monitor);
		createPluginXml(project);
		createManifestMf(project);
	}

	private void createDescription(IProject project, IProgressMonitor monitor)
			throws CoreException {
		IProjectDescription description = ResourcesPlugin.getWorkspace()
				.newProjectDescription(project.getName());
		description.setNatureIds(new String[] { JavaCore.NATURE_ID });
		description.setLocation(null);
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

	// public IPlugin createPlugin(IProject project, IProgressMonitor monitor) {
	//		
	// //PluginPr
	//		
	// PluginProject pluginProject = new PluginProject();
	// pluginProject.setProject((IProject) project);
	// try {
	// pluginProject.configure();
	// } catch (CoreException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// //
	// //BundlePluginModel model = new BundlePluginModel();
	// //IPluginObject
	// // IPluginBase pluginBase = model.createPluginBase();
	// // IPluginObject object = new PluginLibrary();
	// // model.createElement(object);
	//		
	// return null;
	// }
	//

	private void createPluginXml(IProject project) throws CoreException {

		String PLUGIN_XML = "plugin.xml";
		ByteArrayOutputStream baos;
		PrintStream out;

		baos = new ByteArrayOutputStream();
		out = new PrintStream(baos);

		out.println("<?xml version='1.0'?>"); //$NON-NLS-1$
		out.println("<plugin>"); //$NON-NLS-1$
		out.println("</plugin>"); //$NON-NLS-1$
		out.close();

		IFile pluginXml = project.getFile(PLUGIN_XML);
		if (!pluginXml.exists())
			pluginXml.create(new ByteArrayInputStream(baos.toByteArray()),
					true, null);
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
		out
				.println("Bundle-SymbolicName: " + project.getName() + ";singleton:=true"); //$NON-NLS-1$
		out.println("Bundle-Version: 1.0.0"); //$NON-NLS-1$
		out.println("Require-Bundle: org.eclipse.ui,"); //$NON-NLS-1$
		out.println(" org.eclipse.core.runtime,"); //$NON-NLS-1$
		out.println(" org.openarchitectureware.core.workflow"); //$NON-NLS-1$
		out.println("Eclipse-LazyStart: true"); //$NON-NLS-1$
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
