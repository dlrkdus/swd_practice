package springidol.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "springidol.annotation")
public class SpringConfig {
    // Bean 클래스로 정의해놓은 bean 들이지만 Config 에서 Bean 을 정의할 때 참조하기 위해 의존성 주입 받음.
    @Autowired
    private Singer lena;
    @Autowired
    private Piano piano;

    @Bean
    public Singer singer(){
        Singer singer=new Singer();
        singer.setName("suhyun");
        singer.setSong(lena.song);
        singer.setInstrument(piano);
        return singer;
    }

    @Bean(name="pinkvenom")
    public Song song(){
        return new Song("Pink Venom","Black Pink");
    }
	
}