package new_component_model.impl.ports;

import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.SimulatedComponent;
import de.uka.ipd.sdq.simucom.SimulatedSystem;

import new_component_model.*;

import new_component_model.impl.OggEncoder;


// Port class for IEncoder_OggEncoder
public class IEncoder_OggEncoder implements IEncoder {
    protected OggEncoder myComponent = null;

    public IEncoder_OggEncoder(OggEncoder myComponent) {
        this.myComponent = myComponent;
    }

    public void EncodeFile(Context ctx) {
        myComponent.iEncoder_EncodeFile(ctx);
    }
}
