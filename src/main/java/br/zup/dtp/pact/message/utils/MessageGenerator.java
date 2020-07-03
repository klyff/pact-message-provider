package br.zup.dtp.pact.message.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class MessageGenerator implements Runnable {

   int numberOfMessages;

   private MessageGenerator(int num) {
      this.numberOfMessages = num;
   }

   @Override
   public void run() {
      log.info("Starting Message Generator for "+numberOfMessages);
      //...

      log.info("Finished Message Generator for "+numberOfMessages);
   }
}


