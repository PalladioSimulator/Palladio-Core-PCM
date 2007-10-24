package mediastorerepository.impl.ports;


// Port class for IMySQL_AudioDB
public class IMySQL_AudioDB implements mediastorerepository.IMySQL {
    protected mediastorerepository.impl.IAudioDB myComponent = null;

    public IMySQL_AudioDB() {
    }

    public IMySQL_AudioDB(mediastorerepository.impl.IAudioDB myComponent) {
        this.myComponent = myComponent;
    }

    public byte[][] getFiles(int[] FilesIDs) {
        return myComponent.iMySQL_getFiles(FilesIDs);
    }

    public int[] getIDsOfMatchingFiles(String queryString, int fieldID) {
        return myComponent.iMySQL_getIDsOfMatchingFiles(queryString, fieldID);
    }
}
