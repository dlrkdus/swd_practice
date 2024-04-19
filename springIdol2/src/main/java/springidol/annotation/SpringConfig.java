package springidol.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "springidol.annotation")
public class SpringConfig {
    @Bean(name="suhyun")
    public Singer singer(){
        Song song =new Song( @Value("lena") )
        return new Singer(name,song,@Value("#{piano}") instrument);
    }

    @Bean(name="pinkvenom")
    public Song song(){
        return new Song("Pink Venom","Black Pink");
    }
	
}