package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.runconfig.SensitivityAnalysisConfiguration;

public class SensitivityAnalysisJob extends SequentialBlackboardInteractingJob<MDSDBlackboard> implements
        IBlackboardInteractingJob<MDSDBlackboard> {

    boolean isFinished = false;

    public SensitivityAnalysisJob(SimuComWorkflowConfiguration config, IDebugListener listener) throws CoreException {
        super(true);
        if (config.isSensitivityAnalysisEnabled()) {
            List<SensitivityAnalysisConfiguration> sconfList = config.getSensitivityAnalysisConfigurations();
            config = config.copy(sconfList);

            while (!isFinished) {
                this.add(new SimuComJob(config, listener));
                sconfList = getNextSConfigList(sconfList);
                config = config.copy(sconfList);
            }
        } else {
            this.add(new SimuComJob(config, listener));
        }

    }

    private List<SensitivityAnalysisConfiguration> getNextSConfigList(List<SensitivityAnalysisConfiguration> sconfList) {
        List<SensitivityAnalysisConfiguration> resultList = new ArrayList<SensitivityAnalysisConfiguration>();
        boolean increased = false;
        for (SensitivityAnalysisConfiguration sconf : sconfList) {
            if (!increased) {
                if (sconf.getCurrent() < sconf.getMax()) {
                    increased = true;
                    sconf = sconf.getNext();
                } else {
                    sconf = sconf.getFirst();
                }
            }
            resultList.add(sconf);
        }
        isFinished = !increased;

        return resultList;
    }
}
