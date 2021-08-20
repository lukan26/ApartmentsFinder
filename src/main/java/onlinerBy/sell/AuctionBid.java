package onlinerBy.sell;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuctionBid {

    @JsonProperty("amount")
    private String amount;
    @JsonProperty("currency")
    private String currency;

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}