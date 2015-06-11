package org.palladiosimulator.protocom.jobs;

import org.eclipse.core.runtime.CoreException;
import org.palladiosimulator.protocom.workflow.ProtoComGenerationConfiguration;

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

    public ProtoComCodeGenerationJob(final ProtoComGenerationConfiguration configuration) throws CoreException {
        this(configuration, null);
    }

    public ProtoComCodeGenerationJob(final ProtoComGenerationConfiguration configuration, final IDebugListener listener)
            throws CoreException {
        super(false);

        if (listener == null && configuration.isDebug()) {
            throw new IllegalArgumentException("Debug listener has to be non-null for debug runs");
        }

        // 1. Load PCM models into memory
        this.addJob(new LoadPCMModelsIntoBlackboardJob(configuration));

        // 2. Validate PCM models in memory
        this.addJob(new ValidatePCMModelsJob(configuration));

        // 3. Generate code into projects using Xtend
        this.addJob(new TransformPCMToCodeXtendJob(configuration));
    }
}