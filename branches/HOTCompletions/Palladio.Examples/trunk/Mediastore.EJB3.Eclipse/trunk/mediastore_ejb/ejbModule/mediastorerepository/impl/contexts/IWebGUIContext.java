package mediastorerepository.impl.contexts;


// Component context interface for WebGUI
public interface IWebGUIContext {
    mediastorerepository.IMediaStore getRoleIMediaStore();

    void setRoleIMediaStore(mediastorerepository.IMediaStore newValue);
}
