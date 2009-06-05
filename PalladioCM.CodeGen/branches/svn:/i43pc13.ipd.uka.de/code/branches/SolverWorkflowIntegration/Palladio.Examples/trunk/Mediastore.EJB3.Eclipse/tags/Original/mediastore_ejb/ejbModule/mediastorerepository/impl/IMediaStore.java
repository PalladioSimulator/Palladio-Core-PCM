package mediastorerepository.impl;

public interface IMediaStore {
    byte[][] iMediaStore_downloadFromDB(int[] desiredFiles);

    byte[][] iMediaStore_queryAndGetFromDB(String queryString, int fieldID);
}
