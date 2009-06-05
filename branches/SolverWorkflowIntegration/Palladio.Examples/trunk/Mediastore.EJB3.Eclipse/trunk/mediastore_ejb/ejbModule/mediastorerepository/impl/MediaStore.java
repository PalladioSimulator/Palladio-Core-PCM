package mediastorerepository.impl;

import mediarepository.entities.DBID3v1;
import mediastorerepository.ISound;

public class MediaStore implements mediastorerepository.impl.IMediaStore {
    protected mediastorerepository.impl.ports.IMediaStore_MediaStore m_portIMediaStore =
        new mediastorerepository.impl.ports.IMediaStore_MediaStore(this);
    protected mediastorerepository.impl.contexts.IMediaStoreContext myContext = null;

    public mediastorerepository.IMediaStore getPortIMediaStore() {
        return m_portIMediaStore;
    }

    public void setContext(
        mediastorerepository.impl.contexts.IMediaStoreContext myContext) {
        this.myContext = myContext;
    }

    public byte[][] iMediaStore_downloadFromDB(int[] desiredFiles) {
        /*PROTECTED REGION ID(downloadFromDB__USFdc6YFEduWZfldHy3B1Q__QW4WtKYGEduWZfldHy3B1Q) ENABLED START*/
        byte[][] files = myContext.getRoleIAudioDB().queryDB(desiredFiles);
        byte[][] result = new byte[files.length][];
        for (int i = 0; i < files.length; i++) {
            result[i] = myContext.getRoleISound().watermark(files[i]);
        }
        return result;
        /*PROTECTED REGION END*/
    }

    public byte[][] iMediaStore_queryAndGetFromDB(String queryString,
        int fieldID) {
        /*PROTECTED REGION ID(queryAndGetFromDB__USFdc6YFEduWZfldHy3B1Q__QW4WtKYGEduWZfldHy3B1Q) ENABLED START*/
    	byte[][] files = myContext.getRoleIAudioDB().queryAndGetFromDB(queryString, fieldID); // 2.5 sec
    	byte[][] result = new byte[files.length][];
        for (int i = 0; i < files.length; i++) {
        	ISound role = myContext.getRoleISound();
        	//System.gc();
        	//try {
			//	Thread.sleep(1000);
			//} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			// }
        	//long start = System.nanoTime(); System.out.println("Start: "+start);
            result[i] = role.watermark(files[i]);
        	//long end = System.nanoTime();
        	//System.out.println("Stop: "+end);
        	//System.out.println("Time: " + (end-start)/1000000000.0 + " files.length: " + files.length);
        }
        return result;
        /*PROTECTED REGION END*/
    }

	@Override
	public DBID3v1[] iMediaStore_queryID3(int[] id) {
		return myContext.getRoleIAudioDB().queryID3(id);
	}
}
