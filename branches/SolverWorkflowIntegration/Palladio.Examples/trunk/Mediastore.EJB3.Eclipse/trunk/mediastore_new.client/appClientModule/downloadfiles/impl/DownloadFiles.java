package downloadfiles.impl;

import java.util.Arrays;
import java.util.Random;

import com.sun.appserv.security.ProgrammaticLogin;

import mediarepository.entities.DBID3v1;
import mediastorerepository.IHTTP;
import mediastorews.MediastoreWSWrapper;

public class DownloadFiles implements java.lang.Runnable {
    protected mediastorerepository.IHTTP m_portIHTTP = null;
	private int[] ids;
    private static final int ARTIST = 0;
	private static final int TITLE = 1;
	private static final int MOVIE = 2;

	static int j = 0;
	
    public DownloadFiles(boolean useRMI) {
    	if (!useRMI) {
    		m_portIHTTP = new MediastoreWSWrapper();
    	} else {
    		ProgrammaticLogin pl = new ProgrammaticLogin();
    		pl.login("snowball", "snowilein");
	    	javax.naming.InitialContext initial;
	        try {
	            initial = new javax.naming.InitialContext();
	            m_portIHTTP = (IHTTP)initial.lookup("mediastorerepository.IHTTP");
	        } catch (javax.naming.NamingException e) {
	            e.printStackTrace();
	        }
    	}
    	initIDs(30000);
    }

	private void initIDs(int count) {    	
    	ids = new int[count];
    	Random rand = new Random(1234);
    	for (int i=0; i<count; i++){
    		ids[i] = (int)(rand.nextDouble()*1500)+1;
    	}
	}

    public void scenarioRunner() {
    	//if (j % 100 == 0) System.out.print('.');
    	//if ((j+1) % 25000 == 0) throw new RuntimeException("Request stop");
        /*PROTECTED REGION ID(_gBOngaY5EdudtvdezBq5JQ) ENABLED START*/
        m_portIHTTP.queryID3(Arrays.copyOf(ids, 1));
    	/*PROTECTED REGION END*/
        //j++;
    }

    public void run() {
        scenarioRunner();
    }
}
