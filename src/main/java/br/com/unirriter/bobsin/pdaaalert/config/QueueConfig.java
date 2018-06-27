package br.com.unirriter.bobsin.pdaaalert.config;

import org.apache.camel.component.amqp.AMQPConnectionDetails;
import org.springframework.stereotype.Component;

@Component
public class QueueConfig {

    private static final String AMQP_SERVICE_HOST = "b-79e24b8a-cd93-48a3-b234-9d75e05e3def-1.mq.us-east-1.amazonaws.com";
    private static final String AMQP_SERVICE_PORT = "5671";
    private static final String AMQP_SERVICE_USERNAME = System.getenv("AMQPUSER");
    private static final String AMQP_SERVICE_PASSWORD = System.getenv("AMQPPASS");

    public AMQPConnectionDetails securedAmqpConnection() {
        return new AMQPConnectionDetails("amqps://"+AMQP_SERVICE_HOST+":"+AMQP_SERVICE_PORT,
                AMQP_SERVICE_USERNAME, AMQP_SERVICE_PASSWORD);
    }

}