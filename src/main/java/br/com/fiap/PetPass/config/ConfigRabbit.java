package br.com.fiap.PetPass.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;

public class ConfigRabbit {

    private static CachingConnectionFactory connectionFactory;

    public static CachingConnectionFactory getConnection() {
        if (connectionFactory == null) {
            connectionFactory = new CachingConnectionFactory("cat.rmq.cloudamqp.com");
            connectionFactory.setUsername("smhztxlb");
            connectionFactory.setPassword("m3L5-0tUjxeVQfZJBgsLaBBkTTwe3o1S");
            connectionFactory.setVirtualHost("smhztxlb");

            //Recommended settings
            connectionFactory.setRequestedHeartBeat(30);
            connectionFactory.setConnectionTimeout(30000);
        }

        return connectionFactory;
    }
}
