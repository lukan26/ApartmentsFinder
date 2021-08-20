package onlinerBy.rent;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {

    @JsonProperty("owner")
    private Boolean owner;

    @JsonProperty("owner")
    public Boolean getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(Boolean owner) {
        this.owner = owner;
    }

}