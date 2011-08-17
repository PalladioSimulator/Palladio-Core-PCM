package mediastorerepository.impl;

import mediarepository.entities.DBID3v1;

public interface IAudioDB {
    byte[][] iMySQL_getFiles(int[] FilesIDs);

    int[] iMySQL_getIDsOfMatchingFiles(String queryString, int fieldID);

	DBID3v1[] iMySQL_queryID3(int[] id);
}
