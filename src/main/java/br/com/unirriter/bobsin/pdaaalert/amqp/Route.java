package br.com.unirriter.bobsin.pdaaalert.amqp;

import org.apache.camel.LoggingLevel;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Route extends SpringRouteBuilder {

    @Override
    public void configure() {

        onException(Exception.class)
                .handled(false)
                .log(LoggingLevel.ERROR, "Error in processing route!");

        from("amqp:queue:test")
                .log("message received");
    }
}