package springidol;

import org.springframework.beans.factory.BeanNameAware;

public class PoeticJuggler extends Juggler implements BeanNameAware {
	private Poem poem;
	private String beanName;

	public PoeticJuggler() { }

	public void setBeanName(String beanName){
		this.beanName=beanName;
	}
	public String getBeanName(){
		return beanName;
	}

	public PoeticJuggler(Poem poem) {
		super();
		this.poem = poem;
	}

	public PoeticJuggler(int beanBags, Poem poem) {
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
