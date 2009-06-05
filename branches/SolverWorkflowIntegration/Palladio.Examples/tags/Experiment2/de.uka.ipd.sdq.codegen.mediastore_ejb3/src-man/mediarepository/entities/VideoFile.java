package mediarepository.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class VideoFile extends MediaFile {
	@Basic
	private String movieTitle = null;

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
}
