package mediastorerepository.impl;

public interface IDBAdapter {
    byte[][] iAudioDB_queryDB(int[] desiredFiles);

    byte[][] iAudioDB_queryAndGetFromDB(String queryString, int fieldID);
}
