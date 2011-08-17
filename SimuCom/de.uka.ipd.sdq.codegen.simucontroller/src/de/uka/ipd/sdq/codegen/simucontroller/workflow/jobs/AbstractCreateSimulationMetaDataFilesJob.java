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

public abstract class AbstractCreateSimulationMetaDataFilesJob implements IJob {

    private AbstractCodeGenerationWorkflowRunConfiguration configuration;

    public static final String F_MANIFEST = "MANIFEST.MF"; //$NON-NLS-1$
    public static final String F_MANIFEST_FP = "META-INF/" + F_MANIFEST; //$NON-NLS-1$
    public static final String F_PLUGIN = "plugin.xml"; //$NON-NLS-1$
    public static final String F_FRAGMENT = "fragment.xml"; //$NON-NLS-1$
    public static final String F_PROPERTIES = ".properties"; //$NON-NLS-1$
    public static final String F_BUILD = "build" + F_PROPERTIES; //$NON-NLS-1$

    public AbstractCreateSimulationMetaDataFilesJob(AbstractCodeGenerationWorkflowRunConfiguration configuration) {
        super();

        this.configuration = configuration;
    }

    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        IProject project = CreatePluginProjectJob.getProject(configuration.getPluginID());

        try {
            createPluginXml(project);
            createManifestMf(project);
            createBuildProperties(project);
        } catch (CoreException e) {
            throw new JobFailedException("Failed to create plugin metadata files", e);
        }
    }

    public String getName() {
        return "Create Simulation Metadata Files";
    }

    public void rollback(IProgressMonitor monitor) throws RollbackFailedException {
        // Nothing to do
    }

    private void createPluginXml(IProject project) throws CoreException {

        ByteArrayOutputStream baos;
        PrintStream out;

        baos = new ByteArrayOutputStream();
        out = new PrintStream(baos);
        writePluginXml(out, project);
        out.close();
        
        IFile pluginXml = project.getFile(F_PLUGIN);
        if (!pluginXml.exists())
            pluginXml.create(new ByteArrayInputStream(baos.toByteArray()), true, null);
    }

    private void createBuildProperties(IProject project) throws CoreException {

        ByteArrayOutputStream baos;
        PrintStream out;

        baos = new ByteArrayOutputStream();
        out = new PrintStream(baos);
        writeBuildProperties(out, project);
        out.close();

        IFile buildProperties = project.getFile(F_BUILD);
        if (!buildProperties.exists())
            buildProperties.create(new ByteArrayInputStream(baos.toByteArray()), true, null);
    }

    private void createManifestMf(IProject project) throws CoreException {

        ByteArrayOutputStream baos;
        PrintStream out;

        baos = new ByteArrayOutputStream();
        out = new PrintStream(baos);
        writeManifestMf(out, project);
        out.close();

        IFile manifestMf = project.getFile(F_MANIFEST_FP);
        if (!manifestMf.exists())
            manifestMf.create(new ByteArrayInputStream(baos.toByteArray()), true, null);
    }
    
    public abstract void writePluginXml(PrintStream out, IProject project);
    
    public abstract void writeBuildProperties(PrintStream out, IProject project);
    
    public abstract void writeManifestMf(PrintStream out, IProject project);

}
