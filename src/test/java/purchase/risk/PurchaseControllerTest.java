package purchase.risk;


import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static purchase.risk.PurchaseController.*;

public class PurchaseControllerTest {

     private PurchaseController controller;

     @Before
     public void setup() {
          controller = new PurchaseController();
     }

     @Test public void
     if_the_amount_is_less_than_10_it_should_always_be_accepted() {
          PurchaseResponse response = controller.process(newPurchaseRequest(1));
          assertThat(response.isAccepted()).isTrue();
          assertThat(response.getReason()).isEqualTo(REASON_OK);
     }

     @Test public void
     if_the_amount_is_higher_than_1000_it_should_always_be_rejected_with_the_reason_amount() {
          PurchaseResponse response = controller.process(newPurchaseRequest(1001));
          assertThat(response.isAccepted()).isFalse();
          assertThat(response.getReason()).isEqualTo(REASON_AMOUNT);
     }

     @Test public void
     if_the_amount_is_negative_it_should_always_be_rejected_with_the_reason_amount() {
          PurchaseResponse response = controller.process(newPurchaseRequest(-1));
          assertThat(response.isAccepted()).isFalse();
          assertThat(response.getReason()).isEqualTo(REASON_AMOUNT);
     }

     @Test public void
     if_the_sum_of_purchases_from_a_particular_email_is_larger_than_1000_including_current_purchase_it_should_be_rejected_with_reason_debt() {
          controller.process(newPurchaseRequest(500));
          PurchaseResponse response = controller.process(newPurchaseRequest(600));
          assertThat(response.isAccepted()).isFalse();
          assertThat(response.getReason()).isEqualTo(REASON_DEBT);
     }

     static PurchaseRequest newPurchaseRequest(int amount) {
          PurchaseRequest request = new PurchaseRequest();
          request.setEmail("john@doe");
          request.setFirst_name("John");
          request.setLast_name("Doe");
          request.setAmount(amount);
          return request;
     }

}
