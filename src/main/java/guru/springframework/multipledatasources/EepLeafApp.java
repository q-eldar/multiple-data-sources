package guru.springframework.multipledatasources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class EepLeafApp {

    public static void main(String[] args) {
        SpringApplication.run(EepLeafApp.class, args);
    }

}
