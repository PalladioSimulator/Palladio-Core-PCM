package new_component_model.impl.contexts;

import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.SimulatedComponent;
import de.uka.ipd.sdq.simucom.SimulatedSystem;

import new_component_model.*;


// Component context class for WebUI
public class WebUIContext {
    protected IAudioStore iAudioStore = null;

    public WebUIContext(IAudioStore iAudioStore) {
        this.iAudioStore = iAudioStore;
    }

    public IAudioStore getRoleIAudioStore() {
        return iAudioStore;
    }
}
