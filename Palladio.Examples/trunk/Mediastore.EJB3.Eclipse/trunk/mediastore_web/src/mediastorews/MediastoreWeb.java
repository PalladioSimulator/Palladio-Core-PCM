package mediastorews;

import javax.ejb.EJB;
import javax.jws.WebService;

import com.sun.appserv.security.ProgrammaticLogin;

import mediarepository.entities.DBID3v1;
import mediastorerepository.IHTTP;

@WebService
public class MediastoreWeb implements IHTTP {

	@EJB(beanInterface = IHTTP.class)
	private IHTTP store = null;
	
	public DBID3v1[] queryID3(int[] id) {
		return store.queryID3(id);
	}

	public byte[][] downloadHTTP(int[] desiredFiles) {
		// TODO Auto-generated method stub
		return null;
	}

	public byte[][] queryFileByField(String queryString, int fieldID) {
		// TODO Auto-generated method stub
		return null;
	}
}
