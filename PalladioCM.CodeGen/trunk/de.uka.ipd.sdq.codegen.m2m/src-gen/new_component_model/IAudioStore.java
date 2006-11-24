package new_component_model;

import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.SimulatedComponent;
import de.uka.ipd.sdq.simucom.SimulatedSystem;


public interface IAudioStore {
    void HandleUpload(Context ctx);

    void FinalizeUpload(Context ctx);
}
