package springidol.annotation;

import org.springframework.stereotype.Component;

@Component("piano")
public class Piano implements Instrument {
	public Piano() {}

	public void play() {
		System.out.println("PLANK PLANK PLANK~~");
	}
}
