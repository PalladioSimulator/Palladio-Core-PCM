package new_component_model.impl;

import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.SimulatedComponent;
import de.uka.ipd.sdq.simucom.SimulatedSystem;

import new_component_model.*;

import new_component_model.impl.contexts.*;

import new_component_model.impl.ports.*;


// Simulator code for BasicComponent WebUI
// Mapping Component->SimulatedComponent
public class WebUI extends SimulatedComponent {
    protected IHTTP_WebUI portIHTTP = new IHTTP_WebUI(this);
    protected WebUIContext myContext = null;

    public IHTTP getPortIHTTP() {
        return portIHTTP;
    }

    public void setContext(WebUIContext myContext) {
        this.myContext = myContext;
    }

    public void iHTTP_UploadFiles(Context ctx) {
        for (int iterationCount = 0, maxIterationCount = ctx.evaluate(
                    "= files.NUMBER_OF_ELEMENTS");
                iterationCount < maxIterationCount; iterationCount++) {
            myContext.getRoleIAudioStore().HandleUpload(ctx);
        }

        myContext.getRoleIAudioStore().FinalizeUpload(ctx);
    }
}
