package springidol.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Encore {
	private Performer encorePerformer;

	@Autowired
	public void setEncorePerformer(Performer perfomer) {
		this.encorePerformer = perfomer;
	}

	public void execute() {
		System.out.println("Encore Performance");
		encorePerformer.perform();
	}
}
