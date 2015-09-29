package edu.kit.ipd.sdq.simcomp.controller.workflow.jobs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.palladiosimulator.analyzer.workflow.configurations.AbstractCodeGenerationWorkflowRunConfiguration;
import org.palladiosimulator.analyzer.workflow.jobs.CreatePluginProjectJob;

import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;

/**
 * This job creates the meta data files for the simulation code plugin project.
 * 
 * This class is based on {@link CreateSimulationMainFile}. Some code has
 * been reused.
 * 
 * @author Christoph Föhrdes
 */
public class CreateSimulationComponentMainFile implements IJob {

    public static final String F_MAIN_FOLDER = "src/main";
    
    public static final String F_SIMULATIONMAIN = "Main.java";
    
    private AbstractCodeGenerationWorkflowRunConfiguration configuration;
    
    public CreateSimulationComponentMainFile(AbstractCodeGenerationWorkflowRunConfiguration configuration) {
        this.configuration = configuration;
    }
    
    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        IProject project = CreatePluginProjectJob.getProject(configuration.getStoragePluginID());

        try {
            createSimulationMainFile(project);
        } catch (CoreException e) {
            throw new JobFailedException("Failed to create simulation main file", e);
        }
    }
    
    public void createSimulationMainFile(IProject project) throws CoreException {
        ByteArrayOutputStream baos;
        PrintStream out;

        baos = new ByteArrayOutputStream();
        out = new PrintStream(baos);
        writeSimulationMainFile(out, project);
        out.close();

        // create main folder, if necessary
        IFolder mainFolder = project.getFolder(F_MAIN_FOLDER);
        if (!mainFolder.exists())
            mainFolder.create(false, true, null);

        // create simulation main file
        IFile simulationMain = project.getFile(F_MAIN_FOLDER + "/" + F_SIMULATIONMAIN);
        if (!simulationMain.exists())
            simulationMain.create(new ByteArrayInputStream(baos.toByteArray()), true, null);
    }
    
    private void writeSimulationMainFile(PrintStream out, IProject project) {
        out.println("package main;");
        out.println("public class Main extends edu.kit.ipd.sdq.simcomp.middleware.simulation.SimulationMain {");
        out.println("}");
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {
        // TODO Auto-generated method stub

    }

}
