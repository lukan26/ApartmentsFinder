package onlinerBy.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "BYN",
        "USD"
})
public class Converted {

    @JsonProperty("BYN")
    private BYN bYN;
    @JsonProperty("USD")
    private USD uSD;

    @JsonProperty("BYN")
    public BYN getBYN() {
        return bYN;
    }

    @JsonProperty("BYN")
    public void setBYN(BYN bYN) {
        this.bYN = bYN;
    }

    @JsonProperty("USD")
    public USD getUSD() {
        return uSD;
    }

    @JsonProperty("USD")
    public void setUSD(USD uSD) {
        this.uSD = uSD;
    }

}