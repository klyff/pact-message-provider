package br.zup.dtp.pact.message.kafka.producer;

import br.zup.dtp.pact.message.model.Client;
import br.zup.dtp.pact.message.utils.MessageGenerator;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class SendMessage {

   private MessageClientKafkaProducer messageClientKafkaProducer;

   public SendMessage(MessageClientKafkaProducer messageClientKafkaProducer) {
      this.messageClientKafkaProducer = messageClientKafkaProducer;
   }

   @PostConstruct
   public void sendMessage() {
      List<Client> clients = MessageGenerator.names(5);

      clients.stream().forEach(messageClientKafkaProducer::sendMessageClientCreation);
   }
}
