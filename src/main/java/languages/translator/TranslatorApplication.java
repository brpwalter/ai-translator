package languages.translator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TranslatorApplication {
    public static void main(String[] args) {
        // Startet den eingebetteten Tomcat-Server (Standardport 8080)
        SpringApplication.run(TranslatorApplication.class, args);
    }
}
 