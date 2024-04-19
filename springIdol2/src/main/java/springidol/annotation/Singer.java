package springidol.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("lena")
public class Singer implements Performer {
	public String name;
	public Song song;
	@Autowired
	@Qualifier("piano")
	public Instrument instrument;
	
	public Singer() {}
	public Singer( @Value("Lena Kim") String name, @Autowired @Qualifier("someone") Song song) {
		this.name = name;
		this.song = song;
	}
	@Autowired
	public Singer(String name, Song song, Instrument instr) {
		this.name = name;
		this.song = song;
		this.instrument = instr;
	}
	
	public Song getSong() {
		return song;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.println(name + " is singing a song \"" + song.getTitle() 
								+ "\" by " + song.getArtist());
		if (this.instrument != null) {
			System.out.print("while playing " + instrument.getClass().getSimpleName() + " ");
			instrument.play();
		}
	}
}
