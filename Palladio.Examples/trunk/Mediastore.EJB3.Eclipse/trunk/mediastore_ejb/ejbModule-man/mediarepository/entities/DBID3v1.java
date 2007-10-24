package mediarepository.entities;

import java.io.IOException;
import java.io.RandomAccessFile;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.farng.mp3.AbstractMP3Tag;
import org.farng.mp3.TagNotFoundException;
import org.farng.mp3.id3.ID3v1;

@Entity
public class DBID3v1 extends ID3v1 {

	protected long idID3Tag;
	
	public DBID3v1() {
	}

	public DBID3v1(ID3v1 arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DBID3v1(AbstractMP3Tag arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DBID3v1(RandomAccessFile arg0) throws TagNotFoundException,
			IOException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}


	@Override @Basic
	public String getAlbum() {
		// TODO Auto-generated method stub
		return super.getAlbum();
	}

	@Override @Basic
	public String getArtist() {
		// TODO Auto-generated method stub
		return super.getArtist();
	}

	@Override @Basic
	public String getComment() {
		// TODO Auto-generated method stub
		return super.getComment();
	}

	@Override @Basic
	public byte getGenre() {
		// TODO Auto-generated method stub
		return super.getGenre();
	}

	@Override @Basic
	public String getSongGenre() {
		// TODO Auto-generated method stub
		return super.getSongGenre();
	}

	@Override @Basic
	public String getTitle() {
		// TODO Auto-generated method stub
		return super.getTitle();
	}

	@Override @Basic
	public String getYear() {
		// TODO Auto-generated method stub
		return super.getYear();
	}

	@Override @Basic
	public void setAlbum(String arg0) {
		// TODO Auto-generated method stub
		super.setAlbum(arg0);
	}

	@Override @Basic
	public void setArtist(String arg0) {
		// TODO Auto-generated method stub
		super.setArtist(arg0);
	}

	@Override @Basic
	public void setComment(String arg0) {
		// TODO Auto-generated method stub
		super.setComment(arg0);
	}

	@Override @Basic
	public void setGenre(byte arg0) {
		// TODO Auto-generated method stub
		super.setGenre(arg0);
	}


	@Override @Basic
	public void setTitle(String arg0) {
		// TODO Auto-generated method stub
		super.setTitle(arg0);
	}

	@Override @Basic
	public void setYear(String arg0) {
		// TODO Auto-generated method stub
		super.setYear(arg0);
	}

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getIdID3Tag() {
		return idID3Tag;
	}

	public void setIdID3Tag(long idID3Tag) {
		this.idID3Tag = idID3Tag;
	}

}
