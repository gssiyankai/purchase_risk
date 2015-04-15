package purchase.risk;


import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import org.junit.Test;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.fest.assertions.api.Assertions.assertThat;
import static purchase.risk.PurchaseController.REASON_OK;
import static purchase.risk.TestHelper.newPurchaseRequest;

public class DecisionServiceTest extends JerseyTest {

     public DecisionServiceTest()throws Exception {
          super("purchase.risk");
     }

     @Test public void
     it_should_assess_risk_of_a_purchase() {
          WebResource resource = resource();
          PurchaseResponse response = resource.path("decisions")
                  .type(APPLICATION_JSON)
                  .accept(APPLICATION_JSON)
                  .post(PurchaseResponse.class, newPurchaseRequest(10));
          assertThat(response.isAccepted()).isTrue();
          assertThat(response.getReason()).isEqualTo(REASON_OK);
     }

}
