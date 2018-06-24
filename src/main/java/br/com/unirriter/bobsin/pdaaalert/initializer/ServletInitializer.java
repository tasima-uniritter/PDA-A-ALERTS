package br.com.unirriter.bobsin.pdaaalert.initializer;

import br.com.unirriter.bobsin.pdaaalert.pdaAlertApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(pdaAlertApplication.class);
    }

}
