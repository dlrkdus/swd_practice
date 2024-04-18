package springidol.javaconf4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springidol.*;

@Configuration
@Import(SpringConfSub.class)			// SpringConfSub 클래스에 설정된 bean 들을 import
public class SpringConfMain {
	//Performers
	@Autowired
	private PoeticJuggler duke;			// PoeticJuggler 타입 객체가 자동 주입됨
	@Autowired
	private Instrumentalist instr;		// Instrumentalist 타입 객체가 자동 주입됨
	@Autowired
	private OneManBand hank;			// OneManBand 타입 객체가 자동 주입됨
	@Autowired
	private Singer lena;
	@Autowired
	private Singer suhyun;
	
	@Bean
	public SpringIdol springIdol() {
		Performer[] performers = new Performer[] {duke, instr, hank, lena, suhyun};
		return new SpringIdol(performers);
	}

	//Encore
	@Bean
	public Encore encore() {
		Encore encore = new Encore();
		encore.setEncorePerformer(duke);
		return encore;
	}
}