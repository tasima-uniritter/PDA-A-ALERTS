package br.com.unirriter.bobsin.pdaaalert.amqp;

import org.apache.camel.Exchange;
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
                .setHeader(Exchange.CONTENT_TYPE, constant("application/octet-stream"))
                .setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http4.HttpMethods.POST))
                .log("Content ${body}")
                .to("http4://localhost:8080/pda-a-alert/alerts/sendAlert");
    }
}