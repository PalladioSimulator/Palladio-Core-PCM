import de.uka.ipd.sdq.simucomframework.resources.IResourceContainerFactory;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;

public class ResourceEnvironment implements IResourceContainerFactory {
    public String[] getResourceContainerIDList() {
        return new String[] { "_oEjdUDRBEduaPaOP6VcQiw" };
    }

    public void fillResourceContainer(SimulatedResourceContainer rc) {
        if (rc.getResourceContainerID().equals("_oEjdUDRBEduaPaOP6VcQiw")) {
            rc.addActiveResource("CPU", 10.0, "CPU cycles");

            rc.addPassiveResource("ThreadPoolThreads", 2);

        }
        else {
            throw new RuntimeException(
                "Unknown resource container should be initialised. This should never happen");
        }
    }
}
