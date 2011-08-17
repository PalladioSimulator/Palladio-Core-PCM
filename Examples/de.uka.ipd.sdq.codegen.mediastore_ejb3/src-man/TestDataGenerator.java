import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mediarepository.entities.DBID3v1;
import mediarepository.entities.MP3MediaFile;
import mediarepository.entities.MediaFile;
import mediarepository.entities.VideoFile;

public class TestDataGenerator {

	private static EntityManagerFactory emFactory = Persistence
		.createEntityManagerFactory("mediastore");

	// Process only files under dir
	public static void visitAllFiles(File dir, String extension, boolean recursive, ArrayList<File> result) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			if (children == null) {
				System.out.println(dir.getName());
			} else {
				for (int i = 0; i < children.length; i++) {
					if (new File(dir, children[i]).isDirectory() && recursive)
						visitAllFiles(new File(dir, children[i]),extension,recursive,result);
					else {
						if (children[i].toLowerCase().endsWith(extension.toLowerCase()))
							result.add(new File(dir,children[i]));
					}
				}
			}
		} else {
			if (dir.getName().toLowerCase().endsWith(extension.toLowerCase()))
				result.add(dir);
		}
	}

	public static void readMetadataFromFiles() {
		ArrayList<File> allMP3Files = new ArrayList<File>(1000);
		//visitAllFiles(new File("y:/New MP3 Lib"),".mp3",true,allMP3Files);
		//visitAllFiles(new File("y:/Mp3"),".mp3",true, allMP3Files);
		visitAllFiles(new File("y:/"),".mp3",true, allMP3Files);
		EntityManager em2 = emFactory.createEntityManager();
		EntityTransaction t = em2.getTransaction();
		t.begin();
		for (File mp3File : allMP3Files) {
			System.out.println(mp3File.getName());
			MP3MediaFile mp3 = new MP3MediaFile(mp3File);
			mp3.setFilename(mp3File.getAbsolutePath());
			em2.persist(mp3);
		}
		t.commit();
		em2.close();
	}

	public static void generateMetaData(int count) {
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		for (int i = 0; i < count; i++) {
			MP3MediaFile mp3File = new MP3MediaFile();
			mp3File.setDescription("File " + i);
			mp3File.setFilename("file" + i + ".mp3");
			DBID3v1 id3 = new DBID3v1();
			id3.setArtist(generateRandomString());
			id3.setTitle(generateRandomString());
			id3.setAlbum(generateRandomString());
			mp3File.setId3(id3);
			em.persist(mp3File);
			if (i % 10000 == 0)
				System.out.print(i + " ");
			if (i % 100000 == 0) {
				System.out.println();
				em.flush();
				em.clear();
				t.commit();
				t.begin();
			}
		}
		t.commit();
		em.close();
	}

	private static String generateRandomString() {
		String result = "";
		int charCount = (int)(Math.random() * 20) + 10;
		for (int i= 0;i<charCount;i++){
			char c = Character.toChars((int)(Math.random()*26)+65)[0];
			result += c;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("--- Start: Reading Movie Files ---");
		readMovieFiles();
		System.out.println("--- Reading MP3 Files ---");
//		readMetadataFromFiles();
		System.out.println("--- Generating Movie Files ---");
		generatePseudoMovieFiles(10000);
//		System.out.println("--- Generating MP3 Files ---");
//		//generateMetaData(250000);
//		System.out.println("--- Testing ---");
		EntityManager em = emFactory.createEntityManager();
//		//List<MediaFile> queryResult = em.createQuery("SELECT file FROM VideoFile file WHERE file.movieTitle LIKE '%"+"geister"+"%'").getResultList();
//		String query = "SELECT file FROM MP3MediaFile file WHERE ";
//		query += "file.filename ";
//		query += "LIKE  '%" + "truckstop" + "%'";
//		List<MediaFile> queryResult = em.createQuery(query).getResultList();
//		for(MediaFile mf:queryResult)
//			System.out.println(mf.getFilename());

		String query="SELECT file FROM VideoFile file WHERE file.movieTitle LIKE '%"+"annp_1701"+"%'";
		for(int i=0; i<50; i++)	{
//			for(int j=0; j<5; j++)
//				em.createQuery(query).
//					getResultList();
			long start = System.nanoTime();
			List<MediaFile> queryResult2 = em.createQuery(query).
				getResultList();
			long end = System.nanoTime();
			System.out.println("DB #count "+i*10000+" measure "+(end-start)/Math.pow(10,9));
//			generateMetaData(10000);
		}
		em.close();
		System.out.println("--- Done ---");
	}

	private static void readMovieFiles() {
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();

		ArrayList<File> allVideoFiles = new ArrayList<File>(1000);
		visitAllFiles(new File("y:/"), ".avi", false, allVideoFiles);
		visitAllFiles(new File("y:/"), ".iso", false, allVideoFiles);
		for(File f:allVideoFiles){
			VideoFile vf = new VideoFile();
			System.out.println(f.getAbsolutePath());
			vf.setFilename(f.getAbsolutePath());
			vf.setMovieTitle(f.getName().replace(".avi",""));
			em.persist(vf);
		}
		t.commit();
		em.close();
	}

	private static void generatePseudoMovieFiles(int count) {
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();

		for(int i=0; i<count; i++){
			VideoFile vf = new VideoFile();
			vf.setFilename("file"+i);
			vf.setMovieTitle(generateRandomString());
			em.persist(vf);
		}
		t.commit();
		em.close();
	}
}
