package de.uka.ipd.sdq.simulation.controller.workflow.jobs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.CreatePluginProjectJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;

/**
 * 
 * @author Philipp Merkle
 *
 */
public class CreateSimulationMainFile implements IJob {

    public static final String F_MAIN_FOLDER = "src/main";
    
    public static final String F_SIMULATIONMAIN = "Main.java";
    
    private AbstractCodeGenerationWorkflowRunConfiguration configuration;
    
    public CreateSimulationMainFile(AbstractCodeGenerationWorkflowRunConfiguration configuration) {
        this.configuration = configuration;
    }
    
    @Override
    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        IProject project = CreatePluginProjectJob.getProject(configuration.getPluginID());

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
        out.println("public class Main extends de.uka.ipd.sdq.simulation.SimulationMain {");
        out.println("}");
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void rollback(IProgressMonitor monitor) throws RollbackFailedException {
        // TODO Auto-generated method stub

    }

}
