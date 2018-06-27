package br.com.unirriter.bobsin.pdaaalert.amq;

import br.com.unirriter.bobsin.pdaaalert.config.QueueConfig;
import org.apache.camel.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Receiver implements CommandLineRunner {

    private QueueConfig queueConfig;

    public Receiver(QueueConfig queueConfig) {
        this.queueConfig = queueConfig;
    }

    @Override
    public void run(String... args) throws Exception {
        Main main = new Main();
        main.bind("amqp", queueConfig.securedAmqpConnection());
        main.addRouteBuilder(new Route());
        main.run(args);
    }
}