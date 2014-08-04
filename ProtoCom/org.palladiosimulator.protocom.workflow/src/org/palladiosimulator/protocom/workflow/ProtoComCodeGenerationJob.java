package org.palladiosimulator.protocom.workflow;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.ValidatePCMModelsJob;

/**
 * Main job for the SDQ workflow engine which will run a ProtoCom generation
 * 
 * @author Steffen Becker, Thomas Zolynski, Sebastian Lehrig
 */
public class ProtoComCodeGenerationJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> implements
        IBlackboardInteractingJob<MDSDBlackboard> {

    public ProtoComCodeGenerationJob(ProtoComGenerationConfiguration configuration) throws CoreException {
        this(configuration, null);
    }

    public ProtoComCodeGenerationJob(ProtoComGenerationConfiguration configuration, IDebugListener listener)
            throws CoreException {
        super(false);

        if (listener == null && configuration.isDebug()) {
            throw new IllegalArgumentException("Debug listener has to be non-null for debug runs");
        }

        // 1. Load PCM models into memory
        this.addJob(new LoadPCMModelsIntoBlackboardJob(configuration));

        // 2. Validate PCM models in memory
        this.addJob(new ValidatePCMModelsJob(configuration));

        // TODO Daria: Remove the following job and integrate project creation into transformation
        // Create empty project
        // this.add(new CreatePluginProjectJob(configuration));

        // 3. Generate code into projects using Xtend
        this.addJob(new TransformPCMToCodeXtendJob(configuration));

        // TODO Daria: Remove step 4, delete CreateProtoComMetaDataFilesJob, and integrate manifest
        // generation into transformation
        // 4. Generate MANIFEST.MF file
        // this.addJob(new CreateProtoComMetaDataFilesJob(configuration));

        // TODO Check the role of the following step once Daria's tasks are done
        // 5. Compile the plugin (otherwise the source files are not properly found)
        // this.addJob(new CompilePluginCodeJob(configuration));

    }
}