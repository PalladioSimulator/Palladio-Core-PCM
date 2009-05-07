package mediastorerepository.impl.ports;

import mediarepository.entities.DBID3v1;


// Port class for IAudioDB_DBAdapter
public class IAudioDB_DBAdapter implements mediastorerepository.IAudioDB {
    protected mediastorerepository.impl.IDBAdapter myComponent = null;

    public IAudioDB_DBAdapter() {
    }

    public IAudioDB_DBAdapter(mediastorerepository.impl.IDBAdapter myComponent) {
        this.myComponent = myComponent;
    }

    public byte[][] queryDB(int[] desiredFiles) {
        return myComponent.iAudioDB_queryDB(desiredFiles);
    }

    public byte[][] queryAndGetFromDB(String queryString, int fieldID) {
        return myComponent.iAudioDB_queryAndGetFromDB(queryString, fieldID);
    }

	public DBID3v1[] queryID3(int[] id) {
		return myComponent.iAudioDB_queryID3(id);
	}
}
