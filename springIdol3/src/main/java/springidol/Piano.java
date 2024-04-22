package springidol;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Piano implements Instrument {
	@Value("${piano.sound}")
	String sound;
	public Piano() {
	}
	@PostConstruct 
	public void tuneInstrument(){ //Piano bean 생성 직후 실행
		System.out.println("SpringIdol#tunePiano(): 피아노를 조율함");
	}
	
	@Override
	public void play() {
		System.out.println(sound);
	}
	@PreDestroy
	public void cleanInstrument(){ //Piano bean 삭제되기 직전 실행
		System.out.println("SpringIdol#cleanPiano(): 피아노를 청소함");
	}
	
	//PostConstruct, PostDestroy 어노테이션이 붙은 메소드들은 실행하지 않아도 자동 실행됨
}
