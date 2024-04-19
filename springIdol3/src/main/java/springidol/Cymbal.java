package springidol;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cymbal implements Instrument {
	@Value("${cymbal.sound}")
	String sound;
	public Cymbal() {
	}
	
	public void play() {
		System.out.println(sound);
	}
}
