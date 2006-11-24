package new_component_model.impl;

import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.SimulatedComponent;
import de.uka.ipd.sdq.simucom.SimulatedSystem;

import new_component_model.*;

import new_component_model.impl.contexts.*;

import new_component_model.impl.ports.*;


// Simulator code for BasicComponent EncodingAdapter
// Mapping Component->SimulatedComponent
public class EncodingAdapter extends SimulatedComponent {
    protected IAudioDB_EncodingAdapter portIAudioDB = new IAudioDB_EncodingAdapter(this);
    protected EncodingAdapterContext myContext = null;

    public IAudioDB getPortIAudioDB() {
        return portIAudioDB;
    }

    public void setContext(EncodingAdapterContext myContext) {
        this.myContext = myContext;
    }

    public void iAudioDB_InsertAudioFile(Context ctx) {
        myContext.getRoleIEncoder().EncodeFile(ctx);

        myContext.getRoleIAudioDB().InsertAudioFile(ctx);
    }

    public void iAudioDB_InsertAudioFileInfo(Context ctx) {
        myContext.getRoleIAudioDB().InsertAudioFileInfo(ctx);
    }

    public void iAudioDB_FinalizeUpload(Context ctx) {
        myContext.getRoleIAudioDB().FinalizeUpload(ctx);
    }
}
