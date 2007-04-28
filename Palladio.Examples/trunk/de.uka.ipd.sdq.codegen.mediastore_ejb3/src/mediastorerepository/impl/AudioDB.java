package mediastorerepository.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import mediarepository.entities.MP3MediaFile;
import mediarepository.entities.MediaFile;
import mediarepository.entities.VideoFile;

public class AudioDB implements mediastorerepository.impl.IAudioDB {
	private static final int ARTIST = 0;

	private static final int TITLE = 1;

	private static final int MOVIE = 2;

	protected mediastorerepository.impl.ports.IMySQL_AudioDB m_portIMySQL = new mediastorerepository.impl.ports.IMySQL_AudioDB(
			this);

	protected mediastorerepository.impl.contexts.IAudioDBContext myContext = null;

	@PersistenceContext
	// EntityManagerFactory emFactory = null;
	EntityManager em = null;

	public mediastorerepository.IMySQL getPortIMySQL() {
		return m_portIMySQL;
	}

	public void setContext(
			mediastorerepository.impl.contexts.IAudioDBContext myContext) {
		this.myContext = myContext;
	}

	public byte[][] iMySQL_getFiles(int[] FilesIDs) {
		/*
		 * PROTECTED REGION
		 * ID(getFiles__a5a906YFEduWZfldHy3B1Q__Wf-b66YGEduWZfldHy3B1Q) ENABLED
		 * START
		 */

		// Internal calculation <SelectFiles>
		// TODO: Implement me!
		// Hint: Here should be an action which has a ResourceDemand of type
		// CPU_AudioDB
		// => DoublePDF(unit="unit")[ (1.0; 0.4) (2.0; 0.3) (3.0; 0.3) ]
		// Hint: Here should be an action which has a ResourceDemand of type
		// HD_AudioDB
		// => DoublePDF(unit="unit")[ (1.0; 0.4) (2.0; 0.3) (3.0; 0.3) ]
		byte[][] result = new byte[FilesIDs.length][];
		for (int i = 0; i < FilesIDs.length; i++) {
			MediaFile mf = (MediaFile) em.find(MediaFile.class,
					(long) FilesIDs[i]);
			if (mf == null) {
				System.out
						.println("Error occured on DB access: " + FilesIDs[i]);
				result[i] = new byte[0];
			} else {
				if (mf instanceof MP3MediaFile) {
					result[i] = readFile(mf);
				} else if (mf instanceof VideoFile) {
					result[i] = readVideoFile(mf);
				}
			}
		}
		return result;
		/* PROTECTED REGION END */
	}

	private byte[] readFile(MediaFile mf) {
		File file = new File(mf.getFilename());
		FileInputStream fis = null;
		byte[] result = new byte[(int) file.length()];
		try {
			fis = new FileInputStream(file);
			byte[] buffer = new byte[512];
			int offset = 0;
			int bytesRead = 0;
			do {
				bytesRead = fis.read(buffer);
				for (int i = 0; i < bytesRead; i++)
					result[i + offset] = buffer[i];
				offset += bytesRead;
			} while (bytesRead == 512);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}

	private byte[] readVideoFile(MediaFile mf) {
		File file = new File(mf.getFilename());
		RandomAccessFile fis = null;
		int count = (int) (Math.random() * 10 * 1000000 + 95 * 1000000);
		byte[] result = new byte[count];
		try {
			fis = new RandomAccessFile(file, "r");
			fis.seek((long) (Math.random() * 2 * Math.pow(10, 9)));
			byte[] buffer = new byte[512];
			int offset = 0;
			int bytesRead = 0;
			do {
				bytesRead = fis.read(buffer);
				for (int i = 0; i < bytesRead; i++)
					if (i + offset < result.length)
						result[i + offset] = buffer[i];
				offset += bytesRead;
			} while (offset < result.length);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}

	public int[] iMySQL_getIDsOfMatchingFiles(String queryString, int fieldID) {
		/*
		 * PROTECTED REGION
		 * ID(getIDsOfMatchingFiles__a5a906YFEduWZfldHy3B1Q__Wf-b66YGEduWZfldHy3B1Q)
		 * ENABLED START
		 */
		int[] result = null;
		String query = null;
		List queryResult = null;
		if (fieldID < MOVIE) {
			queryResult = queryDBInternal(queryString, fieldID);
	    	int count = ((int)(Math.random()*5))+10;
	    	result = new int[count];
	    	for (int i=0; i<count; i++){
	    		result[i] = (int)(Math.random()*4100)+1;
	    	}
		} else {
			query = "SELECT file FROM VideoFile file WHERE file.movieTitle LIKE '%"+queryString+"%'";
			queryResult = em.createQuery(query).getResultList();
			result = new int[queryResult.size()];
			for (int i = 0; i < queryResult.size(); i++) {
				result[i] = (int) ((MediaFile) queryResult.get(i)).getMediaID();
			}
		}
		return result;
		/* PROTECTED REGION END */
	}

	public List queryDBInternal(String queryString, int fieldID) {
//		String query;
//		List queryResult;
//		query = "SELECT file FROM DBID3v1 tag, MP3MediaFile file WHERE ";
//		switch (fieldID) {
//		case ARTIST:
//			query += "tag.artist ";
//			break;
//		case TITLE:
//			query += "tag.title ";
//			break;
//		}
//		query += "LIKE  '%" + queryString + "%' AND file.id3 = tag";
//		queryResult = em.createQuery(query).getResultList();
		String query;
		List queryResult;
		query = "SELECT file FROM MP3MediaFile file WHERE ";
		query += "file.filename ";
		query += "LIKE  '%" + queryString + "%'";
		queryResult = em.createQuery(query).getResultList();
		return queryResult;
	}
}
