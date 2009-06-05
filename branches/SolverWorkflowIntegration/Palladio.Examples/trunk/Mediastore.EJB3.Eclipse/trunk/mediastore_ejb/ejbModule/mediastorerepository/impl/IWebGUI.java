package mediastorerepository.impl;

import mediarepository.entities.DBID3v1;

public interface IWebGUI {
    byte[][] iHTTP_downloadHTTP(int[] desiredFiles);

    byte[][] iHTTP_queryFileByField(String queryString, int fieldID);

	DBID3v1[] iHTTP_queryID3(int[] id);
}
