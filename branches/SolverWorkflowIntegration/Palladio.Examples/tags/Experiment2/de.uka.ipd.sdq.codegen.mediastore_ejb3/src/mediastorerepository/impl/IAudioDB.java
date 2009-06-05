package mediastorerepository.impl;

public interface IAudioDB {
    byte[][] iMySQL_getFiles(int[] FilesIDs);

    int[] iMySQL_getIDsOfMatchingFiles(String queryString, int fieldID);
}
