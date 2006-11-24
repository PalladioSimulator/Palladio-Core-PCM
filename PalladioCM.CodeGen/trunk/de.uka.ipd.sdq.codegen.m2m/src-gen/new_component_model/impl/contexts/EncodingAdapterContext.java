package new_component_model.impl.contexts;

import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.SimulatedComponent;
import de.uka.ipd.sdq.simucom.SimulatedSystem;

import new_component_model.*;


// Component context class for EncodingAdapter
public class EncodingAdapterContext {
    protected IEncoder iEncoder = null;
    protected IAudioDB iAudioDB = null;

    public EncodingAdapterContext(IEncoder iEncoder, IAudioDB iAudioDB) {
        this.iEncoder = iEncoder;

        this.iAudioDB = iAudioDB;
    }

    public IEncoder getRoleIEncoder() {
        return iEncoder;
    }

    public IAudioDB getRoleIAudioDB() {
        return iAudioDB;
    }
}
