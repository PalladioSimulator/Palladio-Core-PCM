package mediastorerepository.impl.contexts;


// Component context class for WebGUI
public class WebGUIContext implements mediastorerepository.impl.contexts.IWebGUIContext {
    protected mediastorerepository.IMediaStore iMediaStore = null;

    public WebGUIContext() {
    }

    public WebGUIContext(mediastorerepository.IMediaStore iMediaStore) {
        this.iMediaStore = iMediaStore;
    }

    public mediastorerepository.IMediaStore getRoleIMediaStore() {
        if (iMediaStore == null) {
            throw new RuntimeException(
                "Attempt to retrieve unbounded port. Check your architecture!");
        }

        return iMediaStore;
    }

    public void setRoleIMediaStore(mediastorerepository.IMediaStore newValue) {
        this.iMediaStore = newValue;
    }
}
