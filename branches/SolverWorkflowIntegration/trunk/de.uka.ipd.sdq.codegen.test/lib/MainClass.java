import de.uka.ipd.sdq.simucomframework.AbstractMain;
import de.uka.ipd.sdq.simucomframework.resources.IResourceContainerFactory;
import de.uka.ipd.sdq.simucomframework.usage.ClosedWorkload;
import de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver;

import uscenario.impl.UScenarioFactory;

public class MainClass extends AbstractMain {
    public static void main(String[] args) {
        new MainClass().run();
    }

    protected IWorkloadDriver[] getWorkloads() {
        return new IWorkloadDriver[] {
            new ClosedWorkload(new UScenarioFactory(getModel()), 30)
        };
    }

    protected IResourceContainerFactory getResourceContainerFactory() {
        return new ResourceEnvironment();
    }
}
