package new_component_model.impl;

import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.SimulatedComponent;
import de.uka.ipd.sdq.simucom.SimulatedSystem;

import new_component_model.*;

import new_component_model.impl.contexts.*;

import new_component_model.impl.ports.*;


// Simulator code for BasicComponent AudioStore
// Mapping Component->SimulatedComponent
public class AudioStore extends SimulatedComponent {
    protected IAudioStore_AudioStore portIAudioStore = new IAudioStore_AudioStore(this);
    protected AudioStoreContext myContext = null;

    public IAudioStore getPortIAudioStore() {
        return portIAudioStore;
    }

    public void setContext(AudioStoreContext myContext) {
        this.myContext = myContext;
    }

    public void iAudioStore_HandleUpload(Context ctx) {
        myContext.getRoleIAudioDB().InsertAudioFile(ctx);

        myContext.getRoleIAudioDB().InsertAudioFileInfo(ctx);

        myContext.getRoleIAudioDB().FinalizeUpload(ctx);
    }

    public void iAudioStore_FinalizeUpload(Context ctx) {
    }
}
