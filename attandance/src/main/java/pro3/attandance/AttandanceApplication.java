package pro3.attandance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import pro3.attandance.utils.DayGenerator;

@SpringBootApplication
@EnableCaching
public class AttandanceApplication extends SpringBootServletInitializer {

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(AttandanceApplication.class);
//    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AttandanceApplication.class, args);
    }
}

