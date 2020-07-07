package br.zup.dtp.pact.message.utils;

import br.zup.dtp.pact.message.model.Client;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class MessageGenerator {

   int numberOfMessages;
   static int ID_START = 100;

   private MessageGenerator(int num) {
      this.numberOfMessages = num;
   }

   public static List<Client> names(int numberOfMessages){
      Faker faker = new Faker();
      ID_START++;

      List<Client> clients = new ArrayList<>();
      String name = faker.name().fullName();
      for(int i = 0; i <= numberOfMessages; i++) {
         clients.add(Client.builder().id(ID_START).name(name).type("user").build());
      }

      return clients;

   }

}


