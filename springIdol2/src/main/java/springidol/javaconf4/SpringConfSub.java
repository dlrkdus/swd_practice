package springidol.javaconf4;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springidol.*;

@Configuration
public class SpringConfSub {
	
	@Bean
	public Saxophone saxophone() {	  	// method 이름을 bean의 ID로 사용 ("saxophone") 
		return new Saxophone();			// Saxophone type bean 생성  
	}
	@Bean
	public Piano piano() {	    
		return new Piano();		
	}
	@Bean
	public Harmonica harmonica() {return new Harmonica();}
	@Bean
	public Cymbal cymbal() {return new Cymbal();}
	@Bean
	public Guitar guitar() {return new Guitar();}
	@Bean
	public Poem sonnet29() {
		return new Sonnet29();
	}
	
	@Bean
	public PoeticJuggler juggler() {
		return new PoeticJuggler(5, sonnet29());
	}
	
	@Bean(name="kenny")				// name 속성을 통해 bean ID 지정 가능 
	public Instrumentalist instr() {
		return new Instrumentalist("Jingle Bells",guitar());
	} 
	
	@Bean		
	public OneManBand hank() {
		Map<String, Instrument> instrMap = new HashMap<String, Instrument>();
		instrMap.put("SAXOPHONE", saxophone());
		instrMap.put("PIANO", piano());
		instrMap.put("HARMONICA",harmonica());
		OneManBand omb = new OneManBand();		
		omb.setInstruments(instrMap);
		return omb;
	}
	//Song
	@Bean(name="someone")
	public Song song1(){return new Song("Someone Like You","Adele");}
	@Bean(name="pinkvenom")
	public Song song2(){return new Song("Pink Venom","Black Pink");}

	//Singers(Performers)
	@Bean(name="lena")
	public Singer lena(){return new Singer("Lena Kim",song1());}
	@Bean(name="suhyun")
	public Singer suhyun(){return new Singer("Suhyun",lena().getSong(),piano());}
}