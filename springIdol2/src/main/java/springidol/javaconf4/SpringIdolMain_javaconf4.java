package springidol.javaconf4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import springidol.Encore;
import springidol.TalentCompetition;

public class SpringIdolMain_javaconf4 {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new AnnotationConfigApplicationContext(SpringConfMain.class);

		TalentCompetition competition = ctx.getBean("springIdol", TalentCompetition.class);
		Encore encore=ctx.getBean("encore", Encore.class);
		competition.run();
		encore.execute();
		ctx.close();
	}
}
