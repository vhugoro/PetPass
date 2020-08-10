package br.com.fiap.PetPass.utils;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import br.com.fiap.PetPass.config.ConfigRabbit;
import br.com.fiap.PetPass.dto.ClienteDTO;

public class MessageRabbit {
    public void geraCobranca(ClienteDTO clienteDTO) {
        //Set up queue, exchanges and bindings
        RabbitAdmin admin = new RabbitAdmin(ConfigRabbit.getConnection());

        Queue queue = new Queue("queueCobranca");
        admin.declareQueue(queue);

        TopicExchange exchange = new TopicExchange("myExchange");
        admin.declareExchange(exchange);
        admin.declareBinding(BindingBuilder.bind(queue).to(exchange).with("foo.*"));

        RabbitTemplate template = new RabbitTemplate(ConfigRabbit.getConnection());
        template.convertAndSend("myExchange"
                               ,"foo.bar"
                               ,"Cliente: " + clienteDTO.getId() + " | Plano:" + clienteDTO.getPlano());
    }
}
