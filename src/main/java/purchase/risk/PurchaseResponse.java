package purchase.risk;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PurchaseResponse {

    private boolean accepted;
    private String reason;

    public PurchaseResponse() {
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
