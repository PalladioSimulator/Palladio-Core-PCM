package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;
import de.uka.ipd.sdq.workflow.pcm.jobs.CreatePluginProjectJob;
import edu.rice.cs.util.jar.JarBuilder;

public class BuildPluginJarJob implements IJob {

    private byte[] result = null;
    private AbstractCodeGenerationWorkflowRunConfiguration configuration;

    public BuildPluginJarJob(AbstractCodeGenerationWorkflowRunConfiguration configuration) {
        super();

        this.configuration = configuration;
    }

    public byte[] getResult() {
        return result;
    }

    public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        URI location = null;
        try {
            location = CreatePluginProjectJob.getProject(this.configuration.getStoragePluginID()).getLocationURI();
            String jarLocation = new File(location).getAbsolutePath() + File.separator + "simucominstance.jar";
            JarBuilder builder = new JarBuilder(new File(jarLocation));
            addCompiledClasses(location, builder);
            addMetadataFiles(location, builder);
            addModelFiles(location, builder);
            builder.close();
            this.result = loadBundle(new File(location).getAbsolutePath() + File.separator + "simucominstance.jar");
        } catch (IOException e) {
            throw new JobFailedException("Compile Plugin failed. Error creating JAR archive.", e);
        }
    }

    /**
     * @param location
     * @param builder
     */
    private void addMetadataFiles(URI location, JarBuilder builder) {
        builder.addDirectoryRecursive(new File(location), "", new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().toUpperCase().contains("META-INF")
                        || pathname.getName().toUpperCase().contains("MANIFEST")
                        || pathname.getName().contains("plugin.xml");
            }
        });
    }

    /**
     * @param location
     * @param builder
     */
    private void addModelFiles(URI location, JarBuilder builder) {
        builder.addDirectoryRecursive(new File(location).listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.equals("model");
            }
        })[0], "model");
    }

    /**
     * @param location
     * @param builder
     */
    private void addCompiledClasses(URI location, JarBuilder builder) {
        builder.addDirectoryRecursive(new File(location).listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.contains("bin");
            }
        })[0], "");
    }

    public String getName() {
        return "Building simulation plugin JAR archive";
    }

    public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {
    }

    private byte[] loadBundle(String location) throws IOException {
        byte[] result = null;
        File bundleFile = new File(location);
        result = new byte[(int) bundleFile.length()];
        FileInputStream fis = new FileInputStream(bundleFile);
        fis.read(result);
        fis.close();
        return result;
    }

}
