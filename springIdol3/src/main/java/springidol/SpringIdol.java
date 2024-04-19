package springidol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SpringIdol implements TalentCompetition {
	@Autowired
	private Performer[] performers;

	public int stageSize;
	@Autowired
	private Piano piano; //Auto-wiring DI
	
	public SpringIdol() {}
	
	public Performer[] getPerformers() {
		return this.performers;
	}

	public void setPerformers(Performer[] performers) {
		this.performers = performers;
	}
	@Autowired
	public void setStageSize(@Value("${springIdol.stage.size}") int size){ //Setter-based DI
		this.stageSize=size;
		System.out.println("SpringIdol#setStageSize(): 무대 크기를 " + stageSize + "으로 설정");
	}

	@PostConstruct
	public void tunePiano(){
		piano.tuneInstrument();
	}

	@PreDestroy
	public void cleanPiano(){
		piano.cleanInstrument();
	}

	@Override
	public void run() {
		for (int i = 0; i < performers.length; i++) {
			System.out.print("Performance #" + (i+1));
			Performer performer = performers[i];
			if (performer.getBeanName() != null)
				System.out.print(" by " + performer.getBeanName());
			System.out.println();
			performer.perform();
			System.out.println("-----------------------");
		}
	}
}
