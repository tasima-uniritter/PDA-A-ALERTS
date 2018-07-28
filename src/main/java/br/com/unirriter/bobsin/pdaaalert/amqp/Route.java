package br.com.unirriter.bobsin.pdaaalert.amqp;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Route extends SpringRouteBuilder {

	private static final String AMQP_QUEUE = "amqp:queue";
	private static final String QUEUE_TEST = "test";
	private static final String QUEUE_PROD = "a-monitor-alerts";

	@Value("${queue.prod}")
	private boolean isProd;
			
    @Override
    public void configure() {
    	String queue = isProd ? QUEUE_PROD : QUEUE_TEST;
    	
        onException(Exception.class)
                .handled(false)
                .log(LoggingLevel.ERROR, "Error in processing route!");

        from(AMQP_QUEUE + queue)
                .setHeader(Exchange.CONTENT_TYPE, constant("application/octet-stream"))
                .setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http4.HttpMethods.POST))
                .log("Content ${body}")
                .to("http4://localhost:8080/pda-a-alert/alerts/sendAlert");
    }
}