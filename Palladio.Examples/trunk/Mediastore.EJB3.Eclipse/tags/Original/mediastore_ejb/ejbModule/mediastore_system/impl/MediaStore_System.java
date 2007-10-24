package mediastore_system.impl;

public class MediaStore_System {
    // Composed child components member variables
    protected mediastorerepository.impl.MediaStore myAssCtx_MediaStore = null;
    protected mediastorerepository.impl.WebGUI myAssCtx_WebGUI = null;
    protected mediastorerepository.impl.DigitalWatermarking myAssCtx_DigitalWatermarking =
        null;
    protected mediastorerepository.impl.DBAdapter myAssCtx_DBAdapter = null;
    protected mediastorerepository.impl.AudioDB myAssCtx_AudioDB = null;
    protected mediastore_system.impl.contexts.IMediaStore_SystemContext myContext =
        null;

    /**
    * Inner Structure initialisation
    */
    private void initInnerComponents() {
        myAssCtx_MediaStore = new mediastorerepository.impl.MediaStore(/* Add Parameters here */
            );

        myAssCtx_WebGUI = new mediastorerepository.impl.WebGUI(/* Add Parameters here */
            );

        myAssCtx_DigitalWatermarking = new mediastorerepository.impl.DigitalWatermarking(/* Add Parameters here */
            );

        myAssCtx_DBAdapter = new mediastorerepository.impl.DBAdapter(/* Add Parameters here */
            );

        myAssCtx_AudioDB = new mediastorerepository.impl.AudioDB(/* Add Parameters here */
            );

        initAssCtx_MediaStore();

        initAssCtx_WebGUI();

        initAssCtx_DigitalWatermarking();

        initAssCtx_DBAdapter();

        initAssCtx_AudioDB();
    }

    private void initAssCtx_MediaStore() {
        mediastorerepository.impl.contexts.MediaStoreContext context = new mediastorerepository.impl.contexts.MediaStoreContext(myAssCtx_DigitalWatermarking.getPortISound(),
                myAssCtx_DBAdapter.getPortIAudioDB());
        myAssCtx_MediaStore.setContext(context);
    }

    private void initAssCtx_WebGUI() {
        mediastorerepository.impl.contexts.WebGUIContext context = new mediastorerepository.impl.contexts.WebGUIContext(myAssCtx_MediaStore.getPortIMediaStore());
        myAssCtx_WebGUI.setContext(context);
    }

    private void initAssCtx_DigitalWatermarking() {
        mediastorerepository.impl.contexts.DigitalWatermarkingContext context = new mediastorerepository.impl.contexts.DigitalWatermarkingContext();
        myAssCtx_DigitalWatermarking.setContext(context);
    }

    private void initAssCtx_DBAdapter() {
        mediastorerepository.impl.contexts.DBAdapterContext context = new mediastorerepository.impl.contexts.DBAdapterContext(myAssCtx_AudioDB.getPortIMySQL());
        myAssCtx_DBAdapter.setContext(context);
    }

    private void initAssCtx_AudioDB() {
        mediastorerepository.impl.contexts.AudioDBContext context = new mediastorerepository.impl.contexts.AudioDBContext();
        myAssCtx_AudioDB.setContext(context);
    }

    /**
    * Inner Structure initialisation end
    */
    public mediastorerepository.IHTTP getPortIHTTP() {
        return myAssCtx_WebGUI.getPortIHTTP();
    }

    public void setContext(
        mediastore_system.impl.contexts.IMediaStore_SystemContext myContext) {
        this.myContext = myContext;

        initInnerComponents();
    }
}
