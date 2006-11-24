package new_component_model.impl.contexts;

import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.SimulatedComponent;
import de.uka.ipd.sdq.simucom.SimulatedSystem;

import new_component_model.*;


// Component context class for AudioStore
public class AudioStoreContext {
    protected IAudioDB iAudioDB = null;

    public AudioStoreContext(IAudioDB iAudioDB) {
        this.iAudioDB = iAudioDB;
    }

    public IAudioDB getRoleIAudioDB() {
        return iAudioDB;
    }
}
