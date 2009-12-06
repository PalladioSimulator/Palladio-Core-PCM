package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;

public class CreateSimuComMetaDataFilesJob implements IJob {

	private AbstractCodeGenerationWorkflowRunConfiguration configuration;
	
	public static final String F_MANIFEST = "MANIFEST.MF"; //$NON-NLS-1$
	public static final String F_MANIFEST_FP = "META-INF/" + F_MANIFEST; //$NON-NLS-1$
	public static final String F_PLUGIN = "plugin.xml"; //$NON-NLS-1$
	public static final String F_FRAGMENT = "fragment.xml"; //$NON-NLS-1$
	public static final String F_PROPERTIES = ".properties"; //$NON-NLS-1$
	public static final String F_BUILD = "build" + F_PROPERTIES; //$NON-NLS-1$
	
	public CreateSimuComMetaDataFilesJob(AbstractCodeGenerationWorkflowRunConfiguration configuration) {
		super();
		
		this.configuration = configuration;
	}
	
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		IProject project = CreatePluginProjectJob.getProject(configuration.getPluginID());
		
		try {
			createPluginXml(project);
			createManifestMf(project);
			createBuildProperties(project);
		} catch (CoreException e) {
			throw new JobFailedException("Failed to create plugin metadata files",e);
		}
	}

	public String getName() {
		return "Create SimuCom Metadata Files";
	}

	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		// Nothing to do
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
