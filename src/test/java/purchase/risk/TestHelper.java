package purchase.risk;


class TestHelper {

    static PurchaseRequest newPurchaseRequest(int amount) {
        PurchaseRequest request = new PurchaseRequest();
        request.setEmail("john@doe");
        request.setFirst_name("John");
        request.setLast_name("Doe");
        request.setAmount(amount);
        return request;
    }

}
