package mediastorerepository.impl.bean;


/** The Enterprise Java Bean for the component WebGUI
*/
@javax.ejb.Stateless
public class WebGUIBean extends mediastorerepository.impl.WebGUI implements mediastorerepository.impl.bean.IWebGUIBean {
    public WebGUIBean() {
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
