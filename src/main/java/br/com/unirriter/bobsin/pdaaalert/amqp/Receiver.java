package br.com.unirriter.bobsin.pdaaalert.amqp;

import br.com.unirriter.bobsin.pdaaalert.config.QueueConfig;
import org.apache.camel.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
    Cria uma nova conexão com a fila no AMQP, utilizando a configuração estabelecida no arquivo QueueConfig
*/

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