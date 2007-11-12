package mediastorerepository;

import mediarepository.entities.DBID3v1;

public interface IAudioDB {
    byte[][] queryDB(int[] desiredFiles);

    byte[][] queryAndGetFromDB(String queryString, int fieldID);

	DBID3v1[] queryID3(int[] id);
}
