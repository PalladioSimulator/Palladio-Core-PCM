package mediastorerepository;

import mediarepository.entities.DBID3v1;

public interface IMySQL {
    byte[][] getFiles(int[] FilesIDs);

    int[] getIDsOfMatchingFiles(String queryString, int fieldID);

	DBID3v1[] queryID3(int[] id);
}
