package onlinerBy.rent;

import com.fasterxml.jackson.annotation.JsonProperty;
import onlinerBy.base.BaseApartments;

import java.util.List;

public class RentApartments extends BaseApartments {

    @JsonProperty("apartments")
    private List<RentApartment> apartments = null;

    @JsonProperty("apartments")
    public List<RentApartment> getApartments() {
        return apartments;
    }

    @JsonProperty("apartments")
    public void setApartments(List<RentApartment> apartments) {
        this.apartments = apartments;
    }

}