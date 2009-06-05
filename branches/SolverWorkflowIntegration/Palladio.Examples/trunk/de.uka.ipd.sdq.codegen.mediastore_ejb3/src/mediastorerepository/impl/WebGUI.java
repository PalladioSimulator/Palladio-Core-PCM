package mediastorerepository.impl;

public class WebGUI implements mediastorerepository.impl.IWebGUI {
    protected mediastorerepository.impl.ports.IHTTP_WebGUI m_portIHTTP = new mediastorerepository.impl.ports.IHTTP_WebGUI(this);
    protected mediastorerepository.impl.contexts.IWebGUIContext myContext = null;

    public mediastorerepository.IHTTP getPortIHTTP() {
        return m_portIHTTP;
    }

    public void setContext(
        mediastorerepository.impl.contexts.IWebGUIContext myContext) {
        this.myContext = myContext;
    }

    public byte[][] iHTTP_downloadHTTP(int[] desiredFiles) {
        /*PROTECTED REGION ID(downloadHTTP__RLTSs6YFEduWZfldHy3B1Q__O42SdKYGEduWZfldHy3B1Q) ENABLED START*/
        byte[][]result = myContext.getRoleIMediaStore().downloadFromDB(desiredFiles);

    	return result;
        /*PROTECTED REGION END*/
    }

    public byte[][] iHTTP_queryFileByField(String queryString, int fieldID) {
        /*PROTECTED REGION ID(queryFileByField__RLTSs6YFEduWZfldHy3B1Q__O42SdKYGEduWZfldHy3B1Q) ENABLED START*/
    	byte[][] result = myContext.getRoleIMediaStore()
                        .queryAndGetFromDB(queryString, fieldID);
    	return result;
        /*PROTECTED REGION END*/
    }
}
