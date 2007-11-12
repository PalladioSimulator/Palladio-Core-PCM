package mediastorerepository.impl.ports;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

import mediarepository.entities.DBID3v1;


// Port class for IHTTP_WebGUI
@PermitAll
public class IHTTP_WebGUI implements mediastorerepository.IHTTP {
    protected mediastorerepository.impl.IWebGUI myComponent = null;

    public IHTTP_WebGUI() {
    }

    public IHTTP_WebGUI(mediastorerepository.impl.IWebGUI myComponent) {
        this.myComponent = myComponent;
    }

    public byte[][] downloadHTTP(int[] desiredFiles) {
        return myComponent.iHTTP_downloadHTTP(desiredFiles);
    }

    public byte[][] queryFileByField(String queryString, int fieldID) {
        return myComponent.iHTTP_queryFileByField(queryString, fieldID);
    }

    @RolesAllowed("CartUsers")
	public DBID3v1[] queryID3(int[] id) {
		return myComponent.iHTTP_queryID3(id);
	}
}
