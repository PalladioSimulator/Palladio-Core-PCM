package new_component_model;

import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.SimulatedComponent;
import de.uka.ipd.sdq.simucom.SimulatedSystem;


public interface IAudioDB {
    void InsertAudioFile(Context ctx);

    void InsertAudioFileInfo(Context ctx);

    void FinalizeUpload(Context ctx);
}
