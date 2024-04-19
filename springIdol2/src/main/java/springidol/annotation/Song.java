package springidol.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("someone")
public class Song {
	private String title;
	private String artist;

	public Song() {
	}

	public Song( String title, String artist){
		this.title=title;
		this.artist=artist;
	}
	@Value("Someone like you")
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	@Value("Adele")
	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
}
