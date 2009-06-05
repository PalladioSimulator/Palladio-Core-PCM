package mediarepository.entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import org.farng.mp3.TagNotFoundException;
import org.hibernate.annotations.Cascade;

@Entity
public class MP3MediaFile extends MediaFile {
	public MP3MediaFile(File mp3File) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(mp3File, "r");
			id3 = new DBID3v1(raf);
		} catch (TagNotFoundException tnfe){
			id3 = new DBID3v1();
			id3.setTitle(mp3File.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (raf != null)
					raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public MP3MediaFile() {}
	
	@OneToOne(cascade=CascadeType.ALL)
	protected DBID3v1 id3;

	public DBID3v1 getId3() {
		return id3;
	}

	public void setId3(DBID3v1 id3) {
		this.id3 = id3;
	}
	
	public String toString(){
		return "MP3 File: "+getFilename();
	}
}
