package purchase.risk;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PurchaseRequest {

    private String email;
    private String first_name;
    private String last_name;
    private int amount;

    public PurchaseRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
