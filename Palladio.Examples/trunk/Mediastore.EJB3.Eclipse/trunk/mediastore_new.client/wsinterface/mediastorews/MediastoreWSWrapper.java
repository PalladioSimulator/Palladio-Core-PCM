package mediastorews;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import mediarepository.entities.DBID3v1;
import mediastorerepository.IHTTP;


public class MediastoreWSWrapper implements IHTTP {

	private MediastoreWeb store;

	public MediastoreWSWrapper() {
		this.store = new MediastoreWebService().getMediastoreWebPort();
	}

	public DBID3v1[] queryID3(int[] id) {
		ArrayList<DBID3v1> result = new ArrayList<DBID3v1>();
		List<Integer> input = new ArrayList<Integer>();
		for (int i : id)
			input.add(i);
		result.addAll(store.queryID3(input));
		return result.toArray(new DBID3v1[]{});
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
