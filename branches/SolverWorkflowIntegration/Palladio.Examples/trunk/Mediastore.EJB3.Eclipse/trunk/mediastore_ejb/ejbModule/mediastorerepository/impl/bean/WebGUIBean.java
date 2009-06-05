package mediastorerepository.impl.bean;

import javax.annotation.security.RolesAllowed;
import javax.jws.WebService;

import mediarepository.entities.DBID3v1;


/** The Enterprise Java Bean for the component WebGUI
*/
@javax.ejb.Stateless
public class WebGUIBean extends mediastorerepository.impl.WebGUI implements mediastorerepository.impl.bean.IWebGUIBean {
    public WebGUIBean() {
    }

    
    @Override @RolesAllowed("CartUsers")
	public DBID3v1[] iHTTP_queryID3(int[] id) {
		// TODO Auto-generated method stub
		return super.iHTTP_queryID3(id);
	}


	// Called by the Container to inject a reference to the local interface of this components
    // context class
    @javax.ejb.EJB(name = "ejb/WebGUI/Context", beanInterface = mediastorerepository.impl.contexts.IWebGUIContext.class)
    @Override
    public void setContext(
        mediastorerepository.impl.contexts.IWebGUIContext context) {
        super.setContext(context);
    }
}
