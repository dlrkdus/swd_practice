package springidol.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("duke")

public class PoeticJuggler extends Juggler {
	@Autowired
	private Poem poem;
	public PoeticJuggler(){}

	public PoeticJuggler(Poem poem) {
		super();
		this.poem = poem;
	}


	public PoeticJuggler(@Value("3") int beanBags, @Qualifier("sonnet29") Poem poem) {
		super(beanBags);
		this.poem = poem;
	}

	@Override
	public void perform() throws PerformanceException {
		super.perform();
		System.out.println("While reciting...");
		poem.recite();
	}
}
