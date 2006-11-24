package new_component_model.impl.ports;

import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.SimulatedComponent;
import de.uka.ipd.sdq.simucom.SimulatedSystem;

import new_component_model.*;

import new_component_model.impl.AudioStore;


// Port class for IAudioStore_AudioStore
public class IAudioStore_AudioStore implements IAudioStore {
    protected AudioStore myComponent = null;

    public IAudioStore_AudioStore(AudioStore myComponent) {
        this.myComponent = myComponent;
    }

    public void HandleUpload(Context ctx) {
        myComponent.iAudioStore_HandleUpload(ctx);
    }

    public void FinalizeUpload(Context ctx) {
        myComponent.iAudioStore_FinalizeUpload(ctx);
    }
}
