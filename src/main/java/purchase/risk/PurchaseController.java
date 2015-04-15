package purchase.risk;

import java.util.HashMap;
import java.util.Map;

public class PurchaseController {

    public static final int MAX_VALID_AMOUNT = 1000;
    public static final int MIN_VALID_AMOUNT = 0;
    public static final String REASON_AMOUNT = "amount";
    public static final String REASON_DEBT = "debt";
    public static final String REASON_OK = "ok";


    private Map<String, Integer> purchases = new HashMap<>();

    public PurchaseResponse process(PurchaseRequest request) {
        final PurchaseResponse response = new PurchaseResponse();
        if(!isCurrentPurchaseValid(request)) {
            response.setAccepted(false);
            response.setReason(REASON_AMOUNT);
        } else if(isBuyerInDebt(request)) {
            response.setAccepted(false);
            response.setReason(REASON_DEBT);
        } else {
            updateBuyerPurchases(request);
            response.setAccepted(true);
            response.setReason(REASON_OK);
        }
        return response;
    }

    private boolean isCurrentPurchaseValid(PurchaseRequest request) {
        final int amount = request.getAmount();
        return amount >= MIN_VALID_AMOUNT && amount <= MAX_VALID_AMOUNT;
    }

    private boolean isBuyerInDebt(PurchaseRequest request) {
        final Integer currentAmount = purchases.get(request.getEmail());
        final int requestAmount = request.getAmount();
        return currentAmount!=null && currentAmount + requestAmount > MAX_VALID_AMOUNT;
    }

    private void updateBuyerPurchases(PurchaseRequest request) {
        final String buyerEMail = request.getEmail();
        final int requestAmount = request.getAmount();
        Integer currentAmount = purchases.get(buyerEMail);
        if(currentAmount==null) {
            currentAmount = 0;
        }
        purchases.put(buyerEMail, currentAmount + requestAmount);
    }

}
