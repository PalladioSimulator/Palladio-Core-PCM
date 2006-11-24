package new_component_model.impl;

import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.SimulatedComponent;
import de.uka.ipd.sdq.simucom.SimulatedSystem;

import new_component_model.*;

import new_component_model.impl.contexts.*;

import new_component_model.impl.ports.*;


// Simulator code for BasicComponent OggEncoder
// Mapping Component->SimulatedComponent
public class OggEncoder extends SimulatedComponent {
    protected IEncoder_OggEncoder portIEncoder = new IEncoder_OggEncoder(this);
    protected OggEncoderContext myContext = null;

    public IEncoder getPortIEncoder() {
        return portIEncoder;
    }

    public void setContext(OggEncoderContext myContext) {
        this.myContext = myContext;
    }

    public void iEncoder_EncodeFile(Context ctx) {
        {
            double demand = ctx.evaluate("= file.BYTESIZE / 500000");
            ctx.findResource("cpu").load(demand);
        }
    }
}
