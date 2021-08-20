package onlinerBy.sell;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import onlinerBy.base.BaseApartments;

public class SellApartments extends BaseApartments {

    @JsonProperty("apartments")
    private List<SellApartment> apartments = null;

    @JsonProperty("apartments")
    public List<SellApartment> getApartments() {
        return apartments;
    }

    @JsonProperty("apartments")
    public void setApartments(List<SellApartment> apartments) {
        this.apartments = apartments;
    }



}