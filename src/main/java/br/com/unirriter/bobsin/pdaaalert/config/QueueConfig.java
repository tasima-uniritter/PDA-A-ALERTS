package br.com.unirriter.bobsin.pdaaalert.config;

import org.apache.camel.component.amqp.AMQPConnectionDetails;
import org.springframework.stereotype.Component;

/*
    Estabelece a configuração para acessar a fila AMQP na Amazon.
    Importante: não comitar o usuário e senha em AMQP_SERVICE_USERNAME e AMQP_SERVICE_PASSWORD. Deverá passar os parâmetros
    System.getenv("user"); e System.getenv("pass"); que serão alimentados pelas variáveis do Heroku.
*/
@Component
public class QueueConfig {

    private static final String AMQP_SERVICE_HOST = "b-79e24b8a-cd93-48a3-b234-9d75e05e3def-1.mq.us-east-1.amazonaws.com";
    private static final String AMQP_SERVICE_PORT = "5671";
    private static final String AMQP_SERVICE_USERNAME = System.getenv("user");
    private static final String AMQP_SERVICE_PASSWORD = System.getenv("pass");

    public AMQPConnectionDetails securedAmqpConnection() {
        return new AMQPConnectionDetails("amqps://"+AMQP_SERVICE_HOST+":"+AMQP_SERVICE_PORT,
                AMQP_SERVICE_USERNAME, AMQP_SERVICE_PASSWORD);
    }

}