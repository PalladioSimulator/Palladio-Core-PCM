package new_component_model.impl.ports;

import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.SimulatedComponent;
import de.uka.ipd.sdq.simucom.SimulatedSystem;

import new_component_model.*;

import new_component_model.impl.WebUI;


// Port class for IHTTP_WebUI
public class IHTTP_WebUI implements IHTTP {
    protected WebUI myComponent = null;

    public IHTTP_WebUI(WebUI myComponent) {
        this.myComponent = myComponent;
    }

    public void UploadFiles(Context ctx) {
        myComponent.iHTTP_UploadFiles(ctx);
    }
}
