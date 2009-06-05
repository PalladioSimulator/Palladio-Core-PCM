package mediastorerepository.impl;

import mediarepository.entities.DBID3v1;

public interface IMediaStore {
    byte[][] iMediaStore_downloadFromDB(int[] desiredFiles);

    byte[][] iMediaStore_queryAndGetFromDB(String queryString, int fieldID);

	DBID3v1[] iMediaStore_queryID3(int[] id);
}
