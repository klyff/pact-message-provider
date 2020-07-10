package br.zup.dtp.pact.message.kafka.producer;


import au.com.dius.pact.core.model.Interaction;
import au.com.dius.pact.core.model.Pact;
import au.com.dius.pact.provider.PactVerifyProvider;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit5.AmpqTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

@Slf4j
@Provider("ClientCreationMessageProvider")
@PactBroker(host = "localhost", port = "80")
public class KafkaContractAsyncTest {


   @TestTemplate
   @ExtendWith(PactVerificationInvocationContextProvider.class)
   void testTemplateInteraction(Pact pact, Interaction interaction, PactVerificationContext context) {
      log.info("TestTemplate called: " + pact.getProvider().getName() + ", " + interaction);
      context.verifyInteraction();
   }

   @BeforeEach
   void before(PactVerificationContext context) {
      System.setProperty("pact.verifier.publishResults", "true");
      context.setTarget(new AmpqTestTarget());
   }

   @State("ClientProviderState")
   public void someProviderState() {
      log.info("ClientProviderState CallBack Json");
   }

   @State("ClientProviderState2")
   public void someProviderState2() {
      log.info("ClientProviderState CallBack Map");
   }


   @PactVerifyProvider("Client Created Message")
   public String verifyMessageForClientCreation() {
      final String body = "{\"name\":\"KLYFF HARLLEY TOLEDO\",\"id\":\"1001\",\"type\":\"user\"}".trim();
      return body;
   }

   @PactVerifyProvider("ClientProviderState CallBack Json")
   public String verifyMessageForClientCreationJson() {
      final String body = "{\"name\":\"KLYFF HARLLEY TOLEDO\",\"id\":\"1001\",\"type\":\"user\"}".trim();
      return body;
   }

   @PactVerifyProvider("ClientProviderState CallBack Map")
   public String verifyMessageForClientCreationMap() {
      final String body = "{\"name\":\"KLYFF HARLLEY TOLEDO\",\"id\":\"1001\",\"type\":\"user\"}".trim();
      return body;
   }

}