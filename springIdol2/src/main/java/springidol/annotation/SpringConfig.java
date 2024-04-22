package springidol.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "springidol.annotation")
public class SpringConfig {
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