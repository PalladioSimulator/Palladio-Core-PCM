package mediastorerepository.impl;

import mediarepository.entities.DBID3v1;

public interface IDBAdapter {
    byte[][] iAudioDB_queryDB(int[] desiredFiles);

    byte[][] iAudioDB_queryAndGetFromDB(String queryString, int fieldID);

	DBID3v1[] iAudioDB_queryID3(int[] id);
}
