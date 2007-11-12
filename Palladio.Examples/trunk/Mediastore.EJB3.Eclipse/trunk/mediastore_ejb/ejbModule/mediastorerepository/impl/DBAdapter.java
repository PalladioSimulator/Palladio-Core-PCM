package mediastorerepository.impl;

import mediarepository.entities.DBID3v1;

public class DBAdapter implements mediastorerepository.impl.IDBAdapter {
    protected mediastorerepository.impl.ports.IAudioDB_DBAdapter m_portIAudioDB = new mediastorerepository.impl.ports.IAudioDB_DBAdapter(this);
    protected mediastorerepository.impl.contexts.IDBAdapterContext myContext = null;

    public mediastorerepository.IAudioDB getPortIAudioDB() {
        return m_portIAudioDB;
    }

    public void setContext(
        mediastorerepository.impl.contexts.IDBAdapterContext myContext) {
        this.myContext = myContext;
    }

    public byte[][] iAudioDB_queryDB(int[] desiredFiles) {
        /*PROTECTED REGION ID(queryDB__Z04Xo6YFEduWZfldHy3B1Q__Vpb1e6YGEduWZfldHy3B1Q) ENABLED START*/
        return myContext.getRoleIMySQL().getFiles(desiredFiles);

        /*PROTECTED REGION END*/
    }

    public byte[][] iAudioDB_queryAndGetFromDB(String queryString, int fieldID) {
        /*PROTECTED REGION ID(queryAndGetFromDB__Z04Xo6YFEduWZfldHy3B1Q__Vpb1e6YGEduWZfldHy3B1Q) ENABLED START*/
    	int[] idList = myContext.getRoleIMySQL().getIDsOfMatchingFiles(queryString, fieldID);
    	return myContext.getRoleIMySQL().getFiles(idList);
        /*PROTECTED REGION END*/
    }

	@Override
	public DBID3v1[] iAudioDB_queryID3(int[] id) {
		return myContext.getRoleIMySQL().queryID3(id);
	}
}
