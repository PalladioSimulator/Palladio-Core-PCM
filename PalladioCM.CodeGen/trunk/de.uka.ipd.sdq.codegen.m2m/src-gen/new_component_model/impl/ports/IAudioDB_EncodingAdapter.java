package new_component_model.impl.ports;

import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.SimulatedComponent;
import de.uka.ipd.sdq.simucom.SimulatedSystem;

import new_component_model.*;

import new_component_model.impl.EncodingAdapter;


// Port class for IAudioDB_EncodingAdapter
public class IAudioDB_EncodingAdapter implements IAudioDB {
    protected EncodingAdapter myComponent = null;

    public IAudioDB_EncodingAdapter(EncodingAdapter myComponent) {
        this.myComponent = myComponent;
    }

    public void InsertAudioFile(Context ctx) {
        myComponent.iAudioDB_InsertAudioFile(ctx);
    }

    public void InsertAudioFileInfo(Context ctx) {
        myComponent.iAudioDB_InsertAudioFileInfo(ctx);
    }

    public void FinalizeUpload(Context ctx) {
        myComponent.iAudioDB_FinalizeUpload(ctx);
    }
}
