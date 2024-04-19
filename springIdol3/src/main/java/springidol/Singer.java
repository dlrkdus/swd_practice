package springidol;

import org.springframework.beans.factory.BeanNameAware;

public class Singer implements Performer, BeanNameAware {
	private String name;
	private Song song;

	private String beanName;

	@Override
	public void setBeanName(String beanName){
		this.beanName=beanName;
	}

	@Override
	public String getBeanName(){
		return beanName;
	}

	public Singer() {
	}

	public Singer(String name) {
		this.name = name;
	}

	public Singer(String name, Song song) {
		this.song = song;
		this.name = name;
	}
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println(this.name + " is singing a song \"" + this.song.getTitle() + "\""
							+ " by " + this.song.getArtist());
	}
}
