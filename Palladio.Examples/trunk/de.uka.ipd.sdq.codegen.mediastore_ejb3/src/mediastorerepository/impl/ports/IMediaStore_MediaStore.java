package mediastorerepository.impl.ports;


// Port class for IMediaStore_MediaStore
public class IMediaStore_MediaStore implements mediastorerepository.IMediaStore {
    protected mediastorerepository.impl.IMediaStore myComponent = null;

    public IMediaStore_MediaStore() {
    }

    public IMediaStore_MediaStore(
        mediastorerepository.impl.IMediaStore myComponent) {
        this.myComponent = myComponent;
    }

    public byte[][] downloadFromDB(int[] desiredFiles) {
        return myComponent.iMediaStore_downloadFromDB(desiredFiles);
    }

    public byte[][] queryAndGetFromDB(String queryString, int fieldID) {
        return myComponent.iMediaStore_queryAndGetFromDB(queryString, fieldID);
    }
}
