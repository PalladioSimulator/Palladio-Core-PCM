package mediastorerepository;

import mediarepository.entities.DBID3v1;

public interface IHTTP {
    byte[][] downloadHTTP(int[] desiredFiles);

    byte[][] queryFileByField(String queryString, int fieldID);

	DBID3v1[] queryID3(int[] id);
}
